/**
 * Created with IntelliJ IDEA.
 * User: juancarrillo
 * Date: 12/11/13
 * Time: 10:14
 * To change this template use File | Settings | File Templates.
 */
function Controller($scope) {
    $scope.master= {};

    $scope.create = function(user) {

        $scope.master= angular.copy(user);

    };

    $scope.reset = function() {
        $scope.user = angular.copy($scope.master);
    };

    $scope.reset();
}