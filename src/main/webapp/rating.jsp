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
	<form:form action="rating" modelAttribute="product">
		<table>
			<tr>
				<th>id</th>
				<td><form:input path="id" value="${product.id }"
						readonly="readonly" />
			</tr>
			<tr>
				<th>name</th>
				<td><input type="text" path="name" value="${product.name }"
					readonly="readonly"></td>

			</tr>
			<tr>
				<th>description</th>
				<td><input type="text" path="description"
					value="${ product.description }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>image</th>
				<td><img alt="no image" path="img" width="20px" height="20px"
					src="${ product.img }"></td>
			</tr>
			<tr>
				<th>rating</th>
				<td><input type="text" path="rating" name="${ product.rating }"></td>
			</tr>
			<tr>
				<th>review</th>
				<td><input type="text" path="review" name="${product.review }"></td>
			</tr>
		</table>
		<input type="submit">
	</form:form>
</body>
</html>