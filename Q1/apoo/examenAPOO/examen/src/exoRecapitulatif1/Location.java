package exoRecapitulatif1;

import java.util.ArrayList;
import java.util.Iterator;

public class Location implements Iterable<Jeu>{
    private ArrayList<Jeu> jeux;
    private boolean terminee;

    public Location() {
        this.jeux = new ArrayList<>();
        this.terminee = false;
    }
    public boolean contient(Jeu jeu){
        if (!jeux.contains(jeu))return false;
        return true;
    }

    public boolean isTerminee() {
        return terminee;
    }
    public boolean terminer(){
        if (terminee) {
            return false;
        }

        // Rendre tous les jeux disponibles
        for (Jeu jeu : jeux) {
            jeu.setDisponible(true);
        }

        terminee = true;
        return true;
    }

   public boolean ajouter(Jeu jeu){
        // le jeux est deja la
        if (!jeu.isDisponible() || terminee){
            return false;
        }
        jeux.add(jeu);
        jeu.setDisponible(false);
        return true;
   }
    // parcourir la liste
    @Override
    public Iterator<Jeu> iterator() {
        return jeux.iterator();
    }
    @Override
    public String toString() {
        String location = "Location " ;
        if (terminee)
            location = location + "terminée :" ;
        else
            location = location + "en cours :" ;
        int i=1 ;
        for (Jeu jeu : jeux) {
            location = location + '\n' + i + ") " + jeu;
            i++;
        }
        return location ;
    }
}
