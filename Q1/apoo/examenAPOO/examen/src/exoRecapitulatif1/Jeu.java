package exoRecapitulatif1;

import java.util.Objects;

public abstract class Jeu {
    private static int nombreDeJeux = 1;
    private int identifiant;
    private String nom;
    private int nbJoueurs;
    private boolean disponible ;

    public Jeu(String nom, int nbJoueurs) {
        this.nom = nom;
        this.nbJoueurs = nbJoueurs;
        this.identifiant = nombreDeJeux;
        nombreDeJeux++;
        this.disponible = true;
    }

    public String getNom() {
        return nom;
    }


    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    //hashCode equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jeu jeu = (Jeu) o;
        return identifiant == jeu.identifiant;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(identifiant);
    }

    @Override
    public String toString() {
        String jeu = ""+identifiant ;
        if (this.disponible) {
            jeu = jeu + " disponible" ;
        } else {
            jeu = jeu + " loué" ;
        }
        jeu = jeu + " : "+this.nom+ " pour "+ this.nbJoueurs+" joueur(s)" ;
        return jeu ;
    }
}
