import java.util.ArrayList;

public class TestSuite {

	public static final String RESET = "\033[0m";
	public static final String RED = "\033[0;31m";
	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("* Programme Test pour la classe Suite *");
		System.out.println("***************************************");
		System.out.println() ;
		System.out.println("Tests de la méthode nbElementsSuperieursEnTete :") ;
		System.out.println("================================================") ;
		System.out.println( );
		if (testNbElementsSuperieursEnTete())
			System.out.println("Les tests de la méthode nbElementsSuperieursEnTete ont réussi.");
		else
			System.out.println("Les tests de la méthode nbElementsSuperieursEnTete ont échoués.");
		System.out.println();
	}

	private static boolean testNbElementsSuperieursEnTete() {
		boolean testOK = true;

		System.out.println(" --------");
		System.out.println("| Test 1 |");
		System.out.println(" --------");

		Suite s = new Suite();
		Suite copieS = new Suite();

		try {
			s.nbElementsSuperieursEnTete(null) ;
			System.out.println("Attention il fallait une IllegalArgumentException car s est null !");
			testOK = false;
		} catch (IllegalArgumentException e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Mauvais type d'exception : Attendu IllegalArgumentException mais reçu : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 2 |");
		System.out.println(" --------");

		s = new Suite();
		copieS = new Suite();
		Suite s2 = new Suite() ;
		Suite copieS2 = new Suite();
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=0) {
				System.out.println("La suite "+s+" a en tête 0 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 3 |");
		System.out.println(" --------");

		s = new Suite();
		copieS = new Suite();
		s2 = new Suite("(7,2)") ;
		copieS2 = new Suite("(7,2)");
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=0) {
				System.out.println("La suite "+s+" a en tête 0 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 4 |");
		System.out.println(" --------");

		s = new Suite("(7,2)");
		copieS = new Suite("(7,2)");
		s2 = new Suite() ;
		copieS2 = new Suite();
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=0) {
				System.out.println("La suite "+s+" a en tête 0 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 5 |");
		System.out.println(" --------");
		s = new Suite("(4,7,5,3)");
		copieS = new Suite("(4,7,5,3)");
		s2 = new Suite("(7,2)") ;
		copieS2 = new Suite("(7,2)");
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=0) {
				System.out.println("La suite "+s+" a en tête 0 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 6 |");
		System.out.println(" --------");

		s = new Suite("(8,7,5,3,9)");
		copieS = new Suite("(8,7,5,3,9)");
		s2 = new Suite("(3,6,5)") ;
		copieS2 = new Suite("(3,6,5)");
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=2) {
				System.out.println("La suite "+s+" a en tête 2 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 7 |");
		System.out.println(" --------");

		s = new Suite("(8,3,6)");
		copieS = new Suite("(8,3,6)");
		s2 = new Suite("(2,1,4,5,2)") ;
		copieS2 = new Suite("(2,1,4,5,2)");
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=3) {
				System.out.println("La suite "+s+" a en tête 3 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 8 |");
		System.out.println(" --------");

		s = new Suite("(10,4,8,6,7,2)");
		copieS = new Suite("(10,4,8,6,7,2)");
		s2 = new Suite("(8,3,6,5)") ;
		copieS2 = new Suite("(8,3,6,5)");
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=4) {
				System.out.println("La suite "+s+" a en tête 4 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 8 |");
		System.out.println(" --------");
		s = new Suite("(8,3,6,5,7,2)");
		copieS = new Suite("(8,3,6,5,7,2)");
		s2 = new Suite("(3,1,4,2,4,1)") ;
		copieS2 = new Suite("(3,1,4,2,4,1)");
		try {
			int nbElSup = s.nbElementsSuperieursEnTete(s2) ;
			if (nbElSup!=6) {
				System.out.println("La suite "+s+" a en tête 6 éléments supérieurs à ceux de la suite "+ s2 );
				System.out.println("Or votre méthode dit qu'elle en a "+nbElSup) ;
				testOK = false ;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else if (sontDifferentes(s2, copieS2)) {
				System.out.println("Attention ! Votre méthode a modifié la suite passée en paramètre !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			System.out.println(RED) ;
			e.printStackTrace(System.out);
			System.out.println(RESET);
			testOK = false;
		}

		System.out.println() ;

		return testOK ;
	}

	private static boolean sontDifferentes(Suite s1, Suite s2) {
		ArrayList<Elt> listeAvant = new ArrayList<Elt>();
		s1.forEach(e -> listeAvant.add(e));
		ArrayList<Elt> listeApres = new ArrayList<Elt>();
		s2.forEach(e -> listeApres.add(e));
		return !listeAvant.equals(listeApres);
	}

}
