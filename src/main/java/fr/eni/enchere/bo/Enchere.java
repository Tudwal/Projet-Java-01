/**
 * 
 */
package fr.eni.enchere.bo;

import java.time.LocalDateTime;

public class Enchere {

	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	
	private Integer noEnchere;
	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	
	
	
	public Enchere() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Enchere(ArticleVendu articleVendu, Utilisateur utilisateur, LocalDateTime dateEnchere, Integer montantEnchere) {
		super();
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public Enchere(ArticleVendu articleVendu, Utilisateur utilisateur, Integer noEnchere, LocalDateTime dateEnchere,
			Integer montantEnchere) {
		super();
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	
	
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Integer getNoEnchere() {
		return noEnchere;
	}
	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Integer getMontantEnchere() {
		return montantEnchere;
	}
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enchere [articleVendu=");
		builder.append(articleVendu);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append(", noEnchere=");
		builder.append(noEnchere);
		builder.append(", dateEnchere=");
		builder.append(dateEnchere);
		builder.append(", montantEnchere=");
		builder.append(montantEnchere);
		builder.append("]");
		return builder.toString();
	}
	
	
}
