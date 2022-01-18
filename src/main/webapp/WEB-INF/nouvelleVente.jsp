<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouvelle vente</title>
</head>
<body style="text-align: center">
<jsp:include page="banniereConnecte.jsp"></jsp:include>

<form action="NouvelleVenteServlet" method="Post">

	Article : <input placeholder="nom article" type="text" name="nomArticle" value="" /> <br>
	Description : <input placeholder="votre description de l'article ici" size="50" type="text" name="descriptionArticle" value="" /> <br>	
	Catégorie : <select name="menuCategorie" id ="menuCategorie">
			<option value = 1>Informatique</option>
			<option value = 2>Ameublement</option>
			<option value = 3>Vêtement</option>
			<option value = 4>Sport & Loisirs</option>
		</select> <br>	
	Photo de l'article : <input type="file" name="photo" value="" /> <br>	
	Mise à prix : <input type="number" name="miseAPrix" value="" /> <br>	
	Début de l'enchère : <input type="datetime" name="debutEnchere" value="" /> <br>				
	Fin de l'enchère : <input type="datetime" name="finEnchere" value="" /> <br>	
	<br>
	Retrait <br>
	Rue : <input type="text" name="rueRetrait" value="${model.utilisateur.rue}" /> <br>
	Code Postal : <input type="text" name="codePostalRetrait" value="${model.utilisateur.codePostal}" /> <br>
	Ville : <input type="text" name="villeRetrait" value="${model.utilisateur.ville}" /> <br>
	
	
	<input type="submit" name="enregistrer" value="Enregister" /> 
	<input type="submit" name="annuler" value="Annuler" /> 
</form>

</body>
</html>