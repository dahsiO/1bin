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
        return mapSDUrls.containsKey(sd); // true
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
		// si SD absente => on cree un enouvelles liste avec l url dedans, on l'ajoute a la map
		if (!mapSDUrls.containsKey(sd)) {
			LinkedList<String> liste = new LinkedList<>();
			liste.add(url);
			mapSDUrls.put(sd, liste);
			return true;
		}
		// sinon ca veut dire que sd etais deja present
		LinkedList<String> liste = mapSDUrls.get(sd);
		// ont verifie si url est deja dedans
		if (liste.contains(url)) return false; // false si dedja dedans
		// sinon ont l ajoute apres return true
		liste.add(url);
		return true;
		//TODO
		/*
		* si la key est pas utiliser on rajoute notre key + value  simple
		* si la key est deja utiliser => on recupere la value a la quelle il est rattacher
		* si c est la value == url  bah return false ca veut dire que la key + value exite deja dansla map on a rien a ajouter
		* sinon on rajoute notre value a la key et voila
		* */
	}




	
	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		if (!mapSDUrls.containsKey(sd)) return "[]";
		return mapSDUrls.get(sd).toString();
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
		if (!mapSDUrls.containsKey(sd)) return false;
		LinkedList<String> liste = mapSDUrls.get(sd);
		if (!liste.contains(url)) return false;
		liste.remove(url);
		if (liste.isEmpty()) mapSDUrls.remove(sd);
		return true;
		//TODO
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    @Override
    public String toString() {
        return mapSDUrls.toString();
    }
}
