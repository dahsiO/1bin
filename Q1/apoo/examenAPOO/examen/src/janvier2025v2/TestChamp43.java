package janvier2025v2;

public class TestChamp43 {
    public static void main(String[] args) {
        //creation de UE
        UE ue2 = new UE("BINV-1090 ","Math 1","BIN");

        // creation des professur interne
        ProfInterne loic = new ProfInterne("Loic","Lecharlier",2000.0);
        // creation des prof Externe
        ProfExterne luc = new ProfExterne("Petit","luc","Infrabel",18.0,20);

        // rajouter les UE  ue2 dans la liste des ues de Loic et Luc
        loic.ajouter(ue2);
        luc.ajouter(ue2);
        loic.intervientDans(ue2);
        luc.intervientDans(ue2);
        //affichage de Etape 1
        System.out.println(loic);
        System.out.println(ue2);
        System.out.println(" ///////////////////////////////////////////////////////////////////////////\n" +
                "        //--------------------------------ETAPE 2 --------------------------------\n" +
                "        /////////////////////////////////////////////////////////////////////////");
        ue2.assignerResponsable(loic);
        System.out.println(loic.supprimer(ue2));
        System.out.println(loic);
        System.out.println(ue2);
        System.out.println(" ///////////////////////////////////////////////////////////////////////////\n" +
                "        //--------------------------------ETAPE 3 --------------------------------\n" +
                "        /////////////////////////////////////////////////////////////////////////");
         UE ue3 = new UE("habibi","15h532","INGI");
        System.out.println(ue3);
    }
}
