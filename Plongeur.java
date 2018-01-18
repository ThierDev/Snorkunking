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
			
			
			while(boolMove1 == true || boolMove2 == true) { // ne permet que 2 déplacement l'un après l'autre.
				
		        if (cas == 1) { // Tour de J1
		        	
		        	StdDraw.setPenColor(StdDraw.RED);
		        	StdDraw.setPenRadius(0.008);
			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 25*SW, 25*SH); // Indicateur de tour
			        StdDraw.setPenRadius(0.002);
			        StdDraw.show();	    
			       
		        	while(boolMove1 == true) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Detection de la touche pressee
		        		
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) { 
		        			Plongeur.Stop(); // Stop pour eviter de compter deux fois le mouvement
		        			boolMove1 = false;
		        			cas=2;
		        			
		        			nList.get(positionJ1).presenceJoueur1[0] = false; // le joueur n'est plus en haut
		        			
		        			positionJ1 = positionJ1 + 1; // le joueur decend d'un niveau
		        			noBorderEscape(); // on vérifie qu'il ne vas pas trop bas/haut
		        			
		        			nList.get(positionJ1).presenceJoueur1[0] = true; // on l'affiche à la nouvelle position
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			Oxygene = Oxygene - 1 -J1Coffre; // on diminue l'oxygène en conséquence du mouvement.
		        			
		        			
		        		}
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
		        			Stop();
		        			boolMove1 = false;
		        			cas=2;
		        			// le joeur n'est plus en bas
		        			nList.get(positionJ1).presenceJoueur1[0] = false;
		        			
		        			//deltaY=(deltaY-hauteurNiveau*SH);
		        			positionJ1 = positionJ1 - 1; // il remonte
		        			noBorderEscape(); // on l'empeche d'aller trop haut/bas
		        			
		        			// on l'affiche un peu plus haut à la position p-1
		        			nList.get(positionJ1).presenceJoueur1[0] = true; 
		        			nList.get(positionJ2).presenceJoueur2[0] = true;
		        			Oxygene = Oxygene - 1 -J1Coffre; // son niveau d'oxygène decend en conséquence.
		        			
		        		
		        			
		        			Plongeur.surfaceTest(); // 0n vérifie si il n'est pas à la surface, pour déposer ou non les coffres
		        			
		        		}
		        		
		        		// si l'on appui sur enter, qu'il y'a un coffre, on peut le prendre
	 		        
		        		if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER) && nList.get(positionJ1).checkPresenceCoffre()){
		        			Stop();
		        			boolMove1 = false;
		        			cas=2;
		        			J1Coffre = J1Coffre + 1; // il prend un coffre 
		        			nList.get(positionJ1).changeStatus(1); // on indique que c'est le joueur 1 qui l'on prit
		        			tempJ1Score = tempJ1Score + nList.get(positionJ1).getTresor(1); // on calcul son score temporaire
		        			Oxygene = Oxygene - 1; // l'oxygène decend en conséquence
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
	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 25*SW, 25*SH); // Indicateur de tour
	        		StdDraw.setPenRadius(0.002);
			        StdDraw.show();
		        	
		        	while(boolMove2 == true) { // Condition pour dire qu'on ne peut faire qu'une action
		        		
		        		// Detection de la touche pressee
		        		
		        		if (IAStatus == true) {
		        			if (Math.round(((2.5*Oxygene)/OxyIni)*100)>58) {
		        				
		        				if (nList.get(positionJ2).coffreList.get(0).presence == true) {
		        					boolMove2 = false;
				        			cas=1;
				        			J2Coffre = J2Coffre + 1;
				        			nList.get(positionJ2).changeStatus(2);
				        			tempJ2Score = tempJ2Score + nList.get(positionJ2).getTresor(2);
				        			Oxygene = Oxygene - 1;
		        				}
		        					
		        				else {
		        					
				        			boolMove2 = false;
				        			cas=1;
				        			//System.out.println("touche S");
				        			
				        			nList.get(positionJ2).presenceJoueur2[0] = false;
				        			positionJ2 = positionJ2 + 1;
				        			noBorderEscape();
				        			
				        			nList.get(positionJ2).presenceJoueur2[0] = true;
				        			nList.get(positionJ1).presenceJoueur1[0] = true;
				        			Oxygene = Oxygene - 1 -J2Coffre;
		        				}
		        			}
		        			
		        			else {
		        				
		        				boolMove2 = false;
		        				cas = 1;
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
		        		}
		        		
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
		
		//actualise la barre d'oxygène
		
		if (Oxygene < 0 ) Oxygene = 0;
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.rectangle(X_MAX/2, 0.895*Y_MAX, BordureOxy*SW, 7.1*SH);
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledRectangle(X_MAX/2, 0.895*Y_MAX,5*Oxygene*SW, 7*SH);
		StdDraw.setPenColor(StdDraw.WHITE);
		PourcentageOxy = Math.round(((2.5*Oxygene)/OxyIni)*100);
		StdDraw.text(X_MAX/2, 0.890*Y_MAX, PourcentageOxy + " %");
		//System.out.println("Pourcentage : " + PourcentageOxy);
	
}
	public static void DispCoffreLateral() {
		 // Affichage lateral des coffres
      
      for (double i = 0; i < J1Coffre*22*SW; i=(i+22)*SW) { StdDraw.picture(0.95*X_MAX, (0.68*Y_MAX - i)*SW, "coffre.png", 30*SW, 27*SH); }
      for (double i = 0; i < J2Coffre*22*SW; i=(i+22)*SW) { StdDraw.picture(0.05*X_MAX, (0.68*Y_MAX - i)*SW, "coffre.png", 30*SW, 27*SH); }
	}

	
	public static void Stop() {
		// empeche d'executer plusieures actions avec un seul appui sur une touche
		try {
			Thread.sleep(200);   }             
		catch(InterruptedException ex) {
			Thread.currentThread().interrupt();  }
		
	}
	public static void noBorderEscape() {
		 //Blocage du deplacement en haut et en bas des niveaux 
		
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
		
		// lorsque un des joueur est à la surface on actualise les scores et on vide ses coffres
		
		if (positionJ1 == 0) {
			J1Score = J1Score + tempJ1Score;
			tempJ1Score = 0;
			J1Coffre = 0;
			
			for(int i=0;i<nList.size();i++) {
				if(nList.get(i).coffreList.get(0).status==1) {
					nList.get(i).coffreList.get(0).status = 0;
					nList.get(i).coffreList.get(0).dropped = true;
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
					nList.get(i).coffreList.get(0).dropped = true;
					
				}
			}
			
			BackgroundGraphics();
			DispOxygene();
			Partie.displayScore();
			DispCoffreLateral();
		}
	}
	
}
