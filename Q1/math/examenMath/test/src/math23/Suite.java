package math23;

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

	/** Constructeur à partir d'un math23.Elt et d'une math23.Suite */
	public Suite(Elt t, Suite c) {
		super(t, c);
	}

	/** Construit la math23.Suite réduite à (x) */
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

	/* Renvoie true si l'math23.Elt x n'est jamais juste après l'math23.Elt y dans la suite courante
	 *         false sinon
	 * Exemples :
	 * ----------
	 * this = (1,2,2)        alors jamaisApres(null,3)   --> IllegalArgumentException
	 * this = (1,2,2)        alors jamaisApres(3,null)   --> IllegalArgumentException
	 * this = (3,6,4,3,6)    alors jamaisApres(3,4)      --> false
	 * this = (3,9,3,4,5,7)  alors jamaisApres(3,4)      --> true
	 * this = ()             alors jamaisApres(3,4)      --> true
	 * this = (7,8,4,6,10)   alors jamaisApres(3,4)      --> true
	 * this = (8,3,6,3,7,3)  alors jamaisApres(3,4)      --> true
	 * this = (8,3,6,3,7,3)  alors jamaisApres(3,3)      --> true
	 * this = (8,3,3,7,3)    alors jamaisApres(3,3)      --> false
	 * this = (8,9,12,4,3)   alors jamaisApres(3,4)      --> false
	 * this = (3)            alors jamaisApres(3,4)      --> true
	 * @param math23.Elt x
	 * @param math23.Elt y
	 * @return true si l'math23.Elt x n'est jamais après l'math23.Elt y dans la suite courante
	 *         false sinon
	 * @throw IllegalArgumentException en cas de paramètre invalide
	 */

	public boolean jamaisApres(Elt x, Elt y) {
		//TODO
		//verification des parametre mister white
		if (x == null || y == null) {
			throw new IllegalArgumentException("Paramètre invalide");
		}

		if (this.estVide() || this.corps().estVide()) {
			return true;
		}

		if (this.tete().val() == y.val() && this.corps().tete().val() == x.val()) {
			return false;
		}

		return this.corps().jamaisApres(x, y);
	}
} 

