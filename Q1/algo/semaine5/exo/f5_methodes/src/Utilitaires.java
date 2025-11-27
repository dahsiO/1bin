public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }



    /**
     * lit un nombre reel positif ou nul
     * @return un nombre reel positif
     */
    public static double lireReelPositif(){
        double x = scanner.nextDouble();
        while(x < 0){
            System.out.println("Attention le reel doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }


    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     * @param min le plus petit reel accepte
     * @param max le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max ){


        double x = scanner.nextDouble();
        while (x < min || x > max) {
            System.out.println("Attention le réel doit être compris entre " + min + " et " + max);
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
        // TODO

        // pour que la classe compile, la methode doit renvoyer un entier
        // commencez par supprimer l'instruction
        // return 0;

        //il faut placer une boucle dans cette methode !
        //procedez comme pour la methode lireReelEntierPositif() donnee ci-dessus
    }


    /**
     * lit le caractere o ou n
     * @return le caractere o un n
     */
    public static char lireOouN(){


        char c = scanner.next().toLowerCase().charAt(0);
        while (c != 'o' && c != 'n') {
            System.out.println("Veuillez entrer 'o' pour oui ou 'n' pour non.");
            System.out.print("Recommencez : ");
            c = scanner.next().toLowerCase().charAt(0);
        }
        return c;

        // TODO

        // pour que la classe compile, la methode doit renvoyer un caractere
        // commencez par supprimer l'instruction
        // return 'p';

        //il faut placer une boucle dans cette methode !
    }

    /**
     *
     * Lire un entier.
     * Vérifier qu’il n’est pas nul.
     * Redemander tant que la valeur est 0.
     * @return un entier différent de 0
     * */

    public static double lireEntierNonNul(){

        int x = scanner.nextInt();
        while (x == 0) {
            System.out.println("Attention, l'entier ne peut pas être nul !");
            System.out.print("Recommencez : ");
            x = scanner.nextInt();
        }
        return x;
    }

    /**
     * Retourne le maximum de trois entiers
     * @param entier1 premier entier
     * @param entier2 deuxième entier
     * @param entier3 troisième entier
     * @return le plus grand des trois entiers
     */
    public static int max3(int entier1, int entier2, int entier3) {
        int max = entier1;
        if (entier2 > max) max = entier2;
        if (entier3 > max) max = entier3;
        return max;
    }

    /**
     * Simule le lancer d'un dé à 6 faces
     * @return un entier compris entre 1 et 6
     */
    public static int lancerDe() {
        return unEntierAuHasardEntre(1, 6);
    }

}
