public class DeuxMeilleurCotes {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        double coteMax = 0;// la plus petite cote possible
        double coteMax2 = 0;
        for (int i = 1; i <= 5 ; i++) {
            System.out.print("Entrez la cote numero " + i + ": ");
            double cote = scanner.nextDouble();
            // Si la cote est plus grande que la meilleure cote actuelle
            if (cote > coteMax) {
                // ⚠ Avant de remplacer coteMax1, on garde sa valeur dans coteMax2
                // car l'ancienne meilleure devient maintenant la 2e meilleure
                coteMax2 = coteMax;

                // On met à jour la nouvelle meilleure cote
                coteMax = cote;
            }
            // Sinon, si la cote n'est pas la meilleure, mais meilleure que la 2e
            else if (cote > coteMax2) {
                // On met simplement à jour la 2e meilleure cote
                coteMax2 = cote;
            }
        }
        System.out.println("la cote la plus grande est : "+coteMax +"et apres ca la cote la plus elever est : "+coteMax2);
    }
}