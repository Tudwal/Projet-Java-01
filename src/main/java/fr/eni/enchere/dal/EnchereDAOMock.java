package fr.eni.enchere.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public class EnchereDAOMock implements EnchereDAO {

	private static List<Utilisateur> lstUtilisateurs = new ArrayList<>();
	
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) {
		lstUtilisateurs.add(utilisateur);
		
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		return lstUtilisateurs;
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		for (Utilisateur u : lstUtilisateurs) {
			if (u.getNoUtilisateur().equals(utilisateur.getNoUtilisateur())) {
				u=utilisateur;
				lstUtilisateurs.add(u);
			}
		}
		
	}

	@Override
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException {
		//ceci est un test
		
	}

	@Override
	public Utilisateur getUnUtilisateur(Integer noUtilisateur) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertArticle(ArticleVendu article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> getAllArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getUneCategorie(Integer noCategorie) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
