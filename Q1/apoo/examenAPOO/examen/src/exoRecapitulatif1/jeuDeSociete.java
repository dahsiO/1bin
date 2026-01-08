package exoRecapitulatif1;

public class jeuDeSociete extends Jeu {
    private String reglesDuJeu;
    private boolean plateau;

    public jeuDeSociete(String nom, int nbJoueurs, String reglesDuJeu, boolean plateau) {
        super(nom, nbJoueurs);
        this.reglesDuJeu = reglesDuJeu;
        this.plateau = plateau;
       }

    public String getRegleDuJeu() {
        return reglesDuJeu;
    }

    public boolean isPlateau() {
        return plateau;
    }


    @Override
    public String toString() {
        String jeuDeSociete = "Jeu " ;
        if (this.plateau)
            jeuDeSociete = jeuDeSociete+"de plateau " ;
        else
            jeuDeSociete = jeuDeSociete+"de société " ;
        jeuDeSociete = jeuDeSociete+ super.toString() +" dont les règles sont" + '\n'+ reglesDuJeu ;
        return jeuDeSociete ;
    }


}
