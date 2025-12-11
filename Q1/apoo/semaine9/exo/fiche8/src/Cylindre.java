public class Cylindre implements Solide{
    private double rayon;
    private double hauteur;


    public Cylindre(double rayon, double hauteur) {
        this.rayon = rayon;
        this.hauteur = hauteur;
    }

    public double getRayon() {
        return rayon;
    }

    public double getHauteur() {
        return hauteur;
    }

    @Override
    public double donnerVolume() {
        return Math.PI * Math.pow(rayon, 2) * hauteur;
    }

    @Override
    public double donnerSurface() {
        return 2 * Math.PI * rayon * (rayon + hauteur);
    }

    @Override
    public String toString() {
        return "Cylindre [rayon=" + rayon + " cm, hauteur=" + hauteur +
                " cm, volume=" + String.format("%.2f", donnerVolume()) +
                " cm³, surface=" + String.format("%.2f", donnerSurface()) + " cm²]";
    }
}
