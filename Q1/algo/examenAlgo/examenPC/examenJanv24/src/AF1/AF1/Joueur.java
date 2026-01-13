package AF1.AF1;

public class Joueur {

    private String nom;
    private int meilleurScore;
    private int nombreTentatives;

    public Joueur(String nom, int meilleurScore, int nombreTentatives) {
        this.nom = nom;
        this.meilleurScore = meilleurScore;
        this.nombreTentatives = nombreTentatives;
    }

    public String getNom() {
        return nom;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public int getNombreTentatives() {
        return nombreTentatives;
    }

    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }

    public void ajouter1Tentative() {
        this.nombreTentatives++;
    }

    @Override
    public String toString() {
        return nom + " : " + meilleurScore + "("+ nombreTentatives+")";
    }


}
