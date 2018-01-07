import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import edu.princeton.cs.introcs.StdDraw;

public class Partie extends Main{
	static Random randomGenerator = new Random();
	public static int niveauxC1 = 9 + randomGenerator.nextInt(12-9);
	public static int niveauxC2 = 6 + randomGenerator.nextInt(9-6);
	public static int niveauxC3 = 3+ randomGenerator.nextInt(6-3);
	public static int totNiveau123 = niveauxC1+niveauxC2+niveauxC3;
	public static double hauteurNiveau = 250/totNiveau123;
	public static List<NiveauC> nList = new ArrayList<NiveauC>();
	public static int Oxygene = 2*(niveauxC3+niveauxC2+niveauxC1);  // VERSION BETA, PAS DE CLASSE DE GESTION DE l'OXYGENE POUR LE MOMENT
    
	public static double h1 = (hauteurNiveau*niveauxC3+hauteurNiveau*niveauxC2+hauteurNiveau*niveauxC1)*SH;
	
	public int index;  
    public static double deltaY = 0;
    public static double deltaY2 = 0;
    
	public static void createNiveau(){	
		for (int i = 0; i < niveauxC1; i++) {
			nList.add(new NiveauC(1,i,totNiveau123));
			System.out.println("here " +i);
		}
		for (int i=niveauxC1+1;i<=niveauxC1+niveauxC2;i++){
			nList.add(new NiveauC(2,i,totNiveau123));
			System.out.println("here2 "+i);
		}
		for (int i=niveauxC2+niveauxC1+1;i<=niveauxC1+niveauxC2+niveauxC3;i++){
			nList.add(new NiveauC(3,i,totNiveau123));
			System.out.println("here3 " +i);
		}

	}


    
   
    
	public static void BackgroundGraphics() { // L'ensemble des �l�ments de toujours pr�sents � l'image. J'ai inclu les coffres pour l'instant

					Font FontScore = new Font("Arial", Font.BOLD,(int) (25*SW));
					Font FontPourcent = new Font("Arial", Font.PLAIN, (int)(20*SW));
							
    				  // Je suis revenu au jpg parce que le gif �tait super chiant � afficher durant les boucles
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg",640*SW,360*SH);
    				// Indicateurs dans les coins pour dire qui va jouer
    				
    				StdDraw.picture(0.05*X_MAX, 0.9*Y_MAX, "bob.png", 25*SW, 25*SH);
    		        StdDraw.picture(X_MAX-0.05*X_MAX, 0.9*Y_MAX, "patrick.png", 25*SW, 25*SH);
    		        
    		        // Affichage des scores
    		        
    		        StdDraw.setFont(FontScore);
    		        StdDraw.setPenColor(StdDraw.RED);
    		        StdDraw.text(0.05*X_MAX, 0.78*Y_MAX, "Score");
    		        StdDraw.text(0.95*X_MAX, 0.78*Y_MAX, "Score");
    				
					//createNiveau();			 
					 for (int i=0;i<totNiveau123;i++){
						 nList.get(i).drawNiveau();					 
						}




        }
     				
     				
     public static void DispDeplacement() {
    	 
		 //Niveau.WindowInit();
		 
		 createNiveau();
		 
    	 BackgroundGraphics();
    	 
    	 while(Oxygene>0) { // AFFICHAGE MANCHE DE JEU - UNE BOUCLE = UN TOUR D'UN JOUEUR
     				
     				// Affichage barre d'oxyg�ne
     				
     				double BordureOxy = 4*(niveauxC3+niveauxC2+niveauxC1) + 0.1;
     				double OxyIni = 2*(niveauxC3+niveauxC2+niveauxC1);
     				
     				StdDraw.setPenColor(StdDraw.BLACK);
     				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy*SW, 6.1*SH);
     				StdDraw.setPenColor(StdDraw.BLUE);
     				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene*SW, 6*SH);
     				
     				double PourcentageOxy = Math.round(((Oxygene/OxyIni)*100));  // Affichage du pourcentage d'oxyg�ne
     				StdDraw.setPenColor(StdDraw.WHITE);
     				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    				
    				StdDraw.show(50);
    				
    				// Affichage des personnages avant les premiers d�placements
    				
    				deplacementPerso();
    				
    				int Ordre = Plongeur.Ordre();  // On r�cup�re l'info de qui va jouer
    				if (Ordre == 1) { // J1 va jouer en premier
    					
    					// Tour J1
    					StdDraw.setPenColor(StdDraw.RED);
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la m�thode de d�placement pour le J1
    			        
    			        BackgroundGraphics(); // Efface l'image pour le fond de base mais pas les joueurs
    			        
    			        // Affichage des joueurs apr�s d�placement de J1 
    			        
    			        deplacementPerso();

    	        		// Mise � jour de la barre d'oxygene	
    	        		
    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy*SW, 6.1*SH);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene*SW, 6*SH);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    	        		// Tour J2
    	        		StdDraw.setPenColor(StdDraw.RED);
    	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J2 checked");
    			        deltaY2 = Plongeur.Deplacement(2); // Appelle la m�thode de d�placement pour le J2
    			        
    			        BackgroundGraphics();
    			        
    			        deplacementPerso();

    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy*SW, 6.1*SH);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene*SW, 6*SH);
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
    			        deltaY2 = Plongeur.Deplacement(2); // Appelle la m�thode de d�placement pour le J2

    			        BackgroundGraphics();
    			        
    			        deplacementPerso();

    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy*SW, 6.1*SH);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene*SW, 6*SH);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    	        		// Tour J1
    	        		StdDraw.setPenColor(StdDraw.RED);
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la m�thode de d�placement pour le J1
    			        
    			        BackgroundGraphics();
    			        
    			        deplacementPerso();
// mise a jour de la barre d'oxy 
    	        		StdDraw.setPenColor(StdDraw.BLACK);
         				StdDraw.rectangle(X_MAX/2, 0.9*Y_MAX, BordureOxy*SW, 6.1*SH);
         				StdDraw.setPenColor(StdDraw.BLUE);
         				StdDraw.filledRectangle(X_MAX/2, 0.9*Y_MAX, 2*Oxygene*SW, 6*SH);
         				StdDraw.setPenColor(StdDraw.WHITE);
         				StdDraw.text(X_MAX/2, 0.9*Y_MAX, PourcentageOxy + " %");
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    				} 
    				
        } // While affichage global
		System.exit(0); // BETA - Fin de programme actuelle pour �viter des boucles ind�sirables
	}
	public static void deplacementPerso(){
		StdDraw.picture(X_MAX-0.25*X_MAX, h1-deltaY+hauteurNiveau,"patrick.png", 12*SW, 12*SH);
    	StdDraw.picture(0.25*X_MAX, h1-deltaY2+hauteurNiveau,"bob.png", 12*SW, 12*SH);
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