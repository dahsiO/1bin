public class Vin extends BoissonAlcoolisee{
    private String cepage;
    private String couleur;
    private String regions;
    private String pays ;

    public Vin(String nom, int contenence, double prix, double degreeAlcool, String cepage, String couleur, String regions, String pays) {
        super(nom, contenence, prix, degreeAlcool);
        this.cepage = cepage;
        this.couleur = couleur;
        this.regions = regions;
        this.pays = pays;
    }

    public String getCepage() {
        return cepage;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getRegions() {
        return regions;
    }

    public String getPays() {
        return pays;
    }

    @Override
    public String toString() {
        return "Vin{" +
                "cepage='" + cepage + '\'' +
                ", couleur='" + couleur + '\'' +
                ", regions='" + regions + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }
}
