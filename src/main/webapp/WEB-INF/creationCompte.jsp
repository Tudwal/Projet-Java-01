<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CREATION PROFIL UTILISATEUR</title>
</head>
<body style="text-align: center">

<jsp:include page="banniereDeconnecte.jsp"></jsp:include>

<h2>Mon profil</h2>

<form action="UtilisateurServlet" method="POST">
	<input placeholder="Pseudo" type="text" required pattern="[a-zA-Z0-9]{1,30}$" title="Le pseudo doit être alphaNumerique" name="pseudo" value="${model.utilisateur.pseudo}"/> 
	<input placeholder="Nom" type="text" required pattern="[a-zA-Z'-']{1,30}$" title="Le nom doit être au maximum de 30 caractères" name="nom" value="${model.utilisateur.nom}"/>
	<input placeholder="Prenom" type="text" required pattern="[a-zA-Z'-']{1,30}$" title="Le prénom doit être au maximum de 30 caractères" name="prenom" value="${model.utilisateur.prenom}"/>
	<input placeholder="Email" type="email" required name="email" value="${model.utilisateur.email}"/>
	<input placeholder="Telephone" type="text" pattern="[a-zA-Z0-9._%+-]{0,15}$" title="Le téléphone doit être au maximum de 15 chiffres" name="telephone" value="${model.utilisateur.telephone}"/>
	<input placeholder="Rue" type="text" required pattern="[a-zA-Z'-']{1,50}$" title="La rue doit être au maximum de 50 caractères" name="rue" value="${model.utilisateur.rue}"/>
	<input placeholder="Code postal" required  type="text" pattern="[a-zA-Z0-9'-']{1,10}$" title="Le code postal doit être au maximum de 10 caractères" name="codePostal" value="${model.utilisateur.codePostal}"/>
	<input placeholder="Ville" type="text" required pattern="[a-zA-Z'-']{1,50}$" title="La ville doit être au maximum de 50 caractères" name="ville" value="${model.utilisateur.ville}"/>
	<input placeholder="Mot de Passe" required type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
	<input placeholder="Confirmation" required type="password" name="confirmation">
	
	<br>
	<br>
	<input type="submit" name="ajouter" value="Créer"/>
	
</form>

<h4>${model.message}</h4>

</body>
</html>