import java.util.ArrayList;
import java.util.Iterator;

public class ListeSolides {
    private ArrayList<Solide> solides;

    public ListeSolides() {
        this.solides = new ArrayList<>();
    }

    public boolean ajouter(Solide s) {
        return solides.add(s);
    }

    public boolean supprimer(Solide s) {
        return solides.remove(s);
    }

    public boolean contient(Solide s) {
        return solides.contains(s);
    }

    public boolean estVide() {
        return solides.isEmpty();
    }

    public int nombreDeSolides() {
        return solides.size();
    }

    public ArrayList<Solide> trouverPlusGrand() {
        ArrayList<Solide> plusGrands = new ArrayList<>();

        if (solides.isEmpty()) {
            return plusGrands;
        }

        // Trouver le volume maximum avec Iterator
        Iterator<Solide> it = solides.iterator();
        double volumeMax = it.next().donnerVolume();

        while (it.hasNext()) {
            Solide s = it.next();
            if (s.donnerVolume() > volumeMax) {
                volumeMax = s.donnerVolume();
            }
        }

        // Ajouter tous les solides ayant ce volume maximum avec Iterator
        it = solides.iterator();
        while (it.hasNext()) {
            Solide s = it.next();
            if (s.donnerVolume() == volumeMax) {
                plusGrands.add(s);
            }
        }

        return plusGrands;
    }

    @Override
    public String toString() {
        if (solides.isEmpty()) {
            return "La liste est vide.";
        }

        String resultat = "Liste des solides :\n";

        // Utilisation d'Iterator pour parcourir
        Iterator<Solide> it = solides.iterator();
        while (it.hasNext()) {
            resultat += it.next().toString() + "\n";
        }

        return resultat;
    }
}