package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import java.util.HashMap;
import java.util.logging.Logger;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Database extends Composant {
	private static final String BDD_DISPO = "BDD DISPO";
	private static final String BDD_NON_DISPO = "BDD NON DISPO";
	private static final String IS_BDD_DISPO = "BDD DISPO ?";
	private static final String REQUETE = "REQUETE";
	private static final String CONNEXION = "CONNEXION";
	private static final String CONNEXION_OK = "CONNEXION OK";
	private static final String CONNEXION_NON_OK = "CONNEXION NON OK";
	private static final String PSEUDO = "pseudo";
	private static final String MOT_DE_PASSE = "mdp";
	private static final String NOM = "nom";
	private static final String PRENOM = "prenom";
	private static final String QUANTITE = "quantite";
	private static final String PRIX = "prix";
	private static final String AJOUT = "AJOUT";
	private static final String INSCRIPTION = "INSCRIPTION";

	private final static Logger logger = Logger.getLogger(Logger.class
			.getName());

	private Receive_Query_Int receiveQueryInt;
	private Receive_Security_Management receiveSecurityManagement;
	private Send_Query_Int sendQueryInt;
	private Send_Security_Management sendSecurityManagement;

	private Boolean dispo;

	private HashMap<String, HashMap<String, String>> bddElements = new HashMap<String, HashMap<String, String>>();
	private HashMap<String, HashMap<String, String>> bddPersonnes = new HashMap<String, HashMap<String, String>>();

	public Database() {
		super();

		this.dispo = true;

		this.receiveQueryInt = new Receive_Query_Int();
		this.receiveSecurityManagement = new Receive_Security_Management();
		this.sendQueryInt = new Send_Query_Int();
		this.sendSecurityManagement = new Send_Security_Management();

		this.setNom("Database");
		this.addInterfaceCommunication(receiveQueryInt);
		this.addInterfaceCommunication(receiveSecurityManagement);
		this.addInterfaceCommunication(sendQueryInt);
		this.addInterfaceCommunication(sendSecurityManagement);

		HashMap<String, String> pers1 = new HashMap<String, String>();
		pers1.put(NOM, "Marin");
		pers1.put(PRENOM, "Poisson");
		pers1.put(PSEUDO, "mPoisson");
		pers1.put(MOT_DE_PASSE, "toto44");

		HashMap<String, String> legume1 = new HashMap<String, String>();
		legume1.put(NOM, "carotte");
		legume1.put(QUANTITE, "2");
		legume1.put(PRIX, "1");

		this.bddPersonnes.put("personne", pers1);
		this.bddElements.put("legume", legume1);
	}

	private String afficheHashMap(HashMap<String, String> hash) {
		String result = "--------------------------\n";
		for (String mapKey : hash.keySet()) {
			result = result + mapKey + " : ";
			result = result + hash.get(mapKey) + "\n";
		}
		return result;
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		ObserverConfig obs = Serveur_Detail.getInstance().getObserver();

		// Dans le cas d'une vérification de disponibilité de la bdd
		if (null != receiveSecurityManagement.getElmtStocke()
				&& IS_BDD_DISPO.equals(receiveSecurityManagement
						.getElmtStocke())) {
			verifierBddDisponible(obs);

		}
		// Dans le cas d'une requête
		else if (null != receiveQueryInt.getElmtStocke()
				&& receiveQueryInt.getElmtStocke().contains(REQUETE)) {
			traiterRequete(obs);
		}
		// Dans le cas d'une connexion
		else if (null != receiveSecurityManagement.getElmtStocke()
				&& receiveSecurityManagement.getElmtStocke()
						.contains(CONNEXION)) {
			verifierConnexionUtilisateur(obs);

		}
		// Dans le cas d'un ajout
		else if (null != receiveQueryInt.getElmtStocke()
				&& receiveQueryInt.getElmtStocke().contains(AJOUT)) {
			ajouterElement(obs);
		}
		// Dans le cas d'une inscription
		else if (null != receiveQueryInt.getElmtStocke()
				&& receiveQueryInt.getElmtStocke().contains(INSCRIPTION)) {
			inscrire(obs);
		}

	}

	private void inscrire(ObserverConfig obs) throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		dispo = false;
		String user = receiveQueryInt.getElmtStocke().substring(6);
		String[] parts = user.split("-");
		String nom = parts[0];
		String prenom = parts[1];
		String pseudo = parts[2];
		String mdp = parts[3];

		HashMap<String, String> pers1 = new HashMap<String, String>();
		pers1.put(NOM, nom);
		pers1.put(PRENOM, prenom);
		pers1.put(PSEUDO, pseudo);
		pers1.put(MOT_DE_PASSE, mdp);

		bddPersonnes.put(pseudo, pers1);
		sendQueryInt
				.setElmtStocke("Inscription terminée. Vous devez maintenant vous connecter.");
		receiveQueryInt.setElmtStocke(null);
		obs.notifierSortieDonnee(sendQueryInt);
		dispo = true;
	}

	/**
	 * @param obs
	 * @throws ExceptionDonneeIncorrecte
	 * @throws MauvaiseConfigurationException
	 * @throws ExceptionMauvaisLien
	 */
	private void ajouterElement(ObserverConfig obs)
			throws ExceptionDonneeIncorrecte, MauvaiseConfigurationException,
			ExceptionMauvaisLien {
		dispo = false;
		String id = receiveQueryInt.getElmtStocke().substring(6);
		String[] parts = id.split("-");
		String type = parts[0];
		String nom = parts[1];
		String quantite = parts[2];
		String prix = parts[3];

		HashMap<String, String> elmt = new HashMap<String, String>();
		elmt.put(NOM, nom);
		elmt.put(QUANTITE, quantite);
		elmt.put(PRIX, prix);
		bddElements.put(type, elmt);
		sendQueryInt.setElmtStocke("L'élément a bien été ajouté.");
		receiveQueryInt.setElmtStocke(null);
		obs.notifierSortieDonnee(sendQueryInt);
		dispo = true;
	}

	/**
	 * @param obs
	 * @throws ExceptionDonneeIncorrecte
	 * @throws MauvaiseConfigurationException
	 * @throws ExceptionMauvaisLien
	 */
	private void verifierConnexionUtilisateur(ObserverConfig obs)
			throws ExceptionDonneeIncorrecte, MauvaiseConfigurationException,
			ExceptionMauvaisLien {
		dispo = false;
		String id = receiveSecurityManagement.getElmtStocke().substring(10);
		String[] parts = id.split("-");
		String pseudo = parts[0];
		String mdp = parts[1];

		for (String personnes : bddPersonnes.keySet()) {
			if (bddPersonnes.get(personnes).get(PSEUDO).equals(pseudo)
					&& bddPersonnes.get(personnes).get(MOT_DE_PASSE)
							.equals(mdp)) {
				sendSecurityManagement.setElmtStocke(CONNEXION_OK);
				receiveSecurityManagement.setElmtStocke(null);
				obs.notifierSortieDonnee(sendSecurityManagement);
				dispo = true;
			} else {
				sendQueryInt.setElmtStocke(CONNEXION_NON_OK);
				receiveQueryInt.setElmtStocke(null);
				obs.notifierSortieDonnee(sendQueryInt);
				dispo = true;
			}
		}
	}

	/**
	 * @param obs
	 * @throws ExceptionDonneeIncorrecte
	 * @throws MauvaiseConfigurationException
	 * @throws ExceptionMauvaisLien
	 */
	private void traiterRequete(ObserverConfig obs)
			throws ExceptionDonneeIncorrecte, MauvaiseConfigurationException,
			ExceptionMauvaisLien {
		dispo = false;
		String requete = receiveQueryInt.getElmtStocke().substring(8);
		String resultRequete = "";
		for (String mapKey : bddElements.keySet()) {
			if (mapKey.equals(requete)) {
				resultRequete = resultRequete
						+ afficheHashMap(bddElements.get(mapKey));
				System.out.println("Une donnée a été trouvée");
			}
		}
		if (resultRequete.isEmpty()) {
			resultRequete = "Aucune donnée trouvée";
			System.out.println("Aucune donnée trouvée");
		}
		sendQueryInt.setElmtStocke(resultRequete);
		receiveQueryInt.setElmtStocke(null);
		obs.notifierSortieDonnee(sendQueryInt);
		dispo = true;
	}

	/**
	 * @param obs
	 * @throws ExceptionDonneeIncorrecte
	 * @throws MauvaiseConfigurationException
	 * @throws ExceptionMauvaisLien
	 */
	private void verifierBddDisponible(ObserverConfig obs)
			throws ExceptionDonneeIncorrecte, MauvaiseConfigurationException,
			ExceptionMauvaisLien {
		if (dispo) {
			sendSecurityManagement.setElmtStocke(BDD_DISPO);
		} else {
			sendSecurityManagement.setElmtStocke(BDD_NON_DISPO);
		}
		System.out.println("Vérification de la disponibilité de la bdd.");
		receiveSecurityManagement.setElmtStocke(null);
		obs.notifierSortieDonnee(sendSecurityManagement);
	}

}
