'use strict';

var directives = angular.module('directive', []);

directives.directive('uiAlert', function() {
    return {
        replace: true,
        restrict: 'E',
        scope: {
            type : '@',
            showClose : '@',
            boolVariable : '='
        },
        transclude: true,
        link: function(scope, element, attrs) {
            scope.closeAlert = function() {
                scope.boolVariable = false;
            }
        },
        template: [
            '<div class="ui-alert alert alert-{{type}}" ng-show="boolVariable">',
                '<a class="close" ng-if="showClose" ng-click="closeAlert()">&times;</a>',
                '<ng-transclude></ng-transclude>',
            '</div>'
        ].join('')
    }
});
