import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class FenetreCombatGuerriers extends JFrame implements ActionListener{
	
	private JPanel principal, cadreHaut, cadreBas, joueur1, joueur2, cadreMilieu, de, cadreEnter;
	private JLabel informationEnHaut, informationEnter, faceDe, points1, points2, statut1, statut2;
	private JButton jouerDe,enter;	
	private ImageIcon[] fDe;
	private ImageIcon guerrier1, guerrier2, epee, bouclier, croix, coupeOr, coupeArgent, siege ;

	private Queue<Integer> listeLancersDes = new LinkedList<Integer>();
	private Thread listener;
	private String path = "images/";
	
	
	public FenetreCombatGuerriers(){
		
		listener = Thread.currentThread();
		
		this.setTitle("Combat entre Cognedur et FrappeFort ");
		this.setSize(500, 500);
		this.setLocation(30, 30);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		
		principal = new JPanel();
		principal.setLayout(new BorderLayout());
		
		Font font = new Font("Arial", Font.BOLD, 14);
		Font fontP = new Font("Arial", Font.BOLD, 12);
		
		fDe = new ImageIcon[6];
		fDe[0]= new ImageIcon(path+"un.png");
		fDe[1]= new ImageIcon(path+"deux.png");
		fDe[2]= new ImageIcon(path+"trois.png");
		fDe[3]= new ImageIcon(path+"quatre.png");
		fDe[4]= new ImageIcon(path+"cinq.png");
		fDe[5]= new ImageIcon(path+"six.png");
		
		epee = new ImageIcon(path+"epee100x100.png");
		bouclier = new ImageIcon(path+"bouclier100x100.png");
		croix = new ImageIcon(path+"cercueil.png");
		coupeOr = new ImageIcon(path+"coupeOr.png");
		coupeArgent = new ImageIcon(path+"coupeArgent.png");
		siege = new ImageIcon(path+"siege100x100.png");
		guerrier1 = new ImageIcon(path+"cogneDur.png");
		guerrier2 = new ImageIcon(path+"frappeFort.png");
		
		
		
		cadreHaut = new JPanel(new GridLayout(3,1));
		cadreHaut.add(new JLabel(" "));
		informationEnHaut = new JLabel(" ");
		informationEnHaut.setFont(font);
		informationEnHaut.setHorizontalAlignment(SwingConstants.CENTER);
		informationEnHaut.setVerticalAlignment(SwingConstants.CENTER);
		cadreHaut.add(informationEnHaut);
		cadreHaut.add(new JLabel(" "));
		principal.add(cadreHaut, BorderLayout.NORTH);
		
		
		cadreMilieu = new JPanel(new GridLayout(3,1));
		cadreMilieu.add(new JLabel(""));
		
		
		// Le de
		
		de = new JPanel();
		de.setLayout(new FlowLayout());
		faceDe = new JLabel(""); 
		faceDe.setIcon(fDe[0]);
		de.add(faceDe);
		jouerDe = new JButton("lancer");
		jouerDe.addActionListener(this);
		de.add(jouerDe);
		
		cadreMilieu.add(de);
		principal.add(cadreMilieu,BorderLayout.CENTER);
		
		
		cadreBas = new JPanel(new GridLayout(3,1));


		
		// Le joueur 1
		
		joueur1 = new JPanel();
		joueur1.setLayout(new BorderLayout());
		
		
		// Les points
		
		points1 = new JLabel("Points de vie = ");
		points1.setFont(font);
		joueur1.add(points1,BorderLayout.NORTH);
		
		
		// L image
	
		joueur1.add(new JLabel(guerrier1),BorderLayout.CENTER);
				
		
		// Le statut
		
		statut1 = new JLabel(siege);
		joueur1.add(statut1,BorderLayout.SOUTH);
		
		
		principal.add(joueur1, BorderLayout.WEST);
		
				
		// Le joueur 2

		joueur2 = new JPanel();
		joueur2.setLayout(new BorderLayout());

		
		// Les points
		
		points2 = new JLabel("Points de vie = ");
		points2.setFont(font);
		joueur2.add(points2,BorderLayout.NORTH);

		
		// L image

		joueur2.add(new JLabel(guerrier2),BorderLayout.CENTER);


		// Le statut
		
		statut2 = new JLabel(siege);
		joueur2.add(statut2,BorderLayout.SOUTH);


		principal.add(joueur2, BorderLayout.EAST);

		setContentPane(principal);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jouerDe){
			int resultatDe = (int)((Math.random() * 6) + 1);
			faceDe.setIcon(fDe[resultatDe-1]);	
			ajouterListeLancerDe(resultatDe);
			principal.invalidate();
			principal.repaint();
		}
	
	}

	private int lancerDeSuivant() {
		synchronized (listeLancersDes) {
			while (listeLancersDes.isEmpty()){
				
				try {
					listeLancersDes.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return listeLancersDes.remove();

		}
	}
	
	private void ajouterListeLancerDe(int resultatDe) {
		synchronized (listeLancersDes) {

			listeLancersDes.add(resultatDe);
			if (listener != null)
				listeLancersDes.notifyAll();
		}
	}
	
	
	
	public int lancerDe() {
		int de = lancerDeSuivant();
		return de;
	}

	
	public void afficherEpee(int numJoueur){
		if(numJoueur==1){
			statut1.setIcon(epee);
		}else{
			statut2.setIcon(epee);
		}
		principal.invalidate();
		principal.repaint();
	}
	
	
	public void afficherBouclier(int numJoueur){
		if(numJoueur==1){
			statut1.setIcon(bouclier);
		}else{
			statut2.setIcon(bouclier);
		}
		principal.invalidate();
		principal.repaint();
	}
	
	
	public void afficherCroix(int numJoueur){
		if(numJoueur==1){
			statut1.setIcon(croix);
		}else{
			statut2.setIcon(croix);
		}
		principal.invalidate();
		principal.repaint();
	}
	
	
	public void afficherCoupeOr(int numJoueur){
		if(numJoueur==1){
			statut1.setIcon(coupeOr);
		}else{
			statut2.setIcon(coupeOr);
		}
		principal.invalidate();
		principal.repaint();
	}

	public void afficherCoupeArgent(int numJoueur){
		if(numJoueur==1){
			statut1.setIcon(coupeArgent);
		}else{
			statut2.setIcon(coupeArgent);
		}
		principal.invalidate();
		principal.repaint();
	}
	
	
	public void afficherPointsDeVie(int numJoueur,int pointsDeVie){
		if(numJoueur==1){
			points1.setText("Points de vie = "+pointsDeVie);
		}else{
			points2.setText("Points de vie = "+pointsDeVie);
		}
	}
	
	
	public void afficherInformation(String texte) {
		informationEnHaut.setText(" "+texte);
	}
	


}
