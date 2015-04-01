<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/admin.css" rel="stylesheet">
</head>
<body>

<div class="btn-group-vertical" role="group">
    <a href="#/categories" class="btn btn-default">Categories</a>
    <a href="#/products" class="btn btn-default">Products</a>
</div>

<div id="appContent" class="app-content">
    <div ng-view></div>
</div>



<script src="/js/libs/require.js" data-main="/js/admin/main.js"></script>
<script src="/js/libs/angular.js"></script>
</body>
</html>
