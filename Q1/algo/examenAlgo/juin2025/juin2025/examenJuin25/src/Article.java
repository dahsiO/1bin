import java.util.Objects;

public class Article {

    private int numeroArticle;
    private double prix;

    public Article(int numeroArticle, double prix) {
        this.numeroArticle = numeroArticle;
        this.prix = prix;
    }

    public int getNumeroArticle() {
        return numeroArticle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {
        return numeroArticle +" - "+ prix +" euros";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return numeroArticle == article.numeroArticle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroArticle);
    }
}
