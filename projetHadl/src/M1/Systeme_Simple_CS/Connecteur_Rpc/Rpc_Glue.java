package M1.Systeme_Simple_CS.Connecteur_Rpc;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class Rpc_Glue extends Glue {

	private Rpc_Caller rpcCaller;
	private Rpc_Called rpcCalled;

	/**
	 * @param rpcCaller
	 * @param rpcCalled
	 */
	public Rpc_Glue() {
		super();

		this.rpcCaller = new Rpc_Caller();
		this.rpcCalled = new Rpc_Called();

		this.addRoleFourni(this.rpcCalled);
		this.addRoleRequis(this.rpcCaller);

		this.addLienFourniRequis(this.rpcCalled, this.rpcCaller);
	}

	/**
	 * @return the rpcCaller
	 */
	public Rpc_Caller getRpcCaller() {
		return rpcCaller;
	}

	/**
	 * @param rpcCaller
	 *            the rpcCaller to set
	 */
	public void setRpcCaller(Rpc_Caller rpcCaller) {
		this.rpcCaller = rpcCaller;
	}

	/**
	 * @return the rpcCalled
	 */
	public Rpc_Called getRpcCalled() {
		return rpcCalled;
	}

	/**
	 * @param rpcCalled
	 *            the rpcCalled to set
	 */
	public void setRpcCalled(Rpc_Called rpcCalled) {
		this.rpcCalled = rpcCalled;
	}

}
