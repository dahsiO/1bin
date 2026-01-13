package AF1.AF1;

import java.util.Arrays;

public class ClassementJoueurs{

	private Joueur[] tableJoueurs; // table triee selon l'ordre decroissant des scores des joueurs
	                               // cette table contient au minimum 2 joueurs
	private static int MAX_TENTATIVES = 3;

	/**
	 * construit un classement avec les joueurs dont les noms sont fournis en parametre
	 * chaque joueur debute avec son score et son nombre de tentative a 0
	 * @param tableNomsJoueurs la table avec les noms des joueurs
	 * @throws IllegalArgumentException
	 * 			si la table est null
	 * 		    s'il n'y a pas au moins 2 joueurs
	 * 		    s'il y a des homonymes
	 */
	public ClassementJoueurs(String[] tableNomsJoueurs) {
		if(tableNomsJoueurs == null)
			throw new IllegalArgumentException();
		if(tableNomsJoueurs.length < 2)
			throw new IllegalArgumentException("il faut au minimum 2 joueurs");
		if(contientHomonymes(tableNomsJoueurs))
			throw new IllegalArgumentException();
		tableJoueurs = new Joueur[tableNomsJoueurs.length];
		for (int i = 0; i < tableNomsJoueurs.length; i++) {
			tableJoueurs[i] = new Joueur(tableNomsJoueurs[i],0,0);
		}
	}

	/**
	 * verifie la presence d'homonyme parmi les joueurs
	 * @param tableNomsJoueurs la table avec les noms des joueurs
	 * @return true si la table tableNomsJoueurs contient au moins 2 joueurs qui ont le meme nom, false sinon
	 * @throws IllegalArgumentException si la table est null
	 */
	public static boolean contientHomonymes(String[] tableNomsJoueurs){
		if(tableNomsJoueurs == null)
			throw new IllegalArgumentException();
		//TODO
		for (int i = 0; i < tableNomsJoueurs.length ; i++) {
			for (int j = i + 1; j < tableNomsJoueurs.length; j++) {
				if (tableNomsJoueurs[i].equals(tableNomsJoueurs[j])) {
					return true;
				}
			}
		}
		return false;

		// pour comparer des String, utilisez la methode equals()

	}


	/**
	 * calcule le plus grand ecart de scores entre 2 joueurs qui se suivent dans le classement
	 * precondition (a ne pas verifier) : il y a au moins 2 joueurs
	 * @return l'ecart de scores maximum entre 2 joueurs qui se suivent dans le classement
	 */
	public int ecartMaximum() {
		//TODO
		int ecart = 0;

		for (int i = 0; i < tableJoueurs.length -1; i++) {
			int formule = tableJoueurs[i].getMeilleurScore() - tableJoueurs[i+1].getMeilleurScore();
			if (formule > ecart){
				ecart = formule;
			}
		}


		return ecart;

		//(rappel : la table contient au minimum 2 joueurs)

	}

	/**
	 * calcule le nombre de joueurs qui peuvent encore jouer
	 * un joueur peut encore jouer s'il a encore droit a au moins 1 tentative
	 * @return le nombre de joueurs qui peuvent encore jouer
	 */
	public int nombreJoueursEnJeu(){
		//TODO
		int compteur = 0;
		for (int i = 0; i < tableJoueurs.length; i++) {
			if (tableJoueurs[i].getNombreTentatives() < MAX_TENTATIVES) {
				compteur++;
			}
		}
		return compteur;

	}


	/**
	 * renvoie une table avec les joueurs qui peuvent encore jouer
	 * la taille de la table renvoyee correspond au nombre de joueurs qui peuvent encore jouer
	 * cette table pourrait etre vide
	 * @return une table contenant les joueurs qui peuvent encore jouer
	 */
	public Joueur[] joueursEnJeu() {
		// TODO

		Joueur[] tableJoueurEnJeu = new Joueur[nombreJoueursEnJeu()];
		int index = 0;
		for (int i = 0; i < tableJoueurs.length; i++) {
			if (tableJoueurs[i].getNombreTentatives() < MAX_TENTATIVES) {
				tableJoueurEnJeu[index] = tableJoueurs[i];
				index++;
			}
		}
		return tableJoueurEnJeu;

	}


