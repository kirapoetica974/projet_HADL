package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_Security_Management_Lien_Attachement extends Lien_Attachement {

	private static Send_Security_Management sendSecurityManagement;
	private static Security_Query_Called securityQueryCalled;

	public Send_Security_Management_Lien_Attachement(
			Send_Security_Management sendSecurityManagement,
			Security_Query_Called securityQueryCalled)
			throws ExceptionMauvaisLien {

		super(securityQueryCalled, sendSecurityManagement);

		this.sendSecurityManagement = sendSecurityManagement;
		this.securityQueryCalled = securityQueryCalled;
	}
}
