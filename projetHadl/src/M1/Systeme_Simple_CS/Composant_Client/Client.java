package M1.Systeme_Simple_CS.Composant_Client;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant_Simple;
import M2.Objet_Architectural.Interface_Communication.Interface;
import M2.Objet_Architectural.Interface_Communication.Port_Composant_Requis;

public class Client extends Composant_Simple {

	private Port_Composant_Requis sendRequest;

	/**
	 * @param sendRequest
	 */
	public Client(Port_Composant_Requis sendRequest) {
		super();
		this.sendRequest = sendRequest;

		List<Interface> listePorts = new ArrayList<Interface>();
		listePorts.add(this.sendRequest);
		this.setInterfaceCommunication(listePorts);
	}

}
