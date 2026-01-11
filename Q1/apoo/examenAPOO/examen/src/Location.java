import java.util.ArrayList;
import java.util.Iterator;

public class Location implements  Iterable<Jeu>{
    private ArrayList<Jeu> jeux;
    private boolean terminee;


    public Location() {
        //attribut
        this.jeux = new ArrayList<>();
        this.terminee = false;
    }
    public boolean terminee(){
        if (this.terminee = true){
            return false;
        }else{
            for (Jeu jeu : jeux) {
                jeu.setDisponible(true);
            }
        }
        return true;
    }
    public  boolean contient(Jeu jeu){
        if ( jeux.contains(jeu)){
            return true;
        }
       return false;
    }
    public boolean ajouter(Jeu jeu){
        if (jeu.isDisponible() == false || this.terminee == true){
            return false;
        }
        jeux.add(jeu);
        jeu.setDisponible(false);
        return true;
    }


    @Override
    public Iterator<Jeu> iterator() {
        return jeux.iterator();
    }
    @Override
    public String toString() {
        String location = "Location " ;
        if (/* Test si la location est terminée */ this.terminee == true)
            location = location + "terminée :" ;
        else
            location = location + "en cours :" ;
        int i=1 ;
        for (Jeu jeu : jeux) {
            {
                location = location + '\n' + i+") "+ jeu;
                i++ ;
            }
        }
        return location ;
    }
}
