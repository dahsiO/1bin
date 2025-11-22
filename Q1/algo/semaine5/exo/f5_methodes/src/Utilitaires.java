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

        return 0;
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

        return 'p';
        // TODO

        // pour que la classe compile, la methode doit renvoyer un caractere
        // commencez par supprimer l'instruction
        // return 'p';

        //il faut placer une boucle dans cette methode !
    }


}
