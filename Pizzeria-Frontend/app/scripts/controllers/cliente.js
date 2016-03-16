'use strict';

/**
 * @ngdoc function
 * @name desktopApp.controller:ClienteCtrl
 * @description
 * # ClienteCtrl
 * Controller of the desktopApp
 */


angular.module('desktopApp').controller('ClienteCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });

var clienteApp = angular.module('desktopApp');

clienteApp.controller('ClienteCtrl', function($scope, $http) {
	
	var cl = this;
	var dominio = 'http://localhost:8080/Pizzeria-Backend/rest';	
	var urlCliente = '/clientes';

	$scope.crearCliente = function(){
		$http.post(dominio + urlCliente + '/crear/'+ $scope.nombre + '/' + $scope.apellido + '/' + $scope.direccion + '/' + $scope.dni + '/' + $scope.nroDeCliente).success(function (data) {
            alert('El cliente se dio de alta correctamente');
        }).error(function(data,status) {
            alert('No se pudo dar de alta al cliente, Error='+status);
        });
    };
	
	$scope.cancelar = function() {
        location = '#/';
    };

});