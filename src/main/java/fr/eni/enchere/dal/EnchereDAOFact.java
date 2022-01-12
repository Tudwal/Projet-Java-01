package fr.eni.enchere.dal;

import fr.eni.enchere.dal.jdbc.EnchereDAOJdbcImpl;

public class EnchereDAOFact {
	public static EnchereDAO getInstance( ) {
		return new EnchereDAOJdbcImpl();
	}
	
}
