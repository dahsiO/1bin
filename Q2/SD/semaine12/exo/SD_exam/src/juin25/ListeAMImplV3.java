package juin25;

import java.util.HashSet;

public class ListeAMImplV3<E> implements ListeAM<E> {

    private Noeud teteS, queueS; //sentinelles de tete et de queue
    private HashSet<E> ensembleElementsPresents;

    /**
     * construit une liste initiale
     * @param tableInitiale la table initiale avec les elements de la liste de depart
     * @throws IllegalArgumentException si la table passee en parametre est null, contient des null ou des ex-aequos
     */
    ListeAMImplV3(E[] tableInitiale) {
        if(!estValide(tableInitiale))
            throw new IllegalArgumentException();
        ensembleElementsPresents = new HashSet<>();
        teteS = new Noeud();   // sentinelle de tete
        queueS = new Noeud();  // sentinelle de queue
        Noeud prec = teteS;
        for (int i = 0; i < tableInitiale.length; i++) {
            Noeud nouveauNoeud = new Noeud(tableInitiale[i]);
            nouveauNoeud.precedent = prec;
            prec.suivant = nouveauNoeud;
            prec = nouveauNoeud;
            ensembleElementsPresents.add(tableInitiale[i]);
        }
        prec.suivant = queueS;
        queueS.precedent = prec;
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
        return ensembleElementsPresents.size();
    }

    @Override
    public boolean estVide() {
        return taille()==0;
    }

    @Override
    public boolean contient(E element) {
        if(element==null)
            throw new IllegalArgumentException();
        //TODO
        if (ensembleElementsPresents.contains(element))return true;
        return false;

    }

    @Override
    public E donnerNieme(int n) {
        if(n < 1 || n > taille())
            throw new IllegalArgumentException();
        //TODO
        //une torpie
        Noeud torpie = teteS.suivant;
        for (int i = 0; i < n-1; i++) {
            torpie = torpie.suivant;
        }
        return torpie.element;

    }

    @Override
    public E supprimerDernier() {
        //TODO
        if (estVide()) return null;            // ou throw, selon ta convention

        Noeud noeud = queueS.precedent;        // dernier vrai nœud
        noeud.precedent.suivant = noeud.suivant;   // le précédent pointe vers queueS
        noeud.suivant.precedent = noeud.precedent; // queueS pointe vers le précédent

        ensembleElementsPresents.remove(noeud.element);
        return noeud.element;
    }


    // Classe interne Noeud
    private class Noeud{
        private E element;
        private Noeud suivant;
        private Noeud precedent;

        private Noeud() {
            this(null, null, null);
        }

        private Noeud(E element) {
            this(null, element, null);
        }

        private Noeud(Noeud precedent, E element, Noeud suivant) {
            this.element = element;
            this.suivant = suivant;
            this.precedent = precedent;
        }
    }

    // pour les tests
    public String teteQueue(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = teteS.suivant;
            int cpt=0;
            while (baladeur != queueS) {
                if(cpt==0)
                    aRenvoyer += baladeur.element;
                else
                    aRenvoyer += ","+baladeur.element;
                baladeur = baladeur.suivant;
                cpt++;
                if(cpt==100){
                    return "boucle infinie";
                }
            }
            return aRenvoyer+")";
        }catch (NullPointerException e){
            return "nullPointerException";
        }
    }

    // pour les tests
    public String queueTete(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = queueS.precedent;
            int cpt=0;
            while (baladeur != teteS) {
                if(cpt==0)
                    aRenvoyer += baladeur.element;
                else
                    aRenvoyer += ","+baladeur.element;
                baladeur = baladeur.precedent;
                cpt++;
                if(cpt==100){
                    return "boucle infinie";
                }
            }
            return aRenvoyer+")";
        }catch (NullPointerException e){
            return "nullPointerException";
        }
    }

}
