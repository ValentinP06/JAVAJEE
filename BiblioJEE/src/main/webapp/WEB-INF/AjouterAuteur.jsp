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
		<form method="post" action="<c:url value="/AjouterAuteur" />">
		
			<fieldset>
				<legend>Créer un auteur</legend>
				
				<label for="prenomAuteur">Prénom</label>
				<input type="text" id="prenomAuteur" name="prenomAuteur" size="20" />
				<br/>
				
				<label for="nomAuteur">Nom</label>
				<input type="text" id="nomAuteur" name="nomAuteur" size="20" />
				<br/>
				
				<label for="telephoneAuteur">Téléphone</label>
				<input type="text" id="telephoneAuteur" name="telephoneAuteur" size="10" />
				<br/>
				
				<label for="emailAuteur">Email</label>
				<input type="email" id="emailAuteur" name="emailAuteur" size="60" />
				<br/>
			
			</fieldset>
		
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
	
	
	
</body>
</html>