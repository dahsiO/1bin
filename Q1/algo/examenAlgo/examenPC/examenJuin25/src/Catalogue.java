public class Catalogue {

    private Article[] tableArticles;   //table des articles tous differents
    private int nombreArticles;


    /**
     * construit une table d'articles a partir de la table recue en parametre
     * on ne peut retrouver plusieurs fois un meme article
     * si l'article est present plusieurs fois dans la table recue,
     *       il ne sera retenu qu'une seule fois avec le prix le plus eleve
     * la taille physique de la table construite correspond a la taille physique de la table recue
     *       meme s'il y a des doublons
     * l'attribut nombreArticles doit correspondre au nombre d'articles differents retenus
     * @param tableRecue une table avec des articles pas necessairement tous differents
     * @throws IllegalArgumentException si la table recue est null ou vide ou contient des objets null
     */
    public Catalogue(Article[] tableRecue) {
        if (tableRecue == null)
            throw new IllegalArgumentException();

        if (tableRecue.length==0)
            throw new IllegalArgumentException();

        for (int i = 0; i < tableRecue.length; i++) {
            if (tableRecue[i] == null)
                throw new IllegalArgumentException();
        }


        tableArticles = new Article[tableRecue.length];
        //TODO
        nombreArticles = 0;

        // Pour chaque article de tableRecue
        for (int i = 0; i < tableRecue.length; i++) {

            // Chercher s'il est déjà présent dans tableArticles
            boolean trouve = false;
            int positionTrouvee = -1;

            for (int j = 0; j < nombreArticles; j++) {
                if (tableArticles[j].getNumeroArticle() == tableRecue[i].getNumeroArticle()) {
                    trouve = true;
                    positionTrouvee = j;
                    break;
                }
            }

            if (trouve) {
                // Il est déjà présent : si son prix est plus élevé, on le modifie
                if (tableRecue[i].getPrix() > tableArticles[positionTrouvee].getPrix()) {
                    tableArticles[positionTrouvee] = tableRecue[i];
                }
            } else {
                // Il n'est pas présent : on l'ajoute
                tableArticles[nombreArticles] = tableRecue[i];
                nombreArticles++;
            }
        }


        //pour connaitre le numero d'un article,
        //utilisez la methode getNumeroArticle() de la classe Article

        //pour connaitre le prix d'un article,
        //utilisez la methode getPrix() de la classe Article

        //pour modifier le prix d'un article,
        //utilisez la methode setPrix() de la classe Article

        //CONTRAINTE : suivez l'algorithme propose dans l'enonce


    }


    public int getNombreArticles() {
        return nombreArticles;
    }


    /**
     * renvoie le prix d'un article
     * @param numeroArticle le numero de l'article recherche
     * @return le prix de l'article ou -1 si aucun article ne porte ce numero
     */
    public double donnerPrix(int numeroArticle){
        //TODO
        for (int i = 0; i < nombreArticles; i++) {
            if (tableArticles[i].getNumeroArticle() == numeroArticle ){
                return tableArticles[i].getPrix();
            }
        }
        return -1;

        //pour connaitre le numero d'un article,
        //utilisez la methode getNumeroArticle() de la classe Article

        //pour connaitre le prix d'un article,
        //utilisez la methode getPrix() de la classe Article


    }


    /**
     * supprime un article
     * l'ordre des articles de la table doit etre conserve apres suppression
     * @param numeroArticle le numero de l'article a supprime
     * @return true si l'article etait bien present et a donc pu etre supprime, false sinon
     */
    public boolean supprimerArticle(int numeroArticle){
        //TODO
        // Chercher l'article à supprimer
        int position = -1;
        for (int i = 0; i < nombreArticles; i++) {
            if (tableArticles[i].getNumeroArticle() == numeroArticle) {
                position = i;
                break;
            }
        }

        // Si non trouvé
        if (position == -1) {
            return false;
        }

        // Décaler tous les articles suivants vers la gauche
        for (int i = position; i < nombreArticles - 1; i++) {
            tableArticles[i] = tableArticles[i + 1];
        }

        // Mettre null à la dernière position et décrémenter
        tableArticles[nombreArticles - 1] = null;
        nombreArticles--;
        //pour connaitre le numero d'un article,
        //utilisez la methode getNumeroArticle() de la classe Article
        return true;
    }



    /**
     * renvoie dans une table l'article le moins cher et l'article le plus cher
     * en cas d'ex-aequos (en terme de prix), on tiendra compte de l'ordre des articles, en prenant le 1er rencontre dans la table
     * La table renvoyee sera de dimension 0 s'il n'y a pas d'article
     * La table renvoyee sera de dimension 1 s'il n'y a qu'un seul article
     * Sinon, la table renvoyee sera de dimension 2 :
     *          on retrouve d'abord l'article le moins cher
     *          ensuite l'article le plus cher
     * La table pourrait contenir 2x le meme article, si tous les prix sont les memes
     * @return une table avec l'article le moins cher et l'article le plus cher
     */
    public Article[] minMax() {
        // Cas 1 : Aucun article
        if (nombreArticles == 0) {
            return new Article[0];
        }

        // Cas 2 : Un seul article
        if (nombreArticles == 1) {
            Article[] resultat = new Article[1];
            resultat[0] = tableArticles[0];
            return resultat;
        }

        // Cas 3 : Plusieurs articles - chercher min et max
        Article min = tableArticles[0];
        Article max = tableArticles[0];

        for (int i = 1; i < nombreArticles; i++) {
            if (tableArticles[i].getPrix() < min.getPrix()) {
                min = tableArticles[i];
            }
            if (tableArticles[i].getPrix() > max.getPrix()) {
                max = tableArticles[i];
            }
        }

        Article[] resultat = new Article[2];
        resultat[0] = min;  // Article le moins cher
        resultat[1] = max;  // Article le plus cher
        return resultat;
    }



    /**
     * calcule combien d'articles ont leur prix compris dans l'intervalle passe en parametre
     * les bornes de l'intervalle sont comprises
     * @param borneMin la borne min de l'intervalle
     * @param borneMax la borne max de l'intervalle
     * @return le nombre d'articles dans l'intervalle de prix
     * @throws IllegalArgumentException si borneMin>borneMax
     */
    public int nombreArticlesDansLIntervalle(double borneMin, double borneMax) {
        if (borneMin > borneMax)
            throw new IllegalArgumentException();
        //TODO
        return 0;

        //pour connaitre le prix d'un article,
        //utilisez la methode getPrix() de la classe Article


    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public Catalogue(){
    }
}
