'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('AboutCtrl', function ($scope, $http) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
});
