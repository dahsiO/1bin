public class DessinPriseElectrique{
    public static void main(String[] args) {
        Tortue tortue = new Tortue();
        for (int i = 0; i < 360; i++) {
            tortue.accelerer();
            tortue.avancer(1);
            tortue.tournerADroite(1);
        }
        //mettre le fond en noir pour pas voir
        tortue.definirCouleur("NOIR");
        tortue.tournerADroite(90);
        tortue.avancer(50);
        tortue.tournerAGauche(90);
        tortue.avancer(25);
        tortue.definirCouleur("BLANC");

        for (int i = 0; i < 360; i++) {
            tortue.accelerer();
            tortue.avancer(0.1);
            tortue.tournerADroite(1);
        }
        //mettre le fond en noir pour pas voir
        tortue.definirCouleur("NOIR");
        tortue.avancer(-50);
        tortue.definirCouleur("BLANC");
        for (int i = 0; i < 360; i++) {
            tortue.accelerer();
            tortue.avancer(0.1);
            tortue.tournerADroite(1);
        }
    }
}
