import java.util.ArrayList;

public class RallyeAutomobile {

    // Pilotes encore en course (ordre = positions)
    private ListeSDImpl<String> enCourse;

    // Pilotes retirés de la course (pas encore arrivés, ex: abandon)
    private ListeSDImpl<String> horsCourse;

    // Pilotes arrivés dans l'ordre d'arrivée
    private ArrayList<String> classement;

    // Tous les pilotes inscrits au départ (pour valider les remises en course)
    private ArrayList<String> tousLesPilotes;

    // -------------------------------------------------------
    // Constructeur
    // -------------------------------------------------------
    public RallyeAutomobile(String[] lesPilotes) {
        enCourse      = new ListeSDImpl<>(lesPilotes);
        horsCourse    = new ListeSDImpl<>();
        classement    = new ArrayList<>();
        tousLesPilotes = new ArrayList<>();
        for (String p : lesPilotes) {
            tousLesPilotes.add(p);
        }
    }

    // -------------------------------------------------------
    // B1 — méthodes de base
    // -------------------------------------------------------

    /** Affiche tous les pilotes en course, du 1er au dernier */
    public String afficherCourse() {
        StringBuilder sb = new StringBuilder();
        int pos = 1;
        for (String p : enCourse) {
            sb.append(pos++).append(". ").append(p).append("\n");
        }
        return sb.length() == 0 ? "(aucun pilote en course)" : sb.toString().trim();
    }

    /** Renvoie le pilote en tête, ou null si la course est vide */
    public String donnerPiloteEnTete() {
        return enCourse.premier();
    }

    /**
     * Enregistre un dépassement : le pilote dépasse celui qui le précède.
     * Retourne false si le pilote est absent ou est déjà en tête.
     */
    public boolean enregistrerDepassement(String pilote) {
        if (!enCourse.contient(pilote)) return false;
        String precedent = enCourse.donnerPrecedent(pilote);
        if (precedent == null) return false; // déjà en tête
        return enCourse.permuter(pilote, precedent);
    }

    /**
     * Retire un pilote de la course (abandon).
     * Il passe dans horsCourse.
     */
    public boolean supprimer(String pilote) {
        if (!enCourse.contient(pilote)) return false;
        enCourse.supprimer(pilote);
        horsCourse.insererEnQueue(pilote);
        return true;
    }

    /**
     * Donne la position (1-based) d'un pilote encore en course.
     * Retourne -1 si absent.
     */
    public int donnerPosition(String pilote) {
        if (!enCourse.contient(pilote)) return -1;
        int pos = 1;
        for (String p : enCourse) {
            if (p.equals(pilote)) return pos;
            pos++;
        }
        return -1;
    }

    /**
     * Le pilote de tête franchit la ligne d'arrivée.
     * Il est retiré de la course et ajouté au classement.
     * Retourne le nom du pilote, ou null si la course est vide.
     */
    public String franchirligneDarrivee() {
        String tete = enCourse.premier();
        if (tete == null) return null;
        enCourse.supprimer(tete);
        classement.add(tete);
        return tete;
    }

    /** Indique si la course est terminée (plus aucun pilote) */
    public boolean estTerminee() {
        return enCourse.estVide();
    }

    // -------------------------------------------------------
    // B3 — méthodes supplémentaires
    // -------------------------------------------------------

    /**
     * Remet un pilote hors-course après un autre pilote en course.
     * Conditions :
     *  - Le pilote doit avoir participé à la course
     *  - Il ne doit pas être déjà en course
     *  - Il ne doit pas avoir déjà franchi la ligne d'arrivée
     *  - Le pilote de référence doit être en course
     */
    public boolean remettreEnCourse(String pilote, String apres) {
        // Vérifications
        if (!tousLesPilotes.contains(pilote))    return false; // n'a pas participé
        if (enCourse.contient(pilote))            return false; // déjà en course
        if (classement.contains(pilote))          return false; // déjà arrivé
        if (!enCourse.contient(apres))            return false; // référence absente

        horsCourse.supprimer(pilote);
        enCourse.insererApres(apres, pilote);
        return true;
    }

    /** Affiche les pilotes hors course (abandons) */
    public String afficherHorsCourse() {
        StringBuilder sb = new StringBuilder();
        for (String p : horsCourse) {
            sb.append("- ").append(p).append("\n");
        }
        return sb.length() == 0 ? "(aucun pilote hors course)" : sb.toString().trim();
    }

    /** Affiche le classement final (dans l'ordre d'arrivée) */
    public String afficherClassement() {
        if (classement.isEmpty()) return "(aucun pilote arrivé)";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < classement.size(); i++) {
            sb.append(i + 1).append(". ").append(classement.get(i)).append("\n");
        }
        return sb.toString().trim();
    }

    /**
     * Vérifie si un pilote a franchi la ligne d'arrivée.
     * Retourne -1 si non arrivé, sinon sa position au classement (1-based).
     */
    public int verifierArrivee(String pilote) {
        int idx = classement.indexOf(pilote);
        return idx == -1 ? -1 : idx + 1;
    }
}
