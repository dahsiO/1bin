package juin25;

public class Studio {
	
	private int numeroStudio;
	private ProducteurMusique producteurMusique;
	
	public Studio(int numeroStudio) {
		this.numeroStudio = numeroStudio;
	}

	public int getNumeroStudio() {
		return numeroStudio;
	}
	
	public ProducteurMusique getProducteurMusique() {
		return producteurMusique;
	}

	public void setProducteurMusique(ProducteurMusique producteurMusique) {
		this.producteurMusique = producteurMusique;
	}

	@Override
	public String toString() {
		return "Studio{" +
				"numeroStudio=" + numeroStudio +
				", producteurMusique=" + producteurMusique +
				'}';
	}
}
