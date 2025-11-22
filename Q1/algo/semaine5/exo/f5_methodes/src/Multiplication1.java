public class Multiplication1 {
    
/*
Cette classe propose 5 multiplications de 2 nombres entiers.
La valeur minimale des 2 nombres à multiplier est 0. 
C'est l'utilisateur qui choisit la valeur maximale de ces 2 nombres. Cette valeur maximale sera la meme pour toutes les multiplications.
Pour chaque multiplication, l'utilisateur n'a droit qu'à un essai. Si la reponse entree au clavier n'est pas bonne, il faut afficher la bonne reponse. 
A la fin, le programme affiche le nombre de multiplications reussies.
*/

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Vous allez faire 5 multiplications de 2 nombres entiers.");
        System.out.println("Pour chaque multiplication, vous n'avez droit qu'a 1 essai.");
        System.out.println("La valeur minimale des 2 nombres a multiplier est 0.");
        System.out.println("C'est vous qui choisissez la valeur maximale de ces 2 nombres.");
        System.out.println("Cette valeur maximale sera la meme pour toutes les multiplications.");
        System.out.println("A la fin, vous recevrez vos points");

        //TODO

        //contient une repetitive dans laquelle se trouve l'appel
        //de la methode faireUneMultiplication()


    }

    /**
     * propose une multiplication de 2 nombres entiers
     * la valeur minimale des 2 nombres a multiplier est 0.
     * la valeur maximale de ces 2 nombres est donnee en parametre
     * l'utilisateur a droit a 1 essai
     *
     * @param valeurMaximale la valeur maximale des 2 nombres a multiplier
     * @return 1 si l'utilisateur a reussi la multiplication, 0 sinon
     */

    public static int faireUneMultiplication(int valeurMaximale) {
        //TODO
        return 0;

        //utilisez la methode unEntierAuHasardEntre() de la classe Utilitaires

    }

}