import java.util.HashSet;

public class ListeAMImplV1<E> implements ListeAM<E> {

    private E[] table;
    private int taille; //taille logique

    /**
     * construit une liste initiale
     * @param tableInitiale la table initiale avec les elements de la liste de depart
     * @throws IllegalArgumentException si la table passee en parametre est null, contient des null ou des ex-aequos
     */
    public ListeAMImplV1(E[] tableInitiale ){
        if(!estValide(tableInitiale))
            throw new IllegalArgumentException();
        table = (E[]) new Object[tableInitiale.length];
        for (int i = 0; i < tableInitiale.length; i++) {
            table[i]=tableInitiale[i];
        }
        taille = tableInitiale.length;
    }

    private boolean estValide(E[] tableInitiale){
        if(tableInitiale==null)
            return false;
        HashSet<E> ensemble = new HashSet<>();
        for (int i = 0; i < tableInitiale.length; i++) {
            if (tableInitiale[i] == null)
                return false;
            if (ensemble.contains(tableInitiale[i]))
                return false;
            ensemble.add(tableInitiale[i]);
        }
        return true;
    }

    @Override
    public int taille() {
        return taille;
    }

    @Override
    public boolean estVide() {
        return taille==0;
    }

    @Override
    public boolean contient(E element) {
        if(element==null)
            throw new IllegalArgumentException();
        //TODO
        return false;

    }


    @Override
    public E donnerNieme(int n) {
        if(n < 1 || n > taille)
            throw new IllegalArgumentException();
        //TODO
        return null;

    }


    @Override
    public E supprimerDernier() {
        //TODO
        return null;

    }

    // A NE PAS MODIFIER !!!
    //ce constructeur sert pour les tests
    //la table passee en parametre peut contenir des null en fin de table
    //apres quelques suppressions, la table contiendra des null en fin de table
    //on voudrait tester les methodes dans cette situation
    public ListeAMImplV1(E[] tableACopier, int taille ){
        table = (E[]) new Object[tableACopier.length];
        for (int i = 0; i < tableACopier.length; i++) {
            table[i]=tableACopier[i];
        }
        this.taille = taille;
    }

}
