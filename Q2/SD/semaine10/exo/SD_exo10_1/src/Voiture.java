import java.util.Objects;

public class Voiture implements Comparable<Voiture>{

    private String numeroChassis;
    private String plaque;

    public Voiture(String numeroChassis, String plaque) {
        this.numeroChassis = numeroChassis;
        this.plaque = plaque;
    }

    public String getNumeroChassis() {
        return numeroChassis;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    @Override
    public String toString() {
        return numeroChassis + "\t" +
                 plaque;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voiture voiture = (Voiture) o;
        return Objects.equals(numeroChassis, voiture.numeroChassis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroChassis);
    }

    @Override
    public int compareTo(Voiture autreVoiture) {
        return this.numeroChassis.compareTo(autreVoiture.numeroChassis) ;
    }
}
