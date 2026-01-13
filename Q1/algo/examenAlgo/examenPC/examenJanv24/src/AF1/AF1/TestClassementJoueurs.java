package AF1.AF1;

import java.util.Arrays;

public class TestClassementJoueurs {

	private static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println(messageErreur);
				System.out.println("Attendu : " + attendu);
				System.out.println("Recu    : " + recu);
				System.exit(0);
			}
		} else {
			if (attendu instanceof Character && recu instanceof String) {
				attendu = "" + attendu;
			}
			if (attendu instanceof String && recu instanceof Character) {
				recu = "" + recu;
			}
			if (!attendu.equals(recu)) {
				System.out.println(messageErreur);
				System.out.println("Attendu : " + attendu);
				System.out.println("Recu    : " + recu);
				System.exit(0);
			}
		}
	}

	public static void main(String [] args){

		int choix;
		System.out.println("*************************************************");
		System.out.println("Programme Test pour la classe ClassementJoueurs :");
		System.out.println("*************************************************");

		do{
			System.out.println();
			System.out.println("1 -> Tester la methode contientHomonymes()");
			System.out.println("2 -> Tester la methode ecartMaximum()");
			System.out.println("3 -> Tester la methode nombreJoueursEnJeu()");
			System.out.println("4 -> Tester la methode joueursEnJeu()");
			System.out.println("5 -> Tester la methode modifierClassement()");

			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1: testContientHomonymes();
					break;
				case 2: testEcartMaximum();
					break;
				case 3: testNombreJoueursEnJeu();
					break;
				case 4: testJoueursEnJeu();
					break;
				case 5: testModifierClassement();
					break;
			}
		} while (choix >= 1 && choix <= 5);
		System.out.println("Fin des tests !");
	}



	private static void testContientHomonymes() {
		System.out.println();
		System.out.println("contientHomonymes()");
		System.out.println("-------------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			String[] tableNoms = {"eva","lea","tim","sam","mia"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false, ClassementJoueurs.contientHomonymes(tableNoms));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test2
		System.out.println("test " + numeroTest);
		try {
			String[] tableNoms = {"eva","lea","tim","sam","lea","mia"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, ClassementJoueurs.contientHomonymes(tableNoms));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test3
		System.out.println("test " + numeroTest);
		try {
			String[] tableNoms = {"eva","lea","tim","sam","mia","tim"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, ClassementJoueurs.contientHomonymes(tableNoms));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test3
		System.out.println("test " + numeroTest);
		try {
			String[] tableNoms = {"eva","lea","tim","sam","mia","eva"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, ClassementJoueurs.contientHomonymes(tableNoms));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test4
		System.out.println("test " + numeroTest);
		try {
			String[] tableNoms = {"eva","lea","tim","sam","mia","mia"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, ClassementJoueurs.contientHomonymes(tableNoms));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test5
		System.out.println("test " + numeroTest);
		try {
			String[] tableNoms = {"eva","eva","lea","tim","sam"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, ClassementJoueurs.contientHomonymes(tableNoms));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi");
	}



	private static void testEcartMaximum() {
		System.out.println();
		System.out.println("ecartMaximum()");
		System.out.println("--------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl2();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 8, cl.ecartMaximum());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test2
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl4();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 25, cl.ecartMaximum());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();


		numeroTest++;
		//test3
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 55, cl.ecartMaximum());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test4
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl9();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 55, cl.ecartMaximum());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi");

	}


	private static void testNombreJoueursEnJeu() {
		System.out.println();
		System.out.println("nombreJoueursEnJeu()");
		System.out.println("--------------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl2();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",2,cl.nombreJoueursEnJeu());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test2
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",4,cl.nombreJoueursEnJeu());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test3
		System.out.println("test " + numeroTest);

		try {
			ClassementJoueurs cl = cl4();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",1,cl.nombreJoueursEnJeu());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test4
		System.out.println("test " + numeroTest);

		try {
			ClassementJoueurs cl = cl9();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",5,cl.nombreJoueursEnJeu());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test5
		System.out.println("test " + numeroTest);

		try {
			ClassementJoueurs cl = cl7();
			System.out.println("classement teste : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",0,cl.nombreJoueursEnJeu());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();


		System.out.println("Tous les tests ont reussi");

	}

	private static void testJoueursEnJeu() {
		System.out.println();
		System.out.println("JoueursEnJeu()");
		System.out.println("--------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl2();
			System.out.println("classement teste : " + cl.toString());
			Joueur[] tableRecue = cl.joueursEnJeu();
			if(tableRecue==null){
				System.out.println("test "+numeroTest +" ko : table renvoyee = null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table renvoyee ko",2,tableRecue.length);
			assertEquals("test " + numeroTest + " ko : contenu table renvoyee ko",cl.toString(),Arrays.toString(tableRecue));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();


		numeroTest++;
		//test2
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			Joueur[] tableRecue = cl.joueursEnJeu();
			if(tableRecue==null){
				System.out.println("test "+numeroTest +" ko : table renvoyee = null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table renvoyee ko",4,tableRecue.length);
			assertEquals("test " + numeroTest + " ko : contenu table renvoyee ko",cl5MoinsTim().toString(),Arrays.toString(tableRecue));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test3
		System.out.println("test " + numeroTest);

		try {
			ClassementJoueurs cl = cl4();
			System.out.println("classement teste : " + cl.toString());
			Joueur[] tableRecue = cl.joueursEnJeu();
			if(tableRecue==null){
				System.out.println("test "+numeroTest +" ko : table renvoyee = null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table renvoyee ko",1,tableRecue.length);
			assertEquals("test " + numeroTest + " ko : contenu table renvoyee ko",cl4Sam().toString(),Arrays.toString(tableRecue));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test4
		System.out.println("test " + numeroTest);

		try {
			ClassementJoueurs cl = cl9();
			System.out.println("classement teste : " + cl.toString());
			Joueur[] tableRecue = cl.joueursEnJeu();
			if(tableRecue==null){
				System.out.println("test "+numeroTest +" ko : table renvoyee = null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table renvoyee ko",5,tableRecue.length);
			assertEquals("test " + numeroTest + " ko : contenu table renvoyee ko",cl9Moins().toString(),Arrays.toString(tableRecue));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();


		numeroTest++;
		//test5
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl7();
			System.out.println("classement teste : " + cl.toString());
			Joueur[] tableRecue = cl.joueursEnJeu();
			if(tableRecue==null){
				System.out.println("test "+numeroTest +" ko : table renvoyee = null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table renvoyee ko",0,tableRecue.length);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi");
	}

	private static void testModifierClassement() {
		System.out.println();
		System.out.println("modifierClassement()");
		System.out.println("--------------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 30;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl57().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test2
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "tim";
			System.out.println("nom : "+nom);
			int nouveauScore = 300;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl5().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test3
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "marie";
			System.out.println("nom : "+nom);
			int nouveauScore = 300;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl5().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();



		numeroTest++;
		//test4
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 110;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl52().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test5
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 128;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl53().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test6
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 140;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl54().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test7
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl4();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 150;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl45().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test8
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 130;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl56().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test9
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "mia";
			System.out.println("nom : "+nom);
			int nouveauScore = 85;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl5Mia().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test10
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 75;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl55().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		numeroTest++;
		//test11
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 85;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl51().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();


		numeroTest++;
		//test12
		System.out.println("test " + numeroTest);
		try {
			ClassementJoueurs cl = cl5();
			System.out.println("classement teste : " + cl.toString());
			String nom = "eva";
			System.out.println("nom : "+nom);
			int nouveauScore = 150;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierClassement(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl5EvaPlus().toString(), cl.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi");
	}

	private static ClassementJoueurs cl5(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,1);
		tJ[3] = new Joueur("sam",75,2);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl5Mia(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,1);
		tJ[3] = new Joueur("mia",85,2);
		tJ[4] = new Joueur("sam",75,2);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl5EvaPlus(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",150,3);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,1);
		tJ[3] = new Joueur("sam",75,2);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl5MoinsTim(){
		Joueur[] tJ = new Joueur[4];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("lea",100,1);
		tJ[2] = new Joueur("sam",75,2);
		tJ[3] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl51(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,1);
		tJ[3] = new Joueur("sam",85,3);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl52(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("sam",110,3);
		tJ[3] = new Joueur("lea",100,1);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl53(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("sam",128,3);
		tJ[2] = new Joueur("tim",125,3);
		tJ[3] = new Joueur("lea",100,1);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl54(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("sam",140,3);
		tJ[1] = new Joueur("eva",130,2);
		tJ[2] = new Joueur("tim",125,3);
		tJ[3] = new Joueur("lea",100,1);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl55(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,1);
		tJ[3] = new Joueur("sam",75,3);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl56(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("sam",130,3);
		tJ[2] = new Joueur("tim",125,3);
		tJ[3] = new Joueur("lea",100,1);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl57(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,1);
		tJ[3] = new Joueur("sam",75,3);
		tJ[4] = new Joueur("mia",20,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl2(){
		Joueur[] tJ = new Joueur[2];
		tJ[0] = new Joueur("eva",128,1);
		tJ[1] = new Joueur("tim",120,2);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl4(){
		Joueur[] tJ = new Joueur[4];
		tJ[0] = new Joueur("eva",130,3);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,3);
		tJ[3] = new Joueur("sam",90,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl4Sam(){
		Joueur[] tJ = new Joueur[1];
		tJ[0] = new Joueur("sam",90,1);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl45(){
		Joueur[] tJ = new Joueur[4];
		tJ[0] = new Joueur("sam",150,2);
		tJ[1] = new Joueur("eva",130,3);
		tJ[2] = new Joueur("tim",125,3);
		tJ[3] = new Joueur("lea",100,3);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl9(){
		Joueur[] tJ = new Joueur[9];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,3);
		tJ[3] = new Joueur("sam",95,2);
		tJ[4] = new Joueur("marie",75,1);
		tJ[5] = new Joueur("mia",20,3);
		tJ[6] = new Joueur("hugo",10,2);
		tJ[7] = new Joueur("louis",5,3);
		tJ[8] = new Joueur("anna",0,0);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl9Moins(){
		Joueur[] tJ = new Joueur[5];
		tJ[0] = new Joueur("eva",130,2);
		tJ[1] = new Joueur("sam",95,2);
		tJ[2] = new Joueur("marie",75,1);
		tJ[3] = new Joueur("hugo",10,2);
		tJ[4] = new Joueur("anna",0,0);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

	private static ClassementJoueurs cl7(){
		Joueur[] tJ = new Joueur[7];
		tJ[0] = new Joueur("eva",130,3);
		tJ[1] = new Joueur("tim",125,3);
		tJ[2] = new Joueur("lea",100,3);
		tJ[3] = new Joueur("sam",95,3);
		tJ[4] = new Joueur("marie",75,3);
		tJ[5] = new Joueur("mia",20,3);
		tJ[6] = new Joueur("hugo",10,3);
		ClassementJoueurs cl = new ClassementJoueurs(tJ);
		return cl;
	}

}
