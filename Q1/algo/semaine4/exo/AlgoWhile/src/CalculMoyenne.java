public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        // la chaine de caracteres se met entre""
        // Initialisation des variables
        double somme = 0;        // pour additionner toutes les cotes
        int compteur = 0;        // pour compter combien de cotes ont été entrées
        char reponse = 'Y';      // pour contrôler la boucle

         /*
          Pour lire un caractere :
          (next() --> lecture d'une chaine de caracteres)
          (charAt(0) --> 1er caractere de la chaine de caracteres
          */

        // Tant que l'utilisateur veut encoder une nouvelle cote
        while (reponse == 'Y' || reponse == 'y') {
            System.out.print("Entrez une cote : ");
            double cote = scanner.nextDouble(); // lire la cote
            somme += cote;                      // ajouter à la somme
            compteur++;                         // incrémenter le compteur


            // Demande à l'utilisateur s'il veut continuer
            System.out.print("Voulez-vous entrer une autre cote ? (Y/N) : ");
            reponse = scanner.next().charAt(0); // lire le premier caractère



            // Quand la boucle s'arrête, on calcule et affiche la moyenne
            if (compteur > 0) {
                double moyenne = somme / compteur;
                System.out.println("La moyenne est : " + moyenne);
            } else {
                System.out.println("Aucune cote n’a été encodée.");
            }

            System.out.println("Fin du programme.");
        }
    }
}


/*

* by dahsi oussama
*
* */