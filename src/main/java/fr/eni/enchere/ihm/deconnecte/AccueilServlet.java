package fr.eni.enchere.ihm.deconnecte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EnchereManager manager = EnchereManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AccueilModel Accueilmodel = new AccueilModel();

		request.getSession().invalidate();
		request.getSession().removeAttribute("model");
		
		if (request.getParameter("rechercher") != null) {
			String articleRecherche = request.getParameter("motClef");
			String categorie = request.getParameter("menuCategorie");
	
			//Accueilmodel.setLstArticles(manager.afficherArticlesParMotCle())
			//Accueilmodel.setLstArticles(manager.afficherArticlesParCategorie())
			
		}		
			

		
		// model.setLstArticles(manager.afficherArticles());

		request.setAttribute("Accueilmodel", Accueilmodel);
		request.getRequestDispatcher("WEB-INF/accueilCopie.jsp").forward(request, response);
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
