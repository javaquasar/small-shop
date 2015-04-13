define([
    'angular',
    'angularCookies',
    'general/services',
    'directives',
    'angularBootstrap'
], function (ng) {
    var controllers = ng.module('controllers', ['ngCookies', 'ngRoute', 'services', 'siteDirectives', 'ui.bootstrap']);

    controllers.controller('MainCtrl', ['$scope', '$cookies', '$log', 'Category',
        function ($scope, $cookies, $log, Category) {
            console.log('main');
        }]);

    controllers.controller('CategoriesCtrl', ['$scope', '$log', 'Category', '$modal',
        function ($scope, $log, Category, $modal) {
            $scope.categories = Category.query();

            $scope.createCategory = function () {
                $modal.open({
                    templateUrl: 'CategoryEditModalContent.html',
                    controller: 'CategoryEditModalCtrl',
                    resolve: {
                        categoryId: function () {
                            return;
                        }
                    }
                }).result.then(function (category) {
                    $scope.categories.push(category);
                });
            };
        }]);

    controllers.controller('CategoryEditModalCtrl',
        ['$scope', '$modalInstance', 'categoryId', 'Category',
            function ($scope, $modalInstance, categoryId, Category) {
                $scope.categoryId = categoryId;

                $scope.ok = function () {
                    Category.save($scope.category, function (category) {
                        $modalInstance.close(category);
                    });
                };

                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                };
            }
        ]
    );

    controllers.controller('ProductsCtrl', ['$scope', '$cookies', '$log', 'Product', '$modal',
        function ($scope, $cookies, $log, Product, $modal) {
            $scope.products = Product.query();

            $scope.editProduct = function(productId) {
                var modalInstance = $modal.open({
                    templateUrl: 'ProductEditModalContent.html',
                    controller: 'ProductEditModalCtrl',
                    resolve: {
                        productId: function () {
                            return productId;
                        }
                    }
                });

                modalInstance.result.then(function () {
//                    $scope.selected = selectedItem;
                }, function () {
//                    $log.info('Modal dismissed at: ' + new Date());
                });


//                var p = Product.get({productId: productId});
            }

            $scope.createProduct = function () {
                var modalInstance = $modal.open({
                    templateUrl: 'ProductEditModalContent.html',
                    controller: 'ProductEditModalCtrl',
                    resolve: {
                        productId: function () {
                            return;
                        }
                    }
                });
                modalInstance.result.then(function () {
//                    $scope.selected = selectedItem;
                }, function () {
//                    $log.info('Modal dismissed at: ' + new Date());
                });
            };

            $scope.deleteProduct = function (product) {
                Product.remove({productId: product.id}, function () {
                    var index = $scope.products.indexOf(product);
                    $scope.products.splice(index, 1);
                });
            };

        }]);

    controllers.controller('ProductEditModalCtrl',
        ['$scope', '$modalInstance', 'productId', 'Solr', 'Product',
            function ($scope, $modalInstance, productId, Solr, Product) {

                $scope.productId = productId;
                $scope.chosenCategories = [];

                $scope._getCategories = function () {
                    var categories = [];
                    angular.forEach($scope.chosenCategories, function (value) {
                        this.push({id: value.id});
                    }, categories);
                    return categories;
                };

                $scope.ok = function () {
                    $scope.product.categories = this._getCategories();
                    Product.save({}, $scope.product, function (data) {
                        $modalInstance.close();
                    });
                };

                $scope.changeCategory = function (val) {
                    if(!val.length) return;

                    Solr.findCategories(val, function (categories) {
                        $scope.categories = categories;
                        console.log(categories);
                    }, function (error) {
                        console.log(error);
                    });
                };

                $scope.assignCategory = function (category) {
                    if($scope.chosenCategories.indexOf(category) != -1) return;
                    $scope.chosenCategories.push(category);
                    $scope.categoryName = '';
                };

                $scope.removeCategory = function (category) {
                    var index = $scope.chosenCategories.indexOf(category);
                    $scope.chosenCategories.splice(index, 1);
                };

                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                };
            }
        ]
    );

    controllers.controller('SolrIndexCtrl',
        ['$scope', 'SolrAdmin',
            function ($scope, SolrAdmin) {


            }
        ]
    );

    return controllers;
});