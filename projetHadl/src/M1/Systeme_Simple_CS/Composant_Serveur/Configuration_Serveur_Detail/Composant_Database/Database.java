package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import M2.ExceptionDonneeIncorrecte;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;

public class Database extends Composant {

	private Receive_Query_Int receiveQueryInt;
	private Receive_Security_Management receiveSecurityManagement;
	private Send_Query_Int sendQueryInt;
	private Send_Security_Management sendSecurityManagement;

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
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte {
		if (null != receiveSecurityManagement.getElmtStocke()) {
			ObserverConfig obs = ObserverConfig.getInstance();
			System.out.println("je passe par Database.");
			sendSecurityManagement.setElmtStocke(receiveSecurityManagement
					.getElmtStocke());
			receiveSecurityManagement.setElmtStocke(null);
			obs.notifierSortieDonnee(sendSecurityManagement);

		}

	}

}
