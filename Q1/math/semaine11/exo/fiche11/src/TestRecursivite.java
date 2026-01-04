import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Tests pour la classe Recursivite.
 */

public class TestRecursivite {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String[] NOMS_METHODE = {
            "factorielle",
            "pgcd",
            "sommePremiersImpairs",
            "nEmeNombreTriangulaire",
            "fibonacci",
            "sommeTableau",
            "puissance",
            "estPremier",
            "tester toutes les méthodes"
    };

    public static void main(String[] args) {
        System.out.println("***************************************************");
        System.out.println("   Programme de tests (avec feedback) — Recursivite ");
        System.out.println("***************************************************");
        while (true) {
            System.out.println();
            for (int i = 0; i < NOMS_METHODE.length; i++) {
                System.out.printf("%2d -> Tester '%s'%n", (i + 1), NOMS_METHODE[i]);
            }
            System.out.println(" 0 -> Quitter");
            System.out.print("Votre choix : ");
            int choix = lireEntier();
            if (choix == 0) return;

            boolean ok;
            switch (choix) {
                case 1:  ok = testFactorielle(); break;
                case 2:  ok = testPgcd(); break;
                case 3:  ok = testSommePremiersImpairs(); break;
                case 4:  ok = testNEmeNombreTriangulaire(); break;
                case 5:  ok = testFibonacci(); break;
                case 6:  ok = testSommeTableau(); break;
                case 7:  ok = testPuissance(); break;
                case 8:  ok = testEstPremier(); break;
                case 9:
                    ok = testFactorielle() & testPgcd() & testSommePremiersImpairs()
                            & testNEmeNombreTriangulaire() & testFibonacci()
                            & testSommeTableau() & testPuissance() & testEstPremier();
                    break;
                default:
                    System.out.println("Choix inconnu, arrêt.");
                    return;
            }

            System.out.println();
            if (ok) {
                System.out.println("✅ Tous les contrôles pour '" + NOMS_METHODE[choix - 1] + "' sont PASSÉS.");
            } else {
                System.out.println("❌ Des contrôles pour '" + NOMS_METHODE[choix - 1] + "' ont ÉCHOUÉ (voir les indications ci-dessus).");
            }
            System.out.println();
        }
    }

    // ============
    // Mini-framework
    // ============

    private static class Echec {
        final String contexte;
        final String attendu;
        final String obtenu;
        final List<String> pistes = new ArrayList<>();
        Echec(String contexte, String attendu, String obtenu, String... pistes) {
            this.contexte = contexte;
            this.attendu = attendu;
            this.obtenu = obtenu;
            this.pistes.addAll(Arrays.asList(pistes));
        }
    }

    private static void rapport(String titre, List<Echec> echecs) {
        if (echecs.isEmpty()) {
            System.out.println("✔ " + titre + " — OK");
            return;
        }
        System.out.println("✘ " + titre + " — " + echecs.size() + " problème(s) :");
        int i = 1;
        for (Echec e : echecs) {
            System.out.println("  " + (i++) + ") Contexte : " + e.contexte);
            if (e.attendu != null) System.out.println("     Attendu : " + e.attendu);
            if (e.obtenu   != null) System.out.println("     Obtenu  : " + e.obtenu);
            if (!e.pistes.isEmpty()) {
                System.out.println("     Pistes de correction :");
                for (String p : e.pistes) System.out.println("       • " + p);
            }
        }
    }

    private static void eqInt(List<Echec> E, String ctx, int attendu, int obtenu, String... pistes) {
        if (attendu != obtenu) {
            E.add(new Echec(ctx, String.valueOf(attendu), String.valueOf(obtenu), pistes));
        }
    }

    private static void eqBool(List<Echec> E, String ctx, boolean attendu, boolean obtenu, String... pistes) {
        if (attendu != obtenu) {
            E.add(new Echec(ctx, String.valueOf(attendu), String.valueOf(obtenu), pistes));
        }
    }

    private static void eqListInt(List<Echec> E, String ctx, List<Integer> attendu, List<Integer> obtenu, String... pistes) {
        if (obtenu == null || !attendu.equals(obtenu)) {
            E.add(new Echec(ctx, String.valueOf(attendu), String.valueOf(obtenu), pistes));
        }
    }

