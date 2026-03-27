import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestEnsembleTableHashing {
    private static Scanner scanner = new Scanner(System.in);

    static Class classe = EnsembleTableHashing.class;
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

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        System.out.println("**************************************************");
        System.out.println("Programme Test pour la classe EnsembleTableHashing");
        System.out.println("**************************************************");

        t = classe.getDeclaredField("tableListes");
        t.setAccessible(true);
        taille = classe.getDeclaredField("taille");
        taille.setAccessible(true);

        System.out.println("1 -> Tester le constructeur");
        System.out.println("2 -> Tester la methode contient");
        System.out.println("3 -> Tester la methode ajouter");
        System.out.println("4 -> Tester la methode enlever");
        System.out.println();

        System.out.print("Entrez votre choix : ");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testConstructeur();
                break;
            case 2:
                testContient();
                break;
            case 3:
                testAjouter();
                break;
            case 4:
                testEnlever();
                break;
        }
    }

    private static void testConstructeur() throws IllegalArgumentException, IllegalAccessException {

        System.out.println();
        Ensemble<Entier> ensemble;
        int capacite;
        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        capacite = 3;
        System.out.println("capacite : " + capacite);
        try {
            ensemble = new EnsembleTableHashing<>(capacite);
            assertEquals("Test" + numTest + " : ko  attribut taille ko : ", 0, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimple[]) t.get(ensemble);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " : ko : attribut tableListes ko : null");
                System.out.println("Avez-vous cree (new) tableListes ?");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " : ko  capacite tableListes ko : ", capacite, tableApresAppel.length);
            if (tableApresAppel[0] == null) {
                System.out.println("Test" + numTest + " : ko : liste a l'indice 0 de tableListes : null");
                System.exit(0);
                System.out.println("Avez-vous cree les listes ?");
            }
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(tVide(capacite)), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 2
        numTest++;
        System.out.println("Test" + numTest);
        capacite = 8;
        System.out.println("capacite : " + capacite);
        try {
            ensemble = new EnsembleTableHashing<>(capacite);
            assertEquals("Test" + numTest + " : ko  attribut taille ko : ", 0, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimple[]) t.get(ensemble);
            if (tableApresAppel == null) {
                System.out.println("Test" + numTest + " : ko : attribut tableListes ko : null");
                System.out.println("Avez-vous cree (new) tableListes ?");
                System.exit(0);
            }
            assertEquals("Test" + numTest + " : ko  capacite tableListes ko : ", capacite, tableApresAppel.length);
            if (tableApresAppel[0] == null) {
                System.out.println("Test" + numTest + " : ko : liste a l'indice 0 de tableListes : null");
                System.exit(0);
                System.out.println("Avez-vous cree les listes ?");
            }
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(tVide(capacite)), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        capacite = 0;
        System.out.println("capacite : " + capacite);
        try {
            new EnsembleTableHashing<>(capacite);
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);
        } catch (IllegalArgumentException e) {
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi!");
    }

    private static void testContient() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        Ensemble<Entier> ensemble;
        int entierTeste;

        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 7);
        t.set(ensemble, t1235111415());
        System.out.println("Ensemble {1,2,3,5,11,14,15}");
        entierTeste = 1;
        Entier entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", true, ensemble.contient(entier));
            ListeSimple[] tableApresAppel = (ListeSimple[]) t.get(ensemble);
            if(!Arrays.toString(t1235111415()).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la methode contient() ne peut pas modifier la table de listes");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 2
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 7);
        t.set(ensemble, t1235111415());
        System.out.println("Ensemble {1,2,3,5,11,14,15}");
        entierTeste = 15;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", true, ensemble.contient(entier));
            ListeSimple[] tableApresAppel = (ListeSimple[]) t.get(ensemble);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 7);
        t.set(ensemble, t1235111415());
        System.out.println("Ensemble {1,2,3,5,11,14,15}");
        entierTeste = 2;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", true, ensemble.contient(entier));
            ListeSimple[] tableApresAppel = (ListeSimple[]) t.get(ensemble);
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 4
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 7);
        t.set(ensemble, t1235111415());
        System.out.println("Ensemble {1,2,3,5,11,14,15}");
        entierTeste = 12;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", false, ensemble.contient(entier));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 5
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t125());
        System.out.println("Ensemble {1,2,5}");
        entierTeste = 5;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", true, ensemble.contient(entier));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 6
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t125());
        System.out.println("Ensemble {1,2,5}");
        entierTeste = 3;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", false, ensemble.contient(entier));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 7
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 6);
        t.set(ensemble, tMoins11251114());
        System.out.println("Ensemble {-1,1,2,5,11,14}");
        entierTeste = -1;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", true, ensemble.contient(entier));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 8
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 7);
        t.set(ensemble, t1235111415());
        System.out.println("Ensemble {1,2,3,5,11,14,15}");
        entierTeste = -2;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", false, ensemble.contient(entier));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 9
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tVide(7));
        System.out.println("Ensemble {}");
        entierTeste = 5;
        entier = new Entier(entierTeste);
        System.out.println("contient "+entierTeste+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", false, ensemble.contient(entier));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("Tous les tests ont reussi!");
    }

    private static void testAjouter() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();

        Ensemble<Entier> ensemble;
        int numTest = 0;
        int entierTeste;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t235());
        System.out.println("Ensemble {2,3,5}");
        entierTeste = 1;
        Entier entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",4, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t1235()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 2
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t235());
        System.out.println("Ensemble {2,3,5}");
        entierTeste = 11;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",4, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t23511()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t235());
        System.out.println("Ensemble {2,3,5}");
        entierTeste = 3;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t235()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 4
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 6);
        t.set(ensemble, t1235111415());
        System.out.println("Ensemble {2,3,5,11,14,15}");
        entierTeste = 6;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",7, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t12356111415()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 5
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t125());
        System.out.println("Ensemble {1,2,5}");
        entierTeste = 5;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t125()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 6
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, t125());
        System.out.println("Ensemble {1,2,5}");
        entierTeste = -5;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",4, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t125Moins5()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 7
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 6);
        t.set(ensemble, tMoins11251114());
        System.out.println("Ensemble {-1,1,2,5,11,14}");
        entierTeste = -1;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",6, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(tMoins11251114()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();



        //test 8
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tVide(8));
        System.out.println("Ensemble {}");
        entierTeste = 14;
        entier = new Entier(entierTeste);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",1, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t14()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();



        System.out.println("Tous les tests ont reussi!");
    }

    private static void testEnlever() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();

        Ensemble<Entier> ensemble;
        int numTest = 0;
        int entierTeste;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 4);
        t.set(ensemble, t1235());
        System.out.println("Ensemble {1,2,3,5}");
        entierTeste = 1;
        Entier entier = new Entier(entierTeste);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t235()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 2
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 4);
        t.set(ensemble, t23511());
        System.out.println("Ensemble {2,3,5,11}");
        entierTeste = 11;
        entier = new Entier(entierTeste);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t235()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble,7);
        t.set(ensemble, t12356111415());
        System.out.println("Ensemble {2,3,5,6,11,14,15}");
        entierTeste = 6;
        entier = new Entier(entierTeste);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",6, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t1235111415()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 4
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble,7);
        t.set(ensemble, t12356111415());
        System.out.println("Ensemble {2,3,5,6,11,14,15}");
        entierTeste = 8;
        entier = new Entier(entierTeste);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",7, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t12356111415()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 5
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble, 4);
        t.set(ensemble, t125Moins5());
        System.out.println("Ensemble {-5,1,2,5}");
        entierTeste = -5;
        entier = new Entier(entierTeste);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(t125()), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        //test 6
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableHashing<Entier>();
        taille.setInt(ensemble,0);
        t.set(ensemble, tVide(9));
        System.out.println("Ensemble {}");
        entierTeste = 11;
        entier = new Entier(entierTeste);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",0, taille.getInt(ensemble));
            ListeSimple[] tableApresAppel = (ListeSimpleImpl[]) t.get(ensemble);
            assertEquals("Test" + numTest + " : ko  contenu tableListes ko : ", Arrays.toString(tVide(9)), Arrays.toString(tableApresAppel));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " : ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " : ok");
        System.out.println();



        System.out.println("Tous les tests ont reussi!");
    }

    public static ListeSimple[] tVide(int capacite) {
        ListeSimple[] tVide = new ListeSimpleImpl[capacite];
        for (int i = 0; i < capacite; i++) {
            tVide[i] = new ListeSimpleImpl();
        }
        return tVide;
    }

    public static ListeSimple[] t14() {
        ListeSimple[] t = new ListeSimpleImpl[8];
        for (int i = 0; i < 8; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[6].insererEnTete(14);
        return t;
    }

    public static ListeSimple[] t1235111415() {
        ListeSimple[] t = new ListeSimpleImpl[3];
        for (int i = 0; i < 3; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[1].insererEnTete(new Entier(1));
        t[2].insererEnTete(new Entier(2));
        t[0].insererEnTete(new Entier(3));
        t[2].insererEnTete(new Entier(5));
        t[2].insererEnTete(new Entier(11));
        t[2].insererEnTete(new Entier(14));
        t[0].insererEnTete(new Entier(15));
        return t;
    }

    public static ListeSimple[] t12356111415() {
        ListeSimple[] t = new ListeSimpleImpl[3];
        for (int i = 0; i < 3; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[1].insererEnTete(new Entier(1));
        t[2].insererEnTete(new Entier(2));
        t[0].insererEnTete(new Entier(3));
        t[2].insererEnTete(new Entier(5));
        t[2].insererEnTete(new Entier(11));
        t[2].insererEnTete(new Entier(14));
        t[0].insererEnTete(new Entier(15));
        t[0].insererEnTete(new Entier(6));
        return t;
    }

    public static ListeSimple[] t235() {
        ListeSimple[] t = new ListeSimpleImpl[3];
        for (int i = 0; i < 3; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[2].insererEnTete(new Entier(2));
        t[2].insererEnTete(new Entier(5));
        t[0].insererEnTete(new Entier(3));
        return t;
    }

    public static ListeSimple[] t1235() {
        ListeSimple[] t = new ListeSimpleImpl[3];
        for (int i = 0; i < 3; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[2].insererEnTete(new Entier(2));
        t[2].insererEnTete(new Entier(5));
        t[0].insererEnTete(new Entier(3));
        t[1].insererEnTete(new Entier(1));
        return t;
    }

    public static ListeSimple[] t23511() {
        ListeSimple[] t = new ListeSimpleImpl[3];
        for (int i = 0; i < 3; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[2].insererEnTete(new Entier(2));
        t[2].insererEnTete(new Entier(5));
        t[0].insererEnTete(new Entier(3));
        t[2].insererEnTete(new Entier(11));
        return t;
    }

    public static ListeSimple[] t125() {
        ListeSimple[] t = new ListeSimpleImpl[4];
        for (int i = 0; i < 4; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[1].insererEnTete(new Entier(1));
        t[2].insererEnTete(new Entier(2));
        t[1].insererEnTete(new Entier(5));
        return t;
    }

    public static ListeSimple[] t125Moins5() {
        ListeSimple[] t = new ListeSimpleImpl[4];
        for (int i = 0; i < 4; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[1].insererEnTete(new Entier(1));
        t[2].insererEnTete(new Entier(2));
        t[1].insererEnTete(new Entier(5));
        t[1].insererEnTete(new Entier(-5));
        return t;
    }

    public static ListeSimple[] tMoins11251114() {
        ListeSimple[] t = new ListeSimpleImpl[4];
        for (int i = 0; i < 4; i++) {
            t[i] = new ListeSimpleImpl();
        }
        t[1].insererEnTete(new Entier(-1));
        t[1].insererEnTete(new Entier(1));
        t[2].insererEnTete(new Entier(2));
        t[1].insererEnTete(new Entier(5));
        t[3].insererEnTete(new Entier(11));
        t[2].insererEnTete(new Entier(14));
        return t;
    }

}
