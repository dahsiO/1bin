import java.util.ArrayDeque;

public class Bal2 implements Bal{

    /**
     * Cette classe retient les etudiants inscrits au bal
     * Une liste contient les hommes, une autre liste contient les femmes
     * Dans chacune des listes, l'ordre suit l'ordre des inscriptions
     */

    ArrayDeque<Etudiant> dequeH;
    ArrayDeque<Etudiant> dequeF;

    /**
     * construit un bal "vide", les 2 listes sont vides
     */
    public Bal2(){
        //TODO

    }

    public void ajouterEtudiant(Etudiant etudiant){
        if(etudiant==null)
            throw new IllegalArgumentException("etudiant null");
        //TODO

    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString(){
        String listeH = dequeH.toString();
        listeH = listeH.substring(0,listeH.length()-1);
        String listeF = dequeF.toString();
        listeF = listeF.substring(1,listeF.length());
        if(listeH.length()>1 && listeF.length()>1)
            listeF = ", "+listeF;
        return listeH + listeF;
    }

}


