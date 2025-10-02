public class Note {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("met ta note");
        int note = scanner.nextInt();
        if (note < 10) {
            System.out.println("ta rater ta vie");
        } else if (note >= 10 && note < 14) {

            System.out.println("tu a valider l'ue");
        } else if (note > 14 && note < 16) {
            System.out.println("tu a valider avec une belle cote");
        } else System.out.println("bsaha");
    }
}