package M1.Systeme_Simple_CS.Composant_Client;

import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Client_Rpc_Lien_Attachement extends Lien_Attachement {

	private static Send_Request sendRequest = new Send_Request();
	private static Rpc_Called rpcCalled = new Rpc_Called();

	public Client_Rpc_Lien_Attachement() throws ExceptionMauvaisLien {

		super(rpcCalled, sendRequest);

		this.setPortComposantRequis(sendRequest);
		this.setRoleFourni(rpcCalled);

	}
}
