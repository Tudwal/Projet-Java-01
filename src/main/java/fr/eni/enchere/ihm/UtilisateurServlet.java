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

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final Integer CREDIT_BASE = 100;
	final Byte ADMIN = 0;

       
	private EnchereManager manager = EnchereManagerSing.getInstance();
	
    
    public UtilisateurServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();
		
		if (request.getParameter("ajouter") != null) {
			
//			Integer noUtilisateur = Integer.parseInt(request.getParameter("noUtilisateur"));
			
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
			Byte administrateur = ADMIN;
			
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
			model.setUtilisateur(utilisateur);
	
			if (motDePasse.equals(confirmation)) {
				try {
					manager.creerCompte(utilisateur);
					System.out.println("OK VALIDER COMPTE");
				} catch (BLLException e) {
					model.setMessage("La création du compte n'est pas validée ");
				}
			} else {				
				model.setMessage("Le mdp doit être identique à la confirmation");
			}
			
			
		}
		
		System.out.println(manager.afficherTousUtilisateurs());
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/creationCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
