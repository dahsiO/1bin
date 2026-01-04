/**
 * Classe Elt
 * Classe d'objets dont les "valeurs" sont 1,2,3,...,MAXELT,
 *
 * @author M.Marchand
 * @version Mars 2008
 */

public class Elt {

    /**
     * valeur numérique de MAXELT
     */
    private static final int MAXELTVALUE = 50;
    public static final Elt MAXELT = new Elt(MAXELTVALUE);
    private int val;

    /**
     * constructeur par recopie
     */
    public Elt(Elt e) {
        if (e == null) throw new IllegalArgumentException();
        this.val = e.val();
    }

    /**
     * constructeur à partir d'un int n;
     * génère une (runtime) exception si n est hors Univers
     */
    public Elt(int n) {
        if (n > MAXELTVALUE || n < 1) {
            throw new IllegalArgumentException("Hors Univers : " + n + " (1.." + MAXELTVALUE + ")");
        }
        this.val = n;
    }

    /**
     * renvoie la valeur numérique
     */
    public int val() {
        return this.val;
    }

    public String toString() {
        return "" + this.val();
    }


    @Override
    public int hashCode() {
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Elt other = (Elt) obj;
        if (val != other.val)
            return false;
        return true;
    }

} // class