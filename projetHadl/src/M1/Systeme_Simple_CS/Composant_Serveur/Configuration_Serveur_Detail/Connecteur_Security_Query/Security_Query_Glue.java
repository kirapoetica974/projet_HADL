package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class Security_Query_Glue extends Glue {

	private Security_Query_Caller_Database securityQueryCallerDatabase;
	private Security_Query_Called_Security_Manager securityQueryCalledSecurityManager;
	private Security_Query_Caller_Security_Manager securityQueryCallerSecurityManager;
	private Security_Query_Called_Database securityQueryCalledDatabase;

	public Security_Query_Glue() {
		super();

		this.securityQueryCalledSecurityManager = new Security_Query_Called_Security_Manager();
		this.securityQueryCallerDatabase = new Security_Query_Caller_Database();
		this.securityQueryCalledDatabase = new Security_Query_Called_Database();
		this.securityQueryCallerSecurityManager = new Security_Query_Caller_Security_Manager();

		this.addRoleFourni(this.securityQueryCalledSecurityManager);
		this.addRoleRequis(this.securityQueryCallerDatabase);
		this.addRoleFourni(this.securityQueryCalledDatabase);
		this.addRoleRequis(this.securityQueryCallerSecurityManager);

		this.addLienFourniRequis(this.securityQueryCalledSecurityManager,
				this.securityQueryCallerDatabase);
		this.addLienFourniRequis(this.securityQueryCalledDatabase,
				this.securityQueryCallerSecurityManager);
	}

	/**
	 * @return securityQueryCaller
	 */
	public Security_Query_Caller_Database getSecurityQueryCaller() {
		return securityQueryCallerDatabase;
	}

	/**
	 * @param securityQueryCaller
	 *            : securityQueryCaller à modifier
	 */
	public void setSecurityQueryCaller(
			Security_Query_Caller_Database securityQueryCaller) {
		this.securityQueryCallerDatabase = securityQueryCaller;
	}

	/**
	 * @return securityQueryCalled
	 */
	public Security_Query_Called_Security_Manager getSecurityQueryCalled() {
		return securityQueryCalledSecurityManager;
	}

	/**
	 * @param securityQueryCalled
	 *            : securityQueryCalled à modifier
	 */
	public void setSecurityQueryCalled(
			Security_Query_Called_Security_Manager securityQueryCalled) {
		this.securityQueryCalledSecurityManager = securityQueryCalled;
	}
}
