/**
 * Classe Suite
 */

public class Suite extends SuiteDeBase {

    // valeur num�rique de MAXELT
    private static final int MAX = Elt.MAXELT.val();

    /** Constructeur vide */
    public Suite() {
        super();
    }

    /** Constructeur par recopie */
    public Suite(SuiteDeBase s) {
        super(s);
    }

    /** Constructeur � partir d'une String */
    public Suite(String st) {
        super(st);
    }

    /** Constructeur � partir d'un Elt et d'une Suite */
    public Suite(Elt t, Suite c) {
        super(t, c);
    }

    /** Construit la Suite r�duite � (x) */
    public Suite(Elt x) {
        this();
        this.ajouter(x);
    }

    public Suite corps() {
        return (Suite) super.corps();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        for (Elt e : this) {
            result = result * prime + e.hashCode();
        }
        return result;
    }


    /** Renvoie la longueur de la Suite courante */
    public int longueur() {
        // TODO
        if (this.estVide()) return 0;
        if (this.corps().estVide()) return 1;
        return 1 + this.corps().longueur();
    }


    /** renvoie TRUE si e a au moins une occurrence dans la Suite courante
     * @throws IllegalArgumentException en cas de param�tre invalide*/
    public boolean contient(Elt e) {
        if (e == null) {
            throw new IllegalArgumentException("L'élément ne peut pas être null");
        }
        if (this.estVide()) {
            return false;
        }
        if (this.tete().equals(e)) {
            return true;
        }
        return this.corps().contient(e);

    }


    /** renvoie le nombre d'occurrences de e dans la Suite courante
     * @throws IllegalArgumentException en cas de param�tre invalide*/
    public int nombreOccur(Elt e) {
        // TODO
        if (e == null) {
            throw new IllegalArgumentException("L'élément ne peut pas être null");
        }
        if (this.estVide()) {
            return 0;
        }
        if (this.tete().equals(e)) {
            return 1 + this.corps().nombreOccur(e);
        }
        return this.corps().nombreOccur(e);
    }


    /** renvoie la position de la premi�re occurrence de e dans la Suite courante ;
     * renvoie 0 si e n'a pas d'occurrence dans la Suite courante
     * @throws IllegalArgumentException en cas de param�tre invalide*/
    public int position(Elt e) {
        // TODO
        if (e == null) {
            throw new IllegalArgumentException("L'élément ne peut pas être null");
        }
        if (this.estVide()) {
            return 0;
        }
        if (this.tete().equals(e)) {
            return 1;
        }
        int posCorps = this.corps().position(e);
        if (posCorps == 0) {
            return 0;
        }
        return 1 + posCorps;
    }


    /** renvoie le i-�me �l�ment de la Suite courante s'il existe ;
     * @throws IllegalArgumentException s'il n'exite pas de i-�me �l�ment*/
    public Elt iEme(int i) {
        if (i < 1) {
            throw new IllegalArgumentException("L'indice doit être >= 1");
        }
        if (this.estVide()) {
            throw new IllegalArgumentException("Pas de " + i + "-ème élément dans une suite vide");
        }
        if (i == 1) {
            return this.tete();
        }
        return this.corps().iEme(i - 1);

    }


    /** renvoie le dernier �l�ment de la Suite courante si elle est non vide,
     * @throws MathException si elle est vide*/
    public Elt dernier() {
        // TODO
        if (this.estVide()) {
            throw new MathException("Impossible d'obtenir le dernier élément d'une suite vide");
        }
        if (this.corps().estVide()) {
            return this.tete();
        }
        return this.corps().dernier();
    }

    @Override
    /** renvoie true si la Suite courante est �gale � s*/
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        Suite suite = (Suite) o;
        // Cas de base : les deux suites sont vides
        if (this.estVide() && suite.estVide()) {
            return true;
        }

        // Si une seule est vide, elles sont différentes
        if (this.estVide() || suite.estVide()) {
            return false;
        }

