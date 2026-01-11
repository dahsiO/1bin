public class TestLudotheque {
    public static void main(String[] args) {
        System.out.println("Étape 1 : création d’instances");
        JeuDeSociete jeuDeSociete = new JeuDeSociete("Dixit",4,"voir boite",true);
        System.out.println(jeuDeSociete);
        Affilie affilie = new Affilie("Gregory","Seront");
        System.out.println(affilie);
        System.out.println("Étape 2 : ajout d’une location à l’affilier");

        try {
            affilie.terminerLocationEnCours();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        affilie.commencerLocation();
        JeuVideo jeuVideo = new JeuVideo("DOOM","PC",16);
        Location location = affilie.getLocationEnCours();
        location.ajouter(jeuVideo);
        location.ajouter(jeuDeSociete);
        System.out.println(affilie);



        jeuDeSociete.setDisponible(true);
        System.out.println("Étape 3 : clôture de la location en cours et nouvelle location\n");
        affilie.terminerLocationEnCours();
        JeuVideo jeuVideo1 = new JeuVideo("Mario-kart",2,"Switch",9);
        affilie.commencerLocation();
        // IMPORTANT : Récupérer la NOUVELLE location en cours
        location = affilie.getLocationEnCours();
        location.ajouter(jeuDeSociete);
        location.ajouter(jeuVideo1);

        // Afficher le nombre de locations et l'état de l'affilié
        System.out.println(affilie.nombreDeLocation());
        System.out.println(affilie);
    }
}
