
public class DivisionEntiere {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez l'entier 1 : ");
		int entier1 = scanner.nextInt();

		System.out.print("Entrez l'entier 2 : ");
		int entier2 = scanner.nextInt();
		if (entier2 != 0){
			int quotient = entier1/entier2;
			System.out.println(entier1+"/"+entier2+" = "+quotient);
		}else
			System.out.println("Attention, division par 0");

	}
}
