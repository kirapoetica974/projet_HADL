package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Simple_Explicite;

public class Security_Query extends Connecteur_Simple_Explicite {

	private Security_Query_Glue securityQueryGlue;

	public Security_Query(Security_Query_Glue securityQueryGlue) {
		super();

		this.securityQueryGlue = new Security_Query_Glue();

		if (null != securityQueryGlue) {
			this.securityQueryGlue = securityQueryGlue;
		}
	}

	/**
	 * @return securityQueryGlue
	 */
	public Security_Query_Glue getSecurityQueryGlue() {
		return securityQueryGlue;
	}

	/**
	 * @param securityQueryGlue
	 *            : securityQueryGlue à modifier
	 */
	public void setSecurityQueryGlue(Security_Query_Glue securityQueryGlue) {
		this.securityQueryGlue = securityQueryGlue;
	}
}