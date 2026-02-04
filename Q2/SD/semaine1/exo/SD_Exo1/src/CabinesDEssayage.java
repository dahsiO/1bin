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

	}
	
	/**
	 * renvoie le nombre de cabines libres
	 * @return le nombre de cabines libres
	 */
	public int nombreCabinesLibres(){
		// TODO
		return 0;

	}
	
	/**
	 * recherche une cabine libre
	 * @return le numero d'une cabine libre ou -1 si toutes les cabines sont occupees
	 */
	public int attribuerCabineLibre(){
        // TODO
        return 0;

	}
	
	/**
	 * libere une cabine
	 * @param numeroCabine le numero de la cabine a liberer
	 * @throws IllegalArgumentException si aucune cabine porte ce numero
	 * @throws IllegalStateException si la cabine a liberer n'est pas occupee
	 */
	public void libererCabine(int numeroCabine) {
		// TODO

	}

    // A NE PAS RETIRER !
    // VA SERVIR POUR LES TESTS
    public CabinesDEssayage(){
    }
}
