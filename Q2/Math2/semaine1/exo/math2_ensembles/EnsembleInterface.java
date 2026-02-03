/** Interface pour les classes Ensi ( i = 1,2,3,...).
 */

import java.util.*;

public interface EnsembleInterface {
	public static final int MAX = Elt.MAXELT.val();

	// renvoie true ssi l'ensemble courant est vide
	public boolean estVide();
	
	// renvoie un element de l'ensemble s'il n'est pas vide
	// lance une MathException si l'ensemble est vide
	public Elt unElement();

	// renvoie true ssi e appartient à l'ensemble courant
	// lance une IllegalArgumentException en cas de paramètre invalide
	public boolean contient(Elt e);

	// ajoute e (éventuellement) à l'ensemble courant
	// lance une IllegalArgumentException en cas de paramètre invalide
	public void ajouter(Elt e);

	// enlève e (éventuellement) de l'ensemble courant
	// lance une IllegalArgumentException en cas de paramètre invalide
	public void enlever(Elt e);

	// this <- complém. de this
	public void complementer();

	// renvoie le cardinal de l'ensemble courant
	public int cardinal();

	// renvoie une chaîne de caractère décrivant this en extension
	public String toString();

	// remplace this par this union a
	// lance une IllegalArgumentException en cas de paramètre invalide
	public default void ajouter(EnsembleInterface a) {
		//TODO
		
	}

	// remplace this par this moins a
	// lance une IllegalArgumentException en cas de paramètre invalide
	public default void enlever(EnsembleInterface a) {
		//TODO
		
	}

	// remplace this par this inter a
	// lance une IllegalArgumentException en cas de paramètre invalide
	public default void intersecter(EnsembleInterface a) {
		//TODO
		
	}
	
} // interface
