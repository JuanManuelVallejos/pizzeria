'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:AdministradorCtrl
 * @description
 * # AdministradorCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('AdministradorCtrl', function ($scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.changeTab = function(tab) {
    		$scope.view_tab = tab;
	};
  });
