package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request.SQL_Request_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_DB_Query_Lien_Attachement extends Lien_Attachement {

	private static Send_DB_Query sendDBQuery;
	private static SQL_Request_Called sqlRequestCalled;

	public Send_DB_Query_Lien_Attachement(Send_DB_Query sendDBQuery,
			SQL_Request_Called sqlRequestCalled) throws ExceptionMauvaisLien {
		super(sqlRequestCalled, sendDBQuery);

		this.sendDBQuery = sendDBQuery;
		this.sqlRequestCalled = sqlRequestCalled;
	}

}