public class Cours {
    private String intitule;
    private String niveau;
    private int nbInscrits;
    private Professeur professeur;

    public Cours(String intitule, String niveau, Professeur professeur) {
        this.intitule = intitule;
        this.niveau = niveau;
        this.professeur = professeur;
        this.nbInscrits = 0;
    }

    public String getIntitule() {
        return intitule;
    }

    public String getNiveau() {
        return niveau;
    }

    public int getNbInscrits() {
        return nbInscrits;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    // Méthode pour signaler l'inscription d'un élève
    public void inscrire() {
        nbInscrits++;
    }

    // Méthode pour signaler la désinscription d'un élève
    public void desinscrire() {
        if (nbInscrits > 0) nbInscrits--;
    }

    @Override
    public String toString() {
        return "Intitulé : " + intitule + "\n" +
                "Niveau : " + niveau + "\n" +
                "Nombre d'inscrits : " + nbInscrits + "\n" +
                "Professeur : " + professeur.getNom() + " " + professeur.getPrenom();
    }
}
