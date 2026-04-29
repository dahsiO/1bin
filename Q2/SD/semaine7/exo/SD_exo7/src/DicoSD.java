import java.util.HashMap;
import java.util.LinkedList;

public class DicoSD {

    private HashMap<String, LinkedList<String>> mapSDUrls;

    // Au depart le dico est vide
    // A NE PAS MODIFIER !
	public DicoSD() {
        mapSDUrls = new HashMap<String, LinkedList<String>>();
    }

    /**
     * verifie si la structure de donnees se trouve dans le dico
     * @param sd
     * @return true si sd est present, false sinon
     */
    public boolean contient(String sd){
        return false;
        //TODO

    }


	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente
     * si sd est deja dans le dico, l'ajout de l'url se fait a la fin de sa liste d'urls
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
		return false;
        //TODO


    }

	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		return null;
		//TODO

    }
	
	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente
     * supprime sd du dico si celle-ci n'a plus d'url
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		return false;
		//TODO
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    @Override
    public String toString() {
        return mapSDUrls.toString();
    }
}
