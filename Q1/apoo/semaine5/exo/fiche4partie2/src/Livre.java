import java.time.LocalDate;

public class Livre {
    private String titre;
    private Auteur auteur;
    private int nbPages;
    private Date dateSoumission;
    private Date datePublication;
    private Evaluateur evaluateur;
    private boolean accepte;
    private boolean evalue;

    public Livre(String titre, Auteur auteur, int nbPages, Date dateSoumission) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.dateSoumission = dateSoumission;
        this.datePublication = null;
        this.evaluateur = null;
        this.accepte = false;
        this.evalue = false;
    }

    // Méthodes principales
    public boolean accepter(Evaluateur eval, Date datePublication) {
        if (evalue) return false;
        if (eval == null) return false;

        this.evaluateur = eval;
        this.accepte = true;
        this.evalue = true;
        this.datePublication = datePublication;

        eval.incrementerNbLivres();
        return true;
    }

    public boolean refuser(Evaluateur eval) {
        if (evalue) return false;
        if (eval == null) return false;

        this.evaluateur = eval;
        this.accepte = false;
        this.evalue = true;

        eval.incrementerNbLivres();
        return true;
    }

    public boolean ajouterDatePublication(Date date) {
        if (!accepte) return false;
        this.datePublication = date;
        return true;
    }

    public boolean estEvalue() {
        return evalue;
    }

    // Getters
    public String getTitre() { return titre; }
    public Auteur getAuteur() { return auteur; }
    public int getNbPages() { return nbPages; }
    public Date getDateSoumission() { return dateSoumission; }
    public Date getDatePublication() { return datePublication; }
    public Evaluateur getEvaluateur() { return evaluateur; }
    public boolean isAccepte() { return accepte; }

    @Override
    public String toString() {
        String texte = "Titre : " + titre +
                "\nAuteur : " + auteur.getPrenom() + " " + auteur.getNom() +
                "\nPages : " + nbPages;

        if (!evalue) {
            texte += "\nStatut : en attente d'évaluation";
        } else if (accepte) {
            texte += "\nStatut : accepté";
            if (datePublication != null)
                texte += "\nDate de publication : " + datePublication;
        } else {
            texte += "\nStatut : refusé";
        }
        return texte;
    }
}
