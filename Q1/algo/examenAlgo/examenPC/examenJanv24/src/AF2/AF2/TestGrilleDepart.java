package AF2.AF2;

import java.util.Arrays;

public class TestGrilleDepart {

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
		System.out.println("********************************************");
		System.out.println("Programme Test pour la classe GrilleDepart :");
		System.out.println("********************************************");

		do{
			System.out.println();
			System.out.println("1 -> Tester la methode contientHomonymes()");
			System.out.println("2 -> Tester la methode ecartMaximum()");
			System.out.println("3 -> Tester la methode nombrePilotesEnPhaseDEssais()");
			System.out.println("4 -> Tester la methode pilotesEnPhaseDEssais()");
			System.out.println("5 -> Tester la methode modifierGrilleDepart()");

			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1: testContientHomonymes();
					break;
				case 2: testEcartMaximum();
					break;
				case 3: testNombrePilotesEnPhaseDEssais();
					break;
				case 4: testPilotesEnPhaseDEssais();
					break;
				case 5: testmodifierGrilleDepart();
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
			String[] tableNoms = {"nic","leo","tim","sam","bob"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false, GrilleDepart.contientHomonymes(tableNoms));
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
			String[] tableNoms = {"nic","leo","tim","sam","leo","bob"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, GrilleDepart.contientHomonymes(tableNoms));
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
			String[] tableNoms = {"nic","leo","tim","sam","bob","tim"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, GrilleDepart.contientHomonymes(tableNoms));
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
			String[] tableNoms = {"nic","leo","tim","sam","bob","nic"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, GrilleDepart.contientHomonymes(tableNoms));
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
			String[] tableNoms = {"nic","leo","tim","sam","bob","bob"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, GrilleDepart.contientHomonymes(tableNoms));
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
			String[] tableNoms = {"nic","nic","leo","tim","sam"};
			System.out.println("table teste : " + Arrays.toString(tableNoms));
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true, GrilleDepart.contientHomonymes(tableNoms));
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
			GrilleDepart cl = cl2();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 10, cl.ecartMaximum());
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
			GrilleDepart cl = cl4();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 15, cl.ecartMaximum());
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
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
			GrilleDepart cl = cl9();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : ecart maximum ko", 90, cl.ecartMaximum());
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


	private static void testNombrePilotesEnPhaseDEssais() {
		System.out.println();
		System.out.println("nombrePilotesEnPhaseDEssais()");
		System.out.println("-----------------------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			GrilleDepart cl = cl2();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",2,cl.nombrePilotesEnPhaseDEssais());
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",4,cl.nombrePilotesEnPhaseDEssais());
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
			GrilleDepart cl = cl4();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",1,cl.nombrePilotesEnPhaseDEssais());

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
			GrilleDepart cl = cl9();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",5,cl.nombrePilotesEnPhaseDEssais());

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
			GrilleDepart cl = cl7();
			System.out.println("grille testee : " + cl.toString());
			assertEquals("test " + numeroTest + " ko : nombre joueurs en jeu renvoye ko",0,cl.nombrePilotesEnPhaseDEssais());

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

	private static void testPilotesEnPhaseDEssais() {
		System.out.println();
		System.out.println("pilotesEnPhaseDEssais()");
		System.out.println("-----------------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			GrilleDepart cl = cl2();
			System.out.println("grille testee : " + cl.toString());
			Pilote[] tableRecue = cl.pilotesEnPhaseDEssais();
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			Pilote[] tableRecue = cl.pilotesEnPhaseDEssais();
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
			GrilleDepart cl = cl4();
			System.out.println("grille testee : " + cl.toString());
			Pilote[] tableRecue = cl.pilotesEnPhaseDEssais();
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
			GrilleDepart cl = cl9();
			System.out.println("grille testee : " + cl.toString());
			Pilote[] tableRecue = cl.pilotesEnPhaseDEssais();
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
			GrilleDepart cl = cl7();
			System.out.println("grille testee : " + cl.toString());
			Pilote[] tableRecue = cl.pilotesEnPhaseDEssais();
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

	private static void testmodifierGrilleDepart() {
		System.out.println();
		System.out.println("modifierGrilleDepart()");
		System.out.println("--------------------");

		int numeroTest = 1;
		//test1
		System.out.println("test " + numeroTest);
		try {
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 300;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "tim";
			System.out.println("nom : "+nom);
			int nouveauScore = 30;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "mike";
			System.out.println("nom : "+nom);
			int nouveauScore = 300;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 110;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 100;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 90;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl4();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 75;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 95;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "bob";
			System.out.println("nom : "+nom);
			int nouveauScore = 121;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", true,cl.modifierGrilleDepart(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl5Bob().toString(), cl.toString());
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 125;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "sam";
			System.out.println("nom : "+nom);
			int nouveauScore = 124;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierGrilleDepart(nom,nouveauScore));
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
			GrilleDepart cl = cl5();
			System.out.println("grille testee : " + cl.toString());
			String nom = "nic";
			System.out.println("nom : "+nom);
			int nouveauScore = 90;
			System.out.println("nouveau score : "+nouveauScore);
			assertEquals("test " + numeroTest + " ko : booleen renvoye ko", false,cl.modifierGrilleDepart(nom,nouveauScore));
			assertEquals("test " + numeroTest + " ko : nouveau classement ko", cl5NicPlus().toString(), cl.toString());
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

	private static GrilleDepart cl5(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,1);
		tJ[3] = new Pilote("sam",125,2);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl5Bob(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,1);
		tJ[3] = new Pilote("bob",121,2);
		tJ[4] = new Pilote("sam",125,2);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl5NicPlus(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",90,3);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,1);
		tJ[3] = new Pilote("sam",125,2);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl5MoinsTim(){
		Pilote[] tJ = new Pilote[4];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("leo",120,1);
		tJ[2] = new Pilote("sam",125,2);
		tJ[3] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl51(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,1);
		tJ[3] = new Pilote("sam",124,3);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl52(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("sam",110,3);
		tJ[3] = new Pilote("leo",120,1);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl53(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("sam",100,3);
		tJ[2] = new Pilote("tim",105,3);
		tJ[3] = new Pilote("leo",120,1);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl54(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("sam",90,3);
		tJ[1] = new Pilote("nic",95,2);
		tJ[2] = new Pilote("tim",105,3);
		tJ[3] = new Pilote("leo",120,1);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl55(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,1);
		tJ[3] = new Pilote("sam",125,3);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl56(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("sam",95,3);
		tJ[2] = new Pilote("tim",105,3);
		tJ[3] = new Pilote("leo",120,1);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl57(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,1);
		tJ[3] = new Pilote("sam",125,3);
		tJ[4] = new Pilote("bob",180,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl2(){
		Pilote[] tJ = new Pilote[2];
		tJ[0] = new Pilote("nic",95,1);
		tJ[1] = new Pilote("tim",105,2);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl4(){
		Pilote[] tJ = new Pilote[4];
		tJ[0] = new Pilote("nic",95,3);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,3);
		tJ[3] = new Pilote("sam",125,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl4Sam(){
		Pilote[] tJ = new Pilote[1];
		tJ[0] = new Pilote("sam",125,1);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl45(){
		Pilote[] tJ = new Pilote[4];
		tJ[0] = new Pilote("sam",75,2);
		tJ[1] = new Pilote("nic",95,3);
		tJ[2] = new Pilote("tim",105,3);
		tJ[3] = new Pilote("leo",120,3);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl9(){
		Pilote[] tJ = new Pilote[9];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,3);
		tJ[3] = new Pilote("sam",125,2);
		tJ[4] = new Pilote("mike",175,1);
		tJ[5] = new Pilote("bob",220,3);
		tJ[6] = new Pilote("hugo",310,2);
		tJ[7] = new Pilote("louis",315,3);
		tJ[8] = new Pilote("adam",330,0);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl9Moins(){
		Pilote[] tJ = new Pilote[5];
		tJ[0] = new Pilote("nic",95,2);
		tJ[1] = new Pilote("sam",125,2);
		tJ[2] = new Pilote("mike",175,1);
		tJ[3] = new Pilote("hugo",310,2);
		tJ[4] = new Pilote("adam",330,0);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

	private static GrilleDepart cl7(){
		Pilote[] tJ = new Pilote[7];
		tJ[0] = new Pilote("nic",95,3);
		tJ[1] = new Pilote("tim",105,3);
		tJ[2] = new Pilote("leo",120,3);
		tJ[3] = new Pilote("sam",125,3);
		tJ[4] = new Pilote("mike",175,3);
		tJ[5] = new Pilote("bob",220,3);
		tJ[6] = new Pilote("hugo",310,3);
		GrilleDepart cl = new GrilleDepart(tJ);
		return cl;
	}

}
