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

            var Category = $resource(root, {}, {});

            return Category;
        }]);

    //getBySubCategoryId

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
                addToCart: {
                    url: root + '/addToCart/:productId',
                    method: 'POST'
                },
                cartItems: {
                    url: root + '/cartItems',
                    isArray: true
                }
            });



            return Product;
        }]);

    return services;
});