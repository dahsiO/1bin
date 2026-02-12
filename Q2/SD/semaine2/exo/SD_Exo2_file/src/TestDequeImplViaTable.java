import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestDequeImplViaTable {
    private static Scanner scanner = new Scanner(System.in);

    static Class classe = DequeImplViaTable.class;
    static Field t;
    static Field indicePremier;
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
        System.out.println("***********************************************");
        System.out.println("Programme Test pour la classe DequeImplViaTable");
        System.out.println("***********************************************");
        int choix = 0;
        t = classe.getDeclaredField("table");
        t.setAccessible(true);
        indicePremier = classe.getDeclaredField("indicePremier");
        indicePremier.setAccessible(true);
        taille = classe.getDeclaredField("taille");
        taille.setAccessible(true);

        System.out.println();
        System.out.println("Menu");
        System.out.println(("----"));
        System.out.println("1 -> Tester la methode dernier()");
        System.out.println("2 -> Tester la methode retirerDernier()");
        System.out.println("3 -> Tester la methode ajouterPremier()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testDernier();
                break;
            case 2:
                testRetirerDernier();
                break;
            case 3:
                testAjouterPremier();
                break;

        }
    }

    private static void testDernier() throws IllegalAccessException {
        int numTest = 0;
        Character[] tableTestee;
        DequeImplViaTable<Character> deque;

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', null, null};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 2, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, null, null]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 4);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'd', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 5);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d e");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'e', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 3);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'c', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 4);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'd', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'d', 'e', 'f', 'g', 'h', 'a', 'b', 'c'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 5);
        taille.setInt(deque, 7);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d e f g");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            Character car = deque.dernier();
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'g', car);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 0);
        t.set(deque, tableTestee);
        System.out.println("deque : deque vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("dernier()");
        try {
            deque.dernier();
            System.out.println("Test Deque vide : ko");
            System.out.println("Il fallait une exception de type DequeVideException");
            System.exit(0);

        } catch (DequeVideException e) {

        } catch (Exception e) {
            System.out.println("Test Deque vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            System.out.println("Il fallait une exception de type DequeVideException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");


        System.out.println();
        System.out.println("tous les tests ont reussi");
    }


    private static void testRetirerDernier() throws IllegalAccessException {
        int numTest = 0;
        Character[] tableTestee;
        DequeImplViaTable<Character> deque;

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', null, null};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 1, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, null, null, null]", "[a, b, null, null]", Arrays.toString((Object[]) t.get(deque)));
            if (table[1] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 1, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, null, c, d]", "[a, b, c, d]", Arrays.toString((Object[]) t.get(deque)));
            if (table[1] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 4);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'd', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 3, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, c, d]", "[a, b, c, null]", Arrays.toString((Object[]) t.get(deque)));
            if (table[3] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 5);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d e");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'e', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 4, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 8, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, c, d, e, f, g, h]", "[a, b, c, d, null, f, g, h]", Arrays.toString((Object[]) t.get(deque)));
            if (table[4] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 1, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 2, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[c, d, a, b]", "[c, d, a, null]", Arrays.toString((Object[]) t.get(deque)));
            if (table[1] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 3);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'c', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 2, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 2, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[c, d, a, b]", "[null, d, a, b]", Arrays.toString((Object[]) t.get(deque)));
            if (table[0] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 4);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'd', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 3, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 2, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[c, d, a, b]", "[c, null, a, b]", Arrays.toString((Object[]) t.get(deque)));
            if (table[1] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'d', 'e', 'f', 'g', 'h', 'a', 'b', 'c'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 5);
        taille.setInt(deque, 7);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d e f g");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            Character car = deque.retirerDernier();
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'g', car);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 6, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 8, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 5, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[d, e, f, g, h, a, b, c]", "[d, e, f, null, h, a, b, c]", Arrays.toString((Object[]) t.get(deque)));
            if (table[4] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 0);
        t.set(deque, tableTestee);
        System.out.println("deque : deque vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("retirerDernier()");
        try {
            deque.retirerDernier();
            System.out.println("Test Deque vide : ko");
            System.out.println("Il fallait une exception de type DequeVideException");
            System.exit(0);

        } catch (DequeVideException e) {

        } catch (Exception e) {
            System.out.println("Test Deque vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            System.out.println("Il fallait une exception de type DequeVideException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");


        System.out.println();
        System.out.println("Tous les tests ont reussi");
    }

    private static void testAjouterPremier() throws IllegalAccessException {
        int numTest = 0;
        Character[] tableTestee;
        DequeImplViaTable<Character> deque;

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{null, null, 'a', null};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 1);
        t.set(deque, tableTestee);
        System.out.println("deque : a");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);
            assertEquals("Test" + numTest + " ko taille (logique) ko :", 2, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 1, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[null, x, a, null]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{null, null, null, 'a'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 3);
        taille.setInt(deque, 1);
        t.set(deque, tableTestee);
        System.out.println("deque : a");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 2, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 2, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[null, null, x, a]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', null, 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 3);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 4, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 1, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[c, x, a, b]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{null, null, null, null, null, 'a', 'b', null};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 5);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 3, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 8, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 4, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[null, null, null, null, x, a, b, null]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', null, null};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 2);
        t.set(deque, tableTestee);
        System.out.println("deque : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 3, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 4, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 3, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, null, x]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', null, null, null, null, null};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 3);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 4, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 8, table.length);
            assertEquals("Test" + numTest + " ko  indicePremier ko", 7, indicePremier.getInt(deque));
            assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, c, null, null, null, null, x]", Arrays.toString((Object[]) t.get(deque)));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 0);
        taille.setInt(deque, 4);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        System.out.println("avec agrandissement de table !");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 5, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 8, table.length);
            if ((char) table[0] == 'x') {
                assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
                assertEquals("Test" + numTest + " ko  contenu table ko", "[x, a, b, c, d, null, null, null]", Arrays.toString((Object[]) t.get(deque)));
            } else {
                assertEquals("Test" + numTest + " ko  indicePremier ko", 7, indicePremier.getInt(deque));
                assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, c, d, null, null, null, x]", Arrays.toString((Object[]) t.get(deque)));
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'c', 'd', 'a', 'b'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 2);
        taille.setInt(deque, 4);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        System.out.println("avec agrandissement de table !");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 5, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 8, table.length);
            if ((char) table[0] == 'x') {
                assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
                assertEquals("Test" + numTest + " ko  contenu table ko", "[x, a, b, c, d, null, null, null]", Arrays.toString((Object[]) t.get(deque)));
            } else {
                assertEquals("Test" + numTest + " ko  indicePremier ko", 7, indicePremier.getInt(deque));
                assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, c, d, null, null, null, x]", Arrays.toString((Object[]) t.get(deque)));
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'f', 'g', 'h', 'a', 'b', 'c', 'd', 'e'};
        deque = new DequeImplViaTable<>();
        indicePremier.setInt(deque, 3);
        taille.setInt(deque, 8);
        t.set(deque, tableTestee);
        System.out.println("deque : a b c d e f g h");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indicePremier.getInt(deque));
        System.out.println("taille : " + taille.getInt(deque));
        System.out.println("ajouterEnPremier('x')");
        System.out.println("avec agrandissement de table !");
        try {
            deque.ajouterEnPremier('x');
            Object[] table = (Object[]) t.get(deque);

            assertEquals("Test" + numTest + " ko taille (logique) ko :", 9, taille.getInt(deque));
            assertEquals("Test" + numTest + " ko ko  taille (physique) ko :", 16, table.length);
            if ((char) table[0] == 'x') {
                assertEquals("Test" + numTest + " ko  indicePremier ko", 0, indicePremier.getInt(deque));
                assertEquals("Test" + numTest + " ko  contenu table ko", "[x, a, b, c, d, e, f, g, h, null, null, null, null, null, null, null]", Arrays.toString((Object[]) t.get(deque)));
            } else {
                assertEquals("Test" + numTest + " ko  indicePremier ko", 15, indicePremier.getInt(deque));
                assertEquals("Test" + numTest + " ko  contenu table ko", "[a, b, c, d, e, f, g, h, null, null, null, null, null, null, null, x]", Arrays.toString((Object[]) t.get(deque)));
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
    }


}
