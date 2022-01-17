<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<header>
	<c:url var="accueil" value="AccueilConnecteServlet"></c:url>
	<c:url var="enchere" value="AccueilConnecteServlet"></c:url>
	<c:url var="vendre" value="NouvelleVenteServlet"></c:url>
	<c:url var="profil" value="MonProfilServlet"></c:url>
	<c:url var="deconnexion" value="AccueilServlet"></c:url>
	
	<h1 class="titreConnexion"><a href="<c:out value="${accueil}"/>">ENI-Enchères</a></h1>
	
	<div>
		<h4><a href="<c:out value="${enchere}"/>">Enchères   </a>
		<a href="<c:out value="${vendre}"/>">Vendre un article   </a>
		<a href="<c:out value="${profil}"/>">Mon profil   </a>
		<a href="<c:out value="${deconnexion}"/>">Déconnexion </a></h4>
	</div>
</header>
