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

    $scope.total = 0;
    $scope.itemsPedidos = [];

	$scope.cargarProductos = function(){
	    $http.get('http://localhost:8080/Pizzeria-Backend/rest/productos/listar').success(function (data) {
	          $scope.productos = data;
	      });
	  }

	$scope.AgregarALaCuenta = function(producto, cantidad){
		$http.post('http://localhost:8080/Pizzeria-Backend/rest/productos/productoToItemPedido/' + producto.id + '/' + cantidad).success(function (itemPedido) {
			if(!estaAgregadoElProducto(producto, cantidad)){
				$scope.itemsPedidos.push(itemPedido);
				$scope.total += itemPedido.objetoCompra.precio * cantidad;
			}
		});
	}

	function estaAgregadoElProducto(producto, cantidad){
		for (var i = 0; i < $scope.itemsPedidos.length; i++) {
	        if ($scope.itemsPedidos[i].objetoCompra.id == producto.id) {
	        	$scope.itemsPedidos[i].cantidad += cantidad; 
	        	$scope.total += cantidad * $scope.itemsPedidos[i].objetoCompra.precio;
	            return true;
	        }
	    }
	    return false;
	}

	$scope.cargarProductos();

  });
