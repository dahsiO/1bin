import java.util.NoSuchElementException;

public class TableEntiersNonNuls {

    private int[] table;
    private int nbEntiers;
    private static final int MAX = 10; // taille physique

    // table qui contient des entiers non nuls
    // table de taille physique = MAX
    // table ne peut pas contenir plus de MAX entiers, mais pourrait en contenir moins
    // Les entiers occupent les nbEntiers premieres cases du tableau!
    // L'ordre des entiers n'a pas d'importance


    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public TableEntiersNonNuls(int[] tableARecopier, int nbEntiers) {
        table = new int[MAX];
        for (int i = 0; i < tableARecopier.length; i++) {
            table[i] = tableARecopier[i];
        }
        this.nbEntiers = nbEntiers;

    }

    public int getNbEntiers() {
        return nbEntiers;
    }


    /**
     * calcule la moyenne des entiers compris entre les 2 entiers passes en parametre (borne comprise)
     * @param entier1 borne inferieure (comprise)
     * @param entier2 borne superieure (comprise)
     * @return la moyenne des entiers compris entre les 2 bornes
     *         ou 0 s'il n'y a aucun entier compris entre ces 2 bornes
     * @throws IllegalArgumentException si entier1 > entier2
     */
    public double moyenneEntiersComprisEntre(int entier1, int entier2){
        //TODO

            if (entier1 > entier2) {
                throw new IllegalArgumentException();
            }

            double somme = 0;
            int compteur = 0;  // Compter les éléments dans l'intervalle

            for (int i = 0; i < table.length; i++) {
                if (table[i] >= entier1 && table[i] <= entier2) {
                    somme += table[i];
                    compteur++;
                }
            }

            // Vérifier APRÈS la boucle
            if (compteur == 0) {
                return 0;
            }

            return somme / (double)compteur;  // Diviser par le nombre d'éléments trouvés
        }


    /**
     * renvoie le plus petit entier positif qui se trouve dans la table
     * @return le plus petit entier positif qui se trouve dans la table
     * @throws NoSuchElementException si la table ne contient aucun positif
     */
    public int plusPetitEntierPositif(){
        //TODO
        return 0;
    }


    /**
     * ajoute, si possible, un entier apres la premiere occurrence d'un autre entier
     * @param entier l'entier apres lequel on veut faire l'ajout
     * @param entierAAjouter l'entier a ajouter
     * @return true si l'entier a ajouter a ete ajoute, false sinon
     * @throws IllegalArgumentException si au moins 1 des 2 entiers est nul
     */
    public boolean ajouterApres(int entier, int entierAAjouter){
        //TODO
        return false;
    }

    /**
     * construit une table qui contient les entiers de la table courante
     * on y trouve d’abord les negatifs et ensuite les positifs.
     * l'ordre des entiers negatif est quelconque
     * l'ordre des entiers positif est quelconque
     * La taille physique de cette table doit correspondre au nombre d'entiers a y placer.
     * @return la table avec d'abord les negatifs et ensuite les positifs
     */
    public int[] tableNegatifsPositifs(){
        //TODO
        return null;
        //contrainte : suivez bien les indications donnees dans l'enonce

    }


    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public int nbAjoutsPossibles(){
        return table.length - nbEntiers;
    }

    @Override
    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        String aRenvoyer = "[";
        if(nbEntiers!=0) {
            aRenvoyer += table[0];
            for (int i = 1; i < nbEntiers; i++) {
                aRenvoyer += ", " + table[i];
            }
        }
        return aRenvoyer+"]";
    }
}