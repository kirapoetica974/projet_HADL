package M2.Objet_Architectural.Configuration.PackageConnecteur;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Interface_Communication.Interface;

public interface Connecteur extends Objet_Architectural {

	@Override
	public Interface getInterfaceCommunication();

	@Override
	public void setInterfaceCommunication(Interface interfaceCommunication);
}
