<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajout auteur</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	
	
	

	<div class="form">
		<form method="post" action="<c:url value="/AjouterLivre" />">
		
			<fieldset>
				<legend>Créer un livre</legend>
				
				<label for="auteurLivre">Auteur</label>
<select id="auteurLivre" name="auteurLivre">
	<c:forEach items="${ auteurs }" var="auteur">
		<option value="<c:out value="${ auteur.id }"/>" ${ auteur.id == livre.auteur.id ? "selected" : "" }><c:out value="${ auteur.prenom }"/> <c:out value="${ auteur.nom }"/></option>
	</c:forEach>
</select>
<br/>

<label for="titreLivre">Titre</label>
<input type="text" id="titreLivre" name="titreLivre" value="<c:out value="${ livre.titre }" />" size="50" />
<br/>

<label for="nbPagesLivre">Nombre de pages</label>
<input type="number" id="nbPagesLivre" name="nbPagesLivre" value="<c:out value="${ livre.nbPages }" />" size="10" />
<br/>

<label for="categorieLivre">Catégorie</label>
<input type="text" id="categorieLivre" name="categorieLivre" value="<c:out value="${ livre.categorie }" />" size="20" />
<br/>
			
			</fieldset>
		
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
</body>
</html>