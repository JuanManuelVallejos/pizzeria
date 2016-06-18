'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:PedidoCtrl
 * @description
 * # PedidoCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('PedidoCtrl', function ($scope, $http) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

	$scope.cargarProductos = function(){
	    $http.get('http://localhost:8080/Pizzeria-Backend/rest/productos/listar').success(function (data) {
	          $scope.productos = data;
	      });
	  }

	$scope.AgregarALaCuenta = function(id, cantidad){
	  alert(id + " " + cantidad);
	}

	$scope.cargarProductos();

  });
