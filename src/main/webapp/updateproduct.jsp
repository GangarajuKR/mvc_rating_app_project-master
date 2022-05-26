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
	 <form:form action="updateprod" modelAttribute="product">
	<form:label path="id">Id:-</form:label>
	<form:input path="id"/><br><br>
	<form:label path="name">Name:-</form:label>
	<form:input path="name"/><br><br>
	<form:label path="description">description:-</form:label>
	<form:input path="description"/><br><br>
	<form:label path="img">Add photo:-</form:label>
	<form:input path="img"/><br><br>
	<form:label path="rating">Rating:-</form:label>
	<form:input  path="rating"/><br><br>
	<form:label path="review">Review:-</form:label>
	<form:input path="review"/> <br><br><br>
	<input type="submit" value="Update_product">
	</form:form>
	 
</body>
</html>