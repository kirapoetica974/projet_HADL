package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Serveur.Serveur_Fourni;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail_Fourni;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Fourni_Serveur_Detail_Lien_Binding extends Lien_Binding {

	private static Serveur_Fourni serveurFourni = new Serveur_Fourni();
	private static Serveur_Detail_Fourni serveurDetailFourni = new Serveur_Detail_Fourni();

	public Serveur_Fourni_Serveur_Detail_Lien_Binding()
			throws ExceptionMauvaisLien {
		super(serveurFourni, serveurDetailFourni);

		this.setPortComposantFourni(serveurFourni);

		this.setPortConfigurationFourni(serveurDetailFourni);
	}

}
