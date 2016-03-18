'use strict';

/**
 * @ngdoc overview
 * @name pizzeriaFrontEndApp
 * @description
 * # pizzeriaFrontEndApp
 *
 * Main module of the application.
 */
angular
  .module('pizzeriaFrontEndApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/producto', {
        templateUrl: 'views/producto.html',
        controller: 'ProductoCtrl',
        controllerAs: 'producto'
      })
      .when('/administrador', {
        templateUrl: 'views/administrador.html',
        controller: 'AdministradorCtrl',
        controllerAs: 'administrador'
      })
      .when('/pedido', {
        templateUrl: 'views/pedido.html',
        controller: 'PedidoCtrl',
        controllerAs: 'pedido'
      })
      .when('/promocion', {
        templateUrl: 'views/promocion.html',
        controller: 'PromocionCtrl',
        controllerAs: 'promocion'
      })
      .when('/objetocompra', {
        templateUrl: 'views/objetocompra.html',
        controller: 'ObjetocompraCtrl',
        controllerAs: 'objetocompra'
      })
      .when('/itempedido', {
        templateUrl: 'views/itempedido.html',
        controller: 'ItempedidoCtrl',
        controllerAs: 'itempedido'
      })
      .when('/cliente', {
        templateUrl: 'views/cliente.html',
        controller: 'ClienteCtrl',
        controllerAs: 'cliente'
      })
      .otherwise({
        redirectTo: '/'
      });
  }).controller('AppCtrl', function($scope, $http) {
  
      

  });
