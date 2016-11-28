package M0.main;

import M1.Systeme_Simple_CS.Simple_CS;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Simple_CS_Main {

	public static void main(String[] args) throws ExceptionDonneeIncorrecte,
			ExceptionMauvaisLien, MauvaiseConfigurationException {

		Simple_CS configClientServeur = Simple_CS.getInstance();
		configClientServeur.getClient().start();

	}
}
