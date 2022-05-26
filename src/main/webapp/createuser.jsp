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
	<form:form action="usersave" modelAttribute="user">
	<form:label path="userName">User Name:</form:label>
	<form:input path="userName"/>
	<form:label path="password">User password:</form:label>
	<form:input path="password"/>
	<form:label path="role">User role:</form:label>
	Admin<input type="radio" name="role" value="admin">
	customer<input type="radio" name="role" value="customer">
	<input type="submit" value="register">
	</form:form>

</body>
</html>