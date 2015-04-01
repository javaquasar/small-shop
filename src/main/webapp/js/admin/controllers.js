define([
    'angular',
    'angularCookies',
    'general/services',
    'directives'
], function (ng) {
    var controllers = ng.module('controllers', ['ngCookies', 'ngRoute', 'services', 'siteDirectives']);

    controllers.controller('MainCtrl', ['$scope', '$cookies', '$log', 'Category',
        function ($scope, $cookies, $log, Category) {
            $scope.categories = Category.query();

            console.log('main');
        }]);

    controllers.controller('CategoriesCtrl', ['$scope', '$cookies', '$log', 'Category',
        function ($scope, $cookies, $log, Category) {
//            $scope.categories = Category.query();
        }]);

    controllers.controller('ProductsCtrl', ['$scope', '$cookies', '$log', 'Category',
        function ($scope, $cookies, $log, Category) {
//            $scope.categories = Category.query();
        }]);

    return controllers;
});