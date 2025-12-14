public class TestDrapeauTricolore {
   
   public static void main(String[] args) {
      System.out.println("Test 1");
      DrapeauTricolore d1 = new DrapeauTricolore(20);
      System.out.println("  Before sort: " + d1);
      d1.triTricolore();
      System.out.println("  After sort:  " + d1);  
      
      System.out.println("Test 2");
      DrapeauTricolore d2 = new DrapeauTricolore(2);
      System.out.println("  Before sort: " + d2);
      d2.triTricolore();
      System.out.println("  After sort:  " + d2);  

      System.out.println("Test 3");
      DrapeauTricolore d3 = new DrapeauTricolore(1);
      System.out.println("  Before sort: " + d3);
      d3.triTricolore();
      System.out.println("  After sort:  " + d3);              
   }
}
