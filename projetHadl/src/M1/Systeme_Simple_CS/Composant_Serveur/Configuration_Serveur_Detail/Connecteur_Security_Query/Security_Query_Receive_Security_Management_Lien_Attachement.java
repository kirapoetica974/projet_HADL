package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Receive_Security_Management;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Security_Query_Receive_Security_Management_Lien_Attachement extends
		Lien_Attachement {

	private static Security_Query_Caller securityQueryCaller;
	private static Receive_Security_Management receiveSecurityManagement;

	public Security_Query_Receive_Security_Management_Lien_Attachement(
			Security_Query_Caller securityQueryCaller,
			Receive_Security_Management receiveSecurityManagement)
			throws ExceptionMauvaisLien {
		super(securityQueryCaller, receiveSecurityManagement);

		this.securityQueryCaller = securityQueryCaller;
		this.receiveSecurityManagement = receiveSecurityManagement;
	}

}
