package juin24;

import java.awt.*;
import java.util.HashMap;

public class FileAttenteAvecDesistementImpl<E> implements FileAttenteAvecDesistement<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	// N'ajoutez pas d'autres attributs

	public FileAttenteAvecDesistementImpl() {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		tete.suivant = queue;
		queue.precedent = tete;
	}

	// A NE PAS MODIFIER !
	// pour les tests
	public int taille () {
		return mapElementNoeud.size();
	}


	@Override
	public boolean enfile(E element) {
		//TODO
		if (element == null)
			throw new IllegalArgumentException();
		if (mapElementNoeud.containsKey(element))
			return false;

		// Créer le nouveau nœud
		Noeud noeud = new Noeud(element);

		// L'insérer juste avant la sentinelle de queue
		Noeud avant = queue.precedent;
		noeud.precedent = avant;
		noeud.suivant = queue;
		avant.suivant = noeud;
		queue.precedent = noeud;

		// L'enregistrer dans la map
		mapElementNoeud.put(element, noeud);
		return true;
	}

	@Override
	public E defile() {
		//TODO
		if (mapElementNoeud.isEmpty()) {
			return null;
		}
		Noeud supp = tete.suivant;
		//detache
		tete.suivant = supp.suivant;
		supp.suivant.precedent = tete;
		//retire
		mapElementNoeud.remove(supp.element);
		// return
		return supp.element;

	}

	@Override
	public boolean desister(E element) {
		//TODO
		if (!mapElementNoeud.containsKey(element)) {
			return false;
		}
		Noeud cible = mapElementNoeud.get(element);
		cible.precedent.suivant = cible.suivant;
		cible.suivant.precedent = cible.precedent;
		mapElementNoeud.remove(element);
		return true;

	}


	// A NE PAS MODIFIER !
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

	// A NE PAS MODIFIER !
	// pour les tests
	public FileAttenteAvecDesistementImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;
	}

	// A NE PAS MODIFIER !
	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
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

	// A NE PAS MODIFIER !
	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
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
