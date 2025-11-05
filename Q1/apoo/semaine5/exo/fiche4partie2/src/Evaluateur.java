import java.util.Objects;

public class Evaluateur {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private int nbLivresEvalues;

    public Evaluateur(String nom, String prenom, String email, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        this.nbLivresEvalues = 0;
    }

    // Méthodes
    public void incrementerNbLivres() {
        nbLivresEvalues++;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public String getTelephone() { return telephone; }
    public int getNbLivresEvalues() { return nbLivresEvalues; }

    @Override
    public String toString() {
        return "Évaluateur : " + prenom + " " + nom +
                "\nEmail : " + email +
                "\nTéléphone : " + telephone +
                "\nLivres évalués : " + nbLivresEvalues;
    }
}
