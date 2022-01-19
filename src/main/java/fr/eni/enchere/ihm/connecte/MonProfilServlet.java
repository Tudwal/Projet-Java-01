package fr.eni.enchere.ihm.connecte;

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
@WebServlet("/MonProfilServlet")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String adresse = "WEB-INF/afficherMonCompte.jsp";
	
	private EnchereManager manager = EnchereManagerSing.getInstance();
	
	//Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		if (adresse != "WEB-INF/afficherMonCompte.jsp" ) {
			adresse = "WEB-INF/afficherMonCompte.jsp";
		}
		
		
		if (adresse != "WEB-INF/afficherMonCompte.jsp") {
			adresse = "WEB-INF/afficherMonCompte.jsp";
		}
		
		if (request.getParameter("modifier")!= null) {
			adresse = "ModifierMonProfilServlet";
		}
		
		request.getRequestDispatcher(adresse).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
