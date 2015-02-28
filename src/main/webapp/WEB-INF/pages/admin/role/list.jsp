<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title></title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="role-list">
    <c:forEach items="${roles}" var="role">
        <div class="panel panel-default">
            <div class="panel-body">
                ${role.title}
            </div>
        </div>
    </c:forEach>
</div>


</body>
</html>
