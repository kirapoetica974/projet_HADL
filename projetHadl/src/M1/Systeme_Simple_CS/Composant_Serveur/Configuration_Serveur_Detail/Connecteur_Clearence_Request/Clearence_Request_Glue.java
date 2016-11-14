package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class Clearence_Request_Glue extends Glue {

	private Clearence_Request_Caller clearenceRequestCaller;
	private Clearence_Request_Called clearenceRequestCalled;

	public Clearence_Request_Glue() {
		super();

		this.clearenceRequestCaller = new Clearence_Request_Caller();
		this.clearenceRequestCalled = new Clearence_Request_Called();

		this.addRoleFourni(this.clearenceRequestCalled);
		this.addRoleRequis(this.clearenceRequestCaller);
		this.addLienFourniRequis(this.clearenceRequestCalled,
				this.clearenceRequestCaller);
	}

	/**
	 * @return clearenceRequestCaller
	 */
	public Clearence_Request_Caller getClearenceRequestCaller() {
		return clearenceRequestCaller;
	}

	/**
	 * @param clearenceRequestCaller
	 *            : clearenceRequestCaller à modifier
	 */
	public void setClearenceRequestCaller(
			Clearence_Request_Caller clearenceRequestCaller) {
		this.clearenceRequestCaller = clearenceRequestCaller;
	}

	/**
	 * @return clearenceRequestCalled
	 */
	public Clearence_Request_Called getClearenceRequestCalled() {
		return clearenceRequestCalled;
	}

	/**
	 * @param clearenceRequestCalled
	 *            : clearenceRequestCalled à modfier
	 */
	public void setClearenceRequestCalled(
			Clearence_Request_Called clearenceRequestCalled) {
		this.clearenceRequestCalled = clearenceRequestCalled;
	}

}
