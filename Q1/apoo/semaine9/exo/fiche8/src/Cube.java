public class Cube implements Solide {
    private double cote;

    public Cube(double cote) {
        this.cote = cote;
    }

    public double getCote() {
        return cote;
    }

    @Override
    public double donnerVolume() {
        return Math.pow(cote, 3);
    }

    @Override
    public double donnerSurface() {
        return 6 * Math.pow(cote, 2);
    }

    @Override
    public String toString() {
        return "Cube [côté=" + cote + " cm, volume=" +
                String.format("%.2f", donnerVolume()) + " cm³, surface=" +
                String.format("%.2f", donnerSurface()) + " cm²]";
    }
}