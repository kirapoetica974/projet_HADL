package M2.Objet_Architectural.Configuration.PackageConnecteur;

import M2.Objet_Architectural.Objet_Architectural;

public abstract class Connecteur extends Objet_Architectural {

	private Glue glue;

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
