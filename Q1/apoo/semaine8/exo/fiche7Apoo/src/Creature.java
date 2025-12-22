/**
 * Classe représentant une créature dans le jeu Mag... IPL !
 * Une créature possède un nom, des points de dégâts et des points de vie
 */
public class Creature extends CarteDeJeu {
    // Constantes de classe
    public static final int PTS_DE_VIE_PAR_DEFAUT = 0;
    public static final int PTS_DE_DEGAT_PAR_DEFAUT = 0;

    // Attributs d'instance
    private String nom;
    private int pointsDeDegat;
    private int pointsDeVie;

    /**
     * Constructeur avec coût et nom uniquement
     * Les points de dégâts et de vie sont mis à 0 par défaut
     * @param cout le coût de la créature
     * @param nom le nom de la créature
     */
    public Creature(int cout, String nom) {
        super(cout);
        this.nom = nom;
        this.pointsDeDegat = PTS_DE_DEGAT_PAR_DEFAUT;
        this.pointsDeVie = PTS_DE_VIE_PAR_DEFAUT;
    }

    /**
     * Constructeur avec tous les attributs
     * Si les points de dégâts ou de vie sont <= 0, on utilise les valeurs par défaut (0)
     * @param cout le coût de la créature
     * @param nom le nom de la créature
     * @param pointsDeDegat les points de dégâts (doit être > 0)
     * @param pointsDeVie les points de vie (doit être > 0)
     */
    public Creature(int cout, String nom, int pointsDeDegat, int pointsDeVie) {
        super(cout);
        this.nom = nom;

        // Validation : les points doivent être strictement positifs
        if (pointsDeDegat > 0 && pointsDeVie > 0) {
            this.pointsDeDegat = pointsDeDegat;
            this.pointsDeVie = pointsDeVie;
        } else {
            // Si invalides, on met les valeurs par défaut
            this.pointsDeDegat = PTS_DE_DEGAT_PAR_DEFAUT;
            this.pointsDeVie = PTS_DE_VIE_PAR_DEFAUT;
        }
    }

    /**
     * Accesseur pour le nom
     * @return le nom de la créature
     */
    public String getNom() {
        return nom;
    }

    /**
     * Accesseur pour les points de dégâts
     * @return les points de dégâts
     */
    public int getPointsDeDegat() {
        return pointsDeDegat;
    }

    /**
     * Accesseur pour les points de vie
     * @return les points de vie
     */
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    /**
     * Fournit les détails de la créature
     * @return une chaîne de caractères au format "Créature - coût : X nom : Nom(dégâts/vie)"
     */
    @Override
    public String fournirDetail() {
        return "Créature - coût : " + getCout() + " nom : " + nom +
                "(" + pointsDeDegat + "/" + pointsDeVie + ")";
    }
}