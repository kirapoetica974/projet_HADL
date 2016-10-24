package M2.Objet_Architectural.Configuration.PackageComposant;

import java.util.ArrayList;
import java.util.List;

public class Composant_Simple extends Composant {

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

}
