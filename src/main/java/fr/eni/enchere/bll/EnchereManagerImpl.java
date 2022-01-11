package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.EnchereDAOFact;

public class EnchereManagerImpl implements EnchereManager {

	private static EnchereDAO dao = EnchereDAOFact.getInstance();

	@Override
	public void creerCompte(Utilisateur utilisateur) throws BLLException {
		BLLException be = new BLLException();

		verificationPseudo(utilisateur.getPseudo(), be);
		verificationNom(utilisateur.getNom(), be);
		verificationPrenom(utilisateur.getPrenom(), be);
		verificationEmail(utilisateur.getEmail(), be);
		verificationTelephone(utilisateur.getTelephone(), be);
		verificationRue(utilisateur.getRue(), be);
		verificationCodePostal(utilisateur.getCodePostal(), be);
		verificationVille(utilisateur.getVille(), be);
		verificationMotDePasse(utilisateur.getMotDePasse(), be);
		verificationCredit(utilisateur.getCredit(), be);
		verificationAdministrateur(utilisateur.getAdministrateur(), be);
		verificationDoublon(utilisateur, be);

		if (be.hasErreur()) {
			throw be;
		}

		dao.insertUtilisateur(utilisateur);

	}

	@Override
	public List<Utilisateur> afficherTousUtilisateurs() {

		return dao.getAllUtilisateur();
	}

	public Boolean seConnecter(String identifiant, String motDePasse) {
		Boolean cnx = false;
		for (Utilisateur u : dao.getAllUtilisateur()) {
			if (((identifiant.equals(u.getNom()) || identifiant.equals(u.getPseudo()))
					&& motDePasse.equals(u.getPseudo()))) {
				cnx = true;
			}
		}
		return cnx;
	}

	private void verificationPseudo(String pseudo, BLLException be) {
		if (pseudo.length() > 30 || pseudo.isBlank() || pseudo == null) {
			be.ajouterErreur(new ParameterException("Le pseudo est obligatoire et inferieur a 30 caracteres"));
		}
	}

	private void verificationNom(String nom, BLLException be) {
		if (nom.length() > 30 || nom.isBlank() || nom == null) {
			be.ajouterErreur(new ParameterException("Le nom est obligatoire et inferieur a 30 caracteres"));
		}

	}

	private void verificationPrenom(String prenom, BLLException be) {
		if (prenom.length() > 30 || prenom.isBlank() || prenom == null) {
			be.ajouterErreur(new ParameterException("Le prenom est obligatoire et inferieur a 30 caracteres"));
		}

	}

	private void verificationEmail(String email, BLLException be) {
		if (email.length() > 50 || email.isBlank() || email == null) {
			be.ajouterErreur(new ParameterException("L'email est obligatoire et inferieur a 50 caracteres"));
		}

	}

	private void verificationTelephone(String telephone, BLLException be) {
		if (telephone.length() > 15) {
			be.ajouterErreur(new ParameterException("Le telephone est inferieur a 15 caracteres"));
		}

	}

	private void verificationRue(String rue, BLLException be) {
		if (rue.length() > 50 || rue.isBlank() || rue == null) {
			be.ajouterErreur(new ParameterException("La rue est obligatoire et inferieur a 50 caracteres"));
		}

	}

	private void verificationCodePostal(String codePostal, BLLException be) {
		if (codePostal.length() > 10 || codePostal.isBlank() || codePostal == null) {
			be.ajouterErreur(new ParameterException("Le code postal est obligatoire et inferieur a 10 caracteres"));
		}

	}

	private void verificationVille(String ville, BLLException be) {
		if (ville.length() > 50 || ville.isBlank() || ville == null) {
			be.ajouterErreur(new ParameterException("La ville est obligatoire et inferieur a 50 caracteres"));
		}

	}

	private void verificationMotDePasse(String motDePasse, BLLException be) {
		if (motDePasse.length() > 30 || motDePasse.isBlank() || motDePasse == null) {
			be.ajouterErreur(new ParameterException("Le mot de passe est obligatoire et inferieur a 30 caracteres"));
		}

	}

	private void verificationCredit(Integer credit, BLLException be) {
		if (credit < 0 || credit == null) {
			be.ajouterErreur(new ParameterException("Le credit est obligatoire et superieur ou egal a zero"));
		}

	}

	private void verificationAdministrateur(Byte administrateur, BLLException be) {
		if (administrateur == null) {
			be.ajouterErreur(new ParameterException("Le code administrateur est obligatoire"));
		}

	}

	private void verificationDoublon(Utilisateur utilisateur, BLLException be) {
		// TODO a revoir conditions
		for (Utilisateur u : dao.getAllUtilisateur()) {
			if (utilisateur.getNom().equalsIgnoreCase(u.getNom())
					&& utilisateur.getPseudo().equalsIgnoreCase(u.getPseudo())) {
				be.ajouterErreur(new ParameterException("Doublon"));
			}

		}
	}

}
