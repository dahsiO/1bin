import java.util.NoSuchElementException;

public class EquipeGuerriers {

    private Guerrier[] tableGuerriers;
    private int nombreGuerriers;
    private Guerrier guerrierAuCombat = null;


    /**
     * construit l'equipe
     * les guerriers sont selectionnes parmi les guerriers contenus dans la table passee en parametre
     * precondition (a ne pas verifier) : la table permet la creation de l'equipe
     *
     * @param tableTousLesGuerriers table avec tous les guerriers
     * @param pointsDeVieMin        nombre de points de vie minimum pour etre selectionne
     * @throws IllegalArgumentException si les points de vie sont negatifs ou nul
     */
    public EquipeGuerriers(Guerrier[] tableTousLesGuerriers, int pointsDeVieMin) {

        if (pointsDeVieMin <= 0)
            throw new IllegalArgumentException("jeu impossible!");

        tableGuerriers = new Guerrier[tableTousLesGuerriers.length];

        //TODO

        //Il ne faut pas initialiser l'attribut guerrierAuCombat

        //pour connaitre le nombre de points de vie d'un guerrier,
        //utilisez la methode getPointsDeVie()

     }

    /**
     * renvoie le nombre de guerriers en attente de combat
     *
     * @return le nombre de guerriers en attente de combat
     */
    public int getNombreGuerriers() {
        return nombreGuerriers;
    }


    /**
     * renvoie le guerrier au combat
     *
     * @return le guerrier au combat
     */
    public Guerrier getGuerrierAuCombat() {
        return guerrierAuCombat;
    }


    /**
     * recherche l'indice du guerrier qui a le plus de points de vie
     * en cas d'ex-aequo, c'est celui qui est rencontre en premier dans la table qui ira au combat
     * precondition (a ne pas verifier) : il y a au moins un guerrier dans la table
     *
     * @return l'indice du guerrier qui a le plus de points de vie
     */
    public int indiceMeilleurGuerrier() {

        //TODO
        return 0;

        //pour connaitre le nombre de points de vie d'un guerrier,
        //utilisez la methode getPointsDeVie()

    }


    /**
     * supprime le guerrier qui se trouve a l'indice passe en parametre
     * apres suppression, l'ordre des guerriers restants doit etre respecte
     * precondition (a ne pas verifier) : l'indice est valide
     *
     * @param indice indice du guerrier a supprimer
     */
    public void supprimerALIndice(int indice) {

        //TODO

    }


    /**
     * selectionne un guerrier pour le combat et le retire de la table
     * le guerrier qui va combattre est le guerrier qui a le plus de points de vie
     * en cas d'ex-aequo, c'est celui qui est rencontre en premier dans la table qui ira au combat
     * apres suppression, l'ordre des guerriers restants doit etre respecte
     *
     * @throws NoSuchElementException s'il n'y a plus de guerrier en attente de combat
     */
    public void selectionnerGuerrierAuCombat() {
        if (nombreGuerriers == 0)
            throw new NoSuchElementException();

        //TODO

        //contrainte : utilisez les methodes indiceMeilleurGuerrier() et supprimerALIndice()

        //il faut modifier l'attribut guerrierAuCombat

    }


    /**
     * diminue le nombre de points de vie du guerrier qui doit combattre.
     * si le guerrier est toujours vivant, il reprend place dans la table apres le dernier guerrier encore en jeu.
     *
     * @param pointsDeViePerdus le nombre de points de vie perdu par le guerrier au combat
     * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
     * @throws IllegalStateException    s'il n'y a pas de guerrier au combat
     */
    public void jouer(int pointsDeViePerdus) {
        if (pointsDeViePerdus < 0)
            throw new IllegalArgumentException();
        if (guerrierAuCombat == null)
            throw new IllegalStateException();

        //TODO

        //n'oubliez pas de remettre l'attribut guerrierAuCombat a null

        //pour diminuer le nombre de points de vie du guerrier,
        //utilisez la methode retirerPointsDeVie()

    }

    /**
     * cree une table triee avec les guerriers en attente
     * les guerriers y apparaissent selon l'ordre decroissant des points de vie
     * (si 2 guerriers ont le meme nombre de points de vie l'ordre n'a pas d'importance)
     * @return la table triee des guerriers selon l'ordre decroissant des points de vie
     */
    public Guerrier[] tableTrieeGuerriers() {
        Guerrier[] tableTriee = new Guerrier[nombreGuerriers];
        for (int i = 0; i < nombreGuerriers; i++) {
            tableTriee[i] = tableGuerriers[i];
        }

        //TODO

        //CONTRAINTE :

        //Utilisez le TRI A BULLES pour trier la table tableTriee
        //cfr enonce

        //pour connaitre le nombre de points de vie d'un guerrier,
        //utilisez la methode getPointsDeVie()

        return tableTriee;
    }


    /**
     * A NE PAS MODIFIER
     * VA SERVIR POUR LES TESTS
     *
     * @return le contenu de la table des guerriers
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
    public EquipeGuerriers(Guerrier[] tableARecopier, int nombreGuerriers, Guerrier guerrier) {
        tableGuerriers = new Guerrier[tableARecopier.length];
        for (int i = 0; i < nombreGuerriers; i++) {
            tableGuerriers[i] = tableARecopier[i];
        }
        this.nombreGuerriers = nombreGuerriers;
        this.guerrierAuCombat = guerrier;
    }

}
