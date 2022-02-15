<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<title>Product List</title>
</head>

<body>

<h1>Product list</h1>

<ul>
    <c:forEach var="product" items="${products}">
        <c:url var="viewUrl" value="/gb_shop/${product.id}"/>
        <li>
            <a href="${viewUrl}">View</a>
            <br>
            Product id: ${product.id}
            <br>
            Product title: ${product.title}
            <br>
            Product cost: ${product.cost}
            <br>
        </li>
        <br>
    </c:forEach>
</ul>

<br>

<c:url var="createUrl" value="/gb_shop/create"/>
<a href="${createUrl}">CREATE</a>

</body>
</html>