public class CompteEnBanque {
    private Personne titulaire;
    private Date dateDeValidite;
    private String numero;
    private Date dateOuverture;
    private double solde;

    public CompteEnBanque(Personne titulaire, Date dateDeValidite, String numero, Date dateOuverture, double solde) {
        this.titulaire = titulaire;
        this.dateDeValidite = dateDeValidite;
        this.numero = numero;
        this.dateOuverture = dateOuverture;
        this.solde = solde;
    }

    public Personne getTitulaire() {
        return titulaire;
    }

    public Date getDateDeValidite() {
        return dateDeValidite;
    }

    public String getNumero() {
        return numero;
    }

    public Date getDateOuverture() {
        return dateOuverture;
    }

    public double getSolde() {
        return solde;
    }

    public void setDateDeValidite(Date dateDeValidite) {
        this.dateDeValidite = dateDeValidite;
    }
    public double retrait(double montant){
        return solde -=montant;
    }


    public double depot(double montant){
        return solde+=montant;
    }
    public boolean virement(CompteEnBanque compteEnBanque, double montant){
        if (solde < 0) {
            return false;
        }
        if (montant < 0){
            return false;
        }
        else compteEnBanque.solde += montant;
        return true;
    }

    @Override
    public String toString() {
        return "CompteEnBanque : " +
                "titulaire : " + titulaire +
                " dateDeValidite : " + dateDeValidite +
                " numero : " + numero +
                " dateOuverture : " + dateOuverture +
                " solde : " + solde ;
    }
}
