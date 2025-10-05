public class Serie {
    private char nom;
    private Etudiant delegue;

    public Serie(char nom) {
        this.nom = nom;
        this.delegue = null;
    }

    public char getNom() {
        return nom;
    }

    public Etudiant getDelegue() {
        return delegue;
    }
    //setter modifier la serie
    public boolean elireDelegue(Etudiant delegue){
        if (delegue == null){
            return false;
        }
        if (this.delegue.getSerie() != this){
            return false;
        }
        if (this.delegue != null){
            return false;
        }
        this.delegue = delegue;
        return true;
    }


    @Override
    public String toString() {
        return "Serie{" +
                "nom=" + nom +
                ", delegue=" + delegue +
                '}';
    }
}
