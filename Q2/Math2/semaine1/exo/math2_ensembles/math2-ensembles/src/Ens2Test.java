import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Ens2Test extends AbstractTest {
	
	private Field fieldTab;
	private Field fieldCard;
 
	public Ens2Test() {
		super(Ens2.class);
		Field[] champs = getCls().getDeclaredFields();
		if (champs.length > 2) {
			System.out.println("Il est inutile de d�clarer des champs suppl�mentaire dans Ens2");
			System.exit(0);
		}
		for (Field f : champs){
			if (f.getType() == Elt[].class){
				fieldTab = f;
			}
			else if (f.getType() == int.class){
				fieldCard = f;
			}
			else {
				System.out.println("Que repr�sente le champ " + f.getName() + " de type " + f.getType().getName() + " ?");
				System.exit(0);
			}
		}
		if (fieldTab == null||fieldCard==null) {
			System.out.println("Vous avez supprim� un attribut de la classe Ens2");
			System.exit(0);
		}
		fieldTab.setAccessible(true);
		fieldCard.setAccessible(true);
	}
	
	@Override
	public boolean testEstVide() throws IllegalArgumentException,
			IllegalAccessException {
		boolean testOK =  super.testEstVide();
		EnsembleInterface ens = creerEnsemble(ELTS);
		fieldCard.set(ens, 0);
		if (!ens.estVide()){
			testOK = false;
			System.out.println("On a cr�� un ensemble vide et votre m�thode dit qu'il ne l'est pas !");
		}
		return testOK;
	}
	
	@Override
	public boolean testUnElement() throws IllegalArgumentException, MathException,
			IllegalAccessException {
		boolean testOK = super.testUnElement();
		EnsembleInterface ens = creerEnsemble();
		try {
			Elt elt = ens.unElement() ;
			testOK = false;
			System.out.println("Votre m�thode renvoie un �l�ment alors que l'ensemble est vide");
		} catch (MathException e) {
			
		} catch (Exception e) {
			System.out.println("Votre m�thode aurait du lancer une MathException mais a lanc� une "+e.getClass());
			testOK = false ;
		} 
		
		try {
			for (int i=0 ; i<5 ; i++) {
				ArrayList<Elt> listElt = new ArrayList<Elt>() ;
				Random rand = new Random() ;
				int j=0 ;
				while (j<6) {
					Elt e = new Elt(rand.nextInt(Elt.MAXELT.val())+1);
					if (!listElt.contains(e)) {
						listElt.add(e) ;
						j++;
					}
				}
				Elt[] tabElt = listElt.toArray(new Elt[1]);
				ens = creerEnsemble(tabElt);
				Elt elt =  ens.unElement();
				if (elt==null) {
					testOK = false;
					System.out.println("Votre m�thode ne trouve pas d'�l�ment alors que l'ensemble n'est pas vide");
					System.out.println("Ensemble cr�� : " + enChaine(tabElt));
				} else if (!(Arrays.asList(tabElt).contains(elt))) {
					testOK = false ;
					System.out.println("Votre m�thode a renvoy� un �l�ment qui n'est pas dans l'ensemble") ;
					System.out.println("Ensemble cr�� : " + enChaine(tabElt));
					System.out.println("Elt renvoy� : "+elt) ;
				}
			}
		} catch(Exception e) {
			System.out.println("Votre m�thode a lanc� une "+e.getClass()+" alors que l'ensemble n'est pas vide ") ;
			testOK = false ;
		}
		return testOK;
	}
	
	@Override
	public boolean testContient() throws IllegalArgumentException,
			IllegalAccessException {
		boolean testOK = super.testContient();
		EnsembleInterface ens = creerEnsemble(ELTS);
		System.out.println("ens avant = "+ens);
		fieldCard.set(ens,ELTS.length-1);
		Elt[] tab = (Elt[]) fieldTab.get(ens);
		System.out.println("element = "+tab[ELTS.length-1]+" ens = "+ens);
		if (ens.contient(tab[ELTS.length-1])){
			testOK = false;
			System.out.println("Ensemble cr�� : " + enChaine(Arrays.copyOf(tab, ELTS.length-1)));
			System.out.println("Votre m�thode contient dit que l'�l�ment " + tab[ELTS.length-1] + " est dans l'ensemble");
		}
		return testOK;
	}
	
	
	@Override
	protected HashSet<Elt> toSet() throws IllegalArgumentException,
			IllegalAccessException {
		HashSet<Elt> elem = new HashSet<Elt>();
		Elt[] tab = (Elt[]) fieldTab.get(getEnsemble());
		int card = fieldCard.getInt(getEnsemble());
		for (int i = 0; i < card;i++){
			 elem.add(tab[i]);
		}
		return elem;
	}
	
	@Override
	protected int card() throws IllegalArgumentException, IllegalAccessException {
		return fieldCard.getInt(getEnsemble());
	}
	
	@Override
	protected EnsembleInterface creerEnsemble(Elt... elts) throws IllegalArgumentException, IllegalAccessException {
		HashSet<Elt> liste = new HashSet<>();
		for (Elt e : elts) liste.add(e);
		Elt[] tab = new Elt[Elt.MAXELT.val()];
		int card = 0;
		for (Elt elt : liste){
			tab[card++] = elt;
		}
		EnsembleInterface ensemble = new Ens2();
		fieldTab.set(ensemble, tab);
		fieldCard.setInt(ensemble, card);
		return ensemble;
	}
	
	protected boolean verifInit() throws  IllegalAccessException{
		Elt[] tabTrouve = (Elt[]) fieldTab.get(getEnsemble());
		if (tabTrouve == null){
			System.out.println("Le tableau d'�l�ments n'a pas �t� initialis� !");
			return false;
		}
		else if (tabTrouve.length!= Elt.MAXELT.val()){
			System.out.println("Le tableau d'�l�ments n'a pas la bonne dimension !");
			return false;
		} 
		return true;
	}
	
	
}
