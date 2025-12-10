import java.util.Objects;

public class Guerrier {

    private String nom;
    private int pointsDeVie;

    public Guerrier(String nom, int pointsDeVie) {
        this.nom = nom;
        this.pointsDeVie = pointsDeVie;
    }

    public String getNom() {
        return nom;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guerrier guerrier = (Guerrier) o;
        return Objects.equals(nom, guerrier.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return nom + "("+ pointsDeVie + ")";
    }

}
