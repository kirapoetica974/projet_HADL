package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Serveur.Serveur_Requis;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail_Requis;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Requis_Serveur_Detail_Lien_Binding extends Lien_Binding {

	private static Serveur_Requis serveurRequis;
	private static Serveur_Detail_Requis serveurDetailRequis;

	public Serveur_Requis_Serveur_Detail_Lien_Binding()
			throws ExceptionMauvaisLien {
		super(serveurRequis, serveurDetailRequis);

		this.serveurRequis = new Serveur_Requis();
		this.setPortComposantRequis(serveurRequis);

		this.serveurDetailRequis = new Serveur_Detail_Requis();
		this.setPortConfigurationRequis(serveurDetailRequis);
	}
}
