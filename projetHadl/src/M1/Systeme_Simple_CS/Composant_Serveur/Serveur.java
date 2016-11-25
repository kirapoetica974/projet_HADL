package M1.Systeme_Simple_CS.Composant_Serveur;

import M1.Systeme_Simple_CS.Simple_CS;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Serveur extends Composant {

	private Receive_Request receiveRequest;
	private Send_Serveur sendRequestServeur;
	private Serveur_Fourni serveurFourni;
	private Serveur_Requis serveurRequis;

	public Serveur() {
		super();

		this.setNom("Serveur");
		this.serveurFourni = new Serveur_Fourni();
		this.serveurRequis = new Serveur_Requis();
		this.receiveRequest = new Receive_Request();
		this.sendRequestServeur = new Send_Serveur();

		this.addInterfaceCommunication(this.receiveRequest);
		this.addInterfaceCommunication(this.sendRequestServeur);
		this.addInterfaceCommunication(serveurFourni);
		this.addInterfaceCommunication(serveurRequis);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		ObserverConfig obs = Simple_CS.getInstance().getObserver();
		if (null != receiveRequest.getElmtStocke()) {
			System.out.println("je passe par Serveur.");
			serveurRequis.setElmtStocke(receiveRequest.getElmtStocke());
			receiveRequest.setElmtStocke(null);
			obs.notifierSortieDonnee(serveurRequis);

		} else if (null != serveurFourni.getElmtStocke()) {
			System.out.println("je passe par Serveur.");
			sendRequestServeur.setElmtStocke(serveurFourni.getElmtStocke());
			serveurFourni.setElmtStocke(null);
			obs.notifierSortieDonnee(sendRequestServeur);

		}

	}

}
