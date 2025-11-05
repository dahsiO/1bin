

public class Club {
    private String matricule;
    private String nom;
    private Adresse adresse;
    private Joueur directeurTournoi; // peut être null

    public Club(String matricule, String nom, Adresse adresse) {
        this.matricule = matricule;
        this.nom = nom;
        this.adresse = adresse;
        this.directeurTournoi = null;
    }

    // getters
    public String getMatricule() { return matricule; }
    public String getNom() { return nom; }
    public Adresse getAdresse() { return adresse; }
    public Joueur getDirecteurTournoi() { return directeurTournoi; }

    // modifier l'adresse
    public void setAdresse(Adresse adresse) { this.adresse = adresse; }

    /**
     * Enregistre un joueur comme directeur des tournois.
     * Échoue si :
     * - joueur == null
     * - joueur n'appartient pas à ce club
     * - il y a déjà un directeur
     * Retourne true si succès.
     */
    public boolean enregistrerDirecteur(Joueur joueur) {
        if (joueur == null) return false;
        if (joueur.getClub() != this) return false;
        if (this.directeurTournoi != null) return false;
        this.directeurTournoi = joueur;
        return true;
    }

    /**
     * Supprime le directeur de tournoi s'il existe.
     * Retourne true si un directeur a été supprimé, false sinon.
     */
    public boolean supprimerDirecteur() {
        if (this.directeurTournoi == null) return false;
        this.directeurTournoi = null;
        return true;
    }

    /**
     * toString textuel du club.
     * Si directeur présent -> on n'indique que son prénom (pas son nom).
     */
    @Override
    public String toString() {
        String s = "Matricule : " + matricule + "\n" +
                "Nom : " + nom + "\n" +
                "Adresse : " + adresse + "\n";
        if (directeurTournoi != null) {
            s += "Directeur des tournois : " + directeurTournoi.getPrenom();
        } else {
            s += "Directeur des tournois : aucun";
        }
        return s;
    }
}
