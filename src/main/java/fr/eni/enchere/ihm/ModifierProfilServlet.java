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

	private String adresse = "WEB-INF/modifierCompte.jsp";

	Utilisateur utilisateur = new Utilisateur();

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

			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");
			String nouveauMotDePasse = request.getParameter("nouveauMotDePasse");
			String confirmation = request.getParameter("confirmation");

			utilisateur = new Utilisateur(5, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, 100, 0);

			if (nouveauMotDePasse != null) {
				if (nouveauMotDePasse.equals(confirmation)) {
					utilisateur.setMotDePasse(nouveauMotDePasse);
				}
			}

			try {
				manager.modifCompte(utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			try {
				System.out.println(manager.afficherTousUtilisateurs());
			} catch (BLLException e) {
				// TODO Auto-generated catch block
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
