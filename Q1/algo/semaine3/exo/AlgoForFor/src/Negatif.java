import java.util.Scanner;

public class Negatif {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // A completer par l(es) instructions necessaire(s) avant de commencer la boucle
        int compteur =  0;
        for (int i = 1; i <= 10 ; i++) {
            System.out.print("Entrez l'entier n�"+i+" : ");
            int entier = scanner.nextInt();
                 if (entier < 0){
                     compteur++;
           }

            // A completer par l(es) instructions necessaire(s) a chaque passage dans la boucle

        }//fin for
        System.out.println(compteur);
        // A completer par l(es) instructions necessaire(s) apres la boucle
    }
}
