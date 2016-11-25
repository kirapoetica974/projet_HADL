package M1.Systeme_Simple_CS.Composant_Client;

import M1.Systeme_Simple_CS.Simple_CS;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

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

		this.setNom("Client");
		this.addInterfaceCommunication(this.sendRequest);
		this.addInterfaceCommunication(this.receiveClient);

	}

	public void envoyerDonnee(String s) throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		sendRequest.setElmtStocke(s);
		System.out.println("Client : j'envoie une donnee 'blabla' ");
		Simple_CS.getInstance().getObserver().notifierSortieDonnee(sendRequest);
	}

	@Override
	public void transmetDonnee() {
		// TODO Auto-generated method stub

	}

}
