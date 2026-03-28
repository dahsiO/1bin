public class FileImplChainee<E> implements File<E>{

	private Noeud tete;
	private Noeud queue;
	private int taille;

	public FileImplChainee(){
		tete=null;
		queue=null;
		taille=0;
	}

	public int taille(){
		return taille;
	}

	public boolean estVide(){
		return taille==0;
	}


	public E premier()throws FileVideException{
		//TODO
		if (taille == 0) {
			throw new FileVideException();
		}
		return tete.element;
	}


	public E defile() throws FileVideException{
		if (estVide()) {
			throw new FileVideException();
		}
		E element = tete.element;
		tete = tete.suivant;
		if (tete == null) {
			queue = null;
		}
		taille--;
		return element;
	}


	public void enfile(E element){
		Noeud nouveau = new Noeud(element);
		if (estVide()) {
			tete = nouveau;
			queue = nouveau;
		} else {
			queue.suivant = nouveau;
			queue = nouveau;
		}
		taille++;
	}



	


	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	// tete 'a' 'b' 'c' queue : ['a','b','c']
	public FileImplChainee(Object[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		this.taille = table.length;

		if(taille==0)
			return;
		queue = new Noeud((E)table[table.length-1],null);
		Noeud noeud = queue;
		for (int i = table.length-2; i>=0;i--) {
			noeud = new Noeud((E)table[i],noeud);
		}
		this.tete=noeud;
	}

	// A ne pas modifier ! Methode utilisee pour les tests
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				return "boucle infinie dans toString(), chainage a verifier";
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	// classe interne
	private class Noeud{
		private E element;
		private Noeud suivant;

		private Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
		
		private Noeud(E element){
			this.element = element;
			this.suivant = null;
		}

	}

} 



