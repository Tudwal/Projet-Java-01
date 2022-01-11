package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public interface EnchereManager {

	void creerCompte(Utilisateur utilisateur) throws BLLException;
	
	List<Utilisateur> afficherTousUtilisateurs();
	
	Boolean seConnecter(String identifiant, String motDePasse);
	
}
