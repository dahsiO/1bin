public class Personne {
    private String nom;
    private String prenom;
    private int jourNaissance;
    private int moisNaissance;
    private int anneeNaissance;
    private Adresse domicile;



    // Constructeur


    public Personne(String nom, String prenom, int jourNaissance, int moisNaissance, int anneeNaissance, Adresse domicile) {
        this.nom = nom;
        this.prenom = prenom;
        this.jourNaissance = jourNaissance;
        this.moisNaissance = moisNaissance;
        this.anneeNaissance = anneeNaissance;
        this.domicile = domicile;
    }

    // Âge à la fin de l'année actuelle
    public int getAgeFinAnnee() {
        int anneeCourante = java.time.Year.now().getValue();
        return anneeCourante - anneeNaissance;
    }

    // Âge à la fin d'une année donnée
    public int getAgeFinAnnee(int annee) {
        return annee - anneeNaissance;
    }

    // Adresse complète
    public Adresse getAdresseComplete() {
        return domicile;
    }

    // Date de naissance complète
    public String getDateNaissance() {
        return jourNaissance + "/" + moisNaissance + "/" + anneeNaissance;
    }

    // Pour affichage de l’état de la personne
    @Override
    public String toString() {
        return prenom + " " + nom + " (né le " + getDateNaissance() + "), habite : " + domicile.toString();
    }
}
