import java.util.TreeSet;

public class TestComparable {

	public static void main(String[] args) {

		TreeSet<Voiture> t = new TreeSet<Voiture>();

		t.add(new Voiture("333A123B456C78900","2ABC003"));
		t.add(new Voiture("111A123B456C78900","1BBQ000"));
		t.add(new Voiture("999A123B456C78900","2ABC001"));
		t.add(new Voiture("555A123B456C78900","1ZZZ999"));

		for (Voiture voiture : t) {
			System.out.println(voiture);
		}	
	}
}


