package M2.Objet_Architectural.Configuration.PackageComposant;

import M2.Objet_Architectural.Interface_Communication.Interface;

public class Composant_Simple extends Composant {

	private Interface interfaceCommunication;

	@Override
	public Interface getInterfaceCommunication() {
		return interfaceCommunication;
	}

	@Override
	public void setInterfaceCommunication(Interface interfaceCommunication) {
		this.interfaceCommunication = interfaceCommunication;
	}

}
