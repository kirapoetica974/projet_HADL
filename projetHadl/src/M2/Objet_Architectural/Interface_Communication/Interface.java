package M2.Objet_Architectural.Interface_Communication;

/**
 * Cette interface représente une interface de communication entre différents
 * objets architecturaux.
 * 
 * @author Rachelle & Nina
 */
public abstract class Interface {

	private String nom;

	/**
	 * @return le nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            le nom à modifier
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
