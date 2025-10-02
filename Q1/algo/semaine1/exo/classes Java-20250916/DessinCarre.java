public class DessinCarre {

    public static void main(String[] args){

        Tortue tortue = new Tortue();
        for (int i = 0; i < 4; i++) {
            tortue.tournerAGauche(90);
            tortue.avancer(100);
        }

    }
}
