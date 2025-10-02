import java.util.Scanner;

public class NegatifetPositif {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // A completer par l(es) instructions necessaire(s) avant de commencer la boucle
        int compteurPositif =  0;
        int compteurNegatif = 0;
        for (int i = 1; i <= 10 ; i++) {
            System.out.print("Entrez l'entier n�"+i+" : ");
            int entier = scanner.nextInt();
            if (entier < 0){
                compteurNegatif++;
            }else compteurPositif++;

            // A completer par l(es) instructions necessaire(s) a chaque passage dans la boucle

        }//fin for
        System.out.println("compteur positif "+ compteurPositif);
        System.out.println("compteur negatif "+ compteurNegatif);
        // A completer par l(es) instructions necessaire(s) apres la boucle
    }
}
