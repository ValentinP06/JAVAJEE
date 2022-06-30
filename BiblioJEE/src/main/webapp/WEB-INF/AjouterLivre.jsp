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
				
				<label for="AuteurLivre">choisir Auteur</label>
				<br/>	

<select name="Auteur" id="Auteur-select">
<c:forEach items="${ Auteurs }" var="Auteur" >
    <option value="">--Please choose an autor--</option>
   <c:out value="${ Auteurs }" />
</c:forEach>

</select> 

				
				
				<br/><label for="titreLivre">titre</label>
				<input type="text" id="titreLivre" name="titreLivre" size="20" />
				<br/>
				
				<label for="nbPagesLivre">nbPages</label>
				<input type="text" id="nbPagesLivre" name="nbPagesLivre" size="10" />
				<br/>
				
				<label for="categorieLivre">categorie</label>
				<input type="text" id="categorieLivre" name="categorieLivre" size="60" />
				<br/>
			
			</fieldset>
		
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
	
	
	
</body>
</html>