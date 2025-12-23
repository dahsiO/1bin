import java.time.LocalDate;
import java.util.Objects;

public abstract class  Vehicule {
    private String numeroDeChassie;
    private String immatriculation;
    private LocalDate dateMiseEnCirculation;
    private LocalDate dateDeControleTechnique;
    private double kilometrage;

    // ✅ CORRECT
    public Vehicule(String numeroDeChassie, String immatriculation,
                    LocalDate dateMiseEnCirculation) {
        // Validations ici
        if (numeroDeChassie == null || numeroDeChassie.isEmpty()){
            throw new IllegalArgumentException("le numero de chassie ne peut pas etre null ou vide ");
        }
        if (immatriculation == null || immatriculation.isEmpty()){
            throw new IllegalArgumentException("la plaque ne peux pas etre null ou vide");
        }
        if (dateMiseEnCirculation == null){
            throw new IllegalArgumentException("la date ne peut pas etre null");
        }
        this.numeroDeChassie = numeroDeChassie;
        this.immatriculation = immatriculation;
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.dateDeControleTechnique = dateMiseEnCirculation;  // ← Même valeur !
        this.kilometrage = 0;
    }
    public abstract boolean estEnOde();

    public String getNumeroDeChassie() {
        return numeroDeChassie;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public LocalDate getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    public LocalDate getDateDeControleTechnique() {
        return dateDeControleTechnique;
    }

    public double getKilometrage() {
        return kilometrage;
    }

    public void setDateDeControleTechnique(LocalDate dateDeControleTechnique) {
        if (dateDeControleTechnique == null) {
            throw new IllegalArgumentException("La date ne peut pas être null");
        }
        if (dateDeControleTechnique.isBefore(this.dateDeControleTechnique) ||
                dateDeControleTechnique.isEqual(this.dateDeControleTechnique)) {
            throw new IllegalArgumentException("La nouvelle date doit être ultérieure à l'ancienne");
        }
        this.dateDeControleTechnique = dateDeControleTechnique;
    }

    public void setKilometrage(double kilometrage) {
        if (kilometrage <= this.kilometrage) {
            throw new IllegalArgumentException("Le nouveau kilométrage doit être strictement supérieur à l'ancien");
        }
        this.kilometrage = kilometrage;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return Objects.equals(immatriculation, vehicule.immatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(immatriculation);
    }
}
