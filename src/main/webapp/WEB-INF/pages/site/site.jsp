<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/css/site.css" type="text/css" rel="stylesheet">
</head>
<body>

<div id="appContent" class="app-content">

    <div class="shop-header">

        <div class="logo">
            <a href="#/main">LOGO</a>
        </div>

        <div class="search" ng-controller="SearchCtrl">
            <form>
                <input ng-model="query">
                <a href="#/searchResult/{{query}}">Search</a>
                <%--<button ng-click="search()">Search</button>--%>
            </form>
        </div>

        <div class="cart">
            Cart: {{cart.items.length}}
            <a href="#/cart">Show Cart</a>
        </div>
    </div>


    <div class="categories" ng-show="categories" ng-controller="CategoriesCtrl">
        <ul>
            <li class="categories__category-item" ng-repeat="category in categories">
                <span class="categories__category-title" ng-bind="category.title"></span>
                <ul class="categories__sub">
                    <li ng-repeat="subCategory in category.subCategories">
                        <a href="#/productList/{{subCategory.id}}" ng-bind="subCategory.title"></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>


    <div ng-view></div>
</div>



<script src="/js/libs/require.js" data-main="/js/site/main.js"></script>
<script src="/js/libs/angular.js"></script>
</body>
</html>
