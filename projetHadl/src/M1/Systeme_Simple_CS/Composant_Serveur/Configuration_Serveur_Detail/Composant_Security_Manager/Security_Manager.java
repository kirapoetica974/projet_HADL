package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant_Simple;

public class Security_Manager extends Composant_Simple {

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
	}

}