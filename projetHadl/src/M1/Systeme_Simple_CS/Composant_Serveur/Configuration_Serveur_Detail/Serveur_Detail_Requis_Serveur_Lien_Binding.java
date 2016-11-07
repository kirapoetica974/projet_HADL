package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Composant_Serveur.Serveur_Requis;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Detail_Requis_Serveur_Lien_Binding extends Lien_Binding {

	private Serveur_Requis serveurRequis;
	private Serveur_Detail_Requis serveurDetailRequis;

	public Serveur_Detail_Requis_Serveur_Lien_Binding(
			Serveur_Requis serveurRequis,
			Serveur_Detail_Requis serveurDetailRequis)
			throws ExceptionMauvaisLien {
		super(serveurRequis, serveurDetailRequis);

		this.serveurRequis = serveurRequis;
		this.serveurDetailRequis = serveurDetailRequis;
	}
}
