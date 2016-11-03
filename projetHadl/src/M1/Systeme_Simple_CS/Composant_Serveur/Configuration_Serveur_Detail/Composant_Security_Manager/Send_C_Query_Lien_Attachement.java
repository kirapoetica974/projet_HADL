package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_C_Query_Lien_Attachement extends Lien_Attachement {

	private static Send_C_Query sendCQuery;
	private static Security_Query_Called securityQueryCalled;

	public Send_C_Query_Lien_Attachement(Send_C_Query sendCQuery,
			Security_Query_Called securityQueryCalled)
			throws ExceptionMauvaisLien {
		super(securityQueryCalled, sendCQuery);

		this.sendCQuery = sendCQuery;
		this.securityQueryCalled = securityQueryCalled;
	}
}
