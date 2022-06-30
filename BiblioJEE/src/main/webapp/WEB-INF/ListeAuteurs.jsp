<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>biblio JEE</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
</head>


<body class=tableau>


	<c:import url="/WEB-INF/menu.jsp" />


	<h2 class=auteurs>MA LISTE DE SUPER AUTEURS</h2>


<div class=tableau>

	<c:choose>

		<c:when test="${empty ListeAuteurs}">
					Aucun auteur trouve
			</c:when>

		<c:otherwise>

			<table >
				<tr>

					<th>Nom
					</th >
					<th>Prenom
					</th >
					<th>Telephone
					</th >
					<th>email
					</th >

					<th>Détails		</th >
					<th>Supprimer
					</th >
					<th>Modifier</th >
				</tr >  

				<c:forEach items="${ ListeAuteurs }" var="Auteur" varStatus="boucle">

					<tr class="${boucle.index % 2 == 0 ? 'pair' : 'impair' }">

						<td><c:out value="${Auteur.nom}" /></td>
						<td><c:out value="${Auteur.prenom}" /></td>
						<td><c:out value="${Auteur.telephone}" /></td>
						<td><c:out value="${Auteur.email}" /></td>
						<td><a
							href="<c:url value="/DetailsAuteur" ><c:param name="id" value="${Auteur.id }"/> </c:url>">
								Voir</a></td>
						<td><a href="<c:url value="/SupprimerAuteur" ><c:param name="id" value="${Auteur.id }"/> </c:url>">
								supprimer</a> </td>
					
					<td><a href="<c:url value="/ModifierAuteur" ><c:param name="id" value="${Auteur.id }"/> </c:url>">
								Modifier</a></td>
					</tr>
				</c:forEach>
			</table>

		</c:otherwise>

	</c:choose>
</div>





</body>
</html>

