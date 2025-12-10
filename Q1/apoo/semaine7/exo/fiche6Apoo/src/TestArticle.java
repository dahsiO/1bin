public class TestArticle {
        public static void main(String[] args) {
            System.out.println("=== TEST DES SITUATIONS EXCEPTIONNELLES ===\n");

            // Test 1 : Création d'un article avec null comme référence
            System.out.println("Test 1 : Création d'un article avec null comme référence");
            try {
                Article article1 = new Article(null, "Test", "Description test", 100.0, 21.0);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 2 : Création d'un article avec la chaîne vide comme référence
            System.out.println("Test 2 : Création d'un article avec la chaîne vide comme référence");
            try {
                Article article2 = new Article("", "Test", "Description test", 100.0, 21.0);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 3 : Création d'un article ayant 0 comme prix
            System.out.println("Test 3 : Création d'un article ayant 0 comme prix");
            try {
                Article article3 = new Article("REF001", "Test", "Description test", 0, 21.0);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 4 : Création d'un article avec 101 comme taux de TVA
            System.out.println("Test 4 : Création d'un article avec 101 comme taux de TVA");
            try {
                Article article4 = new Article("REF001", "Test", "Description test", 100.0, 101);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 5 : Calculer le prix TVA comprise avec une réduction de -5
            System.out.println("Test 5 : Calculer le prix TVA comprise avec une réduction de -5");
            try {
                // Créer d'abord un article valide
                Article article5 = new Article("REF001", "Test", "Description test", 100.0, 21.0);
                System.out.println("Article créé avec succès");
                // Puis tenter de calculer avec une réduction invalide
                double prix = article5.calculerPrixTVAComprise(-5);
                System.out.println("ERREUR : Aucune exception levée ! Prix calculé : " + prix);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Tests supplémentaires
            System.out.println("=== TESTS SUPPLEMENTAIRES ===\n");

            // Test 6 : Nom null
            System.out.println("Test 6 : Création d'un article avec null comme nom");
            try {
                Article article6 = new Article("REF001", null, "Description test", 100.0, 21.0);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 7 : Nom vide
            System.out.println("Test 7 : Création d'un article avec le nom vide");
            try {
                Article article7 = new Article("REF001", "", "Description test", 100.0, 21.0);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 8 : Prix négatif
            System.out.println("Test 8 : Création d'un article avec un prix négatif");
            try {
                Article article8 = new Article("REF001", "Test", "Description test", -50.0, 21.0);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 9 : Taux de TVA négatif
            System.out.println("Test 9 : Création d'un article avec un taux de TVA négatif");
            try {
                Article article9 = new Article("REF001", "Test", "Description test", 100.0, -5);
                System.out.println("ERREUR : Aucune exception levée !");
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 10 : Réduction de 0 (borne exclue)
            System.out.println("Test 10 : Calculer le prix avec une réduction de 0");
            try {
                Article article10 = new Article("REF001", "Test", "Description test", 100.0, 21.0);
                double prix = article10.calculerPrixTVAComprise(0);
                System.out.println("ERREUR : Aucune exception levée ! Prix calculé : " + prix);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test 11 : Réduction de 100 (borne exclue)
            System.out.println("Test 11 : Calculer le prix avec une réduction de 100");
            try {
                Article article11 = new Article("REF001", "Test", "Description test", 100.0, 21.0);
                double prix = article11.calculerPrixTVAComprise(100);
                System.out.println("ERREUR : Aucune exception levée ! Prix calculé : " + prix);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception attrapée : " + e.getMessage());
            }
            System.out.println();

            // Test de création d'un article valide pour terminer
            System.out.println("=== TEST DE CREATION D'UN ARTICLE VALIDE ===");
            try {
                Article articleValide = new Article("REF001", "Ordinateur", "Dell XPS", 1200.0, 21.0);
                System.out.println("Article créé avec succès !");
                System.out.println(articleValide);
                System.out.println("Prix TVA comprise : " + articleValide.calculerPrixTVAComprise());
                System.out.println("Prix TVA comprise avec 10% de réduction : " + articleValide.calculerPrixTVAComprise(10));
            } catch (IllegalArgumentException e) {
                System.out.println("Exception inattendue : " + e.getMessage());
            }

            System.out.println("\n=== FIN DES TESTS ===");
        }
    }
