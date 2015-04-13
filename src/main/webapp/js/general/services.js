define([
    'angular',
    'angularResource',
    'angularFileUpload'
], function (ng, angularResource) {
    var services = ng.module('services', ['ngResource', 'angularFileUpload']);

    services.factory('Order', ['$resource', '$upload',
        function ($resource, $upload) {

            var root = '/site/order';

            var Order = $resource(root, {orderId:'@id'}, {
                current: {
                    url: root + '/current/:userId'
                },
                createNew: {
                    method: 'POST'
                },
                test: {
                    url: root + '/:orderId',
                    method: "POST"
                },
                update: {
                    url: root + '/:orderId',
                    method: 'PUT'
                }
            });

            Order.uploadImage = function(orderId, file, success, error){
                $upload.upload({
                    url: '/site/order/saveFile',
                    method: 'POST',
                    data: {orderId: orderId},
                    file: file
                }).then(function (response) {
                    success && success(response.data);
                }, error);
            };

            return Order;
        }]);

    services.factory('Category', ['$resource',
        function ($resource) {

            //TODO move to constants
            //TODO move 'app' to separate constant
            var root = '/app/category';

            var Category = $resource(root, {}, {
                attributes: {
                    url: root + '/attributes/:subCategoryId',
                    isArray: true
                }
            });

            return Category;
        }]);

    services.factory('Product', ['$resource',
        function ($resource) {

            //TODO move to constants
            //TODO move 'app' to separate constant
            var root = '/app/product/:productId';

            var Product = $resource(root, {productId:'@id'}, {
                getBySubCategoryId: {
                    url: root + '/bySubCategoryId/:subCategoryId',
                    isArray: true
                },
                getBySubCategoryIdAndAttributeValue: {
                    url: root + '/filter/subCategory/:subCategoryId/attributeValue/:attributeValueId',
                    isArray: true
                },
                search: {
                    url: root + '/search',
                    method: 'POST',
                    isArray: true
                }
            });



            return Product;
        }]);

    services.factory('Cart', ['$resource',
        function ($resource) {

            //TODO move to constants
            //TODO move 'app' to separate constant
            var root = '/app/cart';

            var Cart = $resource(root, {}, {
                addToCart: {
                    url: root + '/:productId',
                    method: 'POST'
                },
                cartItems: {
                    url: root + '/cartItems',
                    isArray: true
                },
                order: {
                    url: root + '/order',
                    method: 'POST'
                },
                removeFromCart: {
                    url: root + '/:productId',
                    method: 'DELETE'
                },
                clean: {
                    method: 'DELETE'
                }
            });

            return Cart;
        }]);

    services.factory('Solr', ['$resource',
        function ($resource) {

            //TODO move to constants
            //TODO move 'app' to separate constant
            var root = 'http://localhost:8983/solr/:core/:requestHandler?q=:query&json.wrf=:callback';

            var Solr = $resource(root, {
                callback: "JSON_CALLBACK"
            }, {
                _findCategories: {
                    method: "JSONP",
                    params: {
                        core: 'category',
                        requestHandler: 'select'
                    }
                }
            });

            Solr.findCategories = function(titleQuery, success, error) {
                Solr._findCategories({
                    query: titleQuery
                }, function(data) {
                    success && success(data.response.docs);
                }, error)
            };



            return Solr;
        }]);

    return services;
});