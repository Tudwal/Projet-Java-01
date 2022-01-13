package fr.eni.enchere.bll;

import java.util.List;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.EnchereDAO;
import fr.eni.enchere.dal.EnchereDAOFact;
import fr.eni.enchere.dal.jdbc.DALException;

public class EnchereManagerImpl implements EnchereManager {

	private static EnchereDAO dao = EnchereDAOFact.getInstance();

	
	/**
	 *Fonction permettant la création d'un compte Utilisateur après la verification
	 * de tout les champs renseigner par l'utilisateur On verifie aussi si le mot de
	 * passe "admin" est rentrée à la création du compte, dans ce cas le compte
	 * créer est un compte utilisateur
	 */
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
		if (utilisateur.getMotDePasse().equals("admin")) {
			utilisateur.setAdministrateur(1);
		}
		try {
			dao.insertUtilisateur(utilisateur);
		} catch (DALException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Fonction permettant de faire remonter la liste de tout les utilisateur qui
	 * ont crée un compte.
	 * 
	 * @return List<Utilisateur>
	 */
	public List<Utilisateur> afficherTousUtilisateurs() {

		try {
			return dao.getAllUtilisateur();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Fonction permettant de vérifier dans la base de donnée si le pseudo ou
	 * l'email appartiennent à un utilisateur, on verifie aussi que le mot de passe
	 * soit le bon
	 * 
	 * @return boolean
	 */
	public Boolean seConnecter(String identifiant, String motDePasse) {
		Boolean cnx = false;
		try {
			for (Utilisateur u : dao.getAllUtilisateur()) {
				if (((identifiant.equals(u.getEmail()) || identifiant.equals(u.getPseudo()))
						&& motDePasse.equals(u.getMotDePasse()))) {
					cnx = true;
				}
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		return cnx;
	}

	/**
	 * Fonction permettant à un utilisateur de modifier les informations de son
	 * compte, des vérifications de conformiter des champs sont aussi effectués.
	 */
	public void modifCompte(Utilisateur utilisateur) throws BLLException, DALException {
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

		dao.updateUtilisateur(utilisateur);

	}

	/**
	 * Fonction permettant la suppression d'un compte uilisateur à partir de son
	 * numéro d'utilisateur.
	 */
	public void supprimerCompte(Integer noUtilisateur) throws DALException, BLLException {
		BLLException be = new BLLException();
		if (be.hasErreur()) {
			throw be;
		}

		dao.deleteUtilisateur(noUtilisateur);

	}

	/**
	 * Fonction permettant d'afficher un profil utilisateur en fonction de son
	 * noUtilisateur
	 * 
	 * @return Utilisateur
	 */
	public Utilisateur afficherMonProfil(Integer noUtilisateur) throws DALException {
		return dao.getUnUtilisateur(noUtilisateur);

	}

	
	
	
	/**
	 * Fonction permettant de vérifier que le pseudo rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param pseudo
	 * @param be
	 */
	private void verificationPseudo(String pseudo, BLLException be) {
		if (pseudo.length() > 30 || pseudo.isBlank() || pseudo == null) {
			be.ajouterErreur(new ParameterException("Le pseudo est obligatoire et inferieur a 30 caracteres"));
		}
	}

	/**
	 * Fonction permettant de vérifier que le nom rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param nom
	 * @param be
	 */
	private void verificationNom(String nom, BLLException be) {
		if (nom.length() > 30 || nom.isBlank() || nom == null) {
			be.ajouterErreur(new ParameterException("Le nom est obligatoire et inferieur a 30 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le prenom rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param prenom
	 * @param be
	 */
	private void verificationPrenom(String prenom, BLLException be) {
		if (prenom.length() > 30 || prenom.isBlank() || prenom == null) {
			be.ajouterErreur(new ParameterException("Le prenom est obligatoire et inferieur a 30 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le mail rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param email
	 * @param be
	 */
	private void verificationEmail(String email, BLLException be) {
		if (email.length() > 50 || email.isBlank() || email == null) {
			be.ajouterErreur(new ParameterException("L'email est obligatoire et inferieur a 50 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le numéro de téléphone rentrée par
	 * l'utilisateur est conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param telephone
	 * @param be
	 */
	private void verificationTelephone(String telephone, BLLException be) {
		if (telephone.length() > 15) {
			be.ajouterErreur(new ParameterException("Le telephone est inferieur a 15 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que la rue rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param rue
	 * @param be
	 */
	private void verificationRue(String rue, BLLException be) {
		if (rue.length() > 50 || rue.isBlank() || rue == null) {
			be.ajouterErreur(new ParameterException("La rue est obligatoire et inferieur a 50 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le code postal rentrée par l'utilisateur
	 * est conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param codePostal
	 * @param be
	 */
	private void verificationCodePostal(String codePostal, BLLException be) {
		if (codePostal.length() > 10 || codePostal.isBlank() || codePostal == null) {
			be.ajouterErreur(new ParameterException("Le code postal est obligatoire et inferieur a 10 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que la ville rentrée par l'utilisateur est
	 * conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param ville
	 * @param be
	 */
	private void verificationVille(String ville, BLLException be) {
		if (ville.length() > 50 || ville.isBlank() || ville == null) {
			be.ajouterErreur(new ParameterException("La ville est obligatoire et inferieur a 50 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le mot de passe rentrée par l'utilisateur
	 * est conforme aux règles inscrites dans la base de donnée.
	 * 
	 * @param motDePasse
	 * @param be
	 */
	private void verificationMotDePasse(String motDePasse, BLLException be) {
		if (motDePasse.length() > 30 || motDePasse.isBlank() || motDePasse == null) {
			be.ajouterErreur(new ParameterException("Le mot de passe est obligatoire et inferieur a 30 caracteres"));
		}

	}

	/**
	 * Fonction permettant de vérifier que les crédits de l'utilisateur ne sont pas
	 * négatifs
	 * 
	 * @param credit
	 * @param be
	 */
	private void verificationCredit(Integer credit, BLLException be) {
		if (credit < 0 || credit == null) {
			be.ajouterErreur(new ParameterException("Le credit est obligatoire et superieur ou egal a zero"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le champs administrateur ne soit pas null
	 * à la création du compte
	 * 
	 * @param administrateur
	 * @param be
	 */
	private void verificationAdministrateur(Integer administrateur, BLLException be) {
		if (administrateur == null) {
			be.ajouterErreur(new ParameterException("Le code administrateur est obligatoire"));
		}

	}

	/**
	 * Fonction permettant de vérifier que le pseudo et le mail d'un utilisateur
	 * soit bien unique et ne soit pas déja présent dans la base de donnée
	 * 
	 * @param utilisateur
	 * @param be
	 */
	private void verificationDoublon(Utilisateur utilisateur, BLLException be) {
		if (utilisateur.getNoUtilisateur() != null) {
			try {
				for (Utilisateur u : dao.getAllUtilisateur()) {
					if (u.getNoUtilisateur().equals(utilisateur.getNoUtilisateur())) {
						if (!u.getPseudo().equals(utilisateur.getPseudo())
								|| !u.getEmail().equals(utilisateur.getEmail())) {
							try {
								for (Utilisateur u2 : dao.getAllUtilisateur()) {
									if (utilisateur.getEmail().equals(u2.getEmail())
											&& utilisateur.getPseudo().equals(u2.getPseudo())) {
										be.ajouterErreur(new ParameterException("Doublon modif"));
									}

								}
							} catch (DALException e) {
								e.printStackTrace();
							}
						}
					}
				}
			} catch (DALException e) {
				e.printStackTrace();
			}
		} else {
			try {
				for (Utilisateur u : dao.getAllUtilisateur()) {
					if (utilisateur.getEmail().equals(u.getEmail()) || utilisateur.getPseudo().equals(u.getPseudo())) {
						be.ajouterErreur(new ParameterException("Doublon"));
					}

				}
			} catch (DALException e) {
				e.printStackTrace();
			}
		}

	}

}