    private static void attendIAE(List<Echec> E, String ctx, Runnable r, String... pistes) {
        try {
            r.run();
            E.add(new Echec(ctx, "Lever IllegalArgumentException", "Aucune exception levée", pistes));
        } catch (IllegalArgumentException ex) {
            // OK
        } catch (Throwable t) {
            E.add(new Echec(ctx, "Lever IllegalArgumentException", "Exception différente : " + t, pistes));
        }
    }

    // ===========================
    // Tests + feedback par méthode
    // ===========================

    private static boolean testFactorielle() {
        List<Echec> E = new ArrayList<>();
        try {
            eqInt(E, "factorielle(0)", 1, Recursivite.factorielle(0),
                    "Cas de base : 0! = 1 doit être traité AVANT la récursion.");
            eqInt(E, "factorielle(5)", 120, Recursivite.factorielle(5),
                    "La relation récursive est n! = n * (n-1)!");
            attendIAE(E, "factorielle(11)", () -> Recursivite.factorielle(11),
                    "Limitez n (Si n > 10 -> IllegalArgumentException).");
        } catch (Throwable t) {
            E.add(new Echec("factorielle — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Vérifiez l'appel récursif. L'argument doit être n-1."));
        }
        rapport("factorielle", E);
        return E.isEmpty();
    }

    private static boolean testPgcd() {
        List<Echec> E = new ArrayList<>();
        try {
            eqInt(E, "pgcd(54,24)", 6, Recursivite.pgcd(54,24),
                    "La relation récursive est : pgcd(a,b) = pgcd(b, a % b).");
            eqInt(E, "pgcd(0,5)", 5, Recursivite.pgcd(0,5),
                    "Cas de base : si b == 0, retourner a.");
            eqInt(E, "pgcd(5,0)", 5, Recursivite.pgcd(5,0),
                    "Cas de base : si b == 0, retourner a.");
            eqInt(E, "pgcd(35,64)", 1, Recursivite.pgcd(35,64),
                    "Attention au sens de a % b (reste modulo) et à l’ordre des arguments.");
        } catch (Throwable t) {
            E.add(new Echec("pgcd — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Traitez d’abord b == 0, puis appelez pgcd(b, a % b)."));
        }
        rapport("pgcd", E);
        return E.isEmpty();
    }

    private static boolean testSommePremiersImpairs() {
        List<Echec> E = new ArrayList<>();
        try {
            eqInt(E, "sommePremiersImpairs(0)", 0, Recursivite.sommePremiersImpairs(0),
                    "Cas de base : si n == 0, retourner 0.");
            eqInt(E, "sommePremiersImpairs(5)", 25, Recursivite.sommePremiersImpairs(5),
                    "Récurrence : S(n) = S(n-1) + (2n-1)");
            attendIAE(E, "sommePremiersImpairs(-3)",
                    () -> Recursivite.sommePremiersImpairs(-3),
                    "Pour n < 0, IllegalArgumentException est requise.");
        } catch (Throwable t) {
            E.add(new Echec("sommePremiersImpairs — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Vérifiez l'appel récursif. L'argument doit être n-1."));
        }
        rapport("sommePremiersImpairs", E);
        return E.isEmpty();
    }

    private static boolean testNEmeNombreTriangulaire() {
        List<Echec> E = new ArrayList<>();
        try {
            eqInt(E, "nEmeNombreTriangulaire(0)", 0, Recursivite.nEmeNombreTriangulaire(0), "Cas de base : T(0) = 0.");
            eqInt(E, "nEmeNombreTriangulaire(5)", 15, Recursivite.nEmeNombreTriangulaire(5),
                    "Base : T(0) = 0.",
                    "Récurrence : T(n) = T(n-1) + n.");
            attendIAE(E, "nEmeNombreTriangulaire(-1)", () -> Recursivite.nEmeNombreTriangulaire(-1),
                    "Pour n < 0, IllegalArgumentException doit être levée.");
        } catch (Throwable t) {
            E.add(new Echec("nEmeNombreTriangulaire — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Ordre recommandé : vérifier si n>=0 -> cas de base -> récursion.", "Vérifiez l'appel récursif. L'argument doit être n-1."));
        }
        rapport("nEmeNombreTriangulaire", E);
        return E.isEmpty();
    }

