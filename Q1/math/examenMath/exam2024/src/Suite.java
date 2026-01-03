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

	/** Constructeur à partir d'un Elt et d'une Suite */
	public Suite(Elt t, Suite c) {
		super(t, c);
	}

	/** Construit la Suite réduite à (x) */
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

	/* Renvoie l’indice jusqu’auquel les éléments de this sont strictement 
     * supérieurs aux éléments de s de même indice.
	 *
	 * @param Suite s
	 * @return l’indice jusqu’auquel les éléments de this sont strictement 
     *         supérieurs aux éléments de s de même indice
	 * @throw IllegalArgumentException en cas de paramètre invalide
     *
	 * Exemples :
	 * ----------
	 * this = ()                                 alors nbElementSuperieurEnTete(null)  --> IllegalArgumentException
	 * this = () et s = ()                       alors nbElementSuperieurEnTete(s) --> 0
	 * this = () et s = (7,2)                    alors nbElementSuperieurEnTete(s) --> 0
	 * this = (7,2) et s = ()                    alors nbElementSuperieurEnTete(s) --> 0
	 * this = (4,7,5,3) et s = (7,2)             alors nbElementSuperieurEnTete(s) --> 0
	 * this = (8,7,5,3,9) et s = (3,6,5)         alors nbElementSuperieurEnTete(s) --> 2
	 * this = (8,3,6) et s = (2,1,4,5,2)         alors nbElementSuperieurEnTete(s) --> 3
	 * this = (10,4,8,6,7,2) et s = (8,3,6,5)    alors nbElementSuperieurEnTete(s) --> 4
	 * this = (8,3,6,5,7,2) et s = (3,1,4,2,4,1) alors nbElementSuperieurEnTete(s) --> 6
	 **/
	public int nbElementsSuperieursEnTete(Suite s) {
		if (s == null) {
			throw new IllegalArgumentException("Paramètre invalide");
		}

		// Cas de base : si une des deux suites est vide, retourner 0
		if (this.estVide() || s.estVide()) {
			return 0;
		}

		// Comparer les têtes
		if (this.tete().val() > s.tete().val()) {
			// Si la tête de this est strictement supérieure à celle de s,
			// on compte 1 et on continue récursivement avec les corps
			return 1 + this.corps().nbElementsSuperieursEnTete(s.corps());
		} else {
			// Sinon, on s'arrête et on retourne 0
			return 0;
		}
	}
}


