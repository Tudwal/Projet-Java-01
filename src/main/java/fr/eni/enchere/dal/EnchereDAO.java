package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
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
	 * Fonction permettant d'insérer un article dans la base de donnée
	 * @param article
	 * @throws DALException 
	 */
	public void insertArticle(ArticleVendu article) throws DALException;
	
	/**
	 * Fonction permettant d'insérer une enchère dans la base de donnée
	 * @param enchere
	 * @throws DALException
	 */
	public void insertEnchere(Enchere enchere) throws DALException;
	
	/**
	 * Fonction permettant de récupérer tout les utilisateurs présents dans la base de donnée
	 * @return List<Utilisateur>
	 * @throws DALException
	 */
	public List<Utilisateur> getAllUtilisateur() throws DALException;
	
	/**
	 * Fonction permettant de récupérer tout les articles présent dans la base de donnée
	 * @return List<ArticleVendu>
	 * @throws DALException 
	 */
	public List<ArticleVendu> getAllArticles() throws DALException;
	
	public List<Enchere> getAllEnchere() throws DALException;
	
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
	
	public void updateArticle(ArticleVendu article) throws DALException;
	
	public void deleteArticle(Integer noArticle) throws DALException;
	
	/**
	 * Fonction permettant de faire remonter le profil d'un utilisateur en fonction de son noUtilisateur
	 * @param noUtilisateur
	 * @return Utilisateur
	 * @throws DALException
	 */
	public Utilisateur getUnUtilisateur(Integer noUtilisateur) throws DALException;

	/**
	 * Fonction permettant de faire remonter une catégorie d'article en fonction de son noCategorie
	 * @param noCategorie
	 * @return
	 * @throws DALException
	 */
	public Categorie getUneCategorie(Integer noCategorie) throws DALException;
	
	/**
	 * Fonction permettant de faire remonter une enchère grâce à son noEnchere
	 * @param noEnchere
	 * @return
	 * @throws DALException 
	 */
	public Enchere getUneEnchere (Integer noEnchere) throws DALException;

	/**
	 * Fonction permettant de récupérer la meilleur enchère sur un article
	 * @param noArticle
	 * @return
	 * @throws DALException 
	 */
	public Enchere getTopEnchere (Integer noArticle) throws DALException;
	
	/**
	 * Fonction permettant de faire remonter un article en fonction de son noArticle
	 * @param noArticle
	 * @return
	 * @throws DALException
	 */
	public ArticleVendu getUnArticle (Integer noArticle) throws DALException;
}
