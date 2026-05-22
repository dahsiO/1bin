import java.util.HashSet;
import java.util.Objects;

public class ProducteurMusique {

	private int numeroProducteur;
	private String nom;
	private HashSet<Integer> ensembleStudios;

	/**
	 * construit un producteur de musique sans studio
	 * @param numeroProducteur son numero
	 * @param nom son nom
	 * @throws IllegalArgumentException si le numero de producteur est negatif ou nul
	 *                                  si le nom est null ou ""
	 */
	public ProducteurMusique(int numeroProducteur, String nom) {
		if(numeroProducteur<=0)
			throw new IllegalArgumentException();
		if(nom == null || nom.equals(""))
			throw new IllegalArgumentException();
		this.numeroProducteur = numeroProducteur;
		this.nom = nom;
		ensembleStudios = new HashSet<>();
	}

	public int getNumeroProducteur() {
		return numeroProducteur;
	}

	public String getNom() {
		return nom;
	}

	/**
	 * renvoie le nombre de studios occupes par le producteur
	 * @return le nombre de studios occupes par le producteur
	 */
	public int nombreStudios(){
		return ensembleStudios.size();
	}


	/**
	 * ajoute un studio si celui-ci ne fait pas encore partie des studios occupes par le producteur
	 * @param numeroStudio le numero du studio ajoute
	 * @return true si l'ajout a ete fait, false sinon
	 */
	public boolean ajouterStudio(int numeroStudio){
		return ensembleStudios.add(numeroStudio);
	}


	/**
	 * supprime un studio si celui-ci fait partie des studios occupes par le producteur
	 * @param numeroStudio le numero du studio supprime
	 * @return true si la suppression a ete faite, false sinon
	 */
	public boolean supprimerStudio(int numeroStudio){
		return ensembleStudios.remove(numeroStudio);
	}


	/**
	 * renvoie sous forme d'une chaine de caracteres les numeros des studios
	 * @return une chaine de caracteres avec les numeros des studios
	 */
	public String lesStudios() {
		return ensembleStudios.toString();
	}

	@Override
	public String toString() {
		return "ProducteurMusique{" +
				"numeroProducteur=" + numeroProducteur +
				", nom='" + nom + '\'' +
				", ensembleStudios=" + ensembleStudios +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ProducteurMusique that = (ProducteurMusique) o;
		return numeroProducteur == that.numeroProducteur;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroProducteur);
	}
}
