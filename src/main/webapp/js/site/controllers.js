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

    controllers.controller('CategoriesCtrl', ['$scope', '$cookies', '$log', 'Category', '$rootScope', 'Product',
        function ($scope, $cookies, $log, Category, $rootScope, Product) {
            console.log('CategoriesCtrl');

            $scope.categories = Category.query();

            $rootScope.cart = {
                items: Product.cartItems()
            };

        }]);

    controllers.controller('ProductListCtrl', ['$scope', '$cookies', '$log', 'Product', '$routeParams', 'Order', '$rootScope',
        function ($scope, $cookies, $log, Product, $routeParams, Order, $rootScope) {
            console.log('ProductListCtrl');

            $scope.products = Product.getBySubCategoryId({
                subCategoryId: $routeParams.subCategoryId
            });

            $scope.addToCart = function(productId) {
                $rootScope.cart.items.push(productId);
                Product.addToCart(productId);
            }

        }]);

    controllers.controller('ProductShowCtrl', ['$scope', '$cookies', '$log', 'Product', '$routeParams', '$rootScope',
        function ($scope, $cookies, $log, Product, $routeParams, $rootScope) {
            console.log('ProductShowCtrl');

            $scope.product = Product.get({
                productId: $routeParams.productId
            });

        }]);



    return controllers;
});