package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private final static String INSERT_USER="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_Passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String SELECT_ALL_USER="SELECT * FROM UTILISATEURS";
	
	/*Permet l'insertion d'un utilisateur dans la base de donnée
	 * 
	 */
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_USER);
			stmt.setString(1, utilisateur.getPseudo());
			stmt.setString(2, utilisateur.getNom());
			stmt.setString(3, utilisateur.getPrenom());
			stmt.setString(4, utilisateur.getEmail());
			stmt.setString(5, utilisateur.getTelephone());
			stmt.setString(6, utilisateur.getRue());
			stmt.setString(7, utilisateur.getCodePostal());
			stmt.setString(8, utilisateur.getVille());
			stmt.setString(9, utilisateur.getMotDePasse());
			stmt.setInt(10, utilisateur.getCredit());
			stmt.setByte(11, utilisateur.getAdministrateur());
			stmt.executeUpdate();
			System.out.println(utilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de conection insertUser");
		}
	}

	/*Permet de récupérer la liste de tout les utilisateurs
	 * 
	 */
	public List<Utilisateur> getAllUtilisateur() throws DALException {
		List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_USER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = mapUtilisateur(rs);
				lstUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("probleme de connection getAll");
		}
		return lstUtilisateurs;
	}

	private Utilisateur mapUtilisateur(ResultSet rs) throws SQLException {
		Integer noUtilisateur = rs.getInt("no_utilisateur");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String rue = rs.getString("rue");
		String codePostal = rs.getString("code_postal");
		String ville = rs.getString("ville");
		String motDePasse = rs.getString("mot_de_passe");
		Integer credit = rs.getInt("credit");
		Byte administrateur = rs.getByte("administrateur");
		
		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		
		return utilisateur;
	}
	
	
}
