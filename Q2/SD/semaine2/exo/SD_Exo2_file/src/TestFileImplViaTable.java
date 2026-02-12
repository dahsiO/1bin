import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestFileImplViaTable {

    private static Scanner scanner = new Scanner(System.in);

    static Class classe = FileImplViaTable.class;
    static Field t;
    static Field indiceTete;
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
        System.out.println("**********************************************");
        System.out.println("Programme Test pour la classe FileImplViaTable");
        System.out.println("**********************************************");
        int choix = 0;
        t = classe.getDeclaredField("table");
        t.setAccessible(true);
        indiceTete = classe.getDeclaredField("indiceTete");
        indiceTete.setAccessible(true);
        taille = classe.getDeclaredField("taille");
        taille.setAccessible(true);

        System.out.println();
        System.out.println("Menu");
        System.out.println(("----"));
        System.out.println("1 -> Tester la methode defile()");
        System.out.println("2 -> Tester la methode enfile()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testDefile();
                break;
            case 2:
                testEnfile();
                break;

        }

    }


    private static void testEnfile() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        testEx1();
        System.out.println();
        testEx2();
        System.out.println();
        testEx3();
        System.out.println();
        testEx5();
        System.out.println();
        testEx6();
        System.out.println();
        testEx7();
        System.out.println();
        testEx8();
        System.out.println();
        System.out.println("Tous les exemples du cours theorique ont reussi!");
    }


    private static void testDefile() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        testEx4();
        System.out.println();
        testEx9();
        System.out.println();
        testEx10();
        System.out.println();
        testFileVide();
        System.out.println();
        System.out.println("Tous les exemples du cours theoriques ont reussi!");
    }

    private static void testFileVide() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Test file Vide");
        Character[] tableTestee = {'a', 'b', 'c', 'd'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 2);
        taille.setInt(file, 0);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : file vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("defile()");
        try {
            file.defile();
            System.out.println("Test file vide : ko");
            System.out.println("Il fallait une exception de type FileVideException");
            System.exit(0);
        } catch (FileVideException e) {
            System.out.println("Test file vide : ok");
        } catch (Exception e) {
            System.out.println("Test file vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            System.out.println("Il fallait une exception de type FileVideException");
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static void testEx1() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 1");
        Character[] tableTestee = {null, null, null, null};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 0);
        taille.setInt(file, 0);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : file vide");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('a')");
        try {
            file.enfile('a');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 1 : ko  taille (logique) ko :", 1, taille.getInt(file));
            assertEquals("Exemple 1 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 1 : ko  indiceTete ko", 0, indiceTete.getInt(file));
            assertEquals("Exemple 1 : ko  contenu table ko", "[a, null, null, null]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println("Exemple 1 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 1 : ok");

    }

    private static void testEx2() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 2 ");
        Character[] tableTestee = {'a', null, null, null};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 0);
        taille.setInt(file, 1);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('b')");
        try {
            file.enfile('b');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 2 : ko  taille (logique) ko :", 2, taille.getInt(file));
            assertEquals("Exemple 2 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 2 : ko  indiceTete ko", 0, indiceTete.getInt(file));
            assertEquals("Exemple 2 : ko  contenu table ko", "[a, b, null, null]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println("Exemple 2 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 2 : ok");
    }

    private static void testEx3() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 3 ");
        Character[] tableTestee = {'a', 'b', null, null};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 0);
        taille.setInt(file, 2);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('c')");
        try {
            file.enfile('c');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 3 : ko  taille (logique) ko :", 3, taille.getInt(file));
            assertEquals("Exemple 3 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 3 : ko  indiceTete ko", 0, indiceTete.getInt(file));
            assertEquals("Exemple 3 : ko  contenu table ko", "[a, b, c, null]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println("Exemple 3 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 3 : ok");
    }

    private static void testEx4() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 4");
        Character[] tableTestee = {'a', 'b', 'c', null};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 0);
        taille.setInt(file, 3);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("defile()");
        try {
            Character car = file.defile();
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 4 : ko  caractere renvoye ko :", 'a', car);
            assertEquals("Exemple 4 : ko  taille (logique) ko :", 2, taille.getInt(file));
            assertEquals("Exemple 4 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 4 : ko  indiceTete ko", 1, indiceTete.getInt(file));
            assertEquals("Exemple 4 : ko  contenu table ko", "[null, b, c, null]", "[a, b, c, null]", Arrays.toString((Object[]) t.get(file)));
            if (table[0] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Exemple 4 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 4 : ok");
    }

    private static void testEx5() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 5");
        Character[] tableTestee = {null, null, 'a', 'b'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 2);
        taille.setInt(file, 2);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('c')");
        try {
            file.enfile('c');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 5 : ko  taille (logique) ko :", 3, taille.getInt(file));
            assertEquals("Exemple 5 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 5 : ko  indiceTete ko", 2, indiceTete.getInt(file));
            assertEquals("Exemple 5 : ko  contenu table ko", "[c, null, a, b]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println("Exemple 5 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 5 : ok");
    }

    private static void testEx6() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 6");
        Character[] tableTestee = {'c', null, 'a', 'b'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 2);
        taille.setInt(file, 3);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('d')");
        try {
            file.enfile('d');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 6 : ko  taille (logique) ko :", 4, taille.getInt(file));
            assertEquals("Exemple 6 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 6 : ko  indiceTete ko", 2, indiceTete.getInt(file));
            assertEquals("Exemple 6 : ko  contenu table ko", "[c, d, a, b]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println(" : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 6 : ok");
    }

    private static void testEx7() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 7");
        Character[] tableTestee = {'c', 'd', 'a', 'b'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 2);
        taille.setInt(file, 4);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('e')");
        try {
            file.enfile('e');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 7 : ko  taille (logique) ko :", 5, taille.getInt(file));
            assertEquals("Exemple 7 : ko  taille (physique) ko :", 8, table.length);
            assertEquals("Exemple 7 : ko  indiceTete ko", 0, indiceTete.getInt(file));
            assertEquals("Exemple 7 : ko  contenu table ko", "[a, b, c, d, e, null, null, null]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println(" : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 7 : ok");

    }

    private static void testEx8() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 8");
        Character[] tableTestee = {'b', 'c', 'd', 'a'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 3);
        taille.setInt(file, 4);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b c d");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("enfile('e')");
        try {
            file.enfile('e');
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 8 : ko  taille (logique) ko :", 5, taille.getInt(file));
            assertEquals("Exemple 8 : ko  taille (physique) ko :", 8, table.length);
            assertEquals("Exemple 8 : ko  indiceTete ko", 0, indiceTete.getInt(file));
            assertEquals("Exemple 8 : ko  contenu table ko", "[a, b, c, d, e, null, null, null]", Arrays.toString(table));
        } catch (Exception e) {
            System.out.println("Exemple 8 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 8 : ok");

    }

    private static void testEx9() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 9");
        Character[] tableTestee = {'c', null, 'a', 'b'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 2);
        taille.setInt(file, 3);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : a b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("defile()");
        try {
            Character car = file.defile();
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 9 : ko  caractere renvoye ko :", 'a', car);
            assertEquals("Exemple 9 : ko  taille (logique) ko :", 2, taille.getInt(file));
            assertEquals("Exemple 9 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 9 : ko  indiceTete ko", 3, indiceTete.getInt(file));
            assertEquals("Exemple 9 : ko  contenu table ko", "[c, null, null, b]", "[c, null, a, b]", Arrays.toString(table));
            if (table[2] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Exemple 9 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 9 : ok");
    }

    private static void testEx10() throws IllegalArgumentException, IllegalAccessException {
        System.out.print("Exemple 10");
        Character[] tableTestee = {'c', null, null, 'b'};
        FileImplViaTable<Character> file = new FileImplViaTable<Character>();
        indiceTete.setInt(file, 3);
        taille.setInt(file, 2);
        t.set(file, tableTestee);
        System.out.println();
        System.out.println("file : b c");
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("indiceTete : " + indiceTete.getInt(file));
        System.out.println("taille : " + taille.getInt(file));
        System.out.println("defile()");
        try {
            Character car = file.defile();
            Object[] table = (Object[]) t.get(file);
            assertEquals("Exemple 10 : ko  caractere renvoye ko :", 'b', car);
            assertEquals("Exemple 10 : ko  taille (logique) ko :", 1, taille.getInt(file));
            assertEquals("Exemple 10 : ko  taille (physique) ko :", 4, table.length);
            assertEquals("Exemple 10 : ko  indiceTete ko", 0, indiceTete.getInt(file));
            assertEquals("Exemple 10 : ko  contenu table ko", "[c, null, null, null]", "[c, null, null, b]", Arrays.toString(table));
            if (table[3] == null) {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer l'objet supprime par null !");
            }
        } catch (Exception e) {
            System.out.println("Exemple 10 : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Exemple 10 : ok");
    }

}








