package exoRecapitulatif1;

public class TestLudotheque {
    public static void main(String[] args) {
        System.out.println("etape : 1");
        jeuDeSociete jeuDeSociete = new jeuDeSociete("Dixit",4,
                "Voir boite",true);
         Affilie affilie = new Affilie("Greogrie","seront");
        System.out.println(jeuDeSociete);
        System.out.println(affilie);

        System.out.println("------------------------------------------------------");
        System.out.println("Étape 2 : ajout d'une location à l'affilié");

        // Tenter de terminer la location en cours (qui n'existe pas encore)
        try {
            affilie.termineeLocationEnCours();
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        // Création du jeu vidéo
                jeuVideo jeuVideo = new jeuVideo("DOOM", 1, "PC", 16);

        // Commencer une nouvelle location pour l'affilié
                affilie.commencerLocation();

        // Récupérer la location en cours de l'affilié
                Location locationEnCours = affilie.getLocationEnCours();

        // Ajouter les jeux à la location en cours de l'affilié
                locationEnCours.ajouter(jeuVideo);
                locationEnCours.ajouter(jeuDeSociete);

        // Afficher l'état de l'affilié
                System.out.println(affilie);

                // etape 3
    }
}
