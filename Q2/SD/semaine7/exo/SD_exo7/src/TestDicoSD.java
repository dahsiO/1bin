import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class TestDicoSD {

    static Class classe = DicoSD.class;
    static Field map;

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
				System.out.println(messageErreur+" attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+" attendu="+attendu+" recu="+recu);
			System.exit(0);			
		}
	}

    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        System.out.println("************************************");
        System.out.println("Programme Test pour la classe DicoSD");
        System.out.println("************************************");

        map = classe.getDeclaredField("mapSDUrls");
        map.setAccessible(true);

        System.out.println();
        System.out.println("Menu");
        System.out.println(("----"));
        System.out.println("1 -> Tester le methode contient()");
        System.out.println("2 -> Tester la methode ajouter()");
        System.out.println("3 -> Tester la methode lesUrls()");
        System.out.println("4 -> Tester la methode supprimer()");
        System.out.println();
        System.out.print("Votre choix : ");
        int choix = scanner.nextInt();
        switch (choix) {
            case 1:
                testContient();
                break;
            case 2:
                testAjouter();
                break;
            case 3:
                testLesUrls();
                break;
            case 4:
                testSupprimer();
                break;

        }
    }

    private static void testContient() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;
        DicoSD dicoTeste;
        DicoSD dicoTesteCopie;
        String sd;
        boolean present;

        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12VecteurQcQ();
        dicoTesteCopie = dicoEnsQcQPile12VecteurQcQ();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        System.out.println("SD verifiee : "+sd);
        present = true;
        testContient(dicoTeste,dicoTesteCopie,sd,present);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoTesteCopie = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="ensemble";
        System.out.println("SD verifiee : "+sd);
        present = true;
        testContient(dicoTeste,dicoTesteCopie,sd,present);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoTesteCopie = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="vecteur";
        System.out.println("SD verifiee : "+sd);
        present = false;
        testContient(dicoTeste,dicoTesteCopie,sd,present);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoVide();
        dicoTesteCopie = dicoVide();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        System.out.println("SD verifiee : "+sd);
        present = false;
        testContient(dicoTeste,dicoTesteCopie,sd,present);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");

    }

    private static void testContient(DicoSD dicoSDAvant, DicoSD dicoSDCopie, String sd, boolean present) throws IllegalArgumentException, IllegalAccessException{
        try {
            HashMap<String, LinkedList<String>> mapAvant = (HashMap<String, LinkedList<String>>)map.get(dicoSDCopie);
            assertEquals("test ko : booleen : ko ",present, dicoSDAvant.contient(sd));
            HashMap<String, LinkedList<String>> mapApres = (HashMap<String, LinkedList<String>>)map.get(dicoSDAvant);
            assertEquals("test ko : la methode contient() ne peut modifier le contenu du map", mapAvant.toString(),mapApres.toString());
        } catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }

    }

    private static void testAjouter() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;
        DicoSD dicoTeste;
        DicoSD dicoAttendu;
        String sd;
        String url;
        boolean possible;

        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoAttendu = dicoEnsQcQPile123();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlPile3";
        System.out.println("association a ajouter : "+sd+"-"+url);
        possible = true;
        testAjouter(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoAttendu = dicoEnsQcQPile12Qcq();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlQcQ";
        System.out.println("association a ajouter : "+sd+"-"+url);
        possible = true;
        testAjouter(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoAttendu = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlPile2";
        System.out.println("association a ajouter : "+sd+"-"+url);
        possible = false;
        testAjouter(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoAttendu = dicoEnsQcQPile12VecteurQcQ();
        System.out.println("Dico teste : "+dicoTeste);
        sd="vecteur";
        url="urlQcQ";
        System.out.println("association a ajouter : "+sd+"-"+url);
        possible = true;
        testAjouter(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoVide();
        dicoAttendu = dicoEnsQcQ();
        System.out.println("Dico teste : "+dicoTeste);
        sd="ensemble";
        url="urlQcQ";
        System.out.println("association a ajouter : "+sd+"-"+url);
        possible = true;
        testAjouter(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testAjouter(DicoSD dicoTeste, DicoSD dicoAttendu, String sd, String url, boolean possible)throws IllegalArgumentException {
        try {
            HashMap<String, LinkedList<String>> mapAttendu = (HashMap<String, LinkedList<String>>)map.get(dicoAttendu);
            assertEquals("test ko : booleen : ko ",possible, dicoTeste.ajouter(sd,url));
            HashMap<String, LinkedList<String>> mapApres = (HashMap<String, LinkedList<String>>)map.get(dicoTeste);
            assertEquals("test ko : le contenu du map, n'est pas le contenu attendu", mapAttendu.toString(),mapApres.toString());
        } catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void testLesUrls() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;
        DicoSD dicoTeste;
        DicoSD dicoTesteCopie;
        String sd;
        String lesUrlsAttendus;

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12VecteurQcQ();
        dicoTesteCopie = dicoEnsQcQPile12VecteurQcQ();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        System.out.println("urls de : "+sd);
        lesUrlsAttendus = "[urlPile1, urlPile2]";
        testLesUrls(dicoTeste,dicoTesteCopie,sd,lesUrlsAttendus);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile123();
        dicoTesteCopie = dicoEnsQcQPile123();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        System.out.println("urls de : "+sd);
        lesUrlsAttendus = "[urlPile1, urlPile2, urlPile3]";
        testLesUrls(dicoTeste,dicoTesteCopie,sd,lesUrlsAttendus);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12VecteurQcQ();
        dicoTesteCopie = dicoEnsQcQPile12VecteurQcQ();
        System.out.println("Dico teste : "+dicoTeste);
        sd="vecteur";
        System.out.println("urls de : "+sd);
        lesUrlsAttendus = "[urlQcQ]";
        testLesUrls(dicoTeste,dicoTesteCopie,sd,lesUrlsAttendus);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile123();
        dicoTesteCopie = dicoEnsQcQPile123();
        System.out.println("Dico teste : "+dicoTeste);
        sd="vecteur";
        System.out.println("urls de : "+sd);
        lesUrlsAttendus = "[]";
        testLesUrls(dicoTeste,dicoTesteCopie,sd,lesUrlsAttendus);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoVide();
        dicoTesteCopie = dicoVide();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        System.out.println("urls de : "+sd);
        lesUrlsAttendus = "[]";
        testLesUrls(dicoTeste,dicoTesteCopie,sd,lesUrlsAttendus);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");

    }

    private static void testLesUrls(DicoSD dicoTeste, DicoSD dicoTesteCopie,String sd, String lesUrlsAttendus) throws IllegalArgumentException{
        try {
            HashMap<String, LinkedList<String>> mapAvant = (HashMap<String, LinkedList<String>>)map.get(dicoTesteCopie);
            String lesUrlsRecus = dicoTeste.lesURLs(sd);
            assertEquals("test ko : String : ko ",lesUrlsAttendus, lesUrlsRecus);
            HashMap<String, LinkedList<String>> mapApres = (HashMap<String, LinkedList<String>>)map.get(dicoTeste);
            assertEquals("test ko : la methode contient() ne peut modifier le contenu du map", mapAvant.toString(),mapApres.toString());
        } catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private static void testSupprimer() throws IllegalArgumentException, IllegalAccessException{
        System.out.println();
        int numTest = 0;
        DicoSD dicoTeste;
        DicoSD dicoAttendu;
        String sd;
        String url;
        boolean possible;

        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile123();
        dicoAttendu = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlPile3";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = true;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12Qcq();
        dicoAttendu = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlQcQ";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = true;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12VecteurQcQ();
        dicoAttendu = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="vecteur";
        url="urlQcQ";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = true;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQPile12();
        dicoAttendu = dicoEnsQcQPile12();
        System.out.println("Dico teste : "+dicoTeste);
        sd="vecteur";
        url="urlQcQ";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = false;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQ();
        dicoAttendu = dicoVide();
        System.out.println("Dico teste : "+dicoTeste);
        sd="ensemble";
        url="urlQcQ";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = true;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoEnsQcQ();
        dicoAttendu = dicoEnsQcQ();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlQcQ";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = false;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        numTest++;
        System.out.println("Test" + numTest);
        dicoTeste = dicoVide();
        dicoAttendu = dicoVide();
        System.out.println("Dico teste : "+dicoTeste);
        sd="pile";
        url="urlQcQ";
        System.out.println("association a supprimer : "+sd+"-"+url);
        possible = false;
        testSupprimer(dicoTeste,dicoAttendu,sd,url,possible);
        System.out.println("Test" + numTest + " : ok");

        System.out.println();
        System.out.println("tous les tests ont reussi");
    }

    private static void testSupprimer(DicoSD dicoTeste, DicoSD dicoAttendu, String sd, String url, boolean possible) {
        try {
            HashMap<String, LinkedList<String>> mapAttendu = (HashMap<String, LinkedList<String>>)map.get(dicoAttendu);
            assertEquals("test ko : booleen : ko ",possible, dicoTeste.supprimer(sd,url));
            HashMap<String, LinkedList<String>> mapApres = (HashMap<String, LinkedList<String>>)map.get(dicoTeste);
            assertEquals("test ko : le contenu du map, n'est pas le contenu attendu", mapAttendu.toString(),mapApres.toString());
        } catch (Exception e) {
            System.out.println("test ko : il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
    }


    private static DicoSD dicoEnsQcQPile12() throws IllegalArgumentException, IllegalAccessException{
        DicoSD dico = new DicoSD();
        HashMap<String, LinkedList<String>> mapC = new HashMap<>();
        LinkedList<String> lEns = new LinkedList<>();
        lEns.add("urlQcQ");
        mapC.put("ensemble",lEns);
        LinkedList<String> lPile = new LinkedList<>();
        lPile.add("urlPile1");
        lPile.add("urlPile2");
        mapC.put("pile",lPile);
        map.set(dico, mapC);
        return dico;
    }

    private static DicoSD dicoEnsQcQPile123() throws IllegalArgumentException, IllegalAccessException{
        DicoSD dico = new DicoSD();
        HashMap<String, LinkedList<String>> mapC = new HashMap<>();
        LinkedList<String> lEns = new LinkedList<>();
        lEns.add("urlQcQ");
        mapC.put("ensemble",lEns);
        LinkedList<String> lPile = new LinkedList<>();
        lPile.add("urlPile1");
        lPile.add("urlPile2");
        lPile.add("urlPile3");
        mapC.put("pile",lPile);
        map.set(dico, mapC);
        return dico;
    }

    private static DicoSD dicoEnsQcQPile12Qcq() throws IllegalArgumentException, IllegalAccessException{
        DicoSD dico = new DicoSD();
        HashMap<String, LinkedList<String>> mapC = new HashMap<>();
        LinkedList<String> lEns = new LinkedList<>();
        lEns.add("urlQcQ");
        mapC.put("ensemble",lEns);
        LinkedList<String> lPile = new LinkedList<>();
        lPile.add("urlPile1");
        lPile.add("urlPile2");
        lPile.add("urlQcQ");
        mapC.put("pile",lPile);
        map.set(dico, mapC);
        return dico;
    }

    private static DicoSD dicoEnsQcQ() throws IllegalArgumentException, IllegalAccessException{
        DicoSD dico = new DicoSD();
        HashMap<String, LinkedList<String>> mapC = new HashMap<>();
        LinkedList<String> lEns = new LinkedList<>();
        lEns.add("urlQcQ");
        mapC.put("ensemble",lEns);
        map.set(dico, mapC);
        return dico;
    }


    private static DicoSD dicoEnsQcQPile12VecteurQcQ() throws IllegalArgumentException, IllegalAccessException{
        DicoSD dico = new DicoSD();
        HashMap<String, LinkedList<String>> mapC = new HashMap<>();
        LinkedList<String> lEns = new LinkedList<>();
        lEns.add("urlQcQ");
        mapC.put("ensemble",lEns);
        LinkedList<String> lPile = new LinkedList<>();
        lPile.add("urlPile1");
        lPile.add("urlPile2");
        mapC.put("pile",lPile);
        map.set(dico, mapC);
        LinkedList<String> lVec = new LinkedList<>();
        lVec.add("urlQcQ");
        mapC.put("vecteur",lVec);
        return dico;
    }

    private static DicoSD dicoVide() throws IllegalArgumentException, IllegalAccessException{
        DicoSD dico = new DicoSD();
        HashMap<String, LinkedList<String>> mapC = new HashMap<>();
        map.set(dico, mapC);
        return dico;
    }


}
