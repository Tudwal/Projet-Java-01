package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.ihm.deconnecte.AccueilModel;

/**
 * Servlet implementation class AccueilConnecte
 */
@WebServlet("/AccueilConnecteServlet")
public class AccueilConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EnchereManager manager = EnchereManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilConnecteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");

		if (request.getParameter("rechercher") != null) {
//			if (request.getParameter("motClef") != null) {
//				String articleRecherche = request.getParameter("motClef");
//			}
//				if (request.getParameter("menuCategorie") != null) {
//					Integer categorie = Integer.parseInt(request.getParameter("menuCategorie"));
//				}
			try {
				model.setLstArticles(manager.consulterArticles());
				System.out.println(model.getLstArticles());
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/accueilConnecte.jsp").forward(request, response);
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
