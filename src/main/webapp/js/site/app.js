define([
    'angular',
    'text!tmpl/main.html',
    'text!tmpl/productList.html',
    'text!tmpl/productShow.html',
    'text!tmpl/cart.html',
    'controllers',
    'angularRoute'
], function (
    ng,
    mainTmpl,
    productListTmpl,
    productShowTmpl,
    cartTmpl
    ) {

    console.log("app");

    var app = ng.module('app', [
        'ngRoute',
        'controllers'
    ]);

    app.config(['$routeProvider', function ($routeProvider) {
                $routeProvider
                    .when('/main', {
                        template: mainTmpl,
                        controller: 'MainCtrl'
                    })
                    .when('/productList/:subCategoryId', {
                        template: productListTmpl,
                        controller: 'ProductListCtrl'
                    })
                    .when('/product/show/:productId', {
                        template: productShowTmpl,
                        controller: 'ProductShowCtrl'
                    })
                    .when('/cart', {
                        template: cartTmpl,
                        controller: 'CartCtrl'
                    })
                    .otherwise({
                        redirectTo: '/main'
                    });

    }]);

    return app;
});