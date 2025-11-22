
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

public class Commande {
	private ArrayList<LigneDeCommande> lignes;
	private LocalDate date;

	public Commande() {
		date = LocalDate.now();
		lignes = new ArrayList<>();
	}

	// Ajouter une quantité d'un article
	public void ajouter(Article article, int quantite) {
		for (LigneDeCommande ligne : lignes) {
			if (ligne.getArticle().equals(article)) {
				ligne.setQuantite(ligne.getQuantite() + quantite);
				return;
			}
		}
		lignes.add(new LigneDeCommande(article, quantite));
	}

	// Calculer le prix total
	public double calculerPrixTotal() {
		double total = 0;
		for (LigneDeCommande ligne : lignes) {
			total += ligne.calculerPrixLigne();
		}
		return total;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String infosCommande = "Date : " + date.format(formatter) + "\n";
		infosCommande += "Articles commandés :\n";

		for (LigneDeCommande ligne : lignes) {
			infosCommande += "- " + ligne.toString() + "\n";
		}

		infosCommande += "Prix total : " + calculerPrixTotal() + " €";
		return infosCommande;
	}
}
