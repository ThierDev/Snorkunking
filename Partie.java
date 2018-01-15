import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import edu.princeton.cs.introcs.StdDraw;

public class Partie extends Main{
	
	
	
	public static int totNiveau123 = niveauxC1+niveauxC2+niveauxC3 + 1;
	//public static double hauteurNiveau = 280/(totNiveau123-1);
	public static List<NiveauC> nList = new ArrayList<NiveauC>();
	public static int Oxygene = 2*(niveauxC3+niveauxC2+niveauxC1);  // VERSION BETA, PAS DE CLASSE DE GESTION DE l'OXYGENE POUR LE MOMENT
    
	
	 //public static double h1 = (hauteurNiveau*niveauxC3+hauteurNiveau*niveauxC2+hauteurNiveau*niveauxC1)*SH;
	
 

    public static int J1Score=0;
    public static int J2Score=0;
    public static int J1Coffre = 0;
    public static int J2Coffre = 0;
	public static int tempJ1Score = 0;
	public static int tempJ2Score = 0; 
    
    public static int nbPartie = 0;
    
	static double BordureOxy = 10*(niveauxC3+niveauxC2+niveauxC1) + 0.1;
	static double OxyIni = 5*(niveauxC3+niveauxC2+niveauxC1);
	static double PourcentageOxy = Math.round(((2.5*Oxygene)/OxyIni)*100);  // Affichage du pourcentage d'oxygene
	
	public static void createNiveau(){	
		
		nList.add(new NiveauC(0,0,totNiveau123));
		
		for (int i = 1; i <= niveauxC1; i++) {
			nList.add(new NiveauC(1,i,totNiveau123));
		}
		for (int i=niveauxC1 + 1;i<=niveauxC1+niveauxC2;i++){
			nList.add(new NiveauC(2,i,totNiveau123));
		}
		for (int i=niveauxC2+niveauxC1+1;i<=niveauxC1+niveauxC2+niveauxC3;i++){
			nList.add(new NiveauC(3,i,totNiveau123));
		}
		System.out.println("totalniveau "+ totNiveau123);

		System.out.println("nlisttaille "+nList.size());

	}
   
    
	public static void BackgroundGraphics() { // L'ensemble des elements de toujours presents a l'image. J'ai inclu les coffres pour l'instant

					Font FontScore = new Font("Arial", Font.BOLD,(int) (25*SW));
					Font FontPourcent = new Font("Arial", Font.PLAIN, (int)(20*SW));
							
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg",640*SW,360*SH);
    				
    				// Indicateurs dans les coins pour dire qui va jouer
    				
    				StdDraw.picture(0.05*X_MAX, 0.9*Y_MAX, "bob.png", 25*SW, 25*SH);
    		        StdDraw.picture(X_MAX-0.05*X_MAX, 0.9*Y_MAX, "patrick.png", 25*SW, 25*SH);
    		        
    		        // Affichage des scores
    		        
    		        StdDraw.setFont(FontScore);
    		        StdDraw.setPenColor(StdDraw.RED);
    		        StdDraw.text(0.05*X_MAX, 0.78*Y_MAX, "Score");
    		        StdDraw.text(0.95*X_MAX, 0.78*Y_MAX, "Score");
    		        
    		        StdDraw.setPenColor(StdDraw.WHITE);
    		        StdDraw.filledRectangle(X_MAX/2, 0.90*Y_MAX,25*SW, 7*SH);
    		        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
    				StdDraw.text(X_MAX/2, 0.895*Y_MAX, "Round " + (nbPartie+1));
    		        
    		        
					//createNiveau();			 
					 for (int i=0;i<nList.size();i++){
						 nList.get(i).drawNiveau();
						}
					 
        }
     				
     				
     public static void DispDeplacement() {
    	 
    	 
    	 while(nbPartie<3) {
    		 Oxygene = 2*(totNiveau123);
    		 BackgroundGraphics();
        	 displayScore();
    	 
	    	 while(Oxygene>0) { // AFFICHAGE MANCHE DE JEU - UNE BOUCLE = UN TOUR D'UN JOUEUR
	     				
	     				// Affichage barre d'oxygene
	     				
	     				Plongeur.DispOxygene();
	    				
	    				StdDraw.show(50);
	    				
	    				// Affichage des personnages avant les premiers deplacements
	    				
	    				int Ordre = Plongeur.Ordre();  // On recupere l'info de qui va jouer
	    				if (Ordre == 1) { // J1 va jouer en premier
	    					
	    					// Tour J1
 			        
	    			        Plongeur.Deplacement(1); // Appelle la methode de deplacement pour le J1
	    			        
	    	        		StdDraw.show();

	    	        		 //Tour J2	        
	    			        Plongeur.Deplacement(2); // Appelle la methode de dï¿½placement pour le J2
	    			        
	    	        		StdDraw.show();
	    	        		
	    	        		//printList(Plongeur.SysOxygene()); 	        		
	    				}
	    					
	    				if (Ordre == 2) { // J2 va jouer en premier
	    	        		
	    	        		// Tour J2
	    					
	    			        
	    			        Plongeur.Deplacement(2); // Appelle la methode de deplacement pour le J2
	    			        
	    	        		StdDraw.show();
	    	        			
	    	        		// Tour J1
	    	        		      
	    			        Plongeur.Deplacement(1); // Appelle la methode de deplacement pour le J1
	    			        
	    	        		StdDraw.show(); 
	    	        		
	    	        		//printList(Plongeur.SysOxygene());
	    	        		
	    				} 
    				
	    	 } //while affichage oxygène
	    	 System.out.println("Fin phase : " + (nbPartie + 1));
	    	 nextPartie();
    	 
    	 }
	}
	
	
	public static void sumScore() {

		for(int i=0;i<nList.size()-1;i++) {
			tempJ1Score += nList.get(i).getTresor(1);
			tempJ2Score += nList.get(i).getTresor(2);
			
		}
	}
		

