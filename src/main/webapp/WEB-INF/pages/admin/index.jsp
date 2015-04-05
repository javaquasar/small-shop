<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/admin.css" rel="stylesheet">
</head>
<body>

<div id="appContent" class="app-content">
    <div class="btn-group-vertical main-controls" role="group">
        <a href="#/categories" class="btn btn-default">Categories</a>
        <a href="#/products" class="btn btn-default">Products</a>
    </div>
    <div class="main-content">
        <div ng-view></div>
    </div>
</div>

<%--TODO remove--%>
<script src="/js/jquery/jquery.js"></script>


<script src="/js/libs/require.js" data-main="/js/admin/main.js"></script>
<script src="/js/libs/angular.js"></script>
</body>
</html>
