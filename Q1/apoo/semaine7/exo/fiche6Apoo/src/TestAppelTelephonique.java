import java.time.Duration;
import java.time.LocalDateTime;

public class TestAppelTelephonique {
    public static void main(String[] args) {
        System.out.println("=== TEST APPEL TELEPHONIQUE ===\n");

        // Afficher le tarif par défaut
        System.out.println("Tarif par défaut initial : " + AppelTelephonique.getTarifDefaut() + " €/min");
        System.out.println();

        // Test 1 : Appel avec le constructeur utilisant le tarif par défaut
        System.out.println("Test 1 : Appel avec tarif par défaut");
        AppelTelephonique appel1 = new AppelTelephonique(
                LocalDateTime.of(2024, 12, 9, 14, 30),
                "02/123.45.67",
                Duration.ofMinutes(5)
        );
        System.out.println(appel1);
        System.out.println("Coût calculé : " + String.format("%.2f", appel1.calculerLeCoutAppel()) + " €");
        System.out.println();

        // Test 2 : Appel avec un tarif personnalisé
        System.out.println("Test 2 : Appel avec tarif personnalisé (0.25 €/min)");
        AppelTelephonique appel2 = new AppelTelephonique(
                LocalDateTime.of(2024, 12, 9, 15, 45),
                "02/987.65.43",
                Duration.ofMinutes(10),
                0.25
        );
        System.out.println(appel2);
        System.out.println("Coût calculé : " + String.format("%.2f", appel2.calculerLeCoutAppel()) + " €");
        System.out.println();

        // Test 3 : Appel avec des secondes (minute entamée compte)
        System.out.println("Test 3 : Appel de 3 minutes et 30 secondes (minute entamée compte)");
        AppelTelephonique appel3 = new AppelTelephonique(
                LocalDateTime.of(2024, 12, 9, 16, 15),
                "0495/12.34.56",
                Duration.ofMinutes(3).plusSeconds(30)
        );
        System.out.println(appel3);
        System.out.println("Coût calculé : " + String.format("%.2f", appel3.calculerLeCoutAppel()) + " €");
        System.out.println("(Devrait compter 4 minutes)");
        System.out.println();

        // Test 4 : Appel de 2 minutes exactement (pas de seconde supplémentaire)
        System.out.println("Test 4 : Appel de 2 minutes exactement");
        AppelTelephonique appel4 = new AppelTelephonique(
                LocalDateTime.now(),
                "02/111.22.33",
                Duration.ofMinutes(2)
        );
        System.out.println(appel4);
        System.out.println("Coût calculé : " + String.format("%.2f", appel4.calculerLeCoutAppel()) + " €");
        System.out.println("(Devrait compter 2 minutes exactement)");
        System.out.println();

        // Test 5 : Modifier le tarif par défaut
        System.out.println("Test 5 : Modification du tarif par défaut");
        System.out.println("Ancien tarif par défaut : " + AppelTelephonique.getTarifDefaut() + " €/min");
        AppelTelephonique.setTarifDefaut(0.20);
        System.out.println("Nouveau tarif par défaut : " + AppelTelephonique.getTarifDefaut() + " €/min");

        AppelTelephonique appel5 = new AppelTelephonique(
                LocalDateTime.now(),
                "02/444.55.66",
                Duration.ofMinutes(5)
        );
        System.out.println(appel5);
        System.out.println("Coût calculé : " + String.format("%.2f", appel5.calculerLeCoutAppel()) + " €");
        System.out.println();

        // Test 6 : Appel de 45 secondes (moins d'une minute)
        System.out.println("Test 6 : Appel de 45 secondes seulement");
        AppelTelephonique appel6 = new AppelTelephonique(
                LocalDateTime.now(),
                "0476/99.88.77",
                Duration.ofSeconds(45)
        );
        System.out.println(appel6);
        System.out.println("Coût calculé : " + String.format("%.2f", appel6.calculerLeCoutAppel()) + " €");
        System.out.println("(Devrait compter 1 minute)");
        System.out.println();

        System.out.println("=== FIN DES TESTS ===");
    }
}