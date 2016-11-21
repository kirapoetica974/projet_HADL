package M1.Systeme_Simple_CS.Composant_Client;

import M2.ExceptionDonneeIncorrecte;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;

public class Client extends Composant {

	private Send_Request sendRequest;
	private Receive_Client receiveClient;

	/**
	 * @param sendRequest
	 */
	public Client() {
		super();

		this.sendRequest = new Send_Request();
		this.receiveClient = new Receive_Client();

		this.addInterfaceCommunication(this.sendRequest);
		this.addInterfaceCommunication(this.receiveClient);

	}

	public void envoyerDonnee(String s) throws ExceptionDonneeIncorrecte {
		sendRequest.setElmtStocke(s);
		System.out.println("Client : j'envoie une donnee 'blabla' ");
		ObserverConfig.getInstance().notifierSortieDonnee(sendRequest);
	}

}
