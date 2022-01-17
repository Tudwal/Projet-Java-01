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
	Description : <input placeholder="" type="text" name="descriptionArticle" value="" /> <br>	

		
	Catégorie :<input type="submit" name="enregister" value="enregister" /> 
	<input type="submit" name="annuler" value="enregister" /> 
			<input type="checkbox">Se souvenir de moi 
			<a
			href="mailto:email@exemple.com?subject=subject text"> Mot de
			passe oublié</a> 
			<a
			href="<c:out value="${creerCompte}"/>">Crée un
			compte</a> 
			<a href="<c:out value="${accueil}"/>">Accueil</a>

		<h4>${model.message}</h4>






</form>

</body>
</html>