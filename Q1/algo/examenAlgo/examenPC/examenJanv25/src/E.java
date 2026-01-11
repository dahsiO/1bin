public class E {

    //pour methode estTrieeSansDoublon

    public static Etudiant[] t1NonTriee(){
        Etudiant[] tableTestee = new Etudiant[6];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2274,"leo",5);
        tableTestee[2] = new Etudiant(2317,"lea",0);
        tableTestee[3] = new Etudiant(2320,"sam",14);
        tableTestee[4] = new Etudiant(2318,"tim",10);
        tableTestee[5] = new Etudiant(2334,"mia",9.5);
        return tableTestee;
    }

    public static Etudiant[] t2NonTriee(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2199,"sam",14);
        tableTestee[2] = new Etudiant(2325,"tim",10);
        tableTestee[3] = new Etudiant(2385,"joe",17);
        return tableTestee;
    }

    public static Etudiant[] t3NonTriee(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2320,"sam",14);
        tableTestee[2] = new Etudiant(2325,"tim",10);
        tableTestee[3] = new Etudiant(2324,"joe",17);
        return tableTestee;
    }

    public static Etudiant[] t4TrieeAvecDoublon(){
        Etudiant[] tableTestee = new Etudiant[5];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2274,"leo",5);
        tableTestee[2] = new Etudiant(2317,"lea",0);
        tableTestee[3] = new Etudiant(2317,"sam",14);
        tableTestee[4] = new Etudiant(2334,"mia",9.5);
        return tableTestee;
    }

    public static Etudiant[] t5TrieeAvecDoublon(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2320,"sam",14);
        tableTestee[2] = new Etudiant(2325,"tim",10);
        tableTestee[3] = new Etudiant(2325,"joe",17);
        return tableTestee;
    }

    public static Etudiant[] t6TrieeAvecDoublon(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2320, "eva",12);
        tableTestee[1] = new Etudiant(2320,"sam",14);
        tableTestee[2] = new Etudiant(2325,"tim",10);
        tableTestee[3] = new Etudiant(2385,"joe",17);
        return tableTestee;
    }

    public static Etudiant[] t7NonTrieeAvecDoublon(){
        Etudiant[] tableTestee = new Etudiant[6];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2274,"leo",5);
        tableTestee[2] = new Etudiant(2317,"lea",0);
        tableTestee[3] = new Etudiant(2320,"sam",14);
        tableTestee[4] = new Etudiant(2317,"tim",10);
        tableTestee[5] = new Etudiant(2334,"mia",9.5);
        return tableTestee;
    }

    public static Etudiant[] t8TrieeSansDoublon(){
        Etudiant[] tableTestee = new Etudiant[9];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2274,"leo",5);
        tableTestee[2] = new Etudiant(2317,"lea",0);
        tableTestee[3] = new Etudiant(2320,"sam",14);
        tableTestee[4] = new Etudiant(2325,"tim",10);
        tableTestee[5] = new Etudiant(2334,"mia",9.5);
        tableTestee[6] = new Etudiant(2359,"tom",7.5);
        tableTestee[7] = new Etudiant(2377,"bob",8);
        tableTestee[8] = new Etudiant(2385,"joe",17);
        return tableTestee;
    }

    public static Etudiant[] t9TrieeSansDoublon(){
        Etudiant[] tableTestee = new Etudiant[8];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2274,"leo",5);
        tableTestee[2] = new Etudiant(2317,"lea",0);
        tableTestee[3] = new Etudiant(2320,"sam",14);
        tableTestee[4] = new Etudiant(2325,"tim",10);
        tableTestee[5] = new Etudiant(2334,"mia",9.5);
        tableTestee[6] = new Etudiant(2359,"tom",7.5);
        tableTestee[7] = new Etudiant(2377,"bob",8);
        return tableTestee;
    }

    public static Etudiant[] t10TrieeSansDoublon() {
        Etudiant[] tableTestee = new Etudiant[1] ;
        tableTestee[0] = new Etudiant(2205, "eva",12);
        return tableTestee;
    }

    //tous en reussite
    public static Resultats r1(){
        Etudiant[] tableTestee = new Etudiant[3];
        tableTestee[0] = new Etudiant(2205, "eva",13);
        tableTestee[1] = new Etudiant(2320,"sam",18);
        tableTestee[2] = new Etudiant(2325,"tim",11);
        return new Resultats(tableTestee);
    }

    public static Etudiant[] t1Valides(){
        Etudiant[] tableTestee = new Etudiant[3];
        tableTestee[0] = new Etudiant(2205, "eva",13);
        tableTestee[1] = new Etudiant(2320,"sam",18);
        tableTestee[2] = new Etudiant(2325,"tim",11);
        return tableTestee;
    }

    //4 etudiants tous en echec
    public static Resultats r2(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2274,"leo",5);
        tableTestee[1] = new Etudiant(2317,"lea",0);
        tableTestee[2] = new Etudiant(2334,"mia",9.5);
        tableTestee[3] = new Etudiant(2359,"tom",7.5);
        return new Resultats(tableTestee);
    }

    public static Etudiant[] t2Valides(){
        Etudiant[] tableTestee = new Etudiant[0];
        return tableTestee;
    }

    //9 etudiants avec quelques reussites dont 1 10
    public static Resultats r3(){
        Etudiant[] tableTestee = new Etudiant[9];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2274,"leo",5);
        tableTestee[2] = new Etudiant(2317,"lea",0);
        tableTestee[3] = new Etudiant(2320,"sam",14);
        tableTestee[4] = new Etudiant(2325,"tim",10);
        tableTestee[5] = new Etudiant(2334,"mia",9.5);
        tableTestee[6] = new Etudiant(2359,"tom",7.5);
        tableTestee[7] = new Etudiant(2377,"bob",8);
        tableTestee[8] = new Etudiant(2385,"joe",17);
        return new Resultats(tableTestee);
    }

    public static Etudiant[] t3Valides(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2205, "eva",12);
        tableTestee[1] = new Etudiant(2320,"sam",14);
        tableTestee[2] = new Etudiant(2325,"tim",10);
        tableTestee[3] = new Etudiant(2385,"joe",17);
        return tableTestee;
    }

    // 1 etudiant
    public static Resultats r4(){
        Etudiant[] tableTestee = new Etudiant[1];
        tableTestee[0] = new Etudiant(2385,"joe",10);
        return new Resultats(tableTestee);
    }

    public static Etudiant[] t4Valides(){
        Etudiant[] tableTestee = new Etudiant[1];
        tableTestee[0] = new Etudiant(2385,"joe",10);
        return tableTestee;
    }

    public static Resultats r5(){
        Etudiant[] tableTestee = new Etudiant[1];
        tableTestee[0] = new Etudiant(2385,"joe",9);
        return new Resultats(tableTestee);
    }

    public static Etudiant[] t5Valides(){
        Etudiant[] tableTestee = new Etudiant[0];
        return tableTestee;
    }

    // ex de l'enonce pour mediane
    public static Resultats rEnonce(){
        Etudiant[] tableTestee = new Etudiant[7];
        tableTestee[0] = new Etudiant(2205, "lea",9);
        tableTestee[1] = new Etudiant(2334,"leo",18);
        tableTestee[2] = new Etudiant(2359,"tim",2);
        tableTestee[3] = new Etudiant(2377,"tom",15);
        tableTestee[4] = new Etudiant(2385,"sam",16);
        tableTestee[5] = new Etudiant(2389,"eva",13);
        tableTestee[6] = new Etudiant(2392,"joe",4);
        return new Resultats(tableTestee);
    }

    public static Etudiant[] tEnonceValides(){
        Etudiant[] tableTestee = new Etudiant[4];
        tableTestee[0] = new Etudiant(2334,"leo",18);
        tableTestee[1] = new Etudiant(2377,"tom",15);
        tableTestee[2] = new Etudiant(2385,"sam",16);
        tableTestee[3] = new Etudiant(2389,"eva",13);
        return tableTestee;
    }

    // ex de l'enonce pour mediane
    public static Resultats rEnonceAvec3X2(){
        Etudiant[] tableTestee = new Etudiant[7];
        tableTestee[0] = new Etudiant(2205, "lea",2);
        tableTestee[1] = new Etudiant(2334,"leo",18);
        tableTestee[2] = new Etudiant(2359,"tim",2);
        tableTestee[3] = new Etudiant(2377,"tom",15);
        tableTestee[4] = new Etudiant(2385,"sam",16);
        tableTestee[5] = new Etudiant(2389,"eva",13);
        tableTestee[6] = new Etudiant(2392,"joe",2);
        return new Resultats(tableTestee);
    }

}
