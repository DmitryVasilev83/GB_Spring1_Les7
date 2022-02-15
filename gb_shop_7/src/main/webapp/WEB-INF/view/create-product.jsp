<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Create product</title>
</head>
<body>

<form:form action="create" modelAttribute="product">
    <form:hidden path="id" value="${product.id}"/>
    Title: <form:input path="title"/>
    <br>
    Cost: <form:input path="cost"/>
    <br>
    Status: <form:input path="status"/>
    <br>
    Manufacturer: <form:input path="manufacturer"/>
    <br>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>