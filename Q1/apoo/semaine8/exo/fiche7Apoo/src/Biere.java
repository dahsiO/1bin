public class Biere extends BoissonAlcoolisee{
    private boolean estPression;

    public Biere(String nom, int contenence, double prix, double degreeAlcool, boolean estPression) {
        super(nom, contenence, prix, degreeAlcool);
        this.estPression = estPression;
    }

    public boolean isEstPression() {
        return estPression;
    }
    @Override
    public String toString() {
        return "Biere{" +
                "estPression=" + estPression +
                '}';
    }
}
