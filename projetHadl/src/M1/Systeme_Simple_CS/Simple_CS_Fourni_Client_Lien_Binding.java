package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Receive_Client;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Simple_CS_Fourni_Client_Lien_Binding extends Lien_Binding {

	private Receive_Client receiveClient;
	private Simple_CS_Fourni simpleCSFourni;

	public Simple_CS_Fourni_Client_Lien_Binding(Receive_Client receiveClient,
			Simple_CS_Fourni simpleCSFourni) throws ExceptionMauvaisLien {
		super(receiveClient, simpleCSFourni);

		this.receiveClient = receiveClient;
		this.simpleCSFourni = simpleCSFourni;
	}

}
