package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request;

import M2.Objet_Architectural.Configuration.PackageConnecteur.Connecteur_Explicite;

public class Clearence_Request extends Connecteur_Explicite {

	private Clearence_Request_Glue clearenceRequestGlue;

	public Clearence_Request() {
		super();
		this.setNom("Clearence_Request");
		this.clearenceRequestGlue = new Clearence_Request_Glue();
		this.setGlue(this.clearenceRequestGlue);
	}

	@Override
	public void transmetDonnee() {
		// TODO Auto-generated method stub

	}

}
