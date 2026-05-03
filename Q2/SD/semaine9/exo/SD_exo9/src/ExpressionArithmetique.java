import java.util.HashSet;

public class ExpressionArithmetique extends ArbreDeCaracteres {
	
	/**
	 * Cree une expression arithmetique a partir d'un arbre de caracteres
	 * @param a
	 */
	public ExpressionArithmetique(ArbreDeCaracteres a) {
		super(a);
	}

	public ExpressionArithmetique(char c) {
		super(c);
	}
	
	public ExpressionArithmetique(char c, ArbreDeCaracteres ag, ArbreDeCaracteres ad) {
		super(c, ag, ad);
	}
	// -------------------------------------------------------
	// Méthode utilitaire : est-ce un opérateur valide ?
	// On l'utilise pour valider le paramètre dans nombreOperations()
	// -------------------------------------------------------
	private boolean estOperateur(char c) {
		return c == '+' || c == '-' || c == '*' || c == '/';
	}
	
	/**
	 * calcule le nombre d'operations correspondant au type d'operateur passe en parametre que contient l'expression arithmetique
	 * Par ex : exp1 : + --> 1
	 *                 / --> 1
	 *                 ...
	 *          exp3 : + --> 4 
	 * @param operateur l'operateur verifie
	 * @return le nombre d'operations
	 * @throws IllegalArgumentException si le caractere passe en parametre n'est pas un operateur (+,-,*,/)
	 */
	public int nombreOperations(char operateur) {
		if (!estOperateur(operateur)) {
			throw new IllegalArgumentException(
					"'" + operateur + "' n'est pas un opérateur (+,-,*,/)");
		}
		return nombreOperations(racine, operateur);
	}

	private int nombreOperations(NoeudCaractere n, char operateur) {
		if (n == null) return 0;                              // arbre vide

		int courant = (n.caractere == operateur) ? 1 : 0;      // ce nœud compte-t-il ?

		return courant
				+ nombreOperations(n.gauche, operateur)          // sous-arbre gauche
				+ nombreOperations(n.droit,  operateur);         // sous-arbre droit
	}



	/**
	 * verifie si l'arbre ne contient que des additions
	 * Par ex : exp3 ne contient que des +
	 * @return true si l'expression arithmetique contient uniquement des additions, false sinon
	 */
	public boolean uniquementDesAdditions(){
		// TODO
		return uniquementDesAdditions(racine);// depart de la recur c est la racine
	}
	private boolean uniquementDesAdditions(NoeudCaractere n) {
		if (n == null) {
			return true;
		}
		if (estOperateur(n.caractere) && n.caractere != '+') {
			return false;
		}
		// Sinon on vérifie les deux sous-arbres avec &&
		// (si l'un des deux retourne false, tout retourne false)
		return uniquementDesAdditions(n.gauche)
				&& uniquementDesAdditions(n.droit);
	}
	/**
	 * calcule le nombre d'entiers differents contenus dans l'expression arithmetique
	 * Par ex : exp2 contient 3 entiers differents : 1, 4 et 8
	 * @return le nombre d'entiers differents
	 */
	public int nombreEntiersDifferents(){
		// piste de solution:
		// utilisez un ensemble (HashSet<Character>) dans lequel seront places les entiers contenus dans l'arbre
		// Grace a la caracteristique d'unicite d'un ensemble, ceux-ci n'y figureront qu'une fois
		// La taille de l'ensemble obtenu correspondra au nombre recherche

		//suggestion:
		//introduisez une methode void remplirEnsemble()
		// TODO
		HashSet<Character> ensemble = new HashSet<>();
		remplirEnsemble(racine, ensemble);
		return ensemble.size();
	}

	private void remplirEnsemble(NoeudCaractere n, HashSet<Character> ensemble) {
		if (n == null) return;                             // arbre vide : rien à faire

		// On ajoute uniquement les chiffres (feuilles), pas les opérateurs
		if (!estOperateur(n.caractere)) {
			ensemble.add(n.caractere);                     // HashSet ignore les doublons
		}

		remplirEnsemble(n.gauche, ensemble);
		remplirEnsemble(n.droit,  ensemble);
	}



	/**
	 * calcule la valeur de l'expression stockee dans l'arbre
	 * Par ex : exp1 --> 13
	 * @return le resultat 
	 */
	public double resultat() {
		// pour obtenir le chiffre : (int)element - '0'; 
		// car l'element est de type char
		// (int)'0' = 48  (int)'1' = 49  (int)'2' = 50 ...  (int)'9' = 57
		// Le cast (int) n'est pas obligatoire
		// TODO

		return resultat(racine);
	}

	private double resultat(NoeudCaractere n) {
		// Cas terminal : feuille = chiffre
		// '3' - '0' = 51 - 48 = 3
		if (!estOperateur(n.caractere)) {
			return n.caractere - '0';
		}

		double gauche = resultat(n.gauche);
		double droit  = resultat(n.droit);

		switch (n.caractere) {
			case '+': return gauche + droit;
			case '-': return gauche - droit;
			case '*': return gauche * droit;
			case '/': return gauche / droit;
			default:  throw new IllegalStateException("Opérateur inconnu : " + n.caractere);
		}
	}
	

	/**
	 * renvoie l'expression stockee dans l'arbre en notation infixe
	 * Par exp : exp1 --> ((3-2)+(4*(9/3)))
	 * @return la notation infixe
	 */
	public String notationInfixe() {
		// TODO
		return notationInfixe(racine);
	}

	private String notationInfixe(NoeudCaractere n) {
		if (n == null) return "";

		// Cas terminal : feuille = chiffre, on retourne juste le caractère
		if (!estOperateur(n.caractere)) {
			return String.valueOf(n.caractere);
		}

		// Nœud opérateur : (gauche  OP  droit)
		return "(" + notationInfixe(n.gauche)
				+ n.caractere
				+ notationInfixe(n.droit)
				+ ")";
	}
	
}

