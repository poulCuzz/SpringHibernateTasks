<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 4/14/2023
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:input path="title"/>
    <form:input path="description"/>
    <form:input path="rating"/>
    <input type="submit" value="Save"/>
</form:form>
</body>
</html>
