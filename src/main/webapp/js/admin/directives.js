define([
    'angular',
    'general/services'
], function (
    ng
    ) {
    var directives = ng.module('siteDirectives', ['services']);

    directives.directive('categoriesMenu', ['Category', '$rootScope', function(Category, $rootScope){
        return {
            template: categoriesMenuTmpl,
            scope: {
                categories: '='
            },
            link: function(scope, element, attrs) {

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