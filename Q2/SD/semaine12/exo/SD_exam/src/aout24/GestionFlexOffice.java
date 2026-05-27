package aout24;

public class GestionFlexOffice {

	//private static Scanner scanner = new Scanner(System.in);
	private static MonScanner scanner = new MonScanner("inputFlexOffice.txt");
	private static FlexOffice flexo;

	public static void main(String[] args) {

		System.out.println("*************************************************");
		System.out.println("Gestion des occupations des bureaux d'une journee");
		System.out.println("*************************************************");
		System.out.println();

		// configuration
		System.out.println("Configuration");
		System.out.println("----------------------------");
		System.out.print("Entrez le nombre de bureaux : ");
		int nombreBureaux = scanner.nextInt();
		System.out.print("Entrez le nombre d'employes : ");
		int nombreEmployes = scanner.nextInt();
		scanner.nextLine();
		String[] tableEmployes = new String[nombreEmployes];
		for (int i = 0; i < tableEmployes.length; i++) {
			System.out.print("Entrez le nom de l'employe " + (i + 1) + " : ");
			String nom  = scanner.nextLine();
			tableEmployes[i] = nom;
		}
		flexo = new FlexOffice(nombreBureaux, tableEmployes);
		System.out.println();

		System.out.println("Phase 1 (la veille)");
		System.out.println("----------------");
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> reserver un bureau de son choix");
			System.out.println("2 -> retrouver le bureau d'un employe");
			System.out.println("3 -> afficher tout");
			System.out.println("autre -> passer a la phase 2");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					reserverPhase1();
					break;
				case 2:
					retrouverBureauEmploye();
					break;
				case 3:
					afficherTout();
					break;
			}

		} while (choix >= 1 && choix <= 3);

		flexo.changerPhase();
		System.out.println();
		System.out.println();

		// Phase 2
		System.out.println("Phase 2 (jour meme)");
		System.out.println("-------");
		choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> attribuer automatiquement un bureau");
			System.out.println("2 -> retrouver le bureau d'un employe");
			System.out.println("3 -> afficher tout");
			System.out.println("autre -> quitter");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					reserverPhase2();
					break;
				case 2:
					retrouverBureauEmploye();
					break;
				case 3:
					afficherTout();
					break;
			}

		} while (choix >= 1 && choix <= 3);

		System.out.println("Fin de la journee!");
	}

	private static void reserverPhase1() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom de l'employe : ");
		String nom = scanner.nextLine();

		System.out.print("Entrez le numero du bureau : ");
		int numero = scanner.nextInt();
		scanner.nextLine();

		if(flexo.reserverLaVeille(nom,numero)){
			System.out.println("La reservation a bien ete faite");
		}else{
			System.out.println("La reservation a echoue");
		}

	}

	private static void retrouverBureauEmploye() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom de l'employe : ");
		String nom = scanner.nextLine();
		int numero = flexo.retrouverBureauEmploye(nom);
		if(numero==-1) {
			System.out.println("L'employe n'existe pas ou n'a pas de bureau");
		}else {
			System.out.println("numero : "+numero);
		}

	}

	private static void afficherTout() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(flexo.toString());
	}

	private static void reserverPhase2() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le nom de l'employe : ");
		String nom = scanner.nextLine();
		int numero = flexo.attribuerAutomatiquementBureau(nom);
		if(numero==-1) {
			System.out.println("L'attribution a echoue");
		}else {
			System.out.println("numero : "+numero);
		}
	}

}

