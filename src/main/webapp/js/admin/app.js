define([
    'angular',
    'text!tmpl/main.html',
    'text!tmpl/categories.html',
    'text!tmpl/products.html',
    'text!tmpl/solrIndex.html',
    'controllers',
    'directives',
    'angularRoute'
], function (
    ng,
    mainTmpl,
    categoriesTmpl,
    productsTmpl,
    solrIndexTmpl
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
                    .when('/categories', {
                        template: categoriesTmpl,
                        controller: 'CategoriesCtrl'
                    })
                    .when('/products', {
                        template: productsTmpl,
                        controller: 'ProductsCtrl'
                    })
                    .when('/solrIndex', {
                        template: solrIndexTmpl,
                        controller: 'SolrIndexCtrl'
                    })
                    .otherwise({
                        redirectTo: '/main'
                    });

    }]);

    return app;
});