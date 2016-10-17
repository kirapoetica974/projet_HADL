package M2.Objet_Architectural;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Interface_Communication.Interface;

/**
 * Cette interface représente l'ensemble des objets architecturaux. Ils
 * possèdent un nom et une interface.
 * 
 * @author Rachelle & Nina
 *
 */
public abstract class Objet_Architectural {

	private List<Interface> interfaceCommunication = new ArrayList<Interface>();

	private String nom;

	/**
	 * @return l'interfaceCommunication
	 */
	public List<Interface> getInterfaceCommunication() {
		return interfaceCommunication;
	}

	/**
	 * @param interfaceCommunication
	 *            l'interfaceCommunication à modifier
	 */
	public void setInterfaceCommunication(List<Interface> interfaceCommunication) {
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
