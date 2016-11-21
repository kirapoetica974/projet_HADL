package M2;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import M1.Systeme_Simple_CS.ExceptionObserverNonConfigure;
import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Configuration.Configuration;
import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur;
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

	private static Configuration configuration;
	private final static Logger logger = Logger.getLogger(Logger.class
			.getName());

	/** L'instance statique */
	private static ObserverConfig instance;

	public static ObserverConfig getInstance() {
		if (null == instance && configuration != null) { // Premier appel
			instance = new ObserverConfig(configuration);
		} else if (configuration != null) {
			try {
				throw new ExceptionObserverNonConfigure(
						"L'observeur doit contenir une configuration");
			} catch (ExceptionObserverNonConfigure e) {
				e.printStackTrace();
			}
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
		logger.log(Level.INFO,
				"Signal de sortie de donnée reçu, traitement en cours.");
		List<Lien_Attachement> listAttachements = configuration
				.getListLienAttachements();

		String donneeATransmettre = recupDonneePort(port);

		Lien_Attachement lienTransporteur = null;
		Boolean lienAttachementTrouve = false;
		int noLien = 0;

		while (!lienAttachementTrouve && noLien < listAttachements.size()) {
			lienAttachementTrouve = verifierLienAttachement(port,
					listAttachements.get(noLien));
			if (lienAttachementTrouve) {
				lienTransporteur = listAttachements.get(noLien);
			}
			noLien++;
		}

		if (!lienTransporteur.equals(null)) {
			logger.log(Level.INFO, "Le lien attachement a été trouvé.");
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

		logger.log(Level.INFO,
				"Signal d'entrée de donnée reçue, traitement en cours.");
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

		// On regarde la liste des glues si ce n'est pas un objet architectural
		if (null == objetArchitectural) {
			noObjetArchitectural = 0;
			while (!interfaceCommunicationTrouve
					&& noObjetArchitectural < listeObjetArchitectural.size())

				objetArchitectural = listeObjetArchitectural
						.get(noObjetArchitectural);

			// Est ce que le port correspond au role de cette glue ?
			if (objetArchitectural instanceof Connecteur) {
				Glue glue = ((Connecteur) objetArchitectural).getGlue();
				List<Role_Fourni> listeRoleFourni = glue.getListeRoleFourni();

				for (Role_Fourni roleFourni : listeRoleFourni) {
					if (roleFourni.equals(port)) {
						glue.transmetDonnee((Port) port);
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
				&& lien_Attachement.getPortComposantRequis() instanceof Port_Composant_Requis;

		Boolean portCompFourni = port instanceof Port_Composant_Fourni;

		Boolean roleRequis = port instanceof Role_Requis;

		Boolean roleFourni = port instanceof Role_Fourni
				&& port.equals(lien_Attachement.getRoleFourni());

		if (portCompRequis || portCompFourni || roleFourni || roleRequis) {
			portCorrect = true;
		}

		return portCorrect;

	}
}
