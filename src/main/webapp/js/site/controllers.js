define([
    'angular',
    'angularCookies',
    'services'
], function (ng) {
    var controllers = ng.module('controllers', ['ngCookies', 'ngRoute', 'services']);

    controllers.controller('OrderCtrl', ['$scope', '$cookies', '$log', 'Order',
        function ($scope, $cookies, $log, Order) {
            console.log('test');
        }]);

    controllers.controller('CategoriesCtrl', ['$scope', '$cookies', '$log', 'Category',
        function ($scope, $cookies, $log, Category) {
            console.log('CategoriesCtrl');

            $scope.categories = Category.query();

        }]);

    controllers.controller('SubCategoryCtrl', ['$scope', '$cookies', '$log', 'Product', '$routeParams',
        function ($scope, $cookies, $log, Product, $routeParams) {
            console.log('SubCategoryCtrl');

            $scope.products = Product.getBySubCategoryId({
                subCategoryId: $routeParams.subCategoryId
            });

        }]);



    return controllers;
});