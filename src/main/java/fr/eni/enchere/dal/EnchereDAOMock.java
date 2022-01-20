package fr.eni.enchere.dal;

import java.util.ArrayList;
import java.util.List;
 
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public class EnchereDAOMock implements EnchereDAO {

	private static List<Utilisateur> lstUtilisateurs = new ArrayList<>();

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertArticle(ArticleVendu article) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> getAllArticles() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur getUnUtilisateur(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getUneCategorie(Integer noCategorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere getUneEnchere(Integer noEnchere) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enchere getTopEnchere(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu getUnArticle(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateArticle(ArticleVendu article) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(Integer noArticle) throws DALException {
		// TODO Auto-generated method stub
		
	}
	


}
