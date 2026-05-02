import java.util.Scanner;

public class GestionRallyeAutomobile {

    private static final Scanner sc = new Scanner(System.in);

    // -------------------------------------------------------
    // Point d'entrée
    // -------------------------------------------------------
    public static void main(String[] args) {

        System.out.println("*******************************************");
        System.out.println("Programme de gestion d'un Rallye Automobile");
        System.out.println("*******************************************");

        // Saisie des pilotes
        System.out.print("Entrez le nombre de pilotes : ");
        int nbPilotes = Integer.parseInt(sc.nextLine().trim());

        String[] pilotes = new String[nbPilotes];
        for (int i = 0; i < nbPilotes; i++) {
            System.out.print("Entrez le nom du pilote " + (i + 1) + " : ");
            pilotes[i] = sc.nextLine().trim();
        }

        RallyeAutomobile rallye = new RallyeAutomobile(pilotes);

        // Boucle principale
        while (!rallye.estTerminee()) {
            afficherMenu();
            System.out.print("Votre choix : ");
            int choix;
            try {
                choix = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Choix invalide.");
                continue;
            }

            switch (choix) {

                case 1: // Afficher toute la course
                    System.out.println(rallye.afficherCourse());
                    break;

                case 2: // Afficher le pilote en tête
                    String tete = rallye.donnerPiloteEnTete();
                    System.out.println(tete != null ? "Pilote en tête : " + tete : "Aucun pilote en course.");
                    break;

                case 3: // Enregistrer un dépassement
                    System.out.print("Entrez le pilote qui dépasse : ");
                    String depasse = sc.nextLine().trim();
                    if (rallye.enregistrerDepassement(depasse)) {
                        System.out.println(depasse + " a effectué un dépassement !");
                    } else {
                        System.out.println("Dépassement impossible (pilote absent ou déjà en tête).");
                    }
                    break;

                case 4: // Retirer un pilote de la course
                    System.out.print("Entrez le pilote à supprimer : ");
                    String aSupprimer = sc.nextLine().trim();
                    if (rallye.supprimer(aSupprimer)) {
                        System.out.println(aSupprimer + " a été retiré de la course.");
                    } else {
                        System.out.println("Pilote introuvable en course.");
                    }
                    break;

                case 5: // Donner la position d'un pilote
                    System.out.print("Entrez le nom du pilote : ");
                    String pilote = sc.nextLine().trim();
                    int pos = rallye.donnerPosition(pilote);
                    if (pos != -1) {
                        System.out.println(pilote + " est en position " + pos + ".");
                    } else {
                        System.out.println(pilote + " n'est pas en course.");
                    }
                    break;

                case 6: // Faire franchir la ligne d'arrivée au pilote de tête
                    String arrivant = rallye.franchirligneDarrivee();
                    if (arrivant != null) {
                        System.out.println(arrivant + " a franchi la ligne d'arrivée !");
                    } else {
                        System.out.println("Aucun pilote en course.");
                    }
                    break;

                case 7: // Remettre un pilote dans la course
                    System.out.print("Entrez le pilote à remettre en course : ");
                    String aRemettre = sc.nextLine().trim();
                    System.out.print("Entrez le pilote après lequel l'insérer : ");
                    String apres = sc.nextLine().trim();
                    if (rallye.remettreEnCourse(aRemettre, apres)) {
                        System.out.println(aRemettre + " est remis en course après " + apres + ".");
                    } else {
                        System.out.println("Impossible de remettre " + aRemettre + " en course.");
                    }
                    break;

                case 8: // Afficher les pilotes hors course
                    System.out.println("--- Pilotes hors course ---");
                    System.out.println(rallye.afficherHorsCourse());
                    break;

                case 9: // Afficher le classement
                    System.out.println("--- Classement ---");
                    System.out.println(rallye.afficherClassement());
                    break;

                case 10: // Vérifier si un pilote a franchi la ligne d'arrivée
                    System.out.print("Entrez le nom du pilote : ");
                    String aVerifier = sc.nextLine().trim();
                    int rang = rallye.verifierArrivee(aVerifier);
                    if (rang != -1) {
                        System.out.println(aVerifier + " a franchi la ligne d'arrivée (rang " + rang + ").");
                    } else {
                        System.out.println(aVerifier + " n'a pas encore franchi la ligne d'arrivée.");
                    }
                    break;

                default:
                    System.out.println("Choix invalide, entrez un nombre entre 1 et 10.");
            }
            System.out.println();
        }

        System.out.println("=== Course terminée ! ===");
        System.out.println("--- Classement final ---");
        System.out.println(rallye.afficherClassement());
    }

    // -------------------------------------------------------
    // Affichage du menu
    // -------------------------------------------------------
    private static void afficherMenu() {
        System.out.println("1  -> Afficher toute la course");
        System.out.println("2  -> Afficher le pilote en tête");
        System.out.println("3  -> Enregistrer un dépassement");
        System.out.println("4  -> Retirer un pilote de la course");
        System.out.println("5  -> Donner la position d'un pilote");
        System.out.println("6  -> Faire franchir la ligne d'arrivée au pilote de tête");
        System.out.println("7  -> Remettre un pilote dans la course (après un autre)");
        System.out.println("8  -> Afficher les pilotes hors course");
        System.out.println("9  -> Afficher le classement");
        System.out.println("10 -> Vérifier si un pilote a franchi la ligne d'arrivée");
    }
}
