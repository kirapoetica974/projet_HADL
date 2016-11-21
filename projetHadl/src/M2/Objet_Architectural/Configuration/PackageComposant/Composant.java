package M2.Objet_Architectural.Configuration.PackageComposant;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Objet_Architectural;

public class Composant extends Objet_Architectural {

	private List<Propriete> listePropriete = new ArrayList<Propriete>();

	private List<Contrainte> listeContrainte = new ArrayList<Contrainte>();

	/**
	 * @return la listePropriete
	 */
	public List<Propriete> getListePropriete() {
		return listePropriete;
	}

	/**
	 * @param listePropriete
	 *            la listePropriete à modifier
	 */
	public void setListePropriete(List<Propriete> listePropriete) {
		this.listePropriete = listePropriete;
	}

	/**
	 * @param propriete
	 *            ajout de propriete dans listePropriete
	 */
	public void addPropriete(Propriete propriete) {
		this.listePropriete.add(propriete);
	}

	/**
	 * @return la listeContrainte
	 */
	public List<Contrainte> getListeContrainte() {
		return listeContrainte;
	}

	/**
	 * @param listeContrainte
	 *            la listeContrainte à modifier
	 */
	public void setListeContrainte(List<Contrainte> listeContrainte) {
		this.listeContrainte = listeContrainte;
	}

	/**
	 * @param contrainte
	 *            ajout de contrainte dans listeContrainte
	 */
	public void addContrainte(Contrainte contrainte) {
		this.listeContrainte.add(contrainte);
	}

}
