import java.util.Scanner;

public class TestListeAoutImplV1 {

    private static Scanner scanner = new Scanner(System.in);


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

                System.out.println(messageErreur + "\n --> attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {

            System.out.println(messageErreur + "\n --> attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }

    /**
     * Cette methode verifie qu'un resultat obtenu est bien un des 2 resultats attendus.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu1      une valeur qu'on s'attendait a recevoir
     * @param attendu2      une autre valeur qu'on s'attendait a recevoir
     * @param recu          la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu1, Object attendu2, Object recu) {
        if (attendu1 == null || attendu2 == null) {
            if (recu != null) {

                System.out.println(messageErreur + "\n --> attendu=" + attendu1 + " ou " + attendu2 + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu1.equals(recu) && !attendu2.equals(recu)) {

            System.out.println(messageErreur + "\n --> attendu=" + attendu1 + " ou " + attendu2 + " recu=" + recu);
            System.exit(0);
        }
    }


    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("*********************************************");
        System.out.println("Programme Test pour la classe ListeAoutImplV1");
        System.out.println("*********************************************");
        int choix = 0;
        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println(("----"));
            System.out.println("1 -> Tester la methode contient()");
            System.out.println("2 -> Tester la methode donnerNieme()");
            System.out.println("3 -> Tester la methode supprimerDernier()");

            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testContient();
                    break;
                case 2:
                    testDonnerNieme();
                    break;
                case 3:
                    testSupprimerDernier();
                    break;
            }
        } while (choix >= 1 && choix <= 3);
    }

    private static void testContient() {
        int numTest=0;
        Character[] tableTestee;
        ListeAoutImplV1<Character> liste;

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'b', 'j'};
        liste = new ListeAoutImplV1<>(tableTestee);
        String avant = liste.toString();
        System.out.println("liste : b j");
        System.out.println("contient('b')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",true, liste.contient('b'));
            assertEquals("Test"+numTest+" ko contenu arrayList modifie",avant,liste.toString());
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'b', 'j'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : b j");
        System.out.println("contient('j')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",true, liste.contient('j'));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'b', 'j'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : b j");
        System.out.println("contient('x')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",false, liste.contient('x'));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'a', 'h', 'j', 'd', 'e'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : a h j d e");
        System.out.println("contient('d')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",true, liste.contient('e'));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'a', 'h', 'j', 'd', 'e'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : a h j d e");
        System.out.println("contient('f')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",false, liste.contient('f'));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : liste vide");
        System.out.println("contient('a')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",false, liste.contient('a'));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
    }

    private static void testDonnerNieme() {
        int numTest=0;
        Character[] tableTestee;
        ListeAoutImplV1<Character> liste;

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'j', 'd'};
        liste = new ListeAoutImplV1<>(tableTestee);
        String avant = liste.toString();
        System.out.println("liste : j d");

        System.out.println("donnerNieme(1)");
        try {
            assertEquals("Test"+numTest+" ko caractere renvoye ko :",'j', liste.donnerNieme(1));
            assertEquals("Test"+numTest+" ko contenu arrayList modifie",avant, liste.toString());
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'j', 'd'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : j d");
        System.out.println("donnerNieme(2)");
        try {
            assertEquals("Test"+numTest+" ko caractere renvoye ko :",'d', liste.donnerNieme(2));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");


        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'a', 'd', 'c', 'b'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : a d c b");
        System.out.println("donnerNieme(4)");
        try {
            assertEquals("Test"+numTest+" ko caractere renvoye ko :",'b', liste.donnerNieme(4));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'a', 'e', 'k', 'd', 'j'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : a e k d j");
        System.out.println("donnerNieme(3)");
        try {
            assertEquals("Test"+numTest+" ko caractere renvoye ko :",'k', liste.donnerNieme(3));
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
    }

    private static void testSupprimerDernier() {
        int numTest=0;
        Character[] tableTestee;
        ListeAoutImplV1<Character> liste;
        Character[] tableAttendue;
        ListeAoutImplV1<Character> listeAttendue;

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'k', 'd'};
        liste = new ListeAoutImplV1<>(tableTestee);
        tableAttendue = new Character[]{'k'};
        listeAttendue = new ListeAoutImplV1<>(tableAttendue);
        System.out.println("liste : k d");
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'd', car);
            assertEquals("Test"+numTest+" ko  contenu table ko",  listeAttendue.toString(),liste.toString());
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'a', 'd', 'b', 'c'};
        liste = new ListeAoutImplV1<>(tableTestee);
        System.out.println("liste : a d b c");
        tableAttendue = new Character[]{'a', 'd', 'b'};
        listeAttendue = new ListeAoutImplV1<>(tableAttendue);
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'c', car);
            assertEquals("Test"+numTest+" ko  contenu table ko",  listeAttendue.toString(),liste.toString());
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'a'};
        liste = new ListeAoutImplV1<>(tableTestee);
        tableAttendue = new Character[]{};
        listeAttendue = new ListeAoutImplV1<>(tableAttendue);
        System.out.println("liste : a");
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'a', car);
            assertEquals("Test"+numTest+" ko  contenu table ko",  listeAttendue.toString(),liste.toString());
        } catch (Exception e) {
            System.out.println("Test"+numTest+" ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{};
        liste = new ListeAoutImplV1<>(tableTestee);
        tableAttendue = new Character[]{};
        listeAttendue = new ListeAoutImplV1<>(tableAttendue);
        System.out.println("liste : liste vide");
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", null, car);
            assertEquals("Test"+numTest+" ko  contenu table ko",  listeAttendue.toString(),liste.toString());
        } catch (Exception e) {
            System.out.println("Test Liste vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
    }

}
