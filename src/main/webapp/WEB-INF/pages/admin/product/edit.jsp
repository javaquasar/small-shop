<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/global.jsp" %>
<html>
<head>
    <title>Create new product</title>
    <%@ include file="/WEB-INF/pages/admin/adminStatic.jsp" %>
</head>
<body>

<div class="panel-body">
    <form:form action="/app/product/save" method="post" commandName="productForm">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="hidden" name="id" value="${productForm.id}">
            <form:input class="form-control" path="title" placeholder="Enter title"/>
        </div>
        <div class="form-group">
            <label>Attributes:</label>
            <div class="attribute-list">
                <c:forEach items="${productForm.attributes}" var="attribute" varStatus="status">
                    <fieldset class="attribute panel panel-default ">
                        <div class="panel-body">
                            <input type="hidden" name="attributes[${status.index}].id" value="${attribute.id}">
                            <input class="form-control" placeholder="Enter title"
                                name="attributes[${status.index}].value" value="${attribute.value}">
                            <form:select cssClass="form-control" path="attributes[${status.index}].attributeTypeId" items="${types}" itemLabel="name" itemValue="id"></form:select>
                            <%--${attribute.attributeType.type}--%>
                        </div>
                    </fieldset>
                </c:forEach>
            </div>
            <button class="btn btn-success add-attribute">Add attribute</button>

            <%--TODO | check if add attribute to project and then click remove it without saving--%>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form:form>
</div>

<form:form id="attributeInputTemplate" hidden="hidden" commandName="productForm" data-name-template="attributes[%(index)s].attributeTypeId">
    <fieldset class="attribute panel panel-default">
        <div class="panel-body">
            <input type="hidden" class="attribute-id" name="attributes[${status.index}].id" value="${attribute.id}" data-name-template="attributes[%(index)s].id">
            <input class="form-control attribute-value" placeholder="Enter value" name="attributes[0].value" data-name-template="attributes[%(index)s].value">
            <form:select cssClass="form-control attribute-type" path="attributes[0].attributeTypeId" data-name-template="attributes[%(index)s].attributeTypeId"
                         items="${types}" itemLabel="name" itemValue="id"></form:select>
        </div>
    </fieldset>
</form:form>

<script>
    $(function() {
        $('.add-attribute').click(function(event) {
            var $attributeFieldset = $('#attributeInputTemplate fieldset.attribute').clone();
            correctAttributeInput($attributeFieldset.find('.attribute-id'));
            correctAttributeInput($attributeFieldset.find('.attribute-value'));
            correctAttributeInput($attributeFieldset.find('.attribute-type'));
            $('.attribute-list').append($attributeFieldset);
            return false;
        });

        function correctAttributeInput($input) {
            var index = $('.attribute-list fieldset.attribute').length;
            var name = sprintf($input.data('nameTemplate'), {index: index});
            $input.attr('name', name);
            $input.val('')
        }
    })
</script>

</body>
</html>
