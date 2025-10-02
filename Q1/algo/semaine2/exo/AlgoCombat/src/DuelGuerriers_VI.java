public class DuelGuerriers_VI {

    public static void main(String[] args) {

        FenetreCombatGuerriers jeu = new FenetreCombatGuerriers();

        // CogneDur
        jeu.afficherInformation("CogneDur lance le dé pour ses PV...");
        int pointsDeVieCogneDur = jeu.lancerDe();
        jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);

        // FrappeFort
        jeu.afficherInformation("FrappeFort lance le dé pour ses PV...");
        int pointsDeVieFrappeFort = jeu.lancerDe();
        jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);



        // Début combat
        jeu.afficherInformation("Début du combat : CogneDur attaque en premier !");
        jeu.afficherEpee(1);
        jeu.afficherBouclier(2);
        jeu.afficherInformation("lance le pour connaitre le nombre de degat qui vas lui infliger ");
        // Dégâts

        int degatCogneDur = jeu.lancerDe();

        // CogneDur attaque
        jeu.afficherInformation("CogneDur attaque et inflige " + degatCogneDur + " dégâts !");
        pointsDeVieFrappeFort -= degatCogneDur;
        jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);

        if (pointsDeVieFrappeFort <= 0) {
            jeu.afficherInformation("FrappeFort est mort ! CogneDur a gagné !");
            jeu.afficherCoupeOr(1);
            jeu.afficherCroix(2);

        } else {
            // FrappeFort attaque
            jeu.afficherEpee(2);
            jeu.afficherBouclier(1);

            //degat
            jeu.afficherInformation("lance le de pour connaitre le nombre dee degat qui vas lui mettre ");
            int degatFrappeFort = jeu.lancerDe();

            jeu.afficherInformation("FrappeFort attaque et inflige " + degatFrappeFort + " dégâts !");
            pointsDeVieCogneDur -= degatFrappeFort;
            jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);

            if (pointsDeVieCogneDur <= 0) {
                jeu.afficherInformation("CogneDur est mort ! FrappeFort a gagné !");
                jeu.afficherCoupeOr(2);
                jeu.afficherCroix(1);

            } else {
                // Match nul : personne n’est mort après un échange
                jeu.afficherInformation("Les deux guerriers tiennent encore debout, match nul !");
                jeu.afficherCoupeArgent(1);
                jeu.afficherCoupeArgent(2);
            }
        }
    }
}
