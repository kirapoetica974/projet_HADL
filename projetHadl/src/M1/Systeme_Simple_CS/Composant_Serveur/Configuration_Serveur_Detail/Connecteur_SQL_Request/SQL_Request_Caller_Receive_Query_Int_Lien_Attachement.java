package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Receive_Query_Int;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class SQL_Request_Caller_Receive_Query_Int_Lien_Attachement extends
		Lien_Attachement {

	private static SQL_Request_Caller_Database sqlRequestCaller = new SQL_Request_Caller_Database();
	private static Receive_Query_Int receiveQueryInt = new Receive_Query_Int();

	public SQL_Request_Caller_Receive_Query_Int_Lien_Attachement()
			throws ExceptionMauvaisLien {
		super(sqlRequestCaller, receiveQueryInt);

		this.setRoleRequis(sqlRequestCaller);

		this.setPortComposantFourni(receiveQueryInt);
	}
}
