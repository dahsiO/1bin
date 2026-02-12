import java.util.Objects;

public class Casier {
	
	private int numero;        // la numerotation des casiers commence a 0
	private String motDePasse; // si le casier est libre, le mot de passe est vide
	
	
	public Casier(int numero) {
		this.numero = numero;
		this.motDePasse="";
	}

	public int getNumero() {
		return numero;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

    public boolean estLibre(){
        return motDePasse.equals("");
    }

    @Override
    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public String toString() {

        return numero + " (" + motDePasse + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Casier casier = (Casier) o;
        return numero == casier.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}
