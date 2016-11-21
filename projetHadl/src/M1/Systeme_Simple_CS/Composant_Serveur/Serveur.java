package M1.Systeme_Simple_CS.Composant_Serveur;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant;

public class Serveur extends Composant {

	private Receive_Request receiveRequest;
	private Send_Serveur sendRequestServeur;

	public Serveur() {
		super();

		this.receiveRequest = new Receive_Request();
		this.sendRequestServeur = new Send_Serveur();

		this.addInterfaceCommunication(this.receiveRequest);
		this.addInterfaceCommunication(this.sendRequestServeur);
	}

	@Override
	public void transmetDonnee() {
		// TODO Auto-generated method stub

	}

}
