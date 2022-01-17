<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<header>
	<c:url var="accueil" value="AccueilServlet"></c:url>
	<c:url var="connexionInscription" value="ConnexionServlet"></c:url>
	<div>
		<h1>
			<a href="<c:out value="${accueil}"/>">ENI-Enchères</a>
		</h1>
		<h4>
			<a href="<c:out value="${connexionInscription}"/>">S'inscrire -	Se connecter</a>
		</h4>
	</div>
</header>