	public static void displayScore() {
		
		// print the scores
		Font FontScore = new Font("Arial", Font.BOLD,(int) (25*SW));
		StdDraw.setFont(FontScore);
        StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.filledRectangle(0.05*X_MAX, 0.74*Y_MAX,20*SW,7*SH);
		StdDraw.filledRectangle(0.95*X_MAX, 0.74*Y_MAX,20*SW,7*SH);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.05*X_MAX, 0.735*Y_MAX, Integer.toString(J2Score));
        StdDraw.text(0.95*X_MAX, 0.735*Y_MAX, Integer.toString(J1Score));
        
	}
	
	public static void nextPartie() {
		
		nbPartie += 1 ;
		
		if(Plongeur.positionJ1 !=0 && Plongeur.positionJ2!=0) { // si les deux joueurs ne sont pas remonté a la surface
			for(int i=1;i<nList.size()-2;i++) {
				System.out.print(nList.get(i).coffreList.get(0).presence + " ");
				System.out.println("cas !=0 i : " + i);
				if(nList.get(i).coffreList.get(0).presence == false) {
					nList.get(i).coffreList.get(0).NiveauType = 3;
					nList.get(i).coffreList.get(0).presence = true;
					nList.get(nList.size()-1).coffreList.add(nList.get(i).coffreList.get(0)); /// on ajoute au dernier niveau les coffre perdu
					nList.remove(i);
					i -=1 ;
					System.out.println("adding coffre "+ i + " in "+(nList.get(nList.size()-1).coffreList.size()-1));
				}
				
			}
			
			tempJ1Score = 0;
			tempJ2Score = 0;
			
		}
		
		/*else if(Plongeur.positionJ1==0 && Plongeur.positionJ2 ==0 ) {
			for(int i=1;i<nList.size();i++) {
				
				if(nList.get(i).coffreList.get(0).presence == false) {
					System.out.println("adding coffre "+ i + " in "+(nList.get(nList.size()-1).coffreList.size()-1));
					nList.get(i).coffreList.get(0).NiveauType =3;
					if (i!=0) nList.get(i).coffreList.get(0).presence = true;
					nList.get(nList.size()-1).coffreList.add(nList.get(i).coffreList.get(0)); /// on ajoute au dernier niveau les coffre perdu
				
					System.out.println("im destroying level "+ i + " in case status 2 " + " color "+nList.get(i).typeNiveau);
					nList.remove(i);
					System.out.println("Level Destroy - nList size :" + nList.size());
				}
				
			}
			
		}*/
		
		
		updateNiveauInfo();
		
		
	} // fin de nextPartie
	
	public static void updateNiveauInfo() {
		
	
		for(int i=0;i<nList.size();i++) {
			nList.get(i).position =i;
			nList.get(i).totalNiveau =nList.size();
			nList.get(i).presenceJoueur1[0]=false;
			nList.get(i).presenceJoueur2[0]=false;
			
			//if (i!=0) nList.get(i).coffreList.get(0).presence = true;
			//if (i!=0) nList.get(i).coffreList.get(0).status = 0;
			
		}
		
		Plongeur.positionJ1 = 0;
		Plongeur.positionJ2 = 0;
		J1Coffre = 0;
		J2Coffre = 0;
		nList.get(0).presenceJoueur1[0]=true;
		nList.get(0).presenceJoueur2[0]=true;
		
		
}
	
	public static void printList(List<NiveauC> list) {
		for (int d=0; d<list.size();d++) {
			if (d==list.size()) {
				System.out.println(list.get(d));
			}
			System.out.println(list.get(d));
		}
	}
	
	
}