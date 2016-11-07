package M2.Objet_Architectural.Configuration;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Interface_Communication.Lien_Attachement;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Configuration extends Objet_Architectural {

	List<Objet_Architectural> listeObjetArchitectural = new ArrayList<Objet_Architectural>();

	List<Lien_Binding> listeLienBinding = new ArrayList<Lien_Binding>();

	List<Lien_Attachement> listLienAttachements = new ArrayList<Lien_Attachement>();

	/**
	 * @return listeObjetArchitectural
	 */
	public List<Objet_Architectural> getListeObjetArchitectural() {
		return listeObjetArchitectural;
	}

	/**
	 * @param listeObjetArchitectural
	 *            la liste des objets architecturaux à modifier
	 */
	public void setListeObjetArchitectural(
			List<Objet_Architectural> listeObjetArchitectural) {
		this.listeObjetArchitectural = listeObjetArchitectural;
	}

	/**
	 * @param objetArchitectural
	 *            l'objet architectural à ajouter à la liste
	 */
	public void addObjetArchitectural(Objet_Architectural objetArchitectural) {
		this.listeObjetArchitectural.add(objetArchitectural);
	}

	/**
	 * @return listeLienBinding
	 */
	public List<Lien_Binding> getListeLienBinding() {
		return listeLienBinding;
	}

	/**
	 * @param listeLienBinding
	 *            la liste des liens binding à modifier
	 */
	public void setListeLienBinding(List<Lien_Binding> listeLienBinding) {
		this.listeLienBinding = listeLienBinding;
	}

	/**
	 * @param listeLienBinding
	 *            le lien binding à ajouter à la liste
	 */
	public void addLienBinding(Lien_Binding lienBinding) {
		this.listeLienBinding.add(lienBinding);
	}

	/**
	 * @return listLienAttachements
	 */
	public List<Lien_Attachement> getListLienAttachements() {
		return listLienAttachements;
	}

	/**
	 * @param listLienAttachements
	 *            la liste des Liens Attachements à modifier
	 */
	public void setListLienAttachements(
			List<Lien_Attachement> listLienAttachements) {
		this.listLienAttachements = listLienAttachements;
	}

	/**
	 * @param lienAttachement
	 *            le liens Attachement à ajouter
	 */
	public void addListLienAttachements(Lien_Attachement lienAttachement) {
		this.listLienAttachements.add(lienAttachement);
	}

}
