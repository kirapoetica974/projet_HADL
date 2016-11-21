package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Receive_DB_Query;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class SQL_Request_Caller_Receive_DB_Query_Lien_Attachement extends
		Lien_Attachement {

	private static SQL_Request_Caller sqlRequestCaller = new SQL_Request_Caller();
	private static Receive_DB_Query receiveDBQuery = new Receive_DB_Query();

	public SQL_Request_Caller_Receive_DB_Query_Lien_Attachement()
			throws ExceptionMauvaisLien {
		super(sqlRequestCaller, receiveDBQuery);

		this.setRoleRequis(sqlRequestCaller);

		this.setPortComposantFourni(receiveDBQuery);
	}
}
