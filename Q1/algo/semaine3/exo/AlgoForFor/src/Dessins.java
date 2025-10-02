public class Dessins {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		int choix;
		do{
			afficherMenu();
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
				case 1: carre();
					break;
				case 2: triangleVersion1();
					break;

				// A COMPLETER
			}
			System.out.println();
		}
		while(choix>=1 && choix<=2);
	}

	private static void afficherMenu(){
		System.out.println("*********");
		System.out.println("Dessins :");
		System.out.println("*********");
		System.out.println("1 -> carre");
		System.out.println("2 -> triangle version 1");
		// A COMPLETER
	}

	private static void carre() {
		System.out.print("\nEntrez n : ");
		int n=scanner.nextInt();
		// A COMPLETER
	}

	private static void triangleVersion1() {
		System.out.print("\nEntrez n : ");
		int n=scanner.nextInt();
		// A COMPLETER
	}

}
