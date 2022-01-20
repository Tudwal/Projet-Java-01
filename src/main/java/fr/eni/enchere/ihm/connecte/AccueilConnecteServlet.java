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

		UtilisateurModel model = ((UtilisateurModel) request.getSession().getAttribute("model"));
		String articleRecherche = null;
		Integer numCategorie = null;
		Integer noUtilisateur = null;

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

			if (request.getParameter("achats") != null) {
				noUtilisateur = model.getUtilisateur().getNoUtilisateur();

				if (request.getParameter("encheresOuvertes") != null && request.getParameter("mesEncheres") == null
						&& request.getParameter("mesEncheresRemportees") == null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecter(numCategorie, noUtilisateur, "EC",
								articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else if (request.getParameter("mesEncheres") != null
						&& request.getParameter("encheresOuvertes") == null
						&& request.getParameter("mesEncheresRemportees") == null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesAchats(numCategorie, noUtilisateur,
								"EC", articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else if (request.getParameter("mesEncheresRemportees") != null
						&& request.getParameter("encheresOuvertes") == null
						&& request.getParameter("mesEncheres") == null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesAchats(numCategorie, noUtilisateur,
								"VT", articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else if (request.getParameter("mesEncheresRemportees") != null
						&& request.getParameter("encheresOuvertes") == null
						&& request.getParameter("mesEncheres") != null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesAchats(numCategorie, noUtilisateur,
								null, articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecter(numCategorie, noUtilisateur, null,
								articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
			}

			if (request.getParameter("ventes") != null) {
				noUtilisateur = model.getUtilisateur().getNoUtilisateur();
				if (request.getParameter("mesVentesEnCours") != null
						&& request.getParameter("ventesNonDebutees") == null
						&& request.getParameter("ventesTerminees") == null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesVentes(numCategorie, noUtilisateur,
								"EC", articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}

				if (request.getParameter("ventesNonDebutees") != null
						&& request.getParameter("mesVentesEnCours") == null
						&& request.getParameter("ventesTerminees") != null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesVentes(numCategorie, noUtilisateur,
								"EA", articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}

				if (request.getParameter("ventesTerminees") != null && request.getParameter("ventesNonDebutees") == null
						&& request.getParameter("mesVentesEnCours") == null) {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesVentes(numCategorie, noUtilisateur,
								"VT", articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				} else {
					try {
						model.setLstArticles(manager.moteurDeRechercheConnecterMesVentes(numCategorie, noUtilisateur,
								null, articleRecherche));
					} catch (BLLException e) {
						e.printStackTrace();
					}
				}
			}
		}

//		System.err.println(request.getParameter("encheresOuvertes"));
//		System.err.println(request.getParameter("mesVentesEnCours"));
//		System.err.println(request.getParameter("mesEncheres"));
//		System.err.println(request.getParameter("ventesNonDebutees"));
//		System.err.println(request.getParameter("mesEncheresRemportees"));
//		System.err.println(request.getParameter("ventesTerminees"));

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
