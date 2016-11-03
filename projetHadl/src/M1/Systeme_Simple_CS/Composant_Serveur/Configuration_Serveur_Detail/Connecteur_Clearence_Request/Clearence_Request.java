package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Simple_Explicite;

public class Clearence_Request extends Connecteur_Simple_Explicite {

	private Clearence_Request_Glue clearenceRequestGlue;

	public Clearence_Request(Clearence_Request_Glue clearenceRequestGlue) {
		super();

		this.setClearenceRequestGlue(new Clearence_Request_Glue());

		if (null != clearenceRequestGlue) {
			this.setClearenceRequestGlue(clearenceRequestGlue);
		}
	}

	/**
	 * @return clearenceRequestGlue
	 */
	public Clearence_Request_Glue getClearenceRequestGlue() {
		return clearenceRequestGlue;
	}

	/**
	 * @param clearenceRequestGlue
	 *            : clearenceRequestGlue à modifier
	 */
	public void setClearenceRequestGlue(
			Clearence_Request_Glue clearenceRequestGlue) {
		this.clearenceRequestGlue = clearenceRequestGlue;
	}

}
