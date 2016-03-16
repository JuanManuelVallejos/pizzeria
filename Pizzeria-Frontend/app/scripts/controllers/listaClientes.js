'use strict';

/**
 * @ngdoc function
 * @name desktopApp.controller:ListaClientesCtrl
 * @description
 * # ListaClientesCtrl
 * Controller of the desktopApp
 */
 
 
angular.module('desktopApp').controller('ListaClientesCtrl', function () {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });

var listaClientesApp = angular.module('desktopApp');

listaClientesApp.controller('ListaClientesCtrl', function($scope, $http) {
	
	var cl = this;
	
	cl.listaClientes = function(){
		$http.get('http://localhost:8080/Pizzeria-Backend/rest/clientes/listar').success(function (data) {
            cl.clientes = data;
        });
	};

	cl.listaClientes();

});
 
 