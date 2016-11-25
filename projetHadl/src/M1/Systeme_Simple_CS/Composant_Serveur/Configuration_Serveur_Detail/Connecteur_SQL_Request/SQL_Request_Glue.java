package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class SQL_Request_Glue extends Glue {

	private SQL_Request_Caller_Database sqlRequestCaller;
	private SQL_Request_Called_Connection_Manager sqlRequestCalled;
	private SQL_Request_Called_Database sqlRequestCalledDatabase;
	private SQL_Request_Caller_Connection_Manager sqlRequestCallerConnectionManager;

	public SQL_Request_Glue() {
		super();

		this.sqlRequestCalledDatabase = new SQL_Request_Called_Database();
		this.sqlRequestCallerConnectionManager = new SQL_Request_Caller_Connection_Manager();
		this.sqlRequestCalled = new SQL_Request_Called_Connection_Manager();
		this.sqlRequestCaller = new SQL_Request_Caller_Database();

		this.addRoleFourni(this.sqlRequestCalled);
		this.addRoleRequis(this.sqlRequestCaller);
		this.addRoleFourni(sqlRequestCalledDatabase);
		this.addRoleRequis(sqlRequestCallerConnectionManager);

		this.addLienFourniRequis(this.sqlRequestCalled, this.sqlRequestCaller);
		this.addLienFourniRequis(sqlRequestCalledDatabase,
				sqlRequestCallerConnectionManager);
	}

	/**
	 * @return sqlRequestCaller
	 */
	public SQL_Request_Caller_Database getSqlRequestCaller() {
		return sqlRequestCaller;
	}

	/**
	 * @param sqlRequestCaller
	 *            : sqlRequestCaller à modifier
	 */
	public void setSqlRequestCaller(SQL_Request_Caller_Database sqlRequestCaller) {
		this.sqlRequestCaller = sqlRequestCaller;
	}

	/**
	 * @return sqlRequestCalled
	 */
	public SQL_Request_Called_Connection_Manager getSqlRequestCalled() {
		return sqlRequestCalled;
	}

	/**
	 * @param sqlRequestCalled
	 *            : sqlRequestCalled à modifier
	 */
	public void setSqlRequestCalled(
			SQL_Request_Called_Connection_Manager sqlRequestCalled) {
		this.sqlRequestCalled = sqlRequestCalled;
	}
}
