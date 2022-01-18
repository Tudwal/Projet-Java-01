/**
 * 
 */
package fr.eni.enchere.bo;

import java.util.Date;

public class Enchere {

	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	
	private Integer noEnchere;
	private Date dateEnchere;
	private Integer montantEnchere=0;
	
	
	
	public Enchere() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Enchere(ArticleVendu articleVendu, Utilisateur utilisateur, Date dateEnchere, Integer montantEnchere) {
		super();
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}


	public Enchere(ArticleVendu articleVendu, Utilisateur utilisateur, Integer noEnchere, Date dateEnchere,
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
	public Date getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(Date dateEnchere) {
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
