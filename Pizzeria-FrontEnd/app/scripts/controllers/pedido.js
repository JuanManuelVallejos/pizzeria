'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:PedidoCtrl
 * @description
 * # PedidoCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('PedidoCtrl', function ($http, $scope) {
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

	$scope.realizarPedido = function(){
	    $http({
                method: 'POST',
                isArray: true,
                url: "http://localhost:8080/Pizzeria-Backend/rest/pedidos/realizar",
                data: { itemsPedido: $scope.itemsPedidos },
				  headers: {
				    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
				  }
            })
            .success(function(data) {
                alert("DATA  : " + data);
            }).error(function(data, status, headers, config) {
                alert("Could not save new person");
            });
	  }

	$scope.cargarProductos();

  });
