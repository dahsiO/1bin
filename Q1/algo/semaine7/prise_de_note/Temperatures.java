import java.util.Arrays;

public class Temperatures {

    private String mois;
    private double[] tableDesTemperatures;

    // A NE PAS MODIFIER
    public Temperatures(String mois, double[] tableARecopier) {
        if (tableARecopier == null)
            throw new IllegalArgumentException();
        if (tableARecopier.length < 2)
            throw new IllegalArgumentException();
        this.mois = mois;
        this.tableDesTemperatures = new double[tableARecopier.length];
        for (int i = 0; i < tableARecopier.length; i++) {
            this.tableDesTemperatures[i] = tableARecopier[i];
        }
    }

    // A NE PAS MODIFIER
    public String toString() {
        String aRenvoyer = this.mois + " : ";
        return aRenvoyer + Arrays.toString(tableDesTemperatures);
    }


    /**
     * calcule la moyenne des temperatures
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     *
     * @return la moyenne
     */
    public double moyenne() {
        //TODO
        return 0;

    }


    /**
     * recherche la temperature la plus basse
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     *
     * @return la temperature la plus basse
     */
    public double temperatureMin() {
        //TODO
        return 0;

    }

    /**
     * recherche la temperature la plus elevee
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     *
     * @return la temperature la plus elevee
     */
    public double temperatureMax() {
        //TODO
        return 0;

    }

    /**
     * calcule le plus grand ecart (en valeur absolue) de temperature entre 2 jours quelconques
     * par exemple :
     * jour 1 : 5
     * jour 2 : 6
     * jour 3 : 4
     * jour 4 : 6
     * jour 5 : 7
     * jour 6 : 5
     * le plus grand ecart est 3. Il s'observe entre le jour 3 et le jour 5
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     * @return  le plus grand ecart de temperature
     */
    public double ecartMax(){
        //TODO
        return 0;

        //Cette methode est tres simple !
        //Piste :
        //Pensez a utiliser les 2 methodes precedentes.

    }

    /**
     * calcule le plus grand ecart en valeur absolue de temperature entre 2 jours successifs
     * par exemple :
     * jour 1 : 5
     * jour 2 : 7
     * jour 3 : 4
     * jour 4 : 6
     * jour 5 : 7
     * jour 6 : 5
     * le plus grand ecart est 3. Il s'observe entre le jour 2 et le jour 3.
     * (Les autres ecarts ont ete de 2 ou de 3)
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     * @return le plus grand ecart de temperature entre 2 jours successifs
     */
    public double ecartMaxSucc(){
        //TODO
        return 0;

        //valeur absolue --> Math.abs()

    }



    /**
     * calcule le nombre de temperatures negatives (< 0)
     *
     * @return le nombre de jours de gel
     */
    public int nombreJoursDeGel() {
        //TODO
        return 0;

    }


    /**
     * remplit une table avec les numeros des jours de gel
     * la dimension de cette table correspond a ce nombre de jours
     * @return une table avec les numeros des jours de gel
     */
    public int[] joursDeGel() {
        //TODO
        return null;

    }

}
