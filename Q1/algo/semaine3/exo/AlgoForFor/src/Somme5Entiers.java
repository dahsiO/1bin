import java.util.Scanner;

public class Somme5Entiers {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // A completer par l(es) instructions necessaire(s) avant de commencer la boucle

        int somme = 0;
        for (int i = 1; i <= 5 ; i++) {
            System.out.print("Entrez l'entier n�"+i+" : ");
            int entier = scanner.nextInt();
                somme+= entier;


            // A completer par l(es) instructions necessaire(s) a chaque passage dans la boucle
            System.out.println(somme);
        }//fin for

        // A completer par l(es) instructions necessaire(s) apres la boucle
    }
}
