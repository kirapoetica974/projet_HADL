package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Explicite;

public class Security_Query extends Connecteur_Explicite {

	private Security_Query_Glue securityQueryGlue;

	public Security_Query() {
		super();

		this.setNom("Security_Query");
		this.securityQueryGlue = new Security_Query_Glue();
		this.setGlue(securityQueryGlue);
	}

	@Override
	public void transmetDonnee() {
		// TODO Auto-generated method stub

	}
}
