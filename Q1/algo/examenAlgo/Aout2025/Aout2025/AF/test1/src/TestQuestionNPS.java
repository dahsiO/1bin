import java.util.Arrays;

public class TestQuestionNPS {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

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
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}
	
	public static void main(String[] args) {
		
		int choix;			
		
		System.out.println("*********************************");
		System.out.println("Tests pour la classe QuestionNPS");
		System.out.println("*********************************");
		do{
			System.out.println("Menu");
			System.out.println("****");
			System.out.println("1 -> QuestionNPS()");
			System.out.println("2 -> moyenne()");
			System.out.println("3 -> mediane()");
			System.out.println("4 -> scoreNPS()");
			System.out.print("\nEntrez votre choix : ");

			choix=scanner.nextInt();

			switch(choix){
				case 1: testerConstructeur();
					break;
				case 2: testerMoyenne();
					break;
				case 3: testerMediane();
					break;
				case 4: testerScoreNPS();
					break;
			}

		}while(choix >= 1 && choix <= 4);

		System.out.println("\nFin des tests");
	}

	private static void testerConstructeur() {
		System.out.println();
		System.out.println("QuestionNPS()");
		System.out.println("---------");
		System.out.println();
		System.out.println("test 1");
		try{
			int[] tableRecue = {5,7,6};
			int[] tableAttendue = {5,7,6};
			System.out.println("tableRecue : "+Arrays.toString(tableRecue));
			QuestionNPS q = new QuestionNPS("q",tableRecue);
			assertEquals("test 1 ko : contenu tableReponses ko", Arrays.toString(tableAttendue), q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");

		System.out.println();
		System.out.println("test 2");
		try{
			int[] tableRecue = {5,7,0,7,10,7};
			int[] tableAttendue = {5,7,0,7,10,7};
			System.out.println("tableRecue : "+Arrays.toString(tableRecue));
			QuestionNPS q = new QuestionNPS("q",tableRecue);
			assertEquals("test 2 ko : contenu tableReponses ko", Arrays.toString(tableAttendue), q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");

		System.out.println();
		System.out.println("test 3");
		try{
			int[] tableRecue = {5,-1,7,6,7,7,11,-5,3};
			int[] tableAttendue = {5,7,6,7,7,3};
			System.out.println("tableRecue : "+Arrays.toString(tableRecue));
			QuestionNPS q = new QuestionNPS("q",tableRecue);
			assertEquals("test 3 ko : contenu tableReponses ko", Arrays.toString(tableAttendue), q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");

		System.out.println();
		System.out.println("test 4");
		try{
			int[] tableRecue = {-1,11,20,-5,3,15};
			int[] tableAttendue = {3};
			System.out.println("tableRecue : "+Arrays.toString(tableRecue));
			QuestionNPS q = new QuestionNPS("q",tableRecue);
			assertEquals("test 4 ko : contenu tableReponses ko", Arrays.toString(tableAttendue), q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 4 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 4 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 ok");

		System.out.println();
		System.out.println("test 5");
		try{
			int[] tableRecue = {-1,11,20,-5,-3,15};
			int[] tableAttendue = {};
			System.out.println("tableRecue : "+Arrays.toString(tableRecue));
			QuestionNPS q = new QuestionNPS("q",tableRecue);
			assertEquals("test 5 ko : contenu tableReponses ko", Arrays.toString(tableAttendue), q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 5 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 5 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 5 ok");

		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();

	}


	private static void testerMoyenne() {
		System.out.println();
		System.out.println("moyenne()");
		System.out.println("---------");

		System.out.println("test 1 : reponses : 5 7 6");
		try{
			int[] table = {5,7,6};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 1 ko ", 6.0 , q.moyenne());
			assertEquals("test 1 ko : tableReponses modifiee","[5, 7, 6]", q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");

		System.out.println();
		System.out.println("test 2 : reponses : 4 (une seule reponse)");
		try{
			int[] table = {4};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 2 ko ", 4.0 , q.moyenne());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");

		System.out.println();
		System.out.println("test 3 : reponses : 3 4 7 1");
		try{
			int[] table = {3,4,7,1};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 3 ko ", 3.75 , q.moyenne());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");


		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerMediane() {
		System.out.println();
		System.out.println();
		System.out.println("mediane()");
		System.out.println("---------");

		System.out.println("test 1 : reponses : 1 2 3 4 5");
		try{
			int[] table = {1,2,3,4,5};
			QuestionNPS q = new QuestionNPS(table);
			QuestionNPS qCopie = new QuestionNPS(table);
			assertEquals("test 1 ko",3,q.mediane());
			assertEquals("test 1 ko tableReponses modifiee", qCopie.toString(), q.toString());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");
		System.out.println();

		System.out.println("test 2 : reponses 2 4 5 1 3");
		try{
			int[] table = {2,4,5,1,3};
			QuestionNPS q = new QuestionNPS(table);

			assertEquals("test 2 ko",3,q.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");
		System.out.println();

		System.out.println("test 3 : reponses 3 4 5 1 2");
		try{
			int[] table = {2,4,5,1,3};
			QuestionNPS q = new QuestionNPS(table);

			assertEquals("test 3 ko",3,q.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");
		System.out.println();

		System.out.println("test 4 : reponses 2 8 9 1 9 7 4");
		try{
			int[] table = {2,8,9,1,9,7,4};
			QuestionNPS q = new QuestionNPS(table);

			assertEquals("test 4 ko",7,q.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 4 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 4 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 ok");

		System.out.println();
		System.out.println("test 5 : reponses 2 8 9 1 9 7 4 9");
		try{
			int[] table = {2,8,9,1,9,7,4,9};
			QuestionNPS q = new QuestionNPS(table);

			assertEquals("test 5 ko",8,q.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 5 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 5 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 5 ok");


		System.out.println();
		System.out.println("test 6 : reponses 2 8 9 1 9 4 2");
		try{
			int[] table = {2,8,9,1,9,4,2};
			QuestionNPS q = new QuestionNPS(table);

			assertEquals("test 6 ko",4,q.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 6 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 6 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 6 ok");

		System.out.println();
		System.out.println("test 7 : reponses 9 (une seule reponse)");
		try{
			int[] table = {9};
			QuestionNPS q = new QuestionNPS(table);

			assertEquals("test 7 ko",9,q.mediane());

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 7 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 7 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 7 ok");

		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerScoreNPS() {
		System.out.println();
		System.out.println("scoreNPS()");
		System.out.println("-----------");

		System.out.println("test 1 : reponses : 9 9 9 10 (0 detracteur 4 promoteurs 0 passif)");
		try{
			int[] table = {9,9,9,10};
			QuestionNPS q = new QuestionNPS(table);
			QuestionNPS qCopie = new QuestionNPS(table);
			assertEquals("test 1 ko ", 100.0 , q.scoreNPS());
			assertEquals("test 1 ko tableReponses modifiee", qCopie.toString(), q.toString());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 1 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 1 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 1 ok");

		System.out.println();
		System.out.println("test 2 : reponses : 0 0 6 (3 detracteurs 0 promoteur 0 passif)");
		try{
			int[] table = {0,0,6};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 2 ko ", -100.0 , q.scoreNPS());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 2 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 2 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 2 ok");

		System.out.println();
		System.out.println("test 3 : reponses : 7 8 (0 detracteur 0 promoteur 2 passifs)");
		try{
			int[] table = {7,8};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 3 ko ", 0.0 , q.scoreNPS());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 3 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 3 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 3 ok");

		System.out.println();
		System.out.println("test 4 : reponses 3 9 9 (1 detracteur 2 promoteurs 0 passif)");
		try{
			int[] table = {3,9,9};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 4 ko ", (int)((100.0*1/3)*10000000) , (int)(q.scoreNPS()*10000000));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 4 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 4 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 4 ok");

		System.out.println();
		System.out.println("test 5 : reponses 10 6 6 (2 detracteurs 1 promoteurs 0 passif)");
		try{
			int[] table = {10,6,6};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 5 ko ", (int)((-100.0*1/3)*10000000) , (int)(q.scoreNPS()*10000000));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 5 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 5 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 5 ok");

		System.out.println();
		System.out.println("test 6 : reponses 0 10 (1 detracteur 1 promoteurs 0 passif)");
		try{
			int[] table = {0,10};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 6 ko ", 0.0 , q.scoreNPS());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 6 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 6 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 6 ok");

		System.out.println();
		System.out.println("test 7 : reponses 7 10 8 7 10 6 (1 detracteur 2 promoteurs 3 passifs)");
		try{
			int[] table = {7,10,8,7,10,6};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 7 ko ", (int)((100.0*1/6)*10000000) , (int)(q.scoreNPS()*10000000));
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 7 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 7 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 7 ok");

		System.out.println();
		System.out.println("test 8 : reponses 3 4 7 1 9 10 8 6 0 9 (5 detracteurs 3 promoteurs 2 passifs)");
		try{
			int[] table = {3, 4, 7, 1, 9, 10, 8, 6, 0, 9};
			QuestionNPS q = new QuestionNPS(table);
			assertEquals("test 8 ko ", -20 , (int) q.scoreNPS());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("test 8 ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}catch(Exception e){
			System.out.println("test 8 ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test 8 ok");

		System.out.println();
		System.out.println("tous les tests ont reussi!");
		System.out.println();
	}

}
