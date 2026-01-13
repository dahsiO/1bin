package AF2.AF2;

import java.util.Arrays;

public class GrilleDepart {

	private Pilote[] tablePilotes; // table triee selon l'ordre croissant des temps des pilotes
	                               // cette table contient au minimum 2 pilotes
	private static int MAX_ESSAIS = 3;
	

	/**
	 * construit un grille de depart avec les pilotes dont les noms sont fournis en parametre
	 * chaque pilote debute avec son temps et son nombre d'essais a 0
	 * @param tableNomsPilotes la table avec les noms des pilotes
	 * @throws IllegalArgumentException
	 * 			si la table est null
	 * 		    s'il n'y a pas au moins 2 pilotes
	 * 		    s'il y a des homonymes
	 */
	public GrilleDepart(String[] tableNomsPilotes) {
		if(tableNomsPilotes == null)
			throw new IllegalArgumentException();
		if(tableNomsPilotes.length < 2)
			throw new IllegalArgumentException("il faut au minimum 2 pilotes");
		if(contientHomonymes(tableNomsPilotes))
			throw new IllegalArgumentException();
		tablePilotes = new Pilote[tableNomsPilotes.length];
		for (int i = 0; i < tableNomsPilotes.length; i++) {
			tablePilotes[i] = new Pilote(tableNomsPilotes[i],0,0);
		}
	}

	/**
	 * verifie la presence d'homonymes parmi les pilotes
	 * @param tableNomsPilotes la table avec les noms des pilotes
	 * @return true si la table tableNomsPilotes contient au moins 2 pilotes qui ont le meme nom, false sinon
	 * @throws IllegalArgumentException si la table est null
	 */
	public static boolean contientHomonymes(String[] tableNomsPilotes){
		if(tableNomsPilotes == null)
			throw new IllegalArgumentException();
		for (int i = 0; i < tableNomsPilotes.length; i++) {
			for (int j = i+1; j < tableNomsPilotes.length; j++) {
				if (tableNomsPilotes[i].equals(tableNomsPilotes[j])) {
					return true;
				}
			}
		}

		//TODO
		return false;

		// pour comparer des String, utilisez la methode equals()

	}


	/**
	 * calcule le plus grand ecart de temps entre 2 pilotes qui se suivent dans la grille
	 * precondition (a ne pas verifier) : il y a au moins 2 pilotes
	 * @return l'ecart de temps maximum entre 2 pilotes qui se suivent dans la grille
	 */
	public int ecartMaximum() {
		//TODO
		int ecart = 0;
		for (int i = 0; i < tablePilotes.length -1; i++) {
			int formule = tablePilotes[i + 1].getMeilleurTemps() - tablePilotes[i].getMeilleurTemps();
			if (formule > ecart) {
				ecart = formule;
			}
		}
		return ecart;

		//(rappel : la table contient au minimum 2 pilotes)

	}

	/**
	 * calcule le nombre de pilotes qui ont droit a encore au moins 1 essai
	 * @return le nombre de pilotes qui ont droit a encore au moins 1 essai
	 */
	public int nombrePilotesEnPhaseDEssais(){
		//TODO
		int compteur = 0;
		for (int i = 0; i < tablePilotes.length ; i++) {
			if (tablePilotes[i].getNombreEssais() < MAX_ESSAIS) {
				compteur++;
			}
		}
		return compteur;

	}


	/**
	 * renvoie une table avec les pilotes qui ont encore droit a encore au moins 1 essai
	 * la taille de la table renvoyee correspond au nombre de pilotes qui ont droit a encore
	 * au moins 1 essai
	 * cette table pourrait etre vide
	 * @return une table contenant les pilotes qui ont droit a encore au moins 1 essai
	 */
	public Pilote[] pilotesEnPhaseDEssais() {
		// TODO
		Pilote[] tablePilote1essais = new Pilote[nombrePilotesEnPhaseDEssais()];
		int index = 0;
		for (int i = 0; i < tablePilotes.length; i++) {
			if (tablePilotes[i].getNombreEssais() < MAX_ESSAIS) {
				tablePilote1essais[index] = tablePilotes[i];
				index++;
			}
		}
		return tablePilote1essais;

	}


