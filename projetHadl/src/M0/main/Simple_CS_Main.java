package M0.main;

import M1.Systeme_Simple_CS.Simple_CS;
import M2.ExceptionDonneeIncorrecte;
import M2.ObserverConfig;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Simple_CS_Main {

	public static void main(String[] args) throws ExceptionDonneeIncorrecte,
			ExceptionMauvaisLien {

		Simple_CS configClientServeur = new Simple_CS();
		ObserverConfig observer = new ObserverConfig(configClientServeur);

		configClientServeur.getClient().envoyerDonnee("blabla");

	}

}
