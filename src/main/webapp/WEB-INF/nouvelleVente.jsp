<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	
	<style><%@includefile="/WEB-INF/CSS/nouvelleVente.css"%></style>
	
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
	
	<title>NOUVELLE VENTE</title>
	
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
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="MonProfilServlet">Mon profil</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilServlet">Déconnexion</a></li>                    
					</ul>
                </div>
            </div>
        </nav>
        
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">Nouvelle vente</h1>
                
        
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                    <br> 
        
        

<form action="NouvelleVenteServlet" method="Post">

	<input placeholder="Nom de l'article" type="text" name="nomArticle" value="" /> <br>
	<input placeholder="Votre description de l'article ici..." size="50" type="text" name="descriptionArticle" value="" /> <br>	
	<span> Catégorie : </span>
	
	<select class="categorieSelect" name="menuCategorie" id ="menuCategorie">
			<option value = 1>Informatique</option>
			<option value = 2>Ameublement</option>
			<option value = 3>Vêtement</option>
			<option value = 4>Sport & Loisirs</option>
		</select> <br>	<br> <br>
	
	<span> Photo de l'article : </span>	
	<input class="photoFichier" placeholder="Photo de l'article " type="file" name="photo" value="" /> <br>	
	<input placeholder="Mise à prix" type="number" name="miseAPrix" value="" /> <br>	
	<input placeholder="Début de l'enchère" type="datetime" name="debutEnchere" value="" /> <br>				
	<input placeholder="Fin de l'enchère" type="datetime" name="finEnchere" value="" /> <br>	
	<br>
	<span>Retrait</span>  <br> <br>
	<input placeholder="Rue" type="text" name="rueRetrait" value="${model.utilisateur.rue}" /> <br>
	<input placeholder="Code Postal" type="text" name="codePostalRetrait" value="${model.utilisateur.codePostal}" /> <br>
	<input placeholder="Ville" type="text" name="villeRetrait" value="${model.utilisateur.ville}" /> <br>
	
	<br>
	
	<button class="buttonEnregistrer" type="submit" name="enregistrer" value="Enregistrer">Enregistrer</button>
	
	<a href="AccueilConnecteServlet"><button class="buttonAnnuler" type="button">Annuler</button></a>

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