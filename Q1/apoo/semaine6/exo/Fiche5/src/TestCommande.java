
public class TestCommande {
	public static void main(String[] args) {
		Article article1 = new Article("REF001", "Vélo de femme", "Vélo confortable pour femme", 500.0, 0.21);
		Article article2 = new Article("REF002", "Tandem", "Vélo tandem pour deux personnes", 800.0, 0.21);

		// Commande 1 : 2 vélos de femme + 1 tandem
		Commande commande1 = new Commande();
		commande1.ajouter(article1, 2);
		commande1.ajouter(article2, 1);

		// Commande 2 : 1 tandem
		Commande commande2 = new Commande();
		commande2.ajouter(article2, 1);

		System.out.println("=== Commande 1 ===");
		System.out.println(commande1);

		System.out.println("\n=== Commande 2 ===");
		System.out.println(commande2);
	}
}
