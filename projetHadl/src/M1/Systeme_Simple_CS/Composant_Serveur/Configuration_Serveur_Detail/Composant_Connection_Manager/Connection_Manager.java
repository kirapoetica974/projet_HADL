package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Connection_Manager extends Composant {
	private final String BDD_DISPO = "BDD DISPO";
	private final String BDD_NON_DISPO = "BDD NON DISPO";
	private final String IS_BDD_DISPO = "BDD DISPO ?";
	private final String CONNEXION_OK = "CONNEXION OK";
	private final String CONNEXION_NON_OK = "CONNEXION NON OK";

	private External_Socket_Fourni externalSocketFourni;
	private External_Socket_Requis externalSocketRequis;
	private Receive_DB_Query receiveDBQuery;
	private Receive_Security_Check receiveSecurityCheck;
	private Send_DB_Query sendDBQuery;
	private Send_Security_Check sendSecurityCheck;

	private Boolean securityCheck;
	private String donneeEnAttente;

	public Connection_Manager() {
		super();

		this.securityCheck = false;
		this.donneeEnAttente = null;

		this.externalSocketRequis = new External_Socket_Requis();
		this.externalSocketFourni = new External_Socket_Fourni();
		this.receiveDBQuery = new Receive_DB_Query();
		this.receiveSecurityCheck = new Receive_Security_Check();
		this.sendDBQuery = new Send_DB_Query();
		this.sendSecurityCheck = new Send_Security_Check();

		this.addInterfaceCommunication(this.externalSocketRequis);
		this.addInterfaceCommunication(this.externalSocketFourni);
		this.addInterfaceCommunication(this.receiveDBQuery);
		this.addInterfaceCommunication(this.receiveSecurityCheck);
		this.addInterfaceCommunication(this.sendDBQuery);
		this.addInterfaceCommunication(this.sendSecurityCheck);
		this.setNom("Connection_Manager");
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		ObserverConfig obs = Serveur_Detail.getInstance().getObserver();

		// On demande à Security Manager si la bdd est dispo
		if (null != externalSocketRequis.getElmtStocke() && !securityCheck) {
			System.out.println("Donnée en traitement dans Connection Manager");
			donneeEnAttente = externalSocketRequis.getElmtStocke();
			externalSocketRequis.setElmtStocke(null);
			sendSecurityCheck.setElmtStocke(IS_BDD_DISPO);
			obs.notifierSortieDonnee(sendSecurityCheck);
		} else if (null != receiveSecurityCheck.getElmtStocke()) {
			if (BDD_DISPO.equals(receiveSecurityCheck.getElmtStocke())) {
				System.out
						.println("La base de donnée est disponible, on peut l'utiliser.");
				if (donneeEnAttente.contains("CONNEXION")) {
					sendSecurityCheck.setElmtStocke(donneeEnAttente);
					receiveSecurityCheck.setElmtStocke(null);
					obs.notifierSortieDonnee(sendSecurityCheck);
				} else {
					sendDBQuery.setElmtStocke(donneeEnAttente);
					receiveSecurityCheck.setElmtStocke(null);
					obs.notifierSortieDonnee(sendDBQuery);
				}

			} else if (BDD_NON_DISPO.equals(receiveSecurityCheck
					.getElmtStocke())) {
				securityCheck = false;
				externalSocketFourni
						.setElmtStocke("La base de donnée est indisponible");
				receiveSecurityCheck.setElmtStocke(null);
				obs.notifierSortieDonnee(externalSocketFourni);
			} else if (CONNEXION_OK
					.equals(receiveSecurityCheck.getElmtStocke())) {
				receiveSecurityCheck.setElmtStocke(null);
				externalSocketFourni.setElmtStocke(CONNEXION_OK);
				obs.notifierSortieDonnee(externalSocketFourni);
			} else if (CONNEXION_NON_OK.equals(receiveSecurityCheck
					.getElmtStocke())) {
				receiveSecurityCheck.setElmtStocke(null);
				externalSocketFourni.setElmtStocke(CONNEXION_NON_OK);
				obs.notifierSortieDonnee(externalSocketFourni);
			}

		} else if (null != receiveDBQuery.getElmtStocke()) {
			externalSocketFourni.setElmtStocke(receiveDBQuery.getElmtStocke());
			receiveDBQuery.setElmtStocke(null);
			obs.notifierSortieDonnee(externalSocketFourni);
		}

	}

	public void envoyerDonnee(String s) throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		externalSocketFourni.setElmtStocke(s);
		System.out.println("Connection Manager : j'envoie une donnee ");
		Serveur_Detail.getInstance().getObserver()
				.notifierEntreeDonnee(externalSocketFourni, s);
	}

}
