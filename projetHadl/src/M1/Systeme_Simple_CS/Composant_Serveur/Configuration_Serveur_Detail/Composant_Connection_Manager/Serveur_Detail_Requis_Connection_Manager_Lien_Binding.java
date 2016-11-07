package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail_Requis;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Detail_Requis_Connection_Manager_Lien_Binding extends
		Lien_Binding {

	private External_Socket_Requis externalSocketRequis;
	private Serveur_Detail_Requis serveurDetailRequis;

	public Serveur_Detail_Requis_Connection_Manager_Lien_Binding(
			External_Socket_Requis externalSocketRequis,
			Serveur_Detail_Requis serveurDetailRequis)
			throws ExceptionMauvaisLien {
		super(externalSocketRequis, serveurDetailRequis);

		this.externalSocketRequis = externalSocketRequis;
		this.serveurDetailRequis = serveurDetailRequis;
	}
}
