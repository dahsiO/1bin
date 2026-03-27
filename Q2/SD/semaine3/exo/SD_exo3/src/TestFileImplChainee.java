import java.util.Scanner;

public class TestFileImplChainee {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("*********************************************");
        System.out.println("Programme Test pour la classe FileImplChainee");
        System.out.println("*********************************************");

        int choix = 0;

        System.out.println();
        System.out.println("1 -> Tester la methode premier()");
        System.out.println("2 -> Tester la methode defile()");
        System.out.println("3 -> Tester la methode enfile()");
        System.out.println("4 -> Tester l'exB1");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testPremier();
                break;
            case 2:
                testDefile();
                break;
            case 3:
                testEnfile();
                break;
            case 4:
                testExB1();
                break;
            default:
                break;
        }

    }

    private static void testPremier() {
        System.out.println();
        System.out.println("Tests methode premier()");
        System.out.println("-----------------------");

        System.out.print("Test 1 : File a b c ");
        String[] tabc = {"a", "b", "c"};
        FileImplChainee<String> fabc = new FileImplChainee<String>(tabc);
        try {
            String s = fabc.premier();
            if (s == null) {
                System.out.println(" KO : string renvoyee : null");
                System.exit(0);
            }
            if (!s.equals("a")) {
                System.out.println(" KO : string renvoyee : " + s);
                System.exit(0);
            }
            if (fabc.taille() != 3) {
                System.out.println();
                System.out.println(" KO : taille modifiee : " + fabc.taille());
                System.exit(0);
            }
            if (!fabc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu modifie : " + fabc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 2 : file a ");
        String[] ta = {"a"};
        FileImplChainee<String> fa = new FileImplChainee<String>(ta);
        try {
            String s = fa.premier();
            if (s == null) {
                System.out.println(" KO : string renvoyee : null");
                System.exit(0);
            }
            if (!s.equals("a")) {
                System.out.println(" KO : string renvoyee : " + s);
                System.exit(0);
            }
            if (fa.taille() != 1) {
                System.out.println();
                System.out.println(" KO : taille modifiee : " + fa.taille());
                System.exit(0);
            }
            if (!fa.toString().equals(" a")) {
                System.out.println(" KO : contenu modifie : " + fa);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 3 : FileVide ");
        FileImplChainee<String> fVide = new FileImplChainee<String>();
        try {
            fVide.premier();
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            System.exit(0);
        } catch (FileVideException ex) {
        } catch (Exception ex) {
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.println();
        System.out.println("Tous les tests de la methode premier ont reussi!");
        System.out.println();
    }


    private static void testDefile() {
        System.out.println();
        System.out.println("Tests methode defile()");
        System.out.println("----------------------");

        System.out.print("Test 1 : File a b c ");
        String[] tabc = {"a", "b", "c"};
        FileImplChainee<String> fabc = new FileImplChainee<String>(tabc);
        try {
            String s = fabc.defile();
            if (s == null) {
                System.out.println(" KO : string renvoyee : null");
                System.exit(0);
            }
            if (!s.equals("a")) {
                System.out.println(" KO : string renvoyee : " + s);
                System.exit(0);
            }
            if (fabc.taille() != 2) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fabc.taille());
                System.exit(0);
            }
            if (!fabc.toString().equals(" b c")) {
                System.out.println(" KO : contenu obtenu : " + fabc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 2 : file a ");
        String[] ta = {"a"};
        FileImplChainee<String> fa = new FileImplChainee<String>(ta);
        try {
            String s = fa.defile();
            if (s == null) {
                System.out.println(" KO : string renvoyee : null");
                System.exit(0);
            }
            if (!s.equals("a")) {
                System.out.println(" KO : string renvoyee : " + s);
                System.exit(0);
            }
            if (fa.taille() != 0) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fa.taille());
                System.exit(0);
            }
            if (!fa.toString().equals("")) {
                System.out.println(" KO : contenu obtenu : " + fa);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 3 : FileVide ");
        FileImplChainee<String> fVide = new FileImplChainee<String>();
        try {
            fVide.defile();
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            System.exit(0);

        } catch (FileVideException ex) {
        } catch (Exception ex) {
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.println();
        System.out.println("Tous les tests de la methode defile ont reussi!");
        System.out.println();
    }


    private static void testEnfile() {
        System.out.println();
        System.out.println("Tests methode enfile()");
        System.out.println("----------------------");

        System.out.print("Test 1 : File a b c : enfile(x)");
        String[] tabc = {"a", "b", "c"};
        FileImplChainee<String> fabc = new FileImplChainee<String>(tabc);
        try {
            fabc.enfile("x");
            if (fabc.taille() != 4) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fabc.taille());
                System.exit(0);
            }
            if (!fabc.toString().equals(" a b c x")) {
                System.out.println(" KO : contenu liste obtenu : " + fabc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 2 : File a : enfile(x)");
        String[] ta = {"a"};
        FileImplChainee<String> fa = new FileImplChainee<String>(ta);
        try {
            fa.enfile("x");
            if (fa.taille() != 2) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fa.taille());
                System.exit(0);
            }
            if (!fa.toString().equals(" a x")) {
                System.out.println(" KO : contenu liste obtenu : " + fa);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 3 : File a b  : enfile(c) enfile(d)");
        String[] tab = {"a", "b"};
        FileImplChainee<String> fab = new FileImplChainee<String>(tab);
        try {
            fab.enfile("c");
            fab.enfile("d");
            if (fab.taille() != 4) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fab.taille());
                System.exit(0);
            }
            if (!fab.toString().equals(" a b c d")) {
                System.out.println(" KO : contenu liste obtenu : " + fab);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 4 : FileVide : enfile(x)");
        FileImplChainee<String> fVide = new FileImplChainee<String>();
        try {
            fVide.enfile("x");
            if (fVide.taille() != 1) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fVide.taille());
                System.exit(0);
            }
            if (!fVide.toString().equals(" x")) {
                System.out.println(" KO : contenu liste obtenu : " + fVide);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.print("Test 5 : File vide  : enfile(a) enfile(b) enfile(c) enfile(d)");
        FileImplChainee<String> fV = new FileImplChainee<String>();
        try {
            fV.enfile("a");
            fV.enfile("b");
            fV.enfile("c");
            fV.enfile("d");
            if (fV.taille() != 4) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + fV.taille());
                System.exit(0);
            }
            if (!fV.toString().equals(" a b c d")) {
                System.out.println(" KO : contenu liste obtenu : " + fV);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" : ok");

        System.out.println();
        System.out.println("Tous les tests de la methode enfile ont reussi!");
        System.out.println();
    }

    private static void testExB1() {

        FileImplChainee<Character> f = new FileImplChainee<Character>();

        System.out.print("Test1 ");
        try {
            f.defile();
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            System.exit(0);
        } catch (FileVideException ex) {
        } catch (Exception ex) {
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test2 ");
        try {
            f.premier();
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            System.exit(0);

        } catch (FileVideException ex) {
        } catch (Exception ex) {
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test3 ");
        try {
            f.enfile('a');
            if (f.taille() != 1) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + f.taille());
                System.exit(0);
            }
            if (!f.toString().equals(" a")) {
                System.out.println(" KO : contenu liste obtenu : " + f);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test4 ");
        try {
            f.enfile('b');
            if (f.taille() != 2) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + f.taille());
                System.exit(0);
            }
            if (!f.toString().equals(" a b")) {
                System.out.println(" KO : contenu liste obtenu : " + f);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test5 ");
        try {
            char c = f.premier();
            if (c != 'a') {
                System.out.println(" KO : caractere renvoye : " + c);
                System.exit(0);
            }
            if (f.taille() != 2) {
                System.out.println();
                System.out.println(" KO : taille modifiee : " + f.taille());
                System.exit(0);
            }
            if (!f.toString().equals(" a b")) {
                System.out.println(" KO : contenu modifie : " + f);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test6 ");
        try {
            char c = f.defile();
            if (c != 'a') {
                System.out.println(" KO : caractere renvoye : " + c);
                System.exit(0);
            }
            if (f.taille() != 1) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + f.taille());
                System.exit(0);
            }
            if (!f.toString().equals(" b")) {
                System.out.println(" KO : contenu obtenu : " + f);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test7 ");
        try {
            char c = f.defile();
            if (c != 'b') {
                System.out.println(" KO : caractere renvoye : " + c);
                System.exit(0);
            }
            if (f.taille() != 0) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + f.taille());
                System.exit(0);
            }
            if (!f.toString().equals("")) {
                System.out.println(" KO : contenu obtenu : " + f);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test8 ");
        try {
            f.defile();
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            System.exit(0);

        } catch (FileVideException ex) {
        } catch (Exception ex) {
            System.out.println(" KO, il n'y a pas eu FileVideException : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println("ok");

        System.out.print("Test9 ");
        try {
            f.enfile('c');
            f.enfile('d');
            f.enfile('e');
            if (f.taille() != 3) {
                System.out.println();
                System.out.println(" KO : taille obtenue : " + f.taille());
                System.exit(0);
            }
            if (!f.toString().equals(" c d e")) {
                System.out.println(" KO : contenu liste obtenu : " + f);
                System.exit(0);
            }

        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }


        System.out.println("ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi!");
    }


}








