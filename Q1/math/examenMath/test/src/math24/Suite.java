package math24;

public class Suite extends SuiteDeBase {

	// valeur numérique de MAXELT
	private static final int MAX = Elt.MAXELT.val();

	/** Constructeur vide */
	public Suite() {
		super();
	}

	/** Constructeur par recopie */
	public Suite(SuiteDeBase s) {
		super(s);
	}

	/** Constructeur à partir d'une String */
	public Suite(String st) {
		super(st);
	}

	/** Constructeur à partir d'un math24.math23.Elt et d'une math24.math23.Suite */
	public Suite(Elt t, Suite c) {
		super(t, c);
	}

	/** Construit la math24.math23.Suite réduite à (x) */
	public Suite(Elt x) {
		this();
		this.ajouter(x);
	}

	public Suite corps() {
		return (Suite) super.corps();
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		for (Elt e : this){
			result = result *prime + e.hashCode();
		}
		return result;
	}

	/* Renvoie true si l'math24.math23.Elt x est toujours juste avant l'math24.math23.Elt y dans la suite courante
	 *         false sinon
	 * Exemples :
	 * ----------
	 * this = (1,2,2)        alors toujoursAvant(null,3)  --> IllegalArgumentException
	 * this = (1,2,2)        alors toujoursAvant(3,null)  --> IllegalArgumentException
	 * this = (3,6,4,2,6)    alors toujoursAvant(3,4)     --> false
	 * this = (3,4,9,3,4)    alors toujoursAvant(3,4)     --> true
	 * this = ()             alors toujoursAvant(3,4)     --> true
	 * this = (7,8,4,6,10)   alors toujoursAvant(3,4)     --> true
	 * this = (8,3,4,3,4,3)  alors toujoursAvant(3,4)     --> false
	 * this = (8,3,4,3,4,3)  alors toujoursAvant(3,3)     --> false
	 * this = (8,3,3,4,2)    alors toujoursAvant(3,3)     --> false
	 * this = (8)            alors toujoursAvant(3,4)     --> true
	 * this = (3)            alors toujoursAvant(3,4)     --> false
	 * @param math24.math23.Elt x
	 * @param math24.math23.Elt y
	 * @return true si l'math24.math23.Elt x est toujours avant l'math24.math23.Elt y dans la suite courante
	 *         false sinon
	 * @throw IllegalArgumentException en cas de paramètre invalide
	 */

	public boolean toujoursAvant(Elt x, Elt y) {
		//TODO
		if (x == null || y == null) throw new IllegalArgumentException("null");
		if (this.estVide())return true;
		if (this.corps().estVide())return !this.tete().equals(x);
		if (this.tete().equals(x))if (!this.corps().tete().equals(y))return false;

		return this.corps().toujoursAvant(x,y);
	}

} 

