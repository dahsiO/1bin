public class jeuVideo extends Jeu {
    private static final String[] CONSOLE_EXISTANTES = {"Switch","Wii","OS","XBOX","PC"};
    public static final int NB_JOUEURS_PAR_DEFAUT = 1;
    private String console;
    private int ageMin;

    public jeuVideo(String nom, int nbJoueurs, String console, int ageMin) {
        super(nom, nbJoueurs);
        boolean consoleValide= false;
        for (String consoleExistante : CONSOLE_EXISTANTES) {
            if (consoleExistante.equals(console)) {
                consoleValide = true;
            }
        }
        if (!consoleValide){
            throw new IllegalArgumentException(console+"n est pas une console valdie");
        }else this.console = console;

        this.ageMin = ageMin;

    }
    // rajouter un second constructeur dans une classs qui heriote c est speciale
    public jeuVideo(String nom, String console, int ageMin) {
        this(nom,NB_JOUEURS_PAR_DEFAUT,console,ageMin);
    }


    public String getConsole() {
        return console;
    }

    public int getAgeMin() {
        return ageMin;
    }
    @Override
    public String toString() {
        return "Jeu vidéo " + super.toString() + " sur " + console + " pour un age minimum de " + ageMin + " ans" ;
    }
}
