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
	
	$scope.crearProducto = function() {
       // $http.post('http://localhost:8080/Pizzeria-Backend/rest/productos/crear', {nombre: $scope.nombreProducto, precio: $scope.precioProducto}).success(function (data) {     			
		//})
		
        $http({
            method: 'POST',
            url: 'http://localhost:8080/Pizzeria-Backend/rest/productos/crear',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var p in obj)
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
            return str.join("&");
            },

            data: {nombre: $scope.nombreProducto, precio: $scope.precioProducto}

        }).success(function (data) {});
		
    }

	$scope.cargarProductos = function(){
		$http.get('http://localhost:8080/Pizzeria-Backend/rest/productos/listar').success(function (data) {
        	$scope.productos = data;
    	});
	}

	$scope.cargarProductos();

  });
