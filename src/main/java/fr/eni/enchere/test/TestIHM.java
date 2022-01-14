package fr.eni.enchere.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestIHM
 */
@WebServlet("/TestIHM")
public class TestIHM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestIHM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
//		System.out.println(manager.afficherMonProfil(1));
//		Utilisateur utilisateur;
//		try {
//			utilisateur = manager.afficherMonProfil(1);
//			utilisateur.setCodePostal("45200");
//			try {
//				manager.supprimerCompte(1);
//			} catch (BLLException e) {
//				e.printStackTrace();
//			}
//			System.out.println(manager.afficherMonProfil(1));
		
//		manager.modifCompte(utilisateur);
//		System.out.println(manager.afficherMonProfil(1));
//		
//		} 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
