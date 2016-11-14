package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client;
import M1.Systeme_Simple_CS.Composant_Client.Client_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Serveur;
import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc;
import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc_Lien_Attachement;
import M2.Objet_Architectural.Configuration.Configuration;

public class Simple_CS extends Configuration {

	private Client client;
	private Serveur serveur;
	private Simple_CS_Requis portSimpleCsEntree;
	private Simple_CS_Fourni portSimpleCsSortie;
	private Rpc rpc;
	private Rpc_Lien_Attachement rpcLienAttachement;
	private Client_Lien_Attachement clientLienAttachement;

	/*
	 * public Simple_CS(Client client, Simple_CS_Entree scEntree,
	 * Simple_CS_Sortie scSortie) {
	 */

	public Simple_CS() {
		super();

		this.setNom("Simple CS");

		this.client = new Client();
		this.serveur = new Serveur();
		this.rpc = new Rpc();
		this.clientLienAttachement = new Client_Lien_Attachement();
		this.rpcLienAttachement = new Rpc_Lien_Attachement();
		this.portSimpleCsEntree = new Simple_CS_Requis();
		this.portSimpleCsSortie = new Simple_CS_Fourni();

		/*
		 * Ajout du client, du serveur et du RPC dans la liste des obj
		 * architecturaux
		 */
		this.addObjetArchitectural(this.client);
		this.addObjetArchitectural(this.serveur);
		this.addObjetArchitectural(this.rpc);

		// Ajout des ports dans la liste des interfaces de communication
		this.addInterfaceCommunication(this.portSimpleCsEntree);
		this.addInterfaceCommunication(this.portSimpleCsSortie);

		// Ajout des lien attachement dans la liste des liens attachements
		this.addLienAttachement(rpcLienAttachement);
		this.addLienAttachement(clientLienAttachement);
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @return the serveur
	 */
	public Serveur getServeur() {
		return serveur;
	}

	/**
	 * @return the rpc
	 */
	public Rpc getRpc() {
		return rpc;
	}
}
