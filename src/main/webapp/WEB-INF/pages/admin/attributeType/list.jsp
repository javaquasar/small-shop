<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title></title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="panel-body">
    <c:forEach items="${attributeTypes}" var="type">
        <div class="panel panel-default">
            <div class="panel-body">
                <span>${type.name}</span>
            </div>
        </div>
    </c:forEach>
</div>



</body>
</html>
