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
		
		//test moteur de recherche
		
//		try {
//			System.out.println(manager.moteurDeRecherche(4, "EC", "bal"));
//		} catch (BLLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
//		try {
//			System.out.println(manager.rechercheParMotClefs("BAL"));
//		} catch (BLLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
		
		// test insertion user CONCLUANT
//		try {
//			dao.insertUtilisateur(new Utilisateur("dubix", "corlouer", "tudwal","tud.c@gmail.com", "0669627119", "3 square du menou", "35200", "rennes", "tud", 100, 1));
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// test insertion article CONCLUANT
//		try {
//			Utilisateur utilisateur = dao.getUnUtilisateur(5);
//			Categorie cat = dao.getUneCategorie(4);
//			ArticleVendu art = new ArticleVendu(utilisateur, cat, "ballon de foot et de tennis", "bleu et blanc et accroche bien",
//					LocalDate.now(), LocalDate.now().plusDays(4), 25, null, "EC");
//			dao.insertArticle(art);
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//test participation à une enchère CONCLUANT
		 
		//via bll
		Utilisateur user;
		try {
			user = dao.getUnUtilisateur(12);
			System.out.println(user);
			ArticleVendu art = dao.getUnArticle(5);
			System.out.println(art);
			
			Enchere enchere = new Enchere(art, user , new Date(System.currentTimeMillis()), 365 );
			try {
				manager.encherire(enchere);
				System.out.println(dao.getTopEnchere(5));
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// via la dal
//		try {
//			Utilisateur user = dao.getUnUtilisateur(12);
//			System.out.println(user);
//			ArticleVendu art = dao.getUnArticle(1);
//			System.out.println(art);
////			Categorie cat = dao.getUneCategorie(4);
////			System.out.println(cat);
//			
//			
//			Enchere enchere = new Enchere(art, user , LocalDate.now(), 350 );
//			dao.insertEnchere(enchere);
////			System.out.println(dao.getUneEnchere(2));
//		} catch (DALException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		try {
//			System.out.println(dao.getTopEnchere(1));
//			
//		} catch (DALException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		// test remonter une catégorie CONCLUANT
//		try {
//			System.out.println(dao.getUneCategorie(2));
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

//		System.out.println(manager.afficherMonProfil(1));
//		Utilisateur utilisateur;
//		try {
//			utilisateur = manager.afficherMonProfil(1);
//			utilisateur.setCodePostal("45200");
//			try {
//				manager.supprimerCompte(1);
//			} catch (BLLException e) {
//				e.printStackTrace();
//			}
//			System.out.println(manager.afficherMonProfil(1));

//		manager.modifCompte(utilisateur);
//		System.out.println(manager.afficherMonProfil(1));
//		
//		} 

		// Test ajout d'un article depuis le manager

//		Categorie cat;
//		try {
//			cat = dao.getUneCategorie(4);
//			try {
//				manager.creerUnArticle(new ArticleVendu(manager.afficherMonProfil(21), cat, "boite de volant",
//						"plume d'oie véritable", LocalDate.now(), LocalDate.now().plusDays(2), 30, "EA"));
//			} catch (BLLException e) {
//				e.printStackTrace();
//			}
//		} catch (DALException e) {
//			e.printStackTrace();
//		}

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
