package fr.eni.enchere.ihm.deconnecte;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
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
		AccueilModel accueilModel = new AccueilModel();
		String articleRecherche = null;
		Integer numCategorie = null;

		request.getSession().invalidate();
		request.getSession().removeAttribute("model");

		if (request.getParameter("rechercher") != null) {
			if (request.getParameter("motClef") != null) {
				articleRecherche = request.getParameter("motClef");
			}
			if (request.getParameter("menuCategorie") != null) {
				numCategorie = Integer.parseInt(request.getParameter("menuCategorie"));
				if (numCategorie == 0) {
					numCategorie = null;
				}
			}

			try {
				accueilModel.setLstArticles(manager.moteurDeRechercheDeconnecter(numCategorie, "EC", articleRecherche));
			} catch (BLLException e) {
				e.printStackTrace();
			}

		}

		// model.setLstArticles(manager.afficherArticles());

		request.setAttribute("accueilmodel", accueilModel);
		request.getRequestDispatcher("WEB-INF/accueil.jsp").forward(request, response);
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
