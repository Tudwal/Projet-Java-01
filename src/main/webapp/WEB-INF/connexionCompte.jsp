<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONNEXION PROFIL</title>
</head>
<body>

<CENTER>
<form action="ConnexionServlet" method="POST">
	<input placeholder="Identifiant" type="text" name="identifiant" value="${model.utilisateur.pseudo}"/> 
	
	<br>
	<br>
	<input placeholder="Mot de Passe" type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>

	<br>
	<br>

	<input type="submit" name="connexion" value="Connexion"/>

	<input type="checkbox">Se souvenir de moi
	<a href="mailto:email@exemple.com?subject=subject text"> Mot de passe oublié</a>
	

</form>
</CENTER>


</body>
</html>