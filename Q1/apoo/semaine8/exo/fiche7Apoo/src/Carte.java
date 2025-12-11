import java.util.ArrayList;

public class Carte {
    private ArrayList<Boisson> boissons;

    public Carte() {
        this.boissons = new ArrayList<>();
    }

    public boolean ajouter(Boisson boisson) {
        if (boissons.contains(boisson)) {  // Vérifie les doublons avec equals()
            return false;  // Boisson déjà présente
        }
        boissons.add(boisson);
        return true;  // Ajout réussi
    }

    public boolean retirer(Boisson boisson) {
        return boissons.remove(boisson);  // Retourne true si supprimé, false sinon
    }

    public boolean contient(Boisson boisson) {
        return boissons.contains(boisson);
    }

    public int nombreDeBoissons() {
        return boissons.size();
    }

    @Override
    public String toString() {
        if (boissons.isEmpty()) {
            return "La carte est vide.";
        }

        String resultat = "Carte des boissons :\n";
        for (Boisson b : boissons) {
            resultat += b.toString() + "\n";
        }
        return resultat;
    }
}