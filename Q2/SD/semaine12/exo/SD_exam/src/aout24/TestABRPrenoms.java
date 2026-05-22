import java.util.ArrayList;
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
				System.out.println(messageErreur+"--> attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+"--> attendu="+attendu+" recu="+recu);
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
			System.out.println("1 -> Tester la methode nombreEnfants()");
			System.out.println("2 -> Tester la methode contient()");
			System.out.println("3 -> Tester la methode toArrayList()");
			System.out.println();
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testNombreEnfants();
				break;
			case 2:
				testContient();
				break;

			case 3:
				testToArrayList();
				break;

			default:
				break;
			}

		} while (choix >= 1 && choix <= 3);

	}

	private static void testNombreEnfants() {
		System.out.println();
		ABRPrenoms aTeste ;

		System.out.println("L'arbre teste est l'ABR 1 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(1);
		System.out.print("nombre enfants ?");
		assertEquals(" ko", 6 , aTeste.nombreEnfants());
		System.out.println(" ok");
		System.out.println();

		System.out.println("L'arbre teste est l'ABR 2 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(2);
		System.out.print("nombre enfants ?");
		assertEquals(" ko",7 , aTeste.nombreEnfants());
		System.out.println(" ok");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre de l'enonce (ABR 3)");
		aTeste = new ABRPrenoms(3);
		System.out.print("nombre enfants ?");
		assertEquals(" ko", 11, aTeste.nombreEnfants());
		System.out.println(" ok");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre vide");
		aTeste = new ABRPrenoms(4);
		System.out.print("nombre enfants ?");
		assertEquals(" ko", 0, aTeste.nombreEnfants());
		System.out.println(" ok");
		System.out.println();

		System.out.println("Tous les tests de la methode nombreEnfants() ont reussi.");
	}

	private static void testContient() {
		System.out.println();
		ABRPrenoms aTeste ;

		System.out.println("L'arbre teste est l'arbre de l'enonce (ABR 3)");
		aTeste = new ABRPrenoms(3);

		System.out.print("contient lea");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("lea"));
		System.out.println(" ok");

		System.out.print("contient anouk");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("anouk"));
		System.out.println(" ok");

		System.out.print("contient hugo");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("hugo"));
		System.out.println(" ok");

		System.out.print("contient sam");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("sam"));
		System.out.println(" ok");

		System.out.print("contient tim");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("tim"));
		System.out.println(" ok");

		System.out.print("contient marie");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("marie"));
		System.out.println(" ok");

		System.out.print("contient zoe");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("zoe"));
		System.out.println(" ok");

		System.out.print("contient loic");
		assertEquals(" ko : booleen ko :", false, aTeste.contient("loic"));
		System.out.println(" ok");
		System.out.println("Tous les tests de la methode contient() avec l'arbre de l'enonce ont reussi.");
		System.out.println();

		System.out.println("L'arbre teste est l'ABR 2 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(2);

		System.out.print("contient lea");
		assertEquals(" ko : booleen ko :", true, aTeste.contient("lea"));
		System.out.println(" ok");
		System.out.print("contient hugo");
		assertEquals(" ko : booleen ko :", false, aTeste.contient("hugo"));
		System.out.println(" ok");

		System.out.println("Tous les tests de la methode contient() avec l'ABR 2.");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre vide ");
		aTeste = new ABRPrenoms(4);

		System.out.print("contient lea");
		assertEquals(" ko : booleen ko :", false, aTeste.contient("lea"));
		System.out.println(" ok");
		System.out.println("Le test de la methode contient() avec l'arbre vide a reussi.");
		System.out.println();

		System.out.println("Tous les tests de la methode contient() ont reussi.");
	}

	private static void testToArrayList() {
		System.out.println();
		ABRPrenoms aTeste ;
		ArrayList<String> arrayList;

		System.out.println("L'arbre teste est l'ABR 1 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(1);
		arrayList = aTeste.toArrayList();
		if(arrayList==null){
			System.out.println(" ko : La liste renvoyee est null");
			System.exit(0);
		}
		assertEquals("ko : contenu ko :","[anouk, lea, marie, sam, tim, zoe]",arrayList.toString());
		System.out.println("Le test de la methode toArrayList() avec l'ABR1");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre de l'enonce (ABR 3)");
		aTeste = new ABRPrenoms(3);
		arrayList = aTeste.toArrayList();
		if(arrayList==null){
			System.out.println(" ko : La liste renvoyee est null");
			System.exit(0);
		}
		assertEquals("ko : contenu ko :","[anouk, hugo, hugo, lea, marie, marie, marie, sam, tim, zoe, zoe]",arrayList.toString());
		System.out.println("Le test de la methode toArrayList() avec l'arbre de l'enonce a reussi");
		System.out.println();

		System.out.println("L'arbre teste est l'ABR 2 (cfr document ABRTestes)");
		aTeste = new ABRPrenoms(2);
		arrayList = aTeste.toArrayList();
		if(arrayList==null){
			System.out.println(" ko : La liste renvoyee est null");
			System.exit(0);
		}
		assertEquals("ko : contenu ko :","[anouk, lea, marie, marie, sam, tim, zoe]",arrayList.toString());
		System.out.println("Le test de la methode toArrayList() avec l'ABR2");
		System.out.println();

		System.out.println("L'arbre teste est l'arbre vide");
		aTeste = new ABRPrenoms(4);
		arrayList = aTeste.toArrayList();
		if(arrayList==null){
			System.out.println(" ko : La liste renvoyee est null");
			System.exit(0);
		}
		assertEquals("ko : contenu ko :","[]",arrayList.toString());
		System.out.println("Le test de la methode toArrayList() avec l'arbre vide a reussi");
		System.out.println();

		System.out.println("Tous les tests de la methode toArrayList() ont reussi.");
	}
	
	
}
