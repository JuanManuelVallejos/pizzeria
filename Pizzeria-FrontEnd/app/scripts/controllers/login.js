'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('LoginCtrl', function ($http, $scope, $q, $cookies, $location) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.usrConectado = {usuario: "", password: "", estaConectado: ""};

    var login = $q.defer();

    login.promise.then(usrASesion);

    function usrASesion(data){
      $scope.usrConectado.usuario = data.numeroDeCliente;
      $scope.usrConectado.password = data.password;
      $scope.usrConectado.estaConectado = true;
      $scope.usrConectado.nombre = data.nombre;

      console.log($scope.usrConectado);

      $cookies.put('estaConectado', true);
      $cookies.put('usuario', data);

      $location.path('/pedido');
    }

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
          login.resolve(data);
          /*
        	if(data == -1){
        		alerte("El numero de cliente o password son incorrectos")
        	}else{
        		location = '#/pedido';
        	} */    	
        });
     };

  });
