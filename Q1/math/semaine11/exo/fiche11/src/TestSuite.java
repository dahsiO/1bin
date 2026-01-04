import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class TestSuite {
	private final static Scanner scanner = new Scanner(System.in);
	private static final String[] NOMS_METHODE = { "longueur", "contient", "nombreOccur", "position", "i_eme",
			"dernier", "equals", "prefixe", "sousSuite", "ajouter", "ajouterALEnvers", "inverse", "reduite",
			"tronquee","moinsPremOcc", "moinsToutesOcc", "doublons", "auMoinsK", "tousDistinct", "substitut","estTriee" };

	public static void main(String[] args) {
		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe Suite");
		System.out.println("**************************************");
		int choix = 0;
		while (true) {
			for (int i = 0; i < NOMS_METHODE.length; i++) {
				System.out.println((i + 1) + " -> Tester la méthode '" + NOMS_METHODE[i] + "'");
			}

			choix = scanner.nextInt();
			boolean testOK;
			switch (choix) {
			case 1:
				testOK = testLongueur();
				break;
			case 2:
				testOK = testContient();
				break;
			case 3:
				testOK = testNombreOccur();
				break;
			case 4:
				testOK = testPosition();
				break;
			case 5:
				testOK = testI_eme();
				break;
			case 6:
				testOK = testDernier();
				break;
			case 7:
				testOK = testEquals();
				break;
			case 8:
				testOK = testPrefixe();
				break;
			case 9:
				testOK = testSousSuite();
				break;
			case 10:
				testOK = testAjouter();
				break;
			case 11:
				testOK = testAjouterALEnvers();
				break;
			case 12:
				testOK = testInverse();
				break;
			case 13:
				testOK = testReduite();
				break;
			case 14:
				testOK = testTronquee();
				break;
			case 15 :	
				testOK = testMoinsPremOcc();
				break;
			case 16:
				testOK = testMoinsToutesOcc();
				break;
			case 17:
				testOK = testDoublons();
				break;
			case 18:
				testOK = testAuMoinsK();
				break;
			case 19:
				testOK = testTousDistincts();
				break;
			case 20:
				testOK = testSubstitut();
				break;
			case 21:
				testOK = testEstTriee();
				break;
			default:
				return;
			}
			System.out.println() ;
			if (testOK)
				System.out.println("Le test de la méthode " + NOMS_METHODE[choix - 1] + " a réussi.");
			else
				System.out.println("Le test de la méthode " + NOMS_METHODE[choix - 1] + " a échoué.");
			System.out.println() ;
		}
	}

	private static boolean testLongueur() {
		boolean testOK = true;
		Suite s = new Suite();
		int longueur = s.longueur();
		if (longueur != 0) {
			testOK = false;
			System.out.println("La longueur de la suite s est de 0.");
			System.out.println("Votre méthode a renvoyé : " + longueur);
		}
		for (int i = 1; i <= Elt.MAXELT.val(); i++)
			s.ajouter(new Elt(i));
		Suite copie = new Suite(s);
		longueur = s.longueur();
		if (longueur != Elt.MAXELT.val()) {
			testOK = false;
			System.out.println("La longueur de la suite" + s + " est de " + Elt.MAXELT.val() + ".");
			System.out.println("Votre méthode a renvoyé : " + longueur);
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode longueur a modifié la suite courante !");
			}
		}

		return testOK;
	}

	private static boolean testContient() {
		boolean testOK = true;
		Suite s = new Suite();
		try {
			s.contient(null);
			System.out.println(
					"Appel de la méthode contient avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Elt e = new Elt(10);
		if (s.contient(e)) {
			testOK = false;
			System.out.println("La suite vide ne contient pas l'élément 10 et votre méthode renvoie true");
		}
		s = new Suite("5,8,12,8,5,14");
		Suite copie = new Suite(s);
		if (s.contient(e)) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas l'Elt " + e);
			System.out.println("Votre méthode contient a renvoyé true au lieu de false");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode longueur a modifié la suite courante !");
			}
		}
		s = new Suite("5,8,12,10,5,14");
		copie = new Suite(s);
		if (!s.contient(e)) {
			testOK = false;
			System.out.println("La suite " + s + " contient l'Elt " + e);
			System.out.println("Votre méthode contient a renvoyé false au lieu de true");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode longueur a modifié la suite courante !");
			}
		}
		return testOK;
	}

	private static boolean testNombreOccur() {
		boolean testOK = true;
		Suite s = new Suite();
		try {
			s.nombreOccur(null);
			System.out.println(
					"Appel de la méthode nombreOccur avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}

		Elt e = new Elt(10);
		int nbOccur = s.nombreOccur(e);
		if (nbOccur != 0) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas l'Elt " + e);
			System.out.println("Votre méthode a renvoyé " + nbOccur + " au lieu de 0");
		}
		s = new Suite("5,8,12,8,5,14");
		Suite copie = new Suite(s);
		nbOccur = s.nombreOccur(e);
		if (nbOccur != 0) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas l'Elt " + e);
			System.out.println("Votre méthode a renvoyé " + nbOccur + " au lieu de 0");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode nombreOccur a modifié la suite courante !");
			}
		}
		s = new Suite("10,10,12,10,5,14,6,10");
		copie = new Suite(s);
		nbOccur = s.nombreOccur(e);
		if (nbOccur != 4) {
			testOK = false;
			System.out.println("La suite " + s + " contient 4 fois l'Elt " + e);
			System.out.println("Votre méthode a renvoyé " + nbOccur + " au lieu de 4");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode nombreOccur a modifié la suite courante !");
			}
		}

		return testOK;
	}

	private static boolean testPosition() {
		boolean testOK = true;
		Suite s = new Suite();
		try {
			s.position(null);
			System.out.println(
					"Appel de la méthode position avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Elt e = new Elt(10);
		int pos = s.position(e);
		if (pos != 0) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas l'Elt " + e);
			System.out.println("Votre méthode a renvoyé " + pos + " au lieu de 0");
		}
		s = new Suite("5,8,12,8,5,14");
		Suite copie = new Suite(s);

		pos = s.position(e);
		if (pos != 0) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas l'Elt " + e);
			System.out.println("Votre méthode a renvoyé " + pos + " au lieu de 0");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode position a modifié la suite courante !");
			}
		}

		s = new Suite("10,10,12,10,5,14,6,10");
		copie = new Suite(s);
		pos = s.position(e);
		if (pos != 1) {
			testOK = false;
			System.out.println("L'Elt " + e + " se trouve en première position de la suite " + s);
			System.out.println("Votre méthode a renvoyé " + pos + " au lieu de 1");
		}

		s = new Suite("8,7,12,4,5,14,6,15,31,34,8,10");
		copie = new Suite(s);
		pos = s.position(e);
		if (pos != 12) {
			testOK = false;
			System.out.println("L'Elt " + e + " se trouve en douzième position de la suite " + s);
			System.out.println("Votre méthode a renvoyé " + pos + " au lieu de 12");
		}
		return testOK;
	}

	private static boolean testI_eme() {
		boolean testOK = true;
		Suite s = new Suite();
		try {
			s.iEme(1);
			testOK = false;
			System.out.println(
					"On a demandé le premier élément de la suite vide -> Il fallait lancer une IllegalArgumentException.");
		} catch (IllegalArgumentException e) {

		}
		s = new Suite("26,7,12,4,5,14,6,15,31,34,8,10");
		Suite copie = new Suite(s);
		try {
			s.iEme(0);
			testOK = false;
			System.out.println(
					"On a demandé le 0ème élément d'une suite -> Il fallait lancer une IllegalArgumentException.");
		} catch (IllegalArgumentException e) {

		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode i_eme a modifié la suite courante !");
			}
		}
		try {
			s.iEme(-2);
			testOK = false;
			System.out.println(
					"On a demandé le -2ème élément d'une suite -> Il fallait lancer une IllegalArgumentException.");
		} catch (IllegalArgumentException e) {

		}
		Elt resultat = s.iEme(1);
		Elt attendu = new Elt(26);
		if (!resultat.equals(attendu)) {
			testOK = false;
			System.out.println("On a demandé le 1er élément de " + s + ".");
			System.out.println("Le résultat attendu est " + attendu);
			System.out.println("Votre méthode a renvoyé + " + resultat);
		}
		resultat = s.iEme(6);
		attendu = new Elt(14);
		if (!resultat.equals(attendu)) {
			testOK = false;
			System.out.println("On a demandé le 1er élément de " + s + ".");
			System.out.println("Le résultat attendu est " + attendu);
			System.out.println("Votre méthode a renvoyé + " + resultat);
		}
		resultat = s.iEme(12);
		attendu = new Elt(10);
		if (!resultat.equals(attendu)) {
			testOK = false;
			System.out.println("On a demandé le 1er élément de " + s + ".");
			System.out.println("Le résultat attendu est " + attendu);
			System.out.println("Votre méthode a renvoyé + " + resultat);
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode i_eme a modifié la suite courante !");
			}
		}
		try {
			s.iEme(13);
			testOK = false;
			System.out.println("On a demandé le 13ème élément de la suite " + s
					+ " -> Il fallait lancer une IllegalArgumentException.");
		} catch (IllegalArgumentException e) {

		}
		return testOK;
	}

	private static boolean testDernier() {
		boolean testOK = true;
		// test avec la suite vide
		Suite s = new Suite();

		try {
			s.dernier();
			testOK = false;
			System.out.println(
					"On a demandé le dernier élément de la suite vide --> Il fallait lancer une MathException.");
		} catch (MathException e) {

		}
		// test avec la suite (5)
		s = new Suite("5");
		Elt dernier = s.dernier();
		if (!dernier.equals(new Elt(5))) {
			testOK = false;
			System.out.println("Le dernier élément de " + s + " est 5.");
			System.out.println("Votre méthode renvoie : " + dernier);
		}
		// test avec la suite (4,8,2,9,15,5,7)
		s = new Suite("4,8,2,9,15,5,7");
		Suite copie = new Suite(s);
		dernier = s.dernier();
		if (!dernier.equals(new Elt(7))) {
			testOK = false;
			System.out.println("Le dernier élément de " + s + " est 7.");
			System.out.println("Votre méthode renvoie : " + dernier);
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode dernier a modifié la suite courante !");
			}
		}
		return testOK;
	}

	private static boolean testEquals() {
		boolean testOK = true;
		Suite s1 = new Suite();
		if (s1.equals(null)) {
			testOK = false;
			System.out.println("Appel de la méthode equals avec un paramètre null --> Il fallait renvoyer false.");
		}
		s1 = new Suite("(5)");
		if (s1.equals(new Elt(5))) {
			testOK = false;
			System.out
					.println("Appel de la méthode equals avec un paramètre de type Elt --> Il fallait renvoyer false.");
		}
		if (s1.equals("(5)")) {
			testOK = false;
			System.out.println(
					"Appel de la méthode equals avec un paramètre de type String --> Il fallait renvoyer false.");
		}

		s1 = new Suite();
		Suite s2 = new Suite();
		if (!s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce la non égalité");
		}
		s1 = new Suite("5,8,12,8,5,14");
		Suite copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,8,5,14");
		Suite copieS2 = new Suite(s2);
		if (!s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce la non égalité");
		}
		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode dernier a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode dernier a modifié la suite passée en paramètre !");
			}
		}
		s1 = new Suite("5");
		s2 = new Suite("5");
		if (!s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce la non égalité");
		}
		s1 = new Suite("5,8,13");
		s2 = new Suite("5,8,12");
		if (s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce l'égalité");
		}
		s1 = new Suite("5,8,13");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,13,15");
		copieS2 = new Suite(s2);
		if (s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce l'égalité");
		}
		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode dernier a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode dernier a modifié la suite passée en paramètre !");
			}
		}
		s1 = new Suite("5,8,13");
		s2 = new Suite("4,8,13");
		if (s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce l'égalité");
		}
		s1 = new Suite("5,8,13,15");
		s2 = new Suite("5,8,13");
		if (s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce l'égalité");
		}

		s1 = new Suite("2,1,33");
		s2 = new Suite("1,33,2");
		if (s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce l'égalité");
		}

		s1 = new Suite("2,3");
		s2 = new Suite("1,34");
		if (s1.equals(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas égale à la suite " + s2);
			System.out.println("Attention, votre méthode annonce l'égalité");
		}

		return testOK;

	}

	private static boolean testPrefixe() {
		boolean testOK = true;
		Suite s1 = new Suite();
		try {
			s1.prefixe(null);
			System.out.println(
					"Appel de la méthode prefixe avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Suite s2 = new Suite();
		// cas où les deux suites sont vides
		if (!s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est préfixe de la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas un préfixe");
		}
		//  test que () est préfixe de (5,8,12,8,5,14)
		s2 = new Suite("5,8,12,8,5,14");
		if (!s1.prefixe(s2)){
			testOK = false;
			System.out.println("La suite " + s1 + " est préfixe de la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas un préfixe");
		}
		// test que (5,8,12,8,5,14) est préfixe de (5,8,12,8,5,14)
		s1 = new Suite("5,8,12,8,5,14");
		Suite copieS1 = new Suite(s1);
		Suite copieS2 = new Suite(s2);
		if (!s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est préfixe de la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas un préfixe");
		}
		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode prefixe a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode prefixe a prefixe la suite passée en paramètre !");
			}
		}
		// test que () est préfixe de ("5,2,7")
		s1 = new Suite();
		s2 = new Suite("5,2,7");
		if (!s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est préfixe à la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas un préfixe");
		}

		// test que (5,2,7) n'est pas préfixe de ()
		s1 = new Suite("5,2,7");
		s2 = new Suite();
		if (s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas un préfixe à la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle est un préfixe");
		}

		// test que (5,8,13) n'est pas préfixe de (5,8,12,5,8,13)
		s1 = new Suite("5,8,13");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,5,8,13");
		copieS2 = new Suite(s2);
		if (s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas préfixe de la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle est un préfixe.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode prefixe a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode prefixe a modifié la suite passée en paramètre !");
			}
		}

		// test que (5,8,13) est un préfixe de (5,8,13,15)
		s1 = new Suite("5,8,13");
		s2 = new Suite("5,8,13,15");
		if (!s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est un préfixe de la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas un préfixe.");
		}

		// test que (5,8,13,15) n'est pas un préfixe de (5,8,13)
		s1 = new Suite("5,8,13,15");
		s2 = new Suite("5,8,13");
		if (s1.prefixe(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas un préfixe de la suite " + s2);
			System.out.println("Attention, votre méthode annonce qu'elle est un préfixe");
		}
		return testOK;
	}

	private static boolean testSousSuite() {
		boolean testOK = true;
		Suite s1 = new Suite();
		try {
			s1.sousSuite(null);
			System.out.println(
					"Appel de la méthode sousSuite avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Suite s2 = new Suite();
		// cas où les deux suites sont vides
		if (!s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas une sous-suite.");
		}
		// test que (5,8,12,8,5,14) est sous-suite de (5,8,12,8,5,14)
		s1 = new Suite("5,8,12,8,5,14");
		Suite copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,8,5,14");
		Suite copieS2 = new Suite(s2);
		if (!s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas une sous-suite.");
		}
		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}
		// test que () est sous-suite de ("5,2,7")
		s1 = new Suite();
		s2 = new Suite("5,2,7");
		if (!s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas une sous-suite");
		}

		// test que (5,2,7) n'est pas une sous-suite de ()
		s1 = new Suite("5,2,7");
		s2 = new Suite();
		if (s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas une sous-suite à la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle est une sous-suite.");
		}

		// test que (5,8,13) est une sous-suite de (5,8,12,5,8,13,4,6)
		s1 = new Suite("5,8,13");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,5,8,13,4,6");
		copieS2 = new Suite(s2);
		if (!s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas une sous-suite.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		// test que (5,8,4) est une sous-suite de (5,8,12,5,8,13,4,6)
		s1 = new Suite("5,8,4");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,5,8,13,4,6");
		copieS2 = new Suite(s2);
		if (!s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas une sous-suite.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		// test que (1,5,8) n'est pas une sous-suite de (5,8,12,5,8,1,4,6)
		s1 = new Suite("1,5,8");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,5,8,1,4,6");
		copieS2 = new Suite(s2);
		if (s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle est une sous-suite.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		// test que (5,8,1) n'est pas une sous-suite de (5,8,12,5,8,13,4,6)
		s1 = new Suite("5,8,1");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,12,5,8,13,4,6");
		copieS2 = new Suite(s2);
		if (s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle est une sous-suite.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		// test que (1,5,7) n'est pas une sous-suite de (1,5,8)
		s1 = new Suite("1,5,7");
		copieS1 = new Suite(s1);
		s2 = new Suite("1,5,8");
		copieS2 = new Suite(s2);
		if (s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle est une sous-suite.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		// test que (5,8,13) est une sous-suite de (5,8,13,15)
		s1 = new Suite("5,8,13");
		s2 = new Suite("5,8,13,15");
		if (!s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " est une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle n'est pas une sous-suite.");
		}

		// test que (1,5,8) n'est pas une sous-suite de (2,5,8)
		s1 = new Suite("1,5,8");
		copieS1 = new Suite(s1);
		s2 = new Suite("2,5,8");
		copieS2 = new Suite(s2);
		if (s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas une sous-suite de la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle est une sous-suite.");
		}

		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		// test que (5,8,12,5,8,13,4,6) n'est pas une sous-suite de (5,8,13)
		s1 = new Suite("5,8,12,5,8,13,4,6");
		copieS1 = new Suite(s1);
		s2 = new Suite("5,8,13");
		copieS2 = new Suite(s2);
		if (s1.sousSuite(s2)) {
			testOK = false;
			System.out.println("La suite " + s1 + " n'est pas une sous-suite à la suite " + s2 + ".");
			System.out.println("Attention, votre méthode annonce qu'elle est une sous-suite.");
		}
		if (testOK) {
			if (sontDifferentes(copieS1, s1)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sontDifferentes(copieS2, s2)) {
				testOK = false;
				System.out.println("La méthode sousSuite a modifié la suite passée en paramètre !");
			}
		}

		return testOK;

	}

	private static boolean testAjouter() {
		boolean testOK = true;
		Suite s = new Suite();
		Suite sAjoutee = null;
		try {
			s.ajouter(sAjoutee);
			System.out.println(
					"Appel de la méthode ajouter avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Suite copieS = new Suite(s);
		sAjoutee = new Suite();
		Suite sResultat = new Suite();
		s.ajouter(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " est la suite "
					+ sResultat + ".");
			System.out.println("Attention, votre méthode donne la suite " + s + ".");
		}
		s = new Suite("5,6,7,8");
		copieS = new Suite(s);
		sAjoutee = new Suite();
		sResultat = new Suite("5,6,7,8");
		s.ajouter(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " est la suite "
					+ sResultat + ".");
			System.out.println("Attention, votre méthode donne la suite " + s + ".");
		}
		s = new Suite("5,6,7,8");
		copieS = new Suite(s);
		sAjoutee = new Suite("1,2,3,4");
		Suite copieSAjoutee = new Suite(sAjoutee);
		sResultat = new Suite("1,2,3,4,5,6,7,8");
		s.ajouter(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " est la suite "
					+ sResultat + ".");
			System.out.println("Attention, votre méthode donne la suite " + s + ".");
		}
		if (testOK) {
			if (sontDifferentes(copieSAjoutee, sAjoutee)) {
				testOK = false;
				System.out.println("La méthode ajouter a modifié la suite passée en paramètre !");
			}
		}
		s = new Suite();
		copieS = new Suite(s);
		sAjoutee = new Suite("1,2,3,25,7");
		sResultat = new Suite("1,2,3,25,7");
		s.ajouter(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println(
					"La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " est la suite " + sResultat);
			System.out.println("Attention, votre méthode donne la suite " + s);
		}
		return testOK;
	}

	private static boolean testAjouterALEnvers() {
		boolean testOK = true;
		Suite s = new Suite();
		Suite sAjoutee = null;
		try {
			s.ajouterALEnvers(sAjoutee);
			System.out.println(
					"Appel de la méthode ajouterALEnvers avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Suite copieS = new Suite(s);
		sAjoutee = new Suite();
		Suite sResultat = new Suite();
		s.ajouterALEnvers(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " à l'envers "
					+ " est la suite " + sResultat + ".");
			System.out.println("Attention, votre méthode donne la suite " + s + ".");
		}
		s = new Suite("5,6,7,8");
		copieS = new Suite(s);
		sAjoutee = new Suite();
		sResultat = new Suite("5,6,7,8");
		s.ajouterALEnvers(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " à l'envers "
					+ " est la suite " + sResultat + ".");
			System.out.println("Attention, votre méthode donne la suite " + s + ".");
		}
		s = new Suite("5,6,7,8");
		copieS = new Suite(s);
		sAjoutee = new Suite("1,2,3,4");
		Suite copieSAjoutee = new Suite(sAjoutee);
		sResultat = new Suite("4,3,2,1,5,6,7,8");
		s.ajouterALEnvers(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " à l'envers "
					+ " est la suite " + sResultat + ".");
			System.out.println("Attention, votre méthode donne la suite " + s + ".");
		}
		if (testOK) {
			if (sontDifferentes(copieSAjoutee, sAjoutee)) {
				testOK = false;
				System.out.println("La méthode ajouter a modifié la suite passée en paramètre !");
			}
		}
		s = new Suite();
		copieS = new Suite(s);
		sAjoutee = new Suite("1,2,3,25,7");
		sResultat = new Suite("7,25,3,2,1");
		s.ajouterALEnvers(sAjoutee);
		if (sontDifferentes(s, sResultat)) {
			testOK = false;
			System.out.println("La suite " + copieS + " à laquelle on ajoute la suite " + sAjoutee + " à l'envers "
					+ " est la suite " + sResultat);
			System.out.println("Attention, votre méthode donne la suite " + s);
		}
		return testOK;
	}

	private static boolean testInverse() {
		boolean testOK = true;
		// test avec une suite vide
		Suite s = new Suite();
		Suite copie = new Suite(s);
		Suite sInversee = new Suite();
		Suite sRenvoyee = s.inverse();
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this !");
		}
		if (sontDifferentes(sInversee, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite inversee de " + s + " est égale à la suite " + sInversee + ".");
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee + ".");
		}
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("Vous avez modifié la suite sur laquelle la méthode est appelée (this) !");
		}
		// test avec la suite ("5,6,7,8");
		s = new Suite("5,6,7,8");
		copie = new Suite(s);
		sInversee = new Suite("8,7,6,5");
		sRenvoyee = s.inverse();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this !");
			}
		}
		if (sontDifferentes(sInversee, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite inversee de " + s + " est égale à la suite " + sInversee + ".");
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee + ".");
		}
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("Vous avez modifié la suite sur laquelle la méthode est appelée (this) !");
		}
		return testOK;
	}

	private static boolean testReduite() {
		boolean testOK = true;
		Suite s = new Suite();
		Suite sRenvoyee = s.reduite();
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this!");
		}
		testOK = verifReduite(s, sRenvoyee);
		s = new Suite("7");
		sRenvoyee = s.reduite();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifReduite(s, sRenvoyee);
		s = new Suite("5,6,7,8");
		sRenvoyee = s.reduite();
		Suite copie = new Suite(s);
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifReduite(s, sRenvoyee);
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("La méthode reduite a modifié la suite courante !");
		}
		s = new Suite("5,6,5,8,5,6,1,1,6,5");
		copie = new Suite(s);
		sRenvoyee = s.reduite();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifReduite(s, sRenvoyee);
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode reduite a modifié la suite courante !");
			}
		}
		s = new Suite("5,5,5,5");
		sRenvoyee = s.reduite();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifReduite(s, sRenvoyee);
		return testOK;
	}
	private static boolean testTronquee() {
		boolean testOK = true;
		Suite s = new Suite();
		try {
			s.tronquee(-1);
			System.out.println("Appel de la méthode tronquée avec comme valeur -1 -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {
			
		}
		try {
			s.tronquee(0);
			System.out.println("Appel de la méthode tronquée avec comme valeur 0 -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {
			
		}
		Suite sRenvoyee = s.tronquee(2);
		Suite sTronquee = new Suite();
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this !");
		}
		if (sontDifferentes(sTronquee, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on tronque au à partir du deuxième élément donne " + sTronquee);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		s = new Suite("4,5,6,8,3");
		sTronquee = new Suite("4,5");
		sRenvoyee = s.tronquee(3);
		if (sontDifferentes(sTronquee, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on tronque au à partir du troisième élément donne " + sTronquee);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		sTronquee = new Suite();
		sRenvoyee = s.tronquee(1);
		if (sontDifferentes(sTronquee, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on tronque au à partir du premier élément donne " + sTronquee);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}	
		sTronquee = new Suite("4,5,6,8,3");
		sRenvoyee = s.tronquee(10);
		if (sontDifferentes(sTronquee, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on tronque au à partir du dixième élément donne " + sTronquee);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}	
		return testOK;
	}
	private static boolean testMoinsPremOcc() {
		boolean testOK = true;
		// test avec la suite vide
		Suite s = new Suite();
		try {
			s.moinsPremOcc(null);
			System.out.println(
					"Appel de la méthode moinsPremOcc avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Suite sMoinsPremOcc = new Suite();
		Suite sRenvoyee = s.moinsPremOcc(new Elt(3));
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this !");
		}
		if (sontDifferentes(sMoinsPremOcc, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on supprime la première occurrence de 3 est égale à " + sMoinsPremOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		// test avec la suite (5,6,7,8) et l'Elt 3
		s = new Suite("5,6,7,8");
		sMoinsPremOcc = new Suite("5,6,7,8");
		sRenvoyee = s.moinsPremOcc(new Elt(3));
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (sontDifferentes(sMoinsPremOcc, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on supprime la première occurrence de 3 est égale à " + sMoinsPremOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		// test avec la suite (5,3,7,3) et l'Elt 3
		s = new Suite("5,3,7,3");
		Suite copie = new Suite(s);
		sMoinsPremOcc = new Suite("5,7,3");
		sRenvoyee = s.moinsPremOcc(new Elt(3));
		if (sontDifferentes(sMoinsPremOcc, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on supprime la première occurrence de 3 est égale à " + sMoinsPremOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("La méthode moinsPremOcc a modifié la suite courante !");
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		// test avec la suite (3,5,7,3) et l'Elt 3
		s = new Suite("3,5,7,3");
		copie = new Suite(s);
		sMoinsPremOcc = new Suite("5,7,3");
		sRenvoyee = s.moinsPremOcc(new Elt(3));
		if (sontDifferentes(sMoinsPremOcc, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on supprime la première occurrence de 3 est égale à " + sMoinsPremOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode moinsPremOcc a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		// test avec la suite (5,8,7,3) et l'Elt 3
		s = new Suite("5,8,7,3");
		copie = new Suite(s);
		sMoinsPremOcc = new Suite("5,8,7");
		sRenvoyee = s.moinsPremOcc(new Elt(3));
		if (sontDifferentes(sMoinsPremOcc, sRenvoyee)) {
			testOK = false;
			System.out.println(
					"La suite " + s + " dont on supprime la première occurrence de 3 est égale à " + sMoinsPremOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode moinsPremOcc a modifié la suite courante !");
			}
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		return testOK;
	}

	private static boolean testMoinsToutesOcc() {
		boolean testOK = true;
		// test avec la suite vide
		Suite s = new Suite();
		Suite sMoinsTouteOcc = new Suite();
		try {
			s.moinsToutesOcc(null);
			System.out.println(
					"Appel de la méthode moinsToutesOcc avec un paramètre null -> Il fallait lancer une IllegalArgumentException.");
			testOK = false;
		} catch (IllegalArgumentException e) {

		}
		Suite sRenvoyee = s.moinsToutesOcc(new Elt(3));
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this!");
		}
		if (sontDifferentes(sMoinsTouteOcc, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dont on supprime tous les 3 est égale à " + sMoinsTouteOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		// test avec la suite (5,6,7,8) et l'Elt 3
		s = new Suite("5,6,7,8");
		sMoinsTouteOcc = new Suite("5,6,7,8");
		sRenvoyee = s.moinsToutesOcc(new Elt(3));
		if (sontDifferentes(sMoinsTouteOcc, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dont on supprime tous les 3 est égale à " + sMoinsTouteOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		// test avec la suite (5,3,7,3) et l'Elt 3
		s = new Suite("5,3,7,3");
		Suite copie = new Suite(s);
		sMoinsTouteOcc = new Suite("5,7");
		sRenvoyee = s.moinsToutesOcc(new Elt(3));
		if (sontDifferentes(sMoinsTouteOcc, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dont on supprime tous les 3 est égale à " + sMoinsTouteOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode moinsToutesOcc a modifié la suite courante !");
			}
		}
		// test avec la suite (3,5,7,3) et l'Elt 3
		s = new Suite("3,5,7,3");
		copie = new Suite(s);
		sMoinsTouteOcc = new Suite("5,7");
		sRenvoyee = s.moinsToutesOcc(new Elt(3));
		if (sontDifferentes(sMoinsTouteOcc, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dont on supprime tous les 3 est égale à " + sMoinsTouteOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode moinsToutesOcc a modifié la suite courante !");
			}
		}
		// test avec la suite (5,8,7,3) et l'Elt 3
		s = new Suite("5,8,7,3");
		sMoinsTouteOcc = new Suite("5,8,7");
		sRenvoyee = s.moinsToutesOcc(new Elt(3));
		if (sontDifferentes(sMoinsTouteOcc, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dont on supprime tous les 3 est égale à " + sMoinsTouteOcc);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		return testOK;
	}

	private static boolean testDoublons() {
		boolean testOK = true;
		Suite s = new Suite();
		Suite sRenvoyee = s.doublons();
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this!");
		}
		testOK = verifDoublons(s, sRenvoyee);
		s = new Suite("7");
		sRenvoyee = s.doublons();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifDoublons(s, sRenvoyee);
		s = new Suite("5,6,7,8");
		sRenvoyee = s.doublons();
		Suite copie = new Suite(s);
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifDoublons(s, sRenvoyee);
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("La méthode reduite a modifié la suite courante !");
		}
		s = new Suite("5,6,5,8,5,6,1,1,6,5");
		copie = new Suite(s);
		sRenvoyee = s.doublons();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifDoublons(s, sRenvoyee);
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode reduite a modifié la suite courante !");
			}
		}
		s = new Suite("5,5,5,5");
		sRenvoyee = s.doublons();
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		testOK = verifDoublons(s, sRenvoyee);
		return testOK;
	}

	private static boolean testAuMoinsK() {
		boolean testOK = true;
		Suite s = new Suite();
		try {
			s.auMoinsK(-1);
			testOK = false;
			System.out.println(
					"La méthode auMoinsK a été appelé avec comme paramètre -1 --> Il fallait lancer une IllegalArgumentException.");
		} catch (IllegalArgumentException e) {

		}
		if (!s.auMoinsK(0)) {
			testOK = false;
			System.out.println("La suite vide contient au moins 0 élément distinct.");
			System.out.println("Votre méthode dit que ce n'est pas le cas.");
		}
		s = new Suite("(5)");
		if (!s.auMoinsK(1)) {
			testOK = false;
			System.out.println("La suite " + s + " contient au moins 1 élément.");
			System.out.println("Votre méthode dit que ce n'est pas le cas.");
		}
		s = new Suite("(5,5)");
		Suite copie = new Suite(s);
		if (!s.auMoinsK(1)) {
			testOK = false;
			System.out.println("La suite " + s + " contient au moins 1 élément.");
			System.out.println("Votre méthode dit que ce n'est pas le cas.");
		}
		if (s.auMoinsK(2)) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas 2 éléments différents.");
			System.out.println("Votre méthode dit qu'elle contient 2 éléments différents.");
		}
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("La méthode auMoinsK a modifié la suite courante !");
		}
		s = new Suite("(5,5,4,5,3,2,2,3)");
		copie = new Suite(s);
		if (!s.auMoinsK(4)) {
			testOK = false;
			System.out.println("La suite " + s + " contient au moins 4 éléments différents.");
			System.out.println("Votre méthode dit que ce n'est pas le cas.");
		}
		if (s.auMoinsK(5)) {
			testOK = false;
			System.out.println("La suite " + s + " ne contient pas 5 éléments différents.");
			System.out.println("Votre méthode dit qu'elle contient 5 éléments différents.");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode auMoinsK a modifié la suite courante !");
			}
		}
		return testOK;
	}

	private static boolean testTousDistincts() {
		boolean testOK = true;
		Suite s = new Suite();
		if (!s.tousDistincts()) {
			testOK = false;
			System.out.println("Les éléments de la suite vide sont tous distincts.");
			System.out.println("Votre méthode dit qu'ils ne le sont pas.");
		}

		s = new Suite("(3,5,6,8,4,14,19)");
		Suite copie = new Suite(s);
		if (!s.tousDistincts()) {
			testOK = false;
			System.out.println("Les éléments de la suite " + s + " sont tous distincts.");
			System.out.println("Votre méthode dit qu'ils ne le sont pas.");
		}
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("La méthode tousDistincts a modifié la suite courante !");
		}
		s = new Suite("(3,3,5,6,8,4,14,19)");
		copie = new Suite(s);
		if (s.tousDistincts()) {
			testOK = false;
			System.out.println("Les éléments de la suite " + s + " ne sont pas tous distincts.");
			System.out.println("Votre méthode dit qu'ils le sont.");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode tousDistincts a modifié la suite courante !");
			}
		}
		s = new Suite("(3,5,6,8,4,5,14,19)");
		copie = new Suite(s);
		if (s.tousDistincts()) {
			testOK = false;
			System.out.println("Les éléments de la suite " + s + " ne sont pas tous distincts.");
			System.out.println("Votre méthode dit qu'ils le sont.");
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode tousDistincts a modifié la suite courante !");
			}
		}
		return testOK;
	}

	private static boolean testSubstitut() {
		boolean testOK = true;
		// test avec la suite vide
		Suite s = new Suite();
		Suite sSubstitut = new Suite();
		Suite sRenvoyee = s.substitut(new Elt(3), new Elt(13));
		if (sRenvoyee == s) {
			testOK = false;
			System.out.println("Vous ne pouvez pas renvoyer this!");
		}
		if (sontDifferentes(sSubstitut, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dans laquelle on remplace 3 par 13 est égale à  " + sSubstitut);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		// test en remplaçant 3 par 13 dans la suite (5,6,7,8)
		s = new Suite("5,6,7,8");
		sSubstitut = new Suite("5,6,7,8");
		sRenvoyee = s.substitut(new Elt(3), new Elt(13));
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (sontDifferentes(sSubstitut, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dans laquelle on remplace 3 par 13 est égale à  " + sSubstitut);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		// test en remplaçant 3 par 13 dans la suite (5,3,7,3)
		s = new Suite("5,3,7,3");
		Suite copie = new Suite(s);
		sSubstitut = new Suite("5,13,7,13");
		sRenvoyee = s.substitut(new Elt(3), new Elt(13));
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (sontDifferentes(sSubstitut, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dans laquelle on remplace 3 par 13 est égale à  " + sSubstitut);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (sontDifferentes(copie, s)) {
			testOK = false;
			System.out.println("La méthode reduite a modifié la suite courante !");
		}
		// test en remplaçant 3 par 13 dans la suite (3,5,7,3)
		s = new Suite("3,5,7,3");
		copie = new Suite(s);
		sSubstitut = new Suite("13,5,7,13");
		sRenvoyee = s.substitut(new Elt(3), new Elt(13));
		if (sontDifferentes(sSubstitut, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dans laquelle on remplace 3 par 13 est égale à  " + sSubstitut);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (testOK) {
			if (sontDifferentes(copie, s)) {
				testOK = false;
				System.out.println("La méthode reduite a modifié la suite courante !");
			}
		}
		// test en remplaçant 3 par 13 dans la suite (5,8,7,3)
		s = new Suite("5,8,7,3");
		sSubstitut = new Suite("5,8,7,13");
		sRenvoyee = s.substitut(new Elt(3), new Elt(13));
		if (testOK) {
			if (sRenvoyee == s) {
				testOK = false;
				System.out.println("Vous ne pouvez pas renvoyer this!");
			}
		}
		if (sontDifferentes(sSubstitut, sRenvoyee)) {
			testOK = false;
			System.out.println("La suite " + s + " dans laquelle on remplace 3 par 13 est égale à  " + sSubstitut);
			System.out.println("Attention, votre méthode a renvoyé la suite " + sRenvoyee);
		}
		return testOK;
	}
	

	private static boolean testEstTriee() {
		boolean testOK = true;
		// Suite vide
		Suite s = new Suite();
		if (!s.estTriee()){
			testOK = false;
			System.out.println("La suite vide est strictement croissante.");
			System.out.println("Votre méthode dit qu'elle ne l'est pas.");
		}
		// SUite avec un seul élément
		s = new Suite("7");
		if (!s.estTriee()){
			testOK = false;
			System.out.println("Une suite avec un seul élément est strictement croissante.");
			System.out.println("Votre méthode dit qu'elle ne l'est pas.");
		}
		//suite (4,7,10,16)
		s = new Suite("4,7,10,16");
		if (!s.estTriee()){
			testOK = false;
			System.out.println("La suite " + s + "  est strictement croissante.");
			System.out.println("Votre méthode dit qu'elle ne l'est pas.");
		}
		//suite (16,18,7,20)
		s = new Suite("16,18,7,20");
		if (s.estTriee()){
			testOK = false;
			System.out.println("La suite " + s +" n'est pas strictement croissante.");
			System.out.println("Votre méthode dit qu'elle l'est.");
		}
		//suite (6,7,7,16)
		s = new Suite("6,7,7,16");
		if (s.estTriee()){
			testOK = false;
			System.out.println("La suite " + s + " n'est pas strictement croissante.");
			System.out.println("Votre méthode dit qu'elle l'est.");
		}
		return testOK;
	}

	private static boolean sontDifferentes(Suite s1, Suite s2) {
		ArrayList<Elt> listeAvant = new ArrayList<Elt>();
		s1.forEach(e -> listeAvant.add(e));
		ArrayList<Elt> listeApres = new ArrayList<Elt>();
		s2.forEach(e -> listeApres.add(e));
		return !listeAvant.equals(listeApres);
	}

	private static boolean verifReduite(Suite s1, Suite s2) {
		HashSet<Elt> ensS1 = new HashSet<Elt>();
		s1.forEach(e -> ensS1.add(e));
		ArrayList<Elt> listS2 = new ArrayList<Elt>();
		s2.forEach(e -> listS2.add(e));
		if (listS2.size() != ensS1.size() || !ensS1.containsAll(listS2)) {
			String aAfficher = "La suite reduite de " + s1 + " doit être de longueur " + ensS1.size() + " et contenir ";
			String elts = ensS1.toString().substring(1, ensS1.toString().length() - 1);
			aAfficher += (ensS1.size() > 1) ? "les éléments " + elts + " (l'ordre n'a pas d'importance)."
					: "l'élément " + elts + ".";
			System.out.println(aAfficher);
			System.out.println("Attention, votre méthode a renvoyé la suite " + s2 + ".");
			return false;
		}
		return true;
	}

	private static boolean verifDoublons(Suite s1, Suite s2) {
		HashSet<Elt> ensS1 = new HashSet<Elt>();
		HashSet<Elt> doublons = new HashSet<Elt>();
		s1.forEach(e -> {
			if (ensS1.contains(e))
				doublons.add(e);
			ensS1.add(e);
		});
		ArrayList<Elt> listS2 = new ArrayList<Elt>();
		s2.forEach(e -> listS2.add(e));
		if (listS2.size() != doublons.size() || !doublons.containsAll(listS2)) {
			if (doublons.size() == 0) {
				System.out.println(
						"La suite renvoyée par la méthode doublons appelée sur la suite " + s1 + " doit être vide.");
			} else {
				String aAfficher = "La suite renvoyée par la méthode doublons appelée sur la suite " + s1
						+ " doit être de longueur " + doublons.size() + " et contenir ";
				String elts = doublons.toString().substring(1, doublons.toString().length() - 1);
				aAfficher += (doublons.size() > 1) ? "les éléments " + elts + " (l'ordre n'a pas d'importance)."
						: "l'élément " + elts + ".";
				System.out.println(aAfficher);
			}
			System.out.println("Attention, votre méthode a renvoyé la suite " + s2 + ".");
			return false;
		}
		return true;
	}

}
