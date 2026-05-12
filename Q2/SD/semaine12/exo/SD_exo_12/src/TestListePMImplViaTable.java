import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestListePMImplViaTable {
    private static Scanner scanner = new Scanner(System.in);

    static Class classe = ListePMImplViaTable.class;
    static Field t;
    static Field taille;

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
        System.out.println("Programme Test pour la classe ListePMViaTable");
        System.out.println("*********************************************");
        int choix = 0;
        t = classe.getDeclaredField("table");
        t.setAccessible(true);
        taille = classe.getDeclaredField("taille");
        taille.setAccessible(true);
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

    private static void testContient() throws IllegalAccessException{
        int numTest=0;
        Character[] tableTestee;
        ListePMImplViaTable<Character> liste;

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'b', 'j', null, null};
        liste = new ListePMImplViaTable<>(tableTestee, 2);
        System.out.println("liste : b j");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("contient('b')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",true, liste.contient('b'));
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko taille (logique) modifiee :", 2, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) modifiee :", 4, table.length);
            assertEquals("Test"+numTest+" ko contenu table modifiee",  "[b, j, null, null]", Arrays.toString((Object[]) t.get(liste)));
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
        tableTestee = new Character[]{'b', 'j', null, null};
        liste = new ListePMImplViaTable<>(tableTestee, 2);
        System.out.println("liste : b j");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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
        tableTestee = new Character[]{'b', 'j', null, null};
        liste = new ListePMImplViaTable<>(tableTestee,2);
        System.out.println("liste : b j");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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
        tableTestee = new Character[]{'a', 'j', 'c', 'd'};
        liste = new ListePMImplViaTable<>(tableTestee);
        System.out.println("liste : a j c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("contient('d')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",true, liste.contient('d'));
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
        tableTestee = new Character[]{'a', 'j', 'c', 'd'};
        liste = new ListePMImplViaTable<>(tableTestee);
        System.out.println("liste : a j c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("contient('e')");
        try {
            assertEquals("Test"+numTest+" ko  boolean renvoye ko :",false, liste.contient('e'));
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
        tableTestee = new Character[]{'a', 'h', 'j', 'd', 'e', null, null, null};
        liste = new ListePMImplViaTable<>(tableTestee,5);
        System.out.println("liste : a h j d e");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("contient('e')");
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
        tableTestee = new Character[]{'a', 'h', 'j', 'd', 'e', null, null, null};
        liste = new ListePMImplViaTable<>(tableTestee,5);
        System.out.println("liste : a h j d e");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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
        tableTestee = new Character[]{null, null, null, null};
        liste = new ListePMImplViaTable<>(tableTestee,0);
        System.out.println("liste : liste vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{};
        liste = new ListePMImplViaTable<>(tableTestee);
        System.out.println("liste : liste vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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

    private static void testDonnerNieme() throws IllegalAccessException{
        int numTest=0;
        Character[] tableTestee;
        ListePMImplViaTable<Character> liste;

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'j', 'd', null, null};
        liste = new ListePMImplViaTable<>(tableTestee,2);
        System.out.println("liste : j d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("donnerNieme(1)");
        try {
            assertEquals("Test"+numTest+" ko caractere renvoye ko :",'j', liste.donnerNieme(1));
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko taille (logique) modifiee :", 2, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) modifiee :", 4, table.length);
            assertEquals("Test"+numTest+" ko contenu table modifiee",  "[j, d, null, null]", Arrays.toString((Object[]) t.get(liste)));
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
        tableTestee = new Character[]{'j', 'd', null, null};
        liste = new ListePMImplViaTable<>(tableTestee,2);
        System.out.println("liste : j d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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
        liste = new ListePMImplViaTable<>(tableTestee);
        System.out.println("liste : a d c b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
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
        tableTestee = new Character[]{'a', 'e', 'k', 'd', 'j', null, null, null};
        liste = new ListePMImplViaTable<>(tableTestee,5);
        t.set(liste, tableTestee);
        System.out.println("liste : a e k d j");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("donnerNieme(5)");
        try {
            assertEquals("Test"+numTest+" ko caractere renvoye ko :",'j', liste.donnerNieme(5));
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

    private static void testSupprimerDernier() throws IllegalAccessException {
        int numTest=0;
        Character[] tableTestee;
        ListePMImplViaTable<Character> liste;

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{'k', 'd', null, null};
        liste = new ListePMImplViaTable<>(tableTestee,2);
        System.out.println("liste : k d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'd', car);
            assertEquals("Test"+numTest+" ko taille (logique) ko :", 1, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) ko :", 4, table.length);
            assertEquals("Test"+numTest+" ko  contenu table ko",  "[k, null, null, null]","[k, d, null, null]", Arrays.toString((Object[]) t.get(liste)));
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
        tableTestee = new Character[]{'a', 'b', null, null};
        liste = new ListePMImplViaTable<>(tableTestee,2);
        System.out.println("liste : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'b', car);
            assertEquals("Test"+numTest+" ko taille (logique) ko :", 1, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) ko :", 4, table.length);
            assertEquals("Test"+numTest+" ko  contenu table ko",  "[a, null, null, null]","[a, b, null, null]", Arrays.toString((Object[]) t.get(liste)));
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
        liste = new ListePMImplViaTable<>(tableTestee);
        System.out.println("liste : a d b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'c', car);
            assertEquals("Test"+numTest+" ko taille (logique) ko :", 3, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) ko :", 4, table.length);
            assertEquals("Test"+numTest+" ko  contenu table ko",  "[a, d, b, c]","[a, d, b, null]", Arrays.toString((Object[]) t.get(liste)));
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
        tableTestee = new Character[]{'a', 'h', 'j', 'd', 'e', null, null, null};
        liste = new ListePMImplViaTable<>(tableTestee,5);
        t.set(liste, tableTestee);
        System.out.println("liste : a h j d e");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", 'e', car);
            assertEquals("Test"+numTest+" ko taille (logique) ko :", 4, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) ko :", 8, table.length);
            assertEquals("Test"+numTest+" ko  contenu table ko",  "[a, h, j, d, null, null, null, null]","[a, h, j, d, e, null, null, null]", Arrays.toString((Object[]) t.get(liste)));
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
        tableTestee = new Character[]{null, null, null, null};
        liste = new ListePMImplViaTable<>(tableTestee,0);
        System.out.println("liste : liste vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", null, car);
            assertEquals("Test"+numTest+" ko taille (logique) ko :", 0, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) ko :", 4, table.length);
            assertEquals("Test"+numTest+" ko  contenu table ko",  "[null, null, null, null]", Arrays.toString((Object[]) t.get(liste)));

        } catch (Exception e) {
            System.out.println("Test Liste vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test"+numTest+" ok");

        numTest++;
        System.out.println();
        System.out.println("Test"+numTest);
        tableTestee = new Character[]{};
        liste = new ListePMImplViaTable<>(tableTestee);
        System.out.println("liste : liste vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("taille : "+taille.getInt(liste));
        System.out.println("supprimerDernier()");
        try {
            Character car = liste.supprimerDernier();
            Object[] table = (Object[]) t.get(liste);
            assertEquals("Test"+numTest+" ko  caractere renvoye ko :", null, car);
            assertEquals("Test"+numTest+" ko taille (logique) ko :", 0, taille.getInt(liste));
            assertEquals("Test"+numTest+" ko taille (physique) ko :", 0, table.length);
            assertEquals("Test"+numTest+" ko  contenu table ko",  "[]", Arrays.toString((Object[]) t.get(liste)));

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
