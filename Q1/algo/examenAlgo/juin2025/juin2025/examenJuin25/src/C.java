public class C {

    //4 articles prix tous differents - table taille physique 4 - le max est le premier
    public static Article[] t1(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,14);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(321,12);
        return tableTestee;
    }

    //4 articles prix tous differents - table taille physique 6 - le min est le premier et le max le dernier
    public static Article[] t1Bis(){
        Article[] tableTestee = new Article[6];
        tableTestee[0] = new Article(999,5);
        tableTestee[1] = new Article(321,12);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(123,14);
        return tableTestee;
    }

    //4 articles prix tous differents - tries selon l'ordre croissant - table taille physique 4
    public static Article[] t1Croissant(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(999,5);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3] = new Article(123,14);
        return tableTestee;
    }

    //4 articles prix tous differents - tries selon l'ordre decroissant - table taille physique 4
    public static Article[] t1Decroissant(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,14);
        tableTestee[1] = new Article(321,12);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(999,5);
        return tableTestee;
    }



    public static int n1(){
        return 4;
    }

    public static Article[] tableMinMax1(){
        Article[] tableMinMax = new Article[2];
        tableMinMax[0] = new Article(999,5);
        tableMinMax[1] = new Article(123,14);
        return tableMinMax;
    }

    public static Article[] t1Moins999V1(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,14);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3] = new Article(321,12);
        return tableTestee;
    }

    public static Article[] t1Moins999V2(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,14);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3] = null;
        return tableTestee;
    }

    public static Article[] t1Moins123V1(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(999,5);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3] = new Article(321,12);
        return tableTestee;
    }

    public static Article[] t1Moins123V2(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(999,5);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3]= null;
        return tableTestee;
    }

    public static Article[] t1Moins321V1(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,14);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(321,12);
        return tableTestee;
    }

    public static Article[] t1Moins321V2(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,14);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = null;
        return tableTestee;
    }




    //5 articles - table taille physique 7
    //il y a des ex-aequos pour les min et max
    public static Article[] t2(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(123,12);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(321,12);
        tableTestee[4] = new Article(555,5);
        tableTestee[5] = null;
        tableTestee[6] = null;
        return tableTestee;
    }

    public static int n2(){
        return 5;
    }

    public static Article[] tableMinMax2(){
        Article[] tableMinMax = new Article[2];
        tableMinMax[0] = new Article(999,5);
        tableMinMax[1] = new Article(123,12);
        return tableMinMax;
    }

    public static Article[] t2Moins123V1(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(999,5);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3] = new Article(555,5);
        tableTestee[4] = new Article(555,5);
        tableTestee[5] = null;
        tableTestee[6] = null;
        return tableTestee;
    }
    public static Article[] t2Moins123V2(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(999,5);
        tableTestee[1] = new Article(714,9.5);
        tableTestee[2] = new Article(321,12);
        tableTestee[3] = new Article(555,5);
        tableTestee[4] = null;
        tableTestee[5] = null;
        tableTestee[6] = null;
        return tableTestee;
    }

    public static Article[] t2Moins555V1(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(123,12);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(321,12);
        tableTestee[4] = new Article(555,5);
        tableTestee[5] = null;
        tableTestee[6] = null;
        return tableTestee;
    }

    public static Article[] t2Moins555V2(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(123,12);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(321,12);
        tableTestee[4] = null;
        tableTestee[5] = null;
        tableTestee[6] = null;
        return tableTestee;
    }

    //5 articles - table taille physique 7
    //il y a des ex-aequos pour les min et le max est le dernier
    public static Article[] t2Melange(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(132,10);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,5);
        tableTestee[3] = new Article(555,5);
        tableTestee[4] = new Article(123,12);
        tableTestee[5] = null;
        tableTestee[6] = null;
        return tableTestee;
    }


    //5 articles - table taille physique 5
    //tous les memes prix
    public static Article[] t3(){
        Article[] tableTestee = new Article[5];
        tableTestee[0] = new Article(123,12);
        tableTestee[1] = new Article(999,12);
        tableTestee[2] = new Article(714,12);
        tableTestee[3] = new Article(321,12);
        tableTestee[4] = new Article(555,12);
        return tableTestee;
    }

    public static int n3(){
        return 5;
    }

    public static Article[] tableMinMax3(){
        Article[] tableMinMax = new Article[2];
        tableMinMax[0] = new Article(123,12);
        tableMinMax[1] = new Article(123,12);
        return tableMinMax;
    }

    //1 article - table taille physique 5
    //tous les memes prix
    public static Article[] t4(){
        Article[] tableTestee = new Article[5];
        tableTestee[0] = new Article(123,12);
        return tableTestee;
    }

    public static int n4(){
        return 1;
    }
    
    public static Article[] tableMinMax4(){
        Article[] tableMinMax = new Article[1];
        tableMinMax[0] = new Article(123,12);
        return tableMinMax;
    }

    //0 article - table taille physique 3
       public static Article[] tVide(){
        Article[] tableTestee = new Article[3];
        return tableTestee;
    }

    public static int nVide(){
        return 0;
    }

    public static Article[] tableMinMax5(){
        Article[] tableMinMax = new Article[0];
        return tableMinMax;
    }

    public static Article[] tableRecueEnonce(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(123,11);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(123,12);
        tableTestee[3] = new Article(999,4);
        tableTestee[4] = new Article(714,9.5);
        tableTestee[5] = new Article(321,10);
        tableTestee[6] = new Article(321,11);
        return tableTestee;
    }

    public static Article[] tableAttendueEnonce(){
        Article[] tableTestee = new Article[7];
        tableTestee[0] = new Article(123,12);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(321,11);
        return tableTestee;
    }

    public static int nEnonce(){
        return 4;
    }

    //4 des 6 articles portent les memes numeros, les prix sont croissants
    public static Article[] tableRecueCroissant(){
        Article[] tableTestee = new Article[6];
        tableTestee[0] = new Article(123,11);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(123,12);
        tableTestee[4] = new Article(123,14);
        tableTestee[5] = new Article(123,15);
        return tableTestee;
    }

    //4 des 6 articles portent les memes numeros, les prix sont croissants
    public static Article[] tableRecueDeCroissant(){
        Article[] tableTestee = new Article[6];
        tableTestee[0] = new Article(123,15);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
        tableTestee[3] = new Article(123,14);
        tableTestee[4] = new Article(123,12);
        tableTestee[5] = new Article(123,11);
        return tableTestee;
    }

    public static Article[] tableCrDeCr(){
        Article[] tableTestee = new Article[6];
        tableTestee[0] = new Article(123,15);
        tableTestee[1] = new Article(999,5);
        tableTestee[2] = new Article(714,9.5);
      
        return tableTestee;
    }

    public static int nCrDecr(){
        return 3;
    }


    //les 4 articles portent les memes numeros, les prix sont croissants
    public static Article[] tableRecueCroissantUn(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,11);
        tableTestee[1] = new Article(123,12);
        tableTestee[2] = new Article(123,14);
        tableTestee[3] = new Article(123,15);
        return tableTestee;
    }

    //Les 4 articles portent les memes numeros, les prix sont croissants
    public static Article[] tableRecueDeCroissantUn(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,15);
        tableTestee[1] = new Article(123,14);
        tableTestee[2] = new Article(123,12);
        tableTestee[3] = new Article(123,11);
        return tableTestee;
    }

    //Les 4 articles portent les memes numeros, les prix sont melanges
    public static Article[] tableRecueMelUn(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,12);
        tableTestee[1] = new Article(123,14);
        tableTestee[2] = new Article(123,15);
        tableTestee[3] = new Article(123,11);
        return tableTestee;
    }

    // un seul article
    public static Article[] tableUn(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,15);

        return tableTestee;
    }

    public static int nUn(){
        return 1;
    }

    public static Article[] tableUnMoins123V1(){
        Article[] tableTestee = new Article[4];
        tableTestee[0] = new Article(123,15);
        return tableTestee;
    }

    public static Article[] tableUnMoins123V2(){
        Article[] tableTestee = new Article[4];
        return tableTestee;
    }
    
}
