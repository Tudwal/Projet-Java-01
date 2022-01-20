/**
 * 
 */
package fr.eni.enchere.ihm.connecte;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurModel {

	private Utilisateur utilisateur;

	private String message = "";

	private ArticleVendu articleVendu;
	
	private List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
	
	private Utilisateur autreUtilisateur;
	
	private Enchere enchere;
	
	private List<Enchere> lstEncheres = new ArrayList<Enchere>();

	public UtilisateurModel() {
		// TODO Auto-generated constructor stub
	}

	public UtilisateurModel(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}





	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UtilisateurModel [utilisateur=");
		builder.append(utilisateur);
		builder.append(", message=");
		builder.append(message);
		builder.append(", articleVendu=");
		builder.append(articleVendu);
		builder.append(", lstArticles=");
		builder.append(lstArticles);
		builder.append(", autreUtilisateur=");
		builder.append(autreUtilisateur);
		builder.append("]");
		return builder.toString();
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

	public Utilisateur getAutreUtilisateur() {
		return autreUtilisateur;
	}

	public void setAutreUtilisateur(Utilisateur autreUtilisateur) {
		this.autreUtilisateur = autreUtilisateur;
	}

	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	public List<Enchere> getLstEnchere() {
		return lstEncheres;
	}

	public void setLstEnchere(List<Enchere> lstEnchere) {
		this.lstEncheres = lstEnchere;
	}

}
