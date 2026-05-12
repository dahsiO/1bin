package aout25.aout2025.AF;

import java.util.HashSet;

public class GestionBrocante {

    //private static Scanner scanner = new Scanner(System.in);
    private static MonScanner scanner = new MonScanner("inputBrocante.txt");

    private static Brocante brocante;

    public static void main(String[] args) {

        System.out.println("**********************");
        System.out.println("Gestion d'une brocante");
        System.out.println("**********************");
        System.out.println();

        // configuration de la brocante
        System.out.println("Configuration de la brocante");
        System.out.println("----------------------------");
        System.out.print("Entrez le nombre d'emplacements : ");
        int nombreEmplacements = scanner.nextInt();
        System.out.print("Entrez le nombre de riverains : ");
        int nombreRiverains = scanner.nextInt();
        scanner.nextLine();
        HashSet<String> ensembleRiverains = new HashSet<>();
        for (int i = 0; i < nombreRiverains; i++) {
            System.out.print("Entrez le nom du riverain " + (i + 1) + " : ");
            String nomRiv = scanner.nextLine();
            ensembleRiverains.add(nomRiv);
        }
        brocante = new Brocante(nombreEmplacements, ensembleRiverains);
        System.out.println();

        // Phase 1
        System.out.println("Phase 1");
        System.out.println("-------");
        int choix;
        do {
            System.out.println();
            System.out.println("Menu :");
            System.out.println("1 -> reserver un emplacement");
            System.out.println("2 -> afficher la brocante");
            System.out.println("3 -> passer en phase 2");
            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    reserverPhase1();
                    break;
                case 2:
                    afficherToutPhase1();
                    break;
            }

        } while (choix >= 1 && choix <= 2);

        brocante.changerPhase();
        System.out.println();
        System.out.println();

        // Phase 2
        System.out.println("Phase 2");
        System.out.println("-------");
        do {
            System.out.println();
            System.out.println("Menu :");
            System.out.println("1 -> reserver un emplacement");
            System.out.println("2 -> afficher la brocante");
            System.out.println("3 -> quitter");
            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    reserverPhase2();
                    break;
                case 2:
                    afficherToutPhase2();
                    break;
            }

        } while (choix >= 1 && choix <= 2);

        System.out.println("Fin de la brocante!");
    }

    private static void reserverPhase1() {
        System.out.print("Entrez le nom du demandeur : ");
        String demandeur = scanner.nextLine();
        try {
            System.out.print("Entrez le numero de l'emplacement souhaite : ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            boolean res = brocante.reserverPhase1(demandeur, numero);
            if (res) {
                System.out.println("La reservation a ete effectuee avec succes.");
            } else {
                System.out.println("La reservation a echoue.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Aucun emplacement ne porte ce numero !");
        }
    }

    private static void reserverPhase2() {
        System.out.print("Entrez le nom du demandeur : ");
        String demandeur = scanner.nextLine();

        int numeroEmplacement = brocante.reserverPhase2(demandeur);

        if (numeroEmplacement == -1) {
            System.out.println("La reservation a echoue");
        } else {
            System.out.println("L'emplacement numero " + numeroEmplacement + " a ete attribue a " + demandeur);
        }
    }

    private static void afficherToutPhase1() {
        System.out.println(brocante.donnerTableEmplacements());
        System.out.println();
        System.out.println(brocante.donnerMapRiverains());
    }

    private static void afficherToutPhase2() {
        System.out.println(brocante.donnerTableEmplacements());
        System.out.println();
        System.out.println(brocante.donnerMapRiverains());
        System.out.println();
        System.out.println(brocante.donnerFileEmplacementsLibres());
    }

}
