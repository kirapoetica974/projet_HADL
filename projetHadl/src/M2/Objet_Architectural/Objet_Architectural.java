package M2.Objet_Architectural;

import M2.Objet_Architectural.Interface_Communication.Interface;

/**
 * Cette interface représente l'ensemble des objets architecturaux.
 * Ils possèdent un nom et une interface.
 * 
 * @author Rachelle & Nina
 *
 */
public abstract class Objet_Architectural {

	private Interface interfaceCommunication;

	private String nom;

	/**
	 * @return l'interfaceCommunication
	 */
	public Interface getInterfaceCommunication() {
		return interfaceCommunication;
	}

	/**
	 * @param interfaceCommunication
	 *            l'interfaceCommunication à modifier
	 */
	public void setInterfaceCommunication(Interface interfaceCommunication) {
		this.interfaceCommunication = interfaceCommunication;
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

}
