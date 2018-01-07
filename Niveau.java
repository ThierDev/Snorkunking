import java.awt.Font;
import java.util.List;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;

public class Niveau extends Titre{

	public int index;
	
	// no need for these
	
	//public final static int X_MAX=(int) (320*SW);
	//public final static int Y_MAX=(int) (180*SH);
	//public final static double WIDTH=0.5f;
    
    public static int deltaY = 0;
    public static int deltaY2 = 0;
    
	static Random randomGenerator = new Random();
	
    public static int niveauxC1 = 9 + randomGenerator.nextInt(12-9);
    public static int niveauxC2 = 6 + randomGenerator.nextInt(9-6);
    public static int niveauxC3 = 3+ randomGenerator.nextInt(6-3);
    public static int totNiveau123 = niveauxC1+niveauxC2+niveauxC3;
    public static double hauteurNiveau = 250/totNiveau123;
    
    public static int Oxygene = 2*(niveauxC3+niveauxC2+niveauxC1);  // VERSION BETA, PAS DE CLASSE DE GESTION DE l'OXYGENE POUR LE MOMENT
    
	public static double h1 = hauteurNiveau*niveauxC3+hauteurNiveau*niveauxC2+hauteurNiveau*niveauxC1;
    
	public static void BackgroundGraphics() { // L'ensemble des éléments de toujours présents à l'image. J'ai inclu les coffres pour l'instant

					Font FontScore = new Font("Arial", Font.BOLD,(int) (25*SW));
					Font FontPourcent = new Font("Arial", Font.PLAIN, (int)(20*SW));
							
    				  // Je suis revenu au jpg parce que le gif était super chiant à afficher durant les boucles
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg",640*SW,360*SH);
    				// Indicateurs dans les coins pour dire qui va jouer
    				
    				StdDraw.picture(0.05*X_MAX, 0.9*Y_MAX, "bob.png", 25*SW, 25*SH);
    		        StdDraw.picture(X_MAX-0.05*X_MAX, 0.9*Y_MAX, "patrick.png", 25*SW, 25*SH);
    		        
    		        // Affichage des scores
    		        
    		        StdDraw.setFont(FontScore);
    		        StdDraw.setPenColor(StdDraw.RED);
    		        StdDraw.text(0.05*X_MAX, 0.78*Y_MAX, "Score");
    		        StdDraw.text(0.95*X_MAX, 0.78*Y_MAX, "Score");
    				
    		        // Affichage des niveaux
    		        StdDraw.setPenRadius(0.005*SW);
    				StdDraw.setPenColor(StdDraw.BLUE);
    		        StdDraw.rectangle(X_MAX/2,(Y_MAX/2)-5*SH*hauteurNiveau,X_MAX/2-0.045*X_MAX,(8+h1/2)*SH);
    				
    		        StdDraw.setPenRadius();
    		        StdDraw.setPenColor(StdDraw.YELLOW);
    		        
    		        for (int i = 0; i < niveauxC1; i++) {
    					StdDraw.rectangle(X_MAX/2,(hauteurNiveau+hauteurNiveau*niveauxC3+hauteurNiveau*niveauxC2+hauteurNiveau*i)*SH,X_MAX/2-0.075*X_MAX,(hauteurNiveau/2)*SH);
    		        }
    		        
    		        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
    				
    		        for (int i = 0; i < niveauxC2; i++) {
    					StdDraw.rectangle(X_MAX/2,(hauteurNiveau+hauteurNiveau*niveauxC3+hauteurNiveau*i)*SH,X_MAX/2-0.075*X_MAX,(hauteurNiveau/2)*SH);
    		        }
    		        
    		        StdDraw.setPenColor(StdDraw.RED);
    		        
    				for (int i = 0; i < niveauxC3; i++) {
    					StdDraw.rectangle(X_MAX/2,(hauteurNiveau+hauteurNiveau*i)*SH,X_MAX/2-0.075*X_MAX,(hauteurNiveau/2)*SH);
    				}
    				
    				/* Affichage des coffres 
    				
    				for (int i = 0; i < niveauxC1; i++) { StdDraw.picture(X_MAX/2, (12+12*niveauxC3+12*niveauxC2+12*i)*SH, "coffre.png", 12*SW, 12*SH); }
     				
     		        for (int i = 0; i < niveauxC2; i++) { StdDraw.picture(X_MAX/2, (12+12*niveauxC3+12*i)*SH, "coffre.png", 12*SW, 12*SH); }
     		        
     				for (int i = 0; i < niveauxC3; i++) { StdDraw.picture(X_MAX/2, (12+12*i)*SH, "coffre.png", 12*SW, 12*SH); }
     				*/
        }
     				
     				
     public static void DispDeplacement() {
    	 
    	 //Niveau.WindowInit();
    	 
    	 Niveau.BackgroundGraphics();
    	 
    	 while(Oxygene>0) { // AFFICHAGE MANCHE DE JEU - UNE BOUCLE = UN TOUR D'UN JOUEUR
     				
     				// Affichage barre d'oxygène
     				
     				double BordureOxy = 4*(niveauxC3+niveauxC2+niveauxC1) + 0.1;
     				double OxyIni = 2*(niveauxC3+niveauxC2+niveauxC1);
     				
     				StdDraw.setPenColor(StdDraw.BLACK);
     				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy, 6.1);
     				StdDraw.setPenColor(StdDraw.BLUE);
     				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene, 6);
     				
