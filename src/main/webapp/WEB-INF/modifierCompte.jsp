<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">

	<style><%@includefile="/WEB-INF/CSS/modifierCompte.css"%></style>

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>


	<title>MODIF PROFIL</title>
	
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
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="NouvelleVenteServlet">Vendre un article</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilServlet">Déconnexion</a></li>                    
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
                </div>
                <!-- Masthead Subheading-->
                    <br> 


<form action="ModifierMonProfilServlet" method="POST">
	<span>Utilisateur </span> 
	<br>
	<input placeholder="Pseudo" type="text" name="pseudo" value="${model.utilisateur.pseudo}"/> 
	<br>
	<span>Nom </span> 
	<br>
	<input placeholder="Nom" type="text" name="nom" value="${model.utilisateur.nom}"/>
	<br>
	<span>Prénom</span> 
	<br>
	<input placeholder="Prenom" type="text" name="prenom" value="${model.utilisateur.prenom}"/>
	<br>
	<span>Email</span> 
	<br>
	<input placeholder="Email" type="email" name="email" value="${model.utilisateur.email}"/>
	<br>
	<span>Téléphone</span> 
	<br>
	<input placeholder="Telephone" type="text" name="telephone" value="${model.utilisateur.telephone}"/>
	<br>
	<span>Rue</span> 
	<br>
	<input placeholder="Rue" type="text" name="rue" value="${model.utilisateur.rue}"/>
	<br>
	<span>Code Postal</span> 
	<br>
	<input placeholder="Code postal" type="text" name="codePostal" value="${model.utilisateur.codePostal}"/>
	<br>
	<span>Ville</span> 
	<br>
	<input placeholder="Ville" type="text" name="ville" value="${model.utilisateur.ville}"/>
	<br>
	<span>Mot de passe</span> 
	<br>
	<input placeholder="Mot de passe actuel" type="text" name="motDePasse" value="${model.utilisateur.motDePasse}"/>
	<br>
	<span>Nouveau Mot de passe</span> 
	<br>
	<input placeholder="Nouveau mot de passe " type="password" name="nouveauMotDePasse" />
	<br>
	<span>Confirmation</span> 
	<br>
	<input placeholder="Confirmation" type="password" name="confirmation">
	
	<br><br><br>

	
	<button class="buttonEnregistrer" type="submit" name="enregistrer" value="Enregistrer">Enregistrer</button>
	
	<button class="buttonSupprimer" type="submit" name="supprimer" value="Supprimer">Supprimer mon compte</button>

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