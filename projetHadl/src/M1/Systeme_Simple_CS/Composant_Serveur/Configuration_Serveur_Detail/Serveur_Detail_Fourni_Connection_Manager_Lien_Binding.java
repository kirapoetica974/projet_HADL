package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.External_Socket_Fourni;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Detail_Fourni_Connection_Manager_Lien_Binding extends
		Lien_Binding {

	private External_Socket_Fourni externalSocketFourni;
	private Serveur_Detail_Fourni serveurDetailFourni;

	public Serveur_Detail_Fourni_Connection_Manager_Lien_Binding(
			External_Socket_Fourni externalSocketFourni,
			Serveur_Detail_Fourni serveurDetailFourni)
			throws ExceptionMauvaisLien {
		super(externalSocketFourni, serveurDetailFourni);

		this.externalSocketFourni = externalSocketFourni;
		this.serveurDetailFourni = serveurDetailFourni;
	}

}
