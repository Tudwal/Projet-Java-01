<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion Compte</title>
    
    <style><%@includefile="/WEB-INF/CSS/connexionCompte.css"%></style>
    
    <link href="creationCompte.css" rel="stylesheet">

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    
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
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="InscriptionServlet">S'inscrire</a></li>                    
					</ul>
                </div>
            </div>
        </nav>
        

        <form action="ConnexionServlet" method="POST">

        <h1 class="a11y-hidden">Login Form</h1>
        <div>
          <label class="label-email">
            <input type="text" class="text" name="identifiant" placeholder="Identifiant" tabindex="1" value="${model.utilisateur.pseudo}" />
            <span class="required">Identifiant</span>
          </label>
        </div>
        <input type="checkbox" name="show-password" class="show-password a11y-hidden" id="show-password" tabindex="3" />
        <label class="label-show-password" for="show-password">
          <span>Se souvenir de moi</span>
        </label>
        <div>
          <label class="label-password">
            <input type="password" class="text" name="motDePasse" placeholder="Mot de passe" tabindex="2" value="${model.utilisateur.motDePasse}" />
            <span class="required">Mot de Passe</span>
          </label>
        </div>
        <input type="submit" name="connexion" value="Connexion" />
        <div class="email">
          <a href="mailto:email@exemple.com?subject=subject text">Mot de passe oublié</a>          
        </div>
                
        <figure aria-hidden="true">
          <div class="person-body"></div>
          <div class="neck skin"></div>
          <div class="head skin">
            <div class="eyes"></div>
            <div class="mouth"></div>
          </div>
          <div class="hair"></div>
          <div class="ears"></div>
          <div class="shirt-1"></div>
          <div class="shirt-2"></div>
        </figure>
      </form>
      
     
     
     	<span>${model.message}</span>
   
      
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