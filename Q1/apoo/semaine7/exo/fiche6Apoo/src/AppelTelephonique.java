import java.time.Duration;
import java.time.LocalDateTime;

public class AppelTelephonique {
    // Constante pour le tarif par défaut (0.15 euro par minute, pas 15.0)
    private static double tarifDefaut = 0.15;

    private LocalDateTime dateEtHeure;
    private String numero;
    private Duration dureeDeAppel;
    private double tarif;

    public AppelTelephonique(LocalDateTime dateEtHeure, String numero, Duration dureeDeAppel, double tarif) {
        this.dateEtHeure = dateEtHeure;
        this.numero = numero;
        this.dureeDeAppel = dureeDeAppel;
        this.tarif = tarif;
    }

    public AppelTelephonique(LocalDateTime dateEtHeure, String numero, Duration dureeDeAppel) {
        this(dateEtHeure, numero, dureeDeAppel, tarifDefaut);
    }

    // Getter pour le tarif par défaut (méthode de classe)
    public static double getTarifDefaut() {
        return tarifDefaut;
    }

    // Setter pour modifier le tarif par défaut (méthode de classe)
    public static void setTarifDefaut(double nouveauTarifDefaut) {
        tarifDefaut = nouveauTarifDefaut;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public LocalDateTime getDateEtHeure() {
        return dateEtHeure;
    }

    public String getNumero() {
        return numero;
    }

    public Duration getDureeDeAppel() {
        return dureeDeAppel;
    }

    public double getTarif() {
        return tarif;
    }

    // Calcul du coût (la minute entamée compte)
    public double calculerLeCoutAppel() {
        long minutes = dureeDeAppel.toMinutes();
        // Si il y a des secondes en plus, on compte une minute supplémentaire
        if (dureeDeAppel.minusMinutes(minutes).getSeconds() > 0) {
            minutes++;
        }
        return tarif * minutes;
    }

    @Override
    public String toString() {
        return "Appel téléphonique du " + dateEtHeure +
                " vers le numéro " + numero +
                " - Durée : " + dureeDeAppel.toMinutes() + " min " +
                (dureeDeAppel.toSecondsPart()) + " sec" +
                " - Tarif : " + tarif + " €/min" +
                " - Coût : " + String.format("%.2f", calculerLeCoutAppel()) + " €";
    }
}