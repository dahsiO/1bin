public class Etudiant {

    private int matricule;
    private String nom;
    private double points;

    /**
     * @param matricule
     * @param nom
     * @param points
     */
    public Etudiant(int matricule, String nom, double points) {
        this.matricule = matricule;
        this.nom = nom;
        this.points = points;
    }

    public int getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public double getPoints() {
        return points;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        return matricule +"       "+ nom + "     "+ points;
    }
}
