package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import java.util.HashMap;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Database extends Composant {

	private Receive_Query_Int receiveQueryInt;
	private Receive_Security_Management receiveSecurityManagement;
	private Send_Query_Int sendQueryInt;
	private Send_Security_Management sendSecurityManagement;

	private HashMap<String, HashMap<String, String>> bdd = new HashMap<String, HashMap<String, String>>();

	public Database() {
		super();

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
		pers1.put("nom", "Marin");
		pers1.put("prenom", "Poisson");
		pers1.put("pseudo", "mPoisson");
		pers1.put("mdp", "toto44");

		HashMap<String, String> legume1 = new HashMap<String, String>();
		legume1.put("type", "carotte");
		legume1.put("quantite", "2");
		legume1.put("prix", "1");

		this.bdd.put("Personne", pers1);
		this.bdd.put("Legume", legume1);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		ObserverConfig obs = Serveur_Detail.getInstance().getObserver();
		if (null != receiveSecurityManagement.getElmtStocke()) {
			System.out.println("je passe par Database.");
			sendSecurityManagement.setElmtStocke(receiveSecurityManagement
					.getElmtStocke());
			receiveSecurityManagement.setElmtStocke(null);
			obs.notifierSortieDonnee(sendSecurityManagement);

		} else if (null != receiveQueryInt.getElmtStocke()) {
			System.out.println("je passe par Database.");
			sendQueryInt.setElmtStocke(receiveQueryInt.getElmtStocke());
			receiveQueryInt.setElmtStocke(null);
			obs.notifierSortieDonnee(sendQueryInt);

		}

	}

}
