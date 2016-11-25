package M1.Systeme_Simple_CS;

import M1.Systeme_Simple_CS.Composant_Client.Client;
import M1.Systeme_Simple_CS.Composant_Client.Client_Rpc_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Serveur;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Serveur_Detail;
import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc;
import M1.Systeme_Simple_CS.Connecteur_Rpc.Rpc_Serveur_Lien_Attachement;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.Configuration;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Simple_CS extends Configuration {

	// Singleton
	private static Simple_CS simpleCsIstance;

	public ObserverConfig observer;

	private Client client;
	private Serveur serveur;
	private Simple_CS_Requis portSimpleCsEntree;
	private Simple_CS_Fourni portSimpleCsSortie;
	private Rpc rpc;
	private Client_Rpc_Lien_Attachement clientRpcLienAttachement;
	private Rpc_Serveur_Lien_Attachement rpcServeurLienAttachement;

	private Simple_CS_Fourni_Client_Lien_Binding simpleCSFourniClientLienBinding;
	private Simple_CS_Requis_Client_Lien_Binding simpleCSRequisClientLienBinding;
	private Serveur_Fourni_Serveur_Detail_Lien_Binding serveurFourniServeurDetailLienBinding;
	private Serveur_Requis_Serveur_Detail_Lien_Binding serveurRequisServeurDetailLienBinding;

	private Serveur_Detail serveurDetail;

	private Simple_CS() throws ExceptionMauvaisLien {
		super();

		observer = new ObserverConfig(this);

		this.setNom("Simple_CS");

		this.client = new Client();
		this.serveur = new Serveur();
		this.rpc = new Rpc();
		this.clientRpcLienAttachement = new Client_Rpc_Lien_Attachement();
		this.rpcServeurLienAttachement = new Rpc_Serveur_Lien_Attachement();
		this.portSimpleCsEntree = new Simple_CS_Requis();
		this.portSimpleCsSortie = new Simple_CS_Fourni();
		this.serveurDetail = Serveur_Detail.getInstance();

		this.simpleCSFourniClientLienBinding = new Simple_CS_Fourni_Client_Lien_Binding();
		this.simpleCSRequisClientLienBinding = new Simple_CS_Requis_Client_Lien_Binding();
		this.serveurFourniServeurDetailLienBinding = new Serveur_Fourni_Serveur_Detail_Lien_Binding();
		this.serveurRequisServeurDetailLienBinding = new Serveur_Requis_Serveur_Detail_Lien_Binding();

		/*
		 * Ajout du client, du serveur et du RPC dans la liste des obj
		 * architecturaux
		 */
		this.addObjetArchitectural(this.client);
		this.addObjetArchitectural(this.serveur);
		this.addObjetArchitectural(this.rpc);
		this.addObjetArchitectural(this.serveurDetail);

		// Ajout des ports dans la liste des interfaces de communication
		this.addInterfaceCommunication(this.portSimpleCsEntree);
		this.addInterfaceCommunication(this.portSimpleCsSortie);

		// Ajout des lien attachement dans la liste des liens attachements
		this.addLienAttachement(clientRpcLienAttachement);
		this.addLienAttachement(rpcServeurLienAttachement);

		// Ajout des liens binding dans la liste des liens attachements
		this.addLienBinding(simpleCSFourniClientLienBinding);
		this.addLienBinding(simpleCSRequisClientLienBinding);
		this.addLienBinding(serveurFourniServeurDetailLienBinding);
		this.addLienBinding(serveurRequisServeurDetailLienBinding);
	}

	public static Simple_CS getInstance() throws ExceptionMauvaisLien {
		if (null == simpleCsIstance) {
			simpleCsIstance = new Simple_CS();
		}
		return simpleCsIstance;
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

	public ObserverConfig getObserver() {
		return observer;
	}

}
