package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
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
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class UneVenteServlet
 */
@WebServlet("/UneVenteServlet")
public class UneVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EnchereManager manager = EnchereManagerSing.getInstance();

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

		if (request.getParameter("encherir") != null) {
			Integer montantEnchere = Integer.parseInt(request.getParameter("montantEnchere"));
			Utilisateur acheteur = ((UtilisateurModel) request.getSession().getAttribute("model")).getUtilisateur();
			ArticleVendu article = ((UtilisateurModel) request.getSession().getAttribute("model")).getArticleVendu();
			Date dateEnchere = new Date(System.currentTimeMillis());

			Enchere enchere = new Enchere(article, acheteur, dateEnchere, montantEnchere);
			try {
				manager.encherire(enchere);
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
