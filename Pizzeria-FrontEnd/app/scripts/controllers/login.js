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
    var conect;
    login.promise.then(usrASesion);

    function usrASesion(data){
      if(data.usrConectado == undefined){
        conect = false;
      }else{
        console.log(data);
        conect = true;
        $scope.usrConectado.usuario = data.numeroDeCliente;
        $scope.usrConectado.password = data.password;
        $scope.usrConectado.estaConectado = conect;
        $scope.usrConectado.nombre = data.nombre;
        $scope.usrConectado.rol = data.rol;
      }

      console.log($scope.usrConectado);

      $cookies.put('estaConectado', conect);
      $cookies.put('usuario', data);
      if(conect){
        $location.path('/pedido');
      }
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
