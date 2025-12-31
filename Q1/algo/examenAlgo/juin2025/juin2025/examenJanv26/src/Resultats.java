public class Resultats {

    private Etudiant[] tableEtudiants;   //table non vide d'etudiants tous differents
                                         //elle est triee selon l'ordre croissant des matricules

    /**
     * verifie si la table passee en parametre est triee selon l'ordre croissant des matricules des etudiants
     *            et qu'elle ne contient pas 2 etudiants qui ont le meme matricule
     * @param tableAVerifier la table a verifier
     * @return true si la table est triee et sans doublon, false sinon
     * @throws IllegalArgumentException si la table est null ou vide ou contient des objets null
     */
    public static boolean estTrieeEtSansDoublon(Etudiant[] tableAVerifier) {

        if (tableAVerifier == null)
            throw new IllegalArgumentException();

        if (tableAVerifier.length == 0)
            throw new IllegalArgumentException();

        for (int i = 0; i < tableAVerifier.length; i++) {
            if (tableAVerifier[i] == null)
                throw new IllegalArgumentException();
        }

        //TODO

        //pour connaitre le matricule d'un etudiant,
        //utilisez la methode getMatricule() de la classe Etudiant

       return false;
    }


    /**
     * calcule la moyenne des points des etudiants
     * precondition (a ne pas verifier) : il y a au moins 1 etudiant
     * @return la moyenne
     */
    public double moyenne() {

        //TODO

        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        return 0;
    }


    /**
     * calcule la mediane des points des etudiants
     * precondition (a ne pas verifier) : il y a au moins 1 etudiant
     * @return la mediane
     */
    public double mediane() {

        //TODO

        //suivez l'algorithme impose (cfr enonce)

        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        return 0;
    }

    /**
     * calcule combien d'etudiants ont leurs points compris dans l'intervalle passe en parametre
     * les bornes de l'intervalle sont comprises
     * @param borneMin la borne min de l'intervalle
     * @param borneMax la borne max de l'intervalle
     * @return le nombre d'etudiants dans l'intervalle de points
     * @throws IllegalArgumentException si borneMin>borneMax
     */
    public int nombreEtudiantsDansLIntervalle(double borneMin, double borneMax) {
        if (borneMin > borneMax)
            throw new IllegalArgumentException();
        //TODO

        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        return 0;
    }


    /**
     * renvoie une table avec les etudiants qui ont reussi (points>=10)
     * la table renvoyee est triee selon l'ordre croissant des matricules des etudiants
     * la taille de la table renvoyee correspond au nombre d'etudiants qui ont reussi
     * cette table pourrait etre vide
     * @return une table contenant les etudiants qui ont reussi
     */
    public Etudiant[] donnerTableEtudiantsEnReussite() {
        //TODO

        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        //pour connaitre la taille de la table,
        //pensez a utiliser la methode nombreEtudiantsDansLIntervalle() !

       return null;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public Resultats(Etudiant[] tableARecopier) {
        tableEtudiants = new Etudiant[tableARecopier.length];
        for (int i = 0; i < tableARecopier.length; i++) {
            tableEtudiants[i] = tableARecopier[i];
        }
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        String aRenvoyer = "matricule  nom    points";
        for (int i = 0; i < tableEtudiants.length; i++) {
            aRenvoyer+="\n"+tableEtudiants[i];
        }
        return aRenvoyer;
    }

}
