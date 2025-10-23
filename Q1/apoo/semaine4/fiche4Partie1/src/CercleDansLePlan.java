public class CercleDansLePlan {

    // 🔹 Attributs
    private double rayon;
    private Point centre;

    // 🔹 Constructeur 1 : rayon + centre
    public CercleDansLePlan(double rayon, Point centre) {
        this.rayon = rayon;
        this.centre = centre;
    }

    // 🔹 Constructeur 2 : seulement le centre → rayon par défaut = 1
    public CercleDansLePlan(Point centre) {
        this.rayon = 1.0;
        this.centre = centre;
    }

    // 🔹 Constructeur 3 : aucun paramètre → rayon = 1 et centre = (0,0)
    public CercleDansLePlan() {
        this.rayon = 1.0;
        this.centre = new Point(0, 0);
    }

    // 🔹 Getter pour le rayon
    public double getRayon() {
        return rayon;
    }

    // 🔹 Setter pour le rayon
    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    // 🔹 Getter pour le centre
    public Point getCentre() {
        return centre;
    }

    // 🔹 Setter pour le centre
    public void setCentre(Point centre) {
        this.centre = centre;
    }

    // 🔹 toString() pour afficher les infos du cercle
    @Override
    public String toString() {
        return "Cercle de rayon " + rayon + " centré en " + centre;
    }
}
/*
*Explication rapide :

Surcharge → les 3 constructeurs permettent de créer un cercle de plusieurs façons.

On réutilise la classe Point pour le centre.

toString() appelle automatiquement centre.toString() → ce qui affichera (x,y).

* */