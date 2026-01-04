/**
 * Chaque méthode est documentée avec son cas de base et son cas récursif.
 */

public final class Recursivite {

    /**
     * Factorielle de n (n!)
     * Cas de base : 0! = 1.
     * Cas récursif : n! = n * (n-1)!
     *
     * @param n entier
     * @throws IllegalArgumentException si n < 0 ou si n > 10
     */
    public static int factorielle(int n) {
        if (n < 0) throw new IllegalArgumentException("n ne peut pas être négatif");
        if (n > 10) throw new IllegalArgumentException("n trop grand (max 10)");

        if (n == 0) return 1; // base
        return n * factorielle(n-1); // récursif
    }


    /**
     * Algorithme d'Euclide.
     * Cas de base : b égal à 0
     * Cas récursif : pgcd(a,b) = pgcd(b,a%b).
     *
     * @param a entier
     * @param b entier
     */
    public static int pgcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) return a;         // base
        return pgcd(b, a % b);      // récursif : (a, b) -> (b, a mod b)
    }

    /**
     * Somme des n premiers nombres impairs.
     * Cas de base : S(0) = 0.
     * Cas récursif : S(n) = S(n-1) + (2n - 1).
     *
     * @param n entier
     * @throws IllegalArgumentException si n < 0
     */
    public static int sommePremiersImpairs(int n) {
        if (n < 0) throw new IllegalArgumentException("n ne peut pas être négatif");
        if (n == 0) return 0; // base
        return sommePremiersImpairs(n-1) + 2*n-1; // récursif
    }

    /**
     * Nombre triangulaire T(n) = 1 + 2 + ... + n.
     * Cas de base : T(0) = 0.
     * Cas récursif : T(n) = T(n-1) + n.
     *
     * @param n entier
     * @throws IllegalArgumentException si n < 0
     */
    public static int nEmeNombreTriangulaire(int n) {
        if (n < 0) throw new IllegalArgumentException("n ne peut pas être négatif");
        if (n == 0) return 0; // base
        return nEmeNombreTriangulaire(n - 1) + n; // récursif
    }

    /**
     * Fibonacci naïf : F(0)=0, F(1)=1, F(n)=F(n-1)+F(n-2).
     * Complexité exponentielle (2^n) -> réservé aux petits n.
     *
     * @param n entier >= 0
     * @throws IllegalArgumentException si n < 0 ou si n > 10
     */
    public static int fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n ne peut pas être négatif");
        if (n > 10) throw new IllegalArgumentException("n trop grand (max 10)");
        if (n == 0) return 0; // base
        if (n == 1) return 1; // base
        return fibonacci(n-1) + fibonacci(n - 2); // récursif
    }


    /**
     * Somme récursive des éléments d'un tableau d'entiers.
     * Cas de base : tableau vide -> 0.
     * Cas récursif : sum(a[0..n]) = a[n] + sum(a[0..n-1]).
     *
     * @param a table d'entiers
     * @throws IllegalArgumentException si a == null
     */
    public static int sommeTableau(int[] a) {
        if (a == null) throw new IllegalArgumentException("tableau null");
        int longeur = a.length;
        return sommeTableau(a, longeur-1);
    }

    private static int sommeTableau(int[] a, int i) {
        if (i < 0) return 0; // base (tableau vide)
        return a[i] + sommeTableau(a, i - 1); // récursif
    }

    /**
     * Puissance a^n par exponentiation rapide.
     * Cas de base : a^0 = 1.
     * Cas récursif :
     * - si n pair, a^n = (a^{n/2})^2
     * - si n impair, a^n = a * a^{n-1}
     *
     * @param a base
     * @param n exposant
     * @throws IllegalArgumentException si n < 0
     */
    public static int puissance(int a, int n) {
        if (n < 0) throw new IllegalArgumentException("l'exposant n doit être >= 0");
        if (n == 0) return 1;
        if (n % 2 == 0) {
            int x = puissance(a, n / 2);
            return x * x;
        } else {
            return a * puissance(a, n-1);
        }
    }


    /**
     * Test récursif de primalité par division jusqu'à sqrt(n).
     * Cas de base : n < 2 -> faux ; d * d > n -> vrai ; n % d == 0 -> faux.
     *
     * @param n entier
     * @throws IllegalArgumentException si n < 0
     */
    public static boolean estPremier(int n) {
        if (n < 0) throw new IllegalArgumentException("n doit être >= 0");
        if (n < 2) return false;
        return estPremier(n, 2);
    }

    private static boolean estPremier(int n, int d) {
        if (d * d > n) return true;   // aucun diviseur d > sqrt(n)
        if (n % d == 0) return false;        // diviseur trouvé
        return estPremier(n, d + 1);       // tester l'entier suivant
    }

}
