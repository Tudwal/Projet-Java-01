/**
 * 
 */
package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {

	private List<ArticleVendu> lstArticlesVendus = new ArrayList<>();
	
	private Integer noCategorie;
	private String libelle;
	
	
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}



	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	
	
	public List<ArticleVendu> getLstArticlesVendus() {
		return lstArticlesVendus;
	}
	public void setLstArticlesVendus(List<ArticleVendu> lstArticlesVendus) {
		this.lstArticlesVendus = lstArticlesVendus;
	}
	public Integer getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [lstArticlesVendus=");
		builder.append(lstArticlesVendus);
		builder.append(", noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
