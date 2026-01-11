
public class EquipeGuerriers {

    private Guerrier[] tableGuerriers;
    private int nombreGuerriers;

    /**
     * construit l'equipe
     * les guerriers sont les nombreGuerriersMax premiers guerriers vivants contenus dans la table passee en parametre.
     * cette equipe est constituee de maximum nombreGuerriersMax guerriers
     * cependant, il pourrait y en avoir moins si la tableTousGuerriers contient moins de nombreGuerriersMax guerriers vivants.
     * precondition (a ne pas verifier) : la table passee en parametre ne contient pas de null, ni d'ex-aequo
     * @param tableTousLesGuerriers table avec tous les guerriers
     * @param nombreGuerriersMax  le nombre maximum de guerriers dans l'equipe
     * @throws IllegalArgumentException : le nombre maximum de guerriers a selectionner ne peut pas etre negatif ou nul
     *                                  : la table passee en parametre ne peut etre null
     */
    public EquipeGuerriers(Guerrier[] tableTousLesGuerriers, int nombreGuerriersMax) {

        if (nombreGuerriersMax <= 0)
            throw new IllegalArgumentException();

        if(tableTousLesGuerriers==null)
            throw new IllegalArgumentException();

        // A NE PAS MODIFIER :
        tableGuerriers = new Guerrier[nombreGuerriersMax];
        int index =0;
        //TODO
        for (int i = 0; i < tableTousLesGuerriers.length; i++) {
            if (tableTousLesGuerriers[i].estVivant() && index < nombreGuerriersMax) {
                tableGuerriers[index] = tableTousLesGuerriers[i];
                index++;
            }
        }
        // ⬅️ CRITIQUE : Mettre à jour nombreGuerriers !
        nombreGuerriers = index;
        //pour savoir si un guerrier est vivant
        //utilisez la methode estVivant()

     }

    /**
     * renvoie le nombre de guerriers encore au combat
     * @return le nombre de guerriers encore au combat
     */
    public int getNombreGuerriers() {
        return nombreGuerriers;
    }


    /**
     * calcule la moyenne des points de vie des guerriers encore au combat
     * @return la moyenne des points de vie des guerriers encore au combat
     */
    public double moyennePointsDeVie(){
        //TODO
        int somme = 0;
        int nbVivant = 0;
        for (int i = 0; i < nombreGuerriers; i++) {
            if (tableGuerriers[i].estVivant()){
                somme += tableGuerriers[i].getPointsDeVie();
                nbVivant++;
            }
        }
        if (nbVivant == 0)return 0;
        return (double) somme / nbVivant;

        //pour connaitre le nombre de points de vie d'un guerrier,
        //utilisez la methode getPointsDeVie()

    }

    /**
     * calcule le nombre de guerriers encore au combat
     * qui ont des points de vie compris entre les 2 bornes passees en parametre
     * (bornes comprises)
     * @param nombrePointsDeVie1 une des 2 bornes (pas necessairement la plus petite)
     * @param nombrePointsDeVie2 une des 2 bornes (pas necessairement la plus grande)
     * @return le nombre de guerriers encore au combat
     *         qui ont des points de vie compris entre les 2 bornes
     */
    public int nombreGuerriersEntre(int nombrePointsDeVie1, int nombrePointsDeVie2){
        int compteur =0;
        for (int i = 0; i < nombreGuerriers; i++) {
            if (nombrePointsDeVie1 < nombrePointsDeVie2){
                if (tableGuerriers[i].getPointsDeVie() >= nombrePointsDeVie1 && tableGuerriers[i].getPointsDeVie() <= nombrePointsDeVie2){
                compteur++;
                }
            }else {
                if (tableGuerriers[i].getPointsDeVie() <= nombrePointsDeVie1 && tableGuerriers[i].getPointsDeVie() >= nombrePointsDeVie2){
                    compteur++;
                }
            }

        }
        //TODO
        return compteur;

        //pour connaitre le nombre de points de vie d'un guerrier,
        //utilisez la methode getPointsDeVie()


    }


