package juin24;

import aout25.aout2025.AF.MonScanner;

import java.util.Arrays;

public class GestionCoworking {

	//private static Scanner scanner = new Scanner(System.in);
	private static MonScanner scanner = new MonScanner("inputCoworking.txt");
	private static Coworking cow;

	public static void main(String[] args) {

		System.out.println("********************************");
		System.out.println("Gestion d'un espace de coworking");
		System.out.println("********************************");
		System.out.println();

		// configuration
		System.out.println("Configuration");
		System.out.println("----------------------------");
		System.out.print("Entrez le nombre de bureaux : ");
		int nombreBureaux = scanner.nextInt();
		System.out.print("Entrez le nombre de societes : ");
		int nombreSocietes = scanner.nextInt();
		scanner.nextLine();
		String[] tableSocietes = new String[nombreSocietes];
		for (int i = 0; i < tableSocietes.length; i++) {
			System.out.print("Entrez le nom de la societe " + (i + 1) + " : ");
			String nomRiv  = scanner.nextLine();
			tableSocietes[i] = nomRiv;
		}
		cow = new Coworking(nombreBureaux, tableSocietes);
		System.out.println();

		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> attribuer un bureau a une societe");
			System.out.println("2 -> liberer un bureau");
			System.out.println("3 -> afficher les bureaux d'une societe");
			System.out.println("4 -> afficher tout");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			scanner.nextLine();
			switch (choix) {
				case 1:
					attribuer();
					break;
				case 2:
					liberer();
					break;
				case 3:
					afficherBureaux();
					break;
				case 4:
					afficherTout();
					break;
			}

		} while (choix >= 1 && choix <= 4);

		System.out.println("Fin !");
	}



	private static void attribuer() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!

		System.out.print("Entrez le nom de la societe: ");
		String nom = scanner.nextLine();

		System.out.print("Entrez le numero du bureau : ");
		int numero = scanner.nextInt();
		scanner.nextLine();

		if(cow.attribuer(nom,numero)){
			System.out.println("L'attribution a bien ete faite");
		}else{
			System.out.println("L'attribution a echoue");
		}


	}

	private static void liberer() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!

		System.out.print("Entrez le numero du bureau : ");
		int numero = scanner.nextInt();
		scanner.nextLine();

		if(cow.liberer(numero)){
			System.out.println("La liberation a bien ete faite");
		}else{
			System.out.println("La liberation a echoue");
		}


	}

	private static void afficherBureaux() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!

		System.out.print("Entrez le nom de la societe: ");
		String nom = scanner.nextLine();

		int[] tableOccupations = cow.occupationsSociete(nom);
		System.out.println("Voici ses bureaux : ");
		System.out.println(Arrays.toString(tableOccupations));
	}

	private static void afficherTout() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!

		System.out.println(cow.toString()) ;
	}
}
