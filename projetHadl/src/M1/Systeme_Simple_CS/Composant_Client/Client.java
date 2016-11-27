package M1.Systeme_Simple_CS.Composant_Client;

import java.util.Scanner;
import java.util.logging.Logger;

import M1.Systeme_Simple_CS.Simple_CS;
import M2.ExceptionDonneeIncorrecte;
import M2.MauvaiseConfigurationException;
import M2.Objet_Architectural.Configuration.PackageComposant.Composant;
import M2.Objet_Architectural.Interface_Communication.ExceptionMauvaisLien;

public class Client extends Composant {

	private final static Logger logger = Logger.getLogger(Logger.class
			.getName());
	private final static String IDENTIFICATION = "CONNEXION ";
	private final static String AJOUT = "AJOUT ";
	private final String CONNEXION_OK = "CONNEXION OK";
	private final String CONNEXION_NON_OK = "CONNEXION NON OK";
	private final String REQUETE = "REQUETE ";

	private Send_Request sendRequest;
	private Receive_Client receiveClient;
	private Boolean connecte;

	/**
	 * @param sendRequest
	 */
	public Client() {
		super();

		this.sendRequest = new Send_Request();
		this.receiveClient = new Receive_Client();

		this.setNom("Client");
		this.addInterfaceCommunication(this.sendRequest);
		this.addInterfaceCommunication(this.receiveClient);

		this.connecte = false;

	}

	public void start() throws ExceptionDonneeIncorrecte,
			MauvaiseConfigurationException, ExceptionMauvaisLien {

		Boolean quit = false;
		while (!quit) {
			String s = lancerMenu();
			Scanner sc = new Scanner(System.in);
			switch (s) {
			case "1":
				System.out.println("Saisir votre pseudo : ");
				String pseudo = sc.nextLine();
				System.out.println("Saisir votre mdp : ");
				String mdp = sc.nextLine();

				String identification = IDENTIFICATION + pseudo + "-" + mdp;
				sendRequest.setElmtStocke(identification);
				Simple_CS.getInstance().getObserver()
						.notifierSortieDonnee(sendRequest);
				break;
			case "2":
				System.out.println("Saisir un type d'élément à afficher :");
				String type = sc.nextLine();
				sendRequest.setElmtStocke(type);

				String requete = REQUETE + type;
				sendRequest.setElmtStocke(requete);
				Simple_CS.getInstance().getObserver()
						.notifierSortieDonnee(sendRequest);
				break;
			case "3":
				if (connecte) {
					System.out.println("Saisir un type d'élément :");
					String typeElem = sc.nextLine();
					System.out.println("Saisir un nom :");
					String nom = sc.nextLine();
					System.out.println("Saisir une quantite :");
					String qte = sc.nextLine();
					System.out.println("Saisir un prix :");
					String prix = sc.nextLine();

					String ajout = AJOUT + typeElem + "-" + nom + "-" + qte
							+ "-" + prix;
					sendRequest.setElmtStocke(ajout);
					Simple_CS.getInstance().getObserver()
							.notifierSortieDonnee(sendRequest);
				} else {
					System.out
							.println("Vous devez vous connecter pour ajouter une donnée !");
				}
				break;
			case "4":
				quit = true;
				break;
			default:
				System.out.println("Choix incorrecte");
				break;
			}
		}

	}

	@Override
	public void transmetDonnee() {
		if (CONNEXION_OK.equals(this.receiveClient.getElmtStocke())) {
			connecte = true;
			System.out.println("Vous êtes connecté.");
		} else if (CONNEXION_NON_OK.equals(this.receiveClient.getElmtStocke())) {
			connecte = false;
			System.out
					.println("Votre pseudo ou votre mot de passe est incorrecte.");
		} else {
			System.out.println(this.receiveClient.getElmtStocke());
		}

	}

	public String lancerMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir une option dans le menu : ");
		System.out.println("1 : Connexion");
		System.out.println("2 : Choisir un type d'élément à afficher");
		System.out
				.println("3 : Ajouter un élément à la base de donnée (connexion obligatoire)");
		System.out.println("4 : Quitter");
		return sc.nextLine();
	}
}
