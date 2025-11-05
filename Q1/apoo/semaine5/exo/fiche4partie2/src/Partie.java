import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Partie {
    private Date date;
    private Joueur blanc;
    private Joueur noir;
    private Tournoi tournoi;
    private Double pointsBlanc; // null si non enregistré
    private Double pointsNoir;  // null si non enregistré


    public Partie(Date date, Joueur blanc, Joueur noir, Tournoi tournoi) {

        this.date = date;
        this.blanc = blanc;
        this.noir = noir;
        this.tournoi = tournoi;
        this.pointsBlanc = null;
        this.pointsNoir = null;
    }

    // getters
    public Date getDate() { return date; }
    public Joueur getBlanc() { return blanc; }
    public Joueur getNoir() { return noir; }
    public Tournoi getTournoi() { return tournoi; }
    public Double getPointsBlanc() { return pointsBlanc; }
    public Double getPointsNoir() { return pointsNoir; }

    /**
     * Enregistre le résultat en fournissant uniquement les points du joueur blanc.
     * - doit être une valeur dans {0, 0.5, 1}
     * - échec si résultat déjà enregistré
     * - incrémente le nbParties des deux joueurs au moment de l'enregistrement
     * Retourne true si succès.
     */
    public boolean enregistrerResultat(double pointsBlanc) {
        if (this.pointsBlanc != null) return false; // déjà enregistré
        this.pointsBlanc = pointsBlanc;
        // pour les échecs les points du noir sont :
        // si blanc = 1 -> noir = 0
        // si blanc = 0 -> noir = 1
        // si blanc = 0.5 -> noir = 0.5
        this.pointsNoir = 1.0 - pointsBlanc;

        // incrémentation du nombre de parties pour les deux joueurs
        this.blanc.incrementerNbParties();
        this.noir.incrementerNbParties();

        return true;
    }

    /**
     * Retourne le gagnant (Joueur) si il y a un gagnant, null si match nul ou résultat non enregistré.
     */
    public Joueur getGagnant() {
        if (pointsBlanc == null || pointsNoir == null) return null;
        if (pointsBlanc == pointsNoir) return null; // match nul
        // si blanc > noir -> blanc gagnant
        if (pointsBlanc > pointsNoir) return blanc;
        return noir;
    }

    @Override
    public String toString() {
        String s = "Date : " + date + "\n" +
                "Blanc : " + blanc.getPrenom() + " " + blanc.getNom() + "\n" +
                "Noir : " + noir.getPrenom() + " " + noir.getNom() + "\n" +
                "Tournoi : " + (tournoi != null ? tournoi.getNom() : "aucun") + "\n";
        if (pointsBlanc != null) {
            s += "Résultat : blanc " + pointsBlanc + " - noir " + pointsNoir;
        } else {
            s += "Résultat : non enregistré";
        }
        return s;
    }
}
