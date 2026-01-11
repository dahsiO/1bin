import java.util.ArrayList;
import java.util.Iterator;

public class Affilie implements Iterable<Location>{
    private String prenom;
    private String nom;
    private ArrayList<Location> locationsPassees;
    private Location locationEnCours;

    public Affilie(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
        this.locationEnCours = null;
        this.locationsPassees = new ArrayList<>();
        //TODO
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Location getLocationEnCours() {
        return locationEnCours;
    }
    // a une location en cour
    public boolean aUneLocationEnCours(){
        if ( this.locationEnCours != null){
            return true;
        }
       return false;
    }
    public void terminerLocationEnCours(){
        if (this.locationEnCours == null){
            throw new IllegalStateException("pas de location en cour");
        }locationEnCours.terminee();
        locationsPassees.add(locationEnCours);
        this.locationEnCours = null;
    }
    //commencerLocation
    public void commencerLocation(){
        if (this.locationEnCours != null){
            throw new IllegalStateException("il ya deja une location en cours");
        }
        this.locationEnCours = new Location();
    }
    //nombre de location
    public int nombreDeLocation(){

       int result  = locationsPassees.size();
       if (this.locationEnCours != null){
           result++;
       }
       return result;
    }

    //a deja louer
    public boolean aDejaLoue(Jeu jeu){
        if ( locationsPassees.contains(jeu)){
            return true;
        }
       return false;
    }


    @Override
    public Iterator<Location> iterator() {
        //TODO
        return locationsPassees.iterator();
    }//toString
    @Override
    public String toString() {
        String affilie = prenom + " " + nom  + '\n' ;
        if (this.locationEnCours == null)
            affilie = affilie+"Pas de location en cours" ;
        else
            affilie = affilie+"Location en cours :" +'\n'+"-------------------"+'\n'+this.locationEnCours;
        affilie = affilie + '\n'+"Liste des locations passées :" +'\n'+"-----------------------------" ;
        if (locationsPassees.isEmpty()) {
            affilie = affilie + '\n'+ "Pas encore de location passée" ;
        } else {
            /* Parcours des locations passées de l'affilié */
            for (Location location : locationsPassees) {
                {
                    affilie = affilie + '\n' + location;
                }
            }

        }
        return affilie ;
    }
}
