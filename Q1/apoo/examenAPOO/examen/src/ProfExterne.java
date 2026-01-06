public class ProfExterne extends Professeur{

    private String entreprise;
    private double salaireHoraire;
    private int nbHeuresPrestees;

    public ProfExterne(String nom, String prenom, String entreprise, double salaireHoraire, int nbHeurePrestees) {
        super(nom, prenom);
        this.entreprise = entreprise;
        this.salaireHoraire = salaireHoraire;
        this.nbHeuresPrestees = nbHeurePrestees;
    }


    @Override
    public double calculerSalaire() {
        return nbHeuresPrestees*salaireHoraire;
    }
    @Override
    public String toString() {
        String profExterne =  "Professeur Interne " + super.toString()   ;
        profExterne = profExterne + "\n" + "Entreprise : " + entreprise  ;
        profExterne = profExterne + "\n" + "Salaire horaire : " + salaireHoraire ;
        profExterne = profExterne + "\n" + "Nombre d'heures prestées : " + nbHeuresPrestees ;
        return profExterne;
    }
}
