package M2.Objet_Architectural.Configuration.PackageConnecteur;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Interface_Communication.Role_Fourni;
import M2.Objet_Architectural.Interface_Communication.Role_Requis;

public class Connecteur_Simple extends Connecteur {

	private List<Role_Requis> listeRoleRequis = new ArrayList<Role_Requis>();
	private List<Role_Fourni> listeRoleFourni = new ArrayList<Role_Fourni>();

	private Glue glue;

	/**
	 * @return la listeRoleRequis
	 */
	public List<Role_Requis> getListeRoleRequis() {
		return listeRoleRequis;
	}

	/**
	 * @param listeRoleRequis
	 *            la listeRoleRequis à modifier
	 */
	public void setListeRoleRequis(List<Role_Requis> listeRoleRequis) {
		this.listeRoleRequis = listeRoleRequis;
	}

	/**
	 * @return la listeRoleFourni
	 */
	public List<Role_Fourni> getListeRoleFourni() {
		return listeRoleFourni;
	}

	/**
	 * @param listeRoleFourni
	 *            la listeRoleFourni à modifier
	 */
	public void setListeRoleFourni(List<Role_Fourni> listeRoleFourni) {
		this.listeRoleFourni = listeRoleFourni;
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
