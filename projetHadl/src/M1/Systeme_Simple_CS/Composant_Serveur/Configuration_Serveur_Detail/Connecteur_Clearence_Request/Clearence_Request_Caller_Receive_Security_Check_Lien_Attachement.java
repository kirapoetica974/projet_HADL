package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Receive_Security_Check;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Clearence_Request_Caller_Receive_Security_Check_Lien_Attachement
		extends Lien_Attachement {

	private static Clearence_Request_Caller clearenceRequestCaller;
	private static Receive_Security_Check receiveSecurityCheck;

	public Clearence_Request_Caller_Receive_Security_Check_Lien_Attachement()
			throws ExceptionMauvaisLien {
		super(clearenceRequestCaller, receiveSecurityCheck);

		this.clearenceRequestCaller = new Clearence_Request_Caller();
		this.setRoleRequis(clearenceRequestCaller);

		this.receiveSecurityCheck = new Receive_Security_Check();
		this.setPortComposantFourni(receiveSecurityCheck);
	}
}
