package fr.eni.enchere.test;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestIHM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//test insertion user CONCLUANT
//		try {
//			dao.insertUtilisateur(new Utilisateur("dubix", "corlouer", "tudwal","tud.c@gmail.com", "0669627119", "3 square du menou", "35200", "rennes", "tud", 100, 1));
//		} catch (DALException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//test insertion article CONCLUANT
		try {
			Utilisateur utilisateur = dao.getUnUtilisateur(21);
			Categorie cat = dao.getUneCategorie(1);
			ArticleVendu art = new ArticleVendu(utilisateur,cat ,"PC g@m3rz de ouf", "pc de ouf malade", LocalDate.now(), LocalDate.now().plusDays(4), 600, null, "EC");
			dao.insertArticle(art, utilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
