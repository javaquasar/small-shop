<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title></title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/admin.css" rel="stylesheet">
</head>
<body>

<div class="products-list">
    <c:forEach items="${products}" var="product">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="product-controls">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-info">Edit</button>
                        <button type="button" class="btn btn-danger">Delete</button>
                    </div>
                </div>
                <span class="product-name">${product.name}</span>
            </div>
        </div>
    </c:forEach>
</div>


</body>
</html>