    private static boolean testFibonacci() {
        List<Echec> E = new ArrayList<>();
        try {
            int[] att = {0,1,1,2,3,5,8,13,21,34,55};
            for (int n = 0; n < att.length; n++) {
                int obt = Recursivite.fibonacci(n);
                if (att[n] != obt) {
                    E.add(new Echec("fibonacci(" + n + ")", String.valueOf(att[n]), String.valueOf(obt),
                            "Bases : F(0) = 0 et F(1) = 1.",
                            "Transition : F(n) = F(n-1) + F(n-2)."));
                }
            }
            attendIAE(E, "fibonacci(-1)", () -> Recursivite.fibonacci(-1),
                    "Pour n < 0, lever IllegalArgumentException.");
            attendIAE(E, "fibonacci(21)", () -> Recursivite.fibonacci(21),
                    "Limiter n (ici n > 20 -> IllegalArgumentException) pour limiter le temps d'exécution (complexité exponentielle).");
        } catch (Throwable t) {
            E.add(new Echec("fibonacci — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Vérifiez que les deux cas de base (0 et 1) sont bien gérés.", "Vérifiez que les arguments des appels récursifs soient n-1 et n-2"));
        }
        rapport("fibonacci", E);
        return E.isEmpty();
    }

    private static boolean testSommeTableau() {
        List<Echec> E = new ArrayList<>();
        try {
            eqInt(E, "sommeTableau({})", 0, Recursivite.sommeTableau(new int[]{}),
                    "Cas de base : indice < 0 -> 0.");
            eqInt(E, "sommeTableau({1,2,3})", 6, Recursivite.sommeTableau(new int[]{1,2,3}),
                    "Utilisez une méthode privée qui décrémente l’indice.");
            eqInt(E, "sommeTableau({1,-2,3})", 2, Recursivite.sommeTableau(new int[]{1,-2,3}),
                    "La somme doit tenir compte des valeurs négatives.");
            attendIAE(E, "sommeTableau(null)", () -> Recursivite.sommeTableau(null),
                    "Si le tableau est null -> IllegalArgumentException.");
        } catch (Throwable t) {
            E.add(new Echec("sommeTableau — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Assurez le pas de -1 pour atteindre la base."));
        }
        rapport("sommeTableau", E);
        return E.isEmpty();
    }

    private static boolean testPuissance() {
        List<Echec> E = new ArrayList<>();
        try {
            eqInt(E, "puissance(3,0)", 1, Recursivite.puissance(3,0),
                    "Cas de base : a^0 = 1.");
            eqInt(E, "puissance(2,3)", 8, Recursivite.puissance(2,3),
                    "Si n est impair : a * a^(n-1).", "Vérifiez la condition n pair/n impair");
            eqInt(E, "puissance(2,10)", 1024, Recursivite.puissance(2,10),
                    "Si n est pair : (a^(n/2))^2 (exponentiation rapide).","Vérifiez la condition n pair/n impair");
            attendIAE(E, "puissance(2,-1)", () -> Recursivite.puissance(2,-1),
                    "Pour n < 0, lever IllegalArgumentException.");
        } catch (Throwable t) {
            E.add(new Echec("puissance — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Vérifiez les arguments des l'appel récursif."));
        }
        rapport("puissance", E);
        return E.isEmpty();
    }

    private static boolean testEstPremier() {
        List<Echec> E = new ArrayList<>();
        try {
            eqBool(E, "estPremier(1)", false, Recursivite.estPremier(1),
                    "Par définition, 1 n’est pas premier (gérez n < 2 -> false).");
            eqBool(E, "estPremier(2)", true, Recursivite.estPremier(2),
                    "Plus petit nombre premier.");
            eqBool(E, "estPremier(29)", true, Recursivite.estPremier(29),
                    "Arrêt lorsque d * d > n : alors n est premier.");
            eqBool(E, "estPremier(100)", false, Recursivite.estPremier(100),
                    "Si n % d == 0 -> false.");
        } catch (Throwable t) {
            E.add(new Echec("estPremier — exécution", "Aucune exception imprévue", "Exception : " + t,
                    "Utilisez une methode privée récursif avec arguments n et d+1 ; base : d * d > n -> true."));
        }
        rapport("estPremier", E);
        return E.isEmpty();
    }



    // =========
    // Utilitaires
    // =========

    private static int lireEntier() {
        while (true) {
            try {
                String s = scanner.nextLine().trim();
                if (s.isEmpty()) continue;
                return Integer.parseInt(s);
            } catch (Exception e) {
                System.out.print("Veuillez entrer un entier : ");
            }
        }
    }
}