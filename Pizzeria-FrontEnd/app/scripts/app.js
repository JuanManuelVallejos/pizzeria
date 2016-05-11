'use strict';

/**
 * @ngdoc overview
 * @name pizzeriaFrontEndApp
 * @description
 * # pizzeriaFrontEndApp
 *
 * Main module of the application.
 */

var app = angular
  .module('pizzeriaFrontEndApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ]);
  app.config(function ($routeProvider) {
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
        templateUrl: 'views/pedido2.html',
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
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
      })
	  .when('/nuevocliente', {
        templateUrl: 'views/nuevocliente.html',
        controller: 'NuevoClienteCtrl',
        controllerAs: 'nuevocliente'
      })
      .otherwise({
        redirectTo: '/'
      });
  });


  app.controller('AppCtrl', function($scope, $http) {
  
  }).directive('dirNuevopedido', function ($http){
    return {
      restrict: 'E',
      templateUrl: '/views/hacerpedido.html',
    };
  }).directive('dirPedidosrealizados', function ($http){
    return {
      restrict: 'E',
      templateUrl: '/views/pedidosRealizados.html',
    };
  }).directive('dirPedirpromocion', function ($http){
    return {
      restrict: 'E',
      templateUrl: '/views/pedirPromocion.html',
    };
  }).directive('dirPendientesadmin', function ($http){
    return {
      restrict: 'E',
      templateUrl: '/views/pedidosPendientesAdmin.html',
    };
  });
