<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modif Profil</title>
</head>
<body style="text-align: center">
<jsp:include page="banniereConnecte.jsp"></jsp:include>

<h2>Modifier mon profil</h2>

<form action="ModifierMonProfilServlet" method="POST">
	<input placeholder="Pseudo" type="text" name="pseudo" value="${model.utilisateur.pseudo}"/> 
	<br><br>
	<input placeholder="Nom" type="text" name="nom" value="${model.utilisateur.nom}"/>
	<br><br>
	<input placeholder="Prenom" type="text" name="prenom" value="${model.utilisateur.prenom}"/>
	<br><br>
	<input placeholder="Email" type="email" name="email" value="${model.utilisateur.email}"/>
	<br><br>
	<input placeholder="Telephone" type="text" name="telephone" value="${model.utilisateur.telephone}"/>
	<br><br>
	<input placeholder="Rue" type="text" name="rue" value="${model.utilisateur.rue}"/>
	<br><br>
	<input placeholder="Code postal" type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
	<br><br>
	<input placeholder="Ville" type="text" name="ville" value="${model.utilisateur.ville}"/>
	<br><br>
	<input placeholder="Mot de passe actuel" type="text" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
	<br><br>
	<input placeholder="Nouveau mot de passe " type="password" name="nouveauMotDePasse" />
	<br><br>
	<input placeholder="Confirmation" type="password" name="confirmation">
	
	<br><br>

	<br><br>
	<input type="submit" name="enregistrer" value="Enregistrer"/>
	<input type="submit" name="supprimer" value="Supprimer mon compte"/>

</form>

</body>
</html>