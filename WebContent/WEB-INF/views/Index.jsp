<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des articles</h1>
	<div>
		<c:forEach var="client" items="${clients}">
			<div class="client">
				<h2>
					${client.lastname}				
				</h2>
				
			</div>
		</c:forEach>
	</div>
</body>
</html>