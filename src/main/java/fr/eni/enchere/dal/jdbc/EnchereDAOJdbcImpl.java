package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private final static String INSERT_USER="INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_Passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String INSERT_ARTICLE="INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, etat_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?,?) ";
	private final static String SELECT_ALL_USER="SELECT * FROM UTILISATEURS";
	private final static String SELECT_ALL_ARTICLE="SELECT * FROM ARTICLES_VENDUS";
	private final static String UPDATE_USER="UPDATE UTILISATEURS SET pseudo = ? , nom = ? , prenom = ? , email = ? , telephone = ? , rue = ? , code_postal = ? , ville = ? , mot_de_Passe = ? , credit = ? , administrateur = ? WHERE no_utilisateur = ?";
	private final static String DELETE_USER="DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private final static String SELECT_USER="SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private final static String SELECT_CATEGORIE="SELECT * FROM CATEGORIES WHERE no_categorie = ?";
	
	
	/**
	 *Fonction permettant d'insérer un utilisateur dans la base de donnée
	 * @param utilisateur
	 * @throws DALException
	 */
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_USER, PreparedStatement.RETURN_GENERATED_KEYS);
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
			stmt.setInt(11, utilisateur.getAdministrateur());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				int id = rs.getInt(1);
				utilisateur.setNoUtilisateur(id);
			}
			System.out.println(utilisateur);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de conection insertUser");
		}
	}

	/**
	 *Fonction permettant d'insérer un article dans la base de donnée
	 */
	@Override
	public void insertArticle(ArticleVendu article) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setInt(6, article.getPrixVente());
			stmt.setString(7, article.getEtatVente());
			stmt.setInt(8, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(9, article.getCategorieArticle().getNoCategorie());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			//TO-DO AJOUT D'UN LIEU DE RETRAIT
			while (rs.next()) {
				int id = rs.getInt(1);
				article.setNoArticle(id);
			}
			System.out.println(article);
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de conection insertArticle");
		}
	}


	
	
	/**
	 *Fonction permettant de récupérer tout les utilisateurs présents dans la base de donnée
	 * @return List<Utilisateur>
	 * @throws DALException
	 */
	@Override
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
	
	/**
	 *Fonction permettant de récupérer une liste de tout les articles
	 */
	@Override
	public List<ArticleVendu> getAllArticles() throws DALException {
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ARTICLE);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = mapArticle(rs);
				lstArticles.add(article);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("probleme de connection getAll");
		}
		return lstArticles;
	}

	
	

	/**
	 *Fonction permettant de modifier les informations d'un utilisateur dans la base de donnée
	 * @param utilisateur
	 * @throws DALException
	 */
	@Override
	public void updateUtilisateur (Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(UPDATE_USER);
			
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
			stmt.setInt(11, utilisateur.getAdministrateur());
			stmt.setInt(12, utilisateur.getNoUtilisateur());

			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de modification de l'utilisateur");
		}
	}

	
	/**
	 *Fonction permettant de supprimer un utilisateur dans la base de donnée
	 * @param noUtilisateur
	 * @throws DALException
	 */
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(DELETE_USER);
			stmt.setInt(1, noUtilisateur);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de suppression de l'utilisateur");
		}
	}

	
	/**
	 *Fonction permettant de faire remonter le profil d'un utilisateur en fonction de son noUtilisateur
	 * @param noUtilisateur
	 * @return Utilisateur
	 * @throws DALException
	 */
	public Utilisateur getUnUtilisateur(Integer noUtilisateur) throws DALException {
		Utilisateur utilisateur = null;
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_USER);
			stmt.setInt(1, noUtilisateur);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				utilisateur = mapUtilisateur(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de récupération d'un utilisateur");
		}
		return utilisateur;
	}
	
	/**
	 *Fonction permettant de récupérer une catégorie
	 */
	public Categorie getUneCategorie(Integer noCategorie) throws DALException {
		Categorie categorie =null;
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_CATEGORIE);
			stmt.setInt(1, noCategorie);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String libelle = rs.getString("libelle");
				categorie.setLibelle(libelle);
				categorie.setNoCategorie(noCategorie);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de récupération d'une categorie");
		}
		return categorie;
	}
	
	
	
	
	/**
	 * Fonction permettant de charger toute les informations utilisateurs dans une map
	 * et de pouvoir s'en servir dans d'autres fonctions
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
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
		Integer administrateur = rs.getInt("administrateur");
		
		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
		
		return utilisateur;
	}

	/**
	 * Fonction permettant de charger toute les informations d'un article dans une map
	 * et de pouvoir s'en servir dans d'autres fonctions
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws DALException
	 */
	private ArticleVendu mapArticle(ResultSet rs) throws SQLException, DALException {
		ArticleVendu article = null;
		Integer noArticle = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDate dateDebutEnchere = rs.getDate("date_debut_encheres").toLocalDate();
		LocalDate dateFinEnchere = rs.getDate("date_fin_encheres").toLocalDate();
		Integer prixInitial = rs.getInt("prix_initial");
		Integer prixVente = rs.getInt("prix_vente");
		String etatVente = rs.getString("etat_vente");
		Integer noUtilisateur = rs.getInt("no_utilisateur");
		Integer noCategorie = rs.getInt("no_categorie");
		article.setUtilisateur(getUnUtilisateur(noUtilisateur));
		article.setCategorieArticle(getUneCategorie(noCategorie));
		Utilisateur utilisateur =  article.getUtilisateur();
		Categorie categorie = article.getCategorieArticle();
		//Retrait lieuRetrait = new Retrait(utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille());
		
		article = new ArticleVendu(utilisateur, categorie, noArticle, nomArticle, description, dateDebutEnchere, dateFinEnchere, prixInitial, prixVente, etatVente);
		return article;
	}
	

	
	
	
}
