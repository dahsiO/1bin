public abstract class Jeu {
    public  static int nombreDeJeux = 0;
    private int identifiant;
    private String nom;
    private int nbJoueurs;
    private boolean disponible ;

    public Jeu(String nom, int nbJoueurs) {
        this.nom = nom;
        this.nbJoueurs = nbJoueurs;
        nombreDeJeux++;
        this.identifiant = nombreDeJeux;
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
    //hashCode

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
