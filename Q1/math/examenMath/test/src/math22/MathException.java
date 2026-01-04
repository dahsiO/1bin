package math22;

/** Classe math22.MathException
	 Classe d'exceptions (runtime) pour le cours de Math.

	 @author  M.Marchand
	 @version Mars 2002
*/

public class MathException extends RuntimeException {
 
       public MathException() {
         super();
      }
   
       public MathException(String s) {
         super(s);
      }
   
   }