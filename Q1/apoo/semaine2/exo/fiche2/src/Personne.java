public class Personne {
    private String nom;
    private String prenom;
    private Date Naissance;
    private Adresse domicile;



    // Constructeur


    public Personne(String nom, String prenom, Date Naissance, Adresse domicile) {
        this.nom = nom;
        this.prenom = prenom;
        this.Naissance = Naissance;
        this.domicile = domicile;
    }

    // Âge à la fin de l'année actuelle
    public int getAgeFinAnnee() {
        int anneeCourante = java.time.Year.now().getValue();
        return anneeCourante - Naissance.getAnnee();
    }

    // Âge à la fin d'une année donnée
    public int getAgeFinAnnee(int annee) {
        return annee - Naissance.getAnnee();
    }

    // Adresse complète
    public Adresse getAdresseComplete() {
        return domicile;
    }

    // Date de naissance complète
    public String getDateNaissance() {
        return Naissance.toString();
    }



    public void demenager(String rue, String numero, String codePostal, String ville) {
        this.domicile = new Adresse(rue, numero, codePostal, ville);
    }
    // Pour affichage de l’état de la personne
    @Override
    public String toString() {
        return prenom + " " + nom + " (né le " + getDateNaissance() + "), habite : " + domicile.toString();
    }
}
