public class ProfInterne extends Professeur{
    public static final int QUOTITE_PAR_DEFAUT = 100;
    private double salaireMensuel;
    private int quotiteTravail;

    public ProfInterne(String nom, String prenom, double salaireMensuel, int quotiteTravail) {
        super(nom, prenom);
        this.salaireMensuel = salaireMensuel;
        this.quotiteTravail = quotiteTravail;
    }

    public ProfInterne(String nom, String prenom, double salaireMensuel) {
        super(nom, prenom);
        this.salaireMensuel = salaireMensuel;
        this.quotiteTravail = QUOTITE_PAR_DEFAUT;
    }

    @Override
    public double calculerSalaire() {
        return (salaireMensuel * quotiteTravail)/100;
    }
    @Override
    public String toString() {
        return "Prof Interne " +super.toString()+ "\n" + "Salaire mensuel : " + salaireMensuel +"\n" + "Quotite travail : " + quotiteTravail ;
    }

}
