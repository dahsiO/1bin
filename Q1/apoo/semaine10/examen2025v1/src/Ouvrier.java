public class Ouvrier extends Salarie{
    private String[] SPECIALITES_EXISTANTES= {"Gros oeuvre","Toiture","Maconnerie","Plomberie"};
    private String specialite;
    private double salaireHoraire;
    private int nbHeurePrestees;

    public Ouvrier(String nom, String prenom, Chantier chantierActuel, double salaireHoraire, String specialite) {
        super(nom, prenom, chantierActuel);
        this.salaireHoraire = salaireHoraire;
        // Vérifier d'abord si la spécialité est valide
        boolean specialiteValide = false;
        for (int i = 0; i < SPECIALITES_EXISTANTES.length; i++) {
            if (specialite.equals(SPECIALITES_EXISTANTES[i])) {
                specialiteValide = true;
                break;  // On arrête dès qu'on trouve
            }
        }

        // Si pas valide, on lance l'exception
        if (!specialiteValide) {
            throw new IllegalArgumentException(specialite + " n'est pas une spécialité valide");
        }
        this.specialite = specialite;
        this.nbHeurePrestees = 0;
    }

    public int getNbHeurePrestees() {
        return nbHeurePrestees;
    }

    public void setSalaireHoraire(double salaireHoraire) {
        this.salaireHoraire = salaireHoraire;
    }
    public void ajouterHeuresPrestees(int nbHeurePrestees){
        //TODO
        this.nbHeurePrestees += nbHeurePrestees;
    }
    public void reinitialiserHeuresPrestees(){
        //TODO
        this.nbHeurePrestees = 0;
    }


    @Override
    double calculerSalaire() {
        return salaireHoraire * nbHeurePrestees;
    }
    @Override
    public String toString() {
        String ouvrier =  "Ouvrier " + super.toString() ;
        ouvrier = ouvrier + "\n" + "Spécialité : " + specialite  ;
        ouvrier = ouvrier + "\n" + "Salaire horaire : " + salaireHoraire ;
        ouvrier = ouvrier + "\n" + "nombre d'heures prestées : " + nbHeurePrestees ;
        return ouvrier;
    }

}
