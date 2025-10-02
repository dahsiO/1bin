public class Rectangle {
    double longeur;
    double largeur;

    public Rectangle(double longeur, double largeur) {
        this.longeur = longeur;
        this.largeur = largeur;
    }
    double airRectangle(){
        return longeur * largeur;
    }
    double perimetre(){
        return 2* (longeur + largeur);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "longeur=" + longeur +
                ", largeur=" + largeur + "calculer l air "+airRectangle()+
                "perimetre : "+perimetre()+
                '}';
    }
}
