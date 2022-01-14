package fr.eni.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

/**
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ModifierProfilServlet")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EnchereManager manager = EnchereManagerSing.getInstance();

	private String adresse = "WEB-INF/afficherCompte.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierProfilServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("supprimer") != null) {
			Integer noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));

			try {
				manager.supprimerCompte(noUtilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			adresse = "WEB-INF/accueil.jsp";
		}

		if (request.getParameter("enregistrer") != null) {
			Integer noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
			adresse = "WEB-INF/accueil.jsp";
		}

		// TODO Test avec Erwan 13h30 13.01
//			if (request.getParameter("enregistrer")!= null) {
//				try {
//					manager.modifCompte(utilisateur)
//				} catch (DALException e) {
//					e.printStackTrace();
//				} catch (BLLException e) {
//					e.printStackTrace();
//				}
//				
//			}

		request.getRequestDispatcher("WEB-INF/modifierCompte.jsp").forward(request, response);
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
