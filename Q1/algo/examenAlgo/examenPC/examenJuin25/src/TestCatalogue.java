import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;

public class TestCatalogue {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    static Class classe = Catalogue.class;
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

        System.out.println("***************************************");
        System.out.println("Programme Test pour la classe Catalogue");
        System.out.println("***************************************");
        int choix = 0;
        t = classe.getDeclaredField("tableArticles");
        t.setAccessible(true);
        taille = classe.getDeclaredField("nombreArticles");
        taille.setAccessible(true);
        do {
            System.out.println("Menu");
            System.out.println("----");
            System.out.println("1 -> Tester le constructeur");
            System.out.println("2 -> Tester la methode donnerPrix()");
            System.out.println("3 -> Tester la methode supprimerArticle()");
            System.out.println("4 -> Tester la methode minMax()");
            System.out.println("5 -> Tester la methode nombreArticlesDansLIntervalle()");

            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testConstructeur();
                    break;
                case 2:
                    testDonnerPrix();
                    break;
                case 3:
                    testSupprimerArticle();
                    break;
                case 4:
                    testMinMax();
                    break;
                case 5:
                    testNombreArticlesDansLIntervalle();
                    break;
                default:
                    break;
            }
        } while (choix >= 1 && choix <= 5);

    }


    private static void testConstructeur() throws IllegalArgumentException, IllegalAccessException {
        //TODO
        System.out.println();
        System.out.println("constructeur");
        System.out.println("------------");

        int numTest = 0;

        Catalogue cata;
        Article[] tableRecue;
        Article[] tableAttendue;
        int nombreArticlesAttendu;


        //test1
        numTest++;
        System.out.println("Test" + numTest);

        tableRecue = C.t1();
        tableAttendue = C.t1();
        nombreArticlesAttendu = C.n1();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            //test ordre des articles tel algo impose
            HashSet<String> ensembleAttendu = new HashSet<>();
            for (Article a : tableAttendue) {
                if (a != null)
                    ensembleAttendu.add(a.toString());
            }
            HashSet<String> ensembleApresAppel = new HashSet<>();
            for (Article a : tableApresAppel) {
                if (a != null)
                    ensembleApresAppel.add(a.toString());
            }
            if (tableApresAppel.length == tableAttendue.length && nombreArticlesAttendu == cata.getNombreArticles() && !(Arrays.toString(tableAttendue).equals(Arrays.toString(tableApresAppel))) && ensembleApresAppel.equals(ensembleAttendu)) {
                System.out.println("Test" + numTest + " ko");
                System.out.println("Le contenu de la table est ok, mais l'ordre des articles n'est pas l'ordre attendu en suivant l'algo propose");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();


        //test2
        numTest++;
        System.out.println("Test" + numTest + " (exemple de l'enonce)");

        tableRecue = C.tableRecueEnonce();
        tableAttendue = C.tableAttendueEnonce();
        nombreArticlesAttendu = C.nEnonce();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            //test ordre des articles tel algo impose
            HashSet<Article> ensembleAttendu = new HashSet<>();
            for (Article a : tableAttendue) {
                ensembleAttendu.add(a);
            }
            HashSet<Article> ensembleApresAppel = new HashSet<>();
            for (Article a : tableApresAppel) {
                ensembleApresAppel.add(a);
            }
            if (tableApresAppel.length == tableAttendue.length && nombreArticlesAttendu == cata.getNombreArticles() && !(Arrays.toString(tableAttendue).equals(Arrays.toString(tableApresAppel)) && ensembleApresAppel.equals(ensembleAttendu))) {
                System.out.println("Test" + numTest + " ko");
                System.out.println("Le contenu de la table est ok, mais l'ordre des articles n'est pas l'ordre attendu en suivant l'algo propose");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test3
        numTest++;
        System.out.println("Test" + numTest);
        tableRecue = C.tableRecueCroissant();
        tableAttendue = C.tableCrDeCr();
        nombreArticlesAttendu = C.nCrDecr();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test4
        numTest++;
        System.out.println("Test" + numTest);
        tableRecue = C.tableRecueDeCroissant();
        tableAttendue = C.tableCrDeCr();
        nombreArticlesAttendu = C.nCrDecr();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test5
        numTest++;
        System.out.println("Test" + numTest);
        tableRecue = C.tableRecueMelUn();
        tableAttendue = C.tableUn();
        nombreArticlesAttendu = C.nUn();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test6
        numTest++;
        System.out.println("Test" + numTest);
        tableRecue = C.tableRecueCroissantUn();
        tableAttendue = C.tableUn();
        nombreArticlesAttendu = C.nUn();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test7
        numTest++;
        System.out.println("Test" + numTest);
        tableRecue = C.tableRecueDeCroissantUn();
        tableAttendue = C.tableUn();
        nombreArticlesAttendu = C.nUn();

        System.out.print("tableRecue : ");
        System.out.println(Arrays.toString(tableRecue));

        System.out.println("appel : Catalogue(tableRecue)");
        try {
            cata = new Catalogue(tableRecue);

            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            if (tableApresAppel.length != tableRecue.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles ko");
                System.out.println("Remettez l'instruction : tableArticles = new Article[tableRecue.length];");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu tableArticles ko", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticlesAttendu, cata.getNombreArticles());

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testDonnerPrix() throws IllegalArgumentException, IllegalAccessException {

        System.out.println();
        System.out.println("Methode donnerPrix()");
        System.out.println("--------------------");

        int numTest = 0;

        Catalogue cata;
        Article[] tableTestee;
        Article[] tableAvantAppel;
        int nombreArticles;
        int numeroArticleTeste;
        double prixAttendu;

        //test1
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        tableAvantAppel = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 999;
        prixAttendu = 5;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (!(Arrays.toString(tableAvantAppel).equals(Arrays.toString(tableApresAppel)))) {
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table courante");
                System.exit(0);
            }
            if (cata.getNombreArticles() != nombreArticles) {
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier le nombre d'articles");
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test2
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 123;
        prixAttendu = 14;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test3
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 321;
        prixAttendu = 12;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test4
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 714;
        prixAttendu = 9.5;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test5
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 456;
        prixAttendu = -1;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test6
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 999;
        prixAttendu = 5;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test7
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 555;
        prixAttendu = 5;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test8
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 987;
        prixAttendu = -1;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test9
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tableUn();
        nombreArticles = C.nUn();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 123;
        prixAttendu = 15;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test10
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tableUn();
        nombreArticles = C.nUn();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 876;
        prixAttendu = -1;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test11
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tVide();
        nombreArticles = C.nVide();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        numeroArticleTeste = 543;
        prixAttendu = -1;
        System.out.println("appel : donnerPrix(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : prix renvoye ko", prixAttendu, cata.donnerPrix(numeroArticleTeste));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testSupprimerArticle() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        System.out.println("Methode supprimerArticle()");
        System.out.println("--------------------------");

        int numTest = 0;

        Catalogue cata;
        Article[] tableTestee;
        int nombreArticles;
        int numeroArticleTeste;


        //test1
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 999;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", true, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles - 1, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " ko : tableArticles est devenue null");
                System.exit(0);
            }
            if (tableApresAppel.length != tableTestee.length) {
                System.out.println("Test" + numTest + " ko : taille physique tableArticles a ete modifiee");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.t1Moins999V1()), Arrays.toString(C.t1Moins999V2()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test2
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 123;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", true, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles - 1, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.t1Moins123V1()), Arrays.toString(C.t1Moins123V2()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test3
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 321;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", true, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles - 1, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.t1Moins321V1()), Arrays.toString(C.t1Moins321V2()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test4
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 375;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", false, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.t1()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test5
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 123;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", true, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles - 1, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.t2Moins123V1()), Arrays.toString(C.t2Moins123V2()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test6
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 555;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", true, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles - 1, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.t2Moins555V1()), Arrays.toString(C.t2Moins555V2()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test7
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tableUn();
        nombreArticles = C.nUn();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 123;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", true, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles - 1, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.tableUnMoins123V1()), Arrays.toString(C.tableUnMoins123V2()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test8
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tableUn();
        nombreArticles = C.nUn();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 432;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", false, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.tableUn()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test9
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tVide();
        nombreArticles = C.nVide();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        numeroArticleTeste = 123;

        System.out.println("appel : supprimer(" + numeroArticleTeste + ")");
        try {
            assertEquals("Test" + numTest + " ko : boolean renvoye ko", false, cata.supprimerArticle(numeroArticleTeste));
            assertEquals("Test" + numTest + " ko : nombreArticles ko", nombreArticles, cata.getNombreArticles());
            Article[] tableApresAppel = (Article[]) t.get(cata);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(C.tVide()), Arrays.toString(tableApresAppel));

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();


        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testMinMax() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        System.out.println("Methode minMax()");
        System.out.println("----------------");

        int numTest = 0;

        Catalogue cata;
        Article[] tableTestee;
        Article[] tableAvantAppel;
        Article[] tableMinMax;
        int nombreArticles;

        //test1
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        tableAvantAppel = C.t1();
        nombreArticles = C.n1();
        tableMinMax = C.tableMinMax1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (!(Arrays.toString(tableAvantAppel).equals(Arrays.toString(tableApresAppel)))) {
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table courante");
                System.exit(0);
            }
            if (cata.getNombreArticles() != nombreArticles) {
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier le nombre d'articles");
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test2
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1Bis();
        nombreArticles = C.n1();
        tableMinMax = C.tableMinMax1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test3
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1Croissant();
        nombreArticles = C.n1();
        tableMinMax = C.tableMinMax1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test4
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1Decroissant();
        nombreArticles = C.n1();
        tableMinMax = C.tableMinMax1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();


        //test5
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        tableMinMax = C.tableMinMax2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test6
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2Melange();
        nombreArticles = C.n2();
        tableMinMax = C.tableMinMax2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test7
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t3();
        nombreArticles = C.n3();
        tableMinMax = C.tableMinMax3();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test8
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t4();
        nombreArticles = C.n4();
        tableMinMax = C.tableMinMax4();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test9
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tVide();
        nombreArticles = C.nVide();
        tableMinMax = C.tableMinMax5();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);

        System.out.println("appel : minMax()");
        try {
            Article[] tableMinMaxRecue = cata.minMax();
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableMinMax), Arrays.toString(tableMinMaxRecue));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();


        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static void testNombreArticlesDansLIntervalle() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        System.out.println("Methode nombreArticlesDansLIntervalle()");
        System.out.println("---------------------------------------");

        int numTest = 0;

        Catalogue cata;
        Article[] tableTestee;
        Article[] tableAvantAppel;
        int nombreArticles;
        double borneMin;
        double borneMax;
        int nombreAttendu;

        //test1
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        tableAvantAppel = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 4;
        borneMax = 11;
        nombreAttendu = 2;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
            Article[] tableApresAppel = (Article[]) t.get(cata);
            if (!(Arrays.toString(tableAvantAppel).equals(Arrays.toString(tableApresAppel)))) {
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table courante");
                System.exit(0);
            }
            if (cata.getNombreArticles() != nombreArticles) {
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier le nombre d'articles");
                System.exit(0);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test2
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1();
        tableAvantAppel = C.t1();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 5;
        borneMax = 12;
        nombreAttendu = 3;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test3
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t1Bis();
        nombreArticles = C.n1();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 1;
        borneMax = 20;
        nombreAttendu = 4;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test4
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 1;
        borneMax = 3;
        nombreAttendu = 0;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test5
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 1;
        borneMax = 5;
        nombreAttendu = 2;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test6
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 12;
        borneMax = 12;
        nombreAttendu = 2;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test7
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.t2();
        nombreArticles = C.n2();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 7;
        borneMax = 7;
        nombreAttendu = 0;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        //test8
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tableUn();
        nombreArticles = C.nUn();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 15;
        borneMax = 15;
        nombreAttendu = 1;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();


        //test9
        numTest++;
        System.out.println("Test" + numTest);

        tableTestee = C.tVide();
        nombreArticles = C.nVide();
        cata = new Catalogue();
        taille.setInt(cata, nombreArticles);
        t.set(cata, tableTestee);

        System.out.print("tableArticles : ");
        System.out.println(Arrays.toString(tableTestee));
        System.out.print("nombreArticles : ");
        System.out.println(nombreArticles);
        borneMin = 8;
        borneMax = 15;
        nombreAttendu = 0;
        System.out.println("appel : nombreArticlesDansIntervalle(" + borneMin + "," + borneMax + ")");
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", nombreAttendu, cata.nombreArticlesDansLIntervalle(borneMin, borneMax));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Test" + numTest + " ko : il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

}
