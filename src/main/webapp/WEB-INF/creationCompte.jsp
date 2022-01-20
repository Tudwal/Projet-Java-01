<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">

	<style><%@includefile="/WEB-INF/CSS/creationCompte.css"%></style>

	<link href="creationCompte.css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>


    <title>CREATION PROFIL UTILISATEUR</title>
    
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
                <a class="navbar-brand" href="AccueilServlet">ENI-ENCHERE</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilServlet">Enchères</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="ConnexionServlet">Se connecter</a></li>                    
					</ul>
                </div>
            </div>
        </nav>
        
        
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <!-- Masthead Avatar Image-->
                <img class="masthead-avatar mb-5" src="https://p7.hiclipart.com/preview/954/328/914/computer-icons-user-profile-avatar.jpg" alt="..." />
                <!-- Masthead Heading-->
                
        
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div> <br>           
        	</div>
		
		
<h2>Inscription</h2>

<form action="InscriptionServlet" method="POST">
	<input placeholder="Pseudo" type="text" name="pseudo" value="${model.utilisateur.pseudo}"/> 
	<input placeholder="Nom" type="text" name="nom" value="${model.utilisateur.nom}"/>
	<input placeholder="Prenom" type="text" name="prenom" value="${model.utilisateur.prenom}"/>
	<input placeholder="Email" type="email" name="email" value="${model.utilisateur.email}"/>
	<input placeholder="Telephone" type="text" name="telephone" value="${model.utilisateur.telephone}"/>
	<input placeholder="Rue" type="text" name="rue" value="${model.utilisateur.rue}"/>
	<input placeholder="Code postal" type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
	<input placeholder="Ville" type="text" name="ville" value="${model.utilisateur.ville}"/>
	<input placeholder="Mot de Passe" type="password" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
	<input placeholder="Confirmation mdp" type="password" name="confirmation">
	<br>
	<br>

	<button class="buttonCreer" type="submit" name="ajouter" value="Créer">Créer</button>


	<!-- LIEN PAGE ACCUEIL btn ANNULER  -->
	<a href="AccueilServlet"><button class="buttonAnnuler" type="button">Annuler</button></a>


</form>

<h4>${model.message}</h4>


	<div id="deuxiemeTrait"></div>
	
	
	
</header>	
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