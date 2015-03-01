define([
    'angular',
    'angularCookies',
    'services'
], function (ng) {
    var controllers = ng.module('controllers', ['ngCookies', 'ngRoute', 'services']);

    controllers.controller('MainCtrl', ['$scope', '$cookies', '$log',
        function ($scope, $cookies, $log) {
            console.log('main');
        }]);

    controllers.controller('CategoriesCtrl', ['$scope', '$cookies', '$log', 'Category', '$rootScope', 'Cart',
        function ($scope, $cookies, $log, Category, $rootScope, Cart) {
            console.log('CategoriesCtrl');

            $scope.categories = Category.query();

            $rootScope.cart = {
                items: Cart.cartItems()
            };

        }]);

    controllers.controller('ProductListCtrl', ['$scope', '$log', 'Product', 'Category', '$routeParams', '$rootScope', 'Cart',
        function ($scope, $log, Product, Category, $routeParams, $rootScope, Cart) {

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
                Cart.addToCart(productId);
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

    controllers.controller('CartCtrl', ['$scope', '$cookies', '$log', 'Product', '$routeParams', '$rootScope', 'Cart',
        function ($scope, $cookies, $log, Product, $routeParams, $rootScope, Cart) {
            console.log('CartCtrl');

            $scope.cart = Cart.get();

            /**
             *
             * METHODS
             *
             */
            $scope.order = function() {
                console.log('ordering...');
                Cart.order();
            };

            $scope.removeFromCart = function(productId) {
                console.log('removing...');
                Cart.removeFromCart({productId: productId});
            };

            $scope.clean = function() {
                console.log('cleaning...');
                Cart.clean();
            };

        }]);



    return controllers;
});