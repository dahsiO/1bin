public class Bmi {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("met ton poid  :");
        double poid = scanner.nextDouble();
        System.out.println("met ta taille :");
        double taille = scanner.nextDouble();
        System.out.println("nous allons calculer votre bmi"+"taille :" +taille+ "poid "+ poid );

       double bmi = poid/taille*taille;
        if (bmi < 20){
            System.out.println("t es mince poto");
        }else if (bmi < 25 && bmi > 20){
            System.out.println("t es bien");
        }else
            System.out.println("tu coonsome");
    }
}
