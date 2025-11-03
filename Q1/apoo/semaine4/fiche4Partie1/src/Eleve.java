public class Eleve {
    private String nom;
    private String prenom;
    private Cours coursPrincipal;
    private Cours coursComplementaire; // optionnel

    // Constructeur avec cours principal uniquement
    public Eleve(String nom, String prenom, Cours coursPrincipal) {
        this.nom = nom;
        this.prenom = prenom;
        this.coursPrincipal = coursPrincipal;
        this.coursComplementaire = null;
        coursPrincipal.inscrire(); // inscription automatique
    }

    // Constructeur avec cours principal + cours complémentaire
    public Eleve(String nom, String prenom, Cours coursPrincipal, Cours coursComplementaire) {
        this(nom, prenom, coursPrincipal);
        this.coursComplementaire = coursComplementaire;
        coursComplementaire.inscrire();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Cours getCoursPrincipal() {
        return coursPrincipal;
    }

    public Cours getCoursComplementaire() {
        return coursComplementaire;
    }

    // Méthode pour initialiser un cours complémentaire s’il n’existe pas encore
    public boolean initialiserCoursComplementaire(Cours cours) {
        if (coursComplementaire == null) {
            coursComplementaire = cours;
            cours.inscrire();
            return true;
        }
        return false; // déjà un cours complémentaire
    }

    // Méthode pour supprimer un cours complémentaire existant
    public boolean supprimerCoursComplementaire() {
        if (coursComplementaire != null) {
            coursComplementaire.desinscrire();
            coursComplementaire = null;
            return true;
        }
        return false; // aucun cours complémentaire à supprimer
    }

    @Override
    public String toString() {
        String texte = "Nom : " + nom + "\n" +
                "Prénom : " + prenom + "\n" +
                "Cours principal : " + coursPrincipal.getIntitule() +
                " (" + coursPrincipal.getNiveau() + ")\n";
        if (coursComplementaire != null) {
            texte += "Cours complémentaire : " + coursComplementaire.getIntitule() +
                    " (" + coursComplementaire.getNiveau() + ")";
        } else {
            texte += "Cours complémentaire : aucun";
        }
        return texte;
    }
}
