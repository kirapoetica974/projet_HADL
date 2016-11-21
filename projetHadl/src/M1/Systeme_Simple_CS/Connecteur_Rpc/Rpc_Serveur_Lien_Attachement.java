package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M1.Systeme_Simple_CS.Composant_Serveur.Receive_Request;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Rpc_Serveur_Lien_Attachement extends Lien_Attachement {

	private static Rpc_Caller rpcCaller = new Rpc_Caller();
	private static Receive_Request receiveRequest = new Receive_Request();

	public Rpc_Serveur_Lien_Attachement() throws ExceptionMauvaisLien {
		super(rpcCaller, receiveRequest);

		this.setRoleRequis(rpcCaller);

		this.setPortComposantFourni(receiveRequest);
	}

}
