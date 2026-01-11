import java.util.Objects;

public class Guerrier {
	
	private String nom;
	private int pointsDeVie; // >= 0
	
	public Guerrier(String nom, int pointsDeVie) {
		if(nom==null || nom.isEmpty() || pointsDeVie<0)
			throw new IllegalArgumentException();
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
	}

	public String getNom() {
		return nom;
	}

	public int getPointsDeVie() {
		return pointsDeVie;
	}

	/**
	 * retire des points de vie
	 * le nombre de points de vie est mis a 0 si le guerrier est mort
	 * @param pointsDeViePerdus le nombre de points de vie a retirer
	 * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
	 */
	public void retirerPointsDeVie(int pointsDeViePerdus){
		if(pointsDeViePerdus<0)
			throw new IllegalArgumentException();
		pointsDeVie = this.pointsDeVie-pointsDeViePerdus;
		if(pointsDeVie < 0)
			pointsDeVie = 0;
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	@Override
	public String toString() {
		return
				"" + nom + "(" + pointsDeVie + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Guerrier guerrier = (Guerrier) o;
		return Objects.equals(nom, guerrier.nom);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nom);
	}
}
