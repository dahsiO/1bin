import java.util.Scanner;


public class TestABRPrenoms {
	
	private final static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}

	public static void main(String[] args) {
		
		
		System.out.println("*****************************************");
		System.out.println("Programme Test pour la classe ABRPrenoms");
		System.out.println("*****************************************");
	
		int choix = 0;
		do {
			System.out.println();
			System.out.println("1 -> Tester la methode contientHomonymes()");
			System.out.println("2 -> Tester la methode nombreOccurrences()");
			System.out.println("3 -> Tester la methode iterator()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testContientHomonymes();
				break;
			case 2:
				testNombreOccurrences();
				break;

			case 3:
				testIterator();
				break;

			default:
				break;
			}

		} while (choix >= 1 && choix <= 3);

	}

	private static void testContientHomonymes() {
		System.out.println();
		ABRPrenoms aTeste ;

		System.out.println("L'arbre teste est l'ABR 1 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(1);
		System.out.print("contient homonymes ?");
		assertEquals(" ko", false, aTeste.contientHomonymes());
		System.out.println(" ok");
		System.out.println();

		System.out.println("L'arbre teste est l'ABR 2 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(2);
		System.out.print("contient homonymes ?");
		assertEquals(" ko", true, aTeste.contientHomonymes());
		System.out.println(" ok");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre de l'enonce (ABR 3)");
		aTeste = new ABRPrenoms(3);
		System.out.print("contient homonymes ?");
		assertEquals(" ko", true, aTeste.contientHomonymes());
		System.out.println(" ok");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre vide");
		aTeste = new ABRPrenoms(4);
		System.out.print("contient homonymes ?");
		assertEquals(" ko", false, aTeste.contientHomonymes());
		System.out.println(" ok");
		System.out.println();

		System.out.println("Tous les tests de la methode contientHomonymes() ont reussi.");
	}


	private static void testNombreOccurrences() {
		System.out.println();
		ABRPrenoms aTeste ;
		System.out.println("L'arbre teste est l'arbre de l'enonce (ABR 3)");
		aTeste = new ABRPrenoms(3);
		
		System.out.print("nombre occurrences de lea");
		assertEquals(" ko", 1, aTeste.nombreOccurrences("lea"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences d'anouk");
		assertEquals("\nnombre occurrences d'anouk ko", 1, aTeste.nombreOccurrences("anouk"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences d'hugo");
		assertEquals(" ko", 2, aTeste.nombreOccurrences("hugo"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences de sam");
		assertEquals(" ko", 1, aTeste.nombreOccurrences("sam"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences de tim");
		assertEquals(" ko", 1, aTeste.nombreOccurrences("tim"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences de marie");
		assertEquals(" ko", 3, aTeste.nombreOccurrences("marie"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences de zoe");
		assertEquals(" ko", 2, aTeste.nombreOccurrences("zoe"));
		System.out.println(" ok");
		
		System.out.print("nombre occurrences de loic");
		assertEquals(" ko", 0, aTeste.nombreOccurrences("loic"));
		System.out.println(" ok");
		System.out.println("Tous les tests de la methode nombreOccurrences() avec l'arbre de l'enonce ont reussi.");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre vide ");
		aTeste = new ABRPrenoms(4);

		System.out.print("nombre occurrences de lea");
		assertEquals(" ko", 0, aTeste.nombreOccurrences("lea"));
		System.out.println(" ok");
		System.out.println("Le test de la methode nombreOccurrences() avec l'arbre vide a reussi.");
		System.out.println();

		System.out.println("Tous les tests de la methode nombreOccurrences() ont reussi.");

	}

	private static void testIterator() {
		System.out.println();
		ABRPrenoms aTeste;
		System.out.println("l'arbre teste est l'ABR 1 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(1);
		String[] prenoms1 = {"anouk","lea","marie","sam","tim","zoe"};
		int i=0;
		for (String prenom : aTeste) {
			if(i>7){
				System.out.println("nombre de next ko. attendu=6 recu : au moins 7");
				System.exit(0);
			}
			System.out.print("next :"+prenoms1[i]);
			assertEquals("\nnext ko", prenoms1[i], prenom);
			System.out.println(" ok");
			i++;
		}
		assertEquals("nombre de next ko", 6, i);
		System.out.println("Le test de la methode iterator() avec l'ABR1 a reussi.");
		System.out.println();

		System.out.println("l'arbre teste est l'arbre de l'enonce (ABR 3)");
		aTeste = new ABRPrenoms(3);
		String[] prenoms3 = {"anouk","hugo","hugo","lea","marie","marie","marie","sam","tim","zoe","zoe"};
		i=0;
		for (String prenom : aTeste) {
			if(i>11){
				System.out.println("nombre de next ko. attendu=11 recu : au moins 12");
				System.exit(0);
			}
			System.out.print("next :"+prenoms3[i]);
			assertEquals("\nnext ko", prenoms3[i], prenom);
			System.out.println(" ok");
			i++;
		}
		assertEquals("nombre de next ko", 11, i);
		System.out.println("Le test de la methode iterator() avec l'arbre de l'enonce a reussi.");
		System.out.println();

		System.out.println("l'arbre teste est l'arbre vide");
		aTeste = new ABRPrenoms(4);
		i=0;
		for (String prenomVide : aTeste) {
				System.out.println("nombre de next ko. attendu=0 recu : au moins 1");
				System.exit(0);

		}
		System.out.println("Le test de la methode iterator() avec l'arbre vide a reussi.");
		System.out.println();


		System.out.println("Tous les tests de la methode iterator() ont reussi.");
	}

}
