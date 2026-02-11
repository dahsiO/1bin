public class CabinesDEssayage {
	
	private Pile<Integer> pileNumerosCabinesLibres;  	// cette pile d'entiers contient les numeros des cabines libres
	private boolean[] tableOccupations;     			// attention la numerotation des cabines commence a 1
												     	// si tableOccupations[0] contient TRUE --> la cabine 1 est occupee
												     	// ...
	// N'ajoutez pas d'autres attributs!
		
	
	/**
	 * construit nombreCabines libres
	 * La numerotation des cabines commence a 1
	 * @param nombreCabines : le nombre de cabines d'essayage
	 * @throws IllegalArgumentException si le nombre de cabines est negatif ou nul
	 */
	public CabinesDEssayage(int nombreCabines){
		// TODO
		if (nombreCabines <= 0) {
			throw new IllegalArgumentException("Le nombre de cabines doit être strictement positif");
		}
		tableOccupations = new boolean[nombreCabines]; // false par defaut
		pileNumerosCabinesLibres = new PileImpl<>(nombreCabines);
		// La numérotation commence à 1
		for (int i = 1; i <= nombreCabines; i++) {
			pileNumerosCabinesLibres.push(i);
		}
	}
	
	/**
	 * renvoie le nombre de cabines libres
	 * @return le nombre de cabines libres
	 */
	public int nombreCabinesLibres(){
		// TODO
		return pileNumerosCabinesLibres.taille();
	}
	
	/**
	 * recherche une cabine libre
	 * @return le numero d'une cabine libre ou -1 si toutes les cabines sont occupees
	 */
	public int attribuerCabineLibre(){
        // TODO
		if (pileNumerosCabinesLibres.estVide()) {
			return -1;
		}
		// Retirer la cabine du sommet le pop supprime met renvoie 	aussi le sommet on recupere cette donne quon stoke dans une variable quon renvoie a la fin de la methode
		int numeroCabine = pileNumerosCabinesLibres.pop();

		// Marquer la cabine comme occupée
		// Les cabines sont numérotées à partir de 1,
		// tandis que les tableaux Java sont indexés à partir de 0
		//donc on fait -1
		tableOccupations[numeroCabine - 1] = true;

		return numeroCabine;
	}
	
	/**
	 * libere une cabine
	 * @param numeroCabine le numero de la cabine a liberer
	 * @throws IllegalArgumentException si aucune cabine porte ce numero
	 * @throws IllegalStateException si la cabine a liberer n'est pas occupee
	 */
	public void libererCabine(int numeroCabine) {
		// TODO
		if (numeroCabine > tableOccupations.length) {
			throw new IllegalArgumentException("le numero de cabine est indisponible");
		}
		if (numeroCabine <= 0) {
			throw new IllegalArgumentException("numero de cabine pas correcte ");
		}
		if (tableOccupations[numeroCabine - 1] == false) {
			throw new IllegalStateException("la cabine est libre ");
		}
		tableOccupations[numeroCabine -1] = false;
		pileNumerosCabinesLibres.push(numeroCabine);
	}

    // A NE PAS RETIRER !
    // VA SERVIR POUR LES TESTS
    public CabinesDEssayage(){
    }
}
