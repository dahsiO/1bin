public class TestCompteEnBanque {
    public static void main(String[] args) {

        // creation de personnes
        Personne p1 = new Personne("Oussama", "dahsi",new Date(2005,03,17),new Adresse("rue bob", "43","1020","Bruxelles"));
        Personne p2 = new Personne("momo", "bledard",new Date(2005,07,03),new Adresse("rue walf", "03","1030","Bruxelles"));

        //creation de date
        Date dateDeOuverture1 = new Date(2035,03,12);
        Date dateDeValidité1 = new Date(2000,03,12);


        Date dateDeOuverture2 = new Date(2025,02,10);
        Date dateDeValidité2 = new Date(2010,02,10);


        //creation de compte en banque
        CompteEnBanque compteEnBanque = new CompteEnBanque(p1,dateDeValidité1,"01",dateDeOuverture1,2000);
        CompteEnBanque compteEnBanque2 = new CompteEnBanque(p2,dateDeValidité2,"01",dateDeOuverture2,1200);


        //teste
        compteEnBanque.depot(200);
        System.out.println(compteEnBanque);

        compteEnBanque.retrait(100);
        System.out.println(compteEnBanque);

        compteEnBanque.virement(compteEnBanque2,2000);
        System.out.println(compteEnBanque2);

    }
}
