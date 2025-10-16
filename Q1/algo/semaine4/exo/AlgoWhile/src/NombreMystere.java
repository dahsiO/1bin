import java.util.Scanner;

public class NombreMystere {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Jeu du Nombre Mystère ===");
        System.out.println("L'ordinateur a choisi un nombre entre 0 et 100. À vous de le deviner !");

        // L'ordinateur choisit un nombre au hasard
        int nombreMystere = unEntierAuHasardEntre(0, 100);

        int tentative;      // la proposition de l'utilisateur
        int essais = 0;     // compteur d'essais

        // Boucle principale : on continue tant que ce n’est pas trouvé
        do {
            System.out.print("Votre proposition : ");
            tentative = scanner.nextInt();
            essais++;

            if (tentative < nombreMystere) {
                System.out.println("C'est plus grand !");
            } else if (tentative > nombreMystere) {
                System.out.println("C'est plus petit !");
            }

        } while (tentative != nombreMystere);

        // Si on sort de la boucle, c’est que la bonne réponse a été trouvée
        System.out.println("Bravo 🎉 ! Vous avez trouvé le nombre mystère (" + nombreMystere + ") en " + essais + " essais !");
    }

    // Fonction utilitaire (à ne pas modifier)
    public static int unEntierAuHasardEntre(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
