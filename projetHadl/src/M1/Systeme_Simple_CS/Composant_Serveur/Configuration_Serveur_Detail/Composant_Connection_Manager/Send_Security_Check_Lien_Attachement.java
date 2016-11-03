package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request.Clearence_Request_Called;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_Security_Check_Lien_Attachement extends Lien_Attachement {

	private static Send_Security_Check sendSecurityCheck;
	private static Clearence_Request_Called clearenceRequestCalled;

	public Send_Security_Check_Lien_Attachement(
			Send_Security_Check sendSecurityCheck,
			Clearence_Request_Called clearenceRequestCalled)
			throws ExceptionMauvaisLien {
		super(clearenceRequestCalled, sendSecurityCheck);

		this.sendSecurityCheck = sendSecurityCheck;
		this.clearenceRequestCalled = clearenceRequestCalled;
	}
}
