<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil Connecté</title>

<style><%@includefile="/WEB-INF/CSS/accueilConnecte.css"%></style>

</head>

<title>ENI-ENCHERE</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
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
                <h3 class="creditAccueil">Crédits: ${model.utilisateur.credit} jetons</h3> 
                   
                <h3 class="bienvenue">Bienvenue  ${model.utilisateur.pseudo}</h3> 
                <!-- Masthead Avatar Image-->
                <img class="masthead-avatar mb-5 imgLargeAccueil" src="https://www.pngmart.com/files/17/Auction-PNG-Transparent-Image.png" alt="..." />
                
                <img class="masthead-avatar mb-5 imgMobileAccueil" src="https://www.eni-ecole.fr/wp-content/uploads/2021/05/elodie-anthony-angelique-anna-perrine-1-1-980x368.png" alt="..." />
                
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">Liste des Enchères</h1>
        
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                </div>
                <!-- Masthead Subheading-->
                    <br> 
    <form action="AccueilConnecteServlet" method="post">
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <span class="filtresRecherche">Filtres : </span> <br>
            <input class="inputRecherche" placeholder="Le nom de l'article contient" type="search"/>
            
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
        <div class="col-sm-6">
        <br>
            <button class="btn-Rechercher" type="submit" name="rechercher" value="Rechercher">Rechercher</button>

        </div>
    </div>
</div>

<br>
<br>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">

           <input class="inputGauche" type="radio" name="achats" value="achats" id="achats" checked onclick="onClickAchats()"> <span class="spanGauche">Achats</span> 
           <span class="spanDroite">Mes ventes</span> 
           <input class="inputDroite" type="radio" name="ventes" value="ventes" id="ventes" onclick="onClickVentes()"> 

        </div>
    </div>
<br>

<div class="row">
    <div class="col-sm-6">
            <input class="inputGauche" name="encheresOuvertes" type="checkbox" value="encheresOuvertes" id="encheresOuvertes" > 
            <span class="checkboxGauche">enchères ouvertes</span>
            <span class="checkboxDroite">mes ventes en cours</span>
            <input class="inputDroite" name="mesVentesEnCours" disabled type="checkbox" value="mesVentesEnCours" id="mesVentesEnCours">
            <br>
            <input class="inputGauche" name="mesEncheres"   type="checkbox" value="mesEncheres" id="mesEncheres"> 
            <span class="checkboxGauche">mes enchères</span>
            <span class="checkboxDroite">ventes non débutées</span>
            <input class="inputDroite" name="ventesNonDebutees" disabled type="checkbox" value="ventesNonDebutees" id="ventesNonDebutees">
            <br>
            <input class="inputGauche" name="mesEncheresRemportees" type="checkbox" value="mesEncheresRemportees" id="mesEncheresRemportees"> 
            <span class="checkboxGauche">mes encheres remportées</span>
            <span class="checkboxDroite">ventes terminées</span>
            <input class="inputDroite" name="ventesTerminees"  disabled type="checkbox" value="ventesTerminees" id="ventesTerminees">    
        
</div>
</div>
</div>
</form>


<div id="divArticle" class="container-fluid">
    	<div class="row">

	<c:forEach items="${ model.lstArticles }" var="articleVendu" varStatus="index">
      
      	<c:url value = "UneVenteServlet" var="UneVenteServlet"></c:url>
			
		<c:url value = "UnProfilServlet" var="UnProfilServlet"></c:url>
      
	        <div class="col-xl-3 col-lg-4 col-sm-6">
	        
	        	<div class="lstArticles">
	        	     		
	        		<div class="imgArticle">
	        			<img alt="..." src="https://www.grandparquet.com/wp-content/uploads/2016/02/pas-de-photo.png">
	        		</div>
	        		
	        		 <div class="informationsArticle">
            <br>
			
			<br> <a href="UneVenteServlet?numArticle=${articleVendu.noArticle}" >${articleVendu.nomArticle}</a> 
            <br> Prix : ${articleVendu.miseAPrix} points
            <br> Fin de l'enchère : ${articleVendu.dateFinEncheres} 
            <br> Vendeur : <a href="UnProfilServlet?numUtilisateur=${articleVendu.utilisateur.noUtilisateur}">${articleVendu.utilisateur.pseudo}</a>  <br>
            <br>
	        		 </div>
        		</div>
        	</div>
	</c:forEach>

 		</div>
	</div>


        </header>
       
       
        <!-- Copyright Section-->
        <div class="copyright py-4 text-center text-white">
            <div class="container"><small>© From { <a href="https://github.com/Totobyro" target="_blank">Totobyro</a> - <a href="https://github.com/Tudwal" target="_blank">Tudwal</a> - <a href="https://www.linkedin.com/in/thomas-guerin-074433146/" target="_blank">3rwan</a> }</small></div>
        </div>
       
       
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>


        <script type="application/javascript">
        function onClickAchats() {
        	var encheresOuvertes = document.getElementById("achats");
            ventes.checked = false;  
            var mesVentesEnCours = document.getElementById("mesVentesEnCours");
            mesVentesEnCours.checked = false;
            mesVentesEnCours.disabled = true;
            ventes.checked = false;
        
            var ventesNonDebutees = document.getElementById("ventesNonDebutees");
            ventesNonDebutees.checked = false;
            ventesNonDebutees.disabled = true;
            ventes.checked = false;
        
            var ventesTerminees = document.getElementById("ventesTerminees");
            ventesTerminees.checked = false;
            ventesTerminees.disabled = true;
            ventes.checked = false;


            var encheresOuvertes = document.getElementById("encheresOuvertes");
            encheresOuvertes.disabled = false;
           
            var mesEncheres = document.getElementById("mesEncheres");
            mesEncheres.disabled = false;
            
            var mesEncheresRemportees = document.getElementById("mesEncheresRemportees");
            mesEncheresRemportees.disabled = false;
        }
      

            function onClickVentes() {      	
            	var encheresOuvertes = document.getElementById("ventes");
                achats.checked = false;          	
            	
                var encheresOuvertes = document.getElementById("encheresOuvertes");
                encheresOuvertes.checked = false;
                encheresOuvertes.disabled = true;
            
                var mesEncheres = document.getElementById("mesEncheres");
                mesEncheres.checked = false;
                mesEncheres.disabled = true;
            
                var mesEncheresRemportees = document.getElementById("mesEncheresRemportees");
                mesEncheresRemportees.checked = false;
                mesEncheresRemportees.disabled = true;


                var mesVentesEnCours = document.getElementById("mesVentesEnCours");
                mesVentesEnCours.disabled = false;
        
                var ventesNonDebutees = document.getElementById("ventesNonDebutees");
                ventesNonDebutees.disabled = false;
        
                var ventesTerminees = document.getElementById("ventesTerminees");
                ventesTerminees.disabled = false;
            }
   
        </script>


    </body>
        

</html>
