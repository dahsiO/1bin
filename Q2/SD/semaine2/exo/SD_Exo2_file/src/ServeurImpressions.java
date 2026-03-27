import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class  ServeurImpressions {

	// table de 10 files d'attente d'impression
	private ArrayDeque<DemandeImpression>[] tableFilesDAttente;
	
	/**
	 * construit une table avec 10 files d'attente d'impression
	 */
	public ServeurImpressions() {
		//A cause d'une limitation du generique en JAVA
		//new ArrayDeque[10] --> OK (avec avertissement)
		//new ArrayDeque<DemandeImpression>[10] --> KO
		tableFilesDAttente = new ArrayDeque[10];
		for (int i = 0; i < 10; i++) {
			tableFilesDAttente[i] = new ArrayDeque<>();
		}
	}
	
	/**
	 * verifie si toutes les files d'attente sont vides
	 * @return true si toutes les files sont vides, false sinon
	 */
	public boolean serveurVide(){
		// iter foreach
		// for ( Type variable : collection ) {utilise la variable}
		// se lit " pour chaque element de la collection faire ...."
		for (ArrayDeque<DemandeImpression> file : tableFilesDAttente) {
			if (!file.isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ajoute la demande d'impression en fin de la file correspondante a sa priorite
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpression demande){
		if (demande == null) {
			throw new IllegalArgumentException();
		}
		/*
		* tableFilesDAttente[demande.getPriorite()].addLast(demande);
		* La priorité de la demande **est l'index** du tableau. Pas besoin de comparer,
		*  pas besoin de trier — elle va directement au bon endroit.
				ajouter(demande priorité 3)  →  tableFilesDAttente[3].addLast(demande)
				ajouter(demande priorité 7)  →  tableFilesDAttente[7].addLast(demande)
				ajouter(demande priorité 3)  →  tableFilesDAttente[3].addLast(demande)

				Résultat :
				[3] → [ doc1, doc3 ]
				[7] → [ doc2 ]
		* */
		tableFilesDAttente[demande.getPriorite()].addLast(demande);
	}

	/**
	 * retire la demande d'impression en tete de file de priorite la plus haute qui est non vide
	 * @return la demande d'impression qui a ete retiree
	 * @throws NoSuchElementException si aucune demande d impression dans le serveur
	 */
	public DemandeImpression retirer(){
		for (int i = 9; i >= 0; i--) {
			if (!tableFilesDAttente[i].isEmpty()) {
				return tableFilesDAttente[i].removeFirst();
			}
		}
		throw new NoSuchElementException();
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	@Override
	public String toString() {
		return Arrays.toString(tableFilesDAttente) ;
	}

}


