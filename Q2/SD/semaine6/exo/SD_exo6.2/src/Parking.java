import java.util.HashSet;

public class Parking {

	private HashSet<Voiture> ensembleVoitures;

	// construit un ensembleVoitures vide
	public Parking(){
		// TODO

	}

	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 *
	 */
	public boolean ajouterVoiture(Voiture voiture){
		return false;
		// TODO

	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){	
		return false;
		// TODO

	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		return false;
		// TODO

	}


	/**
	 * remplit une table avec les plaques des voitures autorisees
	 * cette table doit etre triee par ordre alphabetique
	 * @return une table avec les plaques de voitures autorisees
	 */
	public String[] tableTrieePlaques(){

		// piste la classe Arrays possede une methode static sort
		// qui trie la table passee en parametre !

		return null;
		//TODO

	}

	//Pour les tests : (A NE PAS MODIFIER, VA SERVIR POUR LES TESTS)
	@Override
	public String toString() {
		return ensembleVoitures.toString();
	}
}