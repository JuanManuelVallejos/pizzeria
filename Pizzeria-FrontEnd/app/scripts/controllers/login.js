'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('LoginCtrl', function ($http, $scope) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

     $scope.ingresar = function() {
     	$http({
            method: 'POST',
            url: 'http://localhost:8080/Pizzeria-Backend/rest/clientes/ingresar',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            transformRequest: function(obj) {
                var str = [];
                    for(var p in obj)
                        str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
            return str.join("&");
            },

            data: {usuario: $scope.usuario, password: $scope.contrasenia}

        }).success(function (data) {
        	if(data == -1){
        		alerte("El numero de cliente o password son incorrectos")
        	}else{
        		//redireccionar
        	}     	
        });
     };

  });
