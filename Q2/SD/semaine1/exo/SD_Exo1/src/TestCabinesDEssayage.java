import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TestCabinesDEssayage {

    private static Scanner scanner = new Scanner(System.in);

    static Class classe = CabinesDEssayage.class;
    static Field table;
    static Field pile;

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

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        System.out.println("**********************************************");
        System.out.println("Programme Test pour la classe CabinesDEssayage");
        System.out.println("**********************************************");

        table = classe.getDeclaredField("tableOccupations");
        table.setAccessible(true);
        pile = classe.getDeclaredField("pileNumerosCabinesLibres");
        pile.setAccessible(true);

        int choix = 0;
        System.out.println();
        System.out.println("Menu");
        System.out.println(("----"));
        System.out.println("1 -> Tester le constructeur");
        System.out.println("2 -> Tester la methode nombreCabinesLibres()");
        System.out.println("3 -> Tester la methode attribuerCabineLibre()");
        System.out.println("4 -> Tester la methode libererCabine()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testConstructeur();
                break;
            case 2:
                testNombreCabinesLibres();
                break;
            case 3:
                testAttribuerCabineLibre();
                break;
            case 4:
                testLibererCabine();
                break;

        }
    }

    private static CabinesDEssayage enonce() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {true, false, true, false, false, true, false, true, true, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(4);
        pileTestee.push(7);
        pileTestee.push(2);
        pileTestee.push(5);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage enonceApresAttribution() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {true, false, true, false, true, true, false, true, true, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(4);
        pileTestee.push(7);
        pileTestee.push(2);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage enonceMoins3() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {true, false, false, false, false, true, false, true, true, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(4);
        pileTestee.push(7);
        pileTestee.push(2);
        pileTestee.push(5);
        pileTestee.push(3);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage enonceMoins1() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {false, false, true, false, false, true, false, true, true, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(4);
        pileTestee.push(7);
        pileTestee.push(2);
        pileTestee.push(5);
        pileTestee.push(1);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage enonceMoins10() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {true, false, true, false, false, true, false, true, true, false};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(4);
        pileTestee.push(7);
        pileTestee.push(2);
        pileTestee.push(5);
        pileTestee.push(10);
        pile.set(cabines, pileTestee);

        return cabines;

    }


    private static CabinesDEssayage tousLibres4() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {false, false, false, false};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(1);
        pileTestee.push(2);
        pileTestee.push(3);
        pileTestee.push(4);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage tousLibres4ApresAttribution() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {false, false, false, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(1);
        pileTestee.push(2);
        pileTestee.push(3);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage tousLibres10() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {false, false, false, false, false, false, false, false, false, false};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pileTestee.push(1);
        pileTestee.push(2);
        pileTestee.push(3);
        pileTestee.push(4);
        pileTestee.push(5);
        pileTestee.push(6);
        pileTestee.push(7);
        pileTestee.push(8);
        pileTestee.push(9);
        pileTestee.push(10);
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage toutesOccupees() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {true, true, true, true, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pile.set(cabines, pileTestee);

        return cabines;

    }

    private static CabinesDEssayage toutesOccupeesMoins4() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {true, true, true, false, true};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pile.set(cabines, pileTestee);

        pileTestee.push(4);

        return cabines;

    }

    //Donnees incoherentes entre la table et la pile
    //La cabine 3 est anoncee occupee dans la table, mais se trouve dans la pile
    //But : verifier que la methode utilise la structure de donnees qui garantit un cout minimum
    //Feu rouge
    private static CabinesDEssayage incoherent() throws IllegalArgumentException, IllegalAccessException {

        CabinesDEssayage cabines = new CabinesDEssayage();

        boolean[] tableTestee = {false, true, true, false};
        table.set(cabines, tableTestee);

        Pile<Integer> pileTestee = new PileImpl<>();
        pile.set(cabines, pileTestee);

        pileTestee.push(1);
        pileTestee.push(3);
        pileTestee.push(4);

        return cabines;

    }


    private static void testConstructeur() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;
        int nombreCabines;

        numTest++;
        System.out.println("Test" + numTest);
        nombreCabines = 10;
        System.out.println("Le nombre de cabines est "+nombreCabines);
        testConstructeur(tousLibres10(),nombreCabines);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        nombreCabines = 4;
        System.out.println("Le nombre de cabines est "+nombreCabines);
        testConstructeur(tousLibres4(),nombreCabines);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        nombreCabines = 0;
        System.out.println("Le nombre de cabines est "+nombreCabines);
        testConstructeur(tousLibres4(),nombreCabines);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        nombreCabines = -5;
        System.out.println("Le nombre de cabines est "+nombreCabines);
        testConstructeur(tousLibres4(),nombreCabines);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");
    }

    private static void testConstructeur(CabinesDEssayage cabinesAttendues, int nombreCabines) throws IllegalArgumentException, IllegalAccessException{
        if(nombreCabines<=0){
            try {
                CabinesDEssayage cabinesApresAppel = new CabinesDEssayage(nombreCabines);
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.exit(0);
            } catch (IllegalArgumentException e) {

            }catch (Exception e) {
                System.out.println("test ko : il y a eu une exception non attendue");
                System.out.println("        : il fallait une IllegalArgumentException");
                e.printStackTrace();
                System.exit(0);
            }
        }else{
            try {
                CabinesDEssayage cabinesApresAppel = new CabinesDEssayage(nombreCabines);
                boolean[] tableApresAppel = (boolean[]) table.get(cabinesApresAppel);
                if(tableApresAppel==null){
                    System.out.println("test ko");
                    System.out.println("Avez-vous cree la table (new) ?");
                    System.exit(0);
                }
                boolean[] tableAttendue = (boolean[]) table.get(cabinesAttendues);
                assertEquals("test ko : contenu table ko  : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));

                Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesApresAppel);
                if(pileApresAppel==null){
                    System.out.println("test ko");
                    System.out.println("Avez-vous cree la pile (new) ?");
                    System.exit(0);
                }
                if(pileApresAppel.taille()!=nombreCabines){
                    System.out.println("test ko");
                    System.out.println("Avez-vous rempli la pile ?");
                    System.out.println("Elle devrait contenir les numeros de tous les casiers");
                    System.exit(0);
                }
                HashSet<Integer> numerosAttendus = new HashSet<>();
                for (int i = 0; i < nombreCabines; i++) {
                    numerosAttendus.add(i+1);
                }
                HashSet<Integer> numerosApresAppel = new HashSet<>();
                for (int i = 0; i < nombreCabines; i++) {
                    numerosApresAppel.add(pileApresAppel.pop());
                }
                for (Integer numero : numerosApresAppel){
                    pileApresAppel.push(numero);
                }
                if(!numerosAttendus.equals(numerosApresAppel)){
                    System.out.println("test ko");
                    System.out.println("Avez-vous bien rempli la pile ?");
                    System.out.println("Elle devrait contenir (dans n'importe quel ordre) : "+numerosAttendus);
                    System.out.println("Elle contient :                                     "+numerosApresAppel);
                    System.exit(0);
                }

            } catch (Exception e) {
                System.out.println("test ko : il y a eu une exception non attendue");
                System.out.println("Avez-vous cree (new) la pile et la table ?");
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    private static void testNombreCabinesLibres() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testNombreCabinesLibres(enonce());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("4 cabines, toutes libres");
        testNombreCabinesLibres(tousLibres4());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 cabines, toutes occupees");
        testNombreCabinesLibres(toutesOccupees());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
        CabinesDEssayage cabines = incoherent();
        try {
            if(cabines.nombreCabinesLibres()!=3){
                System.out.println();
                System.out.println("ATTENTION : FEU ROUGE detecte");
                System.out.println("Parcours de table : O(N)");
                System.out.println("methode taille() de la classe PileImpl : O(1)");
            }
        }catch (Exception e) {

        }
    }

    private static void testNombreCabinesLibres(CabinesDEssayage cabinesTestees) throws IllegalArgumentException, IllegalAccessException{
        boolean[] tableTestee = (boolean[]) table.get(cabinesTestees);
        String tableTesteeString = Arrays.toString(tableTestee);
        Pile<Integer> pileTestee = (Pile<Integer>) pile.get(cabinesTestees);
        String pileTesteeString = pileTestee.toString();
        System.out.println("pile : " + pileTesteeString);
        System.out.println("table : " + tableTesteeString);
        try {
            assertEquals("test ko : nombre cabinesTestees libres : ko ",pileTestee.taille(), cabinesTestees.nombreCabinesLibres());
            boolean[] tableApresAppel = (boolean[]) table.get(cabinesTestees);
            Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesTestees);
            assertEquals("KO : la methode nombreCabinesLibres ne peut modifier la table de booleens",tableTesteeString,Arrays.toString(tableApresAppel));
            assertEquals("test ko : la methode nombreCabinesLibres ne peut modifier la pile",pileTesteeString,pileApresAppel.toString());
        }catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void testAttribuerCabineLibre() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testAttribuerCabineLibre(enonce(),enonceApresAttribution());

        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("4 cabines, toutes libres");
        testAttribuerCabineLibre(tousLibres4(),tousLibres4ApresAttribution());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 cabines, toutes occupees");
        testAttribuerCabineLibre(toutesOccupees(), toutesOccupees());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testAttribuerCabineLibre(CabinesDEssayage cabinesTestees, CabinesDEssayage cabinesAttendues) throws IllegalArgumentException, IllegalAccessException{
        boolean[] tableTestee = (boolean[]) table.get(cabinesTestees);
        Pile<Integer> pileTestee = (Pile<Integer>) pile.get(cabinesTestees);
        System.out.println("pile : " + pileTestee.toString());
        System.out.println("table : " + Arrays.toString(tableTestee));
        if(pileTestee.estVide()){
            try {
                assertEquals("test ko : numero cabine attribuee : ko ",-1, cabinesTestees.attribuerCabineLibre());
                boolean[] tableAttendue = (boolean[]) table.get(cabinesAttendues);
                Pile<Integer> pileAttendue = (Pile<Integer>) pile.get(cabinesAttendues);
                boolean[] tableApresAppel = (boolean[]) table.get(cabinesTestees);
                Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesTestees);
                assertEquals("test ko : contenu table modifie  : ",Arrays.toString(tableAttendue),Arrays.toString(tableApresAppel));
                assertEquals("test ko : contenu pile modifie : ",pileAttendue.toString(),pileApresAppel.toString());
            }catch (Exception e) {
                System.out.println("test ko : il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
        }else{
            try {
                assertEquals("test ko : numero cabine attribuee : ko ",pileTestee.sommet(), cabinesTestees.attribuerCabineLibre());
                boolean[] tableAttendue = (boolean[]) table.get(cabinesAttendues);
                Pile<Integer> pileAttendue = (Pile<Integer>) pile.get(cabinesAttendues);
                boolean[] tableApresAppel = (boolean[]) table.get(cabinesTestees);
                Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesTestees);
                assertEquals("test ko : contenu table ko : ",Arrays.toString(tableAttendue),Arrays.toString(tableApresAppel));
                assertEquals("test ko : contenu pile ko : ",pileAttendue.toString(),pileApresAppel.toString());
            }catch (Exception e) {
                System.out.println("test ko : il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
        }

    }

    private static void testLibererCabine() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonceMoins3(),3);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonceMoins1(),1);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonceMoins10(),10);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonce(),0);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonce(),-5);
        System.out.println("Test" + numTest + " : ok");

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonce(),11);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonce(),15);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCabine(enonce(), enonce(),7);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 cabines, toutes occupees");
        testLibererCabine(toutesOccupees(), toutesOccupeesMoins4(),4);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 cabines, toutes occupees");
        testLibererCabine(toutesOccupees(), toutesOccupees(),6);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");
    }

    private static void testLibererCabine(CabinesDEssayage cabinesTestees, CabinesDEssayage cabinesAttendues, int numeroCabineALiberer)throws IllegalArgumentException, IllegalAccessException {
        boolean[] tableTestee = (boolean[]) table.get(cabinesTestees);
        Pile<Integer> pileTestee = (Pile<Integer>) pile.get(cabinesTestees);
        System.out.println("pile : " + pileTestee.toString());
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("numero cabine a liberer : "+numeroCabineALiberer);
        if(numeroCabineALiberer<=0 ||numeroCabineALiberer>tableTestee.length){
            try {
                cabinesTestees.libererCabine(numeroCabineALiberer);
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.exit(0);
            }catch (IllegalArgumentException e) {
                System.out.println("il y a bien eu une IllegalArgumentException");
                boolean[] tableAttendue = (boolean[]) table.get(cabinesAttendues);
                Pile<Integer> pileAttendue = (Pile<Integer>) pile.get(cabinesAttendues);
                boolean[] tableApresAppel = (boolean[]) table.get(cabinesTestees);
                Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesTestees);
                assertEquals("MAIS test ko : contenu table modifie : ",Arrays.toString(tableAttendue),Arrays.toString(tableApresAppel));
                assertEquals("MAIS test ko : contenu pile modifie : ",pileAttendue.toString(),pileApresAppel.toString());
            }catch (Exception e) {
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.out.println("        : il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
        }else{
            if(tableTestee[numeroCabineALiberer-1]==false){
                try {
                    cabinesTestees.libererCabine(numeroCabineALiberer);
                    System.out.println("test ko : il fallait une IllegalStateException");
                    System.exit(0);
                }catch (IllegalStateException e) {
                    System.out.println("il y a bien eu une IllegalStateException");
                    boolean[] tableAttendue = (boolean[]) table.get(cabinesAttendues);
                    Pile<Integer> pileAttendue = (Pile<Integer>) pile.get(cabinesAttendues);
                    boolean[] tableApresAppel = (boolean[]) table.get(cabinesTestees);
                    Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesTestees);
                    assertEquals("MAIS test ko : contenu table modifie : ",Arrays.toString(tableAttendue),Arrays.toString(tableApresAppel));
                    assertEquals("MAIS test ko : contenu pile modifie : ",pileAttendue.toString(),pileApresAppel.toString());
                }catch (Exception e) {
                    System.out.println("test ko : il fallait une IllegalStateException");
                    System.out.println("        : il y a eu une exception non attendue");
                    e.printStackTrace();
                    System.exit(0);
                }
            }else{
                try {
                    cabinesTestees.libererCabine(numeroCabineALiberer);
                    boolean[] tableAttendue = (boolean[]) table.get(cabinesAttendues);
                    Pile<Integer> pileAttendue = (Pile<Integer>) pile.get(cabinesAttendues);
                    boolean[] tableApresAppel = (boolean[]) table.get(cabinesTestees);
                    Pile<Integer> pileApresAppel = (Pile<Integer>) pile.get(cabinesTestees);
                    assertEquals("test ko : contenu table ko : ",Arrays.toString(tableAttendue),Arrays.toString(tableApresAppel));
                    assertEquals("test ko : contenu pile ko : ",pileAttendue.toString(),pileApresAppel.toString());
                }catch (Exception e) {
                    System.out.println(" test ko : il y a eu une exception non attendue");
                    e.printStackTrace();
                    System.exit(0);
                }

            }
        }

    }


}