     				double PourcentageOxy = Math.round(((Oxygene/OxyIni)*100));  // Affichage du pourcentage d'oxygène
     				StdDraw.setPenColor(StdDraw.WHITE);
     				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    				
    				StdDraw.show(50);
    				
    				// Affichage des personnages avant les premiers déplacements
    				
    				StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+12.5,"patrick.png", 12*SW*SW, 12*SH*SH);
    				StdDraw.picture(0.12*X_MAX, h1-deltaY2+12.5,"bob.png", 12*SW, 12*SH);
    				
    				int Ordre = Plongeur.Ordre();  // On récupère l'info de qui va jouer
    				if (Ordre == 1) { // J1 va jouer en premier
    					
    					// Tour J1
    					StdDraw.setPenColor(StdDraw.RED);
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la méthode de déplacement pour le J1
    			        
    			        Niveau.BackgroundGraphics(); // Efface l'image pour le fond de base mais pas les joueurs
    			        
    			        // Affichage des joueurs après déplacement de J1 
    			        
    			        StdDraw.picture(0.12*X_MAX, h1-deltaY2+12.5,"bob.png", 12*SW, 12*SH);
    	        		StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+12.5,"patrick.png", 12*SW*SW, 12*SH*SH);

    	        		// Mise à jour de la barre d'oxygene	
    	        		
    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy, 6.1);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene, 6);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    	        		// Tour J2
    	        		StdDraw.setPenColor(StdDraw.RED);
    	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J2 checked");
    			        deltaY2 = Plongeur.Deplacement(2); // Appelle la méthode de déplacement pour le J2
    			        
    			        Niveau.BackgroundGraphics();
    			        
    			        StdDraw.picture(0.12*X_MAX, h1-deltaY2+12.5,"bob.png", 12*SW, 12*SH);
    	        		StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+12.5,"patrick.png", 12*SW*SW, 12*SH*SH);

    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy, 6.1);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene, 6);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene()); 	        		
    				}
    					
    				if (Ordre == 2) { // J2 va jouer en premier
    	        		
    	        		// Tour J2
    					StdDraw.setPenColor(StdDraw.RED);
    	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J2 checked");
    			        deltaY2 = Plongeur.Deplacement(2); // Appelle la méthode de déplacement pour le J2

    			        Niveau.BackgroundGraphics();
    			        
    			        StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+12.5,"patrick.png", 12*SW, 12*SH);
    	        		StdDraw.picture(0.12*X_MAX, h1-deltaY2+12.5,"bob.png", 12*SW, 12*SH);

    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy, 6.1);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene, 6);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    	        		// Tour J1
    	        		StdDraw.setPenColor(StdDraw.RED);
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la méthode de déplacement pour le J1
    			        
    			        Niveau.BackgroundGraphics();
    			        
    			        StdDraw.picture(0.12*X_MAX, h1-deltaY2+12.5,"bob.png", 12*SW, 12*SH);
    	        		StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+12.5,"patrick.png", 12*SW, 12*SH);

    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy, 6.1);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene, 6);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    				} 
    				
        } // While affichage global
		System.exit(0); // BETA - Fin de programme actuelle pour éviter des boucles indésirables
	}
	
	public static void printList(List<String> list) {
		for (int d=0; d<list.size();d++) {
			if (d==list.size()) {
				System.out.println(list.get(d));
			}
			System.out.println(list.get(d));
		}
	}
}   