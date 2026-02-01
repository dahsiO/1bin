import java.util.Arrays;
import java.util.NoSuchElementException;

public class TestTableEntiersNonNuls {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

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
                System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        int choix;

        System.out.println("******************************************");
        System.out.println("Tests pour la classe TableNegatifsPositifs");
        System.out.println("******************************************");
        do{
            System.out.println("Menu");
            System.out.println("****");

            System.out.println("1 -> moyenneEntiersComprisEntre()");
            System.out.println("2 -> plusPetitEntierPositif()");
            System.out.println("3 -> ajouterApres()");
            System.out.println("4 -> tableNegatifsPositifs()");
            System.out.print("\nEntrez votre choix : ");

            choix=scanner.nextInt();

            switch(choix){
                case 1: testerMoyenneEntiersComprisEntre();
                    break;
                case 2: testerPlusPetitEntierPositif();
                    break;
                case 3: testerAjouterApres();
                    break;
                case 4: testerTableNP();
                    break;
            }
        }while(choix >=1 && choix<=4);

        System.out.println("\nFin des tests");
    }



    private static void testerMoyenneEntiersComprisEntre() {
        System.out.println();
        System.out.println("moyenneEntiersComprisEntre()");
        System.out.println("----------------------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,8,3,-1,1};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,5);
            int entier1 = 1;
            int entier2 = 4;
            System.out.println("intervalle : ["+entier1+","+entier2+"]");
            assertEquals("test "+numeroTest+ " ko : moyenne ko",2.0,table.moyenneEntiersComprisEntre(entier1,entier2));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(IllegalArgumentException e){
            System.out.println("test "+numeroTest+ "ko, entier1 <= entier2, il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test2
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3,4,5,2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,4);
            int entier1 = 0;
            int entier2 = 9;
            System.out.println("intervalle : ["+entier1+","+entier2+"]");
            assertEquals("test "+numeroTest+ " ko : moyenne ko",3.5,table.moyenneEntiersComprisEntre(entier1,entier2));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(IllegalArgumentException e){
            System.out.println("test "+numeroTest+ "ko, entier1 <= entier2, il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test3
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {0,1,2,3,4,5,6,7,8,9};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            int entier1 = 8;
            int entier2 = 9;
            System.out.println("intervalle : ["+entier1+","+entier2+"]");
            assertEquals("test "+numeroTest+ " ko : moyenne ko",8.5,table.moyenneEntiersComprisEntre(entier1,entier2));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(IllegalArgumentException e){
            System.out.println("test "+numeroTest+ "ko, entier1 <= entier2, il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test4
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3, 5, 2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,3);
            int entier1 = 8;
            int entier2 = 15;
            System.out.println("intervalle : ["+entier1+","+entier2+"]");
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,table.moyenneEntiersComprisEntre(entier1,entier2));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(IllegalArgumentException e){
            System.out.println("test "+numeroTest+ "ko, entier1 <= entier2, il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test5
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,0);
            int entier1 = 2;
            int entier2 = 5;
            System.out.println("intervalle : ["+entier1+","+entier2+"]");
            assertEquals("test "+numeroTest+ " ko : moyenne ko",0.0,table.moyenneEntiersComprisEntre(entier1,entier2));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(IllegalArgumentException e){
            System.out.println("test "+numeroTest+ "ko, entier1 <= entier2, il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test6
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3, 5, 2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,4);
            int entier1 = 9;
            int entier2 = 1;
            System.out.println("intervalle : ["+entier1+","+entier2+"]");
            table.moyenneEntiersComprisEntre(entier1,entier2);
            System.out.println("test "+numeroTest+ "ko, entier1 > entier2, il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(IllegalArgumentException e){

        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();

    }


    private static void testerPlusPetitEntierPositif() {
        System.out.println();
        System.out.println("plusPetitEntierPositif()");
        System.out.println("------------------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,8,3,-1,11};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,5);
            assertEquals("test "+numeroTest+ " ko : min positif ko",3,table.plusPetitEntierPositif());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a des positifs dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test2
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,-2, 3,-4, 5,-6,-7,-8, 9, 10};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            assertEquals("test "+numeroTest+ " ko : min positif ko",1,table.plusPetitEntierPositif());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a des positifs dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test3
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {10,-2, 5,-4, 3,-6, 7,-8, 9, 2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            assertEquals("test "+numeroTest+ " ko : min positif ko",2,table.plusPetitEntierPositif());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a des positifs dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test4
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-1,-2,-3,-4,-5,-6,-7,-8,-9,-10};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            table.plusPetitEntierPositif();
            System.out.println("test "+numeroTest+ "ko, il n'y a pas de positifs dans la table");
            System.out.println("il fallait lancer une exception de type NoSuchElementException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {

        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            System.out.println("il n'y a pas de positifs dans la table");
            System.out.println("il fallait lancer une exception de type NoSuchElementException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test5
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,0);
            table.plusPetitEntierPositif();
            System.out.println("test "+numeroTest+ "ko, il n'y a pas de positifs dans la table");
            System.out.println("il fallait lancer une exception de type NoSuchElementException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {

        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            System.out.println("il n'y a pas de positifs dans la table");
            System.out.println("il fallait lancer une exception de type NoSuchElementException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();


        numeroTest++;
        //test6
        System.out.println("test "+numeroTest);
        try{
            int max = Integer.MAX_VALUE;
            int[] tableARecopier = {max};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,1);
            assertEquals("test "+numeroTest+ " ko : min positif ko",max,table.plusPetitEntierPositif());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }catch(NoSuchElementException e) {
            System.out.println("test "+numeroTest+ "ko, il y a des positifs dans la table");
            System.out.println("il ne fallait pas lancer d'exception");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerAjouterApres() {
        System.out.println();
        System.out.println("ajouterApres()");
        System.out.println("--------------");

        System.out.println();
        //test1
        int numeroTest = 1;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {2,-4,6,8};
            int nbEntiers = 4;
            int entier = -4;
            int entierAAjouter = 777;
            int[]tableAttendue = {2,-4,777,6,8};
            int nbEntiersAttendu = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test2
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {2,-4,6,8,5};
            int nbEntiers = 5;
            int entier = 5;
            int entierAAjouter = 999;
            int[]tableAttendue = {2,-4,6,8,5,999};
            int nbEntiersAttendu = 6;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test3
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,3,4,-5,6,7,-8,9};
            int nbEntiers = 9;
            int entier = 1;
            int entierAAjouter = 444;
            int[]tableAttendue = {1,444,2,3,4,-5,6,7,-8,9};
            int nbEntiersAttendu = 10;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test4
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,-3,4,5,6,7,8,9};
            int nbEntiers = 9;
            int entier = 9;
            int entierAAjouter = 999;
            int[]tableAttendue = {1,2,-3,4,5,6,7,8,9,999};
            int nbEntiersAttendu = 10;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test5
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,-5,2,7,8,2};
            int nbEntiers = 7;
            int entier = 2;
            int entierAAjouter = 444;
            int[]tableAttendue = {1,2,444,-5,2,7,8,2};
            int nbEntiersAttendu = 8;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test6
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {2,2,2,2};
            int nbEntiers = 4;
            int entier = 2;
            int entierAAjouter = 444;
            int[]tableAttendue = {2,444,2,2,2};
            int nbEntiersAttendu = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",true,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test7
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,3,4,5,6,7,-8,9,10};
            int nbEntiers = 10;
            int entier = 5;
            int entierAAjouter = 333;
            int[]tableAttendue = {1,2,3,4,5,6,7,-8,9,10};
            int nbEntiersAttendu = 10;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",false,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test8
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,-3,4,5};
            int nbEntiers = 5;
            int entier = 9;
            int entierAAjouter = 333;
            int[]tableAttendue = {1,2,-3,4,5};
            int nbEntiersAttendu = 5;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",false,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test9
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            int nbEntiers = 0;
            int entier = 3;
            int entierAAjouter = 555;
            int[]tableAttendue = {};
            int nbEntiersAttendu = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            assertEquals("test "+numeroTest+" ko : booleen renvoye",false,table.ajouterApres(entier,entierAAjouter));
            assertEquals("test "+numeroTest+" ko : nbEntiers ko",nbEntiersAttendu,table.getNbEntiers() );
            assertEquals("test "+numeroTest+" ko : contenu table ko",Arrays.toString(tableAttendue),table.toString());
            assertEquals("test "+numeroTest+" ko : taille physique table != 10",10,table.getNbEntiers()+table.nbAjoutsPossibles());
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test10
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,-3,7};
            int nbEntiers = 3;
            int entier = 0;
            int entierAAjouter = 555;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            table.ajouterApres(entier,entierAAjouter);
            System.out.println("test "+numeroTest+ "ko, il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(IllegalArgumentException e){
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            System.out.println("il fallait lancer une exception de type IllegalArgumentException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test11
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,-3,7,9};
            int nbEntiers = 5;
            int entier = 2;
            int entierAAjouter = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            table.ajouterApres(entier,entierAAjouter);
            System.out.println("test "+numeroTest+ "ko, il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(IllegalArgumentException e){
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            System.out.println("il fallait lancer une exception de type IllegalArgumentException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        //test12
        numeroTest++;
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {1,2,-3,7};
            int nbEntiers = 4;
            int entier = 0;
            int entierAAjouter = 0;
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            System.out.println("ajout "+entierAAjouter+" apres "+entier);
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,nbEntiers);
            table.ajouterApres(entier,entierAAjouter);
            System.out.println("test "+numeroTest+ "ko, il fallait lancer une exception de type IllegalArgumentException");
            System.exit(0);

        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(IllegalArgumentException e){
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
            System.out.println("il fallait lancer une exception de type IllegalArgumentException");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        System.out.println("tous les tests ont reussi!");
        System.out.println();
    }

    private static void testerTableNP() {

        System.out.println();
        System.out.println("tableNegatifsPositifs()");
        System.out.println("-----------------------");

        int numeroTest = 1;
        //test1
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,-3,-1,-9};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,4);
            int[] tableAttendue = {-5,-3,-1,-9};
            int[] tableRecue = table.tableNegatifsPositifs();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",tableAttendue.length,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test2
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {3,8,15,9,2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,5);
            int[] tableAttendue = {2,9,15,8,3};
            int[] tableRecue = table.tableNegatifsPositifs();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",tableAttendue.length,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test3
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-5,6,-1,9,3,-2};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,6);
            int[] tableAttendue = {-5,-1,-2,3,9,6};
            int[] tableRecue = table.tableNegatifsPositifs();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",tableAttendue.length,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test4
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {-3,-8, 1, 2, -5, 3, 4, 5, -9, 9};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,10);
            int[] tableAttendue = {-3,-8,-5,-9,9,5,4,3,2,1};
            int[] tableRecue = table.tableNegatifsPositifs();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",tableAttendue.length,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();

        numeroTest++;
        //test5
        System.out.println("test "+numeroTest);
        try{
            int[] tableARecopier = {};
            System.out.println("table testee : "+Arrays.toString(tableARecopier));
            TableEntiersNonNuls table = new TableEntiersNonNuls(tableARecopier,0);
            int[] tableAttendue = {};
            int[] tableRecue = table.tableNegatifsPositifs();
            if(tableRecue==null){
                System.out.println("test "+numeroTest+ "ko, la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test "+numeroTest+ " ko : taille table renvoyee ko",tableAttendue.length,tableRecue.length);
            assertEquals("test "+numeroTest+ " ko : contenu ko",Arrays.toString(tableAttendue),Arrays.toString(tableRecue));
        }catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
            e.printStackTrace();
            System.exit(0);
        }
        catch(Exception e){
            System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test "+numeroTest+ " ok");
        System.out.println();







        System.out.println("tous les tests ont reussi!");
        System.out.println();

    }



}
