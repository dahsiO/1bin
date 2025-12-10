import java.util.Arrays;

public class TestEquipeGuerriers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

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
                System.out.println("-->" + messageErreur + ". Attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println("-->" + messageErreur + ". Attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }


    public static void main(String[] args) {

        System.out.println("*********************************************");
        System.out.println("Programme Test pour la classe EquipeGuerriers");
        System.out.println("*********************************************");
        int choix = 0;

        System.out.println("Menu : ");
        System.out.println("-------");
        System.out.println("1 -> Tester la methode nombreGuerriersEnVie()");
        System.out.println("2 -> Tester la methode auMoins1GuerrierEnVie()");
        System.out.println("3 -> Tester la methode premierGuerrierEnVie()");
        System.out.println("4 -> Tester la methode getPointsDeVie()");
        System.out.println("5 -> Tester la methode donnerTableGuerriersEnVie()");
        System.out.println();
        System.out.print("Entrez votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testNombreGuerriersEnVie();
                break;
            case 2:
                testAuMoins1GuerrierEnVie();
                break;
            case 3:
                testPremierGuerrierEnVie();
                break;
            case 4:
                testGetPointsDeVie();
                break;
            case 5:
                testDonnerTableGuerriersEnVie();
                break;
            default:
                break;
        }
    }

    private static void testNombreGuerriersEnVie() {
        System.out.println();
        System.out.println("Methode nombreGuerriersEnVie()");
        System.out.println("------------------------------");
        int numTest;
        EquipeGuerriers equipe = E.eq1();
        numTest = 1;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 3, equipe.nombreGuerriersEnVie());
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

        equipe = E.eq2();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 0, equipe.nombreGuerriersEnVie());
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

        equipe = E.eq3();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 4, equipe.nombreGuerriersEnVie());
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

        equipe = E.eq4();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 3, equipe.nombreGuerriersEnVie());
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

        equipe = E.eq5();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 3, equipe.nombreGuerriersEnVie());
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

        equipe = E.eq6();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 3, equipe.nombreGuerriersEnVie());
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

        equipe = E.eqVide();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : nombre guerriers en vie ko", 0, equipe.nombreGuerriersEnVie());
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

    private static void testAuMoins1GuerrierEnVie() {
        System.out.println();
        System.out.println("Methode AuMoins1GuerrierEnVie()");
        System.out.println("-------------------------------");
        int numTest;
        EquipeGuerriers equipe = E.eq1();
        numTest = 1;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", true, equipe.auMoins1GuerrierEnVie());
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

        equipe = E.eq2();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", false, equipe.auMoins1GuerrierEnVie());
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

        equipe = E.eq3();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", true, equipe.auMoins1GuerrierEnVie());
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

        equipe = E.eq4();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", true, equipe.auMoins1GuerrierEnVie());
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

        equipe = E.eq5();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", true, equipe.auMoins1GuerrierEnVie());
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

        equipe = E.eq6();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", true, equipe.auMoins1GuerrierEnVie());
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

        equipe = E.eqVide();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoye ko", false, equipe.auMoins1GuerrierEnVie());
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

    private static void testPremierGuerrierEnVie() {
        System.out.println();
        System.out.println("Methode PremierGuerrierEnVie()");
        System.out.println("------------------------------");
        int numTest;
        EquipeGuerriers equipe = E.eq1();
        numTest = 1;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", new Guerrier("eva", 8), guerrier);
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

        equipe = E.eq2();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", null, guerrier);
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

        equipe = E.eq3();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", new Guerrier("eva", 8), guerrier);
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

        equipe = E.eq4();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", new Guerrier("eva", 8), guerrier);
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

        equipe = E.eq5();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", new Guerrier("tim", 9), guerrier);
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

        equipe = E.eq6();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", new Guerrier("sam", 5), guerrier);
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

        equipe = E.eqVide();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier guerrier = equipe.premierGuerrierEnVie();
            assertEquals("Test" + numTest + " ko: guerrier renvoye", null, guerrier);
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


    private static void testGetPointsDeVie() {
        System.out.println();
        System.out.println("Methode getPointsDeVie()");
        System.out.println("------------------------");
        int numTest;
        EquipeGuerriers equipe = E.eq3();
        String nomGuerrier = new String("tim");
        numTest = 1;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        System.out.println("Le nom du guerrier recherche : " + nomGuerrier);
        try {
            assertEquals("Test" + numTest + " ko : nombre points de vie ko", 9, equipe.getPointsDeVie(nomGuerrier));
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

        equipe = E.eq3();
        nomGuerrier = new String("max");
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        System.out.println("Le nom du guerrier recherche : " + nomGuerrier);
        try {
            assertEquals("Test" + numTest + " ko : nombre points de vie ko", 3, equipe.getPointsDeVie(nomGuerrier));
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

        equipe = E.eq3();
        nomGuerrier = new String("eva");
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        System.out.println("Le nom du guerrier recherche : " + nomGuerrier);
        try {
            assertEquals("Test" + numTest + " ko : nombre points de vie ko", 8, equipe.getPointsDeVie(nomGuerrier));
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

        equipe = E.eq3();
        nomGuerrier = new String("loic");
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        System.out.println("Le nom du guerrier recherche : " + nomGuerrier);
        try {
            assertEquals("Test" + numTest + " ko : nombre points de vie ko", -1, equipe.getPointsDeVie(nomGuerrier));
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

        equipe = E.eq7();
        nomGuerrier = new String("leo");
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        System.out.println("Le nom du guerrier recherche : " + nomGuerrier);
        try {
            assertEquals("Test" + numTest + " ko : nombre points de vie ko", 0, equipe.getPointsDeVie(nomGuerrier));
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

        equipe = E.eqVide();
        nomGuerrier = new String("loic");
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        System.out.println("Le nom du guerrier recherche : " + nomGuerrier);
        try {
            assertEquals("Test" + numTest + " ko : nombre points de vie ko", -1, equipe.getPointsDeVie(nomGuerrier));
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

    private static void testDonnerTableGuerriersEnVie() {
        System.out.println();
        System.out.println("Methode tableGuerriersEnVie()");
        System.out.println("-----------------------------");
        int numTest;
        EquipeGuerriers equipe = E.eq1();
        Guerrier[] tableAttendue = E.t1EnVie();
        numTest = 1;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }

            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eq3();
        tableAttendue = E.t3EnVie();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }

            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eq4();
        tableAttendue = E.t4EnVie();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eq5();
        tableAttendue = E.t5EnVie();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eq6();
        tableAttendue = E.t6EnVie();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eq7();
        tableAttendue = E.t7EnVie();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eq2();
        tableAttendue = E.tVide();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        equipe = E.eqVide();
        tableAttendue = E.tVide();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("L'equipe testee : " + equipe.toString());
        try {
            Guerrier[] tableRecue = equipe.donnerTableGuerriersEnVie();
            if (tableRecue == null) {
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table renvoyee ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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


