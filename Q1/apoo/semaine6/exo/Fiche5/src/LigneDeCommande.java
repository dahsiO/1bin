
public class LigneDeCommande {
    private Article article;
    private int quantite;

    // Constructeur avec article (quantité = 1 par défaut)
    public LigneDeCommande(Article article) {
        this.article = article;
        this.quantite = 1;
    }

    // Constructeur avec article et quantité
    public LigneDeCommande(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Prix total de la ligne (TVAC)
    public double calculerPrixLigne() {
        return article.calculerPrixTVAComprise() * quantite;
    }

    @Override
    public String toString() {
        return quantite + " x " + article.toString() + " = " + calculerPrixLigne() + " €";
    }
}
