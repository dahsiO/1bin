
public class TestPersoNoirJauneRouge {
	
	public static void main(String [] args){
		
		NoirJauneRouge njr = new NoirJauneRouge();
		njr.ajouter("nico", 'r');
		System.out.println(njr.toString());
		njr.ajouter("rene", 'r');
		System.out.println(njr.toString());
		njr.ajouter("noel", 'r');
		System.out.println(njr.toString());
		
		System.out.println("A completer a votre guise !");
	}
}
