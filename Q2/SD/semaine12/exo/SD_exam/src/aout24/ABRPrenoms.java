package aout24;

import java.util.ArrayList;

public class ABRPrenoms {

    private Noeud racine;

    /**
     * calcule le nombre d'enfants
     * @return le nombre d'enfants
     */
    public int nombreEnfants(){
        //TODO
        //contrainte : implementation recursive
        return nombreEnfants(racine);

    }
    private int nombreEnfants(Noeud noeud){
        if (noeud == null){
            return 0;
        }
        return noeud.nombreOccurrences + nombreEnfants(noeud.gauche) + nombreEnfants(noeud.droit);
    }

    /**
     * verifie la presence d'au moins un enfant qui porte le prenom passe en parametre
     * @param prenom le prenom recherche
     * @return true s'il y a au moins un enfant qui porte ce prenom, false sinon
     */
    public boolean contient(String prenom){
        if(prenom==null||prenom.length()==0)
            throw new IllegalArgumentException();
        //TODO
        //contrainte : implementation recursive
        return contient(racine , prenom);

    }
    private boolean contient(Noeud noeud, String prenom){
        if (noeud == null) {
            return false;// fin de parcourt ou vide
        }
        if (noeud.prenom.equals(prenom)) {
            return true; // trouver bingo
        }

        return contient(noeud.gauche,prenom) || contient(noeud.droit,prenom);
    }

    /**
     * construit une liste de type ArrayList avec les prenoms des enfants
     * Cette liste doit contenir autant de prenoms qu�il y a d�occurrences
     * Cette liste doit etre triee selon l'ordre alphabetique
     * @return une liste avec les prenoms des enfants
     */
    public ArrayList toArrayList(){
        //TODO
        ArrayList<String> liste = new ArrayList<>();
        remplir(racine, liste);
        return liste;
    }
        //contrainte : implementation recursive

        //contrainte : pour que cette liste respecte l'ordre alphabetique,
        //vous devez parcourir l'arbre selon un bon ordre.
        //Vous ne pouvez pas passer par une methode de tri
    private void remplir(Noeud noeud,ArrayList<String>list){
        if (noeud == null) {
            return;
        }  
        remplir(noeud.gauche,list);
        for (int i = 0; i < noeud.nombreOccurrences; i++) {
            list.add(noeud.prenom);
        }
        remplir(noeud.droit,list);
    }

    // classe interne
    private class Noeud {

        private String prenom;
        private int nombreOccurrences;
        private Noeud gauche;
        private Noeud droit;

        private Noeud(Noeud gauche, String prenom, int nombreOccurrences,
                      Noeud droit) {
            if(prenom==null||prenom.length()==0)
                throw new IllegalArgumentException();
            if(nombreOccurrences<1)
                throw new IllegalArgumentException();
            this.prenom = prenom;
            this.nombreOccurrences = nombreOccurrences;
            this.gauche = gauche;
            this.droit = droit;
        }

        private Noeud(String prenom, int nombreOccurrences) {
            this(null, prenom, nombreOccurrences, null);
        }
    }

    // A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
    public ABRPrenoms(int i) {
        if(i==1){
            Noeud g2 = new Noeud(new Noeud("marie", 1), "sam", 1, new Noeud("tim", 1));
            Noeud d1 = new Noeud(g2, "zoe", 1, null);
            racine = new Noeud(new Noeud("anouk",1), "lea", 1, d1);
        }else {
            if(i==2){
                Noeud g2 = new Noeud(new Noeud("marie", 2), "sam", 1, new Noeud("tim", 1));
                Noeud d1 = new Noeud(g2, "zoe", 1, null);
                racine = new Noeud(new Noeud("anouk",1), "lea", 1, d1);
            }else {
                if (i==3) {
                    Noeud g1 = new Noeud(null, "anouk", 1, new Noeud("hugo", 2));
                    Noeud g2 = new Noeud(new Noeud("marie", 3), "sam", 1, new Noeud("tim", 1));
                    Noeud d1 = new Noeud(g2, "zoe", 2, null);
                    racine = new Noeud(g1, "lea", 1, d1);
                } else {
                    racine = null;
                }
            }
        }
    }


}
