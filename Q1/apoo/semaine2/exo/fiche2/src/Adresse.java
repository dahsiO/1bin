public class Adresse {
    String rue;
    String numero;
    String codePostal;
    String ville;

    public Adresse(String rue, String numero, String codePostale, String ville) {
        this.rue = rue;
        this.numero = numero;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public String getNumero() {
        return numero;
    }

    public String getCodePostale() {
        return codePostal;
    }

    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
         return rue + " " + numero + ", " + codePostal + " " + ville;
    }
}
