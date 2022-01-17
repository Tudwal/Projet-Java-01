<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebehhhhh</title>
</head>
<body style="text-align: center">
	<jsp:include page="banniereDeconnecte.jsp"></jsp:include>

	<h2>Liste des enchères</h2>
	<h4>Filtres :</h4>
	<br>
	<form action="AccueilServlet" method="post">
		<input type="search" placeholder="Le nom de l'article contient" size="30"
			type="text" name="articleCherche" /> <br> 
		<select
			name="menuCategorie">
			<option>Toutes</option>
			<option>Informatique</option>
			<option>Ameublement</option>
			<option>Vêtement</option>
			<option>Sport & Loisirs</option>
		</select>
		<br>
		<input type="submit"name="rechercher" value="rechercher">  
	</form>



	<%-- 	Affichage de la liste des articles vendus en fonction de la catégorie sélectionnées
		//<c:forEach></c:forEach> --%>


</body>
</html>