package math22;

import java.util.ArrayList;
import java.util.Scanner;

public class TestSuite {
	private final static Scanner scanner = new Scanner(System.in);
	private static final String[] NOMS_METHODE = {"aucunEntre","auMoinsNOccurences" };

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("* Programme Test pour la classe math22.Suite *");
		System.out.println("***************************************");
		int choix ;
		while (true) {
			for (int i = 0; i < NOMS_METHODE.length; i++) {
				System.out.println((i + 1) + " -> Tester la méthode '" + NOMS_METHODE[i] + "'");
			}

			choix = scanner.nextInt();
			System.out.println() ;
			boolean testOK;
			switch (choix) {
				case 1:
					testOK = testAucunEntre();
					break;
				case 2:
					testOK = testAuMoinsNOccurences() ;
					break;
				default:
					return;
			}

			if (testOK)
				System.out.println("Les tests de la méthode " + NOMS_METHODE[choix - 1] + " ont réussi.");
			else
				System.out.println("Les tests de la méthode " + NOMS_METHODE[choix - 1] + " ont échoués.");
			System.out.println();
		}
	}

	private static boolean testAucunEntre() {
		boolean testOK = true;
		int temps = 300 ;

		System.out.print("Test 1 : ") ;

		Suite s = new Suite("(1,5,6,10,3)");
		Suite copieS = new Suite("(1,5,6,10,3)") ;
		try {
			if (s.aucunEntre(6,9)) {
				System.out.println("KO");
				System.out.println(s+".aucunEntrent(6,9) = false car la suite contient 6 ");
				System.out.println("Or votre méthode renvoie true");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 2 : ") ;

		s = new Suite("(1,5,6,10,3)");
		copieS = new Suite("(1,5,6,10,3)") ;
		try {
			if (!s.aucunEntre(7,9)) {
				System.out.println("KO");
				System.out.println(s+".aucunEntrent(7,9) = true car la suite n'a aucun élément entre 7 et 9.");
				System.out.println("Or votre méthode renvoie false");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 3 : ") ;

		s = new Suite("(1,5,6,10,3)");
		copieS = new Suite("(1,5,6,10,3)") ;
		try {
			if (!s.aucunEntre(-5,-2)) {
				System.out.println("KO");
				System.out.println(s+".aucunEntrent(-5,-2) = true car la suite n'a aucun élément entre -5 et -2.");
				System.out.println("Or votre méthode renvoie false");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 4 : ") ;

		s = new Suite("(1,5,6,10,3)");
		copieS = new Suite("(1,5,6,10,3)") ;
		try {
			if (s.aucunEntre(-2,5)) {
				System.out.println("KO");
				System.out.println(s+".aucunEntrent(-2,5) = false car la suite contient les éléments 1, 3 et 5.");
				System.out.println("Or votre méthode renvoie true");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 5 : ") ;

		s = new Suite();
		copieS = new Suite() ;
		try {
			if (!s.aucunEntre(6,9)) {
				System.out.println("KO");
				System.out.println(s+".aucunEntrent(6,9) = true car la suite n'a aucun élément entre 6 et 9.");
				System.out.println("Or votre méthode renvoie false");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		return testOK;
	}

	private static boolean testAuMoinsNOccurences() {
		boolean testOK = true;
		int temps = 300 ;

		System.out.print("Test 1 : ") ;

		Suite s = new Suite("(3,7,7,12,7)");
		Suite copieS = new Suite("(3,7,7,12,7)") ;
		try {
			s.auMoinsNOccurences(-1,new Elt(7));
			System.out.println("KO : ") ;
			System.out.println(s+".auMoinsNOccurences(-1,new math22.Elt(7)) : il fallait une exception car n<0") ;
			testOK=false ;
		} catch(IllegalArgumentException e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(-1) :") ;
			System.out.println("Attention ce n'est pas le bon type d'exception :");
			System.out.println("Attendu : IllegalArgumentExcepion") ;
			System.out.println("Reçu : "+e.getClass()) ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK=false ;
		}
		System.out.println() ;

		System.out.print("Test 2 : ") ;
		s = new Suite("(3,7,7,12,7)");
		copieS = new Suite("(3,7,7,12,7)") ;
		try {
			s.auMoinsNOccurences(-8,new Elt(7));
			System.out.println("KO : ") ;
			System.out.println(s+".auMoinsNOccurences(-1,new math22.Elt(7)) : il fallait une exception car n<0") ;
			testOK=false ;
		} catch(IllegalArgumentException e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(-1) :") ;
			System.out.println("Attention ce n'est pas le bon type d'exception :");
			System.out.println("Attendu : IllegalArgumentExcepion") ;
			System.out.println("Reçu : "+e.getClass()) ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK=false ;
		}
		System.out.println() ;

		System.out.print("Test 3 : ") ;
		s = new Suite("(3,7,7,12,7)");
		copieS = new Suite("(3,7,7,12,7)") ;
		try {
			s.auMoinsNOccurences(1, null);
			System.out.println("KO : ") ;
			System.out.println(s+".auMoinsNOccurences(1,null) : il fallait une exception car e est null") ;
			testOK=false ;
		} catch(IllegalArgumentException e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(-1) :") ;
			System.out.println("Attention ce n'est pas le bon type d'exception :");
			System.out.println("Attendu : IllegalArgumentExcepion") ;
			System.out.println("Reçu : "+e.getClass()) ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK=false ;
		}
		System.out.println() ;

		System.out.print("Test 4 : ") ;

		s = new Suite("(3,7,7,12,7)");
		copieS = new Suite("(3,7,7,12,7)") ;
		try {
			if (!s.auMoinsNOccurences(2,new Elt(7))) {
				System.out.println("KO") ;
				System.out.println("Attention ! La suite "+s+" contient 3 fois l'élément 7 !") ;
				System.out.println("Or votre méthode dit qu'elle ne contient pas au moins 2 fois l'élément 7 !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : "+s+".auMoinsNOccurences(2,new math22.Elt(7)) : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 5 : ") ;

		s = new Suite("(3,7,7,12,7)");
		copieS = new Suite("(3,7,7,12,7)") ;
		try {
			if (!s.auMoinsNOccurences(3,new Elt(7))) {
				System.out.println("KO") ;
				System.out.println("Attention ! La suite "+s+" contient 3 fois l'élément 7 !") ;
				System.out.println("Or votre méthode dit qu'elle ne contient pas au moins 3 fois l'élément 7 !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : "+s+".auMoinsNOccurences(3,new math22.Elt(7)) : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 6 : ") ;

		s = new Suite("(3,7,7,12,7)");
		copieS = new Suite("(3,7,7,12,7)") ;
		try {
			if (s.auMoinsNOccurences(4,new Elt(7))) {
				System.out.println("KO") ;
				System.out.println("Attention ! La suite "+s+" contient 3 fois l'élément 7 !") ;
				System.out.println("Or votre méthode dit qu'elle contient au moins 4 fois l'élément 7 !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : "+s+".auMoinsNOccurences(4,new math22.Elt(7)) : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 7 : ") ;

		s = new Suite();
		copieS = new Suite() ;
		try {
			if (!s.auMoinsNOccurences(0,new Elt(2))) {
				System.out.println("KO") ;
				System.out.println("Attention ! La suite "+s+" contient 0 fois l'élément 2 !") ;
				System.out.println("Or votre méthode dit qu'elle ne contient pas au moins 0 fois l'élément 2 !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : "+s+".auMoinsNOccurences(0,new math22.Elt(2)) : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		System.out.print("Test 8 : ") ;

		s = new Suite();
		copieS = new Suite() ;
		try {
			if (s.auMoinsNOccurences(1,new Elt(7))) {
				System.out.println("KO") ;
				System.out.println("Attention ! La suite "+s+" contient 0 fois l'élément 7 !") ;
				System.out.println("Or votre méthode dit qu'elle contient au moins 1 fois l'élément 7 !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("KO : Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("KO : "+s+".auMoinsNOccurences(1,new math22.Elt(7)) : Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}
		System.out.println() ;

		return testOK;
	}

	private static boolean sontDifferentes(Suite s1, Suite s2) {
		ArrayList<Elt> listeAvant = new ArrayList<Elt>();
		s1.forEach(e -> listeAvant.add(e));
		ArrayList<Elt> listeApres = new ArrayList<Elt>();
		s2.forEach(e -> listeApres.add(e));
		return !listeAvant.equals(listeApres);
	}


}
