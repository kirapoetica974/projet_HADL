package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Explicite;

public class Rpc extends Connecteur_Explicite {

	private Rpc_Glue rpcGlue;

	/**
	 * Constructeur
	 */
	public Rpc() {
		super();
		this.setNom("Rpc");
		this.rpcGlue = new Rpc_Glue();
		this.setGlue(rpcGlue);
	}

	@Override
	public void transmetDonnee() {
		// TODO Auto-generated method stub

	}

}
