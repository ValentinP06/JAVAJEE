<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>détails des livres</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css" />" />
</head>


<body>


<c:import url="/WEB-INF/menu.jsp"/>


<h1> Détails des livres</h1>
	


<div class="details">


<span> titre : <c:out value="${livres.titre }"/></span>
<span> nbPages : <c:out value="${livres.nbPages }"/></span>
<span> categorie : <c:out value="${livres.categorie }"/></span>
<span> auteur : <c:out value="${livres.auteur }"/></span>
<span> id : <c:out value="${livres.id }"/></span>



</div>
</body>
</html>


