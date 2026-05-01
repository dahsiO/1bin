import java.util.HashMap;
import java.util.Iterator;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud teteS, queueS;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		//TODO

	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		//TODO
		return false;
	
	}

	public boolean contient (E element) {
		//TODO
		return false;

	}

	public E premier() {
		//TODO
		return null;

	}

	public E dernier() {
		//TODO
		return null;

	}

	public E donnerPrecedent (E element) {
		//TODO
		return null;

	}

	public E donnerSuivant (E element) {
		//TODO
		return null;

	}

	public boolean insererEnTete (E element){
		//TODO
		return false;

	}

	public boolean insererEnQueue (E element) {
		//TODO
		return false;

	}

	public boolean insererApres (E element, E elementAInserer) {
		//TODO
		return false;

	}

	public boolean insererAvant (E element, E elementAInserer) {
		//TODO
		return false;

	}


	public boolean supprimer (E element) {
		//TODO
		return false;

	}

	
	public boolean permuter (E element1, E element2) {

		//TODO
		return false;

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

	}

	public Iterator<E> iterator() {
		//TODO
		return null;
		// il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl();
		// completez la classe interne IterateurImpl !
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = teteS.suivant;
		while (baladeur != queueS) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}



	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl implements Iterator{

		private Noeud noeudCourant;

		private IterateurImpl() {
			//TODO

		}

		public boolean hasNext() {
			//TODO
			return false;

		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			//TODO
			return null;

		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		teteS = new Noeud();   // sentinelle de tete
		queueS = new Noeud();  // sentinelle de queue
		Noeud prec = teteS;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queueS;
		queueS.precedent = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = teteS.suivant;
			int cpt=0;
			while (baladeur != queueS) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queueS.precedent;
			int cpt=0;
			while (baladeur != teteS) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

}
