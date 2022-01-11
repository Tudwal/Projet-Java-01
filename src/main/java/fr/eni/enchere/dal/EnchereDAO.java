package fr.eni.enchere.dal;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public interface EnchereDAO {

	public void insertUtilisateur(Utilisateur utilisateur);
	
	public List<Utilisateur> getAll();
}
