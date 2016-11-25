package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Connection_Manager extends Composant {

	private External_Socket_Fourni externalSocket;
	private External_Socket_Requis externalSocketRequis;
	private Receive_DB_Query receiveDBQuery;
	private Receive_Security_Check receiveSecurityCheck;
	private Send_DB_Query sendDBQuery;
	private Send_Security_Check sendSecurityCheck;

	public Connection_Manager() {
		super();

		this.externalSocketRequis = new External_Socket_Requis();
		this.externalSocket = new External_Socket_Fourni();
		this.receiveDBQuery = new Receive_DB_Query();
		this.receiveSecurityCheck = new Receive_Security_Check();
		this.sendDBQuery = new Send_DB_Query();
		this.sendSecurityCheck = new Send_Security_Check();

		this.addInterfaceCommunication(this.externalSocketRequis);
		this.addInterfaceCommunication(this.externalSocket);
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
		if (null != externalSocketRequis.getElmtStocke()) {
			System.out.println("je passe par Connection Manager.");
			sendSecurityCheck.setElmtStocke(externalSocketRequis
					.getElmtStocke());
			externalSocketRequis.setElmtStocke(null);
			obs.notifierSortieDonnee(sendSecurityCheck);

		} else if (null != receiveSecurityCheck.getElmtStocke()) {
			System.out.println("je passe par Connection Manager.");
			sendDBQuery.setElmtStocke(receiveSecurityCheck.getElmtStocke());
			receiveSecurityCheck.setElmtStocke(null);
			obs.notifierSortieDonnee(sendDBQuery);

		}

	}

	public void envoyerDonnee(String s) throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		externalSocket.setElmtStocke(s);
		System.out.println("Connection Manager : j'envoie une donnee ");
		Serveur_Detail.getInstance().getObserver()
				.notifierEntreeDonnee(externalSocket, s);
	}

}
