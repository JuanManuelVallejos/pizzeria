'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:NuevoClienteCtrl
 * @description
 * # NuevoClienteCtrl
 * Controller of the pizzeriaFrontEndApp
 */


angular.module('pizzeriaFrontEndApp').controller('NuevoClienteCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });

var clienteApp = angular.module('pizzeriaFrontEndApp');

clienteApp.controller('NuevoClienteCtrl', function($scope, $http) {
	
	var dominio = 'http://localhost:8080/Pizzeria-Backend/rest/clientes';	

	$scope.crearCliente = function(){
		$http.post(dominio + '/crear/'+ $scope.nombre + '/' + $scope.apellido + '/' + $scope.direccion + '/' + $scope.dni + '/' + $scope.nroDeCliente + '/' + $scope.password).success(function (data) {
            alert('El cliente se dio de alta correctamente');
        }).error(function(data,status) {
            alert('No se pudo dar de alta al cliente, Error='+status);
        });
    };
	
	$scope.cancelar = function() {
        location = '#/';
    };

});