package M2.Objet_Architectural.Interface_Communication;

public abstract class Port extends Interface {

	String elmtStocke;

	/**
	 * @return l'elmt stocké
	 */
	public String getElmtStocke() {
		return elmtStocke;
	}

	/**
	 * @param elmtStocke
	 *            l'elmtStocke à modifier
	 */
	public void setElmtStocke(String elmtStocke) {
		this.elmtStocke = elmtStocke;
	}

}
