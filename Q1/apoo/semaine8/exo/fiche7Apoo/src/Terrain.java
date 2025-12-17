public class Terrain extends CarteDeJeu{
    private char couleur;
    public static final char [] COULEUR = {'B','b','r','v'};
    public static final int COUT_PAR_DEFAUT = 0;
    public static final char COULEUR_PARDEFAUT = 'i';


    public Terrain(int cout, char couleur) {
        super(cout);
        for (int i = 0; i < COULEUR.length; i++) {
            if (COULEUR[i] != couleur)
               this.couleur = COULEUR_PARDEFAUT;
        }
        this.couleur = couleur;
    }
    public char getCouleur() {
        return couleur;
    }


    @Override
    public String fournirDetail() {
        return super.fournirDetail() + "Terrain : " + couleur;
    }
}
