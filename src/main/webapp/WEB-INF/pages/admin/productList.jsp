<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/global.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
    hello - ${test}

    <c:forEach items="${products}" var="product">
        ${product.name}
    </c:forEach>

</body>
</html>
