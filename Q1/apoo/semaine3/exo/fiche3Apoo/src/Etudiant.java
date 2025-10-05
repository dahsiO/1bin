public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;
    private Serie serie;

    public Etudiant(String matricule, String nom, String prenom, Serie serie) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.serie = serie;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Serie getSerie() {
        return serie;
    }

   public boolean changerSerie(Serie nouvelleSerie){

        // cas 1 : la serie donne est null
       if (nouvelleSerie == null){
           return false;
       }
       // cas 2 l etudiant est deja dans la serie
       if ( this.serie == nouvelleSerie){
           return false;
       }
       // si il est deklegue de sa propre serie
       if (this.serie != null && this.serie.getDelegue() == this){
           return false;
       }
       // si tous est bon
       this.serie = nouvelleSerie;
       return true;
   }


    @Override
    public String toString() {
        return "Etudiant : " + matricule + ' ' + " nom :" +
                nom + ' ' +" prenom='" + prenom + ' ' + "serie :" + serie ;
    }
}
