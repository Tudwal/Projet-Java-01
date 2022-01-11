package fr.eni.enchere.dal;

public class EnchereDAOFact {
	public static EnchereDAO getInstance( ) {
		return new EnchereDAOMock();
	}
	
}
