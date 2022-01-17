<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body style="text-align: center">

	<jsp:include page="banniereConnecte.jsp"></jsp:include>

	<h2>Liste des enchères</h2>
	<p>Filtres</p>
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


		<div>
			<input type="radio" id="Achats" name="transaction" value="Achats">
			<label for="Achats">Achats</label>
			<div>
				<input type="checkbox" id="encheresOuvertes" name="encheresOuvertes">
				<label for="encheresOuvertes">enchères ouvertes</label> 
				<input
					type="checkbox" id="mesEncheres" name="mesEncheres"> 
				<label
					for="mesEncheres">mes enchères</label> 
				<input type="checkbox"
					id="mesEncheresRemportees" name="mesEncheresRemportees"> 
				<label
					for="mesEncheresRemportees">mes enchères remportées</label>
			</div>
		</div>
		<div>
			<input type="radio" id="ventes" name="transaction" value="ventes"
				checked> <label for="ventes">Mes ventes</label>
			<div>
				<input type="checkbox" id="mesVentesEnCours" name="mesVentesEnCours">
				<label for="mesVentesEnCours">mes ventes en cours</label> <input
					type="checkbox" id="ventesNonDebutees" name="ventesNonDebutees">
				<label for="ventesNonDebutees">ventes non débutées</label> <input
					type="checkbox" id="ventesTerminees" name="ventesTerminees">
				<label for="ventesTerminees">ventes terminées</label>
			</div>
		</div>
		<br>
		<input type="submit" name="rechercher" value="rechercher">  

	</form>

	<br>
	
	
	<p> Affichage des articles 
	
	
	
	
	
	
</body>
</html>