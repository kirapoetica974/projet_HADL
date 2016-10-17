package M2.Objet_Architectural;

public abstract class Objet_Architectural {

	public Interface interfaceCommunication;

	/**
	 * Lecture de l'attribut interfaceCommunication
	 * 
	 * @return interfaceCommunication
	 */
	public Interface getInterfaceCommunication() {
		return interfaceCommunication;
	}

	/**
	 * Ecriture de l'attribut interfaceCommunication
	 * 
	 * @param interfaceCommunication
	 *            l'interfaceCommunication à modifier
	 */
	public void setInterfaceCommunication(Interface interfaceCommunication) {
		this.interfaceCommunication = interfaceCommunication;
	}

}
