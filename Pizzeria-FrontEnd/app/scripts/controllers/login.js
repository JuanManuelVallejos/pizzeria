'use strict';

/**
 * @ngdoc function
 * @name pizzeriaFrontEndApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the pizzeriaFrontEndApp
 */
angular.module('pizzeriaFrontEndApp')
  .controller('LoginCtrl', function ($http, $scope, $q, $cookies, $location, $controller) {
    this.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $controller('AppCtrl', {$scope: $scope});

    $scope.usrConectado = {usuario: "", password: "", estaConectado: "", rol:""};

    var login = $q.defer();
    login.promise.then(usrASesion);

    function usrASesion(data){
      console.log(data);
      $scope.usrConectado.usuario = data.numeroDeCliente;
      $scope.usrConectado.password = data.password;
      $scope.usrConectado.estaConectado = true;
      $scope.usrConectado.nombre = data.nombre;
      $scope.usrConectado.rol = data.rol;

      console.log($scope.usrConectado);

      $cookies.put("estaConectado", true);
      $cookies.put('usuario', data);

      if(data.rol == "ADMIN"){
        $location.path('/');
      }else{
        $location.path('/pedido');
      }
      
      $scope.setBotonesPorRol(data.rol);
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
          if(data == -1){
            alert("El numero de cliente o password son incorrectos")
          }else{
            login.resolve(data);
            $("#login").hide();
            $("#logout").show();
        	}
        });
     };

  });
