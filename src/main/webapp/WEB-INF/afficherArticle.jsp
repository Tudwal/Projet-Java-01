<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	 <style><%@includefile="/WEB-INF/CSS/afficherArticle.css"%></style>
	
	<title>DETAIL VENTE</title>

</head>

  		<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />


<body id="page-top">
	
 <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="AccueilConnecteServlet">ENI-ENCHERE</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilConnecteServlet">Enchères</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="NouvelleVenteServlet">Vendre un article</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="MonProfilServlet">Mon profil</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilServlet">Déconnexion</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>


 <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
               <h1 class="masthead-heading text-uppercase mb-0">Détail vente</h1>
                <!-- Masthead Avatar Image-->
                
                
        
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                    <br> 

<%-- 	<c:if test="${model.enchere!=null}"> --%>
<%-- 	<span>${model.enchere.articleVendu.nomArticle}</span> --%>
<!-- 	<br> -->
<%-- 	<span class="spanInfos">Description :</span> <span>${model.enchere.articleVendu.description}</span> --%>
<!-- 	<br> -->
<%-- 	<span class="spanInfos">Catégorie :</span> <span>${model.enchere.articleVendu.categorieArticle.libelle}</span> --%>
<!-- 	<br> -->
<%-- <%-- 	<c:if test="${model.enchere.montantEnchere}=!null"> --%> 
<%-- 		<span class="spanInfos">Meilleure offre :</span> <span>${model.enchere.montantEnchere}  par  ${model.enchere.utilisateur.pseudo}</span> --%>
<!-- 		<br> -->
<%-- <%-- 	</c:if> --%>
	
<%-- 	<span class="spanInfos">Mise à prix :</span> <span>${model.enchere.articleVendu.miseAPrix}</span> --%>
<!-- 	<br> -->
<%-- 	<span class="spanInfos">Fin de l'enchère :</span> <span>${model.enchere.articleVendu.dateFinEncheres}</span> --%>
<!-- 	<br> -->
<%-- 	<span class="spanInfos">Retrait :</span> <span>${model.articleVendu.lieuRetrait.rue}</span> --%>
<!-- 	<br> -->
<%-- 	<span>${model.articleVendu.lieuRetrait.codePostal}</span> --%>
<%-- 	<span>${model.articleVendu.lieuRetrait.ville}</span> --%>
<!-- 	<br> -->
<%-- 	</c:if> --%>
	
	<span>${model.articleVendu.nomArticle}</span>
	<br>
	<span class="spanInfos">Description :</span> <span>${model.articleVendu.description}</span>
	<br>
	<span class="spanInfos">Catégorie :</span> <span>${model.articleVendu.categorieArticle.libelle}</span>
	<br>	
	<span class="spanInfos">Mise à prix :</span> <span>${model.articleVendu.miseAPrix}</span>
	<br>
	<span class="spanInfos">Meilleure offre :</span> <span>${model.enchere.montantEnchere}  par  ${model.enchere.utilisateur.pseudo}</span>
	<br>
	<span class="spanInfos">Fin de l'enchère :</span> <span>${model.articleVendu.dateFinEncheres}</span>
	<br>
	<span class="spanInfos">Retrait :</span> <span>${model.articleVendu.lieuRetrait.rue}</span>
	<br>
	<span>${model.articleVendu.lieuRetrait.codePostal}</span>
	<span>${model.articleVendu.lieuRetrait.ville}</span>
	<br>

	
	
		
	<form action="UneVenteServlet?numArticle=${model.enchere.articleVendu.noArticle}" method="post">
	
		<span class="spanProposition">Ma proposition :</span> <input class="inputProposition" type="number" name="montantEnchere">
		<button class="btnEncherir" type="submit" name="encherir" value="Enchérir">Enchérir</button>
	<br>
	
	</form>


<!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>

</body>
</html>