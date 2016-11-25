package M0.main;

import M1.Systeme_Simple_CS.Simple_CS;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Simple_CS_Main {

	public static void main(String[] args) throws ExceptionDonneeIncorrecte,
			ExceptionMauvaisLien, MauvaiseConfigurationException {

		Simple_CS configClientServeur = Simple_CS.getInstance();
		// ObserverConfig observer = new ObserverConfig(configClientServeur);

		configClientServeur.getClient().envoyerDonnee("blabla");

		/*
		 * Serveur_Detail servDetail = new Serveur_Detail();
		 * servDetail.getConnectionManager().envoyerDonnee(
		 * "kjdnfkjdnsjkfnsdjkfnjsdnfnjks");
		 */

	}
}
