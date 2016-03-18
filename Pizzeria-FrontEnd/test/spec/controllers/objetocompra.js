'use strict';

describe('Controller: ObjetocompraCtrl', function () {

  // load the controller's module
  beforeEach(module('pizzeriaFrontEndApp'));

  var ObjetocompraCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    ObjetocompraCtrl = $controller('ObjetocompraCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(ObjetocompraCtrl.awesomeThings.length).toBe(3);
  });
});
