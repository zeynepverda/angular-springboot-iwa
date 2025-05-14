<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add student</title>
</head>
<body>

<h1>${message}</h1>

<h2>Student</h2>
<form:form method="post" action="addStudent.html" modelAttribute="student">
    <form:label path="firstName">Firstname</form:label>
    <form:input path="firstName" />
    <br>

    <form:label path="lastName">Lastname</form:label>
    <form:input path="lastName" />
    <br>

    <form:label path="email">Email</form:label>
    <form:input path="email" />
    <br>

    <form:label path="telephone">Telephone</form:label>
    <form:input path="telephone" />
    <br>

    <input type="submit" value="Add Student" />
</form:form>

</body>
</html>
