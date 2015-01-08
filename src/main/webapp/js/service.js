'use strict';

var services = angular.module('service', ['ngResource']);

services.api = 'api/v1/';

services.endpoint = function (resource) {
    return services.api + resource + '/';
}

services.factory('PaymentService', function ($resource) {
    var url = services.endpoint('payment');
    return {
        card: $resource(url, {}, {
            'charge': {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                }
            }
        })
    };
});


