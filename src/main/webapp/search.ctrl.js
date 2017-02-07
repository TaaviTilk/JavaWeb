(function () {
    'use strict';

    angular.module('app').controller('SearchCtrl', Ctrl);

    function Ctrl($http, $location) {

    this.title = 'Hello';
    var vm = this;
    vm.customers = [];

//    vm.deletePost = deletePost;

    init();


    function init(){
        $http.get('http://localhost:8080/api/customers').then(function (result){
            vm.customers = result.data;
        });
    }


//    function deletePost(id){
//            $http.delete('http://localhost:8080/api/customers/'+id).then(function (result){
//
//               init();
//            });
//    }




    }

})();
