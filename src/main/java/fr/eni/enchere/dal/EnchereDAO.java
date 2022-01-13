package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface EnchereDAO {

	/**
	 * Fonction permettant d'insérer un utilisateur dans la base de donnée
	 * @param utilisateur
	 * @throws DALException
	 */
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException;
	
	/**
	 * Fonction permettant de récupérer tout les utilisateurs présents dans la base de donnée
	 * @return List<Utilisateur>
	 * @throws DALException
	 */
	public List<Utilisateur> getAllUtilisateur() throws DALException;
	
	/**
	 * Fonction permettant de modifier les informations d'un utilisateur dans la base de donnée
	 * @param utilisateur
	 * @throws DALException
	 */
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException;
	
	/**
	 * Fonction permettant de supprimer un utilisateur dans la base de donnée
	 * @param noUtilisateur
	 * @throws DALException
	 */
	public void deleteUtilisateur (Integer noUtilisateur) throws DALException;
	
	/**
	 * Fonction permettant de faire remonter le profil d'un utilisateur en fonction de son noUtilisateur
	 * @param noUtilisateur
	 * @return Utilisateur
	 * @throws DALException
	 */
	public Utilisateur getUnUtilisateur(Integer noUtilisateur) throws DALException;
}
