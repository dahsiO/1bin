import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArbreDEntiers implements Iterable<Integer>{
	protected NoeudEntier racine; 
	protected int taille;
	
	public ArbreDEntiers () {
		this.racine=null ;
		this.taille=0;
	}

	public ArbreDEntiers (int entier) {
		this.racine=new NoeudEntier(entier) ;
		this.taille=1;
	}
	
	public ArbreDEntiers (ArbreDEntiers gauche, int entier, ArbreDEntiers droit) {
		this.racine=new NoeudEntier(gauche.racine,entier,droit.racine) ;
		this.taille= 1 + gauche.taille + droit.taille;
	}

	public boolean estVide () {
		return  this.racine == null;
	}

	public int taille () {
		return taille;
	}

	public Iterator<Integer> preIterateur () {
		return new PreIterateur();
	}
	
	public Iterator<Integer> postIterateur () {
		//Cet iterateur s�implemente de facon similaire a l�iterateur en pre-ordre.
		//TODO
		return new PostIterateur();
	}

	// iterateur in ordre
	// Cet iterateur a ete selectionne comme iterateur par defaut
	public Iterator<Integer> iterator () {
		return new InIterateur();
		//Cet iterateur s�implemente de facon similaire a l�iterateur en pre-ordre.
		//TODO
	}
	
	public Iterator<Integer> iterateurParNiveau () {
		return new IterateurParNiveau();
		//Cet iterateur s'implemente en utilisant une file de Noeud
		//Lisez bien l'enonce
		//TODO
	}
	
	
	protected class NoeudEntier {
		protected int entier; 
		protected NoeudEntier gauche;
		protected NoeudEntier droit;

		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
		}
		
		private NoeudEntier (NoeudEntier g,int entier,NoeudEntier d) {
			this.entier = entier;
			this.gauche = g;
			this.droit = d;
		}
	}
	
	private class PreIterateur implements Iterator<Integer> {
		
		private ArrayDeque<Integer> fileDEntiers;
		
		public PreIterateur () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(racine);
			//La classe PreIterator possede un attribut : une file d�entiers (ArrayDeque<Integer>).
			//Le constructeur de la classe va s�occuper de remplir cette file avec tous les entiers contenus dans l�arbre.
			//Il construit la file et appelle la methode recursive remplirFile()
		}
		
		private void remplirFile (NoeudEntier n) {
			// TODO
			//C�est la methode remplirFile() qui se charge de remplir la file.
			//Il s�agit d�une methode recursive !
			//Le but de cet iterateur est de parcourir l�arbre en pre-ordre !
			//Il faut donc � enfiler � les objets dans la file de facon a respecter ce parcours.
			if (n == null) return;
			fileDEntiers.add(n.entier);
			remplirFile(n.gauche);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
			// TODO
			//cette methode verifie si la file est non vide.
		}

		public Integer next () {
			if (!hasNext()) throw new NoSuchElementException();
			return fileDEntiers.poll();
		}
	}
	private class PostIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public PostIterateur () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(racine);
		}

		private void remplirFile (NoeudEntier n) {
			if (n == null) return;
			remplirFile(n.gauche);
			remplirFile(n.droit);
			fileDEntiers.add(n.entier);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if (!hasNext()) throw new NoSuchElementException();
			return fileDEntiers.poll();
		}
	}

	private class InIterateur implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public InIterateur () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile(racine);
		}

		private void remplirFile (NoeudEntier n) {
			if (n == null) return;
			remplirFile(n.gauche);
			fileDEntiers.add(n.entier);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if (!hasNext()) throw new NoSuchElementException();
			return fileDEntiers.poll();
		}
	}

	private class IterateurParNiveau implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public IterateurParNiveau () {
			fileDEntiers = new ArrayDeque<Integer>(taille);
			remplirFile();
		}

		private void remplirFile () {
			if (racine == null) return;
			ArrayDeque<NoeudEntier> fileDeTravail = new ArrayDeque<NoeudEntier>();
			fileDeTravail.add(racine);
			while (!fileDeTravail.isEmpty()) {
				NoeudEntier courant = fileDeTravail.poll();
				fileDEntiers.add(courant.entier);
				if (courant.gauche != null) fileDeTravail.add(courant.gauche);
				if (courant.droit != null) fileDeTravail.add(courant.droit);
			}
		}

		public boolean hasNext () {
			return !fileDEntiers.isEmpty();
		}

		public Integer next () {
			if (!hasNext()) throw new NoSuchElementException();
			return fileDEntiers.poll();
		}
	}

}
