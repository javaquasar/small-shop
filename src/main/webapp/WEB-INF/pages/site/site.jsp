<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <%--<link href="/css/site.css" type="text/css" rel="stylesheet">--%>
</head>
<body>

<div id="appContent">

    <div ng-show="categories" ng-controller="CategoriesCtrl">
        <ul ng-repeat="category in categories">
            <li>
                <span ng-bind="category.title"></span>
                <ul ng-repeat="subCategory in category.subCategories">
                    <li>
                        <a href="#/productList/{{subCategory.id}}" ng-bind="subCategory.title"></a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>

    <div>
        Cart: {{cart.items.length}}
        <a href="#/cart">Show Cart</a>
    </div>

    <div ng-view></div>
</div>



<script src="/js/libs/require.js" data-main="/js/site/main.js"></script>
<script src="/js/libs/angular.js"></script>
</body>
</html>
