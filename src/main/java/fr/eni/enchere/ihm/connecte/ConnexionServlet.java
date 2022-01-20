package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.jdbc.DALException;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String adresse = "WEB-INF/connexionCompte.jsp";
	private EnchereManager manager = EnchereManagerSing.getInstance();

	public ConnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();
		
		if (adresse != "WEB-INF/connexionCompte.jsp") {
			adresse = "WEB-INF/connexionCompte.jsp";
		}

		if (request.getParameter("connexion") != null) {
			String identifiant = request.getParameter("identifiant");
			String motDePasse = request.getParameter("motDePasse");

			try {
				if (manager.seConnecter(identifiant, motDePasse)) {
					adresse = "WEB-INF/accueilConnecte.jsp";
					HttpSession session = request.getSession();
					model.setUtilisateur(manager.recupererUnProfil(identifiant));
					session.setAttribute("model", model);
				} else {
					model.setMessage("L'identifiant et/ou le mdp est invalide");
					System.out.println(model.getMessage());
				}
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher(adresse).forward(request, response);

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
