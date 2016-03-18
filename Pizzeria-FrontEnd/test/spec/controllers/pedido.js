'use strict';

describe('Controller: PedidoCtrl', function () {

  // load the controller's module
  beforeEach(module('pizzeriaFrontEndApp'));

  var PedidoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PedidoCtrl = $controller('PedidoCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PedidoCtrl.awesomeThings.length).toBe(3);
  });
});
