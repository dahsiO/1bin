import java.util.ArrayList;
import java.util.HashSet;

public class ListeAMImplV2<E> implements ListeAM<E> {

    private Noeud racine;
    private int taille;

    /**
     * construit une liste initiale
     * @param tableInitiale la table initiale avec les elements de la liste de depart
     * @throws IllegalArgumentException si la table passee en parametre est null, contient des null ou des ex-aequos
     */
    public ListeAMImplV2(E[] tableInitiale) {
        if(!estValide(tableInitiale))
            throw new IllegalArgumentException();
        this.taille = tableInitiale.length;
        if (tableInitiale.length == 0) {
            this.racine = null;
            return;
        }
        this.racine = construire(tableInitiale, 0);
    }

    private Noeud construire(E[] tableInitiale, int i) {
        if (i >= tableInitiale.length) {
            return null;
        }
        return new Noeud(construire(tableInitiale, 2 * i + 1), tableInitiale[i], construire(tableInitiale, 2 * i + 2));
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
        return taille == 0;
    }

    @Override
    public boolean contient(E element) {
        if (element == null)
            throw new IllegalArgumentException();
        //TODO
        return false;

    }

    @Override
    public E donnerNieme(int n) {
        if (n < 1 || n > taille)
            throw new IllegalArgumentException();
        //TODO
        return null;

        // contrainte : suivez l'algorithme propose (cfr enonce)
    }

    @Override
    public E supprimerDernier() {
        //TODO
        return null;

        // contrainte : suivez l'algorithme propose (cfr enonce)
    }

    public class Noeud {

        private E element;
        private Noeud gauche;
        private Noeud droit;

        private Noeud(E element) {
            this.element = element;
            this.gauche = null;
            this.droit = null;
        }

        private Noeud(Noeud gauche, E element, Noeud droit) {
            this.element = element;
            this.gauche = gauche;
            this.droit = droit;
        }
    }

    // A NE PAS MODIFIER!!!
    // VA SERVIR POUR LES TESTS!!!
    public String toString() {
        return "[ " + toString(racine) + " ]";
    }

    private String toString(Noeud n) {
        if (n == null)
            return "";
        if (n.gauche == null && n.droit == null)
            return "" + n.element;
        if (n.gauche == null)
            return " [ ] " + n.element + " [ " + toString(n.droit) + " ] ";
        if (n.droit == null)
            return " [ " + toString(n.gauche) + " ] " + n.element + " [ ] ";
        return " [ " + toString(n.gauche) + " ] " + n.element + " [ " + toString(n.droit) + " ] ";
    }

    /**********************************************
     * Debut du toString de Loic LeCharlier
     **********************************************/
    public String toStringLoic() {
        String arbre = "\n";
        if (racine != null) {
            ArrayList<ArrayList<Object>> niveaux = niveau();
            int nbNiveaux = niveaux.size() - 1;
            int nbBlanc = (int) Math.pow(2, nbNiveaux) - 1;
            arbre = arbre + this.addBlanc(nbBlanc) + racine.element + '\n';
            for (int i = 2; i <= nbNiveaux; i++) {
                ArrayList<Object> niv = niveaux.get(i);
                int nbNoeuds = niv.size();
                int nbBlancInt = 1;
                int nbBlancExt = (int) Math.pow(2, nbNiveaux - i + 3) - 3;
                int nbLignes = (int) Math.pow(2, nbNiveaux - i + 1) - 1;
                for (int k = 0; k < nbLignes; k++) {
                    nbBlanc--;
                    arbre = arbre + addBlanc(nbBlanc);
                    for (int j = 0; j < nbNoeuds / 2; j++) {
                        if (niveaux.get(i - 1).get(j) instanceof String) {
                            arbre = arbre + " " + addBlanc(nbBlancInt) + " ";
                        } else {
                            if (niv.get(2 * j) instanceof String) {
                                arbre = arbre + " ";
                            } else {
                                arbre = arbre + "/";
                            }
                            arbre = arbre + addBlanc(nbBlancInt);
                            if (niv.get(2 * j + 1) instanceof String) {
                                arbre = arbre + " ";
                            } else {
                                arbre = arbre + "\\";
                            }
                        }
                        arbre = arbre + addBlanc(nbBlancExt);
                    }
                    arbre = arbre + '\n';
                    nbBlancInt += 2;
                    nbBlancExt -= 2;
                }
                nbBlanc = (int) Math.pow(2, nbNiveaux - i + 1) - 1;
                arbre = arbre + addBlanc(nbBlanc - 1);
                for (int j = 0; j < nbNoeuds; j++) {
                    if (niv.get(j) instanceof String)
                        arbre = arbre + "   ";
                    else
                        arbre = arbre + format((char) niv.get(j));
                    if (j != nbNoeuds - 1)
                        arbre = arbre + addBlanc((int) Math.pow(2, nbNiveaux - i + 2) - 3);
                }
                arbre = arbre + '\n';
            }
        }
        return arbre;
    }

    private String addBlanc(int n) {
        String st = "";
        for (int i = 0; i < n; i++) {
            st = st + " ";
        }
        return st;
    }

    private String format(int nombre) {
        String st = "" + (char) nombre;
        if (st.length() == 1)
            st = " " + st + " ";
        else if (st.length() == 2)
            st = " " + st;
        return st;
    }

    private ArrayList<ArrayList<Object>> niveau() {
        ArrayList<ArrayList<Object>> niveaux = new ArrayList<ArrayList<Object>>();
        niveaux.add(null);
        niveau(racine, 1, niveaux);
        int nbNiveaux = niveaux.size();
        ArrayList<Object> liste = niveaux.get(nbNiveaux - 1);
        int taille = liste.size();
        boolean vide = true;
        int ni = 0;
        while (ni < taille && vide) {
            vide = liste.get(ni) instanceof String;
            ni++;
        }
        if (vide) {
            niveaux.remove(nbNiveaux - 1);
        }
        nbNiveaux = niveaux.size();
        for (int i = 3; i < nbNiveaux; i++) {
            ArrayList<Object> listep = niveaux.get(i - 1);
            liste = niveaux.get(i);
            int lo = listep.size();
            for (int j = 0; j < lo; j++) {
                if (listep.get(j) instanceof String) {
                    liste.add(2 * j, "null");
                    liste.add(2 * j, "null");
                }
            }
        }

        return niveaux;
    }

    private void niveau(Noeud noeud, int hauteur, ArrayList<ArrayList<Object>> niveaux) {
        if (niveaux.size() <= hauteur)
            niveaux.add(new ArrayList<Object>());
        niveaux.get(hauteur).add(noeud.element);
        if (noeud.gauche != null) {
            niveau(noeud.gauche, hauteur + 1, niveaux);
            if (noeud.droit == null) {
                if (niveaux.size() <= hauteur + 1)
                    niveaux.add(new ArrayList<Object>());
                niveaux.get(hauteur + 1).add("null");
            } else {
                niveau(noeud.droit, hauteur + 1, niveaux);
            }
        } else if (noeud.droit != null) {
            if (noeud.gauche == null) {
                if (niveaux.size() <= hauteur + 1)
                    niveaux.add(new ArrayList<Object>());
                niveaux.get(hauteur + 1).add("null");
            }
            niveau(noeud.droit, hauteur + 1, niveaux);
        } else {
            if (niveaux.size() <= hauteur + 1)
                niveaux.add(new ArrayList<Object>());
            niveaux.get(hauteur + 1).add("null");
            niveaux.get(hauteur + 1).add("null");
        }
    }

    /*************************************************
     * Fin du toString de Loic LeCharlier
     **********************************************/
}
