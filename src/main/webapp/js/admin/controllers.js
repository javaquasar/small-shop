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

    controllers.controller('CategoriesCtrl', ['$scope', '$cookies', '$log', 'Category',
        function ($scope, $cookies, $log, Category) {
            $scope.categories = Category.query();
        }]);

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
            }

        }]);

    controllers.controller('ProductEditModalCtrl',
        ['$scope', '$modalInstance', 'productId', 'Solr',
            function ($scope, $modalInstance, productId, Solr) {
                $scope.productId = productId;
                $scope.ok = function () {
                    $modalInstance.close();
                };

                $scope.changeCategory = function (val) {

                    console.log('changeCategory');

                    if(!val.length) return;

                    Solr.findCategories(val, function (categories) {
                        $scope.categories = categories;
                        console.log(categories);
                    }, function (error) {
                        console.log(error);
                    });

//                    http://localhost:8983/solr/category/select?q=*%3A*&wt=json

                    $.ajax({
                        'url': 'http://localhost:8983/solr/category/select/',
                        'data': {'wt':'json', 'q':'title:qwe','hl':true,'rows':5},
                        'success': function(data) { console.log(data)},
                        'dataType': 'jsonp',
                        'contentType': "application/json",
                        'jsonp': 'json.wrf'
                    });

                    console.log(val);
                };

                $scope.assignCategory = function (categoryId) {
                    console.log(categoryId);
                };

                $scope.cancel = function () {
                    $modalInstance.dismiss('cancel');
                };
            }
        ]
    );

    return controllers;
});