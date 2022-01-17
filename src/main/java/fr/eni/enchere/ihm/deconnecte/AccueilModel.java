/**
 * 
 */
package fr.eni.enchere.ihm.deconnecte;

import java.util.ArrayList;
import java.util.List;

import fr.eni.enchere.bo.ArticleVendu;

public class AccueilModel {

	private List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
	private String message = "";

	public AccueilModel() {
	}

	public AccueilModel(List<ArticleVendu> lstArticles, String message) {
		super();
		this.lstArticles = lstArticles;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AccueilModel [message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

}
