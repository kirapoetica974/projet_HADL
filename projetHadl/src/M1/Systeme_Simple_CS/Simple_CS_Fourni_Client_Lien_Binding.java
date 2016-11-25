package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client_Fourni;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Simple_CS_Fourni_Client_Lien_Binding extends Lien_Binding {

	private static Client_Fourni clientFourni = new Client_Fourni();
	private static Simple_CS_Fourni simpleCSFourni = new Simple_CS_Fourni();

	public Simple_CS_Fourni_Client_Lien_Binding() throws ExceptionMauvaisLien {
		super(clientFourni, simpleCSFourni);

		this.clientFourni = new Client_Fourni();
		this.setPortComposantFourni(clientFourni);

		this.simpleCSFourni = new Simple_CS_Fourni();
		this.setPortConfigurationFourni(simpleCSFourni);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		String donnee = this.simpleCSFourni.getElmtStocke();
		this.clientFourni.setElmtStocke(donnee);
		this.simpleCSFourni.setElmtStocke(null);
		Simple_CS.getInstance().getObserver()
				.notifierEntreeDonnee(this.clientFourni, donnee);

	}

}
