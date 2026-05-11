import java.util.Comparator;

public class ComparateurVoiture implements Comparator<Voiture> {

    @Override
    public int compare(Voiture voiture1, Voiture voiture2) {
        return voiture1.getPlaque().compareTo(voiture2.getPlaque());
    }

}


