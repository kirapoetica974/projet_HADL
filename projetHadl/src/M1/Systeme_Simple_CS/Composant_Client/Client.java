package M1.Systeme_Simple_CS.Composant_Client;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant_Simple;

public class Client extends Composant_Simple {

	private Send_Request sendRequest;

	/**
	 * @param sendRequest
	 */
	public Client() {
		super();

		this.sendRequest = new Send_Request();

		this.addInterfaceCommunication(this.sendRequest);

	}

}
