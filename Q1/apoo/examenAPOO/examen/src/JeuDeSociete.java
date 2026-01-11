public class JeuDeSociete extends Jeu{
    private String reglesDuJeu;
    private boolean plateau;

    public JeuDeSociete(String nom, int nbJoueurs, String regleDuJeu, boolean plateau) {
        super(nom, nbJoueurs);
        this.reglesDuJeu = regleDuJeu;
        this.plateau = plateau;
    }

    public String getReglesDuJeu() {
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
