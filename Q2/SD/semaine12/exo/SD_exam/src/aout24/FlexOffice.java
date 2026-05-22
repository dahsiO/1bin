import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;

public class FlexOffice {

	// suivez l'implementation imposee dans l'enonce
	// n'ajoutez pas d'autres attributs

	private String[] tableBureaux;
	private HashMap<String, Integer> mapEmployes;
	private ArrayDeque<Integer> pileBureauxLibres;
	private int phase = 1;


	/**
	 * initialise un espace de coworking
	 * precondition (a ne pas verifier) la table ne contient pas de null, pas de chaine vide ni d'homonyme
	 * @param nombreBureaux le nombre de bureaux
	 * @param tableEmployes la table des employes
	 * @throws IllegalArgumentException : il faut au moins un bureau et un employe
	 */
	public FlexOffice(int nombreBureaux, String[] tableEmployes){

		if(nombreBureaux<1)
			throw new IllegalArgumentException();
		if(tableEmployes==null || tableEmployes.length==0)
			throw new IllegalArgumentException();

		//TODO


	}
	
	/**
	 * reserve le bureau qui porte le numero passe en parametre a l'employe passe en parametre
	 * La reservation reussit si
	 *     le bureau est libre
	 *     l'employe existe
	 *     l'employe n'a pas encore reserve de bureau
	 * @param employe l'employe qui demande un bureau
	 * @param numeroBureau le numero du bureau souhaite
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si l'employe est null et/ou si le numero de bureau n'existe pas
	 * @throws IllegalStateException si on n'est pas en phase 1
	 */
	public boolean reserverLaVeille(String employe,int numeroBureau){

		if(employe==null)
			throw new IllegalArgumentException();
		if(numeroBureau<0||numeroBureau>= tableBureaux.length)
			throw new IllegalArgumentException();
		if(phase!=1)
			throw new IllegalStateException();

		//TODO
		return false;

	}

	/**
	 * donne le numero du bureau attribue a l'employe passe en parametre
	 * @param employe l'employe dont on veut connaitre son numero de bureau
	 * @return le numero du bureau ou -1 si l'employe n'existe pas ou n'a pas de bureau
	 * @throws IllegalArgumentException si l'employe est null
	 */
	public int retrouverBureauEmploye(String employe) {

		if(employe==null)
			throw new IllegalArgumentException();
		//TODO
		return -1;

	}

	/**
	 * a comme effet de passer de la phase 1 a la phase 2
	 * si deja en phase 2, rien ne doit etre fait
	 */
	public void changerPhase() {

		//TODO
		//Pensez a initialiser la pile!!!

	}

	/**
	 * attribue automatiquement un bureau libre a l'employe passe en parametre
	 * L'attribution reussit si
	 *     il y a encore un bureau de libre
	 *     l'employe existe
	 *     l'employe n'a pas encore reserve de bureau
	 * @param employe l'employe qui demande un bureau
	 * @return le numero du bureau attribue ou -1 si l'attribution a echoue
	 * @throws IllegalArgumentException si l'employe est null
	 * @throws IllegalStateException si on n'est pas en phase 2
	 */
	public int attribuerAutomatiquementBureau(String employe) {

		if(employe==null)
			throw new IllegalArgumentException();
		if(phase!=2)
			throw new IllegalStateException();

		//TODO
		return -1;

	}
	
	// Pour le debug
	public String toString(){

		// CETTE METHODE NE SERA PAS EVALUEE

		// vous pouvez modifier cette methode comme vous voulez
		// ne perdez pas de temps sur des affichages!

		if(phase==1) {
			if (tableBureaux == null)
				return "attention tableBureaux est null";
			if (mapEmployes == null)
				return "attention mapEmployes est null";
			return "tableBureaux :\n" + Arrays.toString(tableBureaux) + "\nmapEmployes :\n" + mapEmployes.toString();
		}
		if (tableBureaux == null)
			return "attention tableBureaux est null";
		if (mapEmployes == null)
			return "attention mapEmployes est null";
		if(pileBureauxLibres == null)
			return "attention pileBureauxLibres est null";
		return "tableBureaux :\n" + Arrays.toString(tableBureaux) + "\nmapEmployes :\n" + mapEmployes.toString()
				+"\npileBureauxLibres :" + pileBureauxLibres.toString();

	}


}
