package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Manager;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class UneVenteServlet
 */
@WebServlet("/UneVenteServlet")
public class UneVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EnchereManager manager = EnchereManagerSing.getInstance();
	int compteur = 0;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UneVenteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer numArticle = null;
//		if (compteur == 0) {
			numArticle = Integer.parseInt(request.getParameter("numArticle")) ;
//			compteur++;
//		}
		
		
		Enchere enchereEnCours = new Enchere();
		try {
			enchereEnCours = manager.recupererTopEnchere(numArticle);
		} catch (BLLException e2) {

			e2.printStackTrace();
		}
		
		((UtilisateurModel)request.getSession().getAttribute("model")).setEnchere(enchereEnCours);
		
		ArticleVendu article = new ArticleVendu();
		try {
			article = manager.recupererUnArticle(numArticle);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		
		((UtilisateurModel)request.getSession().getAttribute("model")).setArticleVendu(article);
		

		if (request.getParameter("encherir") != null) {
			Integer numeroArticle = Integer.parseInt(request.getParameter("numArticle"));
			try {
				((UtilisateurModel)request.getSession().getAttribute("model")).setArticleVendu(manager.recupererUnArticle(numeroArticle));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			Integer montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));
			Utilisateur acheteur = ((UtilisateurModel) request.getSession().getAttribute("model")).getUtilisateur();
			article = ((UtilisateurModel) request.getSession().getAttribute("model")).getArticleVendu();
			Date dateEnchere = new Date(System.currentTimeMillis());

			Enchere nouvelleEnchere = new Enchere(article, acheteur, dateEnchere, montantEnchere);
			try {
				manager.encherire(nouvelleEnchere);
			} catch (BLLException e) {
				e.printStackTrace();
			}

		}

		request.getRequestDispatcher("WEB-INF/afficherArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
