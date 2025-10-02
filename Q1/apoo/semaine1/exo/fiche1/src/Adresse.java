public class Adresse {
    String rue;
    String numero;
    String codePostale;
    String ville;

    public Adresse(String rue, String numero, String codePostale, String ville) {
        this.rue = rue;
        this.numero = numero;
        this.codePostale = codePostale;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" + rue +  numero + '\'' + codePostale + '\'' + ville + '\'' +
                '}';
    }
}
