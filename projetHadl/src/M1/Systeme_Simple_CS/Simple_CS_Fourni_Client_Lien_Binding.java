package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client_Fourni;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Simple_CS_Fourni_Client_Lien_Binding extends Lien_Binding {

	private static Client_Fourni clientFourni;
	private static Simple_CS_Fourni simpleCSFourni;

	public Simple_CS_Fourni_Client_Lien_Binding() throws ExceptionMauvaisLien {
		super(clientFourni, simpleCSFourni);

		this.clientFourni = new Client_Fourni();
		this.setPortComposantFourni(clientFourni);

		this.simpleCSFourni = new Simple_CS_Fourni();
		this.setPortConfigurationFourni(simpleCSFourni);
	}

}
