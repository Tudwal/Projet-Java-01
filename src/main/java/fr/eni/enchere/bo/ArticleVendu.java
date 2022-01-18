/**
 * 
 */
package fr.eni.enchere.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tguerin2021
 *
 */
public class ArticleVendu {
	private Utilisateur utilisateur;
	private List<Enchere> lstEncheres = new ArrayList<>();
	private Categorie categorieArticle;
	private Retrait lieuRetrait;

	private Integer noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;

	public ArticleVendu() {
		super();
	}

	public ArticleVendu(Utilisateur utilisateur, Categorie categorieArticle, String nomArticle, String description,
			LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix, Integer prixVente,
			String etatVente) {
		super();
		this.utilisateur = utilisateur;
		this.categorieArticle = categorieArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public ArticleVendu(Utilisateur utilisateur, Categorie categorieArticle, String nomArticle, String description,
			LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix, String etatVente) {
		super();
		this.utilisateur = utilisateur;
		this.categorieArticle = categorieArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.etatVente = etatVente;
	}

	public ArticleVendu(Utilisateur utilisateur, Categorie categorieArticle, Integer noArticle, String nomArticle,
			String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix,
			Integer prixVente, String etatVente) {
		super();
		this.utilisateur = utilisateur;
		this.categorieArticle = categorieArticle;
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}

	public ArticleVendu(Utilisateur utilisateur, Categorie categorieArticle, Retrait lieuRetrait, Integer noArticle,
			String nomArticle, String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres,
			Integer miseAPrix, Integer prixVente, String etatVente) {
		super();
		this.utilisateur = utilisateur;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
	}
	

	public ArticleVendu(Utilisateur utilisateur, Categorie categorieArticle, Retrait lieuRetrait, String nomArticle,
			String description, LocalDate dateDebutEncheres, LocalDate dateFinEncheres, Integer miseAPrix) {
		super();
		this.utilisateur = utilisateur;
		this.categorieArticle = categorieArticle;
		this.lieuRetrait = lieuRetrait;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Enchere> getLstEncheres() {
		return lstEncheres;
	}

	public void setLstEncheres(List<Enchere> lstEncheres) {
		this.lstEncheres = lstEncheres;
	}

	public Categorie getCategorieArticle() {
		return categorieArticle;
	}

	public void setCategorieArticle(Categorie categorieArticle) {
		this.categorieArticle = categorieArticle;
	}

	public Retrait getLieuRetrait() {
		return lieuRetrait;
	}

	public void setLieuRetrait(Retrait lieuRetrait) {
		this.lieuRetrait = lieuRetrait;
	}

	public Integer getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(Integer noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public Integer getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public Integer getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [utilisateur=");
		builder.append(utilisateur);
		builder.append(", lstEncheres=");
		builder.append(lstEncheres);
		builder.append(", categorieArticle=");
		builder.append(categorieArticle);
		builder.append(", lieuRetrait=");
		builder.append(lieuRetrait);
		builder.append(", noArticle=");
		builder.append(noArticle);
		builder.append(", nomArticle=");
		builder.append(nomArticle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebutEncheres=");
		builder.append(dateDebutEncheres);
		builder.append(", dateFinEncheres=");
		builder.append(dateFinEncheres);
		builder.append(", miseAPrix=");
		builder.append(miseAPrix);
		builder.append(", prixVente=");
		builder.append(prixVente);
		builder.append(", etatVente=");
		builder.append(etatVente);
		builder.append("]");
		return builder.toString();
	}

}
