<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 4/17/2023
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Student</title>
</head>
<body>
<form:form method="post" modelAttribute="student">
    FirstName:
    <form:input path="firstName"/>
    LastName:
    <form:input path="lastName"/>
    Country:
    <form:input path="country"/>
    Gender:
    <form:input path="gender"/>
    Mailing List:
    <form:input path="mailingList"/>
    Notes:
    <form:input path="notes"/>
    Programming Skills:
    <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/>
    Hobbies:
    <form:select path="hobbies" items="${hobbies}" multiple="true"/>
    <input type="submit" value="Save">
</form:form>
</body>
</html>
