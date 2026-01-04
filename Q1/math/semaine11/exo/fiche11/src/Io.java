   /** Classe Io
		 Classe de lecture au clavier et de chargement de fichiers de données.
	
		 @author M.Marchand
   	 @version Mars 2008.
	*/
   
   import java.io.*;
   import java.util.*;

		
    public class Io {
    	private static Scanner scanner = new Scanner(System.in);
       public Io()
      {
      }

         
       public static Elt lireElt(){
         int i = 1;
         boolean flag = false;
         do {
            flag = true;
            String str = scanner.nextLine();
            if (str.toUpperCase().equals("MAXELT")) 
               return new Elt(Elt.MAXELT.val());
            try {
               i = Integer.parseInt(str);
               if ((i<1)||(i>Elt.MAXELT.val())){
                  System.out.println("Hors Univers (1.." + Elt.MAXELT.val() + ") : " + i);
                  System.out.println("Recommencez SVP.");
                  flag = false;
               }  
            } 
                catch (NumberFormatException nfe){
                  System.out.println("Entier incorrect. Recommencez SVP.");
                  flag = false;
               }           
         } while (!flag);
         return new Elt(i);        
      } // lireElt()
   
       public static Suite lireSuite()
      {
         System.out.print("(");
         Suite suite = null;
         String s = "";
         boolean flag;
         do
         {
            flag = true;
            BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(System.in));
            try
            {
               s = bufferedreader.readLine();
            }
                catch(IOException ioexception) { }
            try
            {
               suite = new Suite(s);
            }
                catch(MathException mathexception)
               {
                  System.out.println(mathexception + "\nRecommencez SVP");
                  flag = false;
               }
         } while(!flag);
         return suite;
      } // lireSuite()
      
   } // class