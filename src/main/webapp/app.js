'use strict';

var ScrumStoryApp = angular.module('ScrumStoryApp', [
    'ngRoute',
    'project'
]);

ScrumStoryApp.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/home', {
        templateUrl: 'home/home.html'
//        controller: HomeController
    });

    $routeProvider.when('/projects', {
        templateUrl: 'project/projectList.html',
        controller: 'ProjectList'
    });

    $routeProvider.when('/project/new', {
        templateUrl: 'project/projectNew.html',
        controller: 'ProjectCreate'
    });

    $routeProvider.otherwise({redirectTo: '/home'});
}]);
