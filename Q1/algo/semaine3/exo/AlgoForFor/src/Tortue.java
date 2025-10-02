import java.awt.Color;

public class Tortue {
	private Turtle t;
	private int derniereCouleurUtilisee ;
	private static final Color[] COULEURS_DISPONIBLES = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.CYAN, Color.MAGENTA, Color.ORANGE, Color.PINK } ;

	public Tortue(){
		t = new Turtle(new Sheet(800, 800),1);
		t.penDown();
		derniereCouleurUtilisee = 1;
	}

	public void avancer(double pixel){
		t.advance(pixel);
	}

	public void tournerADroite(int degre){
		t.turn(360-degre);
	}

	public void tournerAGauche(int degre){
		t.turn(degre);
	}

	public void definirCouleur(String couleur){
		if(couleur.equalsIgnoreCase("ROUGE")){
			t.setPenColor(Color.RED);
			return;
		}
		if(couleur.equalsIgnoreCase("NOIR")){
			t.setPenColor(Color.BLACK);
			return;
		}
		if(couleur.equalsIgnoreCase("BLEU")){
			t.setPenColor(Color.BLUE);
			return;
		}
		if(couleur.equalsIgnoreCase("JAUNE")){
			t.setPenColor(Color.YELLOW);
			return;
		}
		if(couleur.equalsIgnoreCase("VERT")){
			t.setPenColor(Color.GREEN);
			return;
		}
		if(couleur.equalsIgnoreCase("ALEATOIRE")){
			java.util.Random r = new java.util.Random();
			int couleurSuivante = this.derniereCouleurUtilisee ;
			while (couleurSuivante==this.derniereCouleurUtilisee) {
				couleurSuivante = r.nextInt(Tortue.COULEURS_DISPONIBLES.length);
			}
			t.setPenColor(Tortue.COULEURS_DISPONIBLES[couleurSuivante]);
			this.derniereCouleurUtilisee = couleurSuivante ;
			return;
		}

		t.setPenColor(Color.WHITE);
	}

	public void accelerer(){
		t.setSpeed(999);
	}

}
