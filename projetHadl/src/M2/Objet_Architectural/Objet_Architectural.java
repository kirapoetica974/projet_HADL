package M2.Objet_Architectural;

import M2.Objet_Architectural.Interface_Communication.Interface;

/**
 * Cette interface
 * 
 * @author Rachelle & Nina
 *
 */
public interface Objet_Architectural {

	/**
	 * 
	 * @return interfaceCommunication
	 */
	public Interface getInterfaceCommunication();

	/**
	 * 
	 * @param interfaceCommunication
	 *            l'interfaceCommunication à modifier
	 */
	public void setInterfaceCommunication(Interface interfaceCommunication);

	/**
	 * @return le nom
	 */
	public String getNom();

	/**
	 * @param nom
	 *            le nom à modifier
	 */
	public void setNom(String nom);
}
