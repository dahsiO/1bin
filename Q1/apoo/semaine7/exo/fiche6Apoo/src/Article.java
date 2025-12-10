import java.util.Objects;

public class Article {
	// Constante pour le taux de TVA par défaut
	private static final double TAUX_TVA_DEFAUT = 21.0;

	// Compteur d'articles créés (variable de classe)
	private static int nombreArticlesCrees = 0;

	private String reference;
	private String nom;
	private String description;
	private double prixHTVA;
	private double tauxTVA;

	public Article(String reference, String nom, String description, double prixHTVA, double tauxTVA) {
		// Validation de la référence
		if (reference == null) {
			throw new IllegalArgumentException("La référence ne peut pas être null");
		}
		if (reference.isEmpty()) {
			throw new IllegalArgumentException("La référence ne peut pas être une chaîne vide");
		}

		// Validation du nom
		if (nom == null) {
			throw new IllegalArgumentException("Le nom ne peut pas être null");
		}
		if (nom.isEmpty()) {
			throw new IllegalArgumentException("Le nom ne peut pas être une chaîne vide");
		}

		this.reference = reference;
		this.nom = nom;
		setTauxTVA(tauxTVA);
		setDescription(description);
		setPrixHTVA(prixHTVA);

		nombreArticlesCrees++; // Incrémenter le compteur
	}

	public Article(String reference, String nom, String description, double prixHTVA) {
		this(reference, nom, description, prixHTVA, TAUX_TVA_DEFAUT);
	}

	// Méthode de classe pour obtenir le nombre d'articles créés
	public static int getNombreArticlesCrees() {
		return nombreArticlesCrees;
	}

	public String getReference() {
		return reference;
	}

	public String getNom() {
		return nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixHTVA() {
		return prixHTVA;
	}

	public void setPrixHTVA(double prixHTVA) {
		if (prixHTVA <= 0) {
			throw new IllegalArgumentException("Le prix doit être strictement positif");
		}
		this.prixHTVA = prixHTVA;
	}

	public double getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(double tauxTVA) {
		if (tauxTVA < 0 || tauxTVA > 100) {
			throw new IllegalArgumentException("Le taux de TVA doit être compris entre 0 et 100 (bornes incluses)");
		}
		this.tauxTVA = tauxTVA;
	}

	public double calculerPrixTVAComprise() {
		return prixHTVA * (1 + tauxTVA/100);
	}

	public double calculerPrixTVAComprise(int reduction) {
		if (reduction <= 0 || reduction >= 100) {
			throw new IllegalArgumentException("La réduction doit être comprise entre 0 et 100 (bornes exclues)");
		}
		return calculerPrixTVAComprise() * (1 - reduction/100.0);
	}

	public String toString() {
		return "Référence : " + reference + "\nNom : " + nom + " (prix HTVA : " + prixHTVA + ", taux de TVA : " + tauxTVA + "%)";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Article article = (Article) o;
		return reference.equals(article.reference);
	}

	@Override
	public int hashCode() {
		return Objects.hash(reference);
	}
}