import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TestConsigneFIFO {
    private static Scanner scanner = new Scanner(System.in);

    static Class classe = ConsigneFIFO.class;
    static Field table;
    static Field file;

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

        System.out.println("******************************************");
        System.out.println("Programme Test pour la classe ConsigneFIFO");
        System.out.println("******************************************");

        table = classe.getDeclaredField("tableCasiers");
        table.setAccessible(true);
        file = classe.getDeclaredField("arrayListCasiersLibres");
        file.setAccessible(true);

        int choix = 0;
        System.out.println();
        System.out.println("Menu");
        System.out.println(("----"));
        System.out.println("1 -> Tester le constructeur");
        System.out.println("2 -> Tester la methode resteUnCasierLibre()");
        System.out.println("3 -> Tester la methode attribuerCasierLibre()");
        System.out.println("4 -> Tester la methode libererCasier()");
        System.out.println();
        System.out.print("Votre choix : ");
        choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testConstructeurC();
                break;
            case 2:
                testResteUnCasierLibre();
                break;
            case 3:
                testAttribuerCasierLibre();
                break;
            case 4:
                testLibererCasier();
                break;

        }
    }

    private static void testConstructeurC() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        int numTest = 0;
        int nombreCasiers;

        numTest++;
        System.out.println("Test" + numTest);
        nombreCasiers = 10;
        System.out.println("Le nombre de Casiers est " + nombreCasiers);
        testConstructeur(tousLibres10(), nombreCasiers);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        nombreCasiers = 7;
        System.out.println("Le nombre de Casiers est " + nombreCasiers);
        testConstructeur(tousLibres7(), nombreCasiers);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        nombreCasiers = 0;
        System.out.println("Le nombre de Casiers est " + nombreCasiers);
        testConstructeur(tousLibres10(), nombreCasiers);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        nombreCasiers = -3;
        System.out.println("Le nombre de Casiers est " + nombreCasiers);
        testConstructeur(tousLibres10(), nombreCasiers);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");
    }

    private static void testConstructeur(ConsigneFIFO consigneAttendue, int nombreCasiers) {
        if (nombreCasiers <= 0) {
            try {
                new ConsigneFIFO(nombreCasiers);
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.exit(0);
            } catch (IllegalArgumentException e) {

            } catch (Exception e) {
                System.out.println("test ko : il y a eu une exception non attendue");
                System.out.println("        : il fallait une IllegalArgumentException");
                e.printStackTrace();
                System.exit(0);
            }
        } else {
            try {
                ConsigneFIFO consigneApresAppel = new ConsigneFIFO(nombreCasiers);
                Casier[] tableApresAppel = (Casier[]) table.get(consigneApresAppel);
                if (tableApresAppel == null) {
                    System.out.println("test ko");
                    System.out.println("Avez-vous cree la table (new) ?");
                    System.exit(0);
                }
                Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
                if (tableApresAppel[0] == null) {
                    System.out.println("test ko");
                    System.out.println("Presence de null dans la table !");
                    System.out.println("Avez-vous rempli la table avec les casiers?");
                    System.exit(0);
                }
                assertEquals("test ko : contenu table ko  : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));

                ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneApresAppel);
                if (pileApresAppel == null) {
                    System.out.println("test ko");
                    System.out.println("Avez-vous cree la pile (new) ?");
                    System.exit(0);
                }
                if (pileApresAppel.size() != nombreCasiers) {
                    System.out.println("test ko");
                    System.out.println("Avez-vous rempli la pile ?");
                    System.out.println("Elle devrait contenir tous les casiers");
                    System.exit(0);
                }
                Casier unCasier = pileApresAppel.getLast();
                HashSet<Integer> numerosAttendus = new HashSet<>();
                for (int i = 0; i < nombreCasiers; i++) {
                    numerosAttendus.add(i);
                }
                HashSet<Integer> numerosApresAppel = new HashSet<>();
                for (int i = 0; i < nombreCasiers; i++) {
                    numerosApresAppel.add(pileApresAppel.removeLast().getNumero());
                }
                if (!numerosAttendus.equals(numerosApresAppel)) {
                    System.out.println("test ko");
                    System.out.println("Avez-vous bien rempli la pile ?");
                    System.out.println("Elle devrait contenir (dans n'importe quel ordre) les casiers avec les numeros : " + numerosAttendus);
                    System.out.println("Elle contient :                                     " + numerosApresAppel);
                    System.exit(0);
                }
                boolean trouve = false;
                for (int i = 0; i < nombreCasiers; i++) {
                    //meme reference
                    if (unCasier == tableApresAppel[i]) {
                        trouve = true;
                        break;
                    }
                }
                if (!trouve) {
                    System.out.println("test ko");
                    System.out.println("la pile et la table doivent referencier les memes objets");
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

    private static void testResteUnCasierLibre() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        int numTest = 0;

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testResteUnCasierLibre(enonce());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("7 Casiers, tous libres");
        testResteUnCasierLibre(tousLibres7());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers, tous occupes");
        testResteUnCasierLibre(tousOccupes5());
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");

        ConsigneFIFO consigneFIFO = incoherent1();
        try {
            if (consigneFIFO.resteUnCasierLibre()) {
                System.out.println();
                System.out.println("ATTENTION : FEU ROUGE detecte");
                System.exit(0);
            }
        } catch (Exception e) {

        }

        consigneFIFO = incoherent2();
        try {
            if (!consigneFIFO.resteUnCasierLibre()) {
                System.out.println();
                System.out.println("ATTENTION : FEU ROUGE detecte");
            }
        } catch (Exception e) {

        }
    }

    private static void testResteUnCasierLibre(ConsigneFIFO consigneTestee) throws IllegalArgumentException, IllegalAccessException {
        Casier[] tableTestee = (Casier[]) table.get(consigneTestee);
        String tableTesteeString = Arrays.toString(tableTestee);
        ArrayList<Casier> pileTestee = (ArrayList<Casier>) file.get(consigneTestee);
        String pileTesteeString = pileTestee.toString();
        System.out.println("pile : " + pileTesteeString);
        System.out.println("table : " + tableTesteeString);
        try {
            assertEquals("test ko : booleen : ko ", !pileTestee.isEmpty(), consigneTestee.resteUnCasierLibre());
            Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
            ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
            assertEquals("test ko : la methode resteUnCasierLibre() ne peut modifier la table de booleens", tableTesteeString, Arrays.toString(tableApresAppel));
            assertEquals("test ko : la methode resteUnCasierLibre() ne peut modifier la pile", pileTesteeString, pileApresAppel.toString());
        } catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void testAttribuerCasierLibre() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        int numTest = 0;
        String motDePasse;

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        motDePasse = "xxx";
        System.out.println("mot de passe : " + motDePasse);
        testAttribuerCasierLibre(enonce(), enonceApresAttribution(), motDePasse);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        motDePasse = null;
        System.out.println("mot de passe : " + motDePasse);
        testAttribuerCasierLibre(enonce(), enonce(), motDePasse);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        motDePasse = "";
        System.out.println("mot de passe : " + motDePasse);
        testAttribuerCasierLibre(enonce(), enonce(), motDePasse);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("7 casiers, tous libres");
        motDePasse = "nv";
        System.out.println("mot de passe : " + motDePasse);
        testAttribuerCasierLibre(tousLibres7(), tousLibres7ApresAttribution(), motDePasse);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers, tous occupes");
        motDePasse = "ko";
        System.out.println("mot de passe : " + motDePasse);
        testAttribuerCasierLibre(tousOccupes5(), tousOccupes5(), motDePasse);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testAttribuerCasierLibre(ConsigneFIFO consigneTestee, ConsigneFIFO consigneAttendue, String motDePasse) throws IllegalArgumentException, IllegalAccessException {
        Casier[] tableTestee = (Casier[]) table.get(consigneTestee);
        ArrayList<Casier> pileTestee = (ArrayList<Casier>) file.get(consigneTestee);
        System.out.println("pile : " + pileTestee.toString());
        System.out.println("table : " + Arrays.toString(tableTestee));
        if (motDePasse == null || motDePasse.length() == 0) {
            try {
                consigneTestee.attribuerCasierLibre(motDePasse);
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("il y a bien eu une IllegalArgumentException");
                Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
                ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
                Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
                ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
                assertEquals("MAIS test ko : contenu table modifie : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
                assertEquals("MAIS test ko : contenu pile modifie : ", pileAttendue.toString(), pileApresAppel.toString());
            } catch (Exception e) {
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.out.println("          il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
            return;
        }
        if (pileTestee.isEmpty()) {
            try {
                assertEquals("test ko : numero casier attribue : ko ", -1, consigneTestee.attribuerCasierLibre(motDePasse));
                Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
                ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
                Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
                ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
                assertEquals("test ko : contenu table modifie  : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
                assertEquals("test ko : contenu pile modifie : ", pileAttendue.toString(), pileApresAppel.toString());
            } catch (Exception e) {
                System.out.println("test ko : il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
            return;
        }
        try {
            Casier casierAttribue = tableTestee[pileTestee.getFirst().getNumero()];
            assertEquals("test ko : numero casier attribue : ko ", pileTestee.getFirst().getNumero(), consigneTestee.attribuerCasierLibre(motDePasse));
            Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
            ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
            Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
            ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
            assertEquals("test ko : contenu table ko : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("test ko : contenu pile ko : ", pileAttendue.toString(), pileApresAppel.toString());
            if(casierAttribue.getMotDePasse().equals("")){
                System.out.println("table et pile : contenu ok");
                System.out.println("MAIS ATTENTION, il y a eu creation (new) de casier !");
                System.out.println("Les casiers ne sont crees qu'une fois via le constructeur.");
                System.out.println("Si changement de mot de passe --> setMotPasse()");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void testLibererCasier() throws IllegalArgumentException, IllegalAccessException {
        System.out.println();
        int numTest = 0;

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCasier(enonce(), enonceMoins2(), 2,"blabla");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("Exemple de l'enonce");
        testLibererCasier(enonce(), enonceMoins0(), 0,"mdp");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5Moins4(), 4,"mdp4");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), 2,"mauvais");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), 2,"bidon");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), 2,null);
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), 2,"");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), -1,"bidon");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), -5,"bidon");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), 10,"bidon");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        numTest++;
        System.out.println("Test" + numTest);
        System.out.println("5 casiers tous occupes");
        testLibererCasier(tousOccupes5(), tousOccupes5(), 5,"bidon");
        System.out.println("Test" + numTest + " : ok");
        System.out.println();

        System.out.println("tous les tests ont reussi");
    }

    private static void testLibererCasier(ConsigneFIFO consigneTestee, ConsigneFIFO consigneAttendue, int numeroCasierALiberer, String motDePasse) throws IllegalArgumentException, IllegalAccessException {
        Casier[] tableTestee = (Casier[]) table.get(consigneTestee);
        ArrayList<Casier> pileTestee = (ArrayList<Casier>) file.get(consigneTestee);
        System.out.println("pile : " + pileTestee.toString());
        System.out.println("table : " + Arrays.toString(tableTestee));
        System.out.println("numero casier a liberer : " + numeroCasierALiberer);
        System.out.println("motDePasse : " + motDePasse);
        if (numeroCasierALiberer < 0 || numeroCasierALiberer >= tableTestee.length) {
            try {
                consigneTestee.libererCasier(numeroCasierALiberer, motDePasse);
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("il y a bien eu une IllegalArgumentException");
                Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
                ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
                Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
                ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
                assertEquals("MAIS test ko : contenu table modifie : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
                assertEquals("MAIS test ko : contenu pile modifie : ", pileAttendue.toString(), pileApresAppel.toString());
            } catch (Exception e) {
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.out.println("        : il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
            return;
        }
        if (motDePasse==null||motDePasse.length()==0) {
            try {
                consigneTestee.libererCasier(numeroCasierALiberer,motDePasse);
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.exit(0);
            } catch (IllegalArgumentException e) {
                System.out.println("il y a bien eu une IllegalArgumentException");
                Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
                ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
                Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
                ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
                assertEquals("MAIS test ko : contenu table modifie : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
                assertEquals("MAIS test ko : contenu pile modifie : ", pileAttendue.toString(), pileApresAppel.toString());
            } catch (Exception e) {
                System.out.println("test ko : il fallait une IllegalArgumentException");
                System.out.println("        : il y a eu une exception non attendue");
                e.printStackTrace();
                System.exit(0);
            }
            return;
        }
        if(!motDePasse.equals(tableTestee[numeroCasierALiberer].getMotDePasse())){
            assertEquals("test ko : booleen ko : ",false,consigneTestee.libererCasier(numeroCasierALiberer,motDePasse));
            Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
            ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
            Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
            ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
            assertEquals("test ko : contenu table modifie : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("test ko : contenu pile modifie : ", pileAttendue.toString(), pileApresAppel.toString());
            return;
        }
        try {
            Casier casierALiberer = tableTestee[numeroCasierALiberer];
            assertEquals("test ko : booleen ko : ",true,consigneTestee.libererCasier(numeroCasierALiberer,motDePasse));
            Casier[] tableAttendue = (Casier[]) table.get(consigneAttendue);
            ArrayList<Casier> pileAttendue = (ArrayList<Casier>) file.get(consigneAttendue);
            Casier[] tableApresAppel = (Casier[]) table.get(consigneTestee);
            ArrayList<Casier> pileApresAppel = (ArrayList<Casier>) file.get(consigneTestee);
            if(tableApresAppel[numeroCasierALiberer]==null){
                System.out.println("test ko : il fallait remettre le mot de passe a vide, pas le casier a null");
                System.exit(0);
            }
            if(tableApresAppel[numeroCasierALiberer].getMotDePasse()==null){
                System.out.println("test ko : il fallait remettre le mot de passe a vide, pas a null");
                System.exit(0);
            }
            if(!tableApresAppel[numeroCasierALiberer].getMotDePasse().equals("")){
                System.out.println("test ko : il fallait remettre le mot de passe a vide");
                System.out.println("          sinon possibilite de le liberer plusieurs fois");
                System.out.println("          consequence : la pile va contenir plusieurs fois ce casier");
                System.out.println("          risque attribution d'un casier deja occupe !!!");

                System.exit(0);
            }
            assertEquals("test ko : contenu table ko : ", Arrays.toString(tableAttendue), Arrays.toString(tableApresAppel));
            assertEquals("test ko : contenu pile ko : ", pileAttendue.toString(), pileApresAppel.toString());
            if(tableApresAppel[numeroCasierALiberer]!=casierALiberer || pileApresAppel.getLast()!=casierALiberer){
                System.out.println("table et pile : contenu ok");
                System.out.println("MAIS ATTENTION, il y a eu creation (new) de casiers !");
                System.out.println("Les casiers ne sont crees qu'une fois via le constructeur.");
                System.out.println("Si changement de mot de passe --> setMotPasse()");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(" test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static ConsigneFIFO enonce() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[4];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[0].setMotDePasse("mdp");
        tableTestee[2].setMotDePasse("blabla");
        pileTestee.addLast(tableTestee[1]);
        pileTestee.addLast(tableTestee[3]);
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    //attention ce ne sont pas les memes objets que la ConsigneFIFO cree apres appel de enonce()
    //Pour les comparaisons --> equals() ou toString()
    private static ConsigneFIFO enonceMoins2() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[4];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[0].setMotDePasse("mdp");
        tableTestee[2].setMotDePasse("");
        pileTestee.addLast(tableTestee[1]);
        pileTestee.addLast(tableTestee[3]);
        pileTestee.addLast(tableTestee[2]);
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    //attention ce ne sont pas les memes objets que la ConsigneFIFO cree apres appel de enonce()
    //Pour les comparaisons --> equals() ou toString()
    private static ConsigneFIFO enonceMoins0() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[4];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[0].setMotDePasse("");
        tableTestee[2].setMotDePasse("blabla");
        pileTestee.addLast(tableTestee[1]);
        pileTestee.addLast(tableTestee[3]);
        pileTestee.addLast(tableTestee[0]);
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    //attention ce ne sont pas les memes objets que la ConsigneFIFO cree apres appel de enonce()
    //Pour les comparaisons --> equals() ou toString()
    private static ConsigneFIFO enonceApresAttribution() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[4];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[0].setMotDePasse("mdp");
        tableTestee[2].setMotDePasse("blabla");
        tableTestee[1].setMotDePasse("xxx");
        pileTestee.addLast(tableTestee[3]);
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    private static ConsigneFIFO tousLibres10() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[10];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
            pileTestee.addLast(casier);
        }
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    private static ConsigneFIFO tousLibres7() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[7];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
            pileTestee.addLast(casier);
        }
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    //attention ce ne sont pas les memes objets que la ConsigneFIFO cree apres appel de tousLibres7()
    //Pour les comparaisons --> equals() ou toString()
    private static ConsigneFIFO tousLibres7ApresAttribution() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[7];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
            pileTestee.addLast(casier);
        }
        pileTestee.removeFirst();
        tableTestee[0].setMotDePasse("nv");
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    private static ConsigneFIFO tousOccupes5() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[5];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[0].setMotDePasse("mdp0");
        tableTestee[1].setMotDePasse("mdp1");
        tableTestee[2].setMotDePasse("mdp2");
        tableTestee[3].setMotDePasse("mdp3");
        tableTestee[4].setMotDePasse("mdp4");
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    private static ConsigneFIFO tousOccupes5Moins4() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[5];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[0].setMotDePasse("mdp0");
        tableTestee[1].setMotDePasse("mdp1");
        tableTestee[2].setMotDePasse("mdp2");
        tableTestee[3].setMotDePasse("mdp3");
        tableTestee[4].setMotDePasse("");
        pileTestee.addLast(tableTestee[4]);
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    //Donnees incoherentes entre la table et la pile
    //tous les casiers sont libres dans la table (mdp "") excepte le casier 3
    //La pile est vide
    //reste un casier libre : FALSE
    //But : verifier que la methode resteUnCasierLibre utilise la pile --> cout O(1)
    //Feu rouge
    private static ConsigneFIFO incoherent1() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[4];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        tableTestee[3].setMotDePasse("mdp");
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }

    //Donnees incoherentes entre la table et la pile
    //tous les casiers sont libres dans la table (mdp "")
    //la pile contient le casier 3
    //reste un casier libre : TRUE
    //But : verifier que la methode resteUnCasierLibre utilise la pile --> cout O(1)
    //Feu rouge
    private static ConsigneFIFO incoherent2() throws IllegalArgumentException, IllegalAccessException {
        ConsigneFIFO ConsigneFIFO = new ConsigneFIFO();
        Casier[] tableTestee = new Casier[4];
        ArrayList<Casier> pileTestee = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Casier casier = new Casier(i);
            tableTestee[i] = casier;
        }
        pileTestee.addLast(tableTestee[3]);
        table.set(ConsigneFIFO, tableTestee);
        file.set(ConsigneFIFO, pileTestee);
        return ConsigneFIFO;
    }
    
    
    
}
