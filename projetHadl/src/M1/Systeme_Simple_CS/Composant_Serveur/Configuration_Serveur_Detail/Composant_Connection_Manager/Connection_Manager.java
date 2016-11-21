package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant;

public class Connection_Manager extends Composant {

	private External_Socket_Fourni externalSocket;
	private Receive_DB_Query receiveDBQuery;
	private Receive_Security_Check receiveSecurityCheck;
	private Send_DB_Query sendDBQuery;
	private Send_Security_Check sendSecurityCheck;

	public Connection_Manager() {
		super();

		this.externalSocket = new External_Socket_Fourni();
		this.receiveDBQuery = new Receive_DB_Query();
		this.receiveSecurityCheck = new Receive_Security_Check();
		this.sendDBQuery = new Send_DB_Query();
		this.sendSecurityCheck = new Send_Security_Check();

		this.addInterfaceCommunication(this.externalSocket);
		this.addInterfaceCommunication(this.receiveDBQuery);
		this.addInterfaceCommunication(this.receiveSecurityCheck);
		this.addInterfaceCommunication(this.sendDBQuery);
		this.addInterfaceCommunication(this.sendSecurityCheck);
	}

}
