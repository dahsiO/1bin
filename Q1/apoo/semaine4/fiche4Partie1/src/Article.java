public class Article {
    // Attributs
    private String reference;
    private String nom;
    private String description;
    private double prixHT;
    private double tauxTVA;

    // Taux de TVA par défaut
    private static final double TVA_DEFAUT = 21.0;

    // Constructeur complet
    public Article(String reference, String nom, String description, double prixHT, double tauxTVA) {
        this.reference = reference;
        this.nom = nom;
        this.description = description;
        this.prixHT = prixHT;
        this.tauxTVA = tauxTVA;
    }

    // Constructeur sans taux de TVA (valeur par défaut = 21%)
    public Article(String reference, String nom, String description, double prixHT) {
        this(reference, nom, description, prixHT, TVA_DEFAUT);
    }

    // Getters
    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrixHT() {
        return prixHT;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    // Méthode : calcul du prix TVA comprise
    public double calculerPrixTVAComprise() {
        return prixHT * (1 + tauxTVA / 100);
    }

    // Surcharge : calcul du prix TVA comprise avec réduction
    public double calculerPrixTVAComprise(int reductionPourcent) {
        if (reductionPourcent < 0 || reductionPourcent > 100) {
            throw new IllegalArgumentException("La réduction doit être comprise entre 0 et 100%");
        }
        double prixAvecTVA = calculerPrixTVAComprise();
        return prixAvecTVA * (1 - reductionPourcent / 100.0);
    }

    // Méthode toString : affiche nom et référence
    @Override
    public String toString() {
        return "Article [Référence=" + reference + ", Nom=" + nom + "]";
    }
}
