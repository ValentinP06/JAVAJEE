<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css" />" />
<h2 class=menu>Menu VINTAGE</h2>
<h3> 30 JUIN 2022 </h3>
<div class = menu>
<ul>

	<li ><a href="<c:url value="/" />">Acceuil</a></li>
	<li ><a href="<c:url value="/ListeAuteurs" />">ListeAuteurs</a></li>
	<li ><a href="<c:url value="/ListeLivres" />">ListeLivres</a></li>
	<li ><a href="<c:url value="/AjouterAuteur" />">Ajoute ton auteur préféré</a></li>
	<li ><a href="<c:url value="/AjouterLivre" />">Ajoute ton livre préféré</a></li>
	
</ul>
</div>