package fr.eni.enchere.bll;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.EnchereDAOFact;
import fr.eni.enchere.dal.jdbc.DALException;

public class EnchereManagerImpl implements EnchereManager {

	private static EnchereDAO dao = EnchereDAOFact.getInstance();

	/**
	 * Fonction permettant la création d'un compte Utilisateur après la verification
	 * de tout les champs renseigner par l'utilisateur On verifie aussi si le mot de
	 * passe "admin" est rentrée à la création du compte, dans ce cas le compte
	 * créer est un compte utilisateur
	 * 
	 * @throws BLLException
	 */
	@Override
	public void creerCompte(Utilisateur utilisateur) throws BLLException {
		BLLException be = new BLLException();

		verificationPseudoUtilisateur(utilisateur.getPseudo(), be);
		verificationNomUtilisateur(utilisateur.getNom(), be);
		verificationPrenomUtilisateur(utilisateur.getPrenom(), be);
		verificationEmailUtilisateur(utilisateur.getEmail(), be);
		verificationTelephoneUtilisateur(utilisateur.getTelephone(), be);
		verificationRueUtilisateur(utilisateur.getRue(), be);
		verificationCodePostalUtilisateur(utilisateur.getCodePostal(), be);
		verificationVilleUtilisateur(utilisateur.getVille(), be);
		verificationMotDePasseUtilisateur(utilisateur.getMotDePasse(), be);
		utilisateur.setCredit(100);
		verificationCreditUtilisateur(utilisateur.getCredit(), be);
//		verificationAdministrateurUtilisateur(utilisateur.getAdministrateur(), be);
		verificationDoublonUtilisateur(utilisateur, be);

		if (be.hasErreur()) {
			throw be;
		}
		if (utilisateur.getMotDePasse().equals("admin")) {
			utilisateur.setAdministrateur(1);
		}
		try {
			dao.insertUtilisateur(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}

	/**
	 * Fonction permettant de faire remonter la liste de tout les utilisateur qui
	 * ont crée un compte.
	 * 
	 * @return List<Utilisateur>
	 * @throws BLLException
	 */
	@Override
	public List<Utilisateur> afficherTousUtilisateurs() throws BLLException {
		List<Utilisateur> lstUtilisateurs = new ArrayList<Utilisateur>();
		try {
			lstUtilisateurs = dao.getAllUtilisateur();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();

		}
		return lstUtilisateurs;
	}

	/**
	 * Fonction permettant de vérifier dans la base de donnée si le pseudo ou
	 * l'email appartiennent à un utilisateur, on verifie aussi que le mot de passe
	 * soit le bon
	 * 
	 * @param identifiant et mot de passe
	 * @return boolean
	 * @throws BLLException
	 */
	@Override
	public Boolean seConnecter(String identifiant, String motDePasse) throws BLLException {
		Boolean cnx = false;
		try {
			for (Utilisateur u : dao.getAllUtilisateur()) {
				if (((identifiant.equals(u.getEmail()) || identifiant.equals(u.getPseudo()))
						&& motDePasse.equals(u.getMotDePasse()))) {
					cnx = true;
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return cnx;
	}

	/**
	 * Fonction permettant à un utilisateur de modifier les informations de son
	 * compte, des vérifications de conformiter des champs sont aussi effectués.
	 * 
	 * @param utilisateur
	 * @throws BLLException
	 */
	@Override
	public void modifCompte(Utilisateur utilisateur) throws BLLException {
		BLLException be = new BLLException();

		verificationPseudoUtilisateur(utilisateur.getPseudo(), be);
		verificationNomUtilisateur(utilisateur.getNom(), be);
		verificationPrenomUtilisateur(utilisateur.getPrenom(), be);
		verificationEmailUtilisateur(utilisateur.getEmail(), be);
		verificationTelephoneUtilisateur(utilisateur.getTelephone(), be);
		verificationRueUtilisateur(utilisateur.getRue(), be);
		verificationCodePostalUtilisateur(utilisateur.getCodePostal(), be);
		verificationVilleUtilisateur(utilisateur.getVille(), be);

		// Mis en commentaire ce 14.01 pour update utilisateur
		verificationMotDePasseUtilisateur(utilisateur.getMotDePasse(), be);
		verificationCreditUtilisateur(utilisateur.getCredit(), be);
		verificationAdministrateurUtilisateur(utilisateur.getAdministrateur(), be);


		// verificationDoublon(utilisateur, be);

		if (be.hasErreur()) {
			throw be;
		}

		try {
			dao.updateUtilisateur(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}

	/**
	 * Fonction permettant la suppression d'un compte uilisateur à partir de son
	 * numéro d'utilisateur.
	 * 
	 * @param numéro d'utilisateur
	 * @throws BLLException
	 */
	@Override
	public void supprimerCompte(Integer noUtilisateur) throws BLLException {
		BLLException be = new BLLException();
		if (be.hasErreur()) {
			throw be;
		}

		try {
			dao.deleteUtilisateur(noUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}

	/**
	 * Fonction permettant d'afficher un profil utilisateur en fonction de son
	 * noUtilisateur
	 * 
	 * @param numéro d'utilisateur
	 * @return Utilisateur
	 * @throws BLLException
	 */
	@Override
	public Utilisateur afficherMonProfil(Integer noUtilisateur) throws BLLException {
		try {
			return dao.getUnUtilisateur(noUtilisateur);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}

	/**
	 * Fonction permettant de récupérer un utilisateur en fonction de son
	 * identifiant de connection
	 * 
	 * @param identifiant
	 * @return un utilisateur
	 * @throws BLLException
	 */
	@Override
	public Utilisateur recupererUnProfil(String identifiant) throws BLLException {
		Utilisateur utilisateur = new Utilisateur();
		try {
			for (Utilisateur u : dao.getAllUtilisateur()) {
				if (u.getPseudo().equals(identifiant) || u.getEmail().equals(identifiant)) {
					utilisateur = u;
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return utilisateur;
	}

	@Override
	public ArticleVendu recupererUnArticle(Integer noArticle) throws BLLException {
		ArticleVendu article = new ArticleVendu();
		try {
			for (ArticleVendu art : dao.getAllArticles()) {
				if (art.getNoArticle().equals(noArticle)) {
					article = art;
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		
		return article;
	}
	
	
	/**
	 * Fonction permettant de créer un article
	 * 
	 * @param article
	 * @throws BLLException
	 */
	@Override
	public void creerUnArticle(ArticleVendu article) throws BLLException {
		BLLException be = new BLLException();
		verificationNomArticle(article.getNomArticle(), be);
		verificationDescriptionArticle(article.getDescription(), be);
		verificationDateDebutEnchereArticle(article.getDateDebutEncheres(), be);
		verificationDateFinEnchereArticle(article.getDateFinEncheres(), be);
		verificationPrixInitialArticle(article.getMiseAPrix(), be);
		article.setEtatVente("EA");

		if (be.hasErreur()) {
			throw be;
		}

		try {
			dao.insertArticle(article);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}

	/**
	 * Fonction permettant de faire remonter la totalités des articles en vente
	 */
	@Override
	public List<ArticleVendu> consulterArticles() throws BLLException {
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		modifierEtatVente();
		try {
			lstArticles = dao.getAllArticles();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return lstArticles;
	}

	@Override
	public Categorie recupereCategorie(Integer noCategorie) throws BLLException {
		Categorie cat;
		try {
			cat = dao.getUneCategorie(noCategorie);
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return cat;
	}

	/**
	 * Fonction permettant d'enchérire sur un article, on verifie que le montant
	 * proposer par l'acheteur est bien un montant plus haut que celui de la
	 * dernière enchère
	 */
	@Override
	public void encherire(Enchere enchere) throws BLLException {
		BLLException be = new BLLException();
		if (be.hasErreur()) {
			throw be;
		}
		try {
			Enchere meilleurEnchere = dao.getTopEnchere(enchere.getArticleVendu().getNoArticle());
			Timestamp dateDebutEnchere = Timestamp
					.valueOf(enchere.getArticleVendu().getDateDebutEncheres().atStartOfDay());
			Timestamp dateFinEnchere = Timestamp
					.valueOf(enchere.getArticleVendu().getDateFinEncheres().plusDays(1).atStartOfDay());
			Timestamp dateEnchere = new Timestamp(enchere.getDateEnchere().getTime());
			

			if (dateEnchere.after(dateDebutEnchere) && dateEnchere.before(dateFinEnchere)) {
				if (meilleurEnchere.getMontantEnchere() < enchere.getMontantEnchere()
						&& enchere.getArticleVendu().getMiseAPrix() < enchere.getMontantEnchere()) {
					dao.insertEnchere(enchere);
					if (meilleurEnchere.getUtilisateur() != null) {
						meilleurEnchere.getUtilisateur().setCredit(meilleurEnchere.getUtilisateur().getCredit() + meilleurEnchere.getMontantEnchere());
						dao.updateUtilisateur(meilleurEnchere.getUtilisateur());
						Integer payement = enchere.getUtilisateur().getCredit() - enchere.getMontantEnchere();
						enchere.getUtilisateur().setCredit(payement);
						dao.updateUtilisateur(enchere.getUtilisateur());
					} else if (meilleurEnchere.getUtilisateur() == null) {
						Integer payement = enchere.getUtilisateur().getCredit() - enchere.getMontantEnchere();
						enchere.getUtilisateur().setCredit(payement);
						dao.updateUtilisateur(enchere.getUtilisateur());
					}
					
					
				}
			} else {
				System.out.println("date depassé");
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}
	
	@Override
	public Enchere recupererTopEnchere(Integer noArticle) throws BLLException {
		Enchere enchere;
		try {
			enchere = dao.getTopEnchere(noArticle);
		}  catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return enchere;
	}



	public void crediterCompte(ArticleVendu article) throws BLLException {
		try {
			Enchere meilleurEnchere = dao.getTopEnchere(article.getNoArticle());
			article.getUtilisateur().setCredit(
					article.getUtilisateur().getCredit() + meilleurEnchere.getMontantEnchere());
			dao.updateUtilisateur(article.getUtilisateur());
			article.setPrixVente(meilleurEnchere.getMontantEnchere());
			dao.updateArticle(article);

		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
	}

	public void modifierEtatVente() throws BLLException {
		Timestamp dateJour = Timestamp.valueOf(LocalDate.now().atTime(LocalTime.now()));
		// actualisation des ventes en attente, a vente en cour
		try {
			List<ArticleVendu> lstEtat = moteurDeRechercheDeconnecter(null, "EA", null);
			System.out.println(lstEtat);
			for (ArticleVendu article : lstEtat) {
				Timestamp dateDebutEnchere = Timestamp.valueOf(article.getDateDebutEncheres().atStartOfDay());
				if (dateJour.after(dateDebutEnchere)) {
					article.setEtatVente("EC");
					dao.updateArticle(article);
				}
			}

			// actualisation des ventes en cours à vente terminé
			List<ArticleVendu> lstEtatTerminer = moteurDeRechercheDeconnecter(null, "EC", null);
			for (ArticleVendu article : lstEtatTerminer) {
				Timestamp dateFinEnchere = Timestamp.valueOf(article.getDateFinEncheres().plusDays(1).atStartOfDay());
				if (dateJour.after(dateFinEnchere)) {
					crediterCompte(article);
					article.setEtatVente("VT");
					dao.updateArticle(article);
				}
			}
			
			

		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}

	}

	@Override
	public List<ArticleVendu> moteurDeRechercheDeconnecter(Integer noCategorie, String etatVente, String motClef)
			throws BLLException {
		List<ArticleVendu> lstRecherche = new ArrayList<ArticleVendu>();
		try {
			List<ArticleVendu> lstArticles = dao.getAllArticles();
			if (noCategorie != null && etatVente != null && motClef != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);
				lstRecherche = rechercheParEtatVente(etatVente, lstRecherche);
				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null && etatVente != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);

				lstRecherche = rechercheParEtatVente(etatVente, lstRecherche);

			} else if (etatVente != null && motClef != null) {
				lstRecherche = rechercheParEtatVente(etatVente, lstArticles);

				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null && motClef != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);

				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);
			} else if (etatVente != null) {
				lstRecherche = rechercheParEtatVente(etatVente, lstArticles);
			} else if (motClef != null) {
				lstRecherche = rechercheParMotClefs(motClef, lstArticles);
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return lstRecherche;
	}
	
	@Override
	public List<ArticleVendu> moteurDeRechercheConnecter(Integer noCategorie, Integer noUtilisateur, String etatVente,
			String motClef) throws BLLException {
		List<ArticleVendu> lstRecherche = new ArrayList<ArticleVendu>();
		try {
			List<ArticleVendu> lstArticles = dao.getAllArticles();
			if (noCategorie != null && etatVente != null && motClef != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);
				lstRecherche = rechercheParEtatVente(etatVente, lstRecherche);
				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null && etatVente != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);

				lstRecherche = rechercheParEtatVente(etatVente, lstRecherche);

			} else if (etatVente != null && motClef != null) {
				lstRecherche = rechercheParEtatVente(etatVente, lstArticles);

				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null && motClef != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);

				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			}  else if (noCategorie != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);
			} else if (etatVente != null) {
				lstRecherche = rechercheParEtatVente(etatVente, lstArticles);
			} else if (motClef != null) {
				lstRecherche = rechercheParMotClefs(motClef, lstArticles);
			} else {
				lstRecherche = lstArticles;
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return lstRecherche;
	}
	
	@Override
	public List<ArticleVendu> moteurDeRechercheConnecterMesVentes(Integer noCategorie, Integer noUtilisateur,
			String etatVente, String motClef) throws BLLException {
		List<ArticleVendu> lstRecherche = new ArrayList<ArticleVendu>();
		try {
			List<ArticleVendu> lstArticles = dao.getAllArticles();
			if (noCategorie != null && etatVente != null && motClef != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);
				lstRecherche = rechercheParEtatVente(etatVente, lstRecherche);
				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null && etatVente != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);

				lstRecherche = rechercheParEtatVente(etatVente, lstRecherche);

			} else if (etatVente != null && motClef != null) {
				lstRecherche = rechercheParEtatVente(etatVente, lstArticles);

				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if (noCategorie != null && motClef != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);

				lstRecherche = rechercheParMotClefs(motClef, lstRecherche);

			} else if(etatVente != null && noUtilisateur != null){
				lstRecherche = rechercheMesVentes(etatVente, lstArticles, noUtilisateur);
			} else if (noCategorie != null) {
				lstRecherche = rechercheParCategorie(noCategorie, lstArticles);
			} else if (etatVente != null) {
				lstRecherche = rechercheParEtatVente(etatVente, lstArticles);
			} else if (motClef != null) {
				lstRecherche = rechercheParMotClefs(motClef, lstArticles);
			}
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return lstRecherche;
	}

	@Override
	public List<ArticleVendu> moteurDeRechercheConnecterMesAchats(Integer noCategorie, Integer noUtilisateur,
			String etatVente, String motClef) throws BLLException {
		List<Enchere> lstRecherche = new ArrayList<Enchere>();
		List<ArticleVendu> lstarti = new ArrayList<ArticleVendu>();
		try {
			List<Enchere> lstEnchere = dao.getAllEnchere();
			if (noCategorie != null && etatVente != null && motClef != null) {
				lstRecherche = rechercheParCategorieEnchere(noCategorie, lstEnchere);
				lstRecherche = rechercheParEtatVenteEnchere(etatVente, lstRecherche);
				lstRecherche = rechercheParMotClefEnchere(motClef, lstRecherche);

			} else if (noCategorie != null && etatVente != null) {
				lstRecherche = rechercheParCategorieEnchere(noCategorie, lstEnchere);

				lstRecherche = rechercheParEtatVenteEnchere(etatVente, lstRecherche);

			} else if (etatVente != null && motClef != null) {
				lstRecherche = rechercheParEtatVenteEnchere(etatVente, lstEnchere);

				lstRecherche = rechercheParMotClefEnchere(motClef, lstRecherche);

			} else if (noCategorie != null && motClef != null) {
				lstRecherche = rechercheParCategorieEnchere(noCategorie, lstEnchere);

				lstRecherche = rechercheParMotClefEnchere(motClef, lstRecherche);

			} else if(etatVente != null && noUtilisateur != null){
				lstRecherche = rechercheMesAchats(etatVente, lstEnchere, noUtilisateur);
			} else if (noCategorie != null) {
				lstRecherche = rechercheParCategorieEnchere(noCategorie, lstEnchere);
			} else if (etatVente != null) {
				lstRecherche = rechercheParEtatVenteEnchere(etatVente, lstEnchere);
			} else if (motClef != null) {
				lstRecherche = rechercheParMotClefEnchere(motClef, lstEnchere);
			}
			
			
			for (Enchere enchere : lstRecherche) {
				Integer noArticle = enchere.getArticleVendu().getNoArticle();
				ArticleVendu article = dao.getUnArticle(noArticle);
				lstarti.add(article);
			}
			
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
		}
		return lstarti;
	}

	

	@Override
	public List<ArticleVendu> rechercheParCategorie(Integer noCategorie, List<ArticleVendu> lstAfiltrer)
			throws BLLException {
		List<ArticleVendu> lstArticleParCategorie = new ArrayList<ArticleVendu>();
		for (ArticleVendu articleVendu : lstAfiltrer) {
			if (articleVendu.getCategorieArticle().getNoCategorie().equals(noCategorie)) {
				lstArticleParCategorie.add(articleVendu);
			}
		}

		return lstArticleParCategorie;
	}

	
	
	@Override
	public List<ArticleVendu> rechercheParMotClefs(String motClef, List<ArticleVendu> lstAfiltrer) throws BLLException {
		List<ArticleVendu> lstArticleParMotClef = new ArrayList<ArticleVendu>();
		for (ArticleVendu articleVendu : lstAfiltrer) {
			if (articleVendu.getDescription().contains(motClef.toLowerCase())
					|| articleVendu.getNomArticle().contains(motClef.toLowerCase())) {
				lstArticleParMotClef.add(articleVendu);
			}
		}
		return lstArticleParMotClef;
	}

	@Override
	public List<ArticleVendu> rechercheParEtatVente(String etatVente, List<ArticleVendu> lstAfiltrer)
			throws BLLException {
		List<ArticleVendu> lstArticleParEtatVente = new ArrayList<ArticleVendu>();
		for (ArticleVendu articleVendu : lstAfiltrer) {
			if (articleVendu.getEtatVente().equals(etatVente)) {
				lstArticleParEtatVente.add(articleVendu);
			}
		}
		return lstArticleParEtatVente;
	}
	
	public List<ArticleVendu> rechercheMesVentes(String etatVente, List<ArticleVendu> lstAfiltrer, Integer noUtilisateur){
		List<ArticleVendu> lstFinal = new ArrayList<ArticleVendu>();
		switch (etatVente) {
		//mes ventes en cours
		case "EA":List<ArticleVendu> lstEnAttente;
			try {
				lstEnAttente = rechercheParEtatVente(etatVente, lstAfiltrer);
				List<ArticleVendu> lstMesVentesEnAttente = new ArrayList<ArticleVendu>();
				for (ArticleVendu articleVendu : lstEnAttente) {
					if (articleVendu.getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
						lstMesVentesEnAttente.add(articleVendu);
					}
				}
				lstFinal = lstMesVentesEnAttente;
				break;
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//mes ventes non débutées	
		case "EC":List<ArticleVendu> lstEnCour;
			try {
				lstEnCour = rechercheParEtatVente(etatVente, lstAfiltrer);
				List<ArticleVendu> lstMesVentesEnCours = new ArrayList<ArticleVendu>();
				for (ArticleVendu articleVendu : lstEnCour) {
					if (articleVendu.getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
						lstMesVentesEnCours.add(articleVendu);
					}
				}
				lstFinal =  lstMesVentesEnCours;
				break;
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//mes ventes terminées	
		case "VT":List<ArticleVendu> lstTermine;
			try {
				lstTermine = rechercheParEtatVente(etatVente, lstAfiltrer);
				List<ArticleVendu> lstMesVentesTermine = new ArrayList<ArticleVendu>();
				for (ArticleVendu articleVendu : lstTermine) {
					if (articleVendu.getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
						lstMesVentesTermine.add(articleVendu);
					}
				}
				lstFinal = lstMesVentesTermine;
				break;
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lstFinal;
	}
	
	public List<Enchere> rechercheMesAchats(String etatVente, List<Enchere> lstAfiltrer,
			Integer noUtilisateur) throws BLLException, DALException {
		List<Enchere> lstFinal = new ArrayList<Enchere>();
		switch (etatVente) {
		//mes ventes en cours
		case "EA":List<Enchere> lstEnAttente;
			lstEnAttente = rechercheParEtatVenteEnchere(etatVente, lstAfiltrer);
			List<Enchere> lstMesVentesEnAttente = new ArrayList<Enchere>();
			for (Enchere enchere : lstEnAttente) {
				if (enchere.getArticleVendu().getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
					lstMesVentesEnAttente.add(enchere);
				}
			}
			lstFinal = lstMesVentesEnAttente;
			break;
		//mes ventes non débutées	
		case "EC":List<Enchere> lstEnCour;
			lstEnCour = rechercheParEtatVenteEnchere(etatVente, lstAfiltrer);
			List<Enchere> lstMesVentesEnCours = new ArrayList<Enchere>();
			for (Enchere enchere : lstEnCour) {
				if (enchere.getArticleVendu().getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
					lstMesVentesEnCours.add(enchere);
				}
			}
			lstFinal =  lstMesVentesEnCours;
			break;
		//mes ventes terminées	
		case "VT":List<Enchere> lstTermine;
			lstTermine = rechercheParEtatVenteEnchere(etatVente, lstAfiltrer);
			List<Enchere> lstMesVentesTermine = new ArrayList<Enchere>();
			for (Enchere enchere : lstTermine) {
				if (enchere.getArticleVendu().getUtilisateur().getNoUtilisateur().equals(noUtilisateur)) {
					lstMesVentesTermine.add(enchere);
				}
			}
			lstFinal = lstMesVentesTermine;
			break;
		}
		return lstFinal;
	}
	
	public List<Enchere> rechercheParEtatVenteEnchere (String etatVente, List<Enchere> lstAFiltrer){
		List<Enchere> lstEnchereParEtatVente = new ArrayList<Enchere>();
		for (Enchere enchere : lstAFiltrer) {
			if (enchere.getArticleVendu().getEtatVente().equals(etatVente)) {
				lstEnchereParEtatVente.add(enchere);
			}
		}
		return lstEnchereParEtatVente;
	}
	
	public List<Enchere> rechercheParCategorieEnchere (Integer noCategorie, List<Enchere> lstAFiltrer){
		List<Enchere> lstEnchereParCategorie = new ArrayList<Enchere>();
		for (Enchere enchere : lstAFiltrer) {
			if (enchere.getArticleVendu().getCategorieArticle().getNoCategorie().equals(noCategorie)) {
				lstEnchereParCategorie.add(enchere);
			}
		}
		return lstEnchereParCategorie;
	}
	
	public List<Enchere> rechercheParMotClefEnchere (String motClef, List<Enchere> lstAFiltrer){
		List<Enchere> lstArticleParMotClefEnchere = new ArrayList<Enchere>();
		for (Enchere enchere : lstAFiltrer) {
			if (enchere.getArticleVendu().getDescription().contains(motClef.toLowerCase())
					|| enchere.getArticleVendu().getNomArticle().contains(motClef.toLowerCase())) {
				lstArticleParMotClefEnchere.add(enchere);
			}
		}
		return lstArticleParMotClefEnchere;
	}
	
	
	
 	private void verificationNomArticle(String nomArticle, BLLException be) {
		if (nomArticle.length() > 30 || nomArticle.isBlank() || nomArticle == null) {
			be.ajouterErreur(
					new ParameterException("Le nom de l'article est obligatoire et inferieur a 30 caracteres"));
		}

	}

	private void verificationDescriptionArticle(String descriptionArticle, BLLException be) {
		if (descriptionArticle.length() > 300 || descriptionArticle.isBlank() || descriptionArticle == null) {
			be.ajouterErreur(new ParameterException(
					"La description de l'article est obligatoire et inferieur a 300 caracteres"));
		}

	}

	private void verificationDateDebutEnchereArticle(LocalDate dateDebutEnchere, BLLException be) {
		if (dateDebutEnchere == null) {
			be.ajouterErreur(new ParameterException("La date de début d'enchère est obligatoire"));
		}

	}

	private void verificationDateFinEnchereArticle(LocalDate dateFinEnchere, BLLException be) {
		if (dateFinEnchere == null) {
			be.ajouterErreur(new ParameterException("La date de fin d'enchère est obligatoire"));
		}

	}

	private void verificationPrixInitialArticle(Integer prixInitial, BLLException be) {
		if (prixInitial < 0) {
			be.ajouterErreur(new ParameterException("Le prix initial est un entier positif"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le pseudo rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param pseudo
	 * @param be
	 * 
	 */
	private void verificationPseudoUtilisateur(String pseudo, BLLException be) {
		if (pseudo.length() > 30 || pseudo.isBlank() || pseudo == null) {
			be.ajouterErreur(new ParameterException("Le pseudo est obligatoire et inferieur a 30 caracteres"));
		}
	}

	/**
	 * Fonction permettant de vérifier que le nom rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param nom
	 * @param be
	 */
	private void verificationNomUtilisateur(String nom, BLLException be) {
		if (nom.length() > 30 || nom.isBlank() || nom == null) {
			be.ajouterErreur(new ParameterException("Le nom est obligatoire et inferieur a 30 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le prenom rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param prenom
	 * @param be
	 */
	private void verificationPrenomUtilisateur(String prenom, BLLException be) {
		if (prenom.length() > 30 || prenom.isBlank() || prenom == null) {
			be.ajouterErreur(new ParameterException("Le prenom est obligatoire et inferieur a 30 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le mail rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param email
	 * @param be
	 */
	private void verificationEmailUtilisateur(String email, BLLException be) {
		if (email.length() > 50 || email.isBlank() || email == null) {
			be.ajouterErreur(new ParameterException("L'email est obligatoire et inferieur a 50 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le numéro de téléphone rentrée par
	 * l'utilisateur est conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param telephone
	 * @param be
	 */
	private void verificationTelephoneUtilisateur(String telephone, BLLException be) {
		if (telephone.length() > 15) {
			be.ajouterErreur(new ParameterException("Le telephone est inferieur a 15 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que la rue rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param rue
	 * @param be
	 */
	private void verificationRueUtilisateur(String rue, BLLException be) {
		if (rue.length() > 50 || rue.isBlank() || rue == null) {
			be.ajouterErreur(new ParameterException("La rue est obligatoire et inferieur a 50 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le code postal rentrée par l'utilisateur
	 * est conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param codePostal
	 * @param be
	 */
	
	private void verificationCodePostalUtilisateur(String codePostal, BLLException be) {
		if (codePostal.length() > 10 || codePostal.isBlank() || codePostal == null) {
			be.ajouterErreur(new ParameterException("Le code postal est obligatoire et inferieur a 10 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que la ville rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param ville
	 * @param be
	 */
	private void verificationVilleUtilisateur(String ville, BLLException be) {
		if (ville.length() > 50 || ville.isBlank() || ville == null) {
			be.ajouterErreur(new ParameterException("La ville est obligatoire et inferieur a 50 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le mot de passe rentrée par l'utilisateur
	 * est conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param motDePasse
	 * @param be
	 */
	private void verificationMotDePasseUtilisateur(String motDePasse, BLLException be) {
		if (motDePasse.length() > 30 || motDePasse.isBlank() || motDePasse == null) {
			be.ajouterErreur(new ParameterException("Le mot de passe est obligatoire et inferieur a 30 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que les crédits de l'utilisateur ne sont pas
	 * négatifs
	 * 
	 * @param credit
	 * @param be
	 */
	private void verificationCreditUtilisateur(Integer credit, BLLException be) {
		if (credit < 0 || credit == null) {
			be.ajouterErreur(new ParameterException("Le credit est obligatoire et superieur ou egal a zero"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le champs administrateur ne soit pas null
	 * à la création du compte
	 * 
	 * @param administrateur
	 * @param be
	 */
	private void verificationAdministrateurUtilisateur(Integer administrateur, BLLException be) {
		if (administrateur == null) {
			be.ajouterErreur(new ParameterException("Le code administrateur est obligatoire"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le pseudo et le mail d'un utilisateur
	 * soit bien unique et ne soit pas déja présent dans la base de donnée
	 * 
	 * @param utilisateur
	 * @param be
	 */
	private void verificationDoublonUtilisateur(Utilisateur utilisateur, BLLException be) {
		if (utilisateur.getNoUtilisateur() != null) {
			try {
				for (Utilisateur u : dao.getAllUtilisateur()) {
					if (u.getNoUtilisateur().equals(utilisateur.getNoUtilisateur())) {
						if (!u.getPseudo().equals(utilisateur.getPseudo())
								|| !u.getEmail().equals(utilisateur.getEmail())) {
							try {
								for (Utilisateur u2 : dao.getAllUtilisateur()) {
									if (utilisateur.getEmail().equals(u2.getEmail())
											&& utilisateur.getPseudo().equals(u2.getPseudo())) {
										be.ajouterErreur(new ParameterException("Doublon modif"));
									}

								}
							} catch (DALException e) {
								e.printStackTrace();
							}
						}
					}
				}
			} catch (DALException e) {
				e.printStackTrace();
			}
		} else {
			try {
				for (Utilisateur u : dao.getAllUtilisateur()) {
					if (utilisateur.getEmail().equals(u.getEmail()) || utilisateur.getPseudo().equals(u.getPseudo())) {
						be.ajouterErreur(new ParameterException("Doublon"));
					}

				}
			} catch (DALException e) {
				e.printStackTrace();
			}
		}

	}









}
