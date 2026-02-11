public class Consigne{
	private Pile<Casier> pileCasiersLibres;
	private Casier[] tableCasiers;

	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casiers de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public Consigne(int nombreCasiers){
		// TODO
		if (nombreCasiers <= 0 ) {
			throw new IllegalArgumentException();
		}
		tableCasiers = new Casier[nombreCasiers];
		pileCasiersLibres = new PileImpl<>(nombreCasiers);

//		for (int i = 0; i <= nombreCasiers -1; i++) {
//			tableCasiers[i] = new Casier(i);
//		}
		for (int i = 0; i < nombreCasiers ; i++) {
			Casier c = new Casier(i);
			tableCasiers[i] = c;
			pileCasiersLibres.push(c);
		}

    }


	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		// TODO
		if (pileCasiersLibres.estVide()) {
			return false;
		}
		return true;

    }


	/**
	 * attribue un casier libre
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		//
		if (motDePasse == null || motDePasse.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (pileCasiersLibres.estVide()) {
			return -1;
		}
		int numero = pileCasiersLibres.pop().getNumero();
		tableCasiers[numero].setMotDePasse(motDePasse);


		return numero;

    }


	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le numero de casier n'existe pas
	 *                                  et/ou si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		// TODO
		if (numeroCasier < 0 || numeroCasier > tableCasiers.length -1) {
			throw new IllegalArgumentException();
		}
		if (motDePasse == null || motDePasse.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if (!tableCasiers[numeroCasier].getMotDePasse().equals(motDePasse)) {
			return false;
		}
		tableCasiers[numeroCasier].setMotDePasse("");
		pileCasiersLibres.push(tableCasiers[numeroCasier]);
		return true;

    }

    //A NE PAS RETIRER
    //VA SERVIR POUR LES TESTS
    public Consigne(){

    }

}
