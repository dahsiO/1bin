import java.util.Arrays;
import java.util.NoSuchElementException;

public class QuestionNPS {
	
	private String question;
	private int[] tableReponses;


	/**
	 * Construit une question NPS
	 * D'une part, il y a une question
	 * D'autre part, il y a les reponses des clients
	 * Une reponse valide est represente par un entier compris entre 0 et 10
	 * La table des reponses (tableReponses) va contenir uniquement des reponses valides
	 * On y transfere les reponses valides de la table recue en parametre
	 * L'ordre des reponses doit etre le meme dans les 2 tables
	 * tableReponses doit etre entierement remplie
	 * (Sa taille phyqique doit correspondre au nombre de reponses valides transferees)
	 * Ex : tableRecue : [5, -1, 7, 6, 7, 7, 11, -5, 3]  --> tableReponses : [5, 7, 6, 7, 7, 3]
	 * @param question la question posee au client
	 * @param tableRecue une table de reponses qui ne sont pas obligatoirement toutes valides
	 * @throws IllegalArgumentException si la question est null ou si la table recue est null
	 */
	public QuestionNPS(String question, int[] tableRecue){

		if(question==null)
			throw new IllegalArgumentException();
		if(tableRecue==null)
			throw new IllegalArgumentException();

		this.question = question;

		//TODO
		int nbDeReponseValide = 0;
		for (int i = 0; i < tableRecue.length; i++) {
			if (tableRecue[i] >= 0 && tableRecue[i] <= 10){
				nbDeReponseValide++;
			}

		}
		// Créer tableReponses avec la taille exacte
		this.tableReponses = new int[nbDeReponseValide];
		int index = 0;
		for (int i = 0; i < tableRecue.length; i++) {
			if (tableRecue[i] >= 0 && tableRecue[i] <= 10){
				this.tableReponses[index] = tableRecue[i];  // ✅ CORRECT
				index++;
			}

		}
		for (int i = 0; i < tableRecue.length; i++) {
			System.out.println("j ai reussi algo");
		}

		//Pour connaitre la taille physique de tableReponses :
		//Pensez a faire un premier parcours de tableRecue pour connaitre le nombre de reponses valides

	}


	/**
	 * calcule la moyenne des reponses
	 * @return la moyenne
	 * @throws NoSuchElementException s'il n'y a pas de reponse
	 */
	public double moyenne(){

		if(tableReponses.length == 0)
			throw new NoSuchElementException();

		// TODO
		//La moyenne est un reel
		//Pour provoquer une division reelle, commencez le calcul par 1.0 * ...
		int somme = 0;
		for (int i = 0; i < tableReponses.length; i++) {
			somme += tableReponses[i];
		}
		return 1.0 * somme/tableReponses.length;

	}


	/**
	 * recherche la mediane des reponses
	 * @return la mediane
	 * @throws NoSuchElementException s'il n'y a pas de reponse
	 */
	public int mediane(){

		if(tableReponses.length == 0)
			throw new NoSuchElementException();

		// TODO

		// Création d'une table temporaire (copie de tableReponses)
		int[] tableTemp = new int[tableReponses.length];
		for (int i = 0; i < tableReponses.length; i++) {
			tableTemp[i] = tableReponses[i];
		}

		// Nombre d'étapes
		int nbEtapes = (tableReponses.length / 2) + 1;

		int mediane = 0;

		// Pour chaque étape
		for (int etape = 0; etape < nbEtapes; etape++) {
			// Rechercher le minimum dans tableTemp
			int min = tableTemp[0];
			int indexMin = 0;

			for (int i = 1; i < tableTemp.length; i++) {
				if (tableTemp[i] < min) {
					min = tableTemp[i];
					indexMin = i;
				}
			}

			// Sauvegarder le minimum (à la dernière étape, ce sera la médiane)
			mediane = min;

			// Remplacer le minimum par 11
			tableTemp[indexMin] = 11;
		}

		return mediane;
	}

	/**
	 * calcule le score NPS 
	 * @return le score NPS
	 * @throws NoSuchElementException s'il n'y a pas de reponse
	 */
	public double scoreNPS(){

		if(tableReponses.length == 0)
			throw new NoSuchElementException();

		// TODO
		int nbPromoteurs = 0;   // réponses 9 et 10
		int nbDetracteurs = 0;  // réponses 0 à 6

		// Parcourir toutes les réponses
		for (int i = 0; i < tableReponses.length; i++) {
			if (tableReponses[i] >= 9) {
				nbPromoteurs++;
			} else if (tableReponses[i] <= 6) {
				nbDetracteurs++;
			}
			// Les réponses 7 et 8 (passifs) ne sont pas comptées
		}
		// cfr enonce

		// Le score est un reel. Il s'agit d'un pourcentage.
		// Pour provoquer une division reelle, commencez le calcul par 100.0 * ...

		// Calculer les pourcentages
		double pourcentagePromoteurs = 100.0 * nbPromoteurs / tableReponses.length;
		double pourcentageDetracteurs = 100.0 * nbDetracteurs / tableReponses.length;

		// Score NPS = % promoteurs - % détracteurs
		return pourcentagePromoteurs - pourcentageDetracteurs;
	}


	// A NE PAS CHANGER
	// VA SERVIR POUR LES TESTS
	public QuestionNPS(int[] tableARecopier){
		this.question = " ";
		this.tableReponses = new int[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableReponses[i]=tableARecopier[i];
		}
	}

	// A NE PAS CHANGER
	// VA SERVIR POUR LES TESTS
	public String toString(){
		return Arrays.toString(tableReponses);
	}

}
