<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title></title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="order-list">
    <c:forEach items="${orders}" var="order">
        <div class="panel panel-default" data-order-id="${order.id}">
            <div class="panel-body">
                id: ${order.id} user: ${order.user.email}
                <c:forEach items="${order.orderItems}" var="item">
                    <div>
                        product: ${item.product.name}
                        <br/>
                        number: ${item.number}
                    </div>
                </c:forEach>
                <a href="/app/order/show/${order.id}">Show</a>
                <button class="remove-order">Remove</button>
            </div>
        </div>
    </c:forEach>
</div>


</body>
</html>
