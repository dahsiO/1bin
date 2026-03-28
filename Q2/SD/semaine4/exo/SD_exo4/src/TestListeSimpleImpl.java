import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestListeSimpleImpl {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("*********************************************");
        System.out.println("Programme Test pour la classe ListeSimpleImpl");
        System.out.println("*********************************************");

        int choix = 0;
        System.out.println();
        System.out.println("1 -> Tester la methode premier()");
        System.out.println("2 -> Tester la methode insererEnTete()");
        System.out.println("3 -> Tester la methode contient()");
        System.out.println("4 -> Tester la methode insererApres()'");
        System.out.println("5 -> Tester la methode supprimer()");
        System.out.println("6 -> Tester la methode iterator()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testPremier();
                break;
            case 2:
                testInsererEnTete();
                break;
            case 3:
                testContient();
                break;
            case 4:
                testInsererApres();
                break;
            case 5:
                testSupprimer();
                break;
            case 6:
                testIterator();
                break;

            default:
                break;
        }
    }

    // ITERATOR()
    private static void testIterator() {
        System.out.println();
        System.out.println("Tests methode iterator()");

        System.out.print("Test 1 : liste a b c :");
        String[] tabc = {"a", "b", "c"};
        ListeSimpleImpl<String> labc = new ListeSimpleImpl<String>(tabc);
        try {
            Iterator<String> it = labc.iterator();
            if (!it.hasNext()) {
                System.out.println(" KO : booleen renvoye par hasNext : false!");
                System.exit(0);
            }
            Object o = it.next();
            if (!(o instanceof String)) {
                System.out.println(" KO : la liste testee contient des objets de la classe String");
                System.out.println("         Verifiez si votre methode renvoie bien l'element contenu dans le noeud et non le noeud");
                System.exit(0);
            }
            String s = (String) o;
            if (!s.equals("a")) {
                System.out.println(" KO : premier renvoye : " + s);
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste  a change : " + labc);
                System.exit(0);
            }
        } catch (NoSuchElementException ex) {
            System.out.println(" KO, il y a eu une NoSuchElementException");
            System.exit(0);
        } catch (Exception e) {
            System.out.println(" KO, il y a eu Exception : ");
            System.out.println("                         Verifier si votre methode next() leve bien une NoSuchElementException quand il n'y a plus d'element");
            e.printStackTrace();
            System.exit(0);
        }
        String forE = "";
        for (Object object : labc) {
            forE += object;
        }
        if (!forE.equals("abc")) {
            System.out.println(" KO, foreach a echoue");
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 2 : listeVide :");
        ListeSimpleImpl<String> listeVide = new ListeSimpleImpl<String>();
        try {
            Iterator<String> it = listeVide.iterator();
            if (it.hasNext()) {
                System.out.println(" KO : booleen renvoye par hasNext() : true!");
                System.exit(0);
            }
            it.next();
            System.out.println("KO, votre methode next() doit lever une NoSuchElementException quand il n'y a plus d'element");
        } catch (NoSuchElementException ex) {
            System.out.println(" ok");
        } catch (Exception e) {
            System.out.println(" KO, il y a eu Exception : ");
            System.out.println("                         Verifier si votre methode next() leve bien une NoSuchElementException quand il n'y a plus d'element");
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Tous les tests ont reussi!");
    }


    // SUPPRIMER()
    private static void testSupprimer() {
        System.out.println();
        System.out.println("Tests methode supprimer()");

        System.out.print("Test 1 : liste a b c : supprimer a : ");
        String[] tabc = {"a", "b", "c"};
        ListeSimpleImpl<String> labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.supprimer(new String("a"))) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 2) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" b c")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 2 : liste a b c : supprimer b : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.supprimer("b")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 2) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a c")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 3 : liste a b c : supprimer c : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.supprimer("c")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 2) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 4 : liste a b c : supprimer d : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (labc.supprimer("d")) {
                System.out.println(" KO : booleen renvoye : true!");
                System.exit(0);
            }
            if (labc.taille() != 3) {
                System.out.println(" KO : taille a change : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste a change : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 5 : liste a : supprimer a : ");
        String[] ta = {"a"};
        ListeSimpleImpl<String> la = new ListeSimpleImpl<String>(ta);
        try {
            if (!la.supprimer("a")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (la.taille() != 0) {
                System.out.println(" KO : taille obtenue : " + la.taille());
                System.exit(0);
            }
            if (!la.toString().equals("")) {
                System.out.println(" KO : contenu liste obtenu : " + la);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }

        System.out.println("ok");
        System.out.print("Test 6 : liste a b a : supprimer a : ");
        String[] taba = {"a", "b", "a"};
        ListeSimpleImpl<String> laba;
        laba = new ListeSimpleImpl<String>(taba);
        try {
            if (!laba.supprimer("a")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (laba.taille() != 2) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!laba.toString().equals(" b a")) {
                System.out.println(" KO : contenu liste obtenu : " + laba);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 7 : listeVide :");
        ListeSimpleImpl<String> listeVide = new ListeSimpleImpl<String>();
        try {
            if (listeVide.supprimer("a")) {
                System.out.println(" KO : booleen renvoye : true!");
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.println("Tous les tests ont reussi!");
    }


    // InSERERERAPRES()
    private static void testInsererApres() {
        System.out.println();
        System.out.println("Tests methode insererApres()");

        System.out.print("Test 1 : liste a b c : inserer x apres a : ");
        String[] tabc = {"a", "b", "c"};
        ListeSimpleImpl<String> labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.insererApres(new String("a"), "x")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 4) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a x b c")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 2 : liste a b c : inserer x apres b : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.insererApres("b", "x")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 4) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b x c")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 3 : liste a b c : inserer x apres c : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.insererApres("c", "x")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 4) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c x")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 4 : liste a b c : inserer x apres d : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (labc.insererApres("d", "x")) {
                System.out.println(" KO : booleen renvoye : true!");
                System.exit(0);
            }
            if (labc.taille() != 3) {
                System.out.println(" KO : taille a change : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste a change : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 5 : listeVide :");
        ListeSimpleImpl<String> listeVide = new ListeSimpleImpl<String>();
        try {
            if (listeVide.insererApres("a", "b")) {
                System.out.println(" KO : booleen renvoye : true!");
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");


        System.out.println("Tous les tests ont reussi!");
    }

    // PREMIER()
    private static void testPremier() {
        System.out.println("Tests methode premier()");

        System.out.print("Test 1 : liste a b c :");
        String[] tabc = {"a", "b", "c"};
        ListeSimpleImpl<String> labc = new ListeSimpleImpl<String>(tabc);
        try {
            Object o = labc.premier();
            if (o == null) {
                System.out.println(" KO : votre methode a renvoye null");
                System.exit(0);
            }
            if (!(o instanceof String)) {
                System.out.println(" KO : la liste testee contient des objets de la classe String");
                System.out.println("         Verifiez si votre methode renvoie bien l'element contenu dans le noeud et non le noeud");
                System.exit(0);
            }
            String s = (String) o;
            if (!s.equals("a")) {
                System.out.println(" KO : premier renvoye : " + s);
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste  a change : " + labc);
            }
        } catch (ListeVideException e) {
            System.out.println(" ko, il y a eu ListeVideException : ");
            System.exit(0);
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 2 : listeVide :");
        ListeSimpleImpl<String> listeVide = new ListeSimpleImpl<String>();
        try {
            listeVide.premier();
            System.out.println(" KO, il fallait une ListeVideException");
            System.exit(0);
        } catch (ListeVideException e) {

        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.println("Tous les tests ont reussi!");
    }


    // CONTIENT()
    private static void testContient() {
        System.out.println();
        System.out.println("Tests methode contient()");


        System.out.print("Test 1 : liste a b c : contient a : ");
        String[] tabc = {"a", "b", "c"};
        ListeSimpleImpl<String> labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.contient(new String("a"))) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 3) {
                System.out.println(" KO : taille a change : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste a change : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 2 : liste a b c : contient b : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.contient("b")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 3) {
                System.out.println(" KO : taille a change : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste a change : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 3 : liste a b c : contient c : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (!labc.contient("c")) {
                System.out.println(" KO : booleen renvoye : false!");
                System.exit(0);
            }
            if (labc.taille() != 3) {
                System.out.println(" KO : taille a change : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste a change : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 4 : liste a b c : contient d : ");
        labc = new ListeSimpleImpl<String>(tabc);
        try {
            if (labc.contient("d")) {
                System.out.println(" KO : booleen renvoye : true!");
                System.exit(0);
            }
            if (labc.taille() != 3) {
                System.out.println(" KO : taille a change : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" a b c")) {
                System.out.println(" KO : contenu liste a change : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 5 : listeVide :");
        ListeSimpleImpl<String> listeVide = new ListeSimpleImpl<String>();
        try {
            if (listeVide.contient(new String("a"))) {
                System.out.println(" KO : booleen renvoye : true!");
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");


        System.out.println("Tous les tests ont reussi!");
    }


    // INSERERENTETE()
    private static void testInsererEnTete() {
        System.out.println();
        System.out.println("Tests methode insererEnTete()");

        System.out.print("Test 1 : liste a b c : inserer en tete x : ");
        String[] tabc = {"a", "b", "c"};
        ListeSimpleImpl<String> labc = new ListeSimpleImpl<String>(tabc);
        try {
            labc.insererEnTete("x");
            if (labc.taille() != 4) {
                System.out.println(" KO : taille obtenue : " + labc.taille());
                System.exit(0);
            }
            if (!labc.toString().equals(" x a b c")) {
                System.out.println(" KO : contenu liste obtenu : " + labc);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" ko, il y a eu Exception : ");
            ex.printStackTrace();
            System.exit(0);
        }
        System.out.println(" ok");

        System.out.print("Test 2 : listeVide :");
        ListeSimpleImpl<String> listeVide = new ListeSimpleImpl<String>();
        try {
            listeVide.insererEnTete("a");
            if (listeVide.taille() != 1) {
                System.out.println(" KO : taille obtenue : " + listeVide.taille());
                System.exit(0);
            }
            if (!listeVide.toString().equals(" a")) {
                System.out.println(" KO : contenu liste obtenu : " + listeVide);
                System.exit(0);
            }
        } catch (Exception ex) {
            System.out.println(" KO, il y a eu Exception : ");
            ex.printStackTrace();
            return;
        }
        System.out.println(" ok");
        System.out.println("Tous les tests ont reussi!");
    }

}

	

