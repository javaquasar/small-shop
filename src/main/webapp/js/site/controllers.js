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

    controllers.controller('ProductListCtrl', ['$scope', '$log', 'Product', 'Category', '$routeParams', '$rootScope',
        function ($scope, $log, Product, Category, $routeParams, $rootScope) {

            console.log('ProductListCtrl');

            /**
             *
             * INIT
             *
             */

            $scope.products = Product.getBySubCategoryId({
                subCategoryId: $routeParams.subCategoryId
            });

            $scope.attributes = Category.attributes({
                subCategoryId: $routeParams.subCategoryId
            });

            /**
             *
             * METHODS
             *
             */

            $scope.addToCart = function(productId) {
                $rootScope.cart.items.push(productId);
                Product.addToCart(productId);
            };

            $scope.filterByAttribute = function(attributeValueId) {
                console.log('filtering...');
                $scope.products = Product.getBySubCategoryIdAndAttributeValue({
                    subCategoryId: $routeParams.subCategoryId,
                    attributeValueId: attributeValueId
                });
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