package aout25.aout2025.AF;

public class Emplacement {
	
	private int numeroEmplacement;
	private String nomRiverain;  //null si libre
	
	public Emplacement(int numeroEmplacement) {
		this.numeroEmplacement = numeroEmplacement;
	}

	public int getNumeroEmplacement() {
		return numeroEmplacement;
	}

	public String getNomRiverain() {
		return nomRiverain;
	}

	public void setNomRiverain(String nomRiverain) {
		this.nomRiverain = nomRiverain;
	}

	@Override
	public String toString() {
		return "emplacement "+ numeroEmplacement +
				" : " + nomRiverain;
	}

}
