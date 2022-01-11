package fr.eni.enchere.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;

public class EnchereDAOMock implements EnchereDAO {

	private static List<Utilisateur> lstUtilisateurs = new ArrayList<>();
	
	@Override
	public void insert(Utilisateur utilisateur) {
		lstUtilisateurs.add(utilisateur);
		
	}

	@Override
	public List<Utilisateur> getAll() {
		return lstUtilisateurs;
	}

}
