public class CalculBMIV3 {

    public static Utilitaires util = new Utilitaires();

    public static void main(String[] args) {
        System.out.print("Entrez votre poids : ");
        double poids= util.lireReelPositif();
        System.out.print(("Entrez votre taille : "));
        double taille = util.lireReelPositif();
        Patient patient = new Patient(poids,taille);
        System.out.println("Votre bmi : "+ patient.calculBmi());
        System.out.println("Votre etat : "+ patient.donnerEtat());
    }

}
