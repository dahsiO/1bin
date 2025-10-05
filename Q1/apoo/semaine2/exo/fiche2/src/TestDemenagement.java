
public class TestDemenagement {
	public static void main(String[] args) {
		Date dateBrad = new Date(1963,12,18);
		Date dateAngelina = new Date(1975,6,4);
		Adresse adresse = new Adresse("Rue des stars", "52","1000","Bruxelles");
		Personne p1 = new Personne("Pitt","Brad",dateBrad,adresse);
		System.out.println(p1);
		Personne angelina = new Personne("Jolie", "Angelina",dateAngelina, adresse);
		p1.demenager("Rue des �toiles", "32", "1000", "Bruxelles");
		System.out.println(p1);
		angelina.demenager("Rue des �toiles", "32", "1000", "Bruxelles");
	}
}
