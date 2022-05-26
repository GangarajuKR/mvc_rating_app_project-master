<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <c:forEach items="${products}" var="list">
	 <a href="editingproduct.jsp" >
			<table border="3px">
				<tr>
					<th>id</th>
					<td>${list.id}</td>
				</tr>
				<tr>
					<th>Name</th>
					<td>${list.name}</td>

				</tr>
				<tr>
					<th>description</th>
					<td>${list.description}</td>

				</tr>
				<tr>
					<th>image</th>
					<td><img alt="no_image" src="${list.img}" height="5px" width="5px">
					</td>
				</tr>
				<tr>
					<th>rating</th>
					<td>${list.rating}</td>

				</tr>
				<tr>
					<th>review</th>
					<td>${list.review}</td>
				</tr>
			</table></a>
		</c:forEach>

</body>
</html>