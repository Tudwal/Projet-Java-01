package fr.eni.enchere.test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.EnchereDAOFact;
import fr.eni.enchere.dal.jdbc.DALException;

/**
 * Servlet implementation class TestIHM
 */
@WebServlet("/TestIHM")
public class TestIHM extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static EnchereDAO dao = EnchereDAOFact.getInstance();
	private static EnchereManager manager = EnchereManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestIHM() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Insérer Utilisateur  FONCTIONNE
		
//		Utilisateur user = new Utilisateur("Bud Stepper","Corlouer", "Tudwal", "tudwal.c@gmail.com", "0669627119", "3 square du menou", "35200", "Rennes", "admin");
//		try {
//			manager.creerCompte(user);
//		} catch (BLLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		// Ajouter article  FONCTIONNE
		
//	try {
//		Utilisateur user = dao.getUnUtilisateur(31);
//		Categorie cat = dao.getUneCategorie(1);
//		ArticleVendu art = new ArticleVendu(user, cat, "Controleur akai 2","petit controleur USB, idéal pour tout les liveurs", LocalDate.now(),LocalDate.now().plusDays(5), 45, null, null );
//		
//			manager.creerUnArticle(art);
//		} catch (BLLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		//test modif etat vente   FONCTIONNE
		
		try {
			System.out.println(manager.consulterArticles());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//test enchere  FONCTIONNE
		
//		try {
//			ArticleVendu article = dao.getUnArticle(3);
//			Utilisateur user = dao.getUnUtilisateur(31);
//			Date date = new Date(System.currentTimeMillis());
//			Enchere enchere = new Enchere(article,user,date,51);
//			manager.encherire(enchere);
//		} catch (BLLException | DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		//test remporter une enchere
		
//		try {
//			ArticleVendu article = dao.getUnArticle(5);
//			Utilisateur user = dao.getUnUtilisateur(31);
//			Date date = new Date(System.currentTimeMillis());
//			Enchere enchere = new Enchere(article,user,date,26);
//			manager.encherire(enchere);
//		} catch (BLLException | DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		manager.moteurDeRechercheConnecter(null, 1, null, null));
//		System.out.println(manager.getLstArticles());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
