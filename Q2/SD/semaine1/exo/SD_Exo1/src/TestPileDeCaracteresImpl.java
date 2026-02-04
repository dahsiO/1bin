import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestPileDeCaracteresImpl {

    private static Scanner scanner = new Scanner(System.in);

    static Class classe = PileDeCaracteresImpl.class;
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

        System.out.println("**************************************************");
        System.out.println("Programme Test pour la classe PileDeCaracteresImpl");
        System.out.println("**************************************************");

        int choix = 0;
        t = classe.getDeclaredField("table");
        t.setAccessible(true);
        taille = classe.getDeclaredField("nombreCaracteres");
        taille.setAccessible(true);

        System.out.println();
        System.out.println("Menu");
        System.out.println(("----"));
        System.out.println("1 -> Tester la methode sommet()");
        System.out.println("2 -> Tester la methode pop()");
        System.out.println("3 -> Tester la methode push()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testSommet();
                break;
            case 2:
                testPop();
                break;
            case 3:
                testPush();
                break;

        }
    }

    private static void testSommet() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        char[] tableABCD = {'a', 'b', 'c', 'd'};
        char[] tableABCDEFGH = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        PileDeCaracteresImpl pile;
        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 3);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 3");
        System.out.println("sommet()");
        try {
            char car = pile.sommet();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'c', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 3, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test2
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 4);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 4");
        System.out.println("sommet()");
        try {
            char car = pile.sommet();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'd', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 4, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c d", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test3
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 1);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 1");
        System.out.println("sommet()");
        try {
            char car = pile.sommet();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'a', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 1, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a", pile.toString());

        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test4
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 8);
        t.set(pile, tableABCDEFGH.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCDEFGH));
        System.out.println("taille : 8");
        System.out.println("sommet()");
        try {
            char car = pile.sommet();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'h', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 8, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 8, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c d e f g h", pile.toString());

        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test 5
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.print("Test pile vide");
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 0);
        t.set(pile, tableABCD.clone());
        System.out.println();
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 0");
        System.out.println("sommet()");
        try {
            Character car = pile.sommet();
            System.out.println("Test pile vide : ko");
            System.out.println("Il fallait une exception de type PileVideException");
            System.exit(0);

        } catch (PileVideException e) {
            System.out.println("Test pile vide : ok");
        } catch (Exception e) {
            System.out.println("Test pile vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            System.out.println("Il fallait une exception de type PileVideException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testPop() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        char[] tableABCD = {'a', 'b', 'c', 'd'};
        char[] tableABCDEFGH = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        PileDeCaracteresImpl pile;
        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 3);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 3");
        System.out.println("pop()");
        try {
            char car = pile.pop();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'c', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 2, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b", pile.toString());
            if (table[2] != 'c') {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer le caractere supprime !");
            }
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test2
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 4);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 4");
        System.out.println("pop()");
        try {
            char car = pile.pop();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'd', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 3, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c", pile.toString());
            if (table[3] != 'd') {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer le caractere supprime !");
            }
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test3
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 1);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 1");
        System.out.println("pop()");
        try {
            char car = pile.pop();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'a', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 0, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile =", pile.toString());
            if (table[0] != 'a') {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer le caractere supprime !");
            }
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test4
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 8);
        t.set(pile, tableABCDEFGH.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCDEFGH));
        System.out.println("taille : 8");
        System.out.println("pop()");
        try {
            char car = pile.pop();
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  caractere renvoye ko :", 'h', car);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 7, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 8, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c d e f g", pile.toString());
            if (table[0] != 'a') {
                System.out.println("Avertissement : il n'est pas indispensable de remplacer le caractere supprime !");
            }
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test 5
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.print("Test pile vide");
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 0);
        t.set(pile, tableABCD.clone());
        System.out.println();
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 0");
        System.out.println("pop()");
        try {
            Character car = pile.pop();
            System.out.println("Test pile vide : ko");
            System.out.println("Il fallait une exception de type PileVideException");
            System.exit(0);

        } catch (PileVideException e) {
            System.out.println("Test pile vide : ok");
        } catch (Exception e) {
            System.out.println("Test pile vide : ko");
            System.out.println("Il y a eu une exception non attendue");
            System.out.println("Il fallait une exception de type PileVideException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testPush() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        char[] tableABCD = {'a', 'b', 'c', 'd'};
        char[] tableABCDEFGH = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        PileDeCaracteresImpl pile;
        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 2);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 2");
        System.out.println("push('x')");
        try {
            pile.push('x');
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 3, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b x", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test 2
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 3);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 3");
        System.out.println("push('x')");
        try {
            pile.push('x');
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 4, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c x", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test 3
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 0);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 0");
        System.out.println("push('x')");
        try {
            pile.push('x');
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 1, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 4, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = x", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test 4
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 4);
        t.set(pile, tableABCD.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCD));
        System.out.println("taille : 4");
        System.out.println("push('x')");
        try {
            pile.push('x');
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 5, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 8, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c d x", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");

        //test 5
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        pile = new PileDeCaracteresImpl();
        taille.setInt(pile, 8);
        t.set(pile, tableABCDEFGH.clone());
        System.out.println("pile : " + pile);
        System.out.println("table : " + Arrays.toString(tableABCDEFGH));
        System.out.println("taille : 8");
        System.out.println("push('x')");
        try {
            pile.push('x');
            char[] table = (char[]) t.get(pile);
            assertEquals("Test " + numTest + " : ko  nombre caracteres (taille logique) ko :", 9, taille.getInt(pile));
            assertEquals("Test " + numTest + " : ko  capacite table (taille physique) ko :", 16, table.length);
            assertEquals("Test " + numTest + " : ko  contenu table ko :", "pile = a b c d e f g h x", pile.toString());
        } catch (Exception e) {
            System.out.println("Test " + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test " + numTest + " : ok");


        System.out.println();
        System.out.println("tous les tests ont reussi");
    }


}



        /*
        System.out.println("\nLes tests suivent un scenario.");
        System.out.println("C'est celui propose a l'ex A1.");
        System.out.println("La numerotation a ete respectee.");
        System.out.println();
        t = classe.getDeclaredField("table");
        t.setAccessible(true);
        char c;
        char[] table;
        PileDeCaracteresImpl pile = new PileDeCaracteresImpl();

        // test 1
        System.out.println("test 1 : pile.pop()");
        try {
            c = pile.pop();
            System.out.println("test 1 KO : Il fallait une PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide");
            System.out.println("Revoyez la methode pop() !");
            return;
        } catch (PileVideException e) {

        } catch (Exception e) {
            System.out.println("test 1 KO : Il fallait une PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide");
            System.out.println("Revoyez la methode pop() !");
            e.printStackTrace();
            return;
        }
        System.out.println("test 1 OK");

        // test 2
        System.out.println("test 2 : pile.sommet()");
        try {
            c = pile.sommet();
            System.out.println("test 2 KO : Il fallait une PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide");
            System.out.println("Revoyez la methode sommet() !");
            return;

        } catch (PileVideException e) {

        } catch (Exception e) {
            System.out.println("test 2 KO : Il fallait une PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide");
            System.out.println("Revoyez la methode sommet() !");
            e.printStackTrace();
            return;
        }
        System.out.println("test 2 OK");

        // test 3
        System.out.println("test 3 : pile.push('a')");
        try {
            pile.push('a');
            if (pile.taille() != 1) {
                System.out.println("test 3 KO : taille logique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide");
                System.out.println("Apres ajout du caractere 'a', la taille logique devrait etre 1");
                System.out.println("Avez-vous augmente de 1 la taille logique ?");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            table = (char[]) t.get(pile);
            if (table.length != 4) {
                System.out.println("test 3 KO : taille physique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide.");
                System.out.println("La taille physique de la table est 4. Elle peut donc contenir 1 premier caractere.");
                System.out.println("Mais, vous avez change la taille physique de depart de la table! Il ne fallait pas.");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[0] != 'a') {
                System.out.println("test 3 KO : contenu de la table KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), au depart la pile est vide.");
                System.out.println("Apres ajout du caractere 'a', la table devrait contenir le caractere 'a' a l'indice 0.");
                System.out.println("Le caractere a l'indice 0 de votre table contient : '" + table[0] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
        } catch (Exception e) {
            System.out.println("test 3 KO : Il y a eu une exception inattendue : ");
            System.out.println("Revoyez la methode push() !");
            System.out.println("La methode push() doit toujours reussir");
            e.printStackTrace();
            return;
        }
        System.out.println("test 3 OK");

        // test 4
        System.out.println("test 4 : pile.push('b')");
        try {
            pile.push('b');
            if (pile.taille() != 2) {
                System.out.println("test 4 KO taille logique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a'.");
                System.out.println("Apres ajout du caractere 'b', la taille logique de la table devrait etre 2.");
                System.out.println("Avez-vous augmente de 1 la taille logique ?");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            table = (char[]) t.get(pile);
            if (table.length != 4) {
                System.out.println("test 4 KO : taille physique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a'.");
                System.out.println("La taille physique de la table est 4. Elle peut donc contenir 1 deuxieme caractere.");
                System.out.println("Mais, vous avez change la taille physique de depart de la table! Il ne fallait pas.");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[0] != 'a') {
                System.out.println("test 4 KO : contenu table KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' et on veut ajouter le caractere 'b'.");
                System.out.println("La table devrait contenir le caractere 'a' a l'indice 0.");
                System.out.println("Le caractere a l'indice 0 de votre table contient : '" + table[0] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[1] != 'b') {
                System.out.println("test 4 KO : contenu table KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' et on veut ajouter le caractere 'b'.");
                System.out.println("La table devrait contenir le caractere 'b' a l'indice 1.");
                System.out.println("Le caractere a l'indice 1 de votre table contient : '" + table[1] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
        } catch (Exception e) {
            System.out.println("test 4 KO : Il y a eu une exception inattendue : ");
            System.out.println("Revoyez la methode push() !");
            System.out.println("La methode push() doit toujours reussir");
            e.printStackTrace();
            return;
        }
        System.out.println("test 4 OK");

        // test 5
        System.out.println("test 5 : pile.sommet()");
        try {
            c = pile.sommet();
            if (c != 'b') {
                System.out.println("test 5 KO : sommet KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("Votre methode aurait du renvoyer le caractere 'b'");
                System.out.println("Elle a renvoye le caractere : '" + c + "'");
                System.out.println("Revoyez la methode sommet() !");
                return;
            }
            if (pile.taille() != 2) {
                System.out.println("test 5 KO : taille logique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("la methode sommet() ne retire pas le caractere du sommet");
                System.out.println("La taille logique devrait etre 2");
                System.out.println("Apres appel de votre methode sommet(), la taille logique est " + pile.taille());
                System.out.println("Revoyez la methode sommet() !");
                return;
            }
            table = (char[]) t.get(pile);
            if (table[0] != 'a') {
                System.out.println("test 5 KO : contenu table KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("la methode sommet() ne retire pas le caractere du sommet");
                System.out.println("La table devrait contenir le caractere 'a' a l'indice 0.");
                System.out.println("Le caractere a l'indice 0 de votre table contient : '" + table[0] + "'");
                System.out.println("Revoyez la methode sommet() !");
                return;
            }
            if (table[1] != 'b') {
                System.out.println("test 5 KO : contenu table KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("la methode sommet() ne retire pas le caractere du sommet");
                System.out.println("La table devrait contenir le caractere 'b' a l'indice 1.");
                System.out.println("Le caractere a l'indice 1 de votre table contient : '" + table[1] + "'");
                System.out.println("Revoyez la methode sommet() !");
                return;
            }
        } catch (PileVideException e) {
            System.out.println("test 5 KO : Il ne fallait pas de PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
            System.out.println("Revoyez la methode sommet() !");
            return;
        } catch (Exception e) {
            System.out.println("test 5 KO : Il y a eu une exception inattendue : ");
            System.out.println("Revoyez la methode sommet() !");
            e.printStackTrace();
            return;
        }
        System.out.println("test 5 OK");

        // test 6
        System.out.println("test 6 : pile.pop()");
        try {
            c = pile.pop();
            if (c != 'b') {
                System.out.println("test 6 KO : caractere renvoye KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("le test 6 retire le caractere 'b'");
                System.out.println("votre methode a renvoye le caractere : '" + c + "'");
                System.out.println("Revoyez la methode pop() !");
                return;
            }
            if (pile.taille() != 1) {
                System.out.println("test 6 KO : taille logique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("le test 6 retire le caractere 'b'");
                System.out.println("La taille logique devrait etre 1");
                System.out.println("Apres appel de votre methode pop(), la taille logique est " + pile.taille());
                System.out.println("Revoyez la methode pop() !");
                return;
            }
            table = (char[]) t.get(pile);
            if (table[0] != 'a') {
                System.out.println("test 6 KO : contenu table KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
                System.out.println("le test 6 retire le caractere 'b'");
                System.out.println("La table devrait toujours contenir le caractere 'a' a l'indice 0.");
                System.out.println("Le caractere a l'indice 0 de votre table contient : '" + table[0] + "'");
                System.out.println("Revoyez la methode pop() !");
                return;
            }
            if (table[1] != 'b') {
                System.out.println("test 6 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
                System.out.println("Revoyez la methode pop() !");
            }

        } catch (PileVideException e) {
            System.out.println("test 6 KO : Il ne fallait pas de PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a' (en bas) et le caractere 'b' (au sommet).");
            System.out.println("Revoyez la methode pop() !");
            return;
        } catch (Exception e) {
            System.out.println("test 6 KO : Il y a eu une exception inattendue : ");
            System.out.println("Revoyez la methode pop() !");
            e.printStackTrace();
            return;
        }
        System.out.println("test 6 OK");

        // test 7
        System.out.println("test 7 : pile.pop()");
        try {
            c = pile.pop();
            if (c != 'a') {
                System.out.println("test 7 KO : caractere renvoye KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a'.");
                System.out.println("le test 7 retire le caractere 'a'");
                System.out.println("votre methode a renvoye le caractere : '" + c + "'");
                System.out.println("Revoyez la methode pop() !");
                return;
            }
            if (pile.taille() != 0) {
                System.out.println("test 7 KO : taille logique KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a'.");
                System.out.println("le test 7 retire le caractere 'a'");
                System.out.println("La taille logique devrait etre 0");
                System.out.println("Apres appel de votre methode pop(), la taille logique est " + pile.taille());
                System.out.println("Revoyez la methode pop() !");
                return;
            }
            table = (char[]) t.get(pile);
            if (table[0] != 'a') {
                System.out.println("test 7 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
            }
            if (table[1] != 'b') {
                System.out.println("test 7 AVERTISSEMENT : Les caracteres supprimes peuvent rester dans la table!");
            }

        } catch (PileVideException e) {
            System.out.println("test 7 KO : Il ne fallait pas de PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), la pile contient actuellement le caractere 'a'.");
            System.out.println("Revoyez la methode pop() !");
            return;
        } catch (Exception e) {
            System.out.println("test 7 KO : Il y a eu une exception inattendue : ");
            System.out.println("Revoyez la methode pop() !");
            e.printStackTrace();
            return;
        }
        System.out.println("test 7 OK");

        // test 8
        System.out.println("test 8 : pile.pop()");
        try {
            c = pile.pop();
            System.out.println("test 8 KO : il fallait lancer une PileVideException");
            System.out.println("Dans le scenario de tests suivi (ex A1), la pile est actuellement vide.");

            return;

        } catch (PileVideException e) {
            if (pile.taille() != 0) {
                System.out.println("test 8 KO : taille KO");
                System.out.println("Dans le scenario de tests suivi (ex A1), la pile est actuellement vide.");
                System.out.println("La taille logique devrait etre 0");
                System.out.println("Apres appel de votre methode pop(), la taille logique est " + pile.taille());
                return;
            }
        } catch (Exception e) {
            System.out.println("test 8 KO : Il y a eu une exception inattendue : ");
            e.printStackTrace();
            return;
        }
        System.out.println("test 8 OK");

        // test 9
        System.out.println("test 9 : verification agrandissement de la table : ");
        System.out.println("Au depart, la pile est vide.");
        System.out.println("On ajoute successivement les caracteres 'a' a 'z'.");
        int taille = 0;
        for (char caractere = 'a'; caractere <= 'd'; caractere++) {
            System.out.println("pile.push('" + caractere + "')");
            try {
                pile.push(caractere);
                taille++;
                if (pile.taille() != taille) {
                    System.out.println("test KO : taille logique KO");
                    System.out.println("la taille logique devrait etre : " + taille);
                    System.out.println("Apres appel de votre methode, la taille logique est " + pile.taille());
                    System.out.println("Revoyez la methode push() !");
                    return;
                }
                table = (char[]) t.get(pile);
                if (table.length != 4) {
                    System.out.println("test KO : taille physique KO");
                    System.out.println("Au depart,la taille physique de la table est 4. Elle peut donc contenir 4 caracteres.");
                    System.out.println("Vous avez change la taille physique de depart de la table! Il ne fallait pas.");
                    System.out.println("Revoyez la methode push() !");
                    return;
                }
                if (table[((int) caractere - (int) 'a')] != caractere) {
                    System.out.println("test KO : contenu de la table KO");
                    System.out.println("Apres ajout du caractere : " + caractere + ", la table devrait contenir le caractere 'a' a l'indice : " + ((int) caractere - (int) 'a'));
                    System.out.println("A cet indice, votre table contient : '" + table[((int) caractere - (int) 'a')] + "'");
                    System.out.println("Revoyez la methode push() !");
                    return;
                }
            } catch (Exception e) {
                System.out.println("test KO : Il y a eu une exception inattendue : ");
                e.printStackTrace();
                return;
            }

        }

        System.out.println("pile.push('e')");
        try {
            pile.push('e');
            taille++;
            if (pile.taille() != taille) {
                System.out.println("test KO : taille logique KO");
                System.out.println("la taille logique devrait etre : " + taille);
                System.out.println("Apres appel de votre methode, la taille logique est " + pile.taille());
                System.out.println("Revoyez la methode push() !");
                return;
            }
            table = (char[]) t.get(pile);
            if (table.length != 8) {
                System.out.println("test KO : taille physique KO");
                System.out.println("Au depart,La taille physique de la table est 4. Elle peut donc contenir 4 caracteres.");
                System.out.println("On a deja ajoute les caracteres 'a', 'b', 'c' et 'd'");
                System.out.println("La table ne peut donc pas contenir le caractere 'e'. Il fallait doubler la table.");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[0] != 'a') {
                System.out.println("test KO : contenu de la table KO");
                System.out.println("Apres ajout du caractere 'e', la table devrait contenir le caractere 'a' a l'indice 0");
                System.out.println("A cet indice, votre table contient : '" + table[0] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[1] != 'b') {
                System.out.println("test KO : contenu de la table KO");
                System.out.println("Apres ajout du caractere 'e', la table devrait contenir le caractere 'b' a l'indice 1");
                System.out.println("A cet indice, votre table contient : '" + table[1] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[2] != 'c') {
                System.out.println("test KO : contenu de la table KO");
                System.out.println("Apres ajout du caractere 'e', la table devrait contenir le caractere 'c' a l'indice 2");
                System.out.println("A cet indice, votre table contient : '" + table[2] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[3] != 'd') {
                System.out.println("test KO : contenu de la table KO");
                System.out.println("Apres ajout du caractere 'e', la table devrait contenir le caractere 'd' a l'indice 3");
                System.out.println("A cet indice, votre table contient : '" + table[3] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
            if (table[4] != 'e') {
                System.out.println("test KO : contenu de la table KO");
                System.out.println("Apres ajout du caractere 'e', la table devrait contenir le caractere 'e' a l'indice 4");
                System.out.println("A cet indice, votre table contient : '" + table[4] + "'");
                System.out.println("Revoyez la methode push() !");
                return;
            }
        } catch (Exception e) {
            System.out.println("test KO : Il y a eu une exception inattendue : ");
            System.out.println("Au depart,La taille physique de la table est 4. Elle peut donc contenir 4 caracteres.");
            System.out.println("La table ne peut donc pas contenir le caractere e. Il fallait doubler la table.");
            System.out.println("La table ne peut donc pas contenir le caractere 'e'. Il fallait doubler la table.");
            System.out.println("Revoyez la methode push() !");
            e.printStackTrace();
            return;
        }

        for (char caractere = 'f'; caractere <= 'z'; caractere++) {
            System.out.println("pile.push('" + caractere + "')");
            try {
                pile.push(caractere);
                taille++;
                if (pile.taille() != taille) {
                    System.out.println("test KO : taille logique KO");
                    System.out.println("la taille logique devrait etre : " + taille);
                    System.out.println("Apres appel de votre methode, la taille logique est " + pile.taille());
                    System.out.println("Revoyez la methode push() !");
                    return;
                }
                table = (char[]) t.get(pile);
                if (table[((int) caractere - (int) 'a')] != caractere) {
                    System.out.println("test KO : contenu de la table KO");
                    System.out.println("Apres ajout du caractere : " + caractere + ", la table devrait contenir le caractere 'a' a l'indice : " + ((int) caractere - (int) 'a'));
                    System.out.println("A cet indice, votre table contient : '" + table[((int) caractere - (int) 'a')] + "'");
                    System.out.println("Revoyez la methode push() !");
                    return;
                }
            } catch (Exception e) {
                System.out.println("test KO : Il y a eu une exception inattendue : ");
                e.printStackTrace();
                return;
            }

        }

        table = (char[]) t.get(pile);
        if (table.length != 32) {
            System.out.println("test 9 : KO");
            System.out.println("la taille physique de la table apres ajout des 26 caracteres devrait etre 32!");
            System.out.println("il faut doubler la table, chaque fois qu'elle est trop petite");
            System.out.println("Au depart taille physique   : 4");
            System.out.println("Ensuite                     : 8");
            System.out.println("Ensuite                     : 16");
            System.out.println("Ensuite                     : 32");
            System.out.println("Revoyez la methode push() !");
            return;
        }


        System.out.println("test 9 OK");
        System.out.println();
        System.out.println("Le scenario de tests a reussi");


         */














