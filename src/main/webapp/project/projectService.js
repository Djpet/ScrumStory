'use strict';
(function () {

    /**
     * Service contenant les méthodes de gestion des projets.
     */
    var projectModule = angular.module('project.services', ['ngResource']);

    projectModule.factory('Project', ['$resource',
        function ($resource) {
            return $resource('api/project/:projectCode', {}, {
                // query: {method:'GET', params:{projectCode:'code'}, isArray:true}
            });
        }]);
})();