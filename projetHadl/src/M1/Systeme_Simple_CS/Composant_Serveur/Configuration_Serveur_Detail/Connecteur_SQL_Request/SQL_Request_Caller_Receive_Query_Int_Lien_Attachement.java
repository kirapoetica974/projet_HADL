package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Receive_Query_Int;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class SQL_Request_Caller_Receive_Query_Int_Lien_Attachement extends
		Lien_Attachement {

	private SQL_Request_Caller sqlRequestCaller;
	private Receive_Query_Int receiveQueryInt;

	public SQL_Request_Caller_Receive_Query_Int_Lien_Attachement(
			SQL_Request_Caller sqlRequestCaller,
			Receive_Query_Int receiveQueryInt) throws ExceptionMauvaisLien {
		super(sqlRequestCaller, receiveQueryInt);

		this.sqlRequestCaller = sqlRequestCaller;
		this.receiveQueryInt = receiveQueryInt;
	}
}
