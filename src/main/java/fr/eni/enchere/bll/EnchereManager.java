package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface EnchereManager {

	public void creerCompte(Utilisateur utilisateur) throws BLLException;
	
	public List<Utilisateur> afficherTousUtilisateurs();
	
	public Boolean seConnecter(String identifiant, String motDePasse);
	
	public void modifCompte (Utilisateur utilisateur) throws BLLException, DALException;
	
	public void supprimerCompte (Integer noUtilisateur) throws DALException, BLLException;
	
	public Utilisateur afficherMonProfil (Integer noUtilisateur) throws DALException;
	
}
