'use strict';

describe('Controller: ItempedidoCtrl', function () {

  // load the controller's module
  beforeEach(module('pizzeriaFrontEndApp'));

  var ItempedidoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ItempedidoCtrl = $controller('ItempedidoCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ItempedidoCtrl.awesomeThings.length).toBe(3);
  });
});
