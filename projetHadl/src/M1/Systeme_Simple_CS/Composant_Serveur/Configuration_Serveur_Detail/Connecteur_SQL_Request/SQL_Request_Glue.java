package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;

public class SQL_Request_Glue extends Glue {

	private SQL_Request_Caller sqlRequestCaller;
	private SQL_Request_Called sqlRequestCalled;

	public SQL_Request_Glue() {
		super();

		this.sqlRequestCalled = new SQL_Request_Called();
		this.sqlRequestCaller = new SQL_Request_Caller();
	}

	/**
	 * @return sqlRequestCaller
	 */
	public SQL_Request_Caller getSqlRequestCaller() {
		return sqlRequestCaller;
	}

	/**
	 * @param sqlRequestCaller
	 *            : sqlRequestCaller à modifier
	 */
	public void setSqlRequestCaller(SQL_Request_Caller sqlRequestCaller) {
		this.sqlRequestCaller = sqlRequestCaller;
	}

	/**
	 * @return sqlRequestCalled
	 */
	public SQL_Request_Called getSqlRequestCalled() {
		return sqlRequestCalled;
	}

	/**
	 * @param sqlRequestCalled
	 *            : sqlRequestCalled à modifier
	 */
	public void setSqlRequestCalled(SQL_Request_Called sqlRequestCalled) {
		this.sqlRequestCalled = sqlRequestCalled;
	}
}
