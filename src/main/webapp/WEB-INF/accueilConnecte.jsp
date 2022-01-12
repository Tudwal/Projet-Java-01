<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>

	<a href="http://localhost:8080/Ebehhhhhh/AccueilServlet">ENI-Enchères</a>

	<a style="text-align: right">Enchères </a>
	<a style="text-align: right">Vendre un article </a>
	<a style="text-align: right">Mon Profil </a>
	<a style="text-align: right">Déconnexion</a>

	<br>

	<h2 style="text-align: center">Liste des enchères</h2>
	<p>Filtres</p>
	<br>
	<input type="search" />
	<br>
	<select name="menu_categorie">
		<option>Toutes</option>
		<option>Informatique</option>
		<option>Ameublement</option>
		<option>Vetement</option>
		<option>Sport&Loisirs</option>
	</select>

	<button style="text-align: right" type="button">Rechercher</button>

	<form action="">
		<div>
			<input type="radio" id="Achats" name="transaction" value="Achats">
			<label for="Achats">Achats</label>
			<div>
				<input type="checkbox" id="encheresOuvertes" name="encheresOuvertes">
				<label for="encheresOuvertes">enchères ouvertes</label> 
				<input type="checkbox" id="mesEncheres" name="mesEncheres"> 
				<label for="mesEncheres">mes enchères</label> 
				<input type="checkbox" id="mesEncheresRemportees" name="mesEncheresRemportees"> 
				<label for="mesEncheresRemportees">mes enchères remportées</label>
			</div>
		</div>
		<div>
			<input type="radio" id="ventes" name="transaction" value="ventes" checked> 
			<label for="ventes">Mes ventes</label>
			<div>
				<input type="checkbox" id="mesVentesEnCours" name="mesVentesEnCours">
				<label for="mesVentesEnCours">mes ventes en cours</label> 
				<input type="checkbox" id="ventesNonDebutees" name="ventesNonDebutees">
				<label for="ventesNonDebutees">ventes non débutées</label> 
				<input type="checkbox" id="ventesTerminees" name="ventesTerminees">
				<label for="ventesTerminees">ventes terminées</label>
			</div>
		</div>

		<input style="text-align: right" type="submit" name="rechercher" value="Rechercher">

	</form>
	
	<br>
		<button>Description de l'article</button>
</body>
</html>