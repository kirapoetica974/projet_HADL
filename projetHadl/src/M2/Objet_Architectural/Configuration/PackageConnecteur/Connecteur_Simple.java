package M2.Objet_Architectural.Configuration.PackageConnecteur;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Interface_Communication.Role;

public abstract class Connecteur_Simple extends Connecteur {

	private List<Role> listeRole = new ArrayList<Role>();

	private Glue glue;

	/**
	 * @return listeRole
	 */
	public List<Role> getListeRole() {
		return listeRole;
	}

	/**
	 * @param listeRole
	 *            la liste des roles à modifier
	 */
	public void setListeRole(List<Role> listeRole) {
		this.listeRole = listeRole;
	}

	/**
	 * @param role
	 *            ajout de role dans listeRole
	 */
	public void addRole(Role role) {
		this.listeRole.add(role);
	}

	/**
	 * @return la glue
	 */
	public Glue getGlue() {
		return glue;
	}

	/**
	 * @param glue
	 *            la glue à modifier
	 */
	public void setGlue(Glue glue) {
		this.glue = glue;
	}

}
