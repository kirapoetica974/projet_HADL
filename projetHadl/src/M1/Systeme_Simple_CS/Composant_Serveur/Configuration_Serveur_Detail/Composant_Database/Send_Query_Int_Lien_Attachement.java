package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request.SQL_Request_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_Query_Int_Lien_Attachement extends Lien_Attachement {

	private static Send_Query_Int sendQueryInt;
	private static SQL_Request_Called sqlRequestCalled;

	public Send_Query_Int_Lien_Attachement(Send_Query_Int sendQueryInt,
			SQL_Request_Called sqlRequestCalled) throws ExceptionMauvaisLien {
		super(sqlRequestCalled, sendQueryInt);

		this.sendQueryInt = sendQueryInt;
		this.sqlRequestCalled = sqlRequestCalled;
	}
}
