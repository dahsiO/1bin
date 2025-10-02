public class RechercheMax2 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("enter le premier entier : ");
        int entier1 = scanner.nextInt();
        System.out.println("enter le second entier : ");
        int entier2 = scanner.nextInt();

        if (entier1 > entier2){
            System.out.println(entier1);
        }else
        if (entier1 < entier2){
            System.out.println(entier2);
        }else
            System.out.println(entier1+ "est egale a "+entier2);
    }
}
