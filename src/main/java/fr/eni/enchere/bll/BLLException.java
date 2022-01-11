package fr.eni.enchere.bll;

import java.util.ArrayList;
import java.util.List;

public class BLLException extends Exception {

	private static final long serialVersionUID = 1L;

	private List<Exception> erreurs = new ArrayList<Exception>();

	public void ajouterErreur(Exception e) {
		erreurs.add(e);
	}

	public boolean hasErreur() {
		return !erreurs.isEmpty();
	}

	public BLLException() {
		super();
	}

	public BLLException(List<Exception> erreurs) {
		super();
		this.erreurs = erreurs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("");
		builder.append(System.lineSeparator());
		for (Exception exception : erreurs) {
			builder.append(exception.getMessage()).append(System.lineSeparator());
		}

		return builder.toString();
	}

}
