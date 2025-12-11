import java.util.Objects;

public class Boisson {
    private String nom;
    private int contenence;
    private double prix;

    public Boisson(String nom, int contenence, double prix) {
        this.nom = nom;
        this.contenence = contenence;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public int getContenence() {
        return contenence;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Boisson boisson = (Boisson) o;
        return contenence == boisson.contenence && Objects.equals(nom, boisson.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, contenence);
    }

    @Override
    public String toString() {
        return "Boisson{" +
                "nom='" + nom + '\'' +
                ", contenence=" + contenence +
                ", prix=" + prix +
                '}';
    }

}
