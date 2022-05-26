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
	<form:form action="productsave" modelAttribute="product">
	<form:label path="name">Name:-</form:label>
	<form:input path="name"/>
	<form:label path="description">description:-</form:label>
	<form:input path="description"/>
	<form:label path="img">Add photo:-</form:label>
	<form:input path="img"/>
	<input type="submit" value="add_product">
	</form:form>

</body>
</html>