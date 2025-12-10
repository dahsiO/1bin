import java.time.Duration;
import java.time.LocalDateTime;

public class TestAppelTelephonique {
    public static void main(String[] args) {
        System.out.println("=== TEST APPEL TELEPHONIQUE ===\n");

        // Test 1 : Appel avec tarif personnalisé
        System.out.println("Test 1 : Création d'un appel valide avec tarif personnalisé");
        try {
            AppelTelephonique appel1 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    "02/123.45.67",
                    Duration.ofMinutes(5).plusSeconds(30),
                    0.20
            );
            System.out.println(appel1);
            System.out.println("✓ Test réussi\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Erreur : " + e.getMessage() + "\n");
        }

        // Test 2 : Appel avec tarif par défaut
        System.out.println("Test 2 : Création d'un appel avec tarif par défaut");
        try {
            AppelTelephonique appel2 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 10, 15, 0),
                    "0495/12.34.56",
                    Duration.ofMinutes(3).plusSeconds(45)
            );
            System.out.println(appel2);
            System.out.println("✓ Test réussi\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Erreur : " + e.getMessage() + "\n");
        }

        // Test 3 : Date null
        System.out.println("Test 3 : Création avec date null");
        try {
            AppelTelephonique appel3 = new AppelTelephonique(
                    null,
                    "02/123.45.67",
                    Duration.ofMinutes(5),
                    0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 4 : Numéro null
        System.out.println("Test 4 : Création avec numéro null");
        try {
            AppelTelephonique appel4 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    null,
                    Duration.ofMinutes(5),
                    0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 5 : Durée null
        System.out.println("Test 5 : Création avec durée null");
        try {
            AppelTelephonique appel5 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    "02/123.45.67",
                    null,
                    0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 6 : Tarif égal à 0
        System.out.println("Test 6 : Création avec tarif égal à 0");
        try {
            AppelTelephonique appel6 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    "02/123.45.67",
                    Duration.ofMinutes(5),
                    0
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 7 : Tarif négatif
        System.out.println("Test 7 : Création avec tarif négatif");
        try {
            AppelTelephonique appel7 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    "02/123.45.67",
                    Duration.ofMinutes(5),
                    -0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 8 : Durée égale à 0
        System.out.println("Test 8 : Création avec durée égale à 0");
        try {
            AppelTelephonique appel8 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    "02/123.45.67",
                    Duration.ZERO,
                    0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 9 : Durée négative
        System.out.println("Test 9 : Création avec durée négative");
        try {
            AppelTelephonique appel9 = new AppelTelephonique(
                    LocalDateTime.of(2024, 12, 9, 14, 30, 0),
                    "02/123.45.67",
                    Duration.ofMinutes(-5),
                    0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 10 : Date dans le futur
        System.out.println("Test 10 : Création avec date dans le futur");
        try {
            AppelTelephonique appel10 = new AppelTelephonique(
                    LocalDateTime.now().plusDays(1),
                    "02/123.45.67",
                    Duration.ofMinutes(5),
                    0.15
            );
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        // Test 11 : Modification du tarif par défaut
        System.out.println("Test 11 : Modification du tarif par défaut");
        try {
            System.out.println("Tarif actuel : " + AppelTelephonique.getTarifDefaut() + " €/min");
            AppelTelephonique.setTarifDefaut(0.25);
            System.out.println("Nouveau tarif : " + AppelTelephonique.getTarifDefaut() + " €/min");

            AppelTelephonique appel11 = new AppelTelephonique(
                    LocalDateTime.now().minusMinutes(10),
                    "02/111.22.33",
                    Duration.ofMinutes(2)
            );
            System.out.println(appel11);
            System.out.println("✓ Test réussi\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Erreur : " + e.getMessage() + "\n");
        }

        // Test 12 : Modification du tarif par défaut avec valeur invalide
        System.out.println("Test 12 : Tarif par défaut négatif");
        try {
            AppelTelephonique.setTarifDefaut(-0.10);
            System.out.println("✗ Aucune exception levée !\n");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception attendue : " + e.getMessage() + "\n");
        }

        System.out.println("=== FIN DES TESTS ===");
    }
}