package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateur;

public interface EnchereManager {

	public void creerCompte(Utilisateur utilisateur) throws BLLException;
	
}
