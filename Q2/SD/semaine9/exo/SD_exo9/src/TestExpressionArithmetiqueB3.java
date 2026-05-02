import java.util.Scanner;


public class TestExpressionArithmetiqueB3 {

    private final static Scanner scanner = new Scanner(System.in);

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
                System.out.println(messageErreur + ". Attendu=" + attendu + " recu=" + recu);
                System.exit(0);
            }
        } else if (!attendu.equals(recu)) {
            System.out.println(messageErreur + ". Attendu=" + attendu + " recu=" + recu);
            System.exit(0);
        }
    }

    public static ExpressionArithmetique exp(int i) {
        if (i == 1) {
            ExpressionArithmetique ag = new ExpressionArithmetique('3');
            ExpressionArithmetique ad = new ExpressionArithmetique('2');
            ExpressionArithmetique a = new ExpressionArithmetique('-', ag, ad);
            ag = new ExpressionArithmetique('9');
            ad = new ExpressionArithmetique('3');
            ad = new ExpressionArithmetique('/', ag, ad);
            ag = new ExpressionArithmetique('4');
            ad = new ExpressionArithmetique('*', ag, ad);
            a = new ExpressionArithmetique('+', a, ad);
            return a;
        }
        if (i == 2) {
            ExpressionArithmetique bg = new ExpressionArithmetique('4');
            ExpressionArithmetique bd = new ExpressionArithmetique('1');
            bd = new ExpressionArithmetique('-', bg, bd);
            bg = new ExpressionArithmetique('8');
            bg = new ExpressionArithmetique('*', bg, bd);
            bd = new ExpressionArithmetique('4');
            bg = new ExpressionArithmetique('+', bg, bd);
            bd = new ExpressionArithmetique('1');
            bd = new ExpressionArithmetique('-', bg, bd);
            bg = new ExpressionArithmetique('4');
            ExpressionArithmetique b = new ExpressionArithmetique('+', bg, bd);
            return b;
        }
        if (i == 3) {
            ExpressionArithmetique ag = new ExpressionArithmetique('3');
            ExpressionArithmetique ad = new ExpressionArithmetique('2');
            ExpressionArithmetique a = new ExpressionArithmetique('+', ag, ad);
            ag = new ExpressionArithmetique('9');
            ad = new ExpressionArithmetique('3');
            ad = new ExpressionArithmetique('+', ag, ad);
            ag = new ExpressionArithmetique('4');
            ad = new ExpressionArithmetique('+', ag, ad);
            a = new ExpressionArithmetique('+', a, ad);
            return a;
        }
        if (i == 4) {
            return new ExpressionArithmetique('3');
        }
        return null;
    }


    public static void main(String[] args) {

        System.out.println("****************************************************");
        System.out.println("💣💣💣    Programme Test pour le Défi B3     💣💣💣");
        System.out.println("****************************************************");

        testDefiB3();
    }


    private static void testDefiB3(){
        String s1 = "((3-2)+(4*(9/3)))";
        String s2 = "(4+(((8*(4-1))+4)-1))";
        String s3 = "((3+2)+(4+(9+3)))";
        String s4 = "3";
        String s5 = "2+2";
        String s6 = "2+(2-2)";

        ExpressionArithmetique exp1 = new ExpressionArithmetique(s1);
        assertEquals("test exp1 ko", "((3-2)+(4*(9/3)))", exp1.notationInfixe());
        ExpressionArithmetique exp2 = new ExpressionArithmetique(s2);
        assertEquals("test exp2 ko", "(4+(((8*(4-1))+4)-1))", exp2.notationInfixe());
        ExpressionArithmetique exp3 = new ExpressionArithmetique(s3);
        assertEquals("test exp3 ko", "((3+2)+(4+(9+3)))", exp3.notationInfixe());
        ExpressionArithmetique exp4 = new ExpressionArithmetique(s4);
        assertEquals("test exp4 ko", "3", exp4.notationInfixe());
        ExpressionArithmetique exp5 = new ExpressionArithmetique(s5);
        assertEquals("test exp5 ko", "(2+2)", exp5.notationInfixe());
        ExpressionArithmetique exp6 = new ExpressionArithmetique(s6);
        assertEquals("test exp6 ko", "(2+(2-2))", exp6.notationInfixe());
        try {
            new ExpressionArithmetique("(2+(-3))");
            System.out.println("test expr mal formée KO");
            System.exit(0);
        } catch ( IllegalArgumentException ignored){

        } catch (Exception e){
            System.out.println("test expr mal formée KO: exception inattendue. " + e);
            System.exit(0);
        }
        System.out.println("Tous les tests ont reussi");
        System.out.println();
    }


}
