(function () {
    'use strict';

    angular.module('app').controller('NewCtrl', Ctrl);

    function Ctrl($http, $location, $routeParams) {

    var vm = this;

    vm.errors = [];
    vm.id = null;
    vm.firstName = null;
    vm.lastName = null;
    vm.eMail = null;
    vm.synniaeg = null;
    vm.aadress = null;
    vm.addNew = addNew;
    vm.deletePost = deletePost;



    if($routeParams.id !== undefined){
        $http.get('http://localhost:8080/api/customers/'+$routeParams.id).then(function (result){
            console.log($routeParams.id);
            vm.id = result.data.id;
            vm.firstName = result.data.firstName;
            vm.lastName = result.data.lastName;
            vm.eMail = result.data.eMail;
            vm.synniaeg = result.data.synniaeg;
            vm.aadress = result.data.aadress;

                });
        }

      function addNew(){
           var newPost = {
                           id : vm.id,
                           firstName : vm.firstName,
                           lastName : vm.lastName,
                           eMail : vm.eMail,
                           synniaeg : vm.synniaeg,
                           aadress : vm.aadress
                       };
            $http.post('http://localhost:8080/api/customers', newPost).then(function (result){
                console.log(result);
                $location.path('/search');

            }, errorHandler);
        }

       function errorHandler(response) {
            if (response.data.errors) {
                vm.errors = response.data.errors.map(function (error) {
                    return messageService.getMessage(error.code, error.arguments);
                });
            } else {
                console.log('Error: ' + JSON.stringify(response.data));
            }
        }

            function deletePost(id){
                    $http.delete('http://localhost:8080/api/customers/'+id).then(function (result){

                      $location.path('/search');
                    });
            }

    }

})();
