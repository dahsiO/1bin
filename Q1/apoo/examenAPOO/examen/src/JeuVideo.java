public class JeuVideo extends Jeu{
    private static final String[] CONSOLE_EXISTANTES = {"Switch","Wii","OS","XBOX","PC"};
    public static final int NB_JOUEURS_PAR_DEFAUT = 1;
    private String console;
    private int ageMin;

    public JeuVideo(String nom, int nbJoueurs, String console, int ageMin) {
        super(nom, nbJoueurs);
        boolean consoleValide = false;
        for (String c : CONSOLE_EXISTANTES) {
            if (console.equals(c)){
                consoleValide = true;
                break;
            }
        }
        if (!consoleValide){
            throw new IllegalArgumentException(console + "n est pas une console valide");
        }
        this.console = console;
        this.ageMin = ageMin;
    }

    public JeuVideo(String nom, String console, int ageMin) {
        this(nom, NB_JOUEURS_PAR_DEFAUT, console, ageMin);
    }

    public String getConsole() {
        return console;
    }

    public int getAgeMin() {
        return ageMin;
    }
    @Override
    public String toString() {
        return "Jeu vidéo " + super.toString()+ " sur " + console + " pour un age minimum de " + ageMin + " ans" ;
    }
}


