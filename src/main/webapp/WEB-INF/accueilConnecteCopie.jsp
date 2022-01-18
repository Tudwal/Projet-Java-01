<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil Connecté</title>

<style><%@includefile="/WEB-INF/accueilConnecteCopie.css"%></style>

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
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="#page-top">ENI-ENCHERE</a>
                <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="AccueilConnecteServlet">Enchères</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="UneVenteServlet">Vendre un article</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="MonProfilServlet">Mon profil</a></li>
                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="http://localhost:8080/Ebehhhhhh/ConnexionServlet">Déconnexion</a></li>
                        
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Masthead-->
        <header class="masthead bg-primary text-white text-center">
            <div class="container d-flex align-items-center flex-column">
                <h3 class="bienvenue">Bienvenue  ${model.utilisateur.pseudo}</h3> 
                <!-- Masthead Avatar Image-->
                <img class="masthead-avatar mb-5" src="https://www.pngmart.com/files/17/Auction-PNG-Transparent-Image.png" alt="..." />
                <!-- Masthead Heading-->
                <h1 class="masthead-heading text-uppercase mb-0">Liste des Enchères</h1>
        
                <!-- Icon Divider-->
                <div class="divider-custom divider-light">
                    <div class="divider-custom-line"></div>
                    <div class="divider-custom-icon"><i class="fas fa-star"></i></div>
                    <div class="divider-custom-line"></div>
                </div>
                <!-- Masthead Subheading-->
                    <br> 
    
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">
            <span class="filtresRecherche">Filtres : </span> <br>
            <input class="inputRecherche" placeholder="Le nom de l'article contient" type="search"/>
            
            <br>
            <span class="categorie">Catégorie : </span> 
            <select name="menu_categorie">
                <option>Toutes </option>
                <option>Informatique </option>
                <option>Ameublement </option>
                <option>Vetement </option>
                <option>Sport&Loisirs </option>
            </select>


        </div>
        <div class="col-sm-6">
        <br>
            <button class="btn-Rechercher" type="submit" name="ajouter" value="Créer">Rechercher</button>

        </div>
    </div>
</div>

<br>
<br>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-6">

           <input class="inputGauche" type="radio" name="encheres" value="achats" id="achats" onclick="onClickAchats()"> <span class="spanGauche">Achats</span> 
           <span class="spanDroite">Mes ventes</span> <input class="inputDroite" type="radio" name="encheres" value="ventes" id="ventes" onclick="onClickVentes()"> 

        </div>
    </div>
<br>

<div class="row">
    <div class="col-sm-6">
            <input class="inputGauche" type="checkbox" value="encheresOuvertes" id="encheresOuvertes"> <span class="checkboxGauche">enchères ouvertes</span>
            <span class="checkboxDroite">mes ventes en cours</span><input class="inputDroite" type="checkbox" value="mesVentesEnCours" id="mesVentesEnCours">
            <br>
            <input class="inputGauche" type="checkbox" value="mesEncheres" id="mesEncheres"> <span class="checkboxGauche">mes enchères</span>
            <span class="checkboxDroite">ventes non débutées</span><input class="inputDroite" type="checkbox" value="ventesNonDebutees" id="ventesNonDebutees">
            <br>
            <input class="inputGauche" type="checkbox" value="mesEncheresRemportees" id="mesEncheresRemportees"> <span class="checkboxGauche">mes encheres remportées</span>
            <span class="checkboxDroite">ventes terminées</span><input class="inputDroite" type="checkbox" value="ventesTerminees" id="ventesTerminees">    
        
</div>
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
            var mesVentesEnCours = document.getElementById("mesVentesEnCours");
            mesVentesEnCours.checked = false;
            mesVentesEnCours.disabled = true;
        
            var ventesNonDebutees = document.getElementById("ventesNonDebutees");
            ventesNonDebutees.checked = false;
            ventesNonDebutees.disabled = true;
        
            var ventesTerminees = document.getElementById("ventesTerminees");
            ventesTerminees.checked = false;
            ventesTerminees.disabled = true;


            var encheresOuvertes = document.getElementById("encheresOuvertes");
                encheresOuvertes.checked = true;
                encheresOuvertes.disabled = false;
            
                var mesEncheres = document.getElementById("mesEncheres");
                mesEncheres.checked = true;
                mesEncheres.disabled = false;
            
                var mesEncheresRemportees = document.getElementById("mesEncheresRemportees");
                mesEncheresRemportees.checked = true;
                mesEncheresRemportees.disabled = false;
        }

            function onClickVentes() {
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
                mesVentesEnCours.checked = true;
                mesVentesEnCours.disabled = false;
        
                var ventesNonDebutees = document.getElementById("ventesNonDebutees");
                ventesNonDebutees.checked = true;
                ventesNonDebutees.disabled = false;
        
                var ventesTerminees = document.getElementById("ventesTerminees");
                ventesTerminees.checked = true;
                ventesTerminees.disabled = false;
            }

        </script>


    </body>
        

</html>
