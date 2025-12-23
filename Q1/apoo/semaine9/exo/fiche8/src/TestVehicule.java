import java.time.LocalDate;

public class TestVehicule {

    public static void main(String[] args) {
        System.out.println("=== TESTS DES VÉHICULES ===\n");

        testVoiture();
        testUtilitaire();
        testValidations();

        System.out.println("\n✅ Tous les tests sont terminés !");
    }

    // ========== TESTS VOITURE ==========
    public static void testVoiture() {
        System.out.println("--- Tests Voiture ---");

        // Test 1 : Voiture neuve (< 4 ans)
        System.out.println("\n1. Voiture neuve (mise en circulation il y a 2 ans)");
        LocalDate il_y_a_2_ans = LocalDate.now().minusYears(2);
        Voiture v1 = new Voiture("CH001", "1-ABC-123", il_y_a_2_ans);

        System.out.println("Immatriculation: " + v1.getImmatriculation());
        System.out.println("Date mise en circulation: " + v1.getDateMiseEnCirculation());
        System.out.println("Kilométrage: " + v1.getKilometrage());
        System.out.println("En ordre? " + v1.estEnOde());  // true ✅
        System.out.println("Résultat attendu: true (< 4 ans)");

        // Test 2 : Voiture ancienne (> 4 ans) AVEC contrôle récent
        System.out.println("\n2. Voiture ancienne (5 ans) avec contrôle récent (6 mois)");
        LocalDate il_y_a_5_ans = LocalDate.now().minusYears(5);
        Voiture v2 = new Voiture("CH002", "1-DEF-456", il_y_a_5_ans);

        // Simulation d'un contrôle technique il y a 6 mois
        LocalDate il_y_a_6_mois = LocalDate.now().minusMonths(6);
        v2.setKilometrage(50000);
        v2.setDateDeControleTechnique(il_y_a_6_mois);

        System.out.println("Immatriculation: " + v2.getImmatriculation());
        System.out.println("Date dernier contrôle: " + v2.getDateDeControleTechnique());
        System.out.println("Kilométrage: " + v2.getKilometrage());
        System.out.println("En ordre? " + v2.estEnOde());  // true ✅
        System.out.println("Résultat attendu: true (contrôle < 1 an)");

        // Test 3 : Voiture ancienne (> 4 ans) SANS contrôle récent
        System.out.println("\n3. Voiture ancienne (5 ans) sans contrôle récent (2 ans)");
        Voiture v3 = new Voiture("CH003", "1-GHI-789", il_y_a_5_ans);

        // Simulation d'un contrôle technique il y a 2 ans
        LocalDate il_y_a_2_ans_date = LocalDate.now().minusYears(2);
        v3.setKilometrage(80000);
        v3.setDateDeControleTechnique(il_y_a_2_ans_date);

        System.out.println("Immatriculation: " + v3.getImmatriculation());
        System.out.println("Date dernier contrôle: " + v3.getDateDeControleTechnique());
        System.out.println("Kilométrage: " + v3.getKilometrage());
        System.out.println("En ordre? " + v3.estEnOde());  // false ❌
        System.out.println("Résultat attendu: false (> 4 ans ET contrôle > 1 an)");

        // Test 4 : Modification de l'immatriculation
        System.out.println("\n4. Modification de l'immatriculation");
        v1.setImmatriculation("1-XYZ-999");
        System.out.println("Nouvelle immatriculation: " + v1.getImmatriculation());
        System.out.println("Résultat attendu: 1-XYZ-999");
    }

