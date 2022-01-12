package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

public interface EnchereDAO {

	public void insertUtilisateur(Utilisateur utilisateur) throws DALException;
	
	public List<Utilisateur> getAllUtilisateur() throws DALException;
	
	public void update(Utilisateur utilisateur);
	
	public void delete (Integer noUtilisateur);
	
	public Utilisateur getUnUtilisateur(Integer noUtilisateur);
}
