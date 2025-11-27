import java.util.Arrays;

@SuppressWarnings("CallToPrintStackTrace")
public class TestTemperatures {

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

        System.out.println("******************************************");
        System.out.println("Programme Test pour la classe Temperatures");
        System.out.println("******************************************");
        int choix;

        System.out.println("1 -> Tester la methode moyenne()");
        System.out.println("2 -> Tester la methode temperatureMin()");
        System.out.println("3 -> Tester la methode temperatureMax()");
        System.out.println("4 -> Tester la methode ecartMax()");
        System.out.println("5 -> Tester la methode ecartMaxSucc()");
        System.out.println("6 -> Tester la methode nombreJourDeGel()");
        System.out.println("7 -> Tester la methode joursDeGel()");

        System.out.println();
        System.out.print("Entrez votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testMoyenne();
                break;
            case 2:
                testTemperatureMin();
                break;
            case 3:
                testTemperatureMax();
                break;
            case 4:
                testEcartMax();
                break;
            case 5:
                testEcartMaxSucc();
                break;
            case 6:
                testNombreJoursDeGel();
                break;
            case 7:
                testJoursDeGel();
                break;

            default:
                break;
        }
    }


    private static void testMoyenne() {
        int numTest;
        Temperatures temperatures;

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 0.5, temperatures.moyenne());
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : moyenne ko", 3.0, temperatures.moyenne());
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

    private static void testTemperatureMin() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : min ko", -4.0, temperatures.temperatureMin());
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures2();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : min ko", -5.0, temperatures.temperatureMin());
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

        numTest = 3;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : min ko", 1.0, temperatures.temperatureMin());
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

    private static void testTemperatureMax() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures2();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : max ko", 4.0, temperatures.temperatureMax());
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : max ko", 5.0, temperatures.temperatureMax());
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

        numTest = 3;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : max ko", 5.0, temperatures.temperatureMax());
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


    private static void testEcartMax() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures5();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max ko", 3.0, temperatures.ecartMax());
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures6();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max ko", 5.0, temperatures.ecartMax());
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

        numTest = 3;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max ko", 4.0, temperatures.ecartMax());
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

        numTest = 4;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures2();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max ko", 9.0, temperatures.ecartMax());
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

    private static void testEcartMaxSucc() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures7();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max succ ko", 3.0, temperatures.ecartMaxSucc());
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures8();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max succ ko", 5.0, temperatures.ecartMaxSucc());
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

        numTest = 3;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures9();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max succ ko", 7.0, temperatures.ecartMaxSucc());
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

        numTest = 4;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures10();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : ecart max succ ko", 3.0, temperatures.ecartMaxSucc());
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


    private static void testNombreJoursDeGel() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : nombre jours gel ko", 2, temperatures.nombreJoursDeGel());
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : nombre jours gel ko", 5, temperatures.nombreJoursDeGel());
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

        numTest = 3;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures);
        try {
            assertEquals("Test" + numTest + " ko : nombre jours gel ko", 0, temperatures.nombreJoursDeGel());
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

    private static void testJoursDeGel() {
        int numTest;
        Temperatures temperatures;
        System.out.println();

        numTest = 1;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures1();
        System.out.println(temperatures);
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if (tableRecue == null) {
                System.out.println("test" + numTest + "ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {1, 3};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        numTest = 2;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures2();
        System.out.println(temperatures);
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if (tableRecue == null) {
                System.out.println("test" + numTest + "ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {2, 4};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        numTest = 3;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures3();
        System.out.println(temperatures);
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if (tableRecue == null) {
                System.out.println("test" + numTest + "ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

        numTest = 4;
        System.out.println("Test" + numTest);
        temperatures = chargerTemperatures4();
        System.out.println(temperatures);
        try {
            int[] tableRecue = temperatures.joursDeGel();
            if (tableRecue == null) {
                System.out.println("test" + numTest + "ko : table renvoyee null");
                System.exit(0);
            }
            int[] tableAttendue = {1, 2, 3, 4, 5};
            assertEquals("Test" + numTest + " ko : taille physique ko", tableAttendue.length, tableRecue.length);
            assertEquals("Test" + numTest + " ko : contenu table ko", Arrays.toString(tableAttendue), Arrays.toString(tableRecue));
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

    public static Temperatures chargerTemperatures1() {
        double[] tableTemperatures = {-2, 3, -4, 5};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures2() {
        double[] tableTemperatures = {2, -3, 4, -5};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures3() {
        double[] tableTemperatures = {5, 2, 3, 4, 1};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures4() {
        double[] tableTemperatures = {-1, -2, -3, -4, -5};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures5() {
        double[] tableTemperatures = {5, 6, 4, 6, 7, 5};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures6() {
        double[] tableTemperatures = {5, 6, 9, 6, 4, 5};
        return new Temperatures("Table testee", tableTemperatures);
    }


    public static Temperatures chargerTemperatures7() {
        double[] tableTemperatures = {5, 7, 4, 6, 7, 5};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures8() {
        double[] tableTemperatures = {2, 7, 4, 6, 7, 5};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures9() {
        double[] tableTemperatures = {2, 7, 4, 6, 7, 0};
        return new Temperatures("Table testee", tableTemperatures);
    }

    public static Temperatures chargerTemperatures10() {
        double[] tableTemperatures = {2, 5};
        return new Temperatures("Table testee", tableTemperatures);
    }

}
