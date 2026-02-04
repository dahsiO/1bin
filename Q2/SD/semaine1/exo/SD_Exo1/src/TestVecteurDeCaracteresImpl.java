import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestVecteurDeCaracteresImpl {

    static Class classe = VecteurDeCaracteresImpl.class;
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
                System.out.println(messageErreur + ". Attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur + ". Attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        System.out.println("*****************************************************");
        System.out.println("Programme Test pour la classe VecteurDeCaracteresImpl");
        System.out.println("*****************************************************");

        int choix = 0;

        taille = classe.getDeclaredField("taille");
        taille.setAccessible(true);

        t = classe.getDeclaredField("table");
        t.setAccessible(true);


        System.out.println();
        System.out.println("1 -> Tester la methode estVide()");
        System.out.println("2 -> Tester la methode element()");
        System.out.println("3 -> Tester la methode insere()");
        System.out.println("4 -> Tester la methode ajoute()'");
        System.out.println("5 -> Tester la methode remplace()");
        System.out.println("6 -> Tester la methode supprime()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testEstVide();
                break;
            case 2:
                testElement();
                break;
            case 3:
                testInsere();
                break;
            case 4:
                testAjoute();
                break;
            case 5:
                testRemplace();
                break;
            case 6:
                testSupprime();
                break;
            default:
                break;
        }
    }

    private static void testEstVide() throws IllegalArgumentException, IllegalAccessException{

        VecteurDeCaracteresImpl v;
        char[] table;
        int tailleV;
        int numTest = 1;
        char[] tABC = {'a', 'b', 'c'};
        char[] tVide = {};

        System.out.println();
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            assertEquals("KO : vecteur : a b c", false, v.estVide());
        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);

        v = new VecteurDeCaracteresImpl(5, tVide);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            assertEquals("KO : vecteur vide", true, v.estVide());
        } catch (Exception e) {
            System.out.println("KO : vecteur vide : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testElement() throws IllegalArgumentException, IllegalAccessException{

        VecteurDeCaracteresImpl v;
        char[] table;
        int tailleV;
        char[] tABC = {'a', 'b', 'c'};
        char[] tVide = {};

        int numTest = 1;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        String tableToStringAvant = Arrays.toString(table);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            assertEquals("KO : vecteur : a b c - element(0)", 'a', v.element(0));
            assertEquals("KO : la methode element() ne peut modifier la taille du vecteur", tailleV, (int) taille.get(v));
            assertEquals("KO : la methode element() ne peut modifier le contenu de la table", tableToStringAvant,Arrays.toString(table));
        } catch (VecteurOutException e) {
            System.out.println("KO : vecteur : a b c - element(0) : Il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - element(0) : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            assertEquals("KO : vecteur : a b c - element(1)", 'b', v.element(1));
        } catch (VecteurOutException e) {
            System.out.println("KO : vecteur : a b c - element(1) : Il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - element(1) : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            assertEquals("KO : vecteur : a b c - element(2)", 'c', v.element(2));
        } catch (VecteurOutException e) {
            System.out.println("KO : vecteur : a b c - element(2) : Il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - element(2) : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            v.element(3);
            System.out.println("KO : vecteur : a b c - element(3) : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {

        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - element(3) : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);

        try {
            v.element(-1);
            System.out.println("KO : vecteur : a b c - element(-1) : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {

        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - element(-1) : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();
        
        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tVide);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            v.element(0);
            System.out.println("KO : vecteur vide - element(0) : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {

        } catch (Exception e) {
            System.out.println("KO : vecteur vide - element(0) : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testInsere() throws IllegalArgumentException, IllegalAccessException{
        
        VecteurDeCaracteresImpl v;
        char[] table;
        int tailleV;
        char[] tABC = {'a', 'b', 'c'};
        char[] tVide = {};
        char[] t10 = {'x','x','x','x','x','x','x','x','x','x'};

        int numTest = 1;
        System.out.println();
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'x', 'b', 'c', '\0'};
            System.out.println("v.insere(1, 'x')");
            v.insere(1, 'x');
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));

        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'x', 'c', '\0'};
            System.out.println("v.insere(2, 'x')");
            v.insere(2, 'x');
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // insertion au debut
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'x', 'a', 'b', 'c', '\0'};
            System.out.println("v.insere(0, 'x')");
            v.insere(0, 'x');
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // insertion en toute fin
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'c', 'x', '\0'};
            System.out.println("v.insere(3, 'x')");
            v.insere(3, 'x');
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // taille logique = 3, taille physique = 4, insertion possible!
        
        v = new VecteurDeCaracteresImpl(4, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'x', 'c'};
            System.out.println("v.insere(2, 'x')");
            v.insere(2, 'x');
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(4, tVide);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'x', '\0', '\0', '\0'};
            System.out.println("v.insere(0, 'x')");
            v.insere(0, 'x');
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 1, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // insertion en -1!
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            System.out.println("v.insere(-1, 'x')");
            v.insere(-1, 'x');
            System.out.println("KO : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            assertEquals("KO : le contenu a ete modifie", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : la taille a ete modifiee", 3, (int) taille.get(v));
        } catch (Exception e) {
            System.out.println("KO : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // insertion avec trou!
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            System.out.println("v.insere(4, 'x')");
            v.insere(4, 'x');
            System.out.println("KO : vecteur : a b c - insere(4,'x') : il fallait une VecteurOutException");
            System.exit(0);

        } catch (VecteurOutException e) {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            assertEquals("KO : le contenu a ete modifie", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : la taille a ete modifiee", 3, (int) taille.get(v));
        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - insere(4,'x') : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // agrandissement de table
        v = new VecteurDeCaracteresImpl(3, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'x', 'b', 'c', '\0', '\0'};
            System.out.println("v.insere(1, 'x')");
            v.insere(1, 'x');
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.out.println("Avez-vous pense a agrandir la table?");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            System.out.println("Avez-vous pense a agrandir la table?");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // agrandissement de table
        v = new VecteurDeCaracteresImpl(10, t10);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a','x','x','x','x','x','x','x','x','x','x','\0','\0','\0','\0','\0','\0','\0','\0','\0'};
            System.out.println("v.insere(0, 'a')");
            v.insere(0, 'a');
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 11, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.out.println("Avez-vous pense a agrandir la table?");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            System.out.println("Avez-vous pense a agrandir la table?");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();
        
        System.out.println("tous les tests ont reussi");
    }

    private static void testAjoute() throws IllegalArgumentException, IllegalAccessException{
        VecteurDeCaracteresImpl v;
        char[] table;
        int tailleV;
        char[] tABC = {'a', 'b', 'c'};
        char[] tVide = {};

        System.out.println();
        
        int numTest = 1;
        System.out.println("Test" + numTest);

        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'c', 'x', '\0'};
            System.out.println("v.ajoute('x')");
            v.ajoute('x');
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(4, tVide);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'x', '\0', '\0', '\0'};
            System.out.println("v.ajoute('x')");
            v.ajoute('x');
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 1, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // agrandissement de table
        v = new VecteurDeCaracteresImpl(3, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'c', 'x', '\0', '\0'};
            System.out.println("v.ajoute('x')");
            v.ajoute('x');
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
        }catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.out.println("Avez-vous pense a agrandir la table?");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            System.out.println("Avez-vous pense a agrandir la table?");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");

    }

    private static void testRemplace() throws IllegalArgumentException, IllegalAccessException{

        VecteurDeCaracteresImpl v;
        char[] table;
        int tailleV;
        char[] tABC = {'a', 'b', 'c'};

        System.out.println();
        
        int numTest = 1;
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'x', 'c', '\0', '\0'};
            System.out.println("v.remplace(1, 'x')");
            assertEquals("KO : caractere renvoye ko", 'b', v.remplace(1, 'x'));
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 3, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // le premier
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'x', 'b', 'c', '\0', '\0'};
            System.out.println("v.remplace(0, 'x')");
            assertEquals("KO : caractere renvoye ko", 'a', v.remplace(0, 'x'));
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 3, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // le dernier
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'x', '\0', '\0'};
            System.out.println("v.remplace(2, 'x')");
            assertEquals("KO : caractere renvoye ko", 'c', v.remplace(2, 'x'));
            table = (char[]) t.get(v);
            assertEquals("KO : table ko", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : taille ko", 3, (int) taille.get(v));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // remplace en -1!
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            System.out.println("v.remplace(-1, 'x')");
            v.remplace(-1, 'x');
            System.out.println("KO : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            assertEquals("KO : le contenu a ete modifie", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : la taille a ete modifiee", 3, (int) taille.get(v));
        } catch (Exception e) {
            System.out.println("KO : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // remplace hors vecteur!
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            System.out.println("v.remplace(3, 'x')");
            v.remplace(3, 'x');
            System.out.println("KO : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            assertEquals("KO : le contenu a ete modifie", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : la taille a ete modifiee", 3, (int) taille.get(v));
        } catch (Exception e) {
            System.out.println("KO : vecteur : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");
    }

    private static void testSupprime() throws IllegalArgumentException, IllegalAccessException{
        
        VecteurDeCaracteresImpl v;
        char[] table;
        int tailleV;
        char[] tABC = {'a', 'b', 'c'};
        char[] tABCDE = {'a', 'b', 'c', 'd', 'e'};

        System.out.println();

        int numTest = 1;
        //taille logique = taille physique
        // ni le premier, ni le dernier
        System.out.println("Test" + numTest);
        v = new VecteurDeCaracteresImpl(5, tABCDE);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'c', 'd', 'e', 'e'};
            System.out.println("v.supprime(1)");
            assertEquals("KO : caractere renvoye ko", 'b', v.supprime(1));
            table = (char[]) t.get(v);
            assertEquals("KO : taille ko", 4, (int) taille.get(v));
            assertEquals("KO : contenu vecteur ko", "a c", ""+table[0]+" "+table[1]);
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        //taille logique < taille physique
        // ni le premier, ni le dernier
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'c', 'c', '\0', '\0'};
            System.out.println("v.supprime(1)");
            assertEquals("KO : caractere renvoye ko", 'b', v.supprime(1));
            table = (char[]) t.get(v);
            assertEquals("KO : taille ko", 2, (int) taille.get(v));
            assertEquals("KO : contenu vecteur ko", "a c", ""+table[0]+" "+table[1]);
            if(!(Arrays.toString(tAttendue)).equals(Arrays.toString(table))){
                System.out.println("AVERTISSEMENT");
                System.out.println("Revoyez votre methode !");
                System.out.println("Votre vecteur contient bien a c");
                System.out.println("La taille obtenue (2) est ok");
                System.out.println("Mais la methode fait faire des permutations inutiles.");
                System.out.println("Il n'est pas necessaire de faire des permutations sur la partie de la table inoccupee.");
                System.out.println("La table peut etre : "+Arrays.toString(tAttendue));
                System.out.println("Utilisez la taille logique et non la taille physique de la table !");
                System.exit(0);
            }
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // le premier
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'b', 'c', 'c', '\0', '\0'};
            System.out.println("v.supprime(0)");
            assertEquals("KO : caractere renvoye ko", 'a', v.supprime(0));
            table = (char[]) t.get(v);
            assertEquals("KO : taille ko", 2, (int) taille.get(v));
            assertEquals("KO : contenu table ko", Arrays.toString(tAttendue), Arrays.toString(table));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // le dernier
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            System.out.println("v.supprime(2)");
            assertEquals("KO : caractere renvoye ko", 'c', v.supprime(2));
            table = (char[]) t.get(v);
            assertEquals("KO : taille ko", 2, (int) taille.get(v));
            assertEquals("KO : contenu table ko", Arrays.toString(tAttendue), Arrays.toString(table));
        } catch (VecteurOutException e) {
            System.out.println("KO : il ne fallait pas de VecteurOutException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println("KO : il y a eu une exception non prevue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();


        numTest++;
        System.out.println("Test" + numTest);
        // supprime en -1!
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            System.out.println("v.supprime(-1)");
            v.supprime(-1);
            System.out.println("KO : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            assertEquals("KO : exception ok, mais le contenu a ete modifie", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : exception ok, mais la taille a ete modifiee", 3, (int) taille.get(v));
        } catch (Exception e) {
            System.out.println("KO : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        // supprime hors vecteur!
        v = new VecteurDeCaracteresImpl(5, tABC);
        table = (char[]) t.get(v);
        tailleV = (int) taille.get(v);
        System.out.println("vecteur : " + v);
        System.out.println("taille vecteur : "+tailleV);
        System.out.println("table : " + Arrays.toString(table));
        System.out.println("capacite table : "+table.length);
        try {
            System.out.println("v.supprime(3)");
            v.supprime(3);
            System.out.println("KO : il fallait une VecteurOutException");
            System.exit(0);
        } catch (VecteurOutException e) {
            char[] tAttendue = {'a', 'b', 'c', '\0', '\0'};
            assertEquals("KO : exception ok, mais le contenu a ete modifie", Arrays.toString(tAttendue), Arrays.toString(table));
            assertEquals("KO : exception ok, mais la taille a ete modifiee", 3, (int) taille.get(v));
        } catch (Exception e) {
            System.out.println("KO : vecteur : a b c - supprime(3) : il fallait une VecteurOutException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");

    }

}


