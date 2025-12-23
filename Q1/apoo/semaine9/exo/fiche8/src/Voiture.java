import java.time.LocalDate;

public class Voiture extends Vehicule {
    //attribut
    public static final int DUREE_AVANT_PREMIER_CT = 4;
    public static final int DURRE_MAX_ENTRE_CT =1;
    public Voiture(String numeroDeChassie, String immatriculation, LocalDate dateMiseEnCirculation) {
        super(numeroDeChassie, immatriculation, dateMiseEnCirculation);
    }
    // la methode abstraite a modfiier
    @Override
    public boolean estEnOde() {
        LocalDate aujourdhuis = LocalDate.now();
        //condition 1 verifier la date limiteCiru
        if ( aujourdhuis.isBefore(getDateMiseEnCirculation().plusYears(DUREE_AVANT_PREMIER_CT)))return true;
       if (aujourdhuis.isBefore(getDateDeControleTechnique().plusYears(DURRE_MAX_ENTRE_CT))) return true;
        return false;
    }
}
