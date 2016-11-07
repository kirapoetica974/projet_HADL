package M2;

import java.util.List;

import M2.Objet_Architectural.Configuration.Configuration;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;
import M2.Objet_Architectural.Interface_Communication.Port;
import M2.Objet_Architectural.Interface_Communication.Port_Composant_Requis;
import M2.Objet_Architectural.Interface_Communication.Port_Configuration_Fourni;
import M2.Objet_Architectural.Interface_Communication.Role;
import M2.Objet_Architectural.Interface_Communication.Role_Fourni;
import M2.Objet_Architectural.Interface_Communication.Role_Requis;

public class ObserverConfig {

	Configuration configuration;

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

		Boolean portCompFourni = port instanceof Port_Configuration_Fourni
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
