package M2.Objet_Architectural.Configuration;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur;

/**
 * Nous utilisons le Pattern Composite. Dans notre diagramme nous avons un
 * double héritage qui n'est pas faisable en Java c'est pourquoi Connecteur est
 * une interface, et nous n'avons pas beoin de l'instancier contrairement à
 * Composant
 */
public class Configuration extends Composant implements Connecteur {

	List<Connecteur> listeConnecteur = new ArrayList<Connecteur>();

	List<Composant> listeComposant = new ArrayList<Composant>();

	/**
	 * @return listeConnecteur
	 */
	public List<Connecteur> getListeConnecteur() {
		return listeConnecteur;
	}

	/**
	 * @param listeConnecteur
	 *            la listeConnecteur à modifier
	 */
	public void setListeConnecteur(List<Connecteur> listeConnecteur) {
		this.listeConnecteur = listeConnecteur;
	}

	/**
	 * @return listeComposant
	 */
	public List<Composant> getListeComposant() {
		return listeComposant;
	}

	/**
	 * @param listeComposant
	 *            la listeComposant à modifier
	 */
	public void setListeComposant(List<Composant> listeComposant) {
		this.listeComposant = listeComposant;
	}

}
