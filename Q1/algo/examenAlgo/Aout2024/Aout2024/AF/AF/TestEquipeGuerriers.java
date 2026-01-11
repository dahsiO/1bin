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
            System.out.println("2 -> Tester la methode moyennePointsDeVie()");
            System.out.println("3 -> Tester la methode nombreGuerriersEntre()");
            System.out.println("4 -> Tester la methode ecartMaximum()");
            System.out.println("5 -> Tester la methode combattre()");
            System.out.print("\nEntrez votre choix : ");
            choix=scanner.nextInt();
            switch(choix){
                case 1: testConstructeur();
                    break;
                case 2: testMoyenne();
                    break;
                case 3: testGuerriersEntre();
                    break;
                case 4: testEcartMax();
                    break;
                case 5: testCombattre();
                    break;

            }
        }while(choix >= 1 && choix <= 5);

        System.out.println("\nFin des tests");
    }

    private static Guerrier[] tableFacile1(){
        Guerrier[] table = new Guerrier[3];
        table[0]=new Guerrier("zoe",8);
        table[1]=new Guerrier("sam",3);
        table[2]=new Guerrier("lea",7);
        return table;
    }

    private static Guerrier[] tableFacile2(){
        Guerrier[] table = new Guerrier[4];
        table[0]=new Guerrier("zoe",8);
        table[1]=new Guerrier("sam",3);
        table[2]=new Guerrier("lea",7);
        table[3]=new Guerrier("mia",9);
        return table;
    }

    private static Guerrier[] tableEx1(){
        Guerrier[] table = new Guerrier[6];
        table[0]=new Guerrier("zoe",8);
        table[1]=new Guerrier("sam",3);
        table[2]=new Guerrier("ali",0);
        table[3]=new Guerrier("lea",7);
        table[4]=new Guerrier("tom",0);
        table[5]=new Guerrier("mia",9);
        return table;
    }

    private static Guerrier[] tableEx2(){
        Guerrier[] table = new Guerrier[6];
        table[0]=new Guerrier("zoe",8);
        table[1]=new Guerrier("sam",3);
        table[2]=new Guerrier("ali",0);
        table[3]=new Guerrier("lea",7);
        table[4]=new Guerrier("tom",0);
        table[5]=new Guerrier("mia",9);
        return table;
    }

    private static Guerrier[] tableEx3(){
        Guerrier[] table = new Guerrier[3];
        table[0]=new Guerrier("tim",0);
        table[1]=new Guerrier("bob",0);
        table[2]=new Guerrier("eve",0);
        return table;
    }

    private static void testConstructeur() {
        //TODO
        Guerrier[] tableTous;
        EquipeGuerriers equipe;
        int nombreGuerriersMax;
        System.out.println();
        System.out.println("test 1 : 3 guerriers vivants et pris ");
        tableTous = tableFacile1();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        nombreGuerriersMax = 3;
        System.out.print("le nombre de guerriers max : ");
        System.out.println(nombreGuerriersMax);
        try{
            equipe = new EquipeGuerriers(tableTous,nombreGuerriersMax);
            assertEquals("test 1 ko : nombreGuerriers ko",3,equipe.getNombreGuerriers());
            assertEquals("test 1 ko : contenu tableGuerriers ko","zoe(8) sam(3) lea(7)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");
        System.out.println();

        System.out.println("test 2 : 4 guerriers vivants - les 3 premiers sont pris");
        tableTous = tableFacile2();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        nombreGuerriersMax = 3;
        System.out.print("le nombre de guerriers max : ");
        System.out.println(nombreGuerriersMax);
        try{
            equipe = new EquipeGuerriers(tableTous,nombreGuerriersMax);
            assertEquals("test 2 ko : nombreGuerriers ko",3,equipe.getNombreGuerriers());
            assertEquals("test 2 ko : contenu tableGuerriers ko","zoe(8) sam(3) lea(7)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");
        System.out.println();

        System.out.println("test 3 : exemple 1 de l'enonce");
        tableTous = tableEx1();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        nombreGuerriersMax = 3;
        System.out.print("le nombre de guerriers max : ");
        System.out.println(nombreGuerriersMax);
        try{
            equipe = new EquipeGuerriers(tableTous,nombreGuerriersMax);
            assertEquals("test 3 ko : nombreGuerriers ko",3,equipe.getNombreGuerriers());
            assertEquals("test 3 ko : contenu tableGuerriers ko","zoe(8) sam(3) lea(7)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");

        System.out.println();
        System.out.println("test 4 : exemple 2 de l'enonce");
        tableTous = tableEx2();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        nombreGuerriersMax = 7;
        System.out.print("le nombre de guerriers max : ");
        System.out.println(nombreGuerriersMax);
        try{
            equipe = new EquipeGuerriers(tableTous,nombreGuerriersMax);
            assertEquals("test 4 ko : nombreGuerriers ko",4,equipe.getNombreGuerriers());
            assertEquals("test 4 ko : contenu tableGuerriers ko","zoe(8) sam(3) lea(7) mia(9)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");

        System.out.println();
        System.out.println("test 5 : exemple 3 de l'enonce");
        tableTous = tableEx3();
        System.out.println("la table passee en parametre : ");
        System.out.println(Arrays.toString(tableTous));
        nombreGuerriersMax = 5;
        System.out.print("le nombre de guerriers max : ");
        System.out.println(nombreGuerriersMax);
        try{
            equipe = new EquipeGuerriers(tableTous,nombreGuerriersMax);
            assertEquals("test 5 ko : nombreGuerriers ko",0,equipe.getNombreGuerriers());
            assertEquals("test 5 ko : contenu tableGuerriers ko","aucun guerrier",equipe.toString());
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

    private static void testMoyenne() {
        EquipeGuerriers equipe;

        System.out.println();
        System.out.println("test 1");
        equipe = eq1();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 1 ko : moyenne ko",6.0,equipe.moyennePointsDeVie());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");
        System.out.println();

        System.out.println("test 2");
        equipe = eq2();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 2 ko : moyenne ko",6.75,equipe.moyennePointsDeVie());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");
        System.out.println();

        System.out.println("test 3");
        equipe = eq3();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 3 ko : moyenne ko",5.0,equipe.moyennePointsDeVie());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");
        System.out.println();

        System.out.println("test 4");
        equipe = eqVide();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 4 ko : moyenne ko",0.0,equipe.moyennePointsDeVie());
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

    private static void testGuerriersEntre() {
        EquipeGuerriers equipe;
        int nombrePointsDeVie1;
        int nombrePointsDeVie2;
        System.out.println();
        System.out.println("test 1");
        equipe = eq1();
        nombrePointsDeVie1 = 0;
        nombrePointsDeVie2 = 10;
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("nombre points de vie 1 : "+nombrePointsDeVie1);
        System.out.println("nombre points de vie 2 : "+nombrePointsDeVie2);
        try{
            assertEquals("test 1 ko : nombre ko",3,equipe.nombreGuerriersEntre(nombrePointsDeVie1,nombrePointsDeVie2));
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");
        System.out.println();

        System.out.println("test 2");
        equipe = eq1();
        nombrePointsDeVie1 = 3;
        nombrePointsDeVie2 = 8;
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("nombre points de vie 1 : "+nombrePointsDeVie1);
        System.out.println("nombre points de vie 2 : "+nombrePointsDeVie2);
        try{
            assertEquals("test 2 ko : nombre ko",3,equipe.nombreGuerriersEntre(nombrePointsDeVie1,nombrePointsDeVie2));
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");
        System.out.println();

        System.out.println("test 3");
        equipe = eq1();
        nombrePointsDeVie1 = 4;
        nombrePointsDeVie2 = 10;
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("nombre points de vie 1 : "+nombrePointsDeVie1);
        System.out.println("nombre points de vie 2 : "+nombrePointsDeVie2);
        try{
            assertEquals("test 3 ko : nombre ko",2,equipe.nombreGuerriersEntre(nombrePointsDeVie1,nombrePointsDeVie2));
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");
        System.out.println();

        System.out.println("test 4");
        equipe = eq2();
        nombrePointsDeVie1 = -1;
        nombrePointsDeVie2 = 10;
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("nombre points de vie 1 : "+nombrePointsDeVie1);
        System.out.println("nombre points de vie 2 : "+nombrePointsDeVie2);
        try{
            assertEquals("test 4 ko : nombre ko",4,equipe.nombreGuerriersEntre(nombrePointsDeVie1,nombrePointsDeVie2));
        }catch(Exception e){
            System.out.println("test 4 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 4 ok");
        System.out.println();

        System.out.println("test 5");
        equipe = eq1();
        nombrePointsDeVie1 = 10;
        nombrePointsDeVie2 = 1;
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("nombre points de vie 1 : "+nombrePointsDeVie1);
        System.out.println("nombre points de vie 2 : "+nombrePointsDeVie2);
        try{
            assertEquals("test 5 ko : nombre ko",3,equipe.nombreGuerriersEntre(nombrePointsDeVie1,nombrePointsDeVie2));
        }catch(Exception e){
            System.out.println("test 5 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 5 ok");
        System.out.println();

        System.out.println("test 6");
        equipe = eqVide();
        nombrePointsDeVie1 = 0;
        nombrePointsDeVie2 = 5;
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        System.out.println("nombre points de vie 1 : "+nombrePointsDeVie1);
        System.out.println("nombre points de vie 2 : "+nombrePointsDeVie2);
        try{
            assertEquals("test 6 ko : nombre ko",0,equipe.nombreGuerriersEntre(nombrePointsDeVie1,nombrePointsDeVie2));
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

    private static void testEcartMax() {
        EquipeGuerriers equipe;

        System.out.println();
        System.out.println("test 1");
        equipe = eq1();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 1 ko : ecart max ko",5,equipe.ecartMaximum());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");
        System.out.println();

        System.out.println("test 2");
        equipe = eq2();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 2 ko : ecart max ko",6,equipe.ecartMaximum());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");
        System.out.println();

        System.out.println("test 3");
        equipe = eq3();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 3 ko : ecart max ko",-1,equipe.ecartMaximum());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");
        System.out.println();

        System.out.println("test 4");
        equipe = eqVide();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        try{
            assertEquals("test 4 ko : ecart max ko",-1,equipe.ecartMaximum());
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

    private static void testCombattre() {
        EquipeGuerriers equipe;
        int pointsDeViePerdus;

        System.out.println();
        System.out.println("test 1 (Exemple 1 de l'enonce)");
        equipe = eq1();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        pointsDeViePerdus = 10;
        System.out.println("le nombre de points de vie perdu : "+pointsDeViePerdus);
        try{
            Guerrier guerrier = equipe.combattre(pointsDeViePerdus);
            if(guerrier==null){
                System.out.println("test 1 ko : guerrier renvoye null");
                System.exit(0);
            }
            assertEquals("test 1 ko : guerrier renvoye ko","zoe",guerrier.getNom());
            assertEquals("test 1 ko : nombre guerriers apres combat ko",2,equipe.getNombreGuerriers());
            assertEquals("test 1 ko : equipe apres combat ko","sam(3) lea(7)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 1 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 1 ok");
        System.out.println();

        System.out.println("test 2 (Exemple 2 de l'enonce)");
        equipe = eq2();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        pointsDeViePerdus = 2;
        System.out.println("le nombre de points de vie perdu : "+pointsDeViePerdus);
        try{
            Guerrier guerrier = equipe.combattre(pointsDeViePerdus);
            if(guerrier==null){
                System.out.println("test 2 ko : guerrier renvoye null");
                System.exit(0);
            }
            assertEquals("test 2 ko : guerrier renvoye ko","zoe",guerrier.getNom());
            assertEquals("test 2 ko : nombre guerriers apres combat ko",4,equipe.getNombreGuerriers());
            assertEquals("test 2 ko : equipe apres combat ko","sam(3) lea(7) mia(9) zoe(6)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 2 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 2 ok");
        System.out.println();

        System.out.println("test 3");
        equipe = eq3();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        pointsDeViePerdus = 3;
        System.out.println("le nombre de points de vie perdu : "+pointsDeViePerdus);
        try{
            Guerrier guerrier = equipe.combattre(pointsDeViePerdus);
            if(guerrier==null){
                System.out.println("test 3 ko : guerrier renvoye null");
                System.exit(0);
            }
            assertEquals("test 3 ko : guerrier renvoye ko","bob",guerrier.getNom());
            assertEquals("test 3 ko : nombre guerriers apres combat ko",1,equipe.getNombreGuerriers());
            assertEquals("test 3 ko : equipe apres combat ko","bob(2)",equipe.toString());
        }catch(Exception e){
            System.out.println("test 3 ko : il y a eu une exception inattendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("test 3 ok");
        System.out.println();

        System.out.println("test 4");
        equipe = eqVide();
        System.out.print("l'equipe : ");
        System.out.println(equipe.toString());
        pointsDeViePerdus = 3;
        System.out.println("le nombre de points de vie perdu : "+pointsDeViePerdus);
        try{
            Guerrier guerrier = equipe.combattre(pointsDeViePerdus);
            if(guerrier!=null){
                System.out.println("test 4 ko : la methode aurait du renvoyer null");
                System.exit(0);
            }
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


    private static EquipeGuerriers eq1(){
        Guerrier[] table = new Guerrier[3];
        table[0]=new Guerrier("zoe",8);
        table[1]=new Guerrier("sam",3);
        table[2]=new Guerrier("lea",7);
        return new EquipeGuerriers(table,3,3);
    }

    private static EquipeGuerriers eq2(){
        Guerrier[] table = new Guerrier[4];
        table[0]=new Guerrier("zoe",8);
        table[1]=new Guerrier("sam",3);
        table[2]=new Guerrier("lea",7);
        table[3]=new Guerrier("mia",9);
        return new EquipeGuerriers(table,7,4);
    }

    private static EquipeGuerriers eq3(){
        Guerrier[] table = new Guerrier[1];
        table[0]=new Guerrier("bob",5);
        return new EquipeGuerriers(table,5,1);
    }

    private static EquipeGuerriers eqVide(){
        Guerrier[] table = new Guerrier[0];
        return new EquipeGuerriers(table,4,0);
    }


}
