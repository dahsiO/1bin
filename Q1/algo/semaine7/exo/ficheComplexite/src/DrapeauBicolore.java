import java.util.Arrays;
import java.util.Random;

public class DrapeauBicolore {
  private int[] t;

  // A NE PAS MODIFIER
  public DrapeauBicolore(int n) {
    t = new int[n];
    Random r = new Random();
    for (int i = 0; i != n; i++) {
      t[i] = r.nextInt();
    }
  }

  // A NE PAS MODIFIER
  public DrapeauBicolore(int[] tab) {
    t = tab;
  }

  public void tri() {
    int i = 0;
    int j = t.length;

    // AVANT ET APRES CHAQUE PASSAGE DANS LA BOUCLE,
    // ON A LA SITUATION SUIVANTE
    // ---------------------------------------------
    // |    PAIRS   | PAS MODIFIE |    IMPAIRS      |
    // ---------------------------------------------
    //               ^i            ^j

   
      //TODO
      
    
  }

  public String toString() {
    return Arrays.toString(t);
  }

  public static void main(String[] args) {
    System.out.println("  TEST 1");
    DrapeauBicolore d1 = new DrapeauBicolore(new int[] { 43, 18, 39, 76, 27, 85, 52 });
    System.out.println(d1.toString());
    d1.tri();
    System.out.println(d1.toString());
    System.out.println();

    System.out.println("  TEST 2");
    DrapeauBicolore d2 = new DrapeauBicolore(new int[] { 12, 18, 6, 24, 30 });
    System.out.println(d2.toString());
    d2.tri();
    System.out.println(d2.toString());
    System.out.println();

    System.out.println("  TEST 3");
    DrapeauBicolore d3 = new DrapeauBicolore(new int[] { 15, 7, 9, 21, 39, 3 });
    System.out.println(d3.toString());
    d3.tri();
    System.out.println(d3.toString());
    System.out.println();

    System.out.println("  TEST 4");
    DrapeauBicolore d4 = new DrapeauBicolore(15);
    System.out.println(d4.toString());
    d4.tri();
    System.out.println(d4.toString());
    System.out.println();
  }
}