package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M1.Systeme_Simple_CS.Composant_Serveur.Receive_Request;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Rpc_Lien_Attachement extends Lien_Attachement {

	private static Rpc_Caller rpcCaller;
	private static Receive_Request receiveRequest;

	public Rpc_Lien_Attachement(Rpc_Caller rpcCaller,
			Receive_Request receiveRequest) throws ExceptionMauvaisLien {
		super(rpcCaller, receiveRequest);

		this.rpcCaller = rpcCaller;
		this.receiveRequest = receiveRequest;
	}

}
