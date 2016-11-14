package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M1.Systeme_Simple_CS.Composant_Client.Receive_Client;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Rpc_Client_Lien_Attachement extends Lien_Attachement {

	private static Rpc_Caller rpcCaller;
	private static Receive_Client receiveClient;

	public Rpc_Client_Lien_Attachement() throws ExceptionMauvaisLien {
		super(rpcCaller, receiveClient);

		this.rpcCaller = new Rpc_Caller();
		this.setRoleRequis(rpcCaller);

		this.receiveClient = receiveClient;
		this.setPortComposantFourni(receiveClient);
	}
}
