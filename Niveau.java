import java.awt.event.KeyEvent;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


public class Niveau extends Titre{

	public int index;
	public final static int X_MAX=320;
	public final static int Y_MAX=180;
	public final static double WIDTH=0.5f;
	
    public static int oxygene = 10;  // VERSION BETA, PAS DE CLASSE DE GESTION DE l'OXYGENE POUR LE MOMENT, uniquement utilisé comme condition
    
    public static int deltaY = 0;
    public static int deltaY2 = 0;
    
	static Random randomGenerator = new Random();
	
    public static int niveauxC1 = 9 + randomGenerator.nextInt(12-9);
    public static int niveauxC2 = 6 + randomGenerator.nextInt(9-6);
    public static int niveauxC3 = 3+ randomGenerator.nextInt(6-3);
    
	public static double h1 = 5+5*niveauxC3+5*niveauxC2+5*niveauxC1;
    
	public static void Graphique() throws Exception {		
	    
		StdDraw.setCanvasSize(1280,720);
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
        
        while(oxygene>0) { // AFFICHAGE MANCHE DE JEU - UNE BOUCLE = UN TOUR D'UN JOUEUR

    				StdDraw.picture(X_MAX/2, Y_MAX/2,"water.gif");  //Génération graphique du niveau
    				StdDraw.picture(0.05*X_MAX, 0.9*Y_MAX, "bob.png", 15, 15);
    		        StdDraw.picture(X_MAX-0.05*X_MAX, 0.9*Y_MAX, "patrick.png", 18, 18);
    				
    				StdDraw.setPenColor(StdDraw.BLUE);
    		        StdDraw.rectangle(X_MAX/2,(5+5*niveauxC3+5*niveauxC2+5*niveauxC1),X_MAX/2-0.05*X_MAX,2.5);
    				
    		        StdDraw.setPenColor(StdDraw.YELLOW);
    		        
    		        for (int i = 0; i < niveauxC1; i++) {
    					StdDraw.rectangle(X_MAX/2,(5+5*niveauxC3+5*niveauxC2+5*i),X_MAX/2-0.05*X_MAX,2.5);
    					StdDraw.picture(X_MAX/2, 5*niveauxC3+5*niveauxC2+5*i, "coffre.png", 7, 7);
    		        }
    		        
    		        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
    				
    		        for (int i = 0; i < niveauxC2; i++) {
    					StdDraw.rectangle(X_MAX/2,(5+5*niveauxC3+5*i),X_MAX/2-0.05*X_MAX,2.5);
    					StdDraw.picture(X_MAX/2, 5+5*niveauxC3+5*i, "coffre.png", 7, 7);
    		        }
    		        
    		        StdDraw.setPenColor(StdDraw.RED);
    		        
    				for (int i = 0; i < niveauxC3; i++) {
    					StdDraw.rectangle(X_MAX/2,(5+5*i),X_MAX/2-0.05*X_MAX,2.5);
    					StdDraw.picture(X_MAX/2, 5+5*i, "coffre.png", 7, 7);
    				}
    				
    				StdDraw.show(50);
    				
    				int Ordre = Plongeur.Ordre();  // On récupère l'info de qui va jouer
    				if (Ordre == 1) { // J1 va jouer
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20, 20); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la méthode de déplacement pour le J1
		        		StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+4.2,"patrick.png", 12, 12);
		        		StdDraw.show();
    				}
    					
    				if (Ordre == 2) { // J2 va jouer
    					StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 15, 15); // Indicateur de tour
    					StdDraw.show();
    					System.out.println("Return Ordre vers Niveau J2 checked");
    					deltaY2 = Plongeur.Deplacement(2); // Appelle la méthode de déplacement pour le J2
		        		StdDraw.picture(0.12*X_MAX, h1-deltaY2+4.5,"bob.png", 10, 10);
		        		StdDraw.show();
    				}	

    				System.out.println("Oxygène restant : " + oxygene);
    				
        } // While affichage global
        
		System.exit(0); // BETA - Fin de programme actuelle pour éviter des boucles indésirables
	}
}     	