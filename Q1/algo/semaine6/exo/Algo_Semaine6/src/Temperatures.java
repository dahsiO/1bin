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
        double somme =0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            somme += tableDesTemperatures[i];
        }
        return somme/tableDesTemperatures.length;

    }


    /**
     * recherche la temperature la plus basse
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     *
     * @return la temperature la plus basse
     */
    public double temperatureMin() {
        //TODO
        double min =  200;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] < min){
                min = tableDesTemperatures[i];
            }
        }
        return min;

    }

    /**
     * recherche la temperature la plus elevee
     * precondition (a ne pas verifier) la table des temperatures contient au moins 2 temperatures
     *
     * @return la temperature la plus elevee
     */
    public double temperatureMax() {
        //TODO
        double max = 0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] > max){
                max = tableDesTemperatures[i];
            }
        }
        return max;

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
        double tempMin = tableDesTemperatures[0];
        double tempMax =tableDesTemperatures[0];
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] < tempMin) {
                tempMin = tableDesTemperatures[i];
            }
            if (tableDesTemperatures[i] > tempMax){
                tempMax = tableDesTemperatures[i];
            }

        }
        return tempMax - tempMin;

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
        double ecartMax = 0;

        for (int i = 0; i < tableDesTemperatures.length - 1; i++) {
            double ecart = Math.abs(tableDesTemperatures[i] - tableDesTemperatures[i + 1]);
            if (ecart > ecartMax) {
                ecartMax = ecart;
            }
        }

        return ecartMax;
    }
//
//            1. **La boucle** : `i < tableDesTemperatures.length - 1` (pas juste `length`)
//            - Sinon `i+1` dépasserait la taille du tableau !
//            3. **Valeur absolue** : `Math.abs()` autour de la soustraction
//   - Sinon un écart négatif ne sera jamais > ecartMax





    /**
     * calcule le nombre de temperatures negatives (< 0)
     *
     * @return le nombre de jours de gel
     */
    public int nombreJoursDeGel() {
        //TODO
        int gel = 0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] < 0) {
                gel++;
            }
        }
        return gel;

    }


    /**
     * remplit une table avec les numeros des jours de gel
     * la dimension de cette table correspond a ce nombre de jours
     * @return une table avec les numeros des jours de gel
     */
    public int[] joursDeGel() {
        int [] tableGel = new int[nombreJoursDeGel()];
        int index = 0;
        for (int i = 0; i < tableDesTemperatures.length; i++) {
            if (tableDesTemperatures[i] < 0) {
                tableGel[index]  = i + 1;
                index++;
            }
        }
        //TODO
//        la methode commence par int donc on devrais retourner des int
//                donc faire attentions a ne pas cree un tableau en double
//
//                deplus commencer indexer notre nouvelle table
//                on reprend le i du fori qui sera lui notre compteur de jour

        return tableGel;

    }

}
