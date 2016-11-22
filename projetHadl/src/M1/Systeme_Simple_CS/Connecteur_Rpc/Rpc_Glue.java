package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class Rpc_Glue extends Glue {

	private Rpc_Caller_Client rpcCallerClient;
	private Rpc_Called_Serveur rpcCalledServeur;
	private Rpc_Caller_Serveur rpcCallerServeur;
	private Rpc_Called_Client rpcCalledClient;

	/**
	 * @param rpcCallerClient
	 * @param rpcCalledServeur
	 */
	public Rpc_Glue() {
		super();

		this.rpcCallerClient = new Rpc_Caller_Client();
		this.rpcCalledServeur = new Rpc_Called_Serveur();
		this.rpcCalledClient = new Rpc_Called_Client();
		this.rpcCallerServeur = new Rpc_Caller_Serveur();

		this.addRoleFourni(this.rpcCalledServeur);
		this.addRoleRequis(this.rpcCallerClient);
		this.addRoleFourni(this.rpcCalledClient);
		this.addRoleRequis(rpcCallerServeur);

		this.addLienFourniRequis(this.rpcCalledServeur, this.rpcCallerClient);
		this.addLienFourniRequis(this.rpcCalledClient, this.rpcCallerServeur);
	}

	/**
	 * @return the rpcCaller
	 */
	public Rpc_Caller_Client getRpcCaller() {
		return rpcCallerClient;
	}

	/**
	 * @param rpcCaller
	 *            the rpcCaller to set
	 */
	public void setRpcCaller(Rpc_Caller_Client rpcCaller) {
		this.rpcCallerClient = rpcCaller;
	}

	/**
	 * @return the rpcCalled
	 */
	public Rpc_Called_Serveur getRpcCalled() {
		return rpcCalledServeur;
	}

	/**
	 * @param rpcCalled
	 *            the rpcCalled to set
	 */
	public void setRpcCalled(Rpc_Called_Serveur rpcCalled) {
		this.rpcCalledServeur = rpcCalled;
	}

}
