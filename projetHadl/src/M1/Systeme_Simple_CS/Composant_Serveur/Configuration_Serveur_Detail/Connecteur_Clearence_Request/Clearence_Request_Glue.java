package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class Clearence_Request_Glue extends Glue {

	private Clearence_Request_Caller_Security_Manager clearenceRequestCallerSecurityManager;
	private Clearence_Request_Called_Connection_Manager clearenceRequestCalledConnectionManager;
	private Clearence_Request_Caller_Connection_Manager clearenceRequestCallerConnectionManager;
	private Clearence_Request_Called_Security_Manager clearenceRequestCalledSecurityManager;

	public Clearence_Request_Glue() {
		super();

		this.clearenceRequestCallerSecurityManager = new Clearence_Request_Caller_Security_Manager();
		this.clearenceRequestCalledConnectionManager = new Clearence_Request_Called_Connection_Manager();
		this.clearenceRequestCallerConnectionManager = new Clearence_Request_Caller_Connection_Manager();
		this.clearenceRequestCalledSecurityManager = new Clearence_Request_Called_Security_Manager();

		this.addRoleFourni(this.clearenceRequestCalledConnectionManager);
		this.addRoleRequis(this.clearenceRequestCallerSecurityManager);
		this.addRoleFourni(clearenceRequestCalledSecurityManager);
		this.addRoleRequis(clearenceRequestCallerConnectionManager);

		this.addLienFourniRequis(this.clearenceRequestCalledConnectionManager,
				this.clearenceRequestCallerSecurityManager);
		this.addLienFourniRequis(clearenceRequestCalledSecurityManager,
				clearenceRequestCallerConnectionManager);
	}

	/**
	 * @return clearenceRequestCaller
	 */
	public Clearence_Request_Caller_Security_Manager getClearenceRequestCaller() {
		return clearenceRequestCallerSecurityManager;
	}

	/**
	 * @param clearenceRequestCaller
	 *            : clearenceRequestCaller à modifier
	 */
	public void setClearenceRequestCaller(
			Clearence_Request_Caller_Security_Manager clearenceRequestCaller) {
		this.clearenceRequestCallerSecurityManager = clearenceRequestCaller;
	}

	/**
	 * @return clearenceRequestCalled
	 */
	public Clearence_Request_Called_Connection_Manager getClearenceRequestCalled() {
		return clearenceRequestCalledConnectionManager;
	}

	/**
	 * @param clearenceRequestCalled
	 *            : clearenceRequestCalled à modfier
	 */
	public void setClearenceRequestCalled(
			Clearence_Request_Called_Connection_Manager clearenceRequestCalled) {
		this.clearenceRequestCalledConnectionManager = clearenceRequestCalled;
	}

}
