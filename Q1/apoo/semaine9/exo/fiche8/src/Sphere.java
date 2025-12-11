public class Sphere implements Solide{
    private double rayon;

    public Sphere(double rayon) {
        this.rayon = rayon;
    }

    public double getRayon() {
        return rayon;
    }

    @Override
    public double donnerVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(rayon, 3);
    }

    @Override
    public double donnerSurface() {
        return 4 * Math.PI * Math.pow(rayon, 2);
    }
    @Override
    public String toString() {
        return "Sphère [rayon=" + rayon + " cm, volume=" +
                String.format("%.2f", donnerVolume()) + " cm³, surface=" +
                String.format("%.2f", donnerSurface()) + " cm²]";
    }
}
