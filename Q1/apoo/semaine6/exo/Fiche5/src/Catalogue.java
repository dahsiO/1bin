import java.util.ArrayList;

public class Catalogue {
    private ArrayList<Livre> livres;

    // Constructeur sans paramètre
    public Catalogue() {
        this.livres = new ArrayList<>();
    }

    // toString
    @Override
    public String toString() {
        if (livres.isEmpty()) {
            return "Catalogue vide.";
        }
        StringBuilder sb = new StringBuilder("Catalogue:\n");
        for (Livre livre : livres) {
            sb.append(livre.toString()).append("\n");
        }
        return sb.toString();
    }

    // Vérifier si un livre est présent (par ISBN)
    public boolean contientLivre(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                return true;
            }
        }
        return false;
    }

    // Ajouter un livre (si non présent)
    public boolean ajouterLivre(Livre livre) {
        if (!contientLivre(livre.getIsbn())) {
            livres.add(livre);
            return true;
        }
        return false;
    }

    // Retirer un livre par ISBN
    public boolean retirerLivre(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                livres.remove(livre);
                return true;
            }
        }
        return false;
    }

    // Nombre de livres
    public int nombreLivres() {
        return livres.size();
    }

    // Est vide ?
    public boolean estVide() {
        return livres.isEmpty();
    }

    // Récupérer un livre par ISBN
    public Livre getLivre(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                return livre;
            }
        }
        return null;
    }
}