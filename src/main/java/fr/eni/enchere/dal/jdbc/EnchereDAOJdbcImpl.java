package fr.eni.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {

	private final static String INSERT_USER = "INSERT INTO UTILISATEURS(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_Passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final static String INSERT_ARTICLE = "INSERT INTO ARTICLES_VENDUS(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, etat_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?) ";
	private final static String INSERT_RETRAIT = "INSERT INTO RETRAITS(no_article, rue, code_postal, ville) VALUES(?,?,?,?)";
	private final static String INSERT_ENCHERE = "INSERT INTO ENCHERES(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private final static String SELECT_ALL_USER = "SELECT * FROM UTILISATEURS";
	private final static String SELECT_ALL_ARTICLE = "SELECT * FROM ARTICLES_VENDUS";
	private final static String SELECT_ALL_ENCHERE = "SELECT * FROM ENCHERES";
	private final static String UPDATE_USER = "UPDATE UTILISATEURS SET pseudo = ? , nom = ? , prenom = ? , email = ? , telephone = ? , rue = ? , code_postal = ? , ville = ? , mot_de_Passe = ? , credit = ? , administrateur = ? WHERE no_utilisateur = ?";
	private final static String DELETE_USER = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ?";
	private final static String UPDATE_ARTICLE="UPDATE ARTICLES_VENDUS SET prix_vente = ?, etat_vente=? WHERE no_article=?";
	private final static String DELETE_ARTICLE="DELETE FROM ARTICLES_VENDUS WHERE no_article=?";
	private final static String SELECT_UN_USER = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
	private final static String SELECT_UN_ARTICLE ="SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	private final static String SELECT_UNE_CATEGORIE = "SELECT * FROM CATEGORIES WHERE no_categorie = ?";
	private final static String SELECT_UNE_ENCHERE = "SELECT * FROM ENCHERES WHERE no_enchere=?";
	private final static String SELECT_TOP_ENCHERE = "SELECT TOP 1 * FROM ENCHERES WHERE no_article=? ORDER BY montant_enchere desc" ;

	/**
	 * Fonction permettant d'insérer un utilisateur dans la base de donnée
	 * 
	 * @param utilisateur
	 * @throws DALException
	 */
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
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
			throw new DALException("problème de conection insertUtilisateur");
		}
	}

	/**
	 * Fonction permettant d'insérer un article dans la base de donnée
	 */
	@Override
	public void insertArticle(ArticleVendu article) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getNomArticle());
			stmt.setString(2, article.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(article.getDateDebutEncheres()));
			stmt.setDate(4, java.sql.Date.valueOf(article.getDateFinEncheres()));
			stmt.setInt(5, article.getMiseAPrix());
			stmt.setString(6, article.getEtatVente());
			stmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			stmt.setInt(8, article.getCategorieArticle().getNoCategorie());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				int id = rs.getInt(1);
				article.setNoArticle(id);

			}
			System.out.println(article);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de conection insertArticle");
		}
		Retrait lieuRetrait = new Retrait();
		lieuRetrait.setRue(article.getUtilisateur().getRue());
		lieuRetrait.setCodePostal(article.getUtilisateur().getCodePostal());
		lieuRetrait.setVille(article.getUtilisateur().getVille());
		lieuRetrait.setArticleVendu(article);
		insertLieuRetrait(lieuRetrait);

	}

	/**
	 * Fonction permettant d'insérer un lieu de retrait dans la base de donnée.
	 * @param lieuRetrait
	 * @throws DALException
	 */
	public void insertLieuRetrait(Retrait lieuRetrait) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT_RETRAIT);
			stmt.setInt(1, lieuRetrait.getArticleVendu().getNoArticle());
			stmt.setString(2, lieuRetrait.getRue());
			stmt.setString(3, lieuRetrait.getCodePostal());
			stmt.setString(4, lieuRetrait.getVille());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de conection insertLieuRetrait");
		}
	}
	
	/**
	 *Fonction permettant d'insérer une nouvelle enchère dans la base de donnée.
	 *@param enchere
	 *@throws DALException
	 */
	@Override
	public void insertEnchere(Enchere enchere) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(INSERT_ENCHERE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setTimestamp(1, new Timestamp(enchere.getDateEnchere().getTime()));
			stmt.setInt(2, enchere.getMontantEnchere());
			stmt.setInt(3, enchere.getArticleVendu().getNoArticle());
			stmt.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				int id = rs.getInt(1);
				enchere.setNoEnchere(id);

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de conection insertEnchere");
		}
		
	}
	
	
	
	/**
	 * Fonction permettant de récupérer tout les utilisateurs présents dans la base
	 * de donnée
	 * 
	 * @return List<Utilisateur>
	 * @throws DALException
	 */
	@Override
	public List<Utilisateur> getAllUtilisateur() throws DALException {
		List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_USER);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Utilisateur utilisateur = mapUtilisateur(rs);
				lstUtilisateurs.add(utilisateur);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("probleme de connection getAllUtilisateur");
		}
		return lstUtilisateurs;
	}

	/**
	 * Fonction permettant de récupérer une liste de tout les articles
	 */
	@Override
	public List<ArticleVendu> getAllArticles() throws DALException {
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ARTICLE);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu article = mapArticle(rs);
				lstArticles.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("probleme de connection getAllArticle");
		}
		return lstArticles;
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		List<Enchere> lstEncheres = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_ALL_ENCHERE);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Enchere enchere = mapEnchere(rs);
				lstEncheres.add(enchere);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("probleme de connection getAllEnchere");
		}
		return lstEncheres;
	}
	
	
	/**
	 * Fonction permettant de modifier les informations d'un utilisateur dans la
	 * base de donnée
	 * 
	 * @param utilisateur
	 * @throws DALException
	 */
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
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
	 * Fonction permettant de supprimer un utilisateur dans la base de donnée
	 * 
	 * @param noUtilisateur
	 * @throws DALException
	 */
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE_USER);
			stmt.setInt(1, noUtilisateur);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de suppression de l'utilisateur");
		}
	}

	
	@Override
	public void updateArticle(ArticleVendu article) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt =  con.prepareStatement(UPDATE_ARTICLE);
			
			stmt.setInt(1, article.getPrixVente());
			stmt.setString(2, article.getEtatVente());
			
			stmt.setInt(3, article.getNoArticle());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de modification de l'article");
		}
		
	}

	@Override
	public void deleteArticle(Integer noArticle) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE_ARTICLE);
			stmt.setInt(1, noArticle);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de suppression de l'article");
		}
		
	}
	
	
	/**
	 * Fonction permettant de faire remonter le profil d'un utilisateur en fonction
	 * de son noUtilisateur
	 * 
	 * @param noUtilisateur
	 * @return Utilisateur
	 * @throws DALException
	 */
	public Utilisateur getUnUtilisateur(Integer noUtilisateur) throws DALException {
		Utilisateur utilisateur = null;

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_UN_USER);
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
	 * Fonction permettant de récupérer une catégorie
	 */
	public Categorie getUneCategorie(Integer noCategorie) throws DALException {
		Categorie categorie = null;

		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_UNE_CATEGORIE);
			stmt.setInt(1, noCategorie);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				categorie = mapCat(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de récupération d'une categorie");
		}
		return categorie;
	}
	
	/**
	 *Fonction permettant de récupérer une enchère dans la base de donnée
	 */
	@Override
	public Enchere getUneEnchere(Integer noEnchere) throws DALException {
		Enchere enchere = new Enchere();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_UNE_ENCHERE);
			stmt.setInt(1, noEnchere);
			ResultSet rs =stmt.executeQuery();
			while (rs.next()) {
				enchere = mapEnchere(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de récupération d'une enchere");
		}
		return enchere;
	}
	
	/**
	 *Fonction permettant de faire remonter la meilleur enchère sur un article
	 */
	@Override
	public Enchere getTopEnchere(Integer noArticle) throws DALException {
		Enchere enchere = new Enchere();
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement stmt = con.prepareStatement(SELECT_TOP_ENCHERE);
			stmt.setInt(1, noArticle);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				enchere = mapEnchere(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de récupération de la meilleure enchere");
		}
		return enchere;
	}
	
	/**
	 * Fonction permettant de récupérer un article dans la base de donnée
	 * @param noArticle
	 * @return
	 * @throws DALException
	 */
	public ArticleVendu getUnArticle(Integer noArticle) throws DALException {
		
		ArticleVendu article = null;
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECT_UN_ARTICLE);
			stmt.setInt(1, noArticle);
			ResultSet rs =stmt.executeQuery();
			while (rs.next()) {
				article = mapArticle(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("problème de récupération d'un article");
		}
		return article;
	}
	
	

	
	
	/**
	 * Fonction permettant de charger toute les informations d'une enchère dans une map
	 * et de pouvoir s'en servir dans d'autres fonctions
	 * @param rs
	 * @return
	 * @throws SQLException
	 * @throws DALException
	 */
	private Enchere mapEnchere(ResultSet rs) throws SQLException, DALException {
		Enchere enchere = new Enchere();
		Integer noEnchere = rs.getInt("no_enchere");
		java.util.Date dateEnchere = rs.getTimestamp("date_enchere");
		Integer montantEnchere = rs.getInt("montant_enchere");
		Integer noArticle = rs.getInt("no_article");
		Integer noUtilisateur = rs.getInt("no_utilisateur");
		enchere.setUtilisateur(getUnUtilisateur(noUtilisateur));
		enchere.setArticleVendu(getUnArticle(noArticle));
		Utilisateur utilisateur = enchere.getUtilisateur();
		ArticleVendu article = enchere.getArticleVendu();
		enchere = new Enchere(article, utilisateur, noEnchere, dateEnchere, montantEnchere);
		return enchere;
	}

	/**
	 * Fonction permettant de charger toute les informations d'un article dans une
	 * map et de pouvoir s'en servir dans d'autres fonctions
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private Categorie mapCat(ResultSet rs) throws SQLException {
		Integer noCategorie = rs.getInt("no_categorie");
		String libelle = rs.getString("libelle");

		Categorie cat = new Categorie(noCategorie, libelle);
		return cat;
	}

	/**
	 * Fonction permettant de charger toute les informations utilisateurs dans une
	 * map et de pouvoir s'en servir dans d'autres fonctions
	 * 
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

		Utilisateur utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal,
				ville, motDePasse, credit, administrateur);

		return utilisateur;
	}

	/**
	 * Fonction permettant de charger toute les informations d'un article dans une
	 * map et de pouvoir s'en servir dans d'autres fonctions
	 * 
	 * @param rs
	 * @return article
	 * @throws SQLException
	 * @throws DALException
	 */
	private ArticleVendu mapArticle(ResultSet rs) throws SQLException, DALException {
		ArticleVendu article = new ArticleVendu();
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
		Utilisateur utilisateur = article.getUtilisateur();
		Categorie categorie = article.getCategorieArticle();
		Retrait lieuRetrait = new Retrait(utilisateur.getRue(),
		utilisateur.getCodePostal(), utilisateur.getVille());

		article = new ArticleVendu(utilisateur, categorie, lieuRetrait, noArticle, nomArticle, description, dateDebutEnchere,
				dateFinEnchere, prixInitial, prixVente, etatVente);
		return article;
	}

	

	

	

	
	
	
	
	

	

}
