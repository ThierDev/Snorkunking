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
	public static int totNiveau123 = niveauxC1+niveauxC2+niveauxC3 + 1;
	public static double hauteurNiveau = 280/(totNiveau123-1);
	public static List<NiveauC> nList = new ArrayList<NiveauC>();
	public static int Oxygene = 2*(niveauxC3+niveauxC2+niveauxC1);  // VERSION BETA, PAS DE CLASSE DE GESTION DE l'OXYGENE POUR LE MOMENT
    
	
	public static double h1 = (hauteurNiveau*niveauxC3+hauteurNiveau*niveauxC2+hauteurNiveau*niveauxC1)*SH;
	
	public int index;  
    public static double deltaY = 0;
    public static double deltaY2 = 0;

    public static int keyPressed = 0;
    public static int J1Coffre = 0;
    public static int J2Coffre = 0;
    
	static double BordureOxy = 10*(niveauxC3+niveauxC2+niveauxC1) + 0.1;
	static double OxyIni = 5*(niveauxC3+niveauxC2+niveauxC1);
	static double PourcentageOxy = Math.round(((2.5*Oxygene)/OxyIni)*100);  // Affichage du pourcentage d'oxygene
	
	public static void createNiveau(){	
		
		nList.add(new NiveauC(0,0,totNiveau123));
		System.out.println("here " +0);
		
		for (int i = 1; i < niveauxC1 + 1; i++) {
			nList.add(new NiveauC(1,i,totNiveau123));
			System.out.println("here " +i);
		}
		for (int i=niveauxC1 + 2;i<=niveauxC1+niveauxC2 + 1;i++){
			nList.add(new NiveauC(2,i,totNiveau123));
			System.out.println("here2 "+i);
		}
		for (int i=niveauxC2+niveauxC1 + 2;i<=niveauxC1+niveauxC2+niveauxC3 + 1;i++){
			nList.add(new NiveauC(3,i,totNiveau123));
			System.out.println("here3 " +i);
		}

	}
   
    
	public static void BackgroundGraphics() { // L'ensemble des elements de toujours presents a l'image. J'ai inclu les coffres pour l'instant

					Font FontScore = new Font("Arial", Font.BOLD,(int) (25*SW));
					Font FontPourcent = new Font("Arial", Font.PLAIN, (int)(20*SW));
							
    				  // Je suis revenu au jpg parce que le gif ï¿½tait super chiant a afficher durant les boucles
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
     				
     				// Affichage barre d'oxygene
     				
     				Partie.DispOxygene();
    				
    				StdDraw.show(50);
    				
    				// Affichage des personnages avant les premiers deplacements
    				
    				//actionPerso();
    				
    				int Ordre = Plongeur.Ordre();  // On recupere l'info de qui va jouer
    				if (Ordre == 1) { // J1 va jouer en premier
    					
    					// Tour J1
    					StdDraw.setPenColor(StdDraw.RED);
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la methode de deplacement pour le J1
    			        
    			        BackgroundGraphics(); // Efface l'image pour le fond de base mais pas les joueurs
    			        
    			        // Affichage des joueurs aprï¿½s deplacement de J1 
    			        
    			        //actionPerso();

    			        // Mise a jour de la barre d'oxygene	
    	        		
    			        Partie.DispOxygene();	
    			        
    			        Partie.DispCoffreLateral();
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    	        		// Tour J2
    	        		StdDraw.setPenColor(StdDraw.RED);
    	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J2 checked");
    			        deltaY2 = Plongeur.Deplacement(2); // Appelle la mï¿½thode de dï¿½placement pour le J2
    			        
    			        BackgroundGraphics();
    			        
    			        //actionPerso();

    			        Partie.DispOxygene();
    	        		
    			        Partie.DispCoffreLateral();
    			        
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene()); 	        		
    				}
    					
    				if (Ordre == 2) { // J2 va jouer en premier
    	        		
    	        		// Tour J2
    					StdDraw.setPenColor(StdDraw.RED);
    	        		StdDraw.rectangle(0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J2 checked");
    			        deltaY2 = Plongeur.Deplacement(2); // Appelle la methode de deplacement pour le J2

    			        BackgroundGraphics();
    			        
    			        //actionPerso();

    			        Partie.DispOxygene();
    			        
    			        Partie.DispCoffreLateral();
    	        		
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    	        		// Tour J1
    	        		StdDraw.setPenColor(StdDraw.RED);
    			        StdDraw.rectangle(X_MAX-0.05*X_MAX, 0.9*Y_MAX, 20*SW, 20*SH); // Indicateur de tour
    			        StdDraw.show();
    			        System.out.println("Return Ordre vers Niveau J1 checked");
    			        deltaY = Plongeur.Deplacement(1); // Appelle la methode de deplacement pour le J1
    			        
    			        BackgroundGraphics();
    			        
    			        //actionPerso();

    			        Partie.DispOxygene();

    			        Partie.DispCoffreLateral();
    			        
    	        		StdDraw.show();
    	        		
    	        		printList(Plongeur.SysOxygene());
    	        		
    				} 
    				
        } // While affichage global
		System.exit(0); // BETA - Fin de programme actuelle pour ï¿½viter des boucles indï¿½sirables
	}
	public static void actionPerso(){
		StdDraw.picture(X_MAX-0.25*X_MAX, h1-deltaY+hauteurNiveau,"patrick.png", 12*SW, 12*SH);
    	StdDraw.picture(0.25*X_MAX, h1-deltaY2+hauteurNiveau,"bob.png", 12*SW, 12*SH);
	}
	
	public static void DispOxygene() {
		
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.rectangle(X_MAX/2, 0.95*Y_MAX, BordureOxy*SW, 7.1*SH);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.filledRectangle(X_MAX/2, 0.95*Y_MAX, 5*Oxygene*SW, 7*SH);
			StdDraw.setPenColor(StdDraw.WHITE);
			PourcentageOxy = Math.round(((2.5*Oxygene)/OxyIni)*100);
			StdDraw.text(X_MAX/2, 0.945*Y_MAX, PourcentageOxy + " %");
			System.out.println("Pourcentage : " + PourcentageOxy);
		
	}
	
	public static void DispCoffreLateral() {
		 // Affichage latéral des coffres
        
        for (int i = 0; i < J1Coffre; i=i+10) { StdDraw.picture(0.95*X_MAX, 0.7*Y_MAX + 10 + i, "coffre.png", 30*SW, 27*SH); }
        for (int i = 0; i < J2Coffre; i=i+10) { StdDraw.picture(0.05*X_MAX, 0.7*Y_MAX + 10 + i, "coffre.png", 30*SW, 27*SH); }
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