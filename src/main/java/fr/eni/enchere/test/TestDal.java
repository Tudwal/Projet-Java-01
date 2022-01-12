package fr.eni.enchere.test;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.EnchereDAOFact;
import fr.eni.enchere.dal.jdbc.DALException;

public class TestDal {

	private static EnchereDAO dao = EnchereDAOFact.getInstance();
	
	public static void main(String[] args) throws DALException {
		
		dao.insertUtilisateur(new Utilisateur("dubix", "corlouer", "tudwal","tud.c@gmail.com", "0669627119", "3 square du menou", "35200", "rennes", "tud"));
		
		System.out.println(dao.getAllUtilisateur());

	}

}