	/**
	 * recherche a quel indice se trouve le pilote dont le nom est passe en parametre
	 * @param nomPilote le nom du pilote recherche
	 * @return l'indice ou -1 si le nom n'est pas present
	 */
	private int trouverIndice(String nomPilote){
		//A NE PAS MODIFIER!!!
		for (int i = 0; i < tablePilotes.length; i++) {
			if(nomPilote.equals(tablePilotes[i].getNom()))
				return i;
		}
		return -1;
	}


	/**
	 * met a jour le meilleur temps d'un pilote, son nombre d'essais, ainsi que la grille de depart
	 *
	 * voici les conditions pour qu'il y ait modification du meilleur temps du pilote :
	 * le pilote doit exister
	 * le nombre max d'essais n'est pas atteint pour ce pilote
	 * le nouveau temps est meilleur (<) que son meilleur temps
	 *
	 * voici les conditions pour qu'il y ait modification du nombre d'essais :
	 * le pilote doit exister
	 * le nombre max d'essais n'est pas atteint pour ce pilote
	 *
	 * La table doit rester triee selon l'ordre croissant des meilleurs temps des pilotes
	 * en cas d'ex-aequo, ce pilote doit apparaitre apres le pilote qui a le meme meilleur temps
	 *
	 * @param nomPilote le nom du pilote
	 * @param nouveauTemps le temps obtenu par le pilote lors de cet essai
	 * @return true si l'ordre des pilotes dans la grille de depart a ete modifie, false sinon
	 * @throws IllegalArgumentException en cas de parametre invalide
	 */
	public boolean modifierGrilleDepart(String nomPilote, int nouveauTemps) {
		if(nomPilote==null||nomPilote.length()==0)
			throw new IllegalArgumentException();
		if(nouveauTemps < 0)
			throw new IllegalArgumentException();
		// TODO
		// 1. Trouver l'indice du pilote
		int indice = trouverIndice(nomPilote);

		// Si le pilote n'existe pas, on ne peut rien faire
		if(indice == -1)
			return false;

		// 2. Vérifier si le nombre max d'essais est atteint
		if(tablePilotes[indice].getNombreEssais() >= MAX_ESSAIS)
			return false;

		// 3. Augmenter le nombre d'essais (toujours, si le pilote existe et a des essais restants)
		tablePilotes[indice].ajouter1Essai();

		// 4. Vérifier si on doit mettre à jour le meilleur temps
		boolean tempsModifie = false;
		if(nouveauTemps < tablePilotes[indice].getMeilleurTemps()) {
			tablePilotes[indice].setMeilleurTemps(nouveauTemps);
			tempsModifie = true;
		}

		// 5. Si le temps n'a pas été modifié, pas de réorganisation nécessaire
		if(!tempsModifie)
			return false;

		// 6. Réorganiser la grille (tri par insertion)
		// On remonte le pilote tant que son temps est meilleur que celui d'avant
		boolean grilleModifiee = false;
		while(indice > 0 && tablePilotes[indice].getMeilleurTemps() < tablePilotes[indice - 1].getMeilleurTemps()) {
			// Échanger les pilotes
			Pilote temp = tablePilotes[indice];
			tablePilotes[indice] = tablePilotes[indice - 1];
			tablePilotes[indice - 1] = temp;

			indice--;
			grilleModifiee = true;
		}

		return grilleModifiee;

		//Prenez connaissance de la methode trouverIndice() ci-dessus.
		// ET UTILISEZ-LA !

		//Pour modifier le temps d'un pilote, utilisez la methode setMeilleurTemps().
		//Pour augmenter de 1 le nombre d'essais d'un pilote, utilisez la methode ajouter1Essai().

		//N'oubliez pas que la table doit etre maintenue triee.

	}

	//VA SERVIR POUR LES TESTS
	//A NE PAS MODIFIER!!!
	@Override
	public String toString() {
		return Arrays.toString(tablePilotes);
	}

	//VA SERVIR POUR LES TESTS
	//A NE PAS MODIFIER!!!
	public GrilleDepart(Pilote[] tableARecopier) {
		tablePilotes = new Pilote[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			tablePilotes[i] = tableARecopier[i];
		}
	}

}
