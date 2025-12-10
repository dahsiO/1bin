import java.util.Arrays;

public class EquipeGuerriers {

    private Guerrier[] tableGuerriers;

    /**
     * calcule le nombre de guerriers en vie
     * @return le nombre de guerriers en vie
     */
    public int nombreGuerriersEnVie(){
        //TODO
        int nombre = 0;
        for (int i = 0; i < tableGuerriers.length; i++) {
           int point = tableGuerriers[i].getPointsDeVie();
           if (point > 0) nombre++;
        }

        return nombre;
    }


    /**
     * verifie s'il y a au moins 1 guerrier en vie
     * @return true s'il y a moins 1 guerrier en vie, false sinon
     */
    public boolean auMoins1GuerrierEnVie(){
        //TODO
        // Pour une question d'efficacite, n'utilisez pas la methode nombreGuerriersEnVie()!
        // (La methode nombreGuerriersEnVie() parcourt toujours l'entierete de la table.)
        // Il n'est peut-etre pas necessaire de parcourir l'entierete de la table pour cette methode.
        for (int i = 0; i < tableGuerriers.length; i++) {
                if (tableGuerriers[i].getPointsDeVie() > 1)
              return true;
        }
        return false;
    }


    /**
     * renvoie le premier guerrier en vie
     * @return le premier guerrier en vie ou null si tous les guerriers sont morts
     */
    public Guerrier premierGuerrierEnVie(){
        //TODO
        // Pour une question d'efficacite, n'utilisez pas les methodes nombreGuerriersEnVie() et auMoins1GuerrierEnVie()
        // Il n'est peut-etre pas necessaire de parcourir l'entierete de la table pour cette methode.
        for (int i = 0; i < tableGuerriers.length; i++) {
                if (tableGuerriers[i].getPointsDeVie() > 1) {
                    return tableGuerriers[i];
                }
        }
        return null;
    }


    /**
     * renvoie le nombre de points de vie d'un guerrier
     * @param nomGuerrier le nom du guerrier recherche
     * @return les points de vie du guerrier s'il est dans l'equipe, -1 sinon
     * @throws IllegalArgumentException si le nom du guerrier est null ou vide
     */
    public int getPointsDeVie(String nomGuerrier){
        if(nomGuerrier==null || nomGuerrier.length()==0)
            throw new IllegalArgumentException();
        //TODO
        // Pour comparer des String, utilisez la methode equals().
        for (int i = 0; i < tableGuerriers.length; i++) {
            if (tableGuerriers[i].getNom().equals(nomGuerrier)){
                return tableGuerriers[i].getPointsDeVie();
            }
        }
        return -1;
    }


    /**
     * remplit une table avec les guerriers en vie
     * (cette table pourrait etre vide)
     * @return une table avec les guerriers en vie
     */
    public Guerrier[] donnerTableGuerriersEnVie() {
        //TODO
        // Attention, la dimension d'une table renvoyee doit TOUJOURS correspondre au nombre de donnees qu'elle contient.
        // Pour connaitre cette dimension, utilisez la methode nombreGuerriersEnVie() !
        Guerrier[] tableDeGuerrierEnVie = new Guerrier[nombreGuerriersEnVie()];
        for (int i = 0; i < nombreGuerriersEnVie() ; i++) {
           if (tableGuerriers[i].getPointsDeVie() > 1){
             Guerrier  x = tableGuerriers[i];

           }
        }
        return null;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public EquipeGuerriers(Guerrier[] tableARecopier) {
        tableGuerriers = new Guerrier[tableARecopier.length];
        for (int i = 0; i < tableARecopier.length; i++) {
            tableGuerriers[i]=tableARecopier[i];
        }
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString(){
        return Arrays.toString(tableGuerriers);
    }

}
