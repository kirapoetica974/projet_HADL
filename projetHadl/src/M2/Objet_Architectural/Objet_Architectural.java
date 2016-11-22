package M2.Objet_Architectural;

import java.util.ArrayList;
import java.util.List;

import M2.ExceptionDonneeIncorrecte;
import M2.Objet_Architectural.Interface_Communication.Interface;

/**
 * Cette interface représente l'ensemble des objets architecturaux. Ils
 * possèdent un nom et une interface.
 * 
 * @author Rachelle & Nina
 *
 */
public abstract class Objet_Architectural {

	private List<Interface> listeInterfaceCommunication = new ArrayList<Interface>();

	private String nom;

	/**
	 * @return l'interfaceCommunication
	 */
	public List<Interface> getInterfaceCommunication() {
		return listeInterfaceCommunication;
	}

	/**
	 * @param listeInterfaceCommunication
	 *            la liste d'interfaces de communication à modifier
	 */
	public void setInterfaceCommunication(
			List<Interface> listeInterfaceCommunication) {
		this.listeInterfaceCommunication = listeInterfaceCommunication;
	}

	/**
	 * @param interfaceCommunication
	 *            ajout de interfaceCommunication dans
	 *            listeInterfaceCommunication
	 */
	public void addInterfaceCommunication(Interface interfaceCommunication) {
		this.listeInterfaceCommunication.add(interfaceCommunication);
	}

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            le nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode qui permet de transmettre une donnée
	 * 
	 * @throws ExceptionDonneeIncorrecte
	 */
	public abstract void transmetDonnee() throws ExceptionDonneeIncorrecte;

}
