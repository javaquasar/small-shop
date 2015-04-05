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
                <a type="button" class="btn btn-success" href="create">Create</a>
            </div>
        </div>
    </div>
    <c:forEach items="${products}" var="product">
        <div class="panel panel-default">
            <div class="panel-body">
                <div class="product-controls">
                    <div class="btn-group" role="group">
                        <%--TODO  remove root /app need to use relative path--%>
                        <a href="edit/${product.id}" class="btn btn-info">Edit</a>
                        <a href="" class="btn btn-danger">Delete</a>
                    </div>
                </div>
                <span class="product-name">${product.title}</span>
            </div>
        </div>
    </c:forEach>
</div>


</body>
</html>
