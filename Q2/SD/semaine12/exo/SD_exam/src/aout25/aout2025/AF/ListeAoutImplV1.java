package aout25.aout2025.AF;

import java.util.ArrayList;
import java.util.HashSet;

public class ListeAoutImplV1<E> implements ListeAout<E> {

    private ArrayList<E> arrayList;

    /**
     * construit une liste initiale
     * @param tableInitiale la arrayList initiale avec les elements de la liste de depart
     * @throws IllegalArgumentException si la arrayList passee en parametre est null, contient des null ou des ex-aequos
     */
    public ListeAoutImplV1(E[] tableInitiale ){
        if(!estValide(tableInitiale))
            throw new IllegalArgumentException();
        arrayList = new ArrayList<>();
        for (int i = 0; i < tableInitiale.length; i++) {
            arrayList.add(tableInitiale[i]);
        }
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
        }
        return true;
    }

    @Override
    public int taille() {
        return arrayList.size();
    }

    @Override
    public boolean estVide() {
        return arrayList.isEmpty();
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
        if(n < 1 || n > taille())
            throw new IllegalArgumentException();
        //TODO
        return null;
    }


    @Override
    public E supprimerDernier() {
        //TODO
        return null;
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public String toString(){
        return arrayList.toString();
    }

}
