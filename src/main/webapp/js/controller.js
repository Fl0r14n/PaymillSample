'use strict';

var controllers = angular.module('controller', []);

controllers.controller('PaymillController', ['$scope', '$window', 'dateFilter', 'PaymentService', function ($scope, $window, dateFilter, paymentService) {
        var self = this;
        
        self.numberElem = {
            show: true,
            readonly: false,
            invalid: false,
            
            value: undefined,
            validate: function() {
                if(angular.isUndefined(this.value)) {
                    this.invalid = true;
                } else {
                    this.invalid = !$window.paymill.validateCardNumber(this.value);
                }
            },
            cardType: function() {
                return $window.paymill.cardType(this.value);
            }
        };

        self.cvcElem = {
            show: true,
            readonly: false,
            invalid: false,
            
            value: undefined,
            validate: function() {
                if(angular.isUndefined(this.value)) {
                    this.invalid = true;
                }
                this.invalid = !$window.paymill.validateCvc(this.value);
            }
        };
        
        self.holderElem = {
            show: true,
            readonly: false,
            invalid: false,
            
            value: undefined,
            validate: function() {
                //TODO some name validation
                this.invalid = false;
            }
        };

        self.expiryElem = {
            show: true,
            readonly: false,
            invalid: false,
            value: Date.now(),
            options: {
                datepickerMode: 'month'
            },
            opened: false,
            toogle: function ($event) {
                $event.preventDefault();
                $event.stopPropagation();
                this.opened = !this.opened;
            },
            dateString: function () {
                if(angular.isUndefined(this.value)) {
                    return '';
                }
                return dateFilter(this.value, 'MM/yyyy');
            },
            monthString: function() {
                var dateStr = this.dateString();              
                var slash = dateStr.indexOf('/');
                return dateStr.substring(0, slash);
            },
            yearString: function() {
                var dateStr = this.dateString();              
                var slash = dateStr.indexOf('/');
                return dateStr.substring(slash+1);
            },
            validate: function() {
                this.invalid = !$window.paymill.validateExpiry(this.monthString(), this.yearString());
            }
        };
        
        self.amountElem = {
            show: false,
            readonly: true,
            invalid: false,
            value: 0,
            validate: function() {  
                if(typeof this.value === 'number' && this.value > 0) {
                    this.invalid = false;
                } else {
                    this.invalid = true;
                }
            }
        };
        
        self.currencyElem = {
            show: false,
            readonly: true,
            invalid: false,
            value: 'EUR',
            validate: function() {
                if(typeof this.value === 'string' && this.value.length === 3) {
                    this.invalid = false;
                } else {
                    this.invalid = true;
                }
            }
        };
        
        self.errorElem = {
            show: false,
            readonly: true,
            value: ''
        };
        
        self.successElem = {
            show: false,
            readonly: true,
            value: ''
        };
        
        self.submit = function() {
            self.numberElem.validate();
            self.cvcElem.validate();
            self.holderElem.validate();
            self.expiryElem.validate();
            self.amountElem.validate();
            self.currencyElem.validate();
            var error = false;
            error = error || self.numberElem.invalid;
            error = error || self.cvcElem.invalid;
            error = error || self.holderElem.invalid;
            error = error || self.expiryElem.invalid;
            error = error || self.amountElem.invalid;
            error = error || self.currencyElem.invalid;
            if(!error) {                
                self.createPaymillToken();
            }
        };
        
        self.createPaymillToken = function() {
            $window.paymill.createToken({
               number: self.numberElem.value,
               exp_month: self.expiryElem.monthString(),
               exp_year: self.expiryElem.yearString(),
               cvc: self.cvcElem.value,
               amount_int: self.amountElem.value,
               currency: self.currencyElem.value,
               cardholder: self.holderElem.value
            }, self.paymillResonseHandler);
        };

        self.paymillResonseHandler = function(error, result) {
            console.log(error);
            console.log(result);
            if(error) {
                self.errorElem.value = error.message;
                self.errorElem.show = true;
                $scope.$apply();
            } else {
                self.executePayment(result.token);
            }
        };
        
        self.executePayment = function(token) {
            paymentService.card.charge({
                'token':token
            }, function(data) {
                console.log(data);
                if(data.successful) {
                    self.successElem.value = data.message;
                    self.successElem.show = true;
                } else {
                    self.errorElem.value = data.message;
                    self.errorElem.show = true;
                }
            });
        };
    }
]);

controllers.controller('PaymentController', ['$scope', function ($scope) {

    }
]);