
// implementation de l'interface Ensemble via un tableau de booleens

public class EnsembleTableBooleens<E> implements Ensemble<E>{
   
 	private boolean[] table; 
	private int taille;

	// capacite = nombre d'elements de l'univers
	public EnsembleTableBooleens(int capacite){
        if(capacite<=0)
            throw new IllegalArgumentException();
		table = new boolean[capacite];	
		taille = 0;		
	}

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public EnsembleTableBooleens(){
        this(16);
    }

    public int taille(){
        // TODO
        return taille;
    }
	
	public boolean estVide(){
		// TODO

		return taille == 0; // true
	}

	public boolean contient(E element){
		// TODO
		//math.abs force la valeur a etre positif car le hash peut avoir une valeur negatif
		return table[Math.abs(element.hashCode()) % table.length];
	}

	public boolean ajouter(E element){
		// TODO

		int i = Math.abs(element.hashCode()) % table.length;
		if (table[i]) return false;
		table[i] = true;
		taille++;
		return true;
	}

	public boolean enlever(E element){
		// TODO
		int i = Math.abs(element.hashCode()) % table.length;
		if (!table[i]) return false;
		table[i] = false;
		taille--;
		return true;
	}



}