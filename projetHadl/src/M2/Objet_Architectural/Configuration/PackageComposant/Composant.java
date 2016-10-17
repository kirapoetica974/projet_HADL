package M2.Objet_Architectural.Configuration.PackageComposant;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Interface_Communication.Interface;

public class Composant implements Objet_Architectural {

	private Interface interfaceCommunication;

	private String nom;

	@Override
	public Interface getInterfaceCommunication() {
		return interfaceCommunication;
	}

	@Override
	public void setInterfaceCommunication(Interface interfaceCommunication) {
		this.interfaceCommunication = interfaceCommunication;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

}
