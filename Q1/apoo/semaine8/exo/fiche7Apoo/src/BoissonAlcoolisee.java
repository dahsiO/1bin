public class BoissonAlcoolisee extends Boisson {
    private double degreeAlcool;

    public BoissonAlcoolisee(String nom, int contenence, double prix, double degreeAlcool) {
        super(nom, contenence, prix);
        this.degreeAlcool = degreeAlcool;
    }

    public double getDegreeAlcool() {
        return degreeAlcool;
    }

    @Override
    public String toString() {
        return "BoissonAlcoolisee{" +
                "degreeAlcool=" + degreeAlcool +
                '}';
    }
}
