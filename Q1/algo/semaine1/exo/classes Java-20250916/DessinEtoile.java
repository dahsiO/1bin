public class DessinEtoile {
    public static void main(String[] args) {
        Tortue tortue = new Tortue();
        for (int i = 0; i < 4; i++) {
            tortue.tournerAGauche(120);
            tortue.avancer(100);
        }
        tortue.definirCouleur("NOIR");
        tortue.tournerAGauche(150);
        tortue.avancer(100);
        tortue.definirCouleur("BLANC");

        //remet dans le bon angle
        tortue.tournerADroite((30));
        for (int i = 0; i < 3; i++) {
            tortue.tournerADroite(120);
            tortue.avancer(100);
        }
    }


}
