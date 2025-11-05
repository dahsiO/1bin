public class Auteur {
    private String nom;
    private String prenom;
    private String email;
    private String biographie;
    private Livre bestseller;

    public Auteur(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.biographie = null;
        this.bestseller = null;
    }

    // Méthodes
    public void setBiographie(String biographie) {
        this.biographie = biographie;
    }

    public boolean enregistrerBestseller(Livre livre) {
        if (livre == null) return false;
        if (livre.getAuteur() != this) return false;
        if (!livre.isAccepte()) return false;
        this.bestseller = livre;
        return true;
    }

    // Getters
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
    public String getBiographie() { return biographie; }
    public Livre getBestseller() { return bestseller; }

    @Override
    public String toString() {
        String texte = prenom + " " + nom;
        if (biographie != null) texte += "\nBiographie : " + biographie;
        if (bestseller != null) texte += "\nBestseller : " + bestseller.getTitre();
        return texte;
    }
}
