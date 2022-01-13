package fr.eni.enchere.ihm;

import java.io.IOException;
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
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/ProfilServlet")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String adresse = "WEB-INF/afficherCompte.jsp";
	
	private EnchereManager manager = EnchereManagerSing.getInstance();
	
	//Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("utilisateur");

	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("modifier")!= null) {
			adresse = "ModifierProfilServlet";
			
		}
		
		
	
		

		
//					} catch (BLLException e) {
//						System.out.println("Erreur suppression compte)");
	
			
		
		
		
		
//		UtilisateurModel model = new UtilisateurModel();
//		
//		if (request.getParameter("supprimer") != null) {
//			Integer noUtilisateur = request.getParameter("noUtilisateur");
//			
//			model.set(noUtilisateur);
//			
//			if (noUtilisateur.equals(noUtilisateur)) {
//				manager.supprimerCompte(noUtilisateur);
//				
//			}
//		}
		
		
		
		request.getRequestDispatcher(adresse).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
