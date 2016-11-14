package M2.Objet_Architectural.Interface_Communication;

import M2.ExceptionDonneeIncorrecte;
import M2.ObserverConfig;

/**
 * Le lien attachement relie soit un rôle fourni avec un port requis d'un
 * composant, soit un rôle requis avec un port fourni d'un composant. Ce
 * contrôle est effetué lors de la création du lien grâce au constructeur
 */
public class Lien_Attachement {

	private Role_Requis roleRequis = null;

	private Port_Composant_Fourni portComposantFourni = null;

	private Role_Fourni roleFourni = null;

	private Port_Composant_Requis portComposantRequis = null;

	private ObserverConfig observer = ObserverConfig.getInstance();

	/**
	 * Contructeur du lien attachement
	 * 
	 * @throws ExceptionMauvaisLien
	 */
	public Lien_Attachement(Role role, Port port) throws ExceptionMauvaisLien {
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
			throw new ExceptionMauvaisLien("Mauvais lien attachement");
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

	public void transmetDonnee() throws ExceptionDonneeIncorrecte {
		String donnee = null;
		if (this.portComposantRequis != null && this.roleFourni != null) {
			donnee = this.portComposantRequis.getElmtStocke();
			if (donnee != null) {
				this.roleFourni.setElmtStocke(donnee);
				observer.notifierEntreeDonnee(this.roleFourni);
			}
		} else if (this.portComposantFourni != null && this.roleRequis != null) {
			donnee = this.roleRequis.getElmtStocke();
			if (donnee != null) {
				this.portComposantFourni.setElmtStocke(donnee);
				observer.notifierEntreeDonnee(this.portComposantFourni);
			}
		}

	}
}
