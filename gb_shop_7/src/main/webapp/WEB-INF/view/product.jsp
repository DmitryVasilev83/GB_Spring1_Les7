<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title>Product</title>
</head>

<body>

<h2>Product id: ${product.id}</h2>
<h2>Product title: ${product.title}</h2>
<h2>Product cost: ${product.cost}</h2>

<c:url var="deleteUrl" value="/gb_shop/delete">
    <c:param name="id" value="${product.id}"/>
</c:url>

<a href="${deleteUrl}">DELETE</a>

<br>

<c:url var="editUrl" value="/gb_shop/create"/>
<a href="${editUrl}">EDIT</a>

</body>
</html>