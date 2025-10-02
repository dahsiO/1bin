public class Cercle {
   private double hauteur;
   private double rayon;

    public Cercle(double hauteur, double rayon) {
        if (rayon <= 0){
             rayon = 1;
        }else
        this.hauteur = hauteur;
        this.rayon = rayon;
    }
    double calculerAir(){
       return Math.PI * rayon * rayon;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "hauteur=" + hauteur +
                ", rayon=" + rayon +"l air est ;" +calculerAir()+
                '}';
    }
}
