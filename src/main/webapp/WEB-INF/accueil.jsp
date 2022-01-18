<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ebehhhhh</title>
</head>
<body style="text-align: center">
	<jsp:include page="banniereDeconnecte.jsp"></jsp:include>

	<h2>Liste des enchères</h2>
	<h4>Filtres :</h4>
	<br>
	<form action="AccueilServlet" method="post">
		<input type="search" placeholder="Le nom de l'article contient"
			size="30" type="text" name="articleCherche" /> <br> <select
			name="menuCategorie">
			<option value=null>Toutes</option>
			<option value="1">Informatique</option>
			<option value="2">Ameublement</option>
			<option value="3">Vêtement</option>
			<option value="4">Sport & Loisirs</option>
		</select> <br> <input type="submit" name="rechercher" value="rechercher">
	</form>


	<c:forEach items="${ accueilmodel.lstArticles }" var="article" varStatus="index">
		<div>
			index
			<%--     <c:out value="${ status.count }" /> : <c:out value="${ titre }" />  --%>
			<br> 
<%-- 			<c:url value=""> ${article.nomArticle} </c:url> --%>
			${article.nomArticle}
			
			<br> Prix : ${article.miseAPrix} points 
			<br> Fin de l'enchère : ${article.dateFinEncheres} 
			<br>Vendeur : ${article.utilisateur.pseudo} <br>
			<br>

		</div>
	</c:forEach>


</body>
</html>