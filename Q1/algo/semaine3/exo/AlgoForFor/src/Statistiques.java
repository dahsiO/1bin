
public class Statistiques {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le nombre de cotes : ");
		int nombreCotes = scanner.nextInt();

		double sommeDesNote = 0;
		double coteMin = 0;
		double coteMax = 0; // la plus petite cote possible
		for (int i = 1; i <= nombreCotes ; i++) {
			System.out.print("Entrez la cote numero " + i + ": ");
			double cote = scanner.nextDouble();
			if(cote>coteMax){
				coteMax = cote;
			}
			if (cote<coteMin){
				coteMin = cote;
			}
			sommeDesNote+= cote;
		}
		System.out.println("La cote la plus elevee est "+ coteMax);
		System.out.println("la cote la plus basse est  :"+ coteMin);
		System.out.println("la moyenne est :"+sommeDesNote/nombreCotes);
	}
}
