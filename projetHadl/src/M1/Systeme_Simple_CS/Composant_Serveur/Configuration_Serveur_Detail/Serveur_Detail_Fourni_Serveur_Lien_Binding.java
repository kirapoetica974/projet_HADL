package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Composant_Serveur.Serveur_Fourni;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Detail_Fourni_Serveur_Lien_Binding extends Lien_Binding {

	private Serveur_Fourni serveurFourni;
	private Serveur_Detail_Fourni serveurDetailFourni;

	public Serveur_Detail_Fourni_Serveur_Lien_Binding(
			Serveur_Fourni serveurFourni,
			Serveur_Detail_Fourni serveurDetailFourni)
			throws ExceptionMauvaisLien {
		super(serveurFourni, serveurDetailFourni);

		this.serveurFourni = serveurFourni;
		this.serveurDetailFourni = serveurDetailFourni;
	}

}
