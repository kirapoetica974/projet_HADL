package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Receive_DB_Query;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class SQL_Request_Caller_Receive_DB_Query_Lien_Attachement extends
		Lien_Attachement {

	private static SQL_Request_Caller sqlRequestCaller;
	private static Receive_DB_Query receiveDBQuery;

	public SQL_Request_Caller_Receive_DB_Query_Lien_Attachement(
			SQL_Request_Caller sqlRequestCaller, Receive_DB_Query receiveDBQuery)
			throws ExceptionMauvaisLien {
		super(sqlRequestCaller, receiveDBQuery);

		this.sqlRequestCaller = sqlRequestCaller;
		this.receiveDBQuery = receiveDBQuery;
	}
}
