package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Send_Request;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Simple_CS_Entree_Client_Lien_Binding extends Lien_Binding {

	private Send_Request sendRequest;
	private Simple_CS_Entree simpleCSEntree;

	public Simple_CS_Entree_Client_Lien_Binding(
			Simple_CS_Entree simpleCSEntree, Send_Request sendRequest)
			throws ExceptionMauvaisLien {
		super(sendRequest, simpleCSEntree);

		this.sendRequest = sendRequest;
		this.simpleCSEntree = simpleCSEntree;
	}
}
