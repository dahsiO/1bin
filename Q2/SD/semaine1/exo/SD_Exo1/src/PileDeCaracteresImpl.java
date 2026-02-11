// implementation d'une pile en utilisant un tableau de taille variable redimensionnable

import java.util.Arrays;

public class PileDeCaracteresImpl implements PileDeCaracteres{

	private char[] table; 			// ne modifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; 	// taille logique
								  	//ne mofifiez pas cet identifiant, va servir pour les tests

	
	public PileDeCaracteresImpl(){
		table = new char[4];
		nombreCaracteres = 0;
	}

	
	public PileDeCaracteresImpl(int capacite){
		if (capacite <= 0)
			throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	
	public int taille(){
		return nombreCaracteres;
	}

	
	public boolean estVide(){
		return nombreCaracteres == 0;
	}


	public char sommet()throws PileVideException{
		if (nombreCaracteres == 0) {
			throw new PileVideException();
		}
		return table[nombreCaracteres -1 ];
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)

	}


	public char pop() throws PileVideException{
		// TODO
		if (nombreCaracteres == 0) {
			throw new PileVideException();
		}

		// récupérer le sommet
		char sommet = table[nombreCaracteres - 1];

		// retirer l’élément de la pile
		nombreCaracteres--;

		return sommet;


	}


	public void push(char c){
		// TODO
			// si la table est pleine → on double la capacité
			if (nombreCaracteres == table.length) {
				char[] nouvelleTable = new char[table.length * 2];

				for (int i = 0; i < table.length; i++) {
					nouvelleTable[i] = table[i];
				}

				table = nouvelleTable;
			}

			table[nombreCaracteres] = c;
			nombreCaracteres++;
		}

		//A NE PAS MODIFIER
	@Override
	public String toString() {
		if(table==null)
			return null;
		String s = "pile =";
		for (int i = 0; i < nombreCaracteres; i++) {
			s = s + " " + table[i];
		}
		return s;
	}

} 
