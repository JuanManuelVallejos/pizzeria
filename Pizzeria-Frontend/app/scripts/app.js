'use strict';

/**
 * @ngdoc overview
 * @name desktopApp
 * @description
 * # desktopApp
 *
 * Main module of the application.
 */
angular
  .module('desktopApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/producto', {
        templateUrl: 'views/producto.html',
        controller: 'ProductoCtrl',
        controllerAs: 'producto'
      })
	  .when('/cliente', {
        templateUrl: 'views/cliente.html',
        controller: 'ClienteCtrl',
        controllerAs: 'cliente'
      })
	  .when('/listaClientes', {
        templateUrl: 'views/listaClientes.html',
        controller: 'ListaClientesCtrl',
        controllerAs: 'listaClientes'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
