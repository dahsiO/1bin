public class DessinEnvloppe {
    public static void main(String[] args) {
        Tortue tortue = new Tortue();
        for (int i = 0; i < 4; i++) {
            tortue.tournerADroite(90);
            tortue.avancer(100);
        }
        for (int i = 0; i < 2; i++) {
            tortue.tournerADroite(120);
            tortue.avancer(100);
        }
    }
}

