import java.util.ArrayList;
import java.util.Iterator;

public abstract class Salarie  implements Iterable<Chantier>{
    private String nom;
    private String prenom;
    private Chantier chantierActuel ;
    //TODO
    private ArrayList<Chantier> chantiers;

	public Salarie(String nom, String prenom, Chantier chantierActuel) {
        //TODO
        this.nom = nom;
        this.prenom = prenom;
        if (chantierActuel.estTerminee()){
             throw new IllegalArgumentException("le chantier est terminee");
        }
        // ✅ INITIALISER D'ABORD !
        this.chantiers = new ArrayList<>();

        // ✅ PUIS UTILISER !
        this.chantiers.add(chantierActuel);
        this.chantierActuel = chantierActuel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Chantier getChantierActuel() {
        return chantierActuel;
    }
    public boolean changerChantierActuel(Chantier chantier){
        if (this.chantierActuel.getChef() == this && !this.chantierActuel.estTerminee()){
            return false;
        }
        if (chantier.estTerminee()){
            return false;
        }
        if (this.chantierActuel == chantier){
            return false;
        }
        this.chantierActuel = chantier;
        // Ajouter à la liste s'il n'y est pas déjà
        if (!this.aDejaTravailleSur(chantier)) {
            this.chantiers.add(chantier);
        }
        return true;

    }
    public boolean  aDejaTravailleSur(Chantier chantier){
        if (this.chantiers.contains(chantier))return true;
        return false;
    }
    public int nombreDeChantiers(){
        return this.chantiers.size();
    }
    abstract double calculerSalaire();


    @Override
    public Iterator<Chantier> iterator() {
        return this.chantiers.iterator();
    }

    @Override
    public String toString() {
        String salarie = prenom + " " + nom ;
        salarie += "\n"+"Chantier actuel : " +  "Chantier n°"+chantierActuel.getNumero() + " : "+chantierActuel.getNom() ;
        if (chantierActuel.estTerminee()) {
            salarie += " : terminé";
        } else {
            salarie += " : en cours" ;
        }
        salarie += "\n"+"A déjà travailler sur les chantiers suivants :" ;
        int num = 1 ;
        /* Parcours de tous les chantiers sur lesquels le salarié a travaillé */ {
            for (Chantier chantier : this) {
                salarie += "\n "+num+") Chantier n°"+chantier.getNumero() + " : "+chantier.getNom() ;
                if (chantier.estTerminee()) {
                    salarie += " : terminé";
                } else {
                    salarie += " : en cours" ;
                }
                num++ ;
            }
            }


        return salarie ;
    }

}
