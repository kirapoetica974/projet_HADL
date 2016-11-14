package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class Security_Query_Glue extends Glue {

	private Security_Query_Caller securityQueryCaller;
	private Security_Query_Called securityQueryCalled;

	public Security_Query_Glue() {
		super();

		this.securityQueryCalled = new Security_Query_Called();
		this.securityQueryCaller = new Security_Query_Caller();

		this.addRoleFourni(this.securityQueryCalled);
		this.addRoleRequis(this.securityQueryCaller);
		this.addLienFourniRequis(this.securityQueryCalled,
				this.securityQueryCaller);
	}

	/**
	 * @return securityQueryCaller
	 */
	public Security_Query_Caller getSecurityQueryCaller() {
		return securityQueryCaller;
	}

	/**
	 * @param securityQueryCaller
	 *            : securityQueryCaller à modifier
	 */
	public void setSecurityQueryCaller(Security_Query_Caller securityQueryCaller) {
		this.securityQueryCaller = securityQueryCaller;
	}

	/**
	 * @return securityQueryCalled
	 */
	public Security_Query_Called getSecurityQueryCalled() {
		return securityQueryCalled;
	}

	/**
	 * @param securityQueryCalled
	 *            : securityQueryCalled à modifier
	 */
	public void setSecurityQueryCalled(Security_Query_Called securityQueryCalled) {
		this.securityQueryCalled = securityQueryCalled;
	}
}
