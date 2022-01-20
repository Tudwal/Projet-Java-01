package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.ihm.deconnecte.AccueilModel;

/**
 * Servlet implementation class AccueilConnecte
 */
@WebServlet("/AccueilConnecteServlet")
public class AccueilConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EnchereManager manager = EnchereManagerSing.getInstance();
	List<ArticleVendu> lstArt1 = new ArrayList<ArticleVendu>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilConnecteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// dubix tud
		String articleRecherche = null;
		Integer numCategorie = null;
		UtilisateurModel model = (UtilisateurModel) request.getSession().getAttribute("model");
		Integer noUtilisateur = model.getUtilisateur().getNoUtilisateur();

		if (request.getParameter("rechercher") != null) {
			if (request.getParameter("motClef") != null) {
				articleRecherche = request.getParameter("motClef");
			}
			if (request.getParameter("menuCategorie") != null) {
				numCategorie = Integer.parseInt(request.getParameter("menuCategorie"));
				if (numCategorie == 0) {
					numCategorie = null;
				}
			}
			
			try {
				model.setLstArticles(manager.moteurDeRechercheConnecter(numCategorie, noUtilisateur, null, articleRecherche));
			} catch (BLLException e) {
				e.printStackTrace();
			}
			
			if (request.getParameter("ventesTerminees")!= null) {
				try {
					model.setLstArticles(manager.moteurDeRechercheConnecterMesVentes(numCategorie, noUtilisateur, "VT", articleRecherche));
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
			
			if (request.getParameter("mesEncheresRemportees")!= null) {
				try {
					model.setLstArticles(manager.moteurDeRechercheConnecterMesAchats(numCategorie, noUtilisateur, "VT", articleRecherche));
				} catch (BLLException e) {
					e.printStackTrace();
				}
	
			}
			
//			if (request.getParameter("mesEncheres")!= null) {
//				try {
//					model.setLstArticles(manager.moteurDeRechercheConnecterMesAchats(numCategorie, noUtilisateur, "VT", articleRecherche));
//				} catch (BLLException e) {
//					e.printStackTrace();
//				}
//	
//			}
			
			
		}
		
		
//		System.out.println(model.getLstArticles());
//		System.err.println(request.getParameter("encheresOuvertes"));
//		System.err.println(request.getParameter("mesVentesEnCours"));
//		System.err.println(request.getParameter("mesEncheres"));
//		System.err.println(request.getParameter("ventesNonDebutees"));
//		System.err.println(request.getParameter("mesEncheresRemportees"));
//		System.err.println(request.getParameter("ventesTerminees"));
		
		
//		if (request.getParameter("encheresOuvertes")!= null) {
//			System.out.println("ça marche");
//		}
		request.setAttribute("model", model);
		request.getRequestDispatcher("WEB-INF/accueilConnecte.jsp").forward(request, response);
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
