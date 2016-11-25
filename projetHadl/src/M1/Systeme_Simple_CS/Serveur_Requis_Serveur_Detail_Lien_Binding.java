package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Serveur.Serveur_Requis;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail_Requis;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Serveur_Requis_Serveur_Detail_Lien_Binding extends Lien_Binding {

	private static Serveur_Requis serveurRequis = new Serveur_Requis();
	private static Serveur_Detail_Requis serveurDetailRequis = new Serveur_Detail_Requis();

	public Serveur_Requis_Serveur_Detail_Lien_Binding()
			throws ExceptionMauvaisLien {
		super(serveurRequis, serveurDetailRequis);

		this.setPortComposantRequis(serveurRequis);

		this.setPortConfigurationRequis(serveurDetailRequis);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		String donnee = this.serveurRequis.getElmtStocke();
		this.serveurDetailRequis.setElmtStocke(donnee);
		this.serveurRequis.setElmtStocke(null);
		Serveur_Detail.getInstance().getObserver()
				.notifierEntreeDonnee(this.serveurDetailRequis, donnee);

	}
}
