<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebehhhhh</title>
</head>
<body>
<h1>Ebehhhhhh</h1>

<form action="AccueilServlet" method="POST">

<input type="submit" name="connexion" value="S'inscrire - Se connecter"/>
<a href="http://localhost:8080/Ebehhhhhh/ConnexionServlet">Se connecter</a>
<a href="http://localhost:8080/Ebehhhhhh/UtilisateurServlet">S'inscrire</a>

</form>

<h2>Liste des ench�res</h2>
<p>Filtres</p> <br>
<input type="search"/> <br>
<select name="menu_categorie">
	<option>Toutes </option>
	<option>Informatique </option>
	<option>Ameublement </option>
	<option>Vetement </option>
	<option>Sport&Loisirs </option>
</select>


</body>
</html>