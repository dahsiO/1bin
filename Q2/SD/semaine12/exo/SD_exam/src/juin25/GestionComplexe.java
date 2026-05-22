import java.util.Scanner;

public class GestionComplexe {

    private static Scanner scanner = new Scanner(System.in);
    //private static MonScanner scanner = new MonScanner("inputComplexe.txt");

    private static Complexe complexe;

    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("Gestion d'un complexe de studios d'enregistrement");
        System.out.println("*************************************************");
        System.out.println();
        System.out.print("Entrez le nombre de studios : ");
        int nombreStudios = scanner.nextInt();
        complexe = new Complexe(nombreStudios);
        int choix;
        do {
            System.out.println();
            System.out.println("Menu :");
            System.out.println("1 -> attribuer un studio");
            System.out.println("2 -> lister les studios d'un producteur de musique");
            System.out.println("3 -> liberer un studio");
            System.out.println("4 -> afficher tout (debug)");
            System.out.println("5 -> quitter");
            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    attribuerUnStudio();
                    break;
                case 2:
                    listerLesStudios();
                    break;
                case 3:
                    libererUnStudio();
                    break;
                case 4:
                    System.out.println(complexe.toString());
            }
        } while (choix != 5);

        System.out.println("Fin");
    }

    private static void attribuerUnStudio() {
        System.out.println();
        System.out.println("Il reste " + complexe.nombreStudiosLibres() + " studio(s) libre(s)");
        System.out.print("Entrez le numero du producteur de musique : ");
        int numeroProducteur = scanner.nextInt();
        ProducteurMusique producteurMusique = complexe.getProducteurMusique(numeroProducteur);
        String nomProducteur;
        if (producteurMusique == null) {
            System.out.print("Entrez le nom du producteur : ");
            nomProducteur = scanner.next();
            scanner.nextLine();
        } else {
            nomProducteur = producteurMusique.getNom();
        }
        int numeroStudio = complexe.attribuerStudio(numeroProducteur, nomProducteur);
        System.out.println("Le numero du studio attribue : " + numeroStudio);
    }


    private static void listerLesStudios() {
        System.out.print("Entrez le numero du producteur de musique : ");
        int numeroProducteur = scanner.nextInt();
        ProducteurMusique producteurMusique = complexe.getProducteurMusique(numeroProducteur);
        if (producteurMusique == null) {
            System.out.println("Attention, ce producteur n'est pas present dans le complexe !");
        } else {
            System.out.print("Voici le(s) numero(s) du (des) studio(s) qu'il occupe : ");
            System.out.println(producteurMusique.lesStudios());
        }
    }


    private static void libererUnStudio() {
        System.out.print("Entrez le numero du studio : ");
        int numeroStudio = scanner.nextInt();
        try {
            ProducteurMusique producteurMusique = complexe.libererStudio(numeroStudio);
            if (producteurMusique == null) {
                System.out.println("Le studio n'a pas pu etre libere, car il n'etait pas occupe !");
            } else {
                if (complexe.getProducteurMusique(producteurMusique.getNumeroProducteur()) == null) {
                    System.out.println("Le producteur de musique " + producteurMusique.getNom() + " ne fait plus partie des producteurs presents");
                } else {
                    System.out.println("Le producteur de musique " + producteurMusique.getNom() + " fait toujours partie des producteurs presents");
                    System.out.println("Voici le(s) studio(s) qu'il occupe :" + producteurMusique.lesStudios());
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Aucun studio ne porte ce numero !");
        }
    }


}
