<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mon Profil</title>
</head>
<body>

<form action="ProfilServlet" method="POST">

Pseudo : ${model.utilisateur.pseudo}
<br>
Nom : ${model.utilisateur.nom}
<br>
Prénom : ${model.utilisateur.prenom}
<br>
Email : ${model.utilisateur.email}
<br>
Téléphone : ${model.utilisateur.telephone}
<br>
Rue : ${model.utilisateur.rue}
<br>
Code Postale : ${model.utilisateur.codePostal}
<br>
Ville : ${model.utilisateur.ville}
<br>

	<Center><input type="submit" name="modifier" value="Modifier"/></Center>


</form>


</body>
</html>