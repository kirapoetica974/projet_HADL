package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Serveur.Receive_Request;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.External_Socket;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class External_Socket_Serveur_Lien_Binding extends Lien_Binding {

	private External_Socket externalSocket;
	private Receive_Request receiveRequest;

	public External_Socket_Serveur_Lien_Binding(External_Socket externalSocket,
			Receive_Request receiveRequest) throws ExceptionMauvaisLien {
		super(externalSocket, receiveRequest);

		this.externalSocket = externalSocket;
		this.receiveRequest = receiveRequest;
	}
}
