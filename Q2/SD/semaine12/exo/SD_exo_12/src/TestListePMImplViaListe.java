import java.util.Scanner;

public class TestListePMImplViaListe<E> {
    
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
     *
     * @param messageErreur message a afficher en cas de probleme
     * @param attendu       la valeur qu'on s'attendait a recevoir
     * @param recu          la valeur qu'on a recu en realite
     */
    private static void assertEquals(String messageErreur, Object attendu, Object recu) {
        if (attendu == null) {
            if (recu != null) {

                System.out.println(messageErreur + "\n --> attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {

            System.out.println(messageErreur + "\n --> attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        System.out.println("*************************************************");
        System.out.println("Programme Test pour la classe ListePMImplViaListe");
        System.out.println("*************************************************");
        int choix = 0;
        do {
            System.out.println();
            System.out.println("Menu");
            System.out.println(("----"));
            System.out.println("1 -> Tester la methode contient()");
            System.out.println("2 -> Tester la methode donnerNieme()");
            System.out.println("3 -> Tester la methode supprimerDernier()");

            System.out.println();
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    testContient();
                    break;
                case 2:
                    testDonnerNieme();
                    break;
                case 3:
                    testSupprimerDernier();
                    break;
            }
        } while (choix >= 1 && choix <= 3);
    }

    private static void testContient() {
        int numTest = 0;
        Character[] tableTestee;
        ListePMImplViaListe<Character> liste;
        ListePMImplViaListe<Character> listeAttendue;

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("contient('a')");
        try {
            assertEquals("Test" + numTest + " ko  boolean renvoye ko :", true, liste.contient('a'));
            assertEquals("Test" + numTest + " ko nombre elements presents dans l'ensemble ko : ", 6, liste.taille());
            if (!liste.teteQueue().equals(listeAttendue.teteQueue())) {
                System.out.println("Test" + numTest + " ko contenu liste modifiee");
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");


        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("contient('e')");
        try {
            assertEquals("Test" + numTest + " ko  boolean renvoye ko :", true, liste.contient('e'));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("contient('k')");
        try {
            assertEquals("Test" + numTest + " ko  boolean renvoye ko :", true, liste.contient('k'));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("contient('j')");
        try {
            assertEquals("Test" + numTest + " ko  boolean renvoye ko :", false, liste.contient('j'));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'k', 'h', 'd', 'e', 'f', 'j'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a k h d e f j");
        System.out.println("contient('j')");
        try {
            assertEquals("Test" + numTest + " ko  boolean renvoye ko :", true, liste.contient('j'));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : vide");
        System.out.println("arbre : vide");
        System.out.println("contient('x')");
        try {
            assertEquals("Test" + numTest + " ko  boolean renvoye ko :", false, liste.contient('x'));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");
    }

    private static void testDonnerNieme() {
        int numTest = 0;
        Character[] tableTestee;
        ListePMImplViaListe<Character> liste;
        ListePMImplViaListe<Character> listeAttendue;

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("donnerNieme(2)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'f', liste.donnerNieme(2));
            assertEquals("Test" + numTest + " ko nombre elements presents dans l'ensemble ko :", 6, liste.taille());
            if (!liste.teteQueue().equals(listeAttendue.teteQueue())) {
                System.out.println("Test" + numTest + " ko contenu table modifiee");
                
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("donnerNieme(1)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'a', liste.donnerNieme(1));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("donnerNieme(3)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'c', liste.donnerNieme(3));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("donnerNieme(4)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'd', liste.donnerNieme(4));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b', 'c', 'd', 'e', 'f'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("donnerNieme(5)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'e', liste.donnerNieme(5));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e k");
        System.out.println("donnerNieme(6)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'k', liste.donnerNieme(6));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'j', 'b'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e j b");
        System.out.println("donnerNieme(6)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'j', liste.donnerNieme(6));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'f', 'c', 'd', 'e', 'j', 'b'};
        liste = new ListePMImplViaListe<>(tableTestee);
        System.out.println("liste : a f c d e j b");
        System.out.println("donnerNieme(7)");
        try {
            assertEquals("Test" + numTest + " ko caractere renvoye ko :", 'b', liste.donnerNieme(7));
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");

    }

    private static void testSupprimerDernier() {

        int numTest = 0;
        Character[] tableTestee;
        Character[] tableAttendue;
        ListePMImplViaListe<Character> liste;
        ListePMImplViaListe<Character> listeAttendue;

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'j', 'c', 'd', 'e', 'k', 'b'};
        tableAttendue = new Character[]{'a', 'j', 'c', 'd', 'e', 'k'};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableAttendue);
        System.out.println("liste : a j c d e k b");
        System.out.println("supprimerDernier");
        try {
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', liste.supprimerDernier());
            assertEquals("Test" + numTest + " ko apres suppression, nombre elements presents dans l'ensemble ko :", 6, liste.taille());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens --> :",listeAttendue.teteQueue(),liste.teteQueue());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens <-- :",listeAttendue.queueTete(),liste.queueTete());
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");


        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'j', 'c', 'd', 'e'};
        tableAttendue = new Character[]{'a', 'j', 'c', 'd'};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableAttendue);
        System.out.println("liste : a j c d e ");
        System.out.println("supprimerDernier");
        try {
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'e', liste.supprimerDernier());
            assertEquals("Test" + numTest + " ko apres suppression, nombre elements presents dans l'ensemble ko :", 4, liste.taille());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens --> :",listeAttendue.teteQueue(),liste.teteQueue());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens <-- :",listeAttendue.queueTete(),liste.queueTete());
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'j', 'c', 'd'};
        tableAttendue = new Character[]{'a', 'j', 'c'};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableAttendue);
        System.out.println("liste : a j c d");
        System.out.println("supprimerDernier");
        try {
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'd', liste.supprimerDernier());
            assertEquals("Test" + numTest + " ko apres suppression, nombre elements presents dans l'ensemble ko :", 3, liste.taille());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens --> :",listeAttendue.teteQueue(),liste.teteQueue());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens <-- :",listeAttendue.queueTete(),liste.queueTete());
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a', 'b'};
        tableAttendue = new Character[]{'a'};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableAttendue);
        System.out.println("liste : a b");
        System.out.println("supprimerDernier");
        try {
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'b', liste.supprimerDernier());
            assertEquals("Test" + numTest + " ko apres suppression, nombre elements presents dans l'ensemble ko :", 1, liste.taille());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens --> :",listeAttendue.teteQueue(),liste.teteQueue());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens <-- :",listeAttendue.queueTete(),liste.queueTete());
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{'a'};
        tableAttendue = new Character[]{};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableAttendue);
        System.out.println("liste : a");
        System.out.println("supprimerDernier");
        try {
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", 'a', liste.supprimerDernier());
            assertEquals("Test" + numTest + " ko apres suppression, nombre elements presents dans l'ensemble ko :", 0, liste.taille());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens --> :",listeAttendue.teteQueue(),liste.teteQueue());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens <-- :",listeAttendue.queueTete(),liste.queueTete());
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        numTest++;
        System.out.println();
        System.out.println("Test" + numTest);
        tableTestee = new Character[]{};
        tableAttendue = new Character[]{};
        liste = new ListePMImplViaListe<>(tableTestee);
        listeAttendue = new ListePMImplViaListe<>(tableAttendue);
        System.out.println("liste : vide");
        System.out.println("arbre : vide");
        System.out.println("supprimerDernier");
        try {
            assertEquals("Test" + numTest + " ko  caractere renvoye ko :", null, liste.supprimerDernier());
            assertEquals("Test" + numTest + " ko apres suppression, nombre elements presents dans l'ensemble ko :", 0, liste.taille());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens --> :",listeAttendue.teteQueue(),liste.teteQueue());
            assertEquals("Test" + numTest + " ko apres suppression, probleme dans le chainage dans le sens <-- :",listeAttendue.queueTete(),liste.queueTete());
        } catch (Exception e) {
            System.out.println("Test" + numTest + " ko");
            System.out.println("Il y a eu une exception non attendue");
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Test" + numTest + " ok");

        System.out.println();
        System.out.println("Tous les tests ont reussi");

    }

}


