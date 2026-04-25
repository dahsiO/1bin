import java.util.LinkedList;

public class SerieEtudiants {
	
	private int numeroSerie;
	private LinkedList<String> listeEtudiants;

	public SerieEtudiants(int numero) {
		if (numero < 1) throw new IllegalArgumentException();
		this.numeroSerie = numero;
		this.listeEtudiants = new LinkedList<>();
	}
	/**
	 * renvoie le numero de la serie
	 * @return le numero de la serie
	 */
	public int getNumeroSerie(){
		// TODO
		return this.numeroSerie;
	}
	
	/**
	 * renvoie le nombre d'etudiants dans la serie
	 * @return le nombre d'etudiants
	 */
	public int nombreEtudiants(){
		// TODO
		return this.listeEtudiants.size();
	}


	/**
	 * verifie la presence d'un etudiant dans la serie
	 * @param nom le nom de l'etudiant recherche
	 * @return true si l'etudiant est present, false sinon
	 * @throws IllegalArgumentException si le nom est null ou vide
	 */
	public boolean contientEtudiant(String nom){
		// TODO
		if (nom == null || nom == ""){
			throw new IllegalArgumentException();
		}
		if (listeEtudiants.contains(nom)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * ajoute un etudiant 
	 * l'ordre des etudiants dans la serie : du plus recent au moins recent
	 * precondition : l'etudiant n'est present dans aucune des series
	 * ! Il ne faut pas verifier une precondition !
	 * @param nom le nom de l'etudiant a ajouter
	 * @throws IllegalArgumentException si le nom est null ou vide
	 */
	public void ajouterEtudiant(String nom){
		// TODO
		if (nom == null || nom.isEmpty()) throw new IllegalArgumentException();
		listeEtudiants.addFirst(nom);
	}

	
	/**
	 * supprime un etudiant s'il est present dans la serie.
	 * @param nom le nom de l'etudiant a supprimer
	 * @return true si l'etudiant etait dans la serie, false sinon
	 * @throws IllegalArgumentException si le nom est null ou vide
	 */
	public boolean supprimerEtudiant(String nom){
		if (nom == null || nom.isEmpty()) throw new IllegalArgumentException();
		return listeEtudiants.remove(nom);
	}

	public String toString(){
		return "serie n�"+numeroSerie+" "+listeEtudiants.toString();
	}
}
