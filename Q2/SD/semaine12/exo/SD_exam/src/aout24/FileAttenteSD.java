
public interface FileAttenteSD<E> extends Iterable<E> {

	/**
	 * renvoie le nombre d elements dans la file
	 * @return
	 */
	public int taille();


	/**
	 * renvoie l'element de tete
	 * @return l'element de tete ou null si la file est vide
	 */
	public E premier();


	/**
	 * renvoie l'element de queue
	 * @return l'element de queue ou null si la file est vide
	 */
	public E dernier();


	/**
	 * ajoute un nouvel element en queue si celui-ci n'etait pas deja present
	 * @param element le nouvel element a inserer en queue
	 * @return true si l'element a ete ajoute, false sinon
	 */
	boolean enfile(E element);


	/**
	 * supprime l element de tete
	 * @return l element de tete ou null s'il n'y a plus d'element
	 */
	E defile();



}