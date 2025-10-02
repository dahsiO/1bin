
public class Livres {
    String ISBN;
    String titre;
    String nom;
    String prenom;
    double prix;
    String anneeEdition;
    int nbPages;

    public Livres(String ISBN, String titre, String nom, String prenom, double prix, String anneeEdition, int nbPages) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.nom = nom;
        this.prenom = prenom;
        this.prix = prix;
        this.anneeEdition = anneeEdition;
        this.nbPages = nbPages;
    }

    @Override
    public String toString() {
        return "Livres{" +
                "ISBN='" + ISBN + '\'' +
                ", titre='" + titre + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", prix=" + prix +
                ", anneeEdition=" + anneeEdition +
                ", nbPages=" + nbPages +
                '}';
    }
}

