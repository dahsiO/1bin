public class Championnat {


        public static java.util.Scanner scanner = new java.util.Scanner(System.in);

        public static void main(String[] args) {
            double sommeDesNote = 0;
            double coteMin = 10;
            double coteMax = 0;// la plus petite cote possible

            for (int i = 1; i <= 8 ; i++) {
                System.out.print("Entrez la cote numero " + i + ": ");
                double cote = scanner.nextDouble();

                sommeDesNote+= cote;

                if(cote>coteMax){
                    coteMax = cote;
                }
                if (cote<coteMin){
                    coteMin = cote;
                }

            }
                // éliminer la plus haute et la plus basse
                double sommeSansExtremes = sommeDesNote - coteMax - coteMin;
                // calculer la moyenne sur les 6 restantes
                double moyenne = sommeSansExtremes / 6.0;
                System.out.println("La cote la plus elevee est "+ coteMax);
                System.out.println("la cote la plus basse est  :"+ coteMin);
                System.out.println("la moyenne est :"+moyenne);

                // sélection pour la finale
                if (moyenne >= 8) {
                    System.out.println("✅ Le concurrent est sélectionné pour la finale !");
                } else {
                    System.out.println("❌ Le concurrent n'est pas sélectionné.");
                }

        }
    }