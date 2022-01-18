package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.ihm.deconnecte.AccueilModel;

/**
 * Servlet implementation class AccueilConnecte
 */
@WebServlet("/AccueilConnecteServlet")
public class AccueilConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilConnecteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		
		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/accueilConnecteCopie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
