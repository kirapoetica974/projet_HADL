package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.External_Socket_Requis;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Detail_Requis_Connection_Manager extends Lien_Binding {

	private static External_Socket_Requis externalSocketRequis;
	private static Serveur_Detail_Requis serveurDetailRequis;

	public Serveur_Detail_Requis_Connection_Manager()
			throws ExceptionMauvaisLien {
		super(externalSocketRequis, serveurDetailRequis);

		this.externalSocketRequis = new External_Socket_Requis();
		this.setPortComposantRequis(externalSocketRequis);

		this.serveurDetailRequis = new Serveur_Detail_Requis();
		this.setPortConfigurationRequis(serveurDetailRequis);
	}

}
