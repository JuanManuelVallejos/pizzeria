'use strict';

/**
 * @ngdoc function
 * @name desktopApp.controller:ProductoCtrl
 * @description
 * # ProductoCtrl
 * Controller of the desktopApp
 */


angular.module('desktopApp').controller('ProductoCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });

var productoApp = angular.module('desktopApp');

productoApp.controller('ProductoCtrl', function($scope, $http) {
	
	var dominio = 'http://localhost:8080/Pizzeria-Backend/rest';	
	var urlProducto = '/productos';

	$scope.listaProductos = function(){
		$http.get(dominio + urlProducto + '/listar').success(function (data) {
            $scope.productos = data;
        });
	}

	$scope.crearProducto = function(){
		$http.post(dominio + urlProducto + '/crear/'+ $scope.nombre + '/' + $scope.precio).success(function (data) {
            alert('Se pudo crear el producto correctamente');
        }).error(function(data,status) {
            alert('No se pudo crear el producto, Error='+status);
        });
	}

});