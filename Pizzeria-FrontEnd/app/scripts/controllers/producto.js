'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:ProductoCtrl
 * @description
 * # ProductoCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('ProductoCtrl', function ($scope, $http) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

	this.cargarProductos = function(){
		$http.get('http://localhost:8080/Pizzeria-Backend/rest/productos/listar').success(function (data) {
        	$scope.productos = data;
    	});
	}

	this.cargarProductos();

  });
