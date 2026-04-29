import java.util.Arrays;
import java.util.HashSet;

public class Parking {

	private HashSet<Voiture> ensembleVoitures;

	// construit un ensembleVoitures vide
	public Parking(){
		// TODO
		ensembleVoitures = new HashSet<>();

	}

	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 *
	 */
	public boolean ajouterVoiture(Voiture voiture){
		if (!ensembleVoitures.contains(voiture)) {
			ensembleVoitures.add(voiture);
			return true;
		}
		// TODO
		return false;
	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){
		return ensembleVoitures.contains(voiture);//true
		// TODO

	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		if (ensembleVoitures.contains(voiture)) {
			ensembleVoitures.remove(voiture);
			return true;
		}
		return false;
		// TODO

	}


	/**
	 * remplit une table avec les plaques des voitures autorisees
	 * cette table doit etre triee par ordre alphabetique
	 * @return une table avec les plaques de voitures autorisees
	 */
	public String[] tableTrieePlaques() {
		String[] table = new String[ensembleVoitures.size()];
		int i = 0;
		// pour chaque voiture de l ensemble
		for (Voiture v : ensembleVoitures) {
			table[i] = v.getNumPlaque();
			i++;
		}
		Arrays.sort(table);
		return table;
		// piste la classe Arrays possede une methode static sort
		// qui trie la table passee en parametre !

		//TODO

	}

	//Pour les tests : (A NE PAS MODIFIER, VA SERVIR POUR LES TESTS)
	@Override
	public String toString() {
		return ensembleVoitures.toString();
	}
}