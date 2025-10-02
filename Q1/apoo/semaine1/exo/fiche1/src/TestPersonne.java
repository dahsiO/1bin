public class TestPersonne {
    public static void main(String[] args) {

        // cree les domiciles
        Adresse adresse1 = new Adresse("louise", "43", "1030", "bruxelles");


        // Création de 3 personnes
        Personne p1 = new Personne("Durand", "Marie", 15, 3, 1995, adresse1 );
        Personne p2 = new Personne("Martin", "Paul", 7, 11, 1988,adresse1 );
        Personne p3 = new Personne("Dupont", "Claire", 25, 6, 2002, adresse1);

        // Affichage des informations
        System.out.println("=== Informations des personnes ===");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Âge à la fin de l’année actuelle
        System.out.println("\n=== Âge à la fin de l'année actuelle ===");
        System.out.println(p1.getAgeFinAnnee() + " ans");
        System.out.println(p2.getAgeFinAnnee() + " ans");
        System.out.println(p3.getAgeFinAnnee() + " ans");

        // Âge à la fin de 2025
        System.out.println("\n=== Âge au 31/12/2025 ===");
        System.out.println(p1.getAgeFinAnnee(2025) + " ans");
        System.out.println(p2.getAgeFinAnnee(2025) + " ans");
        System.out.println(p3.getAgeFinAnnee(2025) + " ans");
    }
}
