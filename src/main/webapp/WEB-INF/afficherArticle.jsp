<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Compte de l'utilisateur</title>
</head>
<body style="text-align: center">
	<jsp:include page="banniereConnecte.jsp"></jsp:include>

	<h2>Détail vente</h2>
	<span>${model.enchere.articleVendu.nomArticle}</span>
	<br>
	Description : <span>${model.enchere.articleVendu.description}</span>
	<br>
	Catégorie : <span>${model.enchere.articleVendu.categorieArticle.libelle}</span>
	<br>
	<c:if test="${model.enchere.montantEnchere}=!null">
		Meilleure offre : <span>${model.enchere.montantEnchere} par ${model.enchere.utilisateur.pseudo}</span>
		<br>
	</c:if>
	
	Mise à prix : <span>${model.enchere.articleVendu.miseAPrix}</span>
	<br>
	Fin de l'enchère : <span>${model.enchere.articleVendu.dateFinEncheres}</span>
	<br>
	Retrait : <span>${model.enchere.articleVendu.lieuRetrait.rue}</span>
	<br><span>${model.enchere.articleVendu.lieuRetrait.codePostal}</span>
	<span>${model.enchere.articleVendu.lieuRetrait.ville}</span>
	<br>
	<span>${model.enchere.articleVendu.utilisateur.pseudo}</span>
	<br>
	<form action="UneVenteServlet" method="post">
	Ma proposition : <input type="number" name="montantEnchere">
	<input type="submit" name="encherir" value="Enchérir">
	<br></form>

</body>
</html>