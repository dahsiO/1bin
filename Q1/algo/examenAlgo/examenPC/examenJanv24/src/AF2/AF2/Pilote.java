package AF2.AF2;

public class Pilote {

    private String nom;
    private int meilleurTemps;
    private int nombreEssais;

    public Pilote(String nom, int meilleurTemps, int nombreEssais) {
        this.nom = nom;
        this.meilleurTemps = meilleurTemps;
        this.nombreEssais = nombreEssais;
    }

    public String getNom() {
        return nom;
    }

    public int getMeilleurTemps() {
        return meilleurTemps;
    }

    public int getNombreEssais() {
        return nombreEssais;
    }

    public void setMeilleurTemps(int meilleurTemps) {
        this.meilleurTemps = meilleurTemps;
    }

    public void ajouter1Essai() {
        this.nombreEssais++;
    }

    @Override
    public String toString() {
        return nom + " : " + meilleurTemps + "("+ nombreEssais +")";
    }


}
