public class Lunette {
    public static void main(String[] args) {
        Tortue tortue = new Tortue();
        for (int i = 0; i < 4; i++) {
            tortue.tournerADroite(90);
            tortue.avancer(100);
        }
        tortue.avancer(50);

        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerADroite(90);

        }
    }
}
