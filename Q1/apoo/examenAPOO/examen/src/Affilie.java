import java.util.ArrayList;
import java.util.Iterator;

public class Affilie implements Iterable<Location> {
    private String prenom;
    private String nom;
    private ArrayList<Location> locationsPassees;
    private Location locationEnCours;

    public Affilie(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.locationsPassees = new ArrayList<>();
        this.locationEnCours = null;
    }

    public String getPrenom() {
        return prenom;
    }

    public Location getLocationEnCours() {
        return locationEnCours;
    }

    public String getNom() {
        return nom;
    }

    public boolean aUneLocationEnCours() {
        if (locationEnCours != null) {
            return true;
        }
        return false;
    }

    public void termineeLocationEnCours() {
        if (!aUneLocationEnCours()) {
            throw new IllegalStateException("pas de location en cours");
        }
        this.locationEnCours.Terminer();
        locationsPassees.add(locationEnCours);
        this.locationEnCours = null;
    }


    public void commencerLocation() {
        if (locationEnCours != null) {
            throw new IllegalStateException("il y a deja un elocation en cours");
        }
        this.locationEnCours = new Location();
    }

    public int nombreDeLocations() {
        int total = locationsPassees.size();
        if (aUneLocationEnCours()) {
            total++;
        }
        return total;
    }
    // foreach
    public boolean aDejaLoue(Jeu jeu) {
        for (Location location : locationsPassees) {
            if (location.contient(jeu)) {
                return true;
            }
        }
        return false;
    }
    // iterator
    @Override
    public Iterator<Location> iterator() {
        return locationsPassees.iterator();
    }

    @Override
    public String toString() {
        String affilie = prenom + " " + nom + '\n';
        if (aUneLocationEnCours())
            affilie = affilie + "Pas de location en cours";
        else
            affilie = affilie + "Location en cours :" + '\n' + "-------------------" + '\n' + this.locationEnCours;
        affilie = affilie + '\n' + "Liste des locations passées :" + '\n' + "-----------------------------";
        if (/* Test si l'affilié n'a pas encore de location passée */ !aUneLocationEnCours()) {
            affilie = affilie + '\n' + "Pas encore de location passée";
        } else {/* Parcours des locations passées de l'affilié */
            for (Location locationPassee : locationsPassees) {
                {
                    affilie = affilie + '\n' + locationPassee;
                }
            }


        }
        return affilie;
    }
}


