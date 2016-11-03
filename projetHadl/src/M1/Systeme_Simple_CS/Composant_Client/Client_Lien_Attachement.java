package M1.Systeme_Simple_CS.Composant_Client;

import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Client_Lien_Attachement extends Lien_Attachement {

	private static Send_Request sendRequest;
	private static Rpc_Called rpcCalled;

	public Client_Lien_Attachement(Send_Request sendRequest,
			Rpc_Called rpcCalled) throws ExceptionMauvaisLien {

		super(rpcCalled, sendRequest);

		this.sendRequest = sendRequest;
		this.rpcCalled = rpcCalled;

	}
}
