package fr.eni.enchere.ihm.connecte;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.EnchereManager;
import fr.eni.enchere.bll.EnchereManagerSing;
import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateur;

/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EnchereManager manager = EnchereManagerSing.getInstance();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NouvelleVenteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("enregistrer") != null) {
			String nomArticle = request.getParameter("nomArticle");
			String descriptionArticle = request.getParameter("descriptionArticle");
			Integer categorieArticle = Integer.parseInt(request.getParameter("menuCategorie"));
			// récupérer photo de l'article
			Integer miseAPrixArticle = Integer.parseInt(request.getParameter("miseAPrix"));
			LocalDate debutEnchereArticle = LocalDate.parse((request.getParameter("debutEnchere")), dtf);
			LocalDate finEnchereArticle = LocalDate.parse((request.getParameter("finEnchere")), dtf);
			String rue = request.getParameter("rueRetrait");
			String codePostal = request.getParameter("codePostalRetrait");
			String ville = request.getParameter("villeRetrait");

			Utilisateur utilisateur = ((UtilisateurModel) request.getSession().getAttribute("model")).getUtilisateur();
			Categorie categorie = new Categorie();
			try {
				categorie = manager.recupereCategorie(categorieArticle);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			Retrait lieuRetrait = new Retrait(rue, codePostal, ville);
			ArticleVendu article = new ArticleVendu(utilisateur, categorie, lieuRetrait, nomArticle, descriptionArticle,
					debutEnchereArticle, finEnchereArticle, miseAPrixArticle);
			try {
				manager.creerUnArticle(article);
			} catch (BLLException e) {
				e.printStackTrace();
			}

		}

		request.getRequestDispatcher("WEB-INF/nouvelleVente.jsp").forward(request, response);
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
