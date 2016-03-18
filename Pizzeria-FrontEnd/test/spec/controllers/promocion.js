'use strict';

describe('Controller: PromocionCtrl', function () {

  // load the controller's module
  beforeEach(module('pizzeriaFrontEndApp'));

  var PromocionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    PromocionCtrl = $controller('PromocionCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(PromocionCtrl.awesomeThings.length).toBe(3);
  });
});
