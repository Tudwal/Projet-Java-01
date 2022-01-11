<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATION PROFIL UTILISATEUR</title>
</head>
<body>

<h2><Center> Mon profil</Center></h2>

<form action="UtilisateurServlet" method="POST">
	<input placeholder="Pseudo" type="text" name="pseudo" value="${model.utilisateur.pseudo}"/> 
	<input placeholder="Nom" type="text" name="nom" value="${model.utilisateur.nom}"/>
	<input placeholder="Prenom" type="text" name="prenom" value="${model.utilisateur.prenom}"/>
	<input placeholder="Email" type="email" name="email" value="${model.utilisateur.email}"/>
	<input placeholder="Telephone" type="text" name="telephone" value="${model.utilisateur.telephone}"/>
	<input placeholder="Rue" type="text" name="rue" value="${model.utilisateur.rue}"/>
	<input placeholder="Code postal" type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
	<input placeholder="Ville" type="text" name="ville" value="${model.utilisateur.ville}"/>
	<input placeholder="Mot de Passe" type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
	<input placeholder="Confirmation" type="password" name="confirmation">
	
	<br>
	<br>
	<Center><input type="submit" name="ajouter" value="Créer"/></Center>
	

</form>

<h4>${model.message}</h4>

</body>
</html>