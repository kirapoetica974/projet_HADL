package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Receive_C_Query;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;

public class Security_Query_Receive_C_Query_Lien_Attachement extends
		Lien_Attachement {

	private static Security_Query_Caller securityQueryCaller = new Security_Query_Caller();
	private static Receive_C_Query receiveCQuery = new Receive_C_Query();

	public Security_Query_Receive_C_Query_Lien_Attachement()
			throws ExceptionMauvaisLien {
		super(securityQueryCaller, receiveCQuery);

		this.setRoleRequis(securityQueryCaller);

		this.setPortComposantFourni(receiveCQuery);
	}

}
