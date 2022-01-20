<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Ebehhhhh</title>
	<style><%@includefile="/WEB-INF/CSS/accueil.css"%></style>
	
	 <!-- Font Awesome icons-->
     <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
     <!-- Google fonts-->
     <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
     <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
</head>
    
<body id="page-top">

        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top colorMobile" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top">ENI-ENCHERE</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="InscriptionServlet">S'inscrire</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="ConnexionServlet">Se connecter</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image Large (PC-Tablette)-->
                <img class="masthead-avatar mb-5 imgLargeAccueil" src="https://www.pngmart.com/files/17/Auction-PNG-Transparent-Image.png" alt="..." />
    			<!-- Masthead Avatar Image Mobile-->
                <img class="masthead-avatar mb-5 imgMobileAccueil" src="https://www.eni-ecole.fr/wp-content/uploads/2021/05/elodie-anthony-angelique-anna-perrine-1-1-980x368.png" alt="..." />
                <!-- Masthead Titre-->
                <h1 class="masthead-heading text-uppercase mb-0">Liste des Enchères</h1>
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>  
            </div> <br> 
               
		<form action="AccueilServlet" method="post"> 
			<div class="container-fluid statistiques">
    			<div class="row">
	        		<div class="col-sm-6">
            			<span class="filtresRecherche">Filtres : </span> <br>    
            			<input class="inputRecherche" placeholder="Le nom de l'article contient" type="search" name="motClef"/>
            				<br>
            			<span class="categorie">Catégorie : </span> 
            			<select name="menuCategorie">
                			<option value="0">Toutes </option>
                			<option value="1">Informatique </option>
                			<option value="2">Ameublement </option>
                			<option value="3">Vetement </option>
                			<option value="4">Sport&Loisirs </option>
            			</select>  
            		</div> 
          
            		<div class="col-sm-6"> <br> <br>
      	  	   		<button class="btn-Rechercher" type="submit" name="rechercher" value="rechercher">Rechercher</button>
		   			</div>
    			</div>
			</div>
		</form>	
<br>
<br>
<br>

		<div class="container-fluid">
    		<div class="row">
				<c:forEach items="${ accueilmodel.lstArticles }" var="article" varStatus="index">
	        		<div class="col-xl-3 col-lg-4 col-sm-6">
	        			<div class="lstArticles">
	        				<div class="imgArticle">
	        					<img alt="..." src="https://www.grandparquet.com/wp-content/uploads/2016/02/pas-de-photo.png">
	        				</div>
	        		 		<div class="informationsArticle">
								<a href="ConnexionServlet">${article.nomArticle}</a> <br>		
            						<br> Prix : ${article.miseAPrix} points
            						<br> Fin de l'enchère : ${article.dateFinEncheres} 
            						<br>Vendeur : ${article.utilisateur.pseudo} <br> <br>
	        		 		</div>
        				</div>
        			</div>      
				</c:forEach>
 			</div>
		</div>
   	</header>
       
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>© From { <a href="https://github.com/Totobyro" target="_blank">Totobyro</a> - <a href="https://github.com/Tudwal" target="_blank">Tudwal</a> - <a href="https://github.com/3rwn" target="_blank">3rwan</a> }</small></div>
        </div>
      
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <style><%@includefile="/WEB-INF/script.js"%></style>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    </body>
</html>