import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TestFileAttenteSDImpl {

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
		message[1]="Test ko, apres appel de la methode, le nombre d'elements dans l'ensemble n'est pas celui attendu";
		message[2]="Test ko, apres appel de la methode, le premier element est ko";
		message[3]="Test ko, apres appel de la methode, le dernier element est ko";
		message[4]="Test ko, apres appel de la methode, le chainage est ko tete --> queue";
		assertEquals(message[numeroMessage],attendu,recu);
	}

	public static void main(String[] args) {
		System.out.println("***********************************************");
		System.out.println("Programme Test pour la classe FileAttenteSDImpl");
		System.out.println("***********************************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode enfile()");
			System.out.println("2 -> Tester la methode defile()");
			System.out.println("3 -> Tester l'iterateur");
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
					testIterateur();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 3 );

	}



	private static void testEnfile() {
		FileAttenteSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo : enfile tom ?");
		String[] tableTestee1 = {"marie","pierre","hugo"};
		l = new FileAttenteSDImpl<String>(tableTestee1);
		assertEquals(0, true, l.enfile("tom"));
		assertEquals(1, 4, l.taille());
		assertEquals(2, "marie", l.premier());
		assertEquals(3, "tom", l.dernier());
		assertEquals(4, "(marie,pierre,hugo,tom)", l.toString());
		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test2 : file testee : marie pierre hugo : enfile pierre ?");
		String[] tableTestee2 = {"marie","pierre","hugo"};
		l = new FileAttenteSDImpl<String>(tableTestee2);
		assertEquals(0, false, l.enfile("pierre"));
		assertEquals(1, 3, l.taille());
		assertEquals(2, "marie", l.premier());
		assertEquals(3, "hugo", l.dernier());
		assertEquals(4, "(marie,pierre,hugo)", l.toString());

		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : file testee : file vide : enfile tom ?");
		String[] tableTestee3 = {};
		l = new FileAttenteSDImpl<String>(tableTestee3);
		assertEquals(0, true, l.enfile("tom"));
		assertEquals(1, 1, l.taille());
		assertEquals(2, "tom", l.premier());
		assertEquals(3, "tom", l.dernier());
		assertEquals(4, "(tom)", l.toString());

		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}


	private static void testDefile() {
		FileAttenteSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo sam lea : defile");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteSDImpl<String>(tableTestee1);
		assertEquals(0, "marie", l.defile());
		assertEquals(1, 4, l.taille());
		assertEquals(2, "pierre", l.premier());
		assertEquals(3, "lea", l.dernier());
		assertEquals(4, "(pierre,hugo,sam,lea)", l.toString());

		System.out.println("Test ok");


		System.out.println();
		System.out.println("Test2 : file testee : lea : defile");
		String[] tableTestee2 = {"lea"};
		l = new FileAttenteSDImpl<String>(tableTestee2);
		assertEquals(0, "lea", l.defile());
		assertEquals(1, 0, l.taille());
		assertEquals(2, null, l.premier());
		assertEquals(3, null, l.dernier());
		assertEquals(4, "()", l.toString());

		System.out.println("Test ok");

		System.out.println();
		System.out.println("Test3 : file vide : defile");
		String[] tableTestee3 = {};
		l = new FileAttenteSDImpl<String>(tableTestee3);
		assertEquals(0, null, l.defile());
		assertEquals(1, 0, l.taille());
		assertEquals(2, null, l.premier());
		assertEquals(3, null, l.dernier());
		assertEquals(4, "()", l.toString());

		System.out.println("Test ok");

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();

	}

	private static void testIterateur() {
		FileAttenteSDImpl<String> l ;
		System.out.println();

		System.out.println();
		System.out.println("Test1 : file testee : marie pierre hugo sam lea");
		String[] tableTestee1 = {"marie","pierre","hugo","sam","lea"};
		l = new FileAttenteSDImpl<String>(tableTestee1);
		try{
			Iterator<String> it = l.iterator();
			if(!it.hasNext()){
				System.out.println(" KO : booleen renvoye par hasNext() : false");
				System.exit(0);
			}
			Object o = it.next();
			if(!(o instanceof String)){
				System.out.println(" KO : la file testee contient des objets de la classe String");
				System.out.println("         Verifiez si votre methode renvoie bien l'element contenu dans le noeud et non le noeud");
				System.exit(0);
			}
			String s = (String) o;
			if(!s.equals("marie")){
				System.out.println(" KO : premier renvoye : "+ s);
				System.exit(0);
			}
			if(!l.toString().equals("(marie,pierre,hugo,sam,lea)")){
				System.out.println(" KO : contenu file a change : "+ l.toString());
				System.exit(0);
			}
		}catch (NoSuchElementException ex){
			System.out.println(" KO, il y a eu une NoSuchElementException des le premier next()");
			System.exit(0);
		}catch (Exception e){
			System.out.println(" KO, il y a eu une exception inattendue : ");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("parcours de la file via un foreach : ");
		int i = 0;
		for (String nom : l) {
			if(i == tableTestee1.length){
				System.out.println("ko : attention lecture d'un 6eme nom");
				System.exit(0);
			}
			if(!nom.equals(tableTestee1[i])){
				System.out.println("ko : nom attendu "+tableTestee1[i]+ " nom recu "+nom);
				System.exit(0);
			}
			System.out.println(nom);
			i++;
		}
		System.out.println("Test ok");

		System.out.println();
		System.out.print("Test 2 : listeVide");
		FileAttenteSD<String> fileVide = new FileAttenteSDImpl<>();
		try{
			Iterator<String> it = fileVide.iterator();
			if(it.hasNext()){
				System.out.println(" KO : booleen renvoye par hasNext() : true!");
				System.exit(0);
			}
			it.next();
			System.out.println("KO, votre methode next() doit lever une NoSuchElementException quand il n'y a plus d'element");
		}catch (NoSuchElementException ex){
			System.out.println();
			System.out.println("Test ok");
		}catch (Exception e){
			System.out.println(" KO, il y a eu Exception : ");
			System.out.println("                         Verifier si votre methode next() leve bien une NoSuchElementException quand il n'y a plus d'element");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println();
		System.out.println("Tous les tests ont reussi");
		System.out.println();
		System.out.println();
	}

}
