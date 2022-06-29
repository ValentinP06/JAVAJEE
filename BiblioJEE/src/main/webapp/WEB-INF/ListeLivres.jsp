<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>biblio JEE</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css" />" />
</head>


<body>


<c:import url="/WEB-INF/menu.jsp"/>


<h2 class=livres>MA LISTE DE SUPER LIVRES DE MA BIBLIOTHEQUE</h2>

<c:forEach items="${ ListeLivres }" var="Livres">
			<c:out value="${ Livres }" /><br/>
	</c:forEach>


</body>
</html>