        // Cas récursif : comparer les têtes et les corps
        return this.tete().equals(suite.tete()) && this.corps().equals(suite.corps());

    }


    /** renvoie true si la Suite courante est un pr�fixe de s
     * @throws IllegalArgumentException en cas de param�tre invalide*/
    public boolean prefixe(Suite s) {
        // TODO
        if (s == null) {
            throw new IllegalArgumentException("La suite ne peut pas être null");
        }

        // Cas de base 1 : une suite vide est préfixe de toute suite
        if (this.estVide()) {
            return true;
        }

        // Cas de base 2 : si s est vide mais this ne l'est pas, this n'est pas préfixe
        if (s.estVide()) {
            return false;
        }

        // Cas récursif : comparer les têtes et vérifier que le corps est préfixe du corps
        return this.tete().equals(s.tete()) && this.corps().prefixe(s.corps());
    }


    /** renvoie true si la Suite courante est une sous-suite de s
     * @throws IllegalArgumentException en cas de param�tre invalide*/
    public boolean sousSuite(Suite s) {
        if (s == null) {
            throw new IllegalArgumentException("La suite ne peut pas être null");
        }

        // Cas de base 1 : une suite vide est sous-suite de toute suite
        if (this.estVide()) {
            return true;
        }

        // Cas de base 2 : si s est vide mais this ne l'est pas, this n'est pas sous-suite
        if (s.estVide()) {
            return false;
        }

        // Cas récursif : soit this est préfixe de s, soit this est sous-suite du corps de s
        return this.prefixe(s) || this.sousSuite(s.corps());

    }


    /** ajoute s à gauche de la Suite courante
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public void ajouter(Suite s) {
        if (s == null) {
            throw new IllegalArgumentException("La suite ne peut pas être null");
        }
        if (s.estVide()) {
            return;
        }
        this.ajouter(s.tete());
        this.ajouter(s.corps());
    }


    /** ajoute s à l'envers et à gauche de la Suite courante
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public void ajouterALEnvers(Suite s) {
        if (s == null) {
            throw new IllegalArgumentException("La suite ne peut pas être null");
        }
        if (s.estVide()) {
            return;
        }
        this.ajouterALEnvers(s.corps());
        this.ajouter(s.tete());
    }


    /** renvoie la Suite courante inversée*/
    public Suite inverse() {
        if (this.estVide()) {
            return new Suite();
        }
        Suite resultat = this.corps().inverse();
        resultat.ajouter(this.tete());
        return resultat;
    }


    /** renvoie une Suite contenant, une et une seule fois, tous les éléments de la Suite courante*/
    public Suite reduite() {
        if (this.estVide()) {
            return new Suite();
        }
        Suite corpsReduit = this.corps().reduite();
        if (corpsReduit.contient(this.tete())) {
            return corpsReduit;
        }
        Suite resultat = new Suite(this.tete(), corpsReduit);
        return resultat;
    }


    /**Renvoie la Suite courante de laquelle on a supprimé tous les éléments à partir du k-ième
     * Si la suite n'a pas k éléments, elle renvoie une copie de la suite.
     * @throws IllegalArgumentException en cas de paramètre invalide
     * */
    public Suite tronquee(int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k doit être >= 1");
        }
        if (this.estVide() || k == 1) {
            return new Suite();
        }
        Suite resultat = this.corps().tronquee(k - 1);
        return new Suite(this.tete(), resultat);
    }


    /** renvoie une copie de la Suite courante dans laquelle on a supprimé la première occurrence (éventuelle) de x
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public Suite moinsPremOcc(Elt x) {
        if (x == null) {
            throw new IllegalArgumentException("L'élément ne peut pas être null");
        }
        if (this.estVide()) {
            return new Suite();
        }
        if (this.tete().equals(x)) {
            return new Suite(this.corps());
        }
        Suite resultat = this.corps().moinsPremOcc(x);
        return new Suite(this.tete(), resultat);
    }


    /** renvoie une copie de la Suite courante dans laquelle on a supprimé toutes les occurrences de x
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public Suite moinsToutesOcc(Elt x) {
        if (x == null) {
            throw new IllegalArgumentException("L'élément ne peut pas être null");
        }
        if (this.estVide()) {
            return new Suite();
        }
        Suite resultat = this.corps().moinsToutesOcc(x);
        if (this.tete().equals(x)) {
            return resultat;
        }
        return new Suite(this.tete(), resultat);
    }


    /** renvoie une Suite constituee de tous les Elt ayant plus d'une occurrence dans la Suite courante */
    public Suite doublons() {
        if (this.estVide()) {
            return new Suite();
        }
        Suite resultat = this.corps().doublons();
        if (this.nombreOccur(this.tete()) > 1 && !resultat.contient(this.tete())) {
            return new Suite(this.tete(), resultat);
        }
        return resultat;
    }

    /** renvoie true ssi la Suite courante contient au moins k Elt distincts
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public boolean auMoinsK(int k) {
        if (k < 0) {
            throw new IllegalArgumentException("k doit être >= 0");
        }
        return this.reduite().longueur() >= k;
    }

    /** renvoie true ssi tous les element de la Suite sont distincts */
    public boolean tousDistincts() {
        if (this.estVide()) {
            return true;
        }
        if (this.corps().contient(this.tete())) {
            return false;
        }
        return this.corps().tousDistincts();
    }

    /** renvoie une copie de la Suite courante dans laquelle toutes les occurrences de x ont été remplacées par y
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public Suite substitut(Elt x, Elt y) {
        if (x == null || y == null) {
            throw new IllegalArgumentException("Les éléments ne peuvent pas être null");
        }
        if (this.estVide()) {
            return new Suite();
        }
        Suite resultat = this.corps().substitut(x, y);
        if (this.tete().equals(x)) {
            return new Suite(y, resultat);
        }
        return new Suite(this.tete(), resultat);
    }

    /** renvoie true si la Suite courante est strictement croissante*/
    public boolean estTriee() {
        if (this.estVide() || this.corps().estVide()) {
            return true;
        }
        // Utilise val() pour comparer les valeurs numériques
        if (this.tete().val() >= this.corps().tete().val()) {
            return false;
        }
        return this.corps().estTriee();
    }

} // class Suite

