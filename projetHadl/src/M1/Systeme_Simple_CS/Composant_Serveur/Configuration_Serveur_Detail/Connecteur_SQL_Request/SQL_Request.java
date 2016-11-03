package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Simple_Explicite;

public class SQL_Request extends Connecteur_Simple_Explicite {

	private SQL_Request_Glue sqlRequestGlue;

	public SQL_Request(SQL_Request_Glue sqlRequestGlue) {
		super();

		this.sqlRequestGlue = new SQL_Request_Glue();

		if (null != sqlRequestGlue) {
			this.sqlRequestGlue = sqlRequestGlue;
		}
	}

	/**
	 * @return sqlRequestGlue
	 */
	public SQL_Request_Glue getSqlRequestGlue() {
		return sqlRequestGlue;
	}

	/**
	 * @param sqlRequestGlue
	 *            : sqlRequestGlue à modifier
	 */
	public void setSqlRequestGlue(SQL_Request_Glue sqlRequestGlue) {
		this.sqlRequestGlue = sqlRequestGlue;
	}
}
