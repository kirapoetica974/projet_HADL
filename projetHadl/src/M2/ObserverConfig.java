package M2;

import java.util.List;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Configuration.Configuration;
import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Simple;
import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;
import M2.Objet_Architectural.Interface_Communication.Interface;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;
import M2.Objet_Architectural.Interface_Communication.Port;
import M2.Objet_Architectural.Interface_Communication.Port_Composant_Fourni;
import M2.Objet_Architectural.Interface_Communication.Port_Composant_Requis;
import M2.Objet_Architectural.Interface_Communication.Role;
import M2.Objet_Architectural.Interface_Communication.Role_Fourni;
import M2.Objet_Architectural.Interface_Communication.Role_Requis;

public class ObserverConfig {

	Configuration configuration;

	/** L'instance statique */
	private static ObserverConfig instance;

	public static ObserverConfig getInstance() {
		if (null == instance) { // Premier appel
			instance = new ObserverConfig();
		}
		return instance;
	}

	public ObserverConfig() {
	}

	public ObserverConfig(Configuration config) {
		this.configuration = config;
	}

	/**
	 * @return la configuration
	 */
	public Configuration getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration
	 *            la configuration à modifier
	 */
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

	/**
	 * Méthode qui permet d'informer au lien attachement qu'il doit transmettre
	 * la donnée
	 * 
	 * @param port
	 *            le port qui a recu l'information
	 * @throws ExceptionDonneeIncorrecte
	 */
	public void notifierSortieDonnee(Object port)
			throws ExceptionDonneeIncorrecte {
		List<Lien_Attachement> listAttachements = configuration
				.getListLienAttachements();

		String donneeATransmettre = recupDonneePort(port);

		Lien_Attachement lienTransporteur = null;
		Boolean lienAttachementTrouve = false;
		int noLien = 0;

		while (!lienAttachementTrouve || noLien < listAttachements.size()) {
			lienAttachementTrouve = verifierLienAttachement(port,
					listAttachements.get(noLien));
			if (lienAttachementTrouve) {
				lienTransporteur = listAttachements.get(noLien);
			}
			noLien++;
		}

		if (!listAttachements.equals(null)) {
			lienTransporteur.transmetDonnee();
		}
	}

	/**
	 * Méthode qui permet d'informer au connecteur, au composant ou à la
	 * configuration qu'il doit transmettre la donnée
	 * 
	 * @param port
	 *            le port qui a recu l'information
	 * @throws ExceptionDonneeIncorrecte
	 */
	public void notifierEntreeDonnee(Object port)
			throws ExceptionDonneeIncorrecte {

		// Si le port est un rôle
		// Si le port est un port_composant
		// Si le port est un port_configuration
		List<Objet_Architectural> listeObjetArchitectural = configuration
				.getListeObjetArchitectural();

		Objet_Architectural objetArchitectural = null;
		Boolean interfaceCommunicationTrouve = false;
		int noObjetArchitectural = 0;
		int noInterfaceCommunication = 0;

		while (!interfaceCommunicationTrouve
				&& noObjetArchitectural < listeObjetArchitectural.size()) {

			// Un objet architectural possède une liste d'interfaces de
			// communication (ports, roles)
			List<Interface> listeInterfaceCommunication = listeObjetArchitectural
					.get(noObjetArchitectural).getInterfaceCommunication();

			// Il faut trouver quelle interface correspond au port
			while (!interfaceCommunicationTrouve
					&& noInterfaceCommunication < listeInterfaceCommunication
							.size()) {
				Interface interfaceCommunication = listeInterfaceCommunication
						.get(noInterfaceCommunication);

				if (interfaceCommunication.equals(port)) {
					interfaceCommunicationTrouve = true;
					objetArchitectural = listeObjetArchitectural
							.get(noObjetArchitectural);
				}
				noInterfaceCommunication++;
			}

			noObjetArchitectural++;
		}

		// On regarde la liste des glues
		if (null == objetArchitectural) {
			noObjetArchitectural = 0;
			while (!interfaceCommunicationTrouve
					&& noObjetArchitectural < listeObjetArchitectural.size())

				objetArchitectural = listeObjetArchitectural
						.get(noObjetArchitectural);

			// Est ce que le port correspond au role de cette glue ?
			if (objetArchitectural instanceof Connecteur_Simple) {
				Glue glue = ((Connecteur_Simple) objetArchitectural).getGlue();
				List<Role_Fourni> listeRoleFourni = glue.getListeRoleFourni();

				for (Role_Fourni roleFourni : listeRoleFourni) {
					if (roleFourni.equals(port)) {
						glue.transmetDonnee();
					}
				}
			}
		}

		// Objet trouve
		else {
			objetArchitectural.transmetDonnee();
		}

	}

	/**
	 * @param port
	 *            un port
	 * @return la valeur de la donnée stockée dans le port
	 * @throws ExceptionDonneeIncorrecte
	 *             en cas d'erreur de la donnee
	 */
	private String recupDonneePort(Object port)
			throws ExceptionDonneeIncorrecte {
		String donnee = null;
		if (port instanceof Port) {
			Port p = (Port) port;
			donnee = p.getElmtStocke();
		} else if (port instanceof Role) {
			Role r = (Role) port;
			donnee = r.getElmtStocke();
		} else {
			new ExceptionDonneeIncorrecte();
		}
		return donnee;
	}

	/**
	 * Méthode qui permet de vérifier si un port est contenu dans un lien
	 * attachement
	 * 
	 * @param port
	 *            le port qui notifie
	 * @param lien_Attachement
	 *            le lien attachement qu'on souhaite comparer
	 * @return vrai si le port est dans le lien, faux sinon
	 */
	private Boolean verifierLienAttachement(Object port,
			Lien_Attachement lien_Attachement) {

		boolean portCorrect = false;

		Boolean portCompRequis = port instanceof Port_Composant_Requis
				&& lien_Attachement.getPortComposantRequis().equals(port);

		Boolean portCompFourni = port instanceof Port_Composant_Fourni
				&& lien_Attachement.getPortComposantRequis().equals(port);

		Boolean roleRequis = port instanceof Role_Requis
				&& lien_Attachement.getRoleRequis().equals(port);

		Boolean roleFourni = port instanceof Role_Fourni
				&& lien_Attachement.getRoleFourni().equals(port);

		if (portCompRequis || portCompFourni || roleFourni || roleRequis) {
			portCorrect = true;
		}

		return portCorrect;

	}
}
