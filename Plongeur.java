import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

public class Plongeur extends Niveau{

    public static int positionJ1 = 0;
    public static int positionJ2 = 0;
	
	public static int Ordre() {
	        
	        //Sélection du joueur
	        
	        if (positionJ1>positionJ2) { // Tour de J1 car plus profond
	        	System.out.println("J1 Ordre checked");
	        	return 1;
	        }
	        
	        if (positionJ1<positionJ2) { // Tour de J2 car plus profond
	        	System.out.println("J2 Ordre checked");
	        	return 2;
	        }
			
	        if (positionJ1==positionJ2) {
	        	System.out.println("Equal levels checked");
	        	int randTour = 1 + randomGenerator.nextInt(9);
	        	System.out.println("randTour = " + randTour);
	        		    
	        	if (randTour<=5) { // Tour J1    
	        		System.out.println("J1 Ordre checked");    
	        		return 1;
	        	}
	    		        	
	        	if (randTour>5) { // Tour J2
	        		System.out.println("J2 Ordre checked");    
	        		return 2;
	        	}	        		
	        }
	        return 0; //Pour valider la méthode, sinon elle donne une erreur
	}

	
	public static int Deplacement(int cas) {
			
		    boolean bool = true;
		    boolean boolMove1 = true;
		    boolean boolMove2 = true;
			
	        //Blocage du déplacement en haut et en bas des niveaux
	        
	        if (deltaY<=0) deltaY = 0 ;
	        if (deltaY>(5*niveauxC3+5*niveauxC2+5*niveauxC1)) deltaY = 5*niveauxC3+5*niveauxC2+5*niveauxC1 ;        
	        
	        if (deltaY2<=0) deltaY2 = 0 ;
	        if (deltaY2>(5*niveauxC3+5*niveauxC2+5*niveauxC1)) deltaY2 = 5*niveauxC3+5*niveauxC2+5*niveauxC1 ;  
			
			while(bool==true) { // Boucle de déplacement, permet de créer des tours de jeu
			        
				System.out.println("Move While checked");
		        
		        //Sélection du joueur
		        
		        if (cas == 1) { // Tour de J1 car plus profond
		        System.out.println("J1 turn checked");
		        	
		        	while(boolMove1) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Détection de la touche pressée
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { 
		        			Plongeur.Stop(); // Stop pour éviter de compter deux fois le mouvement
		        			boolMove1 = false;
		        			System.out.println("touche BAS");
		        			deltaY= deltaY+5;	//Modification graphique de la position
		        			positionJ1 = positionJ1 + 1;	//Modification fonctionnelle de la position
		        			System.out.println("Position J1 : " + positionJ1);
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
		        			Plongeur.Stop();
		        			boolMove1 = false;
		        			System.out.println("touche HAUT");
		        			deltaY= deltaY-5;
		        			positionJ1 = positionJ1 - 1;
		        		}
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
		        			Plongeur.Stop();
		        			boolMove1 = false;
		        		}
		        	}
	
		        		Oxygene = Oxygene - 1;
		        		bool = false; // Fin du tour, on sort du while de déplacement
		        		
		        		return deltaY;
		        }
		        
		        if (cas == 2) { // Tour de J2 car plus profond
		        	System.out.println("J2 turn checked");

		        	while(boolMove2) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Détection de la touche pressée
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
		        			Plongeur.Stop();
		        			boolMove2 = false;
		        			System.out.println("touche S");
		        			deltaY2= deltaY2+5;
		        			positionJ2 = positionJ2 + 1;
		        			System.out.println("Position J2 : " + positionJ2);
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
		        			Plongeur.Stop();
		        			boolMove2 = false;
		        			System.out.println("touche Z");
		        			deltaY2= deltaY2-5;
		        			positionJ2 = positionJ2 - 1;
		        		}
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
		        			Plongeur.Stop();
		        			boolMove2 = false;
		        		}
		        	}
		        		
		        		Oxygene = Oxygene - 1;
		        		bool = false; // Fin du tour, on sort du while de déplacement
		        		
		        		return deltaY2;
		        }
				
			} // While de déplacement
			
			 bool = true;		
			 return 0; //Pour valider la méthode, sinon elle donne une erreur
	}
	
	public static List<String> SysOxygene() { //Permet l'affichage de l'ogygène dans la console pour les tests
		
		List<String> OxygeneDisp = new ArrayList<String>();
		
		OxygeneDisp.add("Oxygène restant : " + Oxygene);
		OxygeneDisp.add("");
		OxygeneDisp.add("------------------------------------");
		OxygeneDisp.add("");
		return OxygeneDisp;
	}
	
	public static void Stop() {
		
		try {
			Thread.sleep(50);   }             
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();  }
		
	}
	
}
