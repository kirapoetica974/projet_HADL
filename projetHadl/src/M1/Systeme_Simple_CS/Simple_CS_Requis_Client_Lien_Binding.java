package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client_Requis;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Simple_CS_Requis_Client_Lien_Binding extends Lien_Binding {

	private static Client_Requis clientRequis = new Client_Requis();
	private static Simple_CS_Requis simpleCSRequis = new Simple_CS_Requis();

	public Simple_CS_Requis_Client_Lien_Binding() throws ExceptionMauvaisLien {
		super(clientRequis, simpleCSRequis);

		this.setPortComposantRequis(clientRequis);

		this.setPortConfigurationRequis(simpleCSRequis);
	}

	@Override
	public void transmetDonnee() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {
		String donnee = this.clientRequis.getElmtStocke();
		this.simpleCSRequis.setElmtStocke(donnee);
		this.clientRequis.setElmtStocke(null);
		Simple_CS.getInstance().getObserver()
				.notifierEntreeDonnee(this.simpleCSRequis, donnee);

	}
}
