import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Plongeur extends Niveau{

	public void Déplacement() {
		
		
        double deltaY=0;
        double deltaY2=0;
        int positionJ1 = 0;
        int positionJ2 = 0;
	    boolean bool = true;
	    boolean boolMove1 = true;
	    boolean boolMove2 = true;
	    boolean boolMove3 = true;
	    
		double h1 = 5+5*niveauxC3+5*niveauxC2+5*niveauxC1;
		
        //Blocage du déplacement en haut et en bas des niveaux
        
        if (deltaY<=0) deltaY = 0 ;
        if (deltaY>(5*niveauxC3+5*niveauxC2+5*niveauxC1)) deltaY = 5*niveauxC3+5*niveauxC2+5*niveauxC1 ;        
        
        if (deltaY2<=0) deltaY2 = 0 ;
        if (deltaY2>(5*niveauxC3+5*niveauxC2+5*niveauxC1)) deltaY2 = 5*niveauxC3+5*niveauxC2+5*niveauxC1 ;  
		
		 while(bool==true) { // Boucle de déplacement, permet de créer des tours de jeu
		        
	        	System.out.println("Move While checked");
	        
	        //Sélection du joueur
	        
	        if (positionJ1>positionJ2) { // Tour de J1 car plus profond
	        System.out.println("J1 lower checked");
	        	StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 15, 15); // Indicateur de tour
	        	while(boolMove1) { // Condition pour dire qu'on ne peut faire qu'une action
	        		
	        		// Détection de la touche pressée
	        		
	        		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {  
	        			System.out.println("touche BAS");
 		            deltaY= deltaY+5;	//Modification graphique de la position
 		            positionJ1 = positionJ1 + 1;	//Modification fonctionnelle de la position
 		        }
 		        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
 		        	System.out.println("touche HAUT");
 		            deltaY= deltaY-5;
 		            positionJ1 = positionJ1 - 1;
 		        }
 		        
 		        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
 		   
 		        }
 		        
 		        //Déplacement du joueur
 		      
 				StdDraw.picture(0.12*X_MAX, h1-deltaY2+4.5,"bob.png", 10, 10);
 		        StdDraw.show(50);
 		        
 		        boolMove1 = false; // Sortie de la boucle de limitation de mouvement
 		        bool = false; // Fin du tour, on sort du while de déplacement
	        		}
	        	}
	        
	        if (positionJ1<positionJ2) { // Tour de J2 car plus profond
	        System.out.println("J2 lower checked");
	        	StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20, 20); // Indicateur de tour
	        	while(boolMove2) { // Condition pour dire qu'on ne peut faire qu'une action
	        		
	        		// Détection de la touche pressée
	        		
 		        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
 		        	System.out.println("touche S");
 		            deltaY2= deltaY2+5;
 		            positionJ2 = positionJ2 + 1;
 		        }
 		        if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
 		        	System.out.println("touche Z");
 		            deltaY2= deltaY2-5;
 		            positionJ2 = positionJ2 - 1;
 		        }
 		        
 		        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {

 		        }
 		        
 		        //Déplacement du joueur
 		      
 		        StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+4.2,"patrick.png", 12, 12);
 		        StdDraw.show(50);
 		        
 		        boolMove2 = false; // Sortie de la boucle de limitation de mouvement
 		        bool = false; // Fin du tour, on sort du while de déplacement
	        			}
	        		}
			
	        		if (positionJ1==positionJ2) {
	        		System.out.println("Equal levels checked");
	        		    int randTour = 1 + randomGenerator.nextInt(9);
	        		    System.out.println("randTour = " + randTour);
	        		    
	        		    if (randTour<=5) { // Tour J1
	        		    System.out.println("Equal levels J1 turn checked");
	        		    	StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 15, 15); // Indicateur de tour
	    		        	while(boolMove3) { // Condition pour dire qu'on ne peut faire qu'une action
	    		        		
	    		        		// Détection de la touche pressée
	    		        		
	    		        		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {  
	    		        			System.out.println("touche BAS");
	    	    		            deltaY= deltaY+5;	//Modification graphique de la position
	    	    		            positionJ1 = positionJ1 + 1;	//Modification fonctionnelle de la position
	    	    		            
		    	    		        boolMove3 = false; // Sortie de la boucle de limitation de mouvement
		    	    		        bool = false; // Fin du tour, on sort du while de déplacement
	    	    		        }
	    	    		        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
	    	    		        	System.out.println("touche HAUT");
	    	    		            deltaY= deltaY-5;
	    	    		            positionJ1 = positionJ1 - 1;
	    	    		        }
	    	    		        
	    	    		        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
	    	    		   
	    	    		        }
	    	    		        
	    		        	}
	    	    		        //Déplacement du joueur
	    	    		      
	    	    				StdDraw.picture(0.12*X_MAX, h1-deltaY2+4.5,"bob.png", 10, 10);
	    	    		        StdDraw.show(50);

	    		        		
	        		    	}
	    		        	
	    		        	if (randTour>5) { // Tour J2
	    		        	System.out.println("Equal levels J2 turn checked");
	        		        	StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20, 20); // Indicateur de tour
	        		        	while(StdDraw.isKeyPressed(KeyEvent.KEY_RELEASED) == false) { // Condition pour dire qu'on ne peut faire qu'une action
	        		        		
	        		        		// Détection de la touche pressée
	        		        		
	        	    		        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
	        	    		        	System.out.println("touche S");
	        	    		            deltaY2= deltaY2+5;
	        	    		            positionJ2 = positionJ2 + 1;
	        	    		        }
	        	    		        if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
	        	    		        	System.out.println("touche Z");
	        	    		            deltaY2= deltaY2-5;
	        	    		            positionJ2 = positionJ2 - 1;
	        	    		        }
	        	    		        
	        	    		        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {

	        	    		        }
	        		        	}
	        	    		        //Déplacement du joueur
	        	    		      
	        	    		        StdDraw.picture(X_MAX-0.12*X_MAX, h1-deltaY+4.2,"patrick.png", 12, 12);
	        	    		        StdDraw.show(50);
	        		        		
	    		        	}
	        			
	        		}
			
	 } // While de déplacement
		
		 bool = true;
		
	}
	
}
