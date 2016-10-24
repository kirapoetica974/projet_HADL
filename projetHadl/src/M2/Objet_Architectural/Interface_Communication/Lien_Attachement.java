package M2.Objet_Architectural.Interface_Communication;

/**
 * Le lien attachement relie soit un rôle fourni avec un port requis d'un
 * composant, soit un rôle requis avec un port fourni d'un composant. Ce
 * contrôle est effetué lors de la création du lien grâce au constructeur
 */
public class Lien_Attachement {

	private Role_Requis roleRequis;

	private Port_Composant_Fourni portComposantFourni;

	private Role_Fourni roleFourni;

	private Port_Composant_Requis portComposantRequis;

	/**
	 * Contructeur du lien attachement
	 */
	private Lien_Attachement(Role role, Port port) {
		if (role instanceof Role_Requis
				&& port instanceof Port_Composant_Fourni) {

			this.roleRequis = (Role_Requis) role;
			this.portComposantFourni = (Port_Composant_Fourni) port;
			this.roleFourni = null;
			this.portComposantRequis = null;

		} else if (role instanceof Role_Fourni
				&& port instanceof Port_Composant_Requis) {

			this.roleFourni = (Role_Fourni) role;
			this.portComposantRequis = (Port_Composant_Requis) port;
			this.roleRequis = null;
			this.portComposantFourni = null;

		} else {
			// Erreur
		}
	}

	/**
	 * @return roleRequis
	 */
	public Role_Requis getRoleRequis() {
		return roleRequis;
	}

	/**
	 * @param roleRequis
	 *            le rôle requis à modifier
	 */
	public void setRoleRequis(Role_Requis roleRequis) {
		this.roleRequis = roleRequis;
	}

	/**
	 * @return portComposantFourni
	 */
	public Port_Composant_Fourni getPortComposantFourni() {
		return portComposantFourni;
	}

	/**
	 * @param portComposantFourni
	 *            le port fourni du composant à modifier
	 */
	public void setPortComposantFourni(Port_Composant_Fourni portComposantFourni) {
		this.portComposantFourni = portComposantFourni;
	}

	/**
	 * @return roleFourni
	 */
	public Role_Fourni getRoleFourni() {
		return roleFourni;
	}

	/**
	 * @param roleFourni
	 *            le rôle fourni à modifier
	 */
	public void setRoleFourni(Role_Fourni roleFourni) {
		this.roleFourni = roleFourni;
	}

	/**
	 * @return portComposantRequis
	 */
	public Port_Composant_Requis getPortComposantRequis() {
		return portComposantRequis;
	}

	/**
	 * @param portComposantRequis
	 *            le port requis du composant à modifier
	 */
	public void setPortComposantRequis(Port_Composant_Requis portComposantRequis) {
		this.portComposantRequis = portComposantRequis;
	}

}
