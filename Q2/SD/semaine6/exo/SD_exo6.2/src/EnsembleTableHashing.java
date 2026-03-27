import java.util.Arrays;

/**
 * implementation de l'interface Ensemble via une table de listes
 */

public class EnsembleTableHashing<E> implements Ensemble<E>{
	
	private ListeSimpleImpl<E>[] tableListes;
	private int taille;
	private double loadFactor;  //pour le defi 

	// taille : taille logique 
	// capacite : taille physique

    /**
     * construit un ensemble vide
     * @param capacite (taille physique de la table - nombre de listes)
     * @throws IllegalArgumentException si la capacite <= 0
     */
	public EnsembleTableHashing(int capacite){	
		// TODO

	}

	public EnsembleTableHashing(int capacite, double loadFactor){	
		// pour le defi
        this(capacite);
        if(loadFactor<=0)
            throw new IllegalArgumentException();
		this.loadFactor = loadFactor;
	}


    public EnsembleTableHashing(){
        //pour la classe Test
        //this(16);
    }

	public boolean estVide(){
		return taille == 0;
	}

	public int taille(){
		return taille;
	}

	public boolean contient(E element){
		// TODO
		// Attention la methode hashCode() renvoie un entier quelconque
		// Il n'est donc pas necessairement compris entre 0 et taille physique de la table
		// Il pourrait meme etre negatif
		// solution pbm compris entre 0 et taille physique : % taille physique
		// solution pbm negatif : Math.abs()

		return false;
	}

	public boolean ajouter(E element) {
		// TODO
		 return false;
	}

	public boolean enlever(E element) {
		// TODO
		 return false;
	}
	
	
	public String toString(){

		// Pour le debug cette methode renvoie le contenu de la table de listes
		// on y voit apparaitre une table avec les differentes listes, meme celles qui sont vides!

		// Cette methode devrait renvoyer uniquement les donnees comprises dans l'ensemble
		// Ex supplementaire

		return Arrays.toString(tableListes);
	}

}

