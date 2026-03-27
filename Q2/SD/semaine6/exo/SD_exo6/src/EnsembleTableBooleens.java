
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
        return 0;
    }
	
	public boolean estVide(){
		// TODO
		return false;
	}

	public boolean contient(E element){
		// TODO
		return false;
	}

	public boolean ajouter(E element){
		// TODO
        return false;
	}

	public boolean enlever(E element){
		// TODO
		return false;
	}



}