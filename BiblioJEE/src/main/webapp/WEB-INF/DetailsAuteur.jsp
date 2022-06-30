<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>détails des auteurs</title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css" />" />
</head>


<body>


<c:import url="/WEB-INF/menu.jsp"/>


<h1> Détails des auteurs</h1>
	


<div class="details">


<span> Nom : <c:out value="${auteur.nom }"/></span>
<span> prenom : <c:out value="${auteur.prenom }"/></span>
<span> telephone : <c:out value="${auteur.telephone }"/></span>
<span> email : <c:out value="${auteur.email }"/></span>



</div>
</body>
</html>













