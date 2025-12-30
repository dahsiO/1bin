public class Employe extends Salarie{
    public static final double SALAIRE_DE_BASE = 1500.0;
    private double salaireMensuel;

    public Employe(String nom, String prenom, Chantier chantierActuel, double salaireMensuel) {
        super(nom, prenom, chantierActuel);
        this.salaireMensuel = salaireMensuel;
    }

    public Employe(String nom, String prenom, Chantier chantierActuel) {
        super(nom, prenom, chantierActuel);
        this.salaireMensuel = SALAIRE_DE_BASE;

        //a finire
    }

    @Override
    public double calculerSalaire() {
        //a completer
        return salaireMensuel;
    }
    @Override
    public String toString() {
        return "Employé " +super.toString() + "\n" + "Salaire mensuel : " + salaireMensuel ;
    }
}
