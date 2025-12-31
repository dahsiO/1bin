import java.util.Arrays;

public class TestResultats {

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

        System.out.println("***************************************");
        System.out.println("Programme Test pour la classe Resultats");
        System.out.println("***************************************");
        int choix = 0;
        do {
            System.out.println("Menu : ");
            System.out.println("-------");
            System.out.println("1 -> Tester la methode estTrieeEtSansDoublon()");
            System.out.println("2 -> Tester la methode moyenne()");
            System.out.println("3 -> Tester la methode mediane()");
            System.out.println("4 -> Tester la methode nombreEtudiantsDansLIntervalle()");
            System.out.println("5 -> Tester la methode donnerTableEtudiantsEnReussite()");
          
            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testEstTrieeEtSansDoublon();
                    break;
                case 2:
                    testMoyenne();
                    break;
                case 3:
                    testMediane();
                    break;
                case 4:
                    testNombreEtudiantsDansLIntervalle();
                    break;
                case 5:
                    testDonnerTableEtudiantsEnReussite();
                    break;
                default:
                    break;
            }
        } while (choix >= 1 && choix <= 5);

    }

    private static void testEstTrieeEtSansDoublon() {
        System.out.println();
        System.out.println("Methode estTrieeSansDoublon()");
        System.out.println("-----------------------------");
        int numTest = 0;
        Etudiant[] tableTestee;

        //test1
        numTest++;
        System.out.println("Test" + numTest);
        tableTestee = E.t1NonTriee();
        Etudiant[] tableAvantAppel = E.t1NonTriee();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
            if(!(contenuTable(tableTestee).equals(contenuTable(tableAvantAppel)))){
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table passee en parametre");
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
        tableTestee = E.t2NonTriee();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t3NonTriee();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t4TrieeAvecDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t5TrieeAvecDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t6TrieeAvecDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t7NonTrieeAvecDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",false,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t8TrieeSansDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",true,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t9TrieeSansDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",true,Resultats.estTrieeEtSansDoublon(tableTestee));
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
        tableTestee = E.t10TrieeSansDoublon();
        System.out.println(contenuTable(tableTestee));
        try {
            assertEquals("Test" + numTest + " ko : booleen renvoyee ko",true,Resultats.estTrieeEtSansDoublon(tableTestee));
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


    private static void testMoyenne() {
        System.out.println();
        System.out.println("Methode moyenne()");
        System.out.println("-----------------");
        int numTest = 0;
        Resultats resultats;

        //test1
        numTest++;
        resultats = E.r1();
        Resultats avantAppel = E.r1();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 14.0, resultats.moyenne());
            if(!(resultats.toString().equals(avantAppel.toString()))){
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table des etudiants");
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
        resultats = E.rEnonce();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 11.0, resultats.moyenne());
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
        resultats = E.r2();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 5.5, resultats.moyenne());
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
        resultats = E.r4();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 10.0, resultats.moyenne());
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

    private static void testMediane() {
        System.out.println();
        System.out.println("Methode mediane()");
        System.out.println("-----------------");
        int numTest = 0;
        Resultats resultats;

        //test1
        numTest++;
        resultats = E.r1();
        Resultats avantAppel = E.r1();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : mediane ko", 13.0, resultats.mediane());
            if(!(resultats.toString().equals(avantAppel.toString()))){
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table des etudiants");
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
        resultats = E.rEnonce();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : mediane ko", 13.0, resultats.mediane());
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
        resultats = E.rEnonceAvec3X2();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : mediane ko", 13.0, resultats.mediane());
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
        resultats = E.r3();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : mediane ko", 9.5, resultats.mediane());
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
        resultats = E.r4();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : mediane ko", 10.0, resultats.mediane());
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
        resultats = E.r2();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        try {
            assertEquals("Test" + numTest + " ko : mediane ko", 7.5, resultats.mediane());
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

    private static void testNombreEtudiantsDansLIntervalle() {
        System.out.println();
        System.out.println("Methode nombreEtudiantsDansLIntervalle()");
        System.out.println("----------------------------------------");
        int numTest = 0;
        Resultats resultats;
        double borneMin;
        double borneMax;

        //test1
        numTest++;
        System.out.println("Test" + numTest);
        resultats = E.r3();
        Resultats avantAppel = E.r3();
        System.out.println(resultats.toString());
        borneMin = -1;
        borneMax = 21;
        System.out.println("borne min = "+borneMin);
        System.out.println("borne max = "+borneMax);
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", 9, resultats.nombreEtudiantsDansLIntervalle(borneMin,borneMax));
            if(!(resultats.toString().equals(avantAppel.toString()))){
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table des etudiants");
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
        resultats = E.r3();
        System.out.println(resultats.toString());
        borneMin = 3;
        borneMax = 15;
        System.out.println("borne min = "+borneMin);
        System.out.println("borne max = "+borneMax);
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", 7, resultats.nombreEtudiantsDansLIntervalle(borneMin,borneMax));
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
        resultats = E.rEnonce();
        System.out.println(resultats.toString());
        borneMin = 5;
        borneMax = 8;
        System.out.println("borne min = "+borneMin);
        System.out.println("borne max = "+borneMax);
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", 0, resultats.nombreEtudiantsDansLIntervalle(borneMin,borneMax));
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
        resultats = E.r3();
        System.out.println(resultats.toString());
        borneMin = 12;
        borneMax = 17;
        System.out.println("borne min = "+borneMin);
        System.out.println("borne max = "+borneMax);
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", 3, resultats.nombreEtudiantsDansLIntervalle(borneMin,borneMax));
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
        resultats = E.r4();
        System.out.println(resultats.toString());
        borneMin = 10;
        borneMax = 17;
        System.out.println("borne min = "+borneMin);
        System.out.println("borne max = "+borneMax);
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", 1, resultats.nombreEtudiantsDansLIntervalle(borneMin,borneMax));
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
        resultats = E.r4();
        System.out.println(resultats.toString());
        borneMin = 12;
        borneMax = 16;
        System.out.println("borne min = "+borneMin);
        System.out.println("borne max = "+borneMax);
        try {
            assertEquals("Test" + numTest + " ko : nombre renvoye ko", 0, resultats.nombreEtudiantsDansLIntervalle(borneMin,borneMax));
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

    private static void testDonnerTableEtudiantsEnReussite() {
        System.out.println();
        System.out.println("Methode tableEtudiantsEnReussite()");
        System.out.println("----------------------------------");
        int numTest = 0;
        Resultats resultats;

        //test1
        numTest++;
        resultats = E.r1();
        Resultats avantAppel = E.r1();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        Etudiant[] tableAttendue = E.t1Valides();
        try {
            Etudiant[] tableRecue = resultats.donnerTableEtudiantsEnReussite();
            if(tableRecue==null){
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko",tableAttendue.length , tableRecue.length);
            if(!(Arrays.toString(tableAttendue).equals(Arrays.toString(tableRecue)))){
                System.out.println("-->Test" + numTest + " ko : contenu table renvoyee ko");
                System.out.println("attendu=");
                System.out.println(contenuTable(tableAttendue));
                System.out.println("recu=");
                System.out.println(contenuTable(tableRecue));
                System.exit(0);
            }
            if(!(resultats.toString().equals(avantAppel.toString()))){
                System.out.println("Test" + numTest + " ko : ");
                System.out.println("Cette methode ne peut pas modifier la table des etudiants");
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
        resultats = E.rEnonce();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        tableAttendue = E.tEnonceValides();
        try {
            Etudiant[] tableRecue = resultats.donnerTableEtudiantsEnReussite();
            if(tableRecue==null){
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko",tableAttendue.length , tableRecue.length);
            if(!(Arrays.toString(tableAttendue).equals(Arrays.toString(tableRecue)))){
                System.out.println("-->Test" + numTest + " ko : contenu table renvoyee ko");
                System.out.println("attendu=");
                System.out.println(contenuTable(tableAttendue));
                System.out.println("recu=");
                System.out.println(contenuTable(tableRecue));
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

        //test3
        numTest++;
        resultats = E.r3();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        tableAttendue = E.t3Valides();
        try {
            Etudiant[] tableRecue = resultats.donnerTableEtudiantsEnReussite();
            if(tableRecue==null){
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko",tableAttendue.length , tableRecue.length);
            if(!(Arrays.toString(tableAttendue).equals(Arrays.toString(tableRecue)))){
                System.out.println("-->Test" + numTest + " ko : contenu table renvoyee ko");
                System.out.println("attendu=");
                System.out.println(contenuTable(tableAttendue));
                System.out.println("recu=");
                System.out.println(contenuTable(tableRecue));
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

        //test4
        numTest++;
        resultats = E.r2();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        tableAttendue = E.t2Valides();
        try {
            Etudiant[] tableRecue = resultats.donnerTableEtudiantsEnReussite();
            if(tableRecue==null){
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko",tableAttendue.length , tableRecue.length);
            if(!(Arrays.toString(tableAttendue).equals(Arrays.toString(tableRecue)))){
                System.out.println("-->Test" + numTest + " ko : contenu table renvoyee ko");
                System.out.println("attendu=");
                System.out.println(contenuTable(tableAttendue));
                System.out.println("recu=");
                System.out.println(contenuTable(tableRecue));
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

        //test5
        numTest++;
        resultats = E.r4();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        tableAttendue = E.t4Valides();
        try {
            Etudiant[] tableRecue = resultats.donnerTableEtudiantsEnReussite();
            if(tableRecue==null){
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko",tableAttendue.length , tableRecue.length);
            if(!(Arrays.toString(tableAttendue).equals(Arrays.toString(tableRecue)))){
                System.out.println("-->Test" + numTest + " ko : contenu table renvoyee ko");
                System.out.println("attendu=");
                System.out.println(contenuTable(tableAttendue));
                System.out.println("recu=");
                System.out.println(contenuTable(tableRecue));
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

        //test6
        numTest++;
        resultats = E.r5();
        System.out.println("Test" + numTest);
        System.out.println(resultats.toString());
        tableAttendue = E.t5Valides();
        try {
            Etudiant[] tableRecue = resultats.donnerTableEtudiantsEnReussite();
            if(tableRecue==null){
                System.out.println("Test" + numTest + " ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " ko : taille table renvoyee ko",tableAttendue.length , tableRecue.length);
            if(!(Arrays.toString(tableAttendue).equals(Arrays.toString(tableRecue)))){
                System.out.println("-->Test" + numTest + " ko : contenu table renvoyee ko");
                System.out.println("attendu=");
                System.out.println(contenuTable(tableAttendue));
                System.out.println("recu=");
                System.out.println(contenuTable(tableRecue));
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

        System.out.println("Tous les tests ont reussi !");
        System.out.println();
    }

    private static String contenuTable(Etudiant[] tableAAfficher){
        String aRenvoyer = "matricule  nom    points";
        for (int i = 0; i < tableAAfficher.length; i++) {
            aRenvoyer+="\n"+tableAAfficher[i];
        }
        return aRenvoyer;
    }

}
