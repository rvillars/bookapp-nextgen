'use strict';

var bookapp = angular.module('bookapp', ['ui.bootstrap','ui.router','ngResource']);

bookapp.config(function config($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise('/books');
});

