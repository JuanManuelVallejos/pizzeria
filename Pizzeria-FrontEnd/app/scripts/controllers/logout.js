'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:LogoutCtrl
 * @description
 * # LogoutCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('LogoutCtrl', function ($scope, $location, $cookies) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.usrConectado = {usuario: "", password: "", estaConectado: ""};
    $cookies.remove("estaConectado");
    $location.path('/home');

  });
