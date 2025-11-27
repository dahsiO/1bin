
public class Joueur {
    private String matricule;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Club club;
    private int nbParties;
    private int pointsElo; // par exigence : doit être >= 1150 lors modification

    public Joueur(String matricule, String nom, String prenom, Date dateNaissance, Club club) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.club = club;
        this.nbParties = 0;
        this.pointsElo = 0;
    }

    // getters
    public String getMatricule() { return matricule; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public Date getDateNaissance() { return dateNaissance; }
    public Club getClub() { return club; }
    public int getNbParties() { return nbParties; }
    public int getPointsElo() { return pointsElo; }

    // incrémenter le nombre de parties
    public void incrementerNbParties() {
        this.nbParties++;
    }

    /**
     * Modifier les points elo.
     * - doit être >= 1150
     * - ne peut pas être modifié tant que nbParties < 10
     * Renvoie true si modification acceptée.
     */
    public boolean modifierPointsElo(int nouveauxPoints) {
        if (nouveauxPoints < 1150) return false;
        if (this.nbParties < 10) return false;
        this.pointsElo = nouveauxPoints;
        return true;
    }

    /**
     * Changer de club.
     * - Échoue si newClub == null ou newClub == club actuel
     * - Si le joueur était directeur du club quitt�, on supprime ce directeur du club quitt�
     * Retourne true si changement effectué.
     */
    public boolean changerClub(Club newClub) {
        if (newClub == null) return false;
        if (this.club == newClub) return false;

        // si joueur est directeur du club actuel, on supprime ce directeur
        if (this.club != null && this.club.getDirecteurTournoi() == this) {
            this.club.supprimerDirecteur();
        }

        this.club = newClub;
        return true;
    }

    @Override
    public String toString() {
        String s = "Matricule : " + matricule + "\n" +
                "Nom : " + nom + "\n" +
                "Prénom : " + prenom + "\n" +
                "Date de naissance : " + dateNaissance + "\n" +
                "Club : " + (club != null ? club.getNom() : "aucun") + "\n" +
                "Nombre de parties : " + nbParties + "\n" +
                "Points ELO : " + pointsElo;
        return s;
    }

}
