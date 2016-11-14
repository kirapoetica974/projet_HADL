package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client_Requis;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Simple_CS_Requis_Client_Lien_Binding extends Lien_Binding {

	private static Client_Requis clientRequis;
	private static Simple_CS_Requis simpleCSRequis;

	public Simple_CS_Requis_Client_Lien_Binding() throws ExceptionMauvaisLien {
		super(clientRequis, simpleCSRequis);

		this.clientRequis = new Client_Requis();
		this.setPortComposantRequis(clientRequis);

		this.simpleCSRequis = new Simple_CS_Requis();
		this.setPortConfigurationRequis(simpleCSRequis);
	}
}
