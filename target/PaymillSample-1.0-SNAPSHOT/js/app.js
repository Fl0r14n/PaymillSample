'use strict';

var app = angular.module('app', ['controller', 'service', 'directive', 'ui.bootstrap', 'ngAnimate', 'ngRoute'])

app.config(['$resourceProvider', function ($resourceProvider) {
    //!do not remove tailing / from urls
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);
