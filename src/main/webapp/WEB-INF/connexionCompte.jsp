<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONNEXION PROFIL</title>
</head>
<body>

<Center>
<form action="ConnexionCompteServlet" method="POST">
	<input placeholder="Identifiant" type="text" name="pseudo" value="${model.utilisateur.pseudo}"/> 
	
	<br>
	<br>
	<input placeholder="Mot de Passe" type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>

	<input type="submit" name="ajouter" value="Connexion"/>

	<a href="mailto:email@exemple.com?subject=subject text"> Mot de passe oublié"</a>
	
	</Center>

</form>


</body>
</html>