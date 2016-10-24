package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client;
import M2.Objet_Architectural.Configuration.Configuration;

public class Simple_CS extends Configuration {

	private Client client;

	public Simple_CS(Client client) {
		this.client = client;
		this.setNom("Simple CS");

		this.addObjetArchitectural(client);
	}
}
