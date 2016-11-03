package M1.Systeme_Simple_CS.Composant_Serveur;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant;

public class Serveur extends Composant {

	private Receive_Request receiveRequest;

	public Serveur() {
		super();

		this.receiveRequest = new Receive_Request();

		this.addInterfaceCommunication(this.receiveRequest);
	}

}
