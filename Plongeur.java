import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;

public class Plongeur extends Partie{

    public static int positionJ1 = 0;
    public static int positionJ2 = 0;
    
    public static boolean boolMove1 = true;
    public static boolean boolMove2 = true;
	public static int cas;
   
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
	
	
	
	public static void Deplacement() {
			
		cas = Ordre();
		if (boolMove1 == false && boolMove2 == false) {		
			boolMove1 = true;
			boolMove2 = true;		
		}
			
			
			while(boolMove1 == true || boolMove2 == true) { // Boucle de deplacement, permet de creer des tours de jeux	
				
		        if (cas == 1) { // Tour de J1
		        	
		        	StdDraw.setPenColor(StdDraw.RED);
		        	StdDraw.setPenRadius(0.008);
			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
			        StdDraw.setPenRadius(0.002);
			        StdDraw.show();	    
			       
		        	while(boolMove1 == true) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Detection de la touche pressee
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { 
		        			Plongeur.Stop(); // Stop pour eviter de compter deux fois le mouvement
		        			boolMove1 = false;
		        			cas=2;
		        			//System.out.println("touche BAS");
		        			//deltaY= (deltaY+hauteurNiveau*SH);	//Modification graphique de la position
		        			nList.get(positionJ1).presenceJoueur1[0] = false;
		        			
		        			positionJ1 = positionJ1 + 1;
		        			noBorderEscape();
		        			
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			Oxygene = Oxygene - 1 -J1Coffre;
		        			
		        			
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
		        			Stop();
		        			boolMove1 = false;
		        			cas=2;
		        			//System.out.println("touche HAUT");
		        			nList.get(positionJ1).presenceJoueur1[0] = false;
		        			
		        			//deltaY=(deltaY-hauteurNiveau*SH);
		        			positionJ1 = positionJ1 - 1;
		        			noBorderEscape(); 
		        			
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			Oxygene = Oxygene - 1 -J1Coffre;
		        			
		        			System.out.println("Surface Test J1");
		        			System.out.println("Nombre de trésors sur soi : " + tempJ1Score);
		        			
		        			Plongeur.surfaceTest();
		        			
		        		}
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && nList.get(positionJ1).checkPresenceCoffre()){
		        			Stop();
		        			boolMove1 = false;
		        			cas=2;
		        			J1Coffre = J1Coffre + 1;
		        			nList.get(positionJ1).changeStatus(1);
		        			tempJ1Score = tempJ1Score + nList.get(positionJ1).getTresor(1);
		        			Oxygene = Oxygene - 1;
		        		}
		        		  		
		        	}
		        	
			        if (Oxygene>0) {
			        	BackgroundGraphics();
	    				DispOxygene();
	    				displayScore();
	    				DispCoffreLateral();
	    				
	    			}
		        	
		        }
		        
		        if (cas == 2) { // Tour de J2
		        	
		        	StdDraw.setPenColor(StdDraw.RED);
		        	StdDraw.setPenRadius(0.008);
	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
	        		StdDraw.setPenRadius(0.002);
			        StdDraw.show();
		        	
		        	while(boolMove2 == true) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Detection de la touche pressee
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
		        			Stop();
		        			boolMove2 = false;
		        			cas=1;
		        			//System.out.println("touche S");
		        			
		        			nList.get(positionJ2).presenceJoueur2[0] = false;
		        			positionJ2 = positionJ2 + 1;
		        			noBorderEscape();
		        			
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			Oxygene = Oxygene - 1 -J2Coffre;
		        			//System.out.println("Position J2 : " + positionJ2);
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_Z)) {
		        			Stop();
		        			boolMove2 = false;
		        			cas=1;
		        			//System.out.println("touche Z");
		        			
		        			nList.get(positionJ2).presenceJoueur2[0] = false;
		        			positionJ2 = positionJ2 - 1;
		        			
		        			noBorderEscape();
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			nList.get(positionJ1).presenceJoueur1[0] = true;
		        			Oxygene = Oxygene - 1 -J2Coffre;
		        			
		        			System.out.println("Surface Test J2");
		        			System.out.println("Nombre de trésors sur soi : " + tempJ2Score);
		        			
		        			Plongeur.surfaceTest();
		        		}
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_D) && nList.get(positionJ2).checkPresenceCoffre() ) {
		        			Stop();
		        			boolMove2 = false;
		        			cas=1;
		        			J2Coffre = J2Coffre + 1;
		        			nList.get(positionJ2).changeStatus(2);
		        			tempJ2Score = tempJ2Score + nList.get(positionJ2).getTresor(2);
		        			Oxygene = Oxygene - 1;
		        			
		        		}

		        	}
		        	
			        if (Oxygene>0) {
			        	BackgroundGraphics();
	    				DispOxygene();
	    				displayScore();
	    				DispCoffreLateral();
	    				
	    			}
		        }    
			} // While de deplacement
			
 
	}
	public static void DispOxygene() {
		
		if (Oxygene < 0 ) Oxygene = 0;
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(X_MAX/2, 0.95*Y_MAX, BordureOxy*SW, 7.1*SH);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledRectangle(X_MAX/2, 0.95*Y_MAX,5*Oxygene*SW, 7*SH);
		StdDraw.setPenColor(StdDraw.WHITE);
		PourcentageOxy = Math.round(((2.5*Oxygene)/OxyIni)*100);
		StdDraw.text(X_MAX/2, 0.945*Y_MAX, PourcentageOxy + " %");
		//System.out.println("Pourcentage : " + PourcentageOxy);
	
}
	public static void DispCoffreLateral() {
		 // Affichage lateral des coffres
      
      for (double i = 0; i < J1Coffre*22*SW; i=(i+22)*SW) { StdDraw.picture(0.95*X_MAX, (0.68*Y_MAX - i)*SW, "coffre.png", 30*SW, 27*SH); }
      for (double i = 0; i < J2Coffre*22*SW; i=(i+22)*SW) { StdDraw.picture(0.05*X_MAX, (0.68*Y_MAX - i)*SW, "coffre.png", 30*SW, 27*SH); }
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
        if (positionJ1>=(nList.size())) {
        	
        	positionJ1 =nList.size()-1;
        	
        }
        
        if (positionJ2<=0) positionJ2 = 0 ;
        if (positionJ2>=(nList.size())) {
        	positionJ2 = nList.size()-1 ;
        	
        }
	}
	
	public static void surfaceTest() {
		if (positionJ1 == 0) {
			J1Score = J1Score + tempJ1Score;
			tempJ1Score = 0;
			J1Coffre = 0;
			
			for(int i=0;i<nList.size();i++) {
				if(nList.get(i).coffreList.get(0).status==1) {
					nList.get(i).coffreList.get(0).status = 0;	
				}
			}
			
			BackgroundGraphics();
			DispOxygene();
			Partie.displayScore(); 
			DispCoffreLateral();
		}
		
		if (positionJ2 == 0) {
			J2Score = J2Score + tempJ2Score;
			tempJ2Score = 0;
			J2Coffre = 0;
			
			for(int i=0;i<nList.size();i++) {
				if(nList.get(i).coffreList.get(0).status==2) {
					nList.get(i).coffreList.get(0).status = 0;	
				}
			}
			
			BackgroundGraphics();
			DispOxygene();
			Partie.displayScore();
			DispCoffreLateral();
		}
	}
	
}
