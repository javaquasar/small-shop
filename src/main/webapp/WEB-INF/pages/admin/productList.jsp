<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title></title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="products-list">
    <div class="panel panel-default">
        <div class="panel-body">
            <div class="btn-group" role="group">
                <a type="button" class="btn btn-success" href="/app/product/create">Create</a>
            </div>
        </div>
    </div>
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
