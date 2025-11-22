public class Patient {
    private String nom;
    private double poids;
    private double taille;

    public Patient(String nom, double poids, double taille) {
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
    }

    public Patient(double poids, double taille) {
        this("",poids,taille);
    }

    /**
     * calcule le bmi
     * @return le bmi
     */
    public double calculBmi(){
        return 0;
        //TODO
    }

    /**
     * renvoie sous forme d'une string, l'etat du patient
     * bmi < 20 : mince
     * [20,25] : normal
     * ]25,30] : en embonpoint
     * bmi > 30 : obese
     * @return l'etat du patient
     */
    public String donnerEtat(){
        return "";
        //TODO

        //pour connaitre le bmi :
        //ne faites pas le calcul !
        //appelez la methode calculBmi() !!!
    }
}


