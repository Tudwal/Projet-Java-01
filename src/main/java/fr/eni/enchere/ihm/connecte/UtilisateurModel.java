/**
 * 
 */
package fr.eni.enchere.ihm.connecte;

import fr.eni.enchere.bo.ArticleVendu;
import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurModel {

	private Utilisateur utilisateur;

	private String message = "";

	private ArticleVendu articleVendu;

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
		builder.append("]");
		return builder.toString();
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

}
