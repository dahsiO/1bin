public class CarteDeJeu {
    private int cout;

    public CarteDeJeu(int cout) {
        this.cout = cout;
    }

    public int getCout() {
        return cout;
    }
    public String fournirDetail(){
        return "carte - cou: "+cout;
    }
}
