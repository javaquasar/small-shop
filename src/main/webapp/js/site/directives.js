define([
    'angular',
    'text!tmpl/categoriesMenu.html',
    'services'
], function (
    ng,
    categoriesMenuTmpl
    ) {
    var directives = ng.module('siteDirectives', ['services']);

    directives.directive('categoriesMenu', ['Category', '$rootScope', function(Category, $rootScope){
        return {
            template: categoriesMenuTmpl,
//            restrict: 'E',
            scope: {
                categories: '='
            },
            link: function(scope, element, attrs) {
//                if(rootScope.categories)

//                scope.categories = 'cc';

                console.log('categoriesMenu !!!!!!!!!');
                scope.t = 'ttt';

                scope.show = function (inner) {
                    scope.innerSubcategories = inner;
                    console.log('inner');
                }

            }
        }
    }]);


    return directives;
});