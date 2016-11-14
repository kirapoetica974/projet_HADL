package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Receive_C_Query;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Security_Query_Receive_C_Query_Lien_Attachement extends
		Lien_Attachement {

	private Security_Query_Caller securityQueryCaller;
	private Receive_C_Query receiveCQuery;

	public Security_Query_Receive_C_Query_Lien_Attachement(
			Security_Query_Caller securityQueryCaller,
			Receive_C_Query receiveCQuery) throws ExceptionMauvaisLien {
		super(securityQueryCaller, receiveCQuery);

		this.securityQueryCaller = securityQueryCaller;
		this.receiveCQuery = receiveCQuery;
	}

}
