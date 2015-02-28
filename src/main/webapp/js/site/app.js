define([
    'angular',
    'text!tmpl/order.html',
    'text!tmpl/productList.html',
    'text!tmpl/productShow.html',
    'controllers',
    'angularRoute'
], function (
    ng,
    orderTmpl,
    productListTmpl,
    productShowTmpl
    ) {

    console.log("app");

    var app = ng.module('app', [
        'ngRoute',
        'controllers'
    ]);

    app.config(['$routeProvider', function ($routeProvider) {
                $routeProvider
                    .when('/order', {
                        template: orderTmpl,
                        controller: 'OrderCtrl'
                    })
                    .when('/productList/:subCategoryId', {
                        template: productListTmpl,
                        controller: 'ProductListCtrl'
                    })
                    .when('/product/show/:productId', {
                        template: productShowTmpl,
                        controller: 'ProductShowCtrl'
                    })
                    .otherwise({
                        redirectTo: '/order'
                    });

    }]);

    return app;
});