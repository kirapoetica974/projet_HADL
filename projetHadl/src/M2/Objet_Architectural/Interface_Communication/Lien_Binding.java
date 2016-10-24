package M2.Objet_Architectural.Interface_Communication;

public class Lien_Binding {

	private Port_Composant_Fourni portComposantFourni;

	private Port_Composant_Requis portComposantRequis;

	private Port_Configuration_Fourni portConfigurationFourni;

	private Port_Configuration_Requis portConfigurationRequis;

	// Constructeur
	public Lien_Binding(Port portComposant, Port portConfiguration) {
		super();
		this.portComposantFourni = portComposantFourni;
		this.portComposantRequis = portComposantRequis;
	}

}
