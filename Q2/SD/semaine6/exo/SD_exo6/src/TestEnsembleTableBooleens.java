import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Scanner;

public class TestEnsembleTableBooleens {

    private static Scanner scanner = new Scanner(System.in);

    static Class classe = EnsembleTableBooleens.class;
    static Field t;
    static Field taille;


    /**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+"\n --> attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+"\n --> attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{

        System.out.println("***************************************************");
        System.out.println("Programme Test pour la classe EnsembleTableBooleens");
        System.out.println("***************************************************");

        int choix;

        t = classe.getDeclaredField("table");
        t.setAccessible(true);
        taille = classe.getDeclaredField("taille");
        taille.setAccessible(true);

        System.out.println("1 -> Tester la methode taille");
        System.out.println("2 -> Tester la methode estVide");
        System.out.println("3 -> Tester la methode contient");
        System.out.println("4 -> Tester la methode ajouter");
        System.out.println("5 -> Tester la methode enlever");
        System.out.println();
        System.out.print("Entrez votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testTaille();
                break;
            case 2:
                testEstVide();
                break;
            case 3:
                testContient();
                break;
            case 4:
                testAjouter();
                break;
            case 5:
                testEnlever();
                break;
        }
    }

    private static void testTaille()throws IllegalArgumentException, IllegalAccessException {
        System.out.println();

        boolean[] table125 = {false,true,true,false,false,true};
        boolean[] table125Copie = {false,true,true,false,false,true};
        boolean[] table25 = {false,false,true,false,false,true,false};
        boolean[] tableVide = {false,false,false,false};

        Ensemble<Entier> ensemble;

        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        try {
            assertEquals("Test" + numTest + " : ko  taille renvoyee ko :", taille.getInt(ensemble), ensemble.taille());
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table125Copie).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la methode taille() ne peut pas modifier la table de booleens");
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

        // Feu rouge ?
        // Infos contradictoires
        // Pour connaitre la taille --> attribut taille
        // Pas de parcours de table (O(N))
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 2);
        t.set(ensemble, table125);
        if(ensemble.taille()!=2){
            System.out.println("Attention : feu rouge detecte !");
            System.out.println("Revoyez votre methode");
            System.exit(0);
        }

        //test 2
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 2);
        t.set(ensemble, table25);
        System.out.println("Ensemble {2,5}");
        try {
            assertEquals("Test" + numTest + " : ko  taille renvoyee ko :", taille.getInt(ensemble), ensemble.taille());
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tableVide);
        System.out.println("Ensemble {}");
        try {
            assertEquals("Test" + numTest + " : ko  taille renvoyee ko :", taille.getInt(ensemble), ensemble.taille());
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

    private static void testEstVide()throws IllegalArgumentException, IllegalAccessException {
        System.out.println();

        boolean[] table125 = {false,true,true,false,false,true};
        boolean[] table125Copie = {false,true,true,false,false,true};
        boolean[] table25 = {false,false,true,false,false,true,false};
        boolean[] tableVide = {false,false,false,false};

        Ensemble<Entier> ensemble;

        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", taille.getInt(ensemble)==0, ensemble.estVide());
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table125Copie).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la methode estVide() ne peut pas modifier la table de booleens");
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

        // Feu rouge ?
        // Infos contradictoires
        // Pour connaitre la taille --> attribut taille
        // Pas de parcours de table (O(N))
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, table125);
        if(!ensemble.estVide()){
            System.out.println("Attention : feu rouge detecte !");
            System.out.println("Revoyez votre methode");
            System.exit(0);
        }

        //test 2
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 2);
        t.set(ensemble, table25);
        System.out.println("Ensemble {2,5}");
        try {
            assertEquals("Test" + numTest + " : ko : booleen renvoye ko : ", taille.getInt(ensemble)==0, ensemble.estVide());
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tableVide);
        System.out.println("Ensemble {}");
        try {
            assertEquals("Test" + numTest + " : ko  : booleen renvoye ko : ", taille.getInt(ensemble)==0, ensemble.estVide());
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

    private static void testContient()throws IllegalArgumentException, IllegalAccessException {
        System.out.println();

        boolean[] table125 = {false,true,true,false,false,true};
        boolean[] table125Copie = {false,true,true,false,false,true};
        boolean[] table25 = {false,false,true,false,false,true,false};
        boolean[] tableVide = {false,false,false,false};

        Ensemble<Entier> ensemble;

        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        Entier entier = new Entier(1);
        System.out.println("contient "+entier+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", true, ensemble.contient(entier));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table125Copie).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la methode contient() ne peut pas modifier la table de booleens");
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        entier = new Entier(2);
        System.out.println("contient "+entier+" ?");
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

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        entier = new Entier(5);
        System.out.println("contient "+entier+" ?");
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

        //test 4
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        entier = new Entier(3);
        System.out.println("contient "+entier+" ?");
        try {
            assertEquals("Test" + numTest + " : ko  boolean renvoye ko : ", false, ensemble.contient(entier));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 2);
        t.set(ensemble, table25);
        System.out.println("Ensemble {2,5}");
        entier = new Entier(5);
        System.out.println("contient "+entier+" ?");
        try {
            assertEquals("Test" + numTest + " : ko : boolean renvoye ko : ", true, ensemble.contient(entier));
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 2);
        t.set(ensemble, table25);
        System.out.println("Ensemble {2,5}");
        entier = new Entier(3);
        System.out.println("contient "+entier+" ?");
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tableVide);
        System.out.println("Ensemble {}");
        entier = new Entier(2);
        System.out.println("contient "+entier+" ?");
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

    private static void testAjouter()throws IllegalArgumentException, IllegalAccessException {

        System.out.println();

        boolean[] table125 = {false,true,true,false,false,true};
        boolean[] table1245 = {false,true,true,false,true,true};
        boolean[] table125Bis = {false,true,true,false,false,true};
        boolean[] table125Copie = {false,true,true,false,false,true};
        boolean[] table25 = {false,false,true,false,false,true,false};
        boolean[] table235 = {false,false,true,true,false,true,false};
        boolean[] tableVide = {false,false,false,false};
        boolean[] table1 = {false,true,false,false};

        Ensemble<Entier> ensemble;

        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        Entier entier = new Entier(4);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",4, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table1245).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens n'est pas la table attendue");
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125Bis);
        System.out.println("Ensemble {1,2,5}");
        entier = new Entier(2);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table125Copie).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens a ete modifiee");
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

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 2);
        t.set(ensemble, table25);
        System.out.println("Ensemble {2,5}");
        entier = new Entier(3);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table235).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens n'est pas la table attendue");
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

        //test 4
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tableVide);
        System.out.println("Ensemble {}");
        entier = new Entier(1);
        System.out.println("ajouter "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.ajouter(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",1, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table1).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens n'est pas la table attendue");
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

        System.out.println("Tous les tests ont reussi!");
    }

    private static void testEnlever()throws IllegalArgumentException, IllegalAccessException {

        boolean[] table125 = {false,true,true,false,false,true};
        boolean[] table25 = {false,false,true,false,false,true};
        boolean[] table125Bis = {false,true,true,false,false,true};
        boolean[] table125Copie = {false,true,true,false,false,true};
        boolean[] table235 = {false,false,true,true,false,true,false};
        boolean[] table35 = {false,false,false,true,false,true,false};
        boolean[] table1 = {false,true,false,false};
        boolean[] tableVide = {false,false,false,false};
        boolean[] tableVideBis = {false,false,false,false};

        Ensemble<Entier> ensemble;

        int numTest = 0;

        //test 1
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125);
        System.out.println("Ensemble {1,2,5}");
        Entier entier = new Entier(1);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",2, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table25).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens n'est pas la table attendue");
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
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table125Bis);
        System.out.println("Ensemble {1,2,5}");
        entier = new Entier(3);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",3, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table125Copie).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens a ete modifiee");
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

        //test 3
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 3);
        t.set(ensemble, table235);
        System.out.println("Ensemble {2,3,5}");
        entier = new Entier(2);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",2, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(table35).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens n'est pas la table attendue");
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

        //test 4
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 1);
        t.set(ensemble, table1);
        System.out.println("Ensemble {1}");
        entier = new Entier(1);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", true, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",0, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(tableVide).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens n'est pas la table attendue");
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

        //test 5
        numTest++;
        System.out.println("Test" + numTest);
        ensemble = new EnsembleTableBooleens<Entier>();
        taille.setInt(ensemble, 0);
        t.set(ensemble, tableVide);
        System.out.println("Ensemble {}");
        entier = new Entier(2);
        System.out.println("enlever "+entier);
        try {
            assertEquals("Test" + numTest + " : ko  : boolean renvoye ko : ", false, ensemble.enlever(entier));
            assertEquals("Test" + numTest + " : ko  : taille ko : ",0, taille.getInt(ensemble));
            boolean[] tableApresAppel = (boolean[]) t.get(ensemble);
            if(!Arrays.toString(tableVideBis).equals(Arrays.toString(tableApresAppel))){
                System.out.println("Test" + numTest + " : ko : la table de booleens a ete modifiee");
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


        System.out.println("Tous les tests ont reussi!");
    }


    /*
	public static void main(String[] args) {	
		System.out.println("***************************************************");
		System.out.println("Programme Test pour la classe EnsembleTableBooleens");
		System.out.println("***************************************************");
		Ensemble<Entier> e;
		e = new EnsembleTableBooleens<Entier>(6);
		assertEquals("estVide() ensemble vide", true, e.estVide());
		assertEquals("cardinal ensemble vide ko", 0, e.taille());
		assertEquals("ajout de 1 dans l'ensemble vide booleen ko", true, e.ajouter(new Entier(1)));
		assertEquals("apres ajout 1 dans ensemble vide cardinal ko", 1, e.taille());
		assertEquals("ajout de 2 dans l'ensemble {1) booleen ko", true, e.ajouter(new Entier(2)));
		assertEquals("apres ajout 2 dans ensemble {1) cardinal ko", 2, e.taille());
		assertEquals("ajout de 5 dans l'ensemble {1,2) booleen ko", true, e.ajouter(new Entier(5)));
		assertEquals("apres ajout 5 dans ensemble {1,2) cardinal ko", 3, e.taille());
		assertEquals("ajout de 2 dans l'ensemble {1,2,5) booleen ko", false, e.ajouter(new Entier(2)));
		assertEquals("apres ajout 2 dans ensemble {1,2,5) cardinal ko", 3, e.taille());
		assertEquals("estVide() ensemble {1,2,5)", false, e.estVide());
		assertEquals("1 appartient a l'ensemble {1,2,5} ? ", true, e.contient(new Entier(1)));
		assertEquals("2 appartient a l'ensemble {1,2,5} ? ", true, e.contient(new Entier(2)));
		assertEquals("5 appartient a l'ensemble {1,2,5} ? ", true, e.contient(new Entier(5)));
		assertEquals("4 appartient a l'ensemble {1,2,5} ? ", false, e.contient(new Entier(4)));
		assertEquals("suppression de 1 dans l'ensemble {1,2,5) booleen ko", true, e.enlever(new Entier(1)));
		assertEquals("apres suppression 1 dans ensemble {1,2,5) cardinal ko", 2, e.taille());
		assertEquals("apres suppression 1 dans ensemble {1,2,5) contient 1 ko", false, e.contient(new Entier(1)));
		assertEquals("suppression de 4 dans l'ensemble {1,2,5) booleen ko", false, e.enlever(new Entier(4)));
		assertEquals("apres suppression 4 dans ensemble {2,5) cardinal ko", 2, e.taille());
		System.out.println("Tous les tests ont reussi!");
		
	}

     */
}
