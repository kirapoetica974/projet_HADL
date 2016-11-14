package M2.Objet_Architectural.Configuration.PackageConnecteur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import M2.Objet_Architectural.Interface_Communication.Port;
import M2.Objet_Architectural.Interface_Communication.Role_Fourni;
import M2.Objet_Architectural.Interface_Communication.Role_Requis;

public class Glue {

	private List<Role_Requis> listeRoleRequis = new ArrayList<Role_Requis>();

	private List<Role_Fourni> listeRoleFourni = new ArrayList<Role_Fourni>();

	private HashMap<Role_Fourni, Role_Requis> liensFourniRequis = new HashMap<Role_Fourni, Role_Requis>();

	/**
	 * @return listeRoleRequis
	 */
	public List<Role_Requis> getListeRoleRequis() {
		return listeRoleRequis;
	}

	/**
	 * @param listeRoleRequis
	 *            la liste des rôles requis à modifier
	 */
	public void setListeRoleRequis(List<Role_Requis> listeRoleRequis) {
		this.listeRoleRequis = listeRoleRequis;
	}

	/**
	 * @param roleRequis
	 *            ajout de roleRequis dans listeRoleRequis
	 */
	public void addRoleRequis(Role_Requis roleRequis) {
		this.listeRoleRequis.add(roleRequis);
	}

	/**
	 * @return listeRoleFourni
	 */
	public List<Role_Fourni> getListeRoleFourni() {
		return listeRoleFourni;
	}

	/**
	 * @param listeRoleFourni
	 *            la liste des rôles fournis à modifier
	 */
	public void setListeRoleFourni(List<Role_Fourni> listeRoleFourni) {
		this.listeRoleFourni = listeRoleFourni;
	}

	/**
	 * @param roleFourni
	 *            ajout de roleFourni dans listeRoleFourni
	 */
	public void addRoleFourni(Role_Fourni roleFourni) {
		this.listeRoleFourni.add(roleFourni);
	}

	/**
	 * @return liensFourniRequis
	 */
	public HashMap<Role_Fourni, Role_Requis> getLiensFourniRequis() {
		return liensFourniRequis;
	}

	/**
	 * @param liensFourniRequis
	 *            la hashmap des liens entre les roles fournis et requis à
	 *            modifier
	 */
	public void setLiensFourniRequis(
			HashMap<Role_Fourni, Role_Requis> liensFourniRequis) {
		this.liensFourniRequis = liensFourniRequis;
	}

	/**
	 * @param roleFourni
	 *            le role d'entree
	 * @param roleRequis
	 *            le role de sortie
	 */
	public void addLienFourniRequis(Role_Fourni roleFourni,
			Role_Requis roleRequis) {
		this.liensFourniRequis.put(roleFourni, roleRequis);
	}

	public void transmetDonnee(Port portEntree) {

	}

}
