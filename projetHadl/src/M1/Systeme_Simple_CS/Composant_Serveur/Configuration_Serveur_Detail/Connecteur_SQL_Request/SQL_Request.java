package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Explicite;

public class SQL_Request extends Connecteur_Explicite {

	private SQL_Request_Glue sqlRequestGlue;

	public SQL_Request(SQL_Request_Glue sqlRequestGlue) {
		super();

		this.sqlRequestGlue = new SQL_Request_Glue();
		this.setGlue(sqlRequestGlue);
	}

}
