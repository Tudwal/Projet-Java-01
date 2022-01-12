package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface EnchereDAO {

	public void insertUtilisateur(Utilisateur utilisateur) throws DALException;
	
	public List<Utilisateur> getAllUtilisateur() throws DALException;
}
