public interface ListeAM<E>{
	
	/**
	 * renvoie le nombre d elements dans la liste
	 * @return le nombre d'elements de la liste
	 */
	public int taille();

	
	/**
	 * verifie si la liste est vide
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide();


	/**
	 * verifie la presence de l element passe en parametre dans la liste
	 * @param element l element recherche
	 * @return true si l element est present, false sinon
	 * @throws IllegalArgumentException si element est null
	 */
	boolean contient(E element);


	/**
	 * renvoie le nieme element de la liste
	 * @param n la position de l'element recherche
	 * @return le nieme element de la liste
	 * @throws IllegalArgumentException si la liste ne contient pas un nieme element
	 */
	E donnerNieme(int n);



	/**
	 * supprime le dernier element de la liste
	 * @return l'element qui est supprime ou null si la liste est vide
	 */
	E supprimerDernier();



}
