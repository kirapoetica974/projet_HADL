package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant_Simple;

public class Database extends Composant_Simple {

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
	}

}
