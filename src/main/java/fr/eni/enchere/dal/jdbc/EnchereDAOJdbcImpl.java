package fr.eni.enchere.dal.jdbc;

public class EnchereDAOJdbcImpl {

	private final static String INSERT_USER="INSERT INTO utilisateurs(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_ALL_USER="SELECT * FROM utilisateurs";


}
