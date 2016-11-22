package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request.Clearence_Request_Called_Security_Manager;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Send_Security_Auth_Lien_Attachement extends Lien_Attachement {

	private static Send_Security_Auth sendSecurityAuth = new Send_Security_Auth();
	private static Clearence_Request_Called_Security_Manager clearenceRequestCalled = new Clearence_Request_Called_Security_Manager();

	public Send_Security_Auth_Lien_Attachement() throws ExceptionMauvaisLien {
		super(clearenceRequestCalled, sendSecurityAuth);

		this.setPortComposantRequis(sendSecurityAuth);

		this.setRoleFourni(clearenceRequestCalled);
	}

}
