package math22;

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

	/** Constructeur à partir d'un math22.Elt et d'une math22.Suite */
	public Suite(Elt t, Suite c) {
		super(t, c);
	}

	/** Construit la math22.Suite réduite à (x) */
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

	/* Renvoie true si aucun élément de la suite n'est compris entre a et b
	 *         false sinon
	 * Précondition à ne pas vérifier : a<=b
	 * Exemples :
	 * ----------
	 * this = (1,5,6,10,3) alors aucunEntre(6,9)   --> false
	 * this = (1,5,6,10,3) alors aucunEntre(7,9)   --> true
	 * this = (1,5,6,10,3) alors aucunEntre(-5,-2) --> true
	 * this = (1,5,6,10,3) alors aucunEntre(-2,5)  --> false
	 * this = ()           alors aucunEntre(6,9)   --> true
	 * @param int a : borne inférieure
	 * @param int b : borne supérieure
	 * @return true si aucun élément de la suite courante n'est compris entre a et b
	 *         false sinon
	 */
	public boolean aucunEntre(int a, int b) {
		//TODO
		if (this.estVide())return true;

		// Vérifier si la tête est comprise entre a et b (inclus)
		int valeurTete = this.tete().val();
		if (valeurTete >= a && valeurTete <= b) {
			return false; // On a trouvé un élément entre a et b
		}

		// Continuer la recherche dans le reste de la suite
		return this.corps().aucunEntre(a, b);
	}

	/*  Renvoie true si la suite contient au moins n fois l'math22.Elt e et
	 *          false sinon
	 *  Exemples :
	 *  ----------
	 *  this = (3,7,7,12,7), n=2  et e=7     alors auMoinsNOccurences(n,e) --> true
	 *  this = (3,7,7,12,7), n=3  et e=7     alors auMoinsNOccurences(n,e) --> true
	 *  this = (3,7,7,12,7), n=4  et e=7     alors auMoinsNOccurences(n,e) --> false
	 *  this = (),           n=0  et e=2     alors auMoinsNOccurences(n,e) --> true
	 *  this = (),           n=1  et e=7     alors auMoinsNOccurences(n,e) --> false
	 *  this = (3,7,7,12,7), n=-1 et e=7     alors auMoinsNOccurences(n,e) --> IllegalArgumentException
	 *  this = (3,7,7,12,7), n=-8 et e=7     alors auMoinsNOccurences(n,e) --> IllegalArgumentException
	 *  this = (3,7,7,12,7), n=1  et e=null  alors auMoinsNOccurences(n,e) --> IllegalArgumentException
	 *
	 * @param int n : nombre minimum d'occurences de l'math22.Elt e
	 * @param math22.Elt e : élément de la suite dont on chercher n occurence(s)
	 * @return true  si la suite contient au moins n fois l'math22.Elt e
	 *         false sinon
	 * @throw IllegalArgumentException si n<0
	 * @throw IllegalArgumentException si e est null
	 */
	public boolean auMoinsNOccurences(int n, Elt e) {
		//TODO
		//verification 3amo
		if (n < 0)throw new IllegalArgumentException("voila c est moin que zero erreur ");
		if (e==null)throw new IllegalArgumentException("pos de null ici ta compris");
		// cas de base
		if (n == 0)return true;
		if (this.estVide())return false;
		// cas rekiki


		if (this.tete().equals(e)) return  this.corps().auMoinsNOccurences(n -1,e);
		else return this.corps().auMoinsNOccurences(n,e) ;
	}

} 

