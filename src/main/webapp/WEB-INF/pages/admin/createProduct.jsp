<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title>Create new product</title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="panel-body">
    <form action="save" method="post">
        <div class="form-group">
            <label for="title">Title:</label>
            <input class="form-control" id="title" placeholder="Enter title" name="name">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
