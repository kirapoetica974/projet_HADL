package M2.Objet_Architectural.Interface_Communication;

public class Lien_Binding {

	private Port_Composant_Fourni portComposantFourni;

	private Port_Composant_Requis portComposantRequis;

	private Port_Configuration_Fourni portConfigurationFourni;

	private Port_Configuration_Requis portConfigurationRequis;

	// Constructeur
	public Lien_Binding(Port portComposant, Port portConfiguration)
			throws ExceptionMauvaisLien {
		super();
		/*
		 * Dans le cas où on a un lien entre le port composant fourni et le port
		 * configuration fourni
		 */
		if (portComposant instanceof Port_Composant_Fourni
				&& portConfiguration instanceof Port_Configuration_Fourni) {
			this.portComposantFourni = (Port_Composant_Fourni) portComposant;
			this.portConfigurationFourni = (Port_Configuration_Fourni) portConfiguration;
			this.portComposantRequis = null;
			this.portConfigurationRequis = null;

			/*
			 * Dans le cas où on a un lien binding entre le port composant
			 * requis et le port configuration requis
			 */
		} else if (portComposant instanceof Port_Composant_Requis
				&& portConfiguration instanceof Port_Configuration_Requis) {
			this.portComposantRequis = (Port_Composant_Requis) portComposant;
			this.portConfigurationRequis = (Port_Configuration_Requis) portConfiguration;
			this.portComposantFourni = null;
			this.portConfigurationFourni = null;

			/*
			 * Dans tous les autres cas on lance une exception
			 */
		} else {
			throw new ExceptionMauvaisLien("Mauvais lien binding");
		}
	}

	/**
	 * @return portComposantFourni
	 */
	public Port_Composant_Fourni getPortComposantFourni() {
		return portComposantFourni;
	}

	/**
	 * @param portComposantFourni
	 *            le port Composant Fourni à modifier
	 */
	public void setPortComposantFourni(Port_Composant_Fourni portComposantFourni) {
		this.portComposantFourni = portComposantFourni;
	}

	/**
	 * @return portComposantRequis
	 */
	public Port_Composant_Requis getPortComposantRequis() {
		return portComposantRequis;
	}

	/**
	 * @param portComposantRequis
	 *            le port Composant Requis à modifier
	 */
	public void setPortComposantRequis(Port_Composant_Requis portComposantRequis) {
		this.portComposantRequis = portComposantRequis;
	}

	/**
	 * @return portConfigurationFourni
	 */
	public Port_Configuration_Fourni getPortConfigurationFourni() {
		return portConfigurationFourni;
	}

	/**
	 * @param portConfigurationFourni
	 *            le port Configuration Fourni à modifier
	 */
	public void setPortConfigurationFourni(
			Port_Configuration_Fourni portConfigurationFourni) {
		this.portConfigurationFourni = portConfigurationFourni;
	}

	/**
	 * @return portConfigurationRequis
	 */
	public Port_Configuration_Requis getPortConfigurationRequis() {
		return portConfigurationRequis;
	}

	/**
	 * @param portConfigurationRequis
	 *            le port Configuration Requis à modifier
	 */
	public void setPortConfigurationRequis(
			Port_Configuration_Requis portConfigurationRequis) {
		this.portConfigurationRequis = portConfigurationRequis;
	}
}
