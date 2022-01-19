<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


  <style><%@includefile="/WEB-INF/CSS/afficherMonCompte.css"%></style>

</head>

<title>Mon Profil</title>

<!-- Favicon-->
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
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilServlet">Déconnexion</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        
        
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
               <h1 class="masthead-heading text-uppercase mb-0">Profil</h1>
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
        

<span class="spanInfos">Pseudo : </span>  <span>${model.autreUtilisateur.pseudo}</span>

<span class="spanInfos">Nom : </span> <span>${model.autreUtilisateur.nom}</span>

<span class="spanInfos">Prénom : </span> <span>${model.autreUtilisateur.prenom}</span>

<span class="spanInfos">Email : </span> <span>${model.autreUtilisateur.email}</span>

<span class="spanInfos">Téléphone : </span> <span>${model.autreUtilisateur.telephone}</span>

<span class="spanInfos">Rue : </span> <span>${model.autreUtilisateur.rue}</span>

<span class="spanInfos">Code Postal : </span> <span>${model.autreUtilisateur.codePostal}</span>

<span class="spanInfos">Ville : </span> <span>${model.autreUtilisateur.ville}</span>
<br>



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