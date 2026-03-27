public class TestPatrouille {

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu       la valeur qu'on s'attendait a recevoir
     * @param recu          la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println(messageErreur + " attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur + " attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        System.out.println();
        System.out.println("Les tests suivent un scenario :");
        System.out.println();
        System.out.println("Appel du constructeur avec sam comme CP : ");
        try {
            Patrouille patrouille = new Patrouille("castors", "sam");
            assertEquals("Test ko : nombre scouts ko : ", 1, patrouille.getNombreScouts());
            assertEquals("Test ko : contenu ko : ", "[sam]", patrouille.toString());
            System.out.print("Voici la patrouille obtenue : ");
            System.out.println(patrouille);

            System.out.println();
            System.out.println("ajout de tom : ");
            try {
                patrouille.ajouterScout("tom");
                assertEquals("Test ko : nombre scouts ko : ", 2, patrouille.getNombreScouts());
                assertEquals("Test ko : contenu ko :", "[sam, tom]", patrouille.toString());
            } catch (Exception ex) {
                System.out.println("Test ko, il y a eu une exception inattendue : ");
                ex.printStackTrace();
                System.exit(0);
            }
            System.out.print("Voici la patrouille obtenue : ");
            System.out.println(patrouille.toString());

            System.out.println();
            System.out.println("ajout de leo : ");
            try {
                patrouille.ajouterScout("leo");
                assertEquals("Test ko : nombre scouts ko : ", 3, patrouille.getNombreScouts());
                assertEquals("Test ko : contenu ko :", "[sam, leo, tom]", patrouille.toString());
            } catch (Exception ex) {
                System.out.println("Test ko, il y a eu une exception inattendue : ");
                ex.printStackTrace();
                System.exit(0);
            }
            System.out.print("Voici la patrouille obtenue : ");
            System.out.println(patrouille.toString());

            System.out.println();
            System.out.println("ajout de bob :");
            try {
                patrouille.ajouterScout("bob");
                assertEquals("Test ko : nombre scouts ko : ", 4, patrouille.getNombreScouts());
                assertEquals("Test ko : contenu ko :", "[sam, bob, leo, tom]", patrouille.toString());
            } catch (Exception ex) {
                System.out.println("Test ko, il y a eu une exception inattendue : ");
                ex.printStackTrace();
                System.exit(0);
            }
            System.out.print("Voici la patrouille obtenue : ");
            System.out.println(patrouille);

            System.out.println();
            System.out.println("Tous les tests proposes ont reussi.");
            System.out.println("Fin du scenario");
        } catch (Exception ex) {
            System.out.println("Test ko, il y a eu une exception inattendue : ");
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