    // ========== TESTS UTILITAIRE ==========
    public static void testUtilitaire() {
        System.out.println("\n\n--- Tests Utilitaire ---");

        // Test 1 : Utilitaire avec valeur par défaut (50000 km)
        System.out.println("\n1. Utilitaire neuf avec km max par défaut");
        LocalDate aujourdhui = LocalDate.now();
        Utilitaire u1 = new Utilitaire("CH101", "2-ABC-123", aujourdhui);

        System.out.println("Immatriculation: " + u1.getImmatriculation());
        System.out.println("Km max entre contrôles: " + u1.getKmMaxEntreControles());
        System.out.println("Km dernier contrôle: " + u1.getKmDernierControle());
        System.out.println("Kilométrage actuel: " + u1.getKilometrage());
        System.out.println("En ordre? " + u1.estEnOde());  // true ✅
        System.out.println("Résultat attendu: true (0 km parcourus), km max = 50000");

        // Test 2 : Utilitaire avec valeur personnalisée (30000 km)
        System.out.println("\n2. Utilitaire avec km max personnalisé (30000)");
        Utilitaire u2 = new Utilitaire("CH102", "2-DEF-456", aujourdhui, 30000);

        System.out.println("Km max entre contrôles: " + u2.getKmMaxEntreControles());
        System.out.println("Résultat attendu: 30000");

        // Test 3 : Utilitaire EN ORDRE (40000 km < 50000 km max)
        System.out.println("\n3. Utilitaire EN ORDRE (40000 km parcourus < 50000 max)");
        Utilitaire u3 = new Utilitaire("CH103", "2-GHI-789", aujourdhui, 50000);
        u3.setKilometrage(40000);

        System.out.println("Kilométrage: " + u3.getKilometrage());
        System.out.println("Km depuis dernier contrôle: " + (u3.getKilometrage() - u3.getKmDernierControle()));
        System.out.println("Km max: " + u3.getKmMaxEntreControles());
        System.out.println("En ordre? " + u3.estEnOde());  // true ✅
        System.out.println("Résultat attendu: true");

        // Test 4 : Utilitaire PAS EN ORDRE (60000 km > 50000 km max)
        System.out.println("\n4. Utilitaire PAS EN ORDRE (60000 km parcourus > 50000 max)");
        Utilitaire u4 = new Utilitaire("CH104", "2-JKL-012", aujourdhui, 50000);
        u4.setKilometrage(60000);

        System.out.println("Kilométrage: " + u4.getKilometrage());
        System.out.println("Km depuis dernier contrôle: " + (u4.getKilometrage() - u4.getKmDernierControle()));
        System.out.println("Km max: " + u4.getKmMaxEntreControles());
        System.out.println("En ordre? " + u4.estEnOde());  // false ❌
        System.out.println("Résultat attendu: false");

        // Test 5 : Nouveau contrôle technique
        System.out.println("\n5. Nouveau contrôle technique");
        Utilitaire u5 = new Utilitaire("CH105", "2-MNO-345", LocalDate.now().minusYears(1), 50000);
        u5.setKilometrage(60000);

        System.out.println("Avant contrôle:");
        System.out.println("  Kilométrage: " + u5.getKilometrage());
        System.out.println("  Km dernier contrôle: " + u5.getKmDernierControle());
        System.out.println("  En ordre? " + u5.estEnOde());  // false ❌

        // Effectuer un nouveau contrôle
        LocalDate dateControle = LocalDate.now();
        u5.setDateDeControleTechnique(dateControle);

        System.out.println("\nAprès contrôle:");
        System.out.println("  Kilométrage: " + u5.getKilometrage());
        System.out.println("  Km dernier contrôle: " + u5.getKmDernierControle());
        System.out.println("  En ordre? " + u5.estEnOde());  // true ✅
        System.out.println("Résultat attendu: km dernier contrôle = 60000, en ordre = true");

        // Rouler encore 40000 km
        u5.setKilometrage(100000);
        System.out.println("\nAprès avoir roulé 40000 km de plus:");
        System.out.println("  Kilométrage: " + u5.getKilometrage());
        System.out.println("  Km depuis dernier contrôle: " + (u5.getKilometrage() - u5.getKmDernierControle()));
        System.out.println("  En ordre? " + u5.estEnOde());  // true ✅
        System.out.println("Résultat attendu: true (40000 < 50000)");

        // Dépasser la limite
        u5.setKilometrage(111000);
        System.out.println("\nAprès avoir dépassé la limite:");
        System.out.println("  Kilométrage: " + u5.getKilometrage());
        System.out.println("  Km depuis dernier contrôle: " + (u5.getKilometrage() - u5.getKmDernierControle()));
        System.out.println("  En ordre? " + u5.estEnOde());  // false ❌
        System.out.println("Résultat attendu: false (51000 > 50000)");
    }

    // ========== TESTS VALIDATIONS ==========
    public static void testValidations() {
        System.out.println("\n\n--- Tests Validations (Exceptions) ---");

        // Test 1 : Numéro de châssis null
        System.out.println("\n1. Test numéro de châssis null");
        try {
            Voiture v = new Voiture(null, "1-ABC-123", LocalDate.now());
            System.out.println("❌ ERREUR : L'exception n'a pas été levée !");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Exception levée : " + e.getMessage());
        }

        // Test 2 : Immatriculation vide
        System.out.println("\n2. Test immatriculation vide");
        try {
            Voiture v = new Voiture("CH123", "", LocalDate.now());
            System.out.println("❌ ERREUR : L'exception n'a pas été levée !");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Exception levée : " + e.getMessage());
        }

        // Test 3 : Date null
        System.out.println("\n3. Test date null");
        try {
            Voiture v = new Voiture("CH123", "1-ABC-123", null);
            System.out.println("❌ ERREUR : L'exception n'a pas été levée !");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Exception levée : " + e.getMessage());
        }

        // Test 4 : Kilométrage inférieur
        System.out.println("\n4. Test kilométrage non croissant");
        try {
            Voiture v = new Voiture("CH123", "1-ABC-123", LocalDate.now());
            v.setKilometrage(50000);
            v.setKilometrage(40000);  // ❌ Plus petit !
            System.out.println("❌ ERREUR : L'exception n'a pas été levée !");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Exception levée : " + e.getMessage());
        }

        // Test 5 : Date contrôle non ultérieure
        System.out.println("\n5. Test date contrôle non ultérieure");
        try {
            Voiture v = new Voiture("CH123", "1-ABC-123", LocalDate.now());
            v.setKilometrage(10000);
            LocalDate date1 = LocalDate.now().plusDays(10);
            v.setDateDeControleTechnique(date1);
            v.setKilometrage(20000);

            // Essayer de mettre une date antérieure
            LocalDate date2 = LocalDate.now().plusDays(5);  // ❌ Avant date1
            v.setDateDeControleTechnique(date2);
            System.out.println("❌ ERREUR : L'exception n'a pas été levée !");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Exception levée : " + e.getMessage());
        }

        // Test 6 : Km max négatif pour utilitaire
        System.out.println("\n6. Test km max négatif pour utilitaire");
        try {
            Utilitaire u = new Utilitaire("CH123", "2-ABC-123", LocalDate.now(), -1000);
            System.out.println("❌ ERREUR : L'exception n'a pas été levée !");
        } catch (IllegalArgumentException e) {
            System.out.println("✅ Exception levée : " + e.getMessage());
        }
    }
}
