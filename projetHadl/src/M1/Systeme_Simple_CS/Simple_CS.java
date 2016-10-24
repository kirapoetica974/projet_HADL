package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client;
import M1.Systeme_Simple_CS.Composant_Serveur.Serveur;
import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc;
import M2.Objet_Architectural.Configuration.Configuration;

public class Simple_CS extends Configuration {

	private Client client;
	private Serveur serveur;
	private Simple_CS_Entree portSimpleCsEntree;
	private Simple_CS_Sortie portSimpleCsSortie;
	private Rpc rpc;

	public Simple_CS(Client client, Simple_CS_Entree scEntree,
			Simple_CS_Sortie scSortie) {
		super();

		this.setNom("Simple CS");

		this.client = new Client();
		this.serveur = new Serveur();
		this.portSimpleCsEntree = new Simple_CS_Entree();
		this.portSimpleCsSortie = new Simple_CS_Sortie();
		this.rpc = new Rpc();

		this.addObjetArchitectural(this.client);
		this.addObjetArchitectural(this.serveur);
		this.addObjetArchitectural(this.rpc);
		this.addInterfaceCommunication(this.portSimpleCsEntree);
		this.addInterfaceCommunication(this.portSimpleCsSortie);
	}
}
