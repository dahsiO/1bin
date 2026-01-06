

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Professeur implements Iterable<UE> {
    private String nom ;
    private String prenom ;
    private int numero;
    private static  int numeroSuivant = 1;
    private ArrayList<UE> ues;
	//TODO

    public Professeur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.ues =new ArrayList<>();
        this.numero = numeroSuivant;
        numeroSuivant++;

        //TODO
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }
    public boolean intervienDans(UE ue){
        if (ues.contains(ue))return true;
        return false;
    }
    // methode ajouter && supprimer

     public boolean ajouter(UE ue){
        if (!ues.contains(ue)){
            ues.add(ue);
            ue.incrementerNbrDeProfesseurs();
            return true;
        }
        return false;
     }
    public boolean supprimer (UE ue){
        if (ue.getResponsable() == this || !ues.contains(ue))return false;
        ues.remove(ue);
       ue.decrementerNbrDeProfesseurs();
        return true;

    }
    public int nombreDUEDuCursus(String cursus){
        int compteur = 0;
        for (UE ue : ues) {
            if (ue.getCursus() == cursus) {
                compteur++;
            }
        }
        return compteur;
    }
    abstract public double calculerSalaire();

    @Override
    public Iterator<UE> iterator() {
        return ues.iterator();
    }

    @Override
    public String toString() {
        String professeur = "n°"+numero+" : "+prenom + " " + nom ;
        professeur += "\n"+"intervient dans les UE suivantes :" ;
        if (ues.isEmpty()) {
            professeur += "\n"+"aucune";
        } else {
            int num = 1 ;
            for (UE ue : ues) {
                /* Parcours de toutes les UEs sur lesquelles le professeur intervient */
                    professeur += "\n " + num + ") " + ue.getCode() + " : " + ue.getNom();
                    num++;
            }

        }
        return professeur ;
    }

}
