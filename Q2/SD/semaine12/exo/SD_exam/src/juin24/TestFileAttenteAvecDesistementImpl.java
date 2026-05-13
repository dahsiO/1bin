import java.util.Scanner;

public class TestFileAttenteAvecDesistementImpl {

	private static Scanner scanner = new Scanner(System.in);

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

				System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {

			System.out.println(messageErreur+"\n --> Attendu="+attendu+" recu="+recu);
			System.exit(0);
		}
	}

	/**
	 * Cette methode appelle la methode assertEquals avec un message d'erreur adequat
	 * @param numeroMessage le numero du message a afficher en cas d'erreur
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(int numeroMessage, Object attendu, Object recu) {
		String[] message = new String[10];
		message[0]="Test ko, la methode n'a pas renvoye ce qui etait attendu";
		message[1]="Test ko, apres appel de la methode, le nombre d'elements dans le map n'est pas celui attendu";
		message[2]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens -->";
		message[3]="Test ko, apres appel de la methode, Il y a un probleme dans le chainage dans le sens <--";
		assertEquals(message[numeroMessage],attendu,recu);
	}

	public static void main(String[] args) {
		System.out.println("************************************************************");
		System.out.println("Programme Test pour la classe FilaAttenteAvecDesistementImpl");
		System.out.println("************************************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode enfile()");
			System.out.println("2 -> Tester la methode defile()");
			System.out.println("3 -> Tester la methode desister()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testEnfile();
					break;
				case 2:
					testDefile();
					break;
				case 3:
					testDesister();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 3 );

	}

	private static void testEnfile() {
		FileAttenteAvecDesistementImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo : enfile tom ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee1);
		assertEquals(0, true, l.enfile("tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,tom)", l.teteQueue());
		assertEquals(3, "(tom,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo : enfile pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee2);
		assertEquals(0, false, l.enfile("pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "(marie,pierre,hugo)", l.teteQueue());
		assertEquals(3, "(hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : file testee : file vide : enfile tom ?");
		String[] tableTestee3 = {};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee3);
		assertEquals(0, true, l.enfile("tom"));
		assertEquals(1, 1, l.taille());
		assertEquals(2, "(tom)", l.teteQueue());
		assertEquals(3, "(tom)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}


	private static void testDefile() {
		FileAttenteAvecDesistementImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo sam lea : defile");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee1);
		assertEquals(0, "marie", l.defile());
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre)", l.queueTete());
		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test2 : file testee : lea : defile");
		String[] tableTestee2 = {"lea"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee2);
		assertEquals(0, "lea", l.defile());
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : file vide : defile");
		String[] tableTestee3 = {};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee3);
		assertEquals(0, null, l.defile());
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}


	private static void testDesister() {
		FileAttenteAvecDesistementImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo sam lea : desiste pierre");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee1);
		assertEquals(0, true, l.desister("pierre"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : file testee : marie pierre hugo sam lea : desiste lea");
		String[] tableTestee2 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee2);
		assertEquals(0, true, l.desister("lea"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam)", l.teteQueue());
		assertEquals(3, "(sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : file testee : marie pierre hugo sam lea : desiste marie");
		String[] tableTestee3 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee3);
		assertEquals(0, true, l.desister("marie"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "(pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test4 : file testee : marie pierre hugo sam lea : desiste tom");
		String[] tableTestee4 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee4);
		assertEquals(0, false, l.desister("tom"));
		assertEquals(1, 5, l.taille());
		assertEquals(2, "(marie,pierre,hugo,sam,lea)", l.teteQueue());
		assertEquals(3, "(lea,sam,hugo,pierre,marie)", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test5 : file testee : marie : desiste marie");
		String[] tableTestee5 = {"marie"};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee5);
		assertEquals(0, true, l.desister("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test6 : file vide : desiste marie");
		String[] tableTestee6 = {};
		l = new FileAttenteAvecDesistementImpl<String>(tableTestee6);
		assertEquals(0, false, l.desister("marie"));
		assertEquals(1, 0, l.taille());
		assertEquals(2, "()", l.teteQueue());
		assertEquals(3, "()", l.queueTete());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

}
