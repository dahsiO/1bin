
public class MultiplicationAuFinish {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tant que tu n'as pas trouve la bonne reponse, tu dois la recommencer! ");

		int premierNombre = unEntierAuHasardEntre(0, 10);
		int secondNombre = unEntierAuHasardEntre(0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		// A COMPLETER

// Calcul du résultat attendu
		int resultatCorrect = premierNombre * secondNombre;

		// Affiche la question
		System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int reponse = scanner.nextInt();  // première réponse de l'utilisateur

		// Tant que la réponse est fausse, on recommence
		while (reponse != resultatCorrect) {
			System.out.println("C'est faux, recommence !");
			System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			reponse = scanner.nextInt();  // nouvelle tentative
		}

		// Si on sort de la boucle, c’est que la réponse est correcte
		System.out.println("Bravo ! La bonne réponse était bien " + resultatCorrect + " !");
	}


	// A NE PAS MODIFIER
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
	}
}
