
public interface FileAttenteAvecDesistement<E> {

	/**
	 * renvoie le nombre d elements dans la file
	 * @return
	 */
	public int taille();


	/**
	 * insere un nouvel element en queue si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en queue
	 * @return true si l'element a ete ajoute, false sinon
	 */
	boolean enfile(E element);


	/**
	 * supprime l element de tete
	 * @return l element de tete ou null s'il n'y a plus d'element
	 */
	E defile();


	/**
	 * supprime de la file l element passe en parametre
	 * @param element l element a supprimer
	 * @return true si l element etait bien present, false sinon
	 */
	boolean desister(E element);


}