public class Professeur {
    private String matricule;
    private String nom;
    private String prenom;
    private String specialisation;

    public Professeur(String matricule, String nom, String prenom, String specialisation) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.specialisation = specialisation;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    @Override
    public String toString() {
        return "Matricule : " + matricule + "\n" +
                "Nom : " + nom + "\n" +
                "Prénom : " + prenom + "\n" +
                "Spécialisation : " + specialisation;
    }
}
