package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Connection_Manager;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Database;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Security_Manager;
import M2.Objet_Architectural.Configuration.Configuration;

public class Serveur_Detail extends Configuration {

	private Connection_Manager connectionManager;
	private Database database;
	private Security_Manager securityManager;

	public Serveur_Detail(Connection_Manager connectionManager,
			Database database, Security_Manager securityManager) {
		super();

		this.connectionManager = new Connection_Manager();
		this.database = new Database();
		this.securityManager = new Security_Manager();

		if (null != connectionManager) {
			this.connectionManager = connectionManager;
		}
		if (null != database) {
			this.database = database;
		}
		if (null != securityManager) {
			this.securityManager = securityManager;
		}
	}

}
