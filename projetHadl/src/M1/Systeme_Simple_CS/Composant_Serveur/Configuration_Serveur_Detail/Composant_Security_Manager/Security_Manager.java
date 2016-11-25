package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Security_Manager extends Composant {

	private Receive_C_Query receiveCQuery;
	private Receive_Security_Auth receiveSecurityAuth;
	private Send_C_Query sendCQuery;
	private Send_Security_Auth sendSecurityAuth;

	public Security_Manager() {
		super();

		this.receiveCQuery = new Receive_C_Query();
		this.receiveSecurityAuth = new Receive_Security_Auth();
		this.sendCQuery = new Send_C_Query();
		this.sendSecurityAuth = new Send_Security_Auth();

		this.setNom("Security_Manager");
		this.addInterfaceCommunication(receiveCQuery);
		this.addInterfaceCommunication(receiveSecurityAuth);
		this.addInterfaceCommunication(sendCQuery);
		this.addInterfaceCommunication(sendSecurityAuth);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		ObserverConfig obs = Serveur_Detail.getInstance().getObserver();
		if (null != receiveSecurityAuth.getElmtStocke()) {
			System.out.println("je passe par Security_Manager");
			this.sendCQuery.setElmtStocke(receiveSecurityAuth.getElmtStocke());
			receiveSecurityAuth.setElmtStocke(null);
			obs.notifierSortieDonnee(sendCQuery);
		} else if (null != receiveCQuery.getElmtStocke()) {
			System.out.println("je passe par Security_Manager");
			this.sendSecurityAuth.setElmtStocke(receiveCQuery.getElmtStocke());
			receiveCQuery.setElmtStocke(null);
			obs.notifierSortieDonnee(sendSecurityAuth);
		}

	}

}
