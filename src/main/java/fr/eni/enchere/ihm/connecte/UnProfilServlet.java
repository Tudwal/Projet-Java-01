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

/**
 * Servlet implementation class UnProfilServlet
 */
@WebServlet("/UnProfilServlet")
public class UnProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnProfilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer numeroUtilisateur = Integer.parseInt(request.getParameter("numUtilisateur"));
		System.out.println(numeroUtilisateur);
		try {
			((UtilisateurModel) request.getSession().getAttribute("model"))
					.setAutreUtilisateur(manager.afficherMonProfil(numeroUtilisateur));
		} catch (BLLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/afficherUnCompte.jsp").forward(request, response);
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
