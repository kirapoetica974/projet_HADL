package M1.Systeme_Simple_CS.Composant_Serveur;

import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Serveur_Rpc_Lien_Attachement extends Lien_Attachement {

	private static Send_Serveur sendServeur;
	private static Rpc_Called rpcCalled;

	public Serveur_Rpc_Lien_Attachement() throws ExceptionMauvaisLien {

		super(rpcCalled, sendServeur);

		this.sendServeur = new Send_Serveur();
		this.setPortComposantRequis(sendServeur);

		this.rpcCalled = new Rpc_Called();
		this.setRoleFourni(rpcCalled);

	}
}
