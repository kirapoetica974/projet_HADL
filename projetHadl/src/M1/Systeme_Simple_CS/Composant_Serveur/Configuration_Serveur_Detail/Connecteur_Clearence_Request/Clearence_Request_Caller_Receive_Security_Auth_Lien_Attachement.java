package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Receive_Security_Auth;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Clearence_Request_Caller_Receive_Security_Auth_Lien_Attachement
		extends Lien_Attachement {

	private static Clearence_Request_Caller clearenceRequestCaller = new Clearence_Request_Caller();
	private static Receive_Security_Auth receiveSecurityAuth = new Receive_Security_Auth();

	public Clearence_Request_Caller_Receive_Security_Auth_Lien_Attachement()
			throws ExceptionMauvaisLien {
		super(clearenceRequestCaller, receiveSecurityAuth);

		this.setRoleRequis(clearenceRequestCaller);

		this.setPortComposantFourni(receiveSecurityAuth);
	}

}
