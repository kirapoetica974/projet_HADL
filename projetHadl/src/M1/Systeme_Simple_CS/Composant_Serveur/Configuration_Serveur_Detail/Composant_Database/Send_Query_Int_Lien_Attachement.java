package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request.SQL_Request_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_Query_Int_Lien_Attachement extends Lien_Attachement {

	private static Send_Query_Int sendQueryInt = new Send_Query_Int();
	private static SQL_Request_Called sqlRequestCalled = new SQL_Request_Called();

	public Send_Query_Int_Lien_Attachement() throws ExceptionMauvaisLien {
		super(sqlRequestCalled, sendQueryInt);

		this.setPortComposantRequis(sendQueryInt);

		this.setRoleFourni(sqlRequestCalled);
	}
}
