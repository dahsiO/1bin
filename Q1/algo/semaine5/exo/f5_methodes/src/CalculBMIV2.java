public class CalculBMIV2 {

    public static Utilitaires util = new Utilitaires();

    public static void main(String[] args) {
        System.out.print("Entrez votre poids : ");
        double poids= util.lireReelPositif();
        System.out.print(("Entrez votre taille : "));
        double taille = util.lireReelPositif();
        double bmi = calculerBmi(poids,taille);
        System.out.println("Votre bmi : "+ bmi);
        String etat = donnerEtat(bmi);
        System.out.println("Votre etat : "+etat);
    }

    /**
     * calcule le bmi
     * @param poids le poids exprime en kg
     * @param taille la taille exprimee en m
     * @return le bmi
     */
    public static double calculerBmi(double poids, double taille){
        return 0;
        //TODO
    }

    /**
     * renvoie sous forme d'une chaine de caracteres, l'etat du patient
     * bmi < 20 : mince
     * [20,25] : normal
     * ]25,30] : en embonpoint
     * bmi > 30 : obese
     * @return l'etat du patient
     */
    public static String donnerEtat(double bmi){
        return "";
        //TODO
    }

}
