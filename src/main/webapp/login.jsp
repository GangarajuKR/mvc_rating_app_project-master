<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="validation" modelAttribute="user">
	<form:label path="userName">User Name:</form:label>
	<form:input path="userName"/>
	<form:label path="password">User password:</form:label>
	<form:input path="password"/>
	<input type="submit" value="Login">
	</form:form>
</body>
</html>