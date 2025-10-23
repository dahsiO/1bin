import java.util.Scanner;

public class NombreMystereInverse {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("=== Jeu du Nombre Mystère Inverse ===");
        System.out.println("Choisissez un nombre entre 0 et 100 dans votre tête...");
        System.out.println("L'ordinateur va essayer de le deviner !");
        System.out.println("Répondez par : '+' (c’est plus grand), '-' (c’est plus petit), '=' (c’est le bon).");

        int min = 0;
        int max = 100;
        int essais = 0;
        char reponse;
        int proposition;

        do {
            // L'ordinateur propose le milieu de l'intervalle
            proposition = (min + max) / 2;
            essais++;

            System.out.print("Je propose : " + proposition + " → Votre réponse (+, -, =) : ");
            reponse = scanner.next().charAt(0);

            if (reponse == '+') {
                min = proposition + 1; // le nombre à deviner est plus grand
            } else if (reponse == '-') {
                max = proposition - 1; // le nombre à deviner est plus petit
            }

        } while (reponse != '=');

        System.out.println("Gagné ! J’ai trouvé le nombre mystère en " + essais + " essais 😎");
    }
}
