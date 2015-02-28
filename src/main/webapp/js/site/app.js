define([
    'angular',
    'text!tmpl/order.html',
    'text!tmpl/subCategory.html',
    'controllers',
    'angularRoute'
], function (
    ng,
    orderTmpl,
    subCategoryTmpl
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
                    .when('/subCategory/:subCategoryId', {
                        template: subCategoryTmpl,
                        controller: 'SubCategoryCtrl'
                    })
                    .otherwise({
                        redirectTo: '/order'
                    });

    }]);

    return app;
});