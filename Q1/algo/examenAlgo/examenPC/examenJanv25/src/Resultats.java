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
        //verifier si c est trier et sans doublon
        for (int i = 0; i < tableAVerifier.length -1; i++) {
            //plus petit au plus GRAND => matricule
            if (tableAVerifier[i].getMatricule() >= tableAVerifier[i+1].getMatricule()){
                return false;
            }

        }

        //pour connaitre le matricule d'un etudiant,
        //utilisez la methode getMatricule() de la classe Etudiant

       return true;
    }


    /**
     * calcule la moyenne des points des etudiants
     * precondition (a ne pas verifier) : il y a au moins 1 etudiant
     * @return la moyenne
     */
    public double moyenne() {

        //TODO
        double somme = 0;
        for (int i = 0; i < tableEtudiants.length; i++) {
            somme += tableEtudiants[i].getPoints();

        }
        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        return  somme / tableEtudiants.length;
    }


    /**
     * calcule la mediane des points des etudiants
     * precondition (a ne pas verifier) : il y a au moins 1 etudiant
     * @return la mediane
     */
    public double mediane() {
        // etape 1 copier le tableau
        Etudiant[] temp = new Etudiant[tableEtudiants.length];
        for (int i = 0; i < tableEtudiants.length; i++) {
            temp[i] = tableEtudiants[i];

        }
        // etape 2 calculer le nombre etape neccessaire
        int nbEtape = (tableEtudiants.length/2)+1;

        double mediane = 0;
        // etape 3 pour chaque etape trouver le min
        for (int etape = 0; etape < nbEtape; etape++) {
            double min = temp[0].getPoints(); // utilise ce que tu cree zamel
            int indexMin = 0;

            for (int i = 0; i < temp.length; i++) {
                if (temp[i].getPoints() < min){
                    min = temp[i].getPoints();
                    indexMin = i;
                }
            }

            mediane = min;
            // Neutraliser avec setPoints (si disponible)
            temp[indexMin] = new Etudiant(999, "hamid",999);

        }
        //TODO

        //suivez l'algorithme impose (cfr enonce)

        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        return mediane;
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
        //5 et max =15
        int compteur = 0;
        for (int i = 0; i < tableEtudiants.length; i++) {
            if (tableEtudiants[i].getPoints() >=borneMin && tableEtudiants[i].getPoints() <= borneMax){
                compteur++;
            }

        }



        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        return compteur;
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
        for (int i = 0; i < tableEtudiants.length -1; i++) {
            for (int j = 0; j < tableEtudiants.length -1 ; j++) {

                // { 2 1 3}
                if (tableEtudiants[j].getMatricule() > tableEtudiants[j + 1].getMatricule()){
                    // temp = 2
                    Etudiant temp = tableEtudiants[j];
                    // tableEtudiant [j]= 1
                    tableEtudiants[j] = tableEtudiants[j + 1];
                    // tableEtudiant [j + 1] = temp = 2
                    tableEtudiants[j + 1] = temp;
                    // table{ 1 , 2 , 3}
                }
            }
        }
        int index = 0;
        Etudiant [] tabreussi = new Etudiant[nombreEtudiantsDansLIntervalle(10,20)];
        for (int i = 0; i < tableEtudiants.length; i++) {
            if (tableEtudiants[i].getPoints() >= 10){
                tabreussi[index] = tableEtudiants[i];
                index++;
            }

        }
        //pour connaitre les points d'un etudiant,
        //utilisez la methode getPoints() de la classe Etudiant

        //pour connaitre la taille de la table,
        //pensez a utiliser la methode nombreEtudiantsDansLIntervalle() !

       return tabreussi;
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
