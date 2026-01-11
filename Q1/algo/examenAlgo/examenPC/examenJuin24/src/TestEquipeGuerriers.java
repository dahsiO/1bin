import java.util.Arrays;

public class TestEquipeGuerriers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu la valeur qu'on s'attendait a recevoir
     * @param recu la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {
                System.out.println(messageErreur);
                System.out.println("--> Attendu : " + attendu);
                System.out.println("--> Recu : " + recu);
                System.exit(0);
            }
        } else {
            if (attendu instanceof Character && recu instanceof String) {
                attendu = "" + attendu;
            }
            if (attendu instanceof String && recu instanceof Character) {
                recu = "" + recu;
            }
            if (!attendu.equals(recu)) {
                System.out.println(messageErreur);
                System.out.println("--> Attendu : " + attendu);
                System.out.println("--> Recu : " + recu);
                System.exit(0);
            }
        }

    }

    public static void main(String [] args){

        int choix;
        System.out.println("***********************************************");
        System.out.println("Programme Test pour la classe EquipeGuerriers :");
        System.out.println("***********************************************");
        do{
            System.out.println();
            System.out.println("1 -> Tester le constructeur'");
            System.out.println("2 -> Tester la methode indiceMeilleurGuerrier()");
            System.out.println("3 -> Tester la methode supprimerALIndice()");
            System.out.println("4 -> Tester la methode selectionnerGuerrierAuCombat()");
            System.out.println("5 -> Tester la methode jouer()");
            System.out.println("6 -> Tester la methode tableTrieeGuerriers()");
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: testConstructeur();
                    break;
                case 2: testIndiceMeilleur();
                    break;
                case 3: testSupprimer();
                    break;
                case 4: testSelectionner();
                    break;
                case 5: testJouer();
                    break;
                case 6: testTri();
                    break;
            }
        }while(choix >= 1 && choix <= 6);

        System.out.println("\nFin des tests");
    }



    private static Guerrier[] tableTous7(){
        Guerrier[] table = new Guerrier[7];
        table[0]=new Guerrier("sam",3);
        table[1]=new Guerrier("hugo",5);
        table[2]=new Guerrier("marie",1);
        table[3]=new Guerrier("lea",6);
        table[4]=new Guerrier("tom",2);
        table[5]=new Guerrier("mia",1);
        table[6]=new Guerrier("eva",4);
        return table;
    }

    private static Guerrier[] tableTous7AvecNull(){
        Guerrier[] table = new Guerrier[7];
        table[0]=new Guerrier("sam",3);
        table[1]=new Guerrier("hugo",5);
        table[2]=new Guerrier("marie",6);
        table[3]=new Guerrier("lea",1);
        table[4]=new Guerrier("tom",2);
        table[5]=null;
        table[6]=null;
        return table;
    }

    private static Guerrier[] tableTous6(){
        Guerrier[] table = new Guerrier[6];
        table[0]=new Guerrier("sam",8);
        table[1]=new Guerrier("hugo",5);
        table[2]=new Guerrier("marie",1);
        table[3]=new Guerrier("lea",6);
        table[4]=new Guerrier("tom",2);
        table[5]=new Guerrier("mia",9);
        return table;
    }

    private static Guerrier[] tableTous5(){
        Guerrier[] table = new Guerrier[5];
        table[0]=new Guerrier("sam",8);
        table[1]=new Guerrier("hugo",5);
        table[2]=new Guerrier("marie",1);
        table[3]=new Guerrier("lea",6);
        table[4]=new Guerrier("tom",2);
        return table;
    }

    private static Guerrier[] tableTous5ExAequo(){
        Guerrier[] table = new Guerrier[5];
        table[0]=new Guerrier("sam",3);
        table[1]=new Guerrier("hugo",5);
        table[2]=new Guerrier("marie",1);
        table[3]=new Guerrier("lea",5);
        table[4]=new Guerrier("tom",5);
        return table;
    }



    private static void testConstructeur() {

        Guerrier[] tableTous;
        int pointsDeVieMin;
        EquipeGuerriers equipe;
        System.out.println();
        System.out.println("test 1");
        tableTous = tableTous6();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        pointsDeVieMin = 1;
        System.out.print("le nombre de points de vie min : ");
        System.out.println(pointsDeVieMin);
        try{
            equipe = new EquipeGuerriers(tableTous,pointsDeVieMin);
            assertEquals("test 1 ko : nombreGuerriers ko",6,equipe.getNombreGuerriers());
            assertEquals("test 1 ko : contenu tableGuerriers ko","sam(8) hugo(5) marie(1) lea(6) tom(2) mia(9)",equipe.toString());
            assertEquals("test 1 ko : guerrierAuCombat ko",null,equipe.getGuerrierAuCombat());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2");
        tableTous = tableTous6();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        pointsDeVieMin = 3;
        System.out.print("le nombre de points de vie min : ");
        System.out.println(pointsDeVieMin);
        try{
            equipe = new EquipeGuerriers(tableTous,pointsDeVieMin);
            assertEquals("test 2 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 2 ko : contenu tableGuerriers ko","sam(8) hugo(5) lea(6) mia(9)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3");
        tableTous = tableTous6();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        pointsDeVieMin = 5;
        System.out.print("le nombre de points de vie min : ");
        System.out.println(pointsDeVieMin);
        try{
            equipe = new EquipeGuerriers(tableTous,pointsDeVieMin);
            assertEquals("test 3 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 3 ko : contenu tableGuerriers ko","sam(8) hugo(5) lea(6) mia(9)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4");
        tableTous = tableTous6();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        pointsDeVieMin = 10;
        System.out.print("le nombre de points de vie min : ");
        System.out.println(pointsDeVieMin);
        try{
            equipe = new EquipeGuerriers(tableTous,pointsDeVieMin);
            assertEquals("test 4 ko : nombreGuerriers ko",0,equipe.getNombreGuerriers());
            assertEquals("test 4 ko : contenu tableGuerriers ko","aucun guerrier",equipe.toString());
        }catch(Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("test 5");
        tableTous = tableTous5();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        pointsDeVieMin = 3;
        System.out.print("le nombre de points de vie min : ");
        System.out.println(pointsDeVieMin);
        try{
            equipe = new EquipeGuerriers(tableTous,pointsDeVieMin);
            assertEquals("test 5 ko : nombreGuerriers ko",3,equipe.getNombreGuerriers());
            assertEquals("test 5 ko : contenu tableGuerriers ko","sam(8) hugo(5) lea(6)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 5 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 5 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testIndiceMeilleur() {

        EquipeGuerriers equipe;

        System.out.println();
        System.out.println("test 1 (tableGuerriers.length = 7 - nombreGuerriers = 7)");
        equipe = new EquipeGuerriers(tableTous7(),7,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 1 ko : indice ko",3,equipe.indiceMeilleurGuerrier());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 (tableGuerriers.length = 7 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous7AvecNull(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 2 ko : indice ko",2,equipe.indiceMeilleurGuerrier());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 (tableGuerriers.length = 7 - nombreGuerriers = 3)");
        equipe = new EquipeGuerriers(tableTous7(),3,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 3 ko : indice ko",1,equipe.indiceMeilleurGuerrier());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 (tableGuerriers.length = 5 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous5(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 4 ko : indice ko",0,equipe.indiceMeilleurGuerrier());
        }catch(Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("test 5 (tableGuerriers.length = 6 - nombreGuerriers = 6)");
        equipe = new EquipeGuerriers(tableTous6(),6,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 5 ko : indice ko",5,equipe.indiceMeilleurGuerrier());
        }catch(Exception e){
            System.out.println("test 5 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 5 ok");

        System.out.println();
        System.out.println("test 6 (tableGuerriers.length = 5 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous5ExAequo(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 6 ko : indice ko",1,equipe.indiceMeilleurGuerrier());
        }catch(Exception e){
            System.out.println("test 6 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 6 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testSupprimer() {
        EquipeGuerriers equipe;

        System.out.println();
        System.out.println("test 1 (tableGuerriers.length = 7 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous7AvecNull(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("suppression guerrier a l'indice 3");
        try{
            equipe.supprimerALIndice(3);
            assertEquals("test 1 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 1 ko : contenu tableGuerriers ko","sam(3) hugo(5) marie(6) tom(2)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 (tableGuerriers.length = 7 - nombreGuerriers = 7)");
        equipe = new EquipeGuerriers(tableTous7(),7,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("suppression guerrier a l'indice 3");
        try{
            equipe.supprimerALIndice(3);
            assertEquals("test 2 ko : nombreGuerriers ko",6,equipe.getNombreGuerriers());
            assertEquals("test 2 ko : contenu tableGuerriers ko","sam(3) hugo(5) marie(1) tom(2) mia(1) eva(4)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 (tableGuerriers.length = 5 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous5(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("suppression guerrier a l'indice 0");
        try{
            equipe.supprimerALIndice(0);
            assertEquals("test 3 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 3 ko : contenu tableGuerriers ko","hugo(5) marie(1) lea(6) tom(2)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 (tableGuerriers.length = 5 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous5(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("suppression guerrier a l'indice 4");
        try{
            equipe.supprimerALIndice(4);
            assertEquals("test 4 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 4 ko : contenu tableGuerriers ko","sam(8) hugo(5) marie(1) lea(6)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("test 5 (tableGuerriers.length = 5 - nombreGuerriers = 1)");
        equipe = new EquipeGuerriers(tableTous5(),1,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("suppression guerrier a l'indice 0");
        try{
            equipe.supprimerALIndice(0);
            assertEquals("test 5 ko : nombreGuerriers ko",0,equipe.getNombreGuerriers());
            assertEquals("test 5 ko : contenu tableGuerriers ko","aucun guerrier",equipe.toString());
        }catch(Exception e){
            System.out.println("test 5 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testSelectionner() {
        EquipeGuerriers equipe;

        System.out.println();
        System.out.println("test 1 (tableGuerriers.length = 7 - nombreGuerriers = 7)");
        equipe = new EquipeGuerriers(tableTous7(),7,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            equipe.selectionnerGuerrierAuCombat();
            assertEquals("test 1 ko : guerrierAuCombat","lea(6)",equipe.getGuerrierAuCombat().toString());
            assertEquals("test 1 ko : nombreGuerriers ko",6,equipe.getNombreGuerriers());
            assertEquals("test 1 ko : contenu tableGuerriers ko","sam(3) hugo(5) marie(1) tom(2) mia(1) eva(4)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 (tableGuerriers.length = 7 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous7AvecNull(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            equipe.selectionnerGuerrierAuCombat();
            assertEquals("test 2 ko : guerrierAuCombat","marie(6)",equipe.getGuerrierAuCombat().toString());
            assertEquals("test 2 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 2 ko : contenu tableGuerriers ko","sam(3) hugo(5) lea(1) tom(2)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 (tableGuerriers.length = 5 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous5(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            equipe.selectionnerGuerrierAuCombat();
            assertEquals("test 3 ko : guerrierAuCombat","sam(8)",equipe.getGuerrierAuCombat().toString());
            assertEquals("test 3 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 3 ko : contenu tableGuerriers ko","hugo(5) marie(1) lea(6) tom(2)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testJouer() {
        EquipeGuerriers equipe;
        int degat;

        System.out.println();
        System.out.println("test 1 (tableGuerriers.length = 7 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous7AvecNull(),5,new Guerrier("bob",7));
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("guerrier au combat : "+equipe.getGuerrierAuCombat());
        degat = 2;
        System.out.println("nombre de points de vie perdu : "+degat);
        try{
            equipe.jouer(degat);
            assertEquals("test 1 ko : guerrierAuCombat ko",null,equipe.getGuerrierAuCombat());
            assertEquals("test 1 ko : nombreGuerriers ko",6,equipe.getNombreGuerriers());
            assertEquals("test 1 ko : contenu tableGuerriers ko","sam(3) hugo(5) marie(6) lea(1) tom(2) bob(5)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 (tableGuerriers.length = 7 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous7AvecNull(),5,new Guerrier("bob",7));
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("guerrier au combat : "+equipe.getGuerrierAuCombat());
        degat = 10;
        System.out.println("nombre de points de vie perdu : "+degat);
        try{
            equipe.jouer(degat);
            assertEquals("test 2 ko : guerrierAuCombat ko",null,equipe.getGuerrierAuCombat());
            assertEquals("test 2 ko : nombreGuerriers ko",5,equipe.getNombreGuerriers());
            assertEquals("test 2 ko : contenu tableGuerriers ko","sam(3) hugo(5) marie(6) lea(1) tom(2)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 (tableGuerriers.length = 6 - nombreGuerriers = 2)");
        equipe = new EquipeGuerriers(tableTous6(),2,new Guerrier("bob",6));
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("guerrier au combat : "+equipe.getGuerrierAuCombat());
        degat = 1;
        System.out.println("nombre de points de vie perdu : "+degat);
        try{
            equipe.jouer(degat);
            assertEquals("test 3 ko : guerrierAuCombat ko",null,equipe.getGuerrierAuCombat());
            assertEquals("test 3 ko : nombreGuerriers ko",3,equipe.getNombreGuerriers());
            assertEquals("test 3 ko : contenu tableGuerriers ko","sam(8) hugo(5) bob(5)",equipe.toString());
        }catch(Exception e) {
            System.out.println("test 3 ko : il y a eu une exception inattendue");
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 (tableGuerriers.length = 6 - nombreGuerriers = 0)");
        equipe = new EquipeGuerriers(tableTous6(),0,new Guerrier("bob",6));
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("guerrier au combat : "+equipe.getGuerrierAuCombat());
        degat = 1;
        System.out.println("nombre de points de vie perdu : "+degat);
        try{
            equipe.jouer(degat);
            assertEquals("test 4 ko : guerrierAuCombat ko",null,equipe.getGuerrierAuCombat());
            assertEquals("test 4 ko : nombreGuerriers ko",1,equipe.getNombreGuerriers());
            assertEquals("test 4 ko : contenu tableGuerriers ko","bob(5)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

    private static void testTri() {
        EquipeGuerriers equipe;
        Guerrier[] tableTrieeAttendue;
        Guerrier[] tableTrieeRecue;

        System.out.println();
        System.out.println("test 1 (tableGuerriers.length = 6 - nombreGuerriers = 6)");
        equipe = new EquipeGuerriers(tableTous6(),6,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        tableTrieeAttendue = new Guerrier[6];
        tableTrieeAttendue[1]=new Guerrier("sam",8);
        tableTrieeAttendue[3]=new Guerrier("hugo",5);
        tableTrieeAttendue[5]=new Guerrier("marie",1);
        tableTrieeAttendue[2]=new Guerrier("lea",6);
        tableTrieeAttendue[4]=new Guerrier("tom",2);
        tableTrieeAttendue[0]=new Guerrier("mia",9);
        try{
            tableTrieeRecue = equipe.tableTrieeGuerriers();
            if(tableTrieeRecue==null){
                System.out.println("test 1 ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test 1 ko",Arrays.toString(tableTrieeAttendue),Arrays.toString(tableTrieeRecue));

        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");

        System.out.println();
        System.out.println("test 2 (tableGuerriers.length = 6 - nombreGuerriers = 5)");
        equipe = new EquipeGuerriers(tableTous6(),5,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        tableTrieeAttendue = new Guerrier[5];
        tableTrieeAttendue[0]=new Guerrier("sam",8);
        tableTrieeAttendue[2]=new Guerrier("hugo",5);
        tableTrieeAttendue[4]=new Guerrier("marie",1);
        tableTrieeAttendue[1]=new Guerrier("lea",6);
        tableTrieeAttendue[3]=new Guerrier("tom",2);
        try{
            tableTrieeRecue = equipe.tableTrieeGuerriers();
            if(tableTrieeRecue==null){
                System.out.println("test 2 ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test 2 ko",Arrays.toString(tableTrieeAttendue),Arrays.toString(tableTrieeRecue));

        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");

        System.out.println();
        System.out.println("test 3 (tableGuerriers.length = 7 - nombreGuerriers = 7)");
        equipe = new EquipeGuerriers(tableTous7(),7,null);
        System.out.println("l'equipe : ");
        System.out.println(equipe.toString());
        tableTrieeAttendue = new Guerrier[7];
        tableTrieeAttendue[3]=new Guerrier("sam",3);
        tableTrieeAttendue[1]=new Guerrier("hugo",5);
        tableTrieeAttendue[5]=new Guerrier("marie",1);
        tableTrieeAttendue[0]=new Guerrier("lea",6);
        tableTrieeAttendue[4]=new Guerrier("tom",2);
        tableTrieeAttendue[6]=new Guerrier("mia",1);
        tableTrieeAttendue[2]=new Guerrier("eva",4);

        try{
            tableTrieeRecue = equipe.tableTrieeGuerriers();
            if(tableTrieeRecue==null){
                System.out.println("test 3 ko : la table renvoyee est null");
                System.exit(0);
            }
            assertEquals("test 3 ko",Arrays.toString(tableTrieeAttendue),Arrays.toString(tableTrieeRecue));

        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");




        System.out.println();
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }

}
