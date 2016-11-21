package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_Security_Management_Lien_Attachement extends Lien_Attachement {

	private static Send_Security_Management sendSecurityManagement = new Send_Security_Management();
	private static Security_Query_Called securityQueryCalled = new Security_Query_Called();

	public Send_Security_Management_Lien_Attachement()
			throws ExceptionMauvaisLien {

		super(securityQueryCalled, sendSecurityManagement);

		this.setPortComposantRequis(sendSecurityManagement);

		this.setRoleFourni(securityQueryCalled);
	}
}
