/** Classe SuiteDeBase. Classe concrète qui sert de base pour la classe Suite.
    Cette classe fournit les outils de base pour travailler sur des suites de Elt

	 @author  M.Marchand && S. Ferneeuw
	 @version  Mai 2011
 */

import java.util.*;

public class SuiteDeBase implements Cloneable, Iterable<Elt>{
	private Noeud tete;
	private Integer version = new Integer(0);
	private int taille = 0;

	public SuiteDeBase clone() {
		try {
			SuiteDeBase cl = (SuiteDeBase) super.clone();
			if (tete != null) {
				cl.tete = tete.clone();
			}
			return cl;
		} catch (CloneNotSupportedException e) {
			throw new InternalError();
		}
	}

	/** Constructeur vide */
	public SuiteDeBase() {
		this.tete = null;
	}

	/** Constructeur par recopie */
	public SuiteDeBase(SuiteDeBase s) {
		this();
		if (s == null) throw new IllegalArgumentException();
		SuiteDeBase aux = new SuiteDeBase();
		Iterator<Elt> it = s.iterator();
		while (it.hasNext()) {
			aux.ajouter(it.next());
		}
		while (!aux.estVide()) {
			this.ajouter(aux.tete());
			aux.couper();
		}
	}

	/** Constructeur à partir d'un Elt et d'une Suite */
	public SuiteDeBase(Elt t, SuiteDeBase c) {
		this(c);
		if (t == null) throw new IllegalArgumentException();
		this.ajouter(t);
	}

	/**
	 * Constructeur à partir d'une String; Accepte par exemple :
	 * "(15,6..9,12 15 MAXelt,10)" "(3,4,3 3" ou "3 4 3,3)" "()" ou ""
	 */
	public SuiteDeBase(String s) {
		this();
		if (s==null) throw new IllegalArgumentException();
		if (s.length() == 0)
			return;
		SuiteDeBase aux = new SuiteDeBase();
		if (s.charAt(0) == '(') {
			s = s.substring(1, s.length());
		}
		if (s.length() != 0 && s.charAt(s.length() - 1) == ')') {
			s = s.substring(0, s.length() - 1);
		}
		StringTokenizer stk = new StringTokenizer(s, "\t ,");
		String token;
		while (stk.hasMoreTokens()) {
			token = stk.nextToken();
			int posPointPoint = token.indexOf("..");
			if (posPointPoint > 0) {
				String debut = token.substring(0, posPointPoint);
				String fin = token.substring(posPointPoint + 2, token.length());
				int debutVal;
				int finVal;
				if (debut.toUpperCase().equals("MAXELT"))
					debutVal = Elt.MAXELT.val();
				else {
					try {
						debutVal = Integer.parseInt(debut);
					} catch (Exception e) {
						aux = new SuiteDeBase();
						throw new IllegalArgumentException("Entier non valide : " + debut
								+ " ");
					}
				}
				if (fin.toUpperCase().equals("MAXELT"))
					finVal = Elt.MAXELT.val();
				else {
					try {
						finVal = Integer.parseInt(fin);
					} catch (Exception e) {
						aux = new SuiteDeBase();
						throw new IllegalArgumentException("Enumération non valide : "
								+ token + " ");
					}
				}
				for (int ii = debutVal; ii <= finVal; ii++) {
					try {
						aux.ajouter(new Elt(ii));
					} catch (IllegalArgumentException me) {
						aux = new SuiteDeBase();
						throw me;
					}
				}
			} // if posPointPoint > 0
			else {
				int i;
				if (token.toUpperCase().equals("MAXELT"))
					i = Elt.MAXELT.val();
				else
					try {
						i = Integer.parseInt(token);
					} catch (Exception e) {
						aux = new SuiteDeBase();
						throw new IllegalArgumentException("Nombre entier incorrect : "
								+ token + " ");
					}

				try {
					aux.ajouter(new Elt(i));
				} catch (IllegalArgumentException me) {
					aux = new SuiteDeBase();
					throw me;
				}
			}
		}

		while (!aux.estVide()) {
			this.ajouter(aux.tete());
			aux.couper();
		}

	}

	/** Ajout en tête */
	public void ajouter(Elt e) {
		version = version + 1;
		SuiteDeBase copie = this.clone();
		tete = new Noeud();
		tete.element = e;
		tete.corps = copie;
		taille++;
	}

	/** Supprimer la tête */
	public void couper() {
		if (this.estVide())
			throw new MathException(
					"Opération illégale sur une Suite vide : couper().");
		version = version + 1;
		this.tete = this.tete.corps.tete;
		taille--;
	}

	/** Renvoie la t�te */
	public Elt tete() {
		if (this.estVide())
			throw new MathException(
					"Opération illégale sur une Suite vide : tête().");
		return this.tete.element;
	}

	/** Renvoie le corps */
	public SuiteDeBase corps() {
		if (this.estVide())
			throw new MathException(
					"Opération illégale sur une Suite vide : corps().");
		return this.tete.corps.clone();
	}

	/** Renvoie true ssi la Suite courante est vide */
	public boolean estVide() {
		return (this.tete == null);
	}

	/** Renvoie une description parenthèsée de la Suite courante */
	public String toString() {
		String str = "(";
		Noeud bal = this.tete;
		if (bal != null) {
			str += bal.element.toString();
			bal = bal.corps.tete;
		}
		while (bal != null) {
			str += "," + bal.element.toString();
			bal = bal.corps.tete;
		}
		return str + ")";
	}

	/** Renvoie un itérateur sur la Suite courante */
	public Iterator<Elt> iterator() {
		return new SuiteIterator();
	}

	public class SuiteIterator implements java.util.Iterator<Elt> {

		private Noeud bal;
		private Integer v;
		private int tailleDep = taille;
		private int indice =0;
		public SuiteIterator() {
			bal = tete;
			v = version;
		}

		public boolean hasNext() {
			return indice < tailleDep;
		}

		public Elt next() {
			if (v!=version)
				throw new ConcurrentModificationException();
			if (!hasNext())
				throw new NoSuchElementException("No such element!");
			Elt n = bal.element;
			bal = bal.corps.tete;
			indice++;
			return n;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	} // SuiteIterator

	private class Noeud implements Cloneable {
		private Elt element;
		private SuiteDeBase corps;

		@Override
		protected Noeud clone() {
			try {
				Noeud n = (Noeud) super.clone();
				if (corps != null) {
					n.corps = corps.clone();
				}
				return n;
			} catch (CloneNotSupportedException e) {
				throw new InternalError();
			}

		}
	}
} // class