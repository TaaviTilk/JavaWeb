(function () {
    'use strict';

    angular.module('app').config(Conf);

    function Conf($routeProvider){

    $routeProvider.when('/search',{
         templateUrl : 'search.html',
         controller : 'SearchCtrl',
         controllerAs : 'vm'
        }).when('/new',{
         templateUrl : 'new.html',
         controller : 'NewCtrl',
         controllerAs : 'vm'
        }).when('/edit/:id',{
         templateUrl : 'edit.html',
         controller : 'NewCtrl',
         controllerAs : 'vm'
        }).otherwise('/search');
    }

})();