<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Livre</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/inc/style.css" />" />
</head>
<body>
	<c:import url="/WEB-INF/menu.jsp" />
	
	
	

	<div class="form">
		<form method="post" action="<c:url value="/ModifierLivre" ><c:param name="id" value="${Livre.id }" /> </c:url>">
		
			<fieldset>
				<legend>Modifier un livre</legend>
				
				<label for="idAuteur">auteurlivre</label>
				
<select name="idAuteur" id="idAuteur">

<c:forEach items="${Auteurs}" var="auteur" >

    <option ${ auteur.id == Livre.auteur.id ? "selected" : "" }value="<c:out value="${auteur.id }" />"><c:out value="${auteur.nom }" /></option>
    
</c:forEach>
</select> 
				
				
				<label for="titreLivre">titre</label>
				<input type="text" id="titreLivre" name="titreLivre" value="<c:out value="${ Livre.titre }" />" size="20" />
				<br/>
				
				<label for="NbPages">nbPages</label>
				<input type="text" id="NbPages" name="NbPages" value="<c:out value="${ Livre.nbPages }" />" size="20" />
				<br/>
				
			<label for="categorieLivre">categorie</label>
				<input type="text" id="categorieLivre" name="categorieLivre" value="<c:out value="${Livre.categorie}" />" size="10" />
				<br/>
				
			
			</fieldset>
		
			<input type="submit" value="Valider" />
			<input type="reset" value="Remettre à zéro" />
		</form>
	</div>
	
	
	
</body>
</html>