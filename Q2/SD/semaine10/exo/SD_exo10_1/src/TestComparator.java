import java.util.Comparator;
import java.util.TreeSet;

public class TestComparator {

	public static void main(String[] args) {
		
		Comparator<Voiture> comparateur = new ComparateurVoiture();
		TreeSet<Voiture> t = new TreeSet<Voiture>(comparateur);

		t.add(new Voiture("333A123B456C78900","2ABC003"));
		t.add(new Voiture("111A123B456C78900","1BBQ000"));
		t.add(new Voiture("999A123B456C78900","2ABC001"));
		t.add(new Voiture("555A123B456C78900","1ZZZ999"));

		for (Voiture voiture : t) {
			System.out.println(voiture);
		}
	}
}




