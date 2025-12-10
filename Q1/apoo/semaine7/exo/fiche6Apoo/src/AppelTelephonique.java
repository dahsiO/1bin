import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class AppelTelephonique {
    // Constante pour le tarif par défaut (0.15 euro par minute)
    private static double tarifDefaut = 0.15;

    private LocalDateTime dateEtHeure;
    private String numero;
    private Duration dureeDeAppel;
    private double tarif;

    public AppelTelephonique(LocalDateTime dateEtHeure, String numero, Duration dureeDeAppel, double tarif) {
        if (dateEtHeure == null){
            throw new IllegalArgumentException("La date et heure ne peuvent pas être null");
        }
        if (numero == null){
            throw new IllegalArgumentException("Le numéro ne peut pas être null");
        }
        if (dureeDeAppel == null){
            throw new IllegalArgumentException("La durée ne peut pas être null");
        }
        if (tarif <= 0){  // ✅ CORRIGÉ : <= au lieu de >
            throw new IllegalArgumentException("Le tarif doit être strictement supérieur à 0");
        }
        if (dureeDeAppel.isZero() || dureeDeAppel.isNegative()){
            throw new IllegalArgumentException("La durée ne peut pas être inférieure ou égale à 0");
        }
        if (dateEtHeure.isAfter(LocalDateTime.now())){
            throw new IllegalArgumentException("Le moment de l'appel doit être antérieur au moment actuel");
        }

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
        if (nouveauTarifDefaut <= 0){  // ✅ CORRIGÉ : <= au lieu de >
            throw new IllegalArgumentException("Le tarif par défaut doit être strictement supérieur à 0");
        }
        tarifDefaut = nouveauTarifDefaut;
    }

    public void setTarif(double tarif) {
        if (tarif <= 0){
            throw new IllegalArgumentException("Le tarif doit être strictement supérieur à 0");
        }
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
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String infos = "Appel passé le " + formatter.format(dateEtHeure);

        // Formatage de la durée au format "x min. y sec."
        long minutes = dureeDeAppel.toMinutes();
        long secondes = dureeDeAppel.minusMinutes(minutes).getSeconds();
        infos += " vers le numéro " + numero;
        infos += " - Durée : " + minutes + " min. " + secondes + " sec.";
        infos += " - Tarif : " + String.format("%.2f", tarif) + " €/min";
        infos += " - Coût : " + String.format("%.2f", calculerLeCoutAppel()) + " €";

        return infos;
    }
}