package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface EnchereManager {

	/**
	 * Fonction permettant la création d'un compte Utilisateur après la verification
	 * de tout les champs renseigner par l'utilisateur On verifie aussi si le mot de
	 * passe "admin" est rentrée à la création du compte, dans ce cas le compte
	 * créer est un compte utilisateur
	 * @param utilisateur
	 * @throws BLLException
	 */
	public void creerCompte(Utilisateur utilisateur) throws BLLException;
	
	/**
	 * Fonction permettant de faire remonter la liste de tout les utilisateur qui
	 * ont crée un compte
	 * @return List<Utilisateur>
	 * @throws BLLException 
	 */
	public List<Utilisateur> afficherTousUtilisateurs() throws BLLException;
	
	/**
	 * Fonction permettant de vérifier dans la base de donnée si le pseudo ou
	 * l'email appartiennent à un utilisateur, on verifie aussi que le mot de passe
	 * soit le bon
	 * @param identifiant
	 * @param motDePasse
	 * @return boolean
	 * @throws BLLException 
	 */
	public Boolean seConnecter(String identifiant, String motDePasse) throws BLLException;
	
	/**
	 * Fonction permettant à un utilisateur de modifier les informations de son
	 * compte, des vérifications de conformiter des champs sont aussi effectués.
	 * @param utilisateur
	 * @throws BLLException
	 * @throws DALException
	 */
	public void modifCompte (Utilisateur utilisateur) throws BLLException;
	
	/**
	 *  Fonction permettant la suppression d'un compte uilisateur à partir de son
	 * numéro d'utilisateur.
	 * @param noUtilisateur
	 * @throws DALException
	 * @throws BLLException
	 */
	public void supprimerCompte (Integer noUtilisateur) throws BLLException;
	
	/**
	 * Fonction permettant d'afficher un profil utilisateur en fonction de son
	 * noUtilisateur
	 * @param noUtilisateur
	 * @return Utilisateur
	 * @throws DALException
	 */
	public Utilisateur afficherMonProfil (Integer noUtilisateur) throws BLLException;
	
	/**
	 * Fonction permettant de récupérer un utilisateur en fonction de son identifiant de connection
	 * @param identifiant
	 * @return
	 * @throws DALException
	 * @throws BLLException 
	 */
	public Utilisateur recupererUnProfil (String identifiant) throws BLLException;
	
}
