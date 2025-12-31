public class TestEntreprise {
    public static void main(String[] args) {

        System.out.println("Etape 1");
        //creation de chantier
        Chantier c1 = new Chantier("Construction Ilot des Carmes "," Namur");
        //creation de notre jeune loic employer
        Employe Loic = new Employe(" Lecharlier","Loïc",c1);
        System.out.println(Loic);
        System.out.println(c1);

        //etape 2
        System.out.println("Etape 2");
        System.out.println("Assignation du chef : " + c1.assigneeChef(Loic));
        System.out.println("Chef actuel : " + c1.getChef());
        Chantier c2 = new Chantier("Demolition tour"," Vedrin");
        System.out.println(Loic.changerChantierActuel(c2));
        System.out.println(c1.getChef());
        System.out.println(c1);
        //etape 3

        System.out.println("etape 3");
        try {
            Ouvrier ouvrier = new Ouvrier("Etienne","Lecharlier",c2,20.0,"Terrassement");
            System.out.println(ouvrier);
        } catch (Exception e) {
            //etape 4
            System.out.println("etape 4");
            Ouvrier ouvrier1 = new Ouvrier("Etienne","Lecharlier",c2,20.0,"Gros oeuvre");
            c2.Terminee();
            System.out.println(ouvrier1);
            System.out.println(c2);

        }
   }
}
