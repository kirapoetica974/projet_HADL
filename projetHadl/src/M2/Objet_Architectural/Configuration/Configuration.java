package M2.Objet_Architectural.Configuration;

import java.util.ArrayList;
import java.util.List;

import M2.Objet_Architectural.Objet_Architectural;
import M2.Objet_Architectural.Interface_Communication.Lien_Binding;

public class Configuration extends Objet_Architectural {

	List<Objet_Architectural> listeObjetArchitectural = new ArrayList<Objet_Architectural>();

	List<Lien_Binding> listeLienBinding = new ArrayList<Lien_Binding>();

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

}
