'use strict';
(function () {

    /** Controleurs des projets */
    var projectModule = angular.module('project.controllers', []);

    projectModule.controller('ProjectCreate', ['$scope', 'Project',
        function ($scope, Project) {

            $scope.create = function (project) {
                console.log('log');
                console.log(JSON.stringify(project));
                Project.save(project);
            }
        }]);

    projectModule.controller('ProjectList', ['$scope', 'Project',
        function ($scope, Project) {
            $scope.projects = Project.query();
        }]);

})();
