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

<body class = tableau>
<c:import url="/WEB-INF/menu.jsp"/>
<h2 class=livres>MA LISTE DE SUPER LIVRES DE MA BIBLIOTHEQUE</h2>

<c:choose>
	
			<c:when test="${empty livres}">
					Aucun livre trouve
			</c:when>
	
			<c:otherwise>
			
			<table class=tableau>
			<tr>
			
			<th>categorie</th>
			<th>titre</th>
			<th>nbPages</th>
			<th>nomprenom </th>
			<th>details</th>
			<th>Supprimer</th>
		
		
			</tr>
			
			<c:forEach items="${livres}" var="livre" varStatus= "boucle">
			
			<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair' }"> 
		
			<td> <c:out value="${livre.categorie}" /></td>
			<td> <c:out value="${livre.titre}" /></td>
			<td> <c:out value="${livre.nbPages}" /> </td>
			<td><c:out value="${livre.auteur.prenom }" /> <c:out value="${ livre.auteur.nom }" /></td>	
			
			<td><a href="<c:url value="/DetailsLivres" ><c:param name="id" value="${livre.id }"/> </c:url>"> Voir</a></td>	
			
			<td><a	href="<c:url value="/SupprimerLivre" ><c:param name="id" value="${Livre.id }"/> </c:url>"> supprimer</a></td>
			</tr>
			</c:forEach>		
	</table>
	
	</c:otherwise>	
	
	</c:choose>
</body>
</html>

