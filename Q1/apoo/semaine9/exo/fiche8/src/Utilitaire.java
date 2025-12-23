import java.time.LocalDate;

public class Utilitaire extends Vehicule {

    public static final int KM_MAX_PAR_DEFAUT = 50000;

    // ✅ DOUBLE au lieu de int
    private double kmMaxEntreControles;
    private double kmDernierControle;

    // CONSTRUCTEUR 1
    public Utilitaire(String numeroDeChassie, String immatriculation,
                      LocalDate dateMiseEnCirculation,
                      double kmMaxEntreControles) {  // ✅ double
        super(numeroDeChassie, immatriculation, dateMiseEnCirculation);

        if (kmMaxEntreControles <= 0) {
            throw new IllegalArgumentException("Le km max entre contrôles doit être positif");
        }

        this.kmMaxEntreControles = kmMaxEntreControles;
        this.kmDernierControle = 0;
    }

    // CONSTRUCTEUR 2
    public Utilitaire(String numeroDeChassie, String immatriculation,
                      LocalDate dateMiseEnCirculation) {
        this(numeroDeChassie, immatriculation, dateMiseEnCirculation, KM_MAX_PAR_DEFAUT);
    }

    // GETTERS - ✅ double
    public double getKmMaxEntreControles() {
        return kmMaxEntreControles;
    }

    public double getKmDernierControle() {
        return kmDernierControle;
    }

    // SETTER - ✅ double
    public void setKmDernierControle(double kmDernierControle) {
        if (kmDernierControle < 0) {
            throw new IllegalArgumentException("Le kilométrage ne peut pas être négatif");
        }
        if (kmDernierControle > getKilometrage()) {
            throw new IllegalArgumentException("Le km au dernier contrôle ne peut pas dépasser le kilométrage actuel");
        }
        this.kmDernierControle = kmDernierControle;
    }

    // MÉTHODE estEnOrdre - ✅ Plus d'erreur !
    @Override
    public boolean estEnOde() {
        // ✅ Maintenant tout est en double
        double kmDepuisControle = getKilometrage() - kmDernierControle;
        return kmDepuisControle < kmMaxEntreControles;
    }

    // OVERRIDE setDateDeControleTechnique
    @Override
    public void setDateDeControleTechnique(LocalDate dateDeControleTechnique) {
        super.setDateDeControleTechnique(dateDeControleTechnique);
        this.kmDernierControle = getKilometrage();
    }
}