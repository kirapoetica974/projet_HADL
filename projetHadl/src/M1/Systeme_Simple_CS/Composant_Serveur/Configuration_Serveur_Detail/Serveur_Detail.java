package M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail;

import M1.Systeme_Simple_CS.Serveur_Fourni_Serveur_Detail_Lien_Binding;
import M1.Systeme_Simple_CS.Serveur_Requis_Serveur_Detail_Lien_Binding;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Connection_Manager;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Send_DB_Query_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Connection_Manager.Send_Security_Check_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Database;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Send_Query_Int_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Database.Send_Security_Management_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Security_Manager;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Send_C_Query_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Composant_Security_Manager.Send_Security_Auth_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request.Clearence_Request;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request.Clearence_Request_Caller_Receive_Security_Auth_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Clearence_Request.Clearence_Request_Caller_Receive_Security_Check_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request.SQL_Request;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request.SQL_Request_Caller_Receive_DB_Query_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_SQL_Request.SQL_Request_Caller_Receive_Query_Int_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query_Receive_C_Query_Lien_Attachement;
import M1.Systeme_Simple_CS.Composant_Serveur.Configuration_Serveur_Detail.Connecteur_Security_Query.Security_Query_Receive_Security_Management_Lien_Attachement;
import M2.ObserverConfig;
import M2.Objet_Architectural.Configuration.Configuration;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Serveur_Detail extends Configuration {

	// Singleton
	private static Serveur_Detail serveurDetailInstance;

	public ObserverConfig observer;

	private Connection_Manager connectionManager;
	private Database database;
	private Security_Manager securityManager;
	private SQL_Request sqlRequest;
	private Clearence_Request clearenceRequest;
	private Security_Query securityQuery;

	private Send_DB_Query_Lien_Attachement sendDBQueryLienAttachement;
	private Send_Security_Check_Lien_Attachement sendSecurityCheckLienAttachement;
	private Send_Query_Int_Lien_Attachement sendQueryIntLienAttachement;
	private Send_Security_Management_Lien_Attachement sendSecurityManagementLienAttachement;
	private Send_C_Query_Lien_Attachement sendCQueryLienAttachement;
	private Send_Security_Auth_Lien_Attachement sendSecurityAuthLienAttachement;
	private Clearence_Request_Caller_Receive_Security_Auth_Lien_Attachement clearenceRequestCallerReceiveSecurityAuthLienAttachement;
	private Clearence_Request_Caller_Receive_Security_Check_Lien_Attachement clearenceRequestCallerReceiveSecurityCheckLienAttachement;
	private Security_Query_Receive_C_Query_Lien_Attachement securityQueryReceiveCQueryLienAttachement;
	private Security_Query_Receive_Security_Management_Lien_Attachement securityManagementLienAttachement;
	private SQL_Request_Caller_Receive_DB_Query_Lien_Attachement sqlRequestCallerReceiveDBQueryLienAttachement;
	private SQL_Request_Caller_Receive_Query_Int_Lien_Attachement sqlRequestCallerReceiveQueryIntLienAttachement;

	private Serveur_Detail_Fourni_Connection_Manager_Lien_Binding serveurDetailFourniConnectionManagerLienBinding;
	private Serveur_Detail_Requis_Connection_Manager_Lien_Binding serveurDetailRequisConnectionManagerLienBinding;
	private Serveur_Fourni_Serveur_Detail_Lien_Binding serveurFourniServeurDetailLienBinding;
	private Serveur_Requis_Serveur_Detail_Lien_Binding serveurRequisServeurDetailLienBinding;

	private Serveur_Detail() throws ExceptionMauvaisLien {
		super();

		this.observer = new ObserverConfig(this);

		this.setNom("Serveur_Detail");
		this.sqlRequest = new SQL_Request();
		this.clearenceRequest = new Clearence_Request();
		this.securityQuery = new Security_Query();

		this.connectionManager = new Connection_Manager();
		this.database = new Database();
		this.securityManager = new Security_Manager();

		this.sendDBQueryLienAttachement = new Send_DB_Query_Lien_Attachement();
		this.sendSecurityCheckLienAttachement = new Send_Security_Check_Lien_Attachement();
		this.sendQueryIntLienAttachement = new Send_Query_Int_Lien_Attachement();
		this.sendSecurityManagementLienAttachement = new Send_Security_Management_Lien_Attachement();
		this.sendCQueryLienAttachement = new Send_C_Query_Lien_Attachement();
		this.sendSecurityAuthLienAttachement = new Send_Security_Auth_Lien_Attachement();
		this.clearenceRequestCallerReceiveSecurityAuthLienAttachement = new Clearence_Request_Caller_Receive_Security_Auth_Lien_Attachement();
		this.clearenceRequestCallerReceiveSecurityCheckLienAttachement = new Clearence_Request_Caller_Receive_Security_Check_Lien_Attachement();
		this.securityQueryReceiveCQueryLienAttachement = new Security_Query_Receive_C_Query_Lien_Attachement();
		this.securityManagementLienAttachement = new Security_Query_Receive_Security_Management_Lien_Attachement();
		this.sqlRequestCallerReceiveDBQueryLienAttachement = new SQL_Request_Caller_Receive_DB_Query_Lien_Attachement();
		this.sqlRequestCallerReceiveQueryIntLienAttachement = new SQL_Request_Caller_Receive_Query_Int_Lien_Attachement();

		this.serveurDetailFourniConnectionManagerLienBinding = new Serveur_Detail_Fourni_Connection_Manager_Lien_Binding();
		this.serveurDetailRequisConnectionManagerLienBinding = new Serveur_Detail_Requis_Connection_Manager_Lien_Binding();
		this.serveurFourniServeurDetailLienBinding = new Serveur_Fourni_Serveur_Detail_Lien_Binding();
		this.serveurRequisServeurDetailLienBinding = new Serveur_Requis_Serveur_Detail_Lien_Binding();

		this.addObjetArchitectural(this.connectionManager);
		this.addObjetArchitectural(this.database);
		this.addObjetArchitectural(this.securityManager);
		this.addObjetArchitectural(this.sqlRequest);
		this.addObjetArchitectural(this.clearenceRequest);
		this.addObjetArchitectural(this.securityQuery);

		this.addLienAttachement(clearenceRequestCallerReceiveSecurityAuthLienAttachement);
		this.addLienAttachement(clearenceRequestCallerReceiveSecurityCheckLienAttachement);
		this.addLienAttachement(securityManagementLienAttachement);
		this.addLienAttachement(securityQueryReceiveCQueryLienAttachement);
		this.addLienAttachement(sendCQueryLienAttachement);
		this.addLienAttachement(sendDBQueryLienAttachement);
		this.addLienAttachement(sendQueryIntLienAttachement);
		this.addLienAttachement(sendSecurityAuthLienAttachement);
		this.addLienAttachement(sendSecurityCheckLienAttachement);
		this.addLienAttachement(sendSecurityManagementLienAttachement);
		this.addLienAttachement(sqlRequestCallerReceiveDBQueryLienAttachement);
		this.addLienAttachement(sqlRequestCallerReceiveQueryIntLienAttachement);

		this.addLienBinding(serveurDetailFourniConnectionManagerLienBinding);
		this.addLienBinding(serveurDetailRequisConnectionManagerLienBinding);
		this.addLienBinding(serveurFourniServeurDetailLienBinding);
		this.addLienBinding(serveurRequisServeurDetailLienBinding);
	}

	public static Serveur_Detail getInstance() throws ExceptionMauvaisLien {
		if (null == serveurDetailInstance) {
			serveurDetailInstance = new Serveur_Detail();
		}
		return serveurDetailInstance;
	}

	public Connection_Manager getConnectionManager() {
		return connectionManager;
	}

	public Database getDatabase() {
		return database;
	}

	public Security_Manager getSecurityManager() {
		return securityManager;
	}

	public ObserverConfig getObserver() {
		return observer;
	}

}
