/**
 * 
 */
package fr.eni.enchere.ihm;

import fr.eni.enchere.bo.Utilisateur;

public class UtilisateurModel {
	
	private Utilisateur utilisateur;
	
	private String message = "";
	
	

	
	
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EnchereModel [utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}
	
	
}
