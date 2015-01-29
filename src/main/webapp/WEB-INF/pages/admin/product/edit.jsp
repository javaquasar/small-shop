<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title>Create new product</title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="panel-body">
    <form:form action="save" method="post" modelAttribute="product">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="hidden" name="id" value="${product.id}">
            <input class="form-control" id="title" placeholder="Enter title" name="title" value="${product.name}">
        </div>
        <div class="form-group">
            <label>Attributes:</label>
            <c:forEach items="${product.productAttributes}" var="attribute" varStatus="status">
                <input class="form-control" placeholder="Enter title"
                       name="attributes[${status.index}].value" value="${attribute.valueAsString}">
                ${attribute.attributeType.type}
            </c:forEach>
            <%--<input class="form-control" placeholder="Enter title" name="attributes[0].value">--%>
            <%--<input class="form-control" placeholder="Enter t id" name="attributes[0].attributeTypeId">--%>

            <%--<input class="form-control" placeholder="Enter title" name="attributes[1].value">--%>
            <%--<input class="form-control" placeholder="Enter t id" name="attributes[1].attributeTypeId">--%>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>

</body>
</html>