	/**
	 * recherche a quel indice se trouve le joueur dont le nom est passe en parametre
	 * @param nomJoueur le nom du joueur recherche
	 * @return l'indice ou -1 si le nom n'est pas present
	 */
	private int trouverIndice(String nomJoueur){
		//A NE PAS MODIFIER!!!
		for (int i = 0; i < tableJoueurs.length; i++) {
			if(nomJoueur.equals(tableJoueurs[i].getNom()))
				return i;
		}
		return -1;
	}


	/**
	 * met a jour le meilleur score d'un joueur, son nombre de tentatives, ainsi que le classement
	 *
	 * voici les conditions pour qu'il y ait modification du meilleur score du joueur :
	 * le joueur doit exister
	 * le nombre max de tentatives n'est pas atteint pour ce joueur
	 * le nouveau score est meilleur (>) que son meilleur score
	 *
	 * voici les conditions pour qu'il y ait modification du nombre de tentatives :
	 * le joueur doit exister
	 * le nombre max de tentatives n'est pas atteint pour ce joueur
	 *
	 * La table doit rester triee selon l'ordre decroissant des meilleurs scores des joueurs
	 * en cas d'ex-aequo, ce joueur doit apparaitre apres le joueur qui a le meme meilleur score
	 *
	 * @param nomJoueur le nom du joueur
	 * @param nouveauScore le score obtenu par le joueur lors de cette tentative
	 * @return true si l'ordre des joueurs dans le classement a ete modifie, false sinon
	 * @throws IllegalArgumentException en cas de parametre invalide
	 */
	public boolean modifierClassement(String nomJoueur, int nouveauScore) {
		if(nomJoueur==null||nomJoueur.length()==0)
			throw new IllegalArgumentException();
		if(nouveauScore < 0)
			throw new IllegalArgumentException();
		// TODO
		// 1. Trouver l'indice du joueur
		int indice = trouverIndice(nomJoueur);

		// Si le joueur n'existe pas, on ne peut rien faire
		if(indice == -1)
			return false;

		// 2. Vérifier si le nombre max de tentatives est atteint
		if(tableJoueurs[indice].getNombreTentatives() >= MAX_TENTATIVES)
			return false;

		// 3. Augmenter le nombre de tentatives
		tableJoueurs[indice].ajouter1Tentative();

		// 4. Vérifier si on doit mettre à jour le meilleur score
		boolean scoreModifie = false;
		if(nouveauScore > tableJoueurs[indice].getMeilleurScore()) {
			tableJoueurs[indice].setMeilleurScore(nouveauScore);
			scoreModifie = true;
		}

		// 5. Si le score n'a pas été modifié, pas de réorganisation nécessaire
		if(!scoreModifie)
			return false;

		// 6. Réorganiser le classement (tri par insertion)
		// On remonte le joueur tant que son score est meilleur que celui d'avant
		boolean classementModifie = false;
		while(indice > 0 && tableJoueurs[indice].getMeilleurScore() > tableJoueurs[indice - 1].getMeilleurScore()) {
			// Échanger les joueurs
			Joueur temp = tableJoueurs[indice];
			tableJoueurs[indice] = tableJoueurs[indice - 1];
			tableJoueurs[indice - 1] = temp;

			indice--;
			classementModifie = true;
		}

		return classementModifie;


		//Prenez connaissance de la methode trouverIndice() ci-dessus.
		// ET UTILISEZ-LA !

		//Pour modifier le score d'un joueur, utilisez la methode setMeilleurScore().
		//Pour augmenter de 1 le nombre de tentatives d'un joueur, utilisez la methode ajouter1Tentative().

		//N'oubliez pas que la table doit etre maintenue triee.

	}

	//VA SERVIR POUR LES TESTS
	//A NE PAS MODIFIER!!!
	@Override
	public String toString() {
		return Arrays.toString(tableJoueurs);
	}

	//VA SERVIR POUR LES TESTS
	//A NE PAS MODIFIER!!!
	public ClassementJoueurs(Joueur[] tableARecopier) {
		tableJoueurs = new Joueur[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableJoueurs[i] = tableARecopier[i];
		}
	}

}
