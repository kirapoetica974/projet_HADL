package M1.Systeme_Simple_CS.Composant_Client;

import M2.ExceptionDonneeIncorrecte;
import M2.ObserverConfig;
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

	public void envoyerDonnee(String s) throws ExceptionDonneeIncorrecte {
		sendRequest.setElmtStocke(s);
		System.out.println("Client : j'envoie une donnee 'blabla' ");
		ObserverConfig.getInstance().notifierSortieDonnee(sendRequest);
	}

}
