public class Tournoi {
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private Club clubOrganisateur; // nullable

    // Constructeur sans club
    public Tournoi(String nom, Date dateDebut, Date dateFin) {
        this(nom, dateDebut, dateFin, null);
    }

    // Constructeur avec club
    public Tournoi(String nom, Date dateDebut, Date dateFin, Club clubOrganisateur) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.clubOrganisateur = clubOrganisateur;
    }

    public String getNom() { return nom; }
    public Date getDateDebut() { return dateDebut; }
    public Date getDateFin() { return dateFin; }
    public Club getClubOrganisateur() { return clubOrganisateur; }

    @Override
    public String toString() {
        String s = "Nom : " + nom + "\n" +
                "Date début : " + dateDebut + "\n" +
                "Date fin : " + dateFin + "\n";
        if (clubOrganisateur != null) {
            s += "Club organisateur : " + clubOrganisateur.getNom();
        } else {
            s += "Club organisateur : aucun";
        }
        return s;
    }
}
