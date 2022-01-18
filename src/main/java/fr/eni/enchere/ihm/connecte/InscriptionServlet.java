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
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/InscriptionServlet")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String adresse = "WEB-INF/creationCompteCopie.jsp";

	final Integer CREDIT_BASE = 100;
	final Integer ADMIN = 0;

	private EnchereManager manager = EnchereManagerSing.getInstance();

	public InscriptionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();

		if (request.getParameter("ajouter") != null) {
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");
			String confirmation = request.getParameter("confirmation");
			Integer credit = CREDIT_BASE;
			Integer administrateur = ADMIN;

			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, credit, administrateur);
			model.setUtilisateur(utilisateur);

			if (motDePasse.equals(confirmation)) {
				try {
					manager.creerCompte(utilisateur);
					System.out.println("OK VALIDER COMPTE");
					adresse = "AccueilConnecteServlet";

				} catch (BLLException e) {
					model.setMessage("La création du compte n'est pas validée ");
				}
			} else {
				model.setMessage("Le mdp doit être identique à la confirmation");
			}
		}

		request.setAttribute("model", model);
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
