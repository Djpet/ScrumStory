'use strict';

var ScrumStoryApp = angular.module('ScrumStoryApp', ['ngRoute']);

ScrumStoryApp.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/home', {
        templateUrl: 'templates/home.html'
//        controller: HomeController
    });

    $routeProvider.when('/project', {
        templateUrl: 'templates/project.html'
//        controller: TodoController
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);
