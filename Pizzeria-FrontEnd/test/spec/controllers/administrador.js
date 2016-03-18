'use strict';

describe('Controller: AdministradorCtrl', function () {

  // load the controller's module
  beforeEach(module('pizzeriaFrontEndApp'));

  var AdministradorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdministradorCtrl = $controller('AdministradorCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AdministradorCtrl.awesomeThings.length).toBe(3);
  });
});