    /**
     * calcule le plus grand ecart de points de vie entre 2 guerriers encore au combat
     * @return l'ecart de points de vie maximum entre 2 guerriers ou -1 s'il n'y a plus au minimum 2 guerriers vivants
     */
    public int ecartMaximum() {
        //TODO
        // 1. Compter les vivants d'abord
        int nbVivants = 0;
        for (int i = 0; i < nombreGuerriers; i++) {
            if (tableGuerriers[i].estVivant()) {
                nbVivants++;
            }
        }

        // 2. Vérifier si au moins 2 vivants
        if (nbVivants < 2) {
            return -1;
        }

        // 3. Trouver min et max PARMI LES VIVANTS
        int min = tableGuerriers[0].getPointsDeVie();
        int max = tableGuerriers[0].getPointsDeVie();

        for (int i = 0; i < nombreGuerriers; i++) {
            if (tableGuerriers[i].estVivant()) {
                int pv = tableGuerriers[i].getPointsDeVie();

                if (pv < min) {
                    min = pv;
                }
                if (pv > max) {
                    max = pv;
                }
            }
        }

        return max - min;

        //pour connaitre le nombre de points de vie d'un guerrier,
        //utilisez la methode getPointsDeVie()

        //suggestion : faites une recherche de points de vie max et une recherche de points de vie min.
        //l'ecart maximum sera la difference entre ces 2 valeurs.

    }

    /**
     * fait combattre le guerrier qui se trouve en debut de table :
     *      supprime ce guerrier de la table
     *      diminue son nombre de points de vie
     *      si le guerrier est toujours vivant, le place dans la table
     *               apres le dernier guerrier encore en jeu
     *               ou en debut de table si tous les autres guerriers sont morts
     * @param pointsDeViePerdus le nombre de points de vie perdu par le guerrier combattant
     * @return le guerrier combattant ou null si tous les guerriers sont morts
     * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
     */
    public Guerrier combattre(int pointsDeViePerdus) {

        if (pointsDeViePerdus < 0)
            throw new IllegalArgumentException();

        //TODO
       // verifier si la table est null
        if (nombreGuerriers == 0) {
            return null;
        }
        //sauvegarder le geurrier en position 0
        Guerrier combattant = tableGuerriers[0];
        //supprimer le guerrier en position 0
        //decaleer tous les guerrier ver la gauche
        for (int i = 0; i < nombreGuerriers - 1; i++) {
            tableGuerriers[i] = tableGuerriers[i + 1];
        }
        //go nettaoyer la derniere position et decrementer
        tableGuerriers[nombreGuerriers -1] = null;
        nombreGuerriers--;
        //le guerrier perd des point de vie
        combattant.retirerPointsDeVie(pointsDeViePerdus);
        //si le gladiator a survecue le remettre dans les rend de ces freres guerrier
        if (combattant.estVivant()) {
            tableGuerriers[nombreGuerriers] = combattant;
            nombreGuerriers++;
        }

        return combattant;

        //pour diminuer le nombre de points de vie du guerrier,
        //utilisez la methode retirerPointsDeVie()

        //pour savoir si un guerrier est vivant
        //utilisez la methode estVivant()

    }


    /**
     * A NE PAS MODIFIER
     * VA SERVIR POUR LES TESTS
     *
     * @return une chaine de caracteres avec les guerriers encore au combat
     */
    public String toString() {
        if (tableGuerriers == null)
            return null;
        if (nombreGuerriers == 0) {
            return "aucun guerrier";
        }
        String aRenvoyer = "" + tableGuerriers[0];
        for (int i = 1; i < nombreGuerriers; i++) {
            aRenvoyer += " " + tableGuerriers[i];
        }
        return aRenvoyer;
    }


    // Attention : seul interet de ce constructeur : les tests!!!
    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public EquipeGuerriers(Guerrier[] tableARecopier, int nombreGuerriersMax, int nombreGuerriersAuCombat) {
        tableGuerriers = new Guerrier[nombreGuerriersMax];
        for (int i = 0; i < tableARecopier.length; i++) {
            tableGuerriers[i] = tableARecopier[i];
        }
        this.nombreGuerriers = nombreGuerriersAuCombat;
    }

}
