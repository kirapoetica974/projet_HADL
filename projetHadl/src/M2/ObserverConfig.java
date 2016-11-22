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
		} else if (configuration == null) {
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
		ObserverConfig.configuration = config;
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
		ObserverConfig.configuration = configuration;
	}

	/**
	 * Méthode qui permet d'informer au lien attachement ou au lien binding
	 * qu'il doit transmettre la donnée
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

		Lien_Attachement lienTransporteur = null;
		Boolean lienAttachementTrouve = false;
		int noLien = 0;

		// On vérifie si on doit envoyer la donnée sur un lien attachement
		while (!lienAttachementTrouve && noLien < listAttachements.size()) {
			lienAttachementTrouve = verifierLienAttachement(port,
					listAttachements.get(noLien));
			if (lienAttachementTrouve) {
				lienTransporteur = listAttachements.get(noLien);
			}
			noLien++;
		}

		if (null != lienTransporteur) {
			logger.log(Level.INFO, "Le lien attachement a été trouvé.");
			lienTransporteur.transmetDonnee();
		}

		// On vérifie si on doit envoyer la donnée sur un lien binding
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
		Interface p = (Interface) port;

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

				if (p.getNom().equals(interfaceCommunication.getNom())) {
					interfaceCommunicationTrouve = true;
					objetArchitectural = listeObjetArchitectural
							.get(noObjetArchitectural);
					interfaceCommunication.setElmtStocke(p.getElmtStocke());
					objetArchitectural.transmetDonnee();
				}
				noInterfaceCommunication++;
			}

			noInterfaceCommunication = 0;
			noObjetArchitectural++;
		}

		// On regarde la liste des glues si ce n'est pas un objet architectural
		if (null == objetArchitectural) {
			noObjetArchitectural = 0;
			while (!interfaceCommunicationTrouve
					&& noObjetArchitectural < listeObjetArchitectural.size()) {

				objetArchitectural = listeObjetArchitectural
						.get(noObjetArchitectural);

				// Est ce que le port correspond au role de cette glue ?
				if (objetArchitectural instanceof Connecteur) {
					Glue glue = ((Connecteur) objetArchitectural).getGlue();
					List<Role_Fourni> listeRoleFourni = glue
							.getListeRoleFourni();

					for (Role_Fourni roleFourni : listeRoleFourni) {
						if (p.getNom().equals(roleFourni.getNom())) {
							roleFourni.setElmtStocke(p.getElmtStocke());
							glue.transmetDonnee(p);
							interfaceCommunicationTrouve = true;
							break;
						}
					}
				}
				noObjetArchitectural++;
			}
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

		// C'est un port composant requis
		if (port instanceof Port_Composant_Requis) {
			Port_Composant_Requis p = (Port_Composant_Requis) port;
			if (lien_Attachement.getPortComposantRequis() != null
					&& p.getNom().equals(
							lien_Attachement.getPortComposantRequis().getNom())) {
				portCorrect = true;
				lien_Attachement.getPortComposantRequis().setElmtStocke(
						p.getElmtStocke());
			}
		}
		// C'est un port Composant fourni
		else if (port instanceof Port_Composant_Fourni) {
			Port_Composant_Fourni p = (Port_Composant_Fourni) port;
			if (lien_Attachement.getPortComposantFourni() != null
					&& p.getNom().equals(
							lien_Attachement.getPortComposantFourni().getNom())) {
				portCorrect = true;
				lien_Attachement.getPortComposantFourni().setElmtStocke(
						p.getElmtStocke());
			}
		}
		// C'est un role requis
		else if (port instanceof Role_Requis) {
			Role_Requis p = (Role_Requis) port;
			if (lien_Attachement.getRoleRequis() != null
					&& p.getNom().equals(
							lien_Attachement.getRoleRequis().getNom())) {
				portCorrect = true;
				lien_Attachement.getRoleRequis().setElmtStocke(
						p.getElmtStocke());
			}
		}
		// C'est un role fourni
		else if (port instanceof Role_Fourni) {
			Role_Fourni p = (Role_Fourni) port;
			if (lien_Attachement.getRoleFourni() != null
					&& p.getNom().equals(
							lien_Attachement.getRoleFourni().getNom())) {
				portCorrect = true;
				lien_Attachement.getRoleFourni().setElmtStocke(
						p.getElmtStocke());
			}
		}

		return portCorrect;

	}
}
