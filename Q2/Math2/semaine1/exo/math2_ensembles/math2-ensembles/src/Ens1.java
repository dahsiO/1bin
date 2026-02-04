public class Ens1 extends EnsembleAbstrait {

	private boolean[] tabB; // e appartient � l'ensemble courant ssi tabE[e.val()] est � true.
	private int cardinal;

	public Ens1() {
		//TODO
			tabB = new boolean[MAX + 1];
			cardinal = 0;
	}
	
	public boolean estVide() {
		//TODO

		// engro  si le cardinal est egal a zero c est que c est vide non c est logique
		return cardinal == 0;
	}

	public Elt unElement() {
		//TODO
		if (estVide()) {
			throw new MathException("est vide");
		}
		//parcourt le tableau et renvoi le premiier element
		for (int i = 0; i < tabB.length; i++) {
			if (tabB[i]){
				return new Elt(i);
			}
		}
		//securiter pour pas planter le programme
		throw new MathException("est vide");
	}

	public boolean contient(Elt e) {
		//TODO
		//pour eviter les exeption au teste
		if (e == null) {
			throw new IllegalArgumentException("e est null");
		}
		//c est logique si la valeur de  l indice est true renvoie true sinon false
		return tabB[e.val()];
	}

	public void ajouter(Elt e) {
		//TODO
		
	}

	public void enlever(Elt e) {
		//TODO
		
	}

	public int cardinal() {
		//TODO
		return 0 ;
	}

	public void complementer() {
		//TODO
		
	}

	public String toString() {
		// TODO
		return null;
	}
	
}
