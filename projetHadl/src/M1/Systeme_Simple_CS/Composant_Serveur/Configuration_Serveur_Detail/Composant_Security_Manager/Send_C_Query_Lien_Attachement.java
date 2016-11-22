package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query_Called_Security_Manager;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_C_Query_Lien_Attachement extends Lien_Attachement {

	private static Send_C_Query sendCQuery = new Send_C_Query();
	private static Security_Query_Called_Security_Manager securityQueryCalled = new Security_Query_Called_Security_Manager();

	public Send_C_Query_Lien_Attachement() throws ExceptionMauvaisLien {
		super(securityQueryCalled, sendCQuery);

		this.setPortComposantRequis(sendCQuery);

		this.setRoleFourni(securityQueryCalled);
	}
}
