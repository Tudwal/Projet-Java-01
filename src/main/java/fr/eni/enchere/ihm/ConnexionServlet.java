package fr.eni.enchere.ihm;

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
	private String adresse ="WEB-INF/connexionCompte.jsp";
       
	private EnchereManager manager = EnchereManagerSing.getInstance();

	
	public ConnexionServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurModel model = new UtilisateurModel();
		
//		PrintWriter pw = response.getWriter();
//		response.setContentType("text/plain");
		
		
		if (request.getParameter("connexion")!= null) {
			
			String identifiant = request.getParameter("identifiant");
			String motDePasse = request.getParameter("motDePasse");
			
			if (manager.seConnecter(identifiant, motDePasse)) {
				//System.out.println("OK Compte existant");
				
				
				adresse = "WEB-INF/accueilConnecte.jsp";
				
				//1er test session
				HttpSession session = request.getSession();
				
				
				//HttpSession session = request.getSession();
				//pw.println("Session ?" + session.isNew());
				//System.out.println("Session ?" + session.isNew());

				
//				String nom = (String)session.getAttribute("identifiant");
//				if (nom != null) {
//					pw.println("nom : "+nom);
//					System.out.println("nom : "+nom);
//				} else {
//					pw.println("Il n'existe pas");
//					System.out.println("Il n'existe pas");
//				}
				try {
					model.setUtilisateur(manager.recupererUnProfil(identifiant));
				} catch (DALException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//session.setAttribute("model", model);
			
				//pw.close();
				
			} else {
				model.setMessage("L'identifiant et/ou le mdp est invalide");				
				}
			
			}
			
//			if (request.getParameter("deconnexion")!= null) {
//				HttpSession session = request.getSession(false);
//			}
			
			request.getSession().setAttribute("model", model);
			
			//Ajout avec erwan 13h30  13.01
			request.getSession().setAttribute("utilisateur", model.getUtilisateur());
			
			//request.setAttribute("model", model);
			request.getRequestDispatcher(adresse).forward(request, response);
			//request.getRequestDispatcher("WEB-INF/connexionCompte.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
