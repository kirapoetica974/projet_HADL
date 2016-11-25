package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.External_Socket_Requis;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Detail_Requis_Connection_Manager_Lien_Binding extends
		Lien_Binding {

	private static External_Socket_Requis externalSocketRequis = new External_Socket_Requis();
	private static Serveur_Detail_Requis serveurDetailRequis = new Serveur_Detail_Requis();

	public Serveur_Detail_Requis_Connection_Manager_Lien_Binding()
			throws ExceptionMauvaisLien {
		super(externalSocketRequis, serveurDetailRequis);

		this.setPortComposantRequis(externalSocketRequis);

		this.setPortConfigurationRequis(serveurDetailRequis);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		String donnee = this.serveurDetailRequis.getElmtStocke();
		this.externalSocketRequis.setElmtStocke(donnee);
		this.serveurDetailRequis.setElmtStocke(null);
		Serveur_Detail.getInstance().getObserver()
				.notifierEntreeDonnee(this.externalSocketRequis, donnee);

	}

}
