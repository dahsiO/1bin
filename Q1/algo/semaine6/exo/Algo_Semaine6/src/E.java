public class E {

    //3 guerriers tous vivants
    public static EquipeGuerriers eq1(){
        Guerrier[] tableTestee = new Guerrier[3];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("tim",9);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] t1EnVie(){
        Guerrier[] tableTestee = new Guerrier[3];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("tim",9);
        return tableTestee;
    }

    //4 guerriers tous morts
    public static EquipeGuerriers eq2(){
        Guerrier[] tableTestee = new Guerrier[4];
        tableTestee[0] = new Guerrier("leo",0);
        tableTestee[1] = new Guerrier("lea",0);
        tableTestee[2] = new Guerrier("tim",0);
        tableTestee[3] = new Guerrier("tom",0);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] tVide(){
        Guerrier[] tableTestee = new Guerrier[0];
        return tableTestee;
    }

    //5 guerriers le 3eme est mort
    public static EquipeGuerriers eq3(){
        Guerrier[] tableTestee = new Guerrier[5];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("lea",0);
        tableTestee[3] = new Guerrier("tim",9);
        tableTestee[4] = new Guerrier("max",3);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] t3EnVie(){
        Guerrier[] tableTestee = new Guerrier[4];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("tim",9);
        tableTestee[3] = new Guerrier("max",3);
        return tableTestee;
    }

    //4 guerriers le premier est mort
    public static EquipeGuerriers eq4(){
        Guerrier[] tableTestee = new Guerrier[4];
        tableTestee[0] = new Guerrier("leo",0);
        tableTestee[1] = new Guerrier("eva",8);
        tableTestee[2] = new Guerrier("sam",5);
        tableTestee[3] = new Guerrier("tim",9);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] t4EnVie(){
        Guerrier[] tableTestee = new Guerrier[3];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("tim",9);
        return tableTestee;
    }

    //4 guerriers le dernier est mort
    public static EquipeGuerriers eq5(){
        Guerrier[] tableTestee = new Guerrier[4];
        tableTestee[0] = new Guerrier("tim",9);
        tableTestee[1] = new Guerrier("eva",8);
        tableTestee[2] = new Guerrier("sam",5);
        tableTestee[3] = new Guerrier("leo",0);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] t5EnVie(){
        Guerrier[] tableTestee = new Guerrier[3];
        tableTestee[0] = new Guerrier("tim",9);
        tableTestee[1] = new Guerrier("eva",8);
        tableTestee[2] = new Guerrier("sam",5);
        return tableTestee;
    }

    //5 guerriers les 2 premiers sont morts
    public static EquipeGuerriers eq6(){
        Guerrier[] tableTestee = new Guerrier[5];
        tableTestee[0] = new Guerrier("lea",0);
        tableTestee[1] = new Guerrier("leo",0);
        tableTestee[2] = new Guerrier("sam",5);
        tableTestee[3] = new Guerrier("tim",9);
        tableTestee[4] = new Guerrier("max",3);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] t6EnVie(){
        Guerrier[] tableTestee = new Guerrier[3];
        tableTestee[0] = new Guerrier("sam",5);
        tableTestee[1] = new Guerrier("tim",9);
        tableTestee[2] = new Guerrier("max",3);
        return tableTestee;
    }

    //7 guerriers 3 sont morts
    public static EquipeGuerriers eq7(){
        Guerrier[] tableTestee = new Guerrier[7];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("lea",0);
        tableTestee[3] = new Guerrier("tim",9);
        tableTestee[4] = new Guerrier("leo",0);
        tableTestee[5] = new Guerrier("tom",0);
        tableTestee[6] = new Guerrier("max",3);
        return new EquipeGuerriers(tableTestee);
    }

    public static Guerrier[] t7EnVie(){
        Guerrier[] tableTestee = new Guerrier[4];
        tableTestee[0] = new Guerrier("eva",8);
        tableTestee[1] = new Guerrier("sam",5);
        tableTestee[2] = new Guerrier("tim",9);
        tableTestee[3] = new Guerrier("max",3);
        return tableTestee;
    }

    //0 guerrier
    public static EquipeGuerriers eqVide(){
        Guerrier[] tableTestee = new Guerrier[0];
        return new EquipeGuerriers(tableTestee);
    }
}
