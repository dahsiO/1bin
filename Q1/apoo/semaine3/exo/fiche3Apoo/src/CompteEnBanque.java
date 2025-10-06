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

    public void setDateDeValidite(Date nouvelledateDeValidite) {
        this.dateDeValidite = nouvelledateDeValidite;
    }
    public double retrait(double montant){
        return solde -=montant;

    }


    public double depot(double montant){
        return solde+=montant;
    }
    public boolean virement(CompteEnBanque compteEnBanque, double montant){
        // verifier si le compte est pas null
        if (compteEnBanque == null){
        return false;
        }
        //verifier si il fait pas de virement a lui meme
        if (compteEnBanque == this){
            return false;
        }
        // verifier que il a le solde sufisant
        if (solde < montant) {
            return false;
        }
        if (montant <= 0){
            return false;
        }
        // diminuier du compte
        else compteEnBanque.solde += montant;
        solde-=montant;
        return true;
    }

    @Override
    public String toString() {
        return "CompteEnBanque : " +
                "titulaire : " + titulaire +
                " dateDeValidite : " + dateDeValidite +
                " numero : " + numero +
                " dateOuverture : " + dateOuverture +
                " solde : " + solde +"$" ;
    }
}
