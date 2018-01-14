import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

public class Plongeur extends Partie{

    public static int positionJ1 = 0;
    public static int positionJ2 = 0;
    
    
	public static int Ordre() {
	        
	        // Selection du joueur
	        
	        if (positionJ1>positionJ2) { // Tour de J1 car plus profond
	        	//System.out.println("J1 Ordre checked");
	        	return 1;
	        }
	        
	        if (positionJ1<positionJ2) { // Tour de J2 car plus profond
	        	//.out.println("J2 Ordre checked");
	        	return 2;
	        }
			
	        if (positionJ1==positionJ2) {
	        	//System.out.println("Equal levels checked");
	        	int randTour = 1 + randomGenerator.nextInt(9);
	        	//System.out.println("randTour = " + randTour);
	        		    
	        	if (randTour<=5) { // Tour J1    
	        		//System.out.println("J1 Ordre checked");    
	        		return 1;
	        	}
	    		        	
	        	if (randTour>5) { // Tour J2
	        		//System.out.println("J2 Ordre checked");    
	        		return 2;
	        	}	        		
	        }
	        return 0; //Pour valider la methode, sinon elle donne une erreur
	}

	
	public static double Deplacement(int cas) {
			
		    boolean bool = true;
		    boolean boolMove1 = true;
		    boolean boolMove2 = true;
			
		    System.out.println((nList.get(nList.size()-1).getTresor()));
		    System.out.println("Position Patrick " + positionJ2);
		    System.out.println("Position Bob " + positionJ2);
			
			while(bool==true) { // Boucle de deplacement, permet de creer des tours de jeux
				
				// Creation d'un bouton submit, il n'est valable que quand les deux joueur accepte de changer de partie.
				if (StdDraw.isKeyPressed(KeyEvent.VK_ESCAPE) && positionJ1==0 && positionJ2==0) {
					
					
				}
		        
		        if (cas == 1) { // Tour de J1 car plus profond
		        		        	
		        	while(boolMove1) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		
		        		// Detection de la touche pressee
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { 
		        			Plongeur.Stop(); // Stop pour eviter de compter deux fois le mouvement
		        			boolMove1 = false;
		        			//System.out.println("touche BAS");
		        			//deltaY= (deltaY+hauteurNiveau*SH);	//Modification graphique de la position
		        			nList.get(positionJ1).presenceJoueur1[0] = false;
		        			
		        			positionJ1 = positionJ1 + 1;
		        			noBorderEscape();
		        			
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			
		        			
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
		        			Stop();
		        			boolMove1 = false;
		        			//System.out.println("touche HAUT");
		        			nList.get(positionJ1).presenceJoueur1[0] = false;
		        			
		        			//deltaY=(deltaY-hauteurNiveau*SH);
		        			positionJ1 = positionJ1 - 1;
		        			noBorderEscape(); 
		        			
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			
		        		}
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && nList.get(positionJ1).coffreN.presence){
		        			Stop();
		        			boolMove1 = false;
		        			J1Coffre = J1Coffre + 1;
		        			nList.get(positionJ1).changeStatus(1);
		        			System.out.println(nList.get(positionJ1).getTresor());
		        			
		        		}
		        	}
	
		        		Oxygene = Oxygene - 1;
		        		bool = false; // Fin du tour, on sort du while de d�placement
		        		
		        		
		        }
		        
		        if (cas == 2) { // Tour de J2 car plus profond
		        	//System.out.println("J2 turn checked");
		        	
		        	
		        	while(boolMove2) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Detection de la touche pressee
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
		        			Stop();
		        			boolMove2 = false;
		        			//System.out.println("touche S");
		        			
		        			nList.get(positionJ2).presenceJoueur2[0] = false;
		        			positionJ2 = positionJ2 + 1;
		        			noBorderEscape();
		        			
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			//System.out.println("Position J2 : " + positionJ2);
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
		        			Stop();
		        			boolMove2 = false;
		        			//System.out.println("touche Z");
		        			
		        			nList.get(positionJ2).presenceJoueur2[0] = false;
		        			positionJ2 = positionJ2 - 1;
		        			
		        			noBorderEscape();
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			
		        			
		        		}
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_D) && nList.get(positionJ2).coffreN.presence ) {
		        			Stop();
		        			boolMove2 = false;
		        			J2Coffre = J2Coffre + 1;
		        			nList.get(positionJ2).changeStatus(2);
		        			
		        		}
		        	}
		        		
		        		Oxygene = Oxygene - 1;
		        		bool = false; // Fin du tour, on sort du while de d�placement
		        		
		        		
		        }
				
			} // While de deplacement
			
			 bool = true;		
			 return 0; //Pour valider la methode, sinon elle donne une erreur
	}
	
	public static List<String> SysOxygene() { //Permet l'affichage de l'ogyg�ne dans la console pour les tests
		
		List<String> OxygeneDisp = new ArrayList<String>();
		
		OxygeneDisp.add("Oxygene restant : " + Oxygene);
		OxygeneDisp.add("");
		OxygeneDisp.add("------------------------------------");
		OxygeneDisp.add("");
		return OxygeneDisp;
	}
	
	public static void Stop() {
		
		try {
			Thread.sleep(200);   }             
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();  }
		
	}
	public static void noBorderEscape() {
		 //Blocage du deplacement en haut et en bas des niveaux >> a revoir par rapport a la nouvelle taille
        
        if (positionJ1<=0) positionJ1 = 0 ;
        if (positionJ1>=(totNiveau123)) {
        	
        	positionJ1 =nList.size()-1;
        	
        }
        
        if (positionJ2<=0) positionJ2 = 0 ;
        if (positionJ2>=(totNiveau123)) {
        	positionJ2 = nList.size()-1 ;
        	
        }
	}
	
}
