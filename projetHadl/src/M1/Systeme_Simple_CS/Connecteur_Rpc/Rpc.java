package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Simple_Explicite;

public class Rpc extends Connecteur_Simple_Explicite {

	private Rpc_Glue rpcGlue;

	/**
	 * Constructeur
	 */
	public Rpc() {
		super();
		this.rpcGlue = new Rpc_Glue();
		this.setGlue(rpcGlue);
	}

}
