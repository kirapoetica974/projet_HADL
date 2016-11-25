package M2;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Configuration.Configuration;
import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur;
import M2.Objet_Architectural.Configuration.PackageConnecteur.Glue;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;
import M2.Objet_Architectural.Interface_Communication.Interface;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;
import M2.Objet_Architectural.Interface_Communication.Port_Composant_Fourni;
import M2.Objet_Architectural.Interface_Communication.Port_Composant_Requis;
import M2.Objet_Architectural.Interface_Communication.Port_Configuration_Fourni;
import M2.Objet_Architectural.Interface_Communication.Port_Configuration_Requis;
import M2.Objet_Architectural.Interface_Communication.Role_Fourni;
import M2.Objet_Architectural.Interface_Communication.Role_Requis;

public class ObserverConfig {

	private Configuration configuration;
	private final static Logger logger = Logger.getLogger(Logger.class
			.getName());

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
	 * Méthode qui permet d'informer au lien attachement ou au lien binding
	 * qu'il doit transmettre la donnée
	 * 
	 * @param port
	 *            le port qui a recu l'information
	 * @throws ExceptionDonneeIncorrecte
	 * @throws MauvaiseConfigurationException
	 * @throws ExceptionMauvaisLien
	 */
	public void notifierSortieDonnee(Object port)
			throws ExceptionDonneeIncorrecte, MauvaiseConfigurationException,
			ExceptionMauvaisLien {
		logger.log(Level.INFO,
				"Signal de sortie de donnée reçu, traitement en cours.");
		List<Lien_Attachement> listAttachements = configuration
				.getListLienAttachements();

		Lien_Attachement lienTransporteurAttachement = null;
		Lien_Binding lienTransporteurBinding = null;
		Boolean lienAttachementTrouve = false;
		Boolean lienBindingTrouve = false;
		Interface p = (Interface) port;
		int noLien = 0;

		// On vérifie si on doit envoyer la donnée sur un lien attachement
		while (!lienAttachementTrouve && noLien < listAttachements.size()) {
			lienAttachementTrouve = verifierLienAttachement(port,
					listAttachements.get(noLien));
			if (lienAttachementTrouve) {
				lienTransporteurAttachement = listAttachements.get(noLien);
			}
			noLien++;
		}

		if (null != lienTransporteurAttachement) {
			logger.log(Level.INFO, "Le lien attachement a été trouvé.");
			lienTransporteurAttachement.transmetDonnee(this);
		}
		// Si on n'a pas trouvé de lien attachement, on regarde les liens
		// binding
		else {
			noLien = 0;
			List<Lien_Binding> listLienBindings = configuration
					.getListeLienBinding();
			while (!lienBindingTrouve && noLien < listLienBindings.size()) {
				lienBindingTrouve = verifierLienBinding(port,
						listLienBindings.get(noLien));
				if (lienBindingTrouve) {
					lienTransporteurBinding = listLienBindings.get(noLien);
				}
				noLien++;
			}
			if (null != lienTransporteurBinding) {
				logger.log(Level.INFO, "Le lien binding a été trouvé.");
				listLienBindings.get(noLien - 1).transmetDonnee();
			}
		}

		if (null == lienTransporteurBinding
				&& null == lienTransporteurAttachement) {
			throw new MauvaiseConfigurationException(
					"Aucun lien associé au port n'a pas été trouvé dans la configuration.");
		}
	}

	/**
	 * Méthode qui permet d'informer au connecteur, au composant ou à la
	 * configuration qu'il doit transmettre la donnée
	 * 
	 * @param port
	 *            le port qui a recu l'information
	 * @throws ExceptionDonneeIncorrecte
	 * @throws MauvaiseConfigurationException
	 * @throws ExceptionMauvaisLien
	 */
	public void notifierEntreeDonnee(Object port, String donnee)
			throws ExceptionDonneeIncorrecte, MauvaiseConfigurationException,
			ExceptionMauvaisLien {

		logger.log(Level.INFO,
				"Signal d'entrée de donnée reçue, traitement en cours.");
		// Si le port est un rôle
		// Si le port est un port_composant
		// Si le port est un port_configuration
		List<Objet_Architectural> listeObjetArchitectural = configuration
				.getListeObjetArchitectural();

		Objet_Architectural objetArchitectural = null;
		Boolean interfaceCommunicationTrouve = false;
		Boolean glueTrouvee = false;
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
					interfaceCommunication.setElmtStocke(donnee);
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
			while (!glueTrouvee
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
							roleFourni.setElmtStocke(donnee);
							glue.transmetDonnee(p, this);
							glueTrouvee = true;
							break;
						}
					}
				}
				noObjetArchitectural++;
			}
		}

		Boolean lienBindingTrouve = false;
		if (!glueTrouvee && !interfaceCommunicationTrouve) {
			int noLien = 0;
			Lien_Binding lienTransporteurBinding = null;
			List<Lien_Binding> listLienBindings = configuration
					.getListeLienBinding();
			while (!lienBindingTrouve && noLien < listLienBindings.size()) {
				lienBindingTrouve = verifierLienBinding(port,
						listLienBindings.get(noLien));
				if (lienBindingTrouve) {
					lienTransporteurBinding = listLienBindings.get(noLien);
				}
				noLien++;
			}
			if (null != lienTransporteurBinding) {
				logger.log(Level.INFO, "Le lien binding a été trouvé : "
						+ lienTransporteurBinding.getClass().getName());
				listLienBindings.get(noLien - 1).transmetDonnee();
			}
		}

		if (!glueTrouvee && !interfaceCommunicationTrouve && !lienBindingTrouve) {
			throw new MauvaiseConfigurationException(
					"Aucun objet pour transmettre la donnée dans la configuration");
		}

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

	/**
	 * @param port
	 *            un port
	 * @param lien_Binding
	 *            un lien binding
	 * @return vrai si le port est dans le lien Binding, faux sinon
	 */
	private Boolean verifierLienBinding(Object port, Lien_Binding lien_Binding) {
		boolean portCorrect = false;
		// C'est un port composant requis
		if (port instanceof Port_Composant_Requis) {
			Port_Composant_Requis p = (Port_Composant_Requis) port;
			if (lien_Binding.getPortComposantRequis() != null
					&& p.getNom().equals(
							lien_Binding.getPortComposantRequis().getNom())) {
				portCorrect = true;
				lien_Binding.getPortComposantRequis().setElmtStocke(
						p.getElmtStocke());
			}
		}

		// C'est un port Composant fourni
		else if (port instanceof Port_Composant_Fourni) {
			Port_Composant_Fourni p = (Port_Composant_Fourni) port;
			if (lien_Binding.getPortComposantFourni() != null
					&& p.getNom().equals(
							lien_Binding.getPortComposantFourni().getNom())) {
				portCorrect = true;
				lien_Binding.getPortComposantFourni().setElmtStocke(
						p.getElmtStocke());
			}
		}

		// C'est un port configuration requis
		if (port instanceof Port_Configuration_Requis) {
			Port_Configuration_Requis p = (Port_Configuration_Requis) port;
			if (lien_Binding.getPortConfigurationRequis() != null
					&& p.getNom().equals(
							lien_Binding.getPortConfigurationRequis().getNom())) {
				portCorrect = true;
				lien_Binding.getPortConfigurationRequis().setElmtStocke(
						p.getElmtStocke());
			}
		}

		// C'est un port configuration fourni
		else if (port instanceof Port_Configuration_Fourni) {
			Port_Configuration_Fourni p = (Port_Configuration_Fourni) port;
			if (lien_Binding.getPortConfigurationFourni() != null
					&& p.getNom().equals(
							lien_Binding.getPortConfigurationFourni().getNom())) {
				portCorrect = true;
				lien_Binding.getPortConfigurationFourni().setElmtStocke(
						p.getElmtStocke());
			}
		}
		return portCorrect;
	}
}
