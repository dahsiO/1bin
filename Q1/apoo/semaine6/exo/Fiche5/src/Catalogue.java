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

    // Vérifier si un livre est présent
    public boolean contientLivre(Livre livre) {
        return livres.contains(livre);
    }

    // Ajouter un livre (si non présent)
    public boolean ajouter(Livre livre) {
        if (!contientLivre(livre)) {
            livres.add(livre);
            return true;
        }
        return false;
    }

    // Retirer un livre
    public boolean retirer(Livre livre) {
        if (contientLivre(livre)) {
            livres.remove(livre);
            return true;
        }
        return false;
    }

    // Nombre de livres
    public int nombreDeLivres() {
        return livres.size();
    }

    // Est vide ?
    public boolean estVide() {
        return livres.isEmpty();
    }

    // Récupérer un livre par ISBN
    public Livre recupererLivre(String isbn) {
        for (Livre livre : livres) {
            if (livre.getIsbn().equals(isbn)) {
                return livre;
            }
        }
        return null;
    }
}