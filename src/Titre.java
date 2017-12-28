import java.awt.Font;
import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Titre extends Main{

	
	public static double SW = Scaling.scalingFactor()[0];
	public static double SH = Scaling.scalingFactor()[1];
	
	
	public int index;
	public static int X_MAX=(int)(1280*SW);
	public static int Y_MAX=(int)(720*SH);
	public static double WIDTH=0.5f;
	
	public static void Launch() throws Exception {	
		
		System.out.println(SW);
		int compteurlancement = 0;
		Boolean bool1 = false;
		Font FontSelctionTitre = new Font("Arial", Font.BOLD,(int)(40*SW));
		StdDraw.setCanvasSize((int)(1280*SW),(int)(720*SH));
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
        Sound2 menuTheme = new Sound2("GuileTheme.wav");
        Sound2 Explosion = new Sound2("explosion2.wav");
        Sound2 pop = new Sound2("pop.wav");
        
        while(true){	
        	
        	StdDraw.picture(X_MAX/2, Y_MAX/2, "Avertissement.png",640*SW,360*SH);

        	
        	try {
				Thread.sleep(4000);   }             
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();  }
        	
    		if (compteurlancement<1) {
    			for (int i = Y_MAX; i> 20; i=(int) (i-5)) { //Chute de la bouteille
    			
    			StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg",640*SW,360*SH); 
    		    StdDraw.picture(X_MAX/2, i,"bouteille.png",50*SW,50*SH);
    		    
    		    	if (i<= (int)(25*SW)) { 
	
    		    	StdDraw.picture(X_MAX/2, i,"explosion.gif");
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg",640*SW,360*SH);
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 350*SW, 350*SH);	
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 380*SW, 240*SH); }
    		    	StdDraw.show((int)(20/SH));}
					Explosion.PlaySound(); // Explosion son
    				
    				try {
    					Thread.sleep((int) (800/SW));   }             
    				catch(InterruptedException ex) {
    					Thread.currentThread().interrupt();  }
    				
    				for (int i=0; i <50; i = (int)(i +5)) {  // Explosions + Titre
    					
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 350*SW, 350*SH);
    				StdDraw.show(10/(int)(SH)); 
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 380*SW, 240*SH);
    				StdDraw.show(10/(int)(SH));
    				StdDraw.picture(X_MAX/4, 3*Y_MAX/4,"explosion.gif", 350*SW, 350*SH);
    				StdDraw.show(10/(int)(SH)); 
    				StdDraw.picture(X_MAX/4, Y_MAX/4,"explosion.gif", 350*SW, 350*SH);
    				StdDraw.show(10/(int)(SH)); 
    				StdDraw.picture(3*X_MAX/4, 3*Y_MAX/4,"explosion.gif", 350*SW, 350*SH);
    				StdDraw.show(10/(int)(SH)); 
    				StdDraw.picture(3*X_MAX/4, Y_MAX/4,"explosion.gif", 350*SW, 350*SH);
    				StdDraw.show(10/(int)(SH)); }
    				
    				menuTheme.PlaySoundC();
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 380*SW, 240*SH);
    				StdDraw.show(2000/(int)(SH));
    				
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg",640*SW,360*SH);  // Ecran titre
    				StdDraw.picture(X_MAX/2, Y_MAX/2+60,"SnorkUnkingLogo.png", 380*SW, 240*SH);
    				StdDraw.setPenColor(StdDraw.WHITE);
    				StdDraw.setFont(FontSelctionTitre);
    				StdDraw.rectangle(X_MAX/4,Y_MAX/2-50*SH,60*SW,20*SH);
    				StdDraw.text(X_MAX/4,Y_MAX/2-52*SH,"1 JOUEUR");
    				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2-50*SH,60*SW,20*SH);
    				StdDraw.text(3*X_MAX/4,Y_MAX/2-52*SH,"2 JOUEURS");	
    				StdDraw.show();
    				
    				while(bool1 == false) {
    					
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) { //Selection 1 JOUEUR
    		        	
    		        	
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2-50*SH,60*SW,20*SH);
        				StdDraw.text(X_MAX/4,Y_MAX/2-52*SH,"1 JOUEUR");
        			
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2-50*SH,60*SW,20*SH);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2-52*SH,"2 JOUEURS");
        				StdDraw.show();
        				}
    		        
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) { //Selection 2 JOUEURS
    		        	
    		        	
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2-50*SH,60*SW,20*SH);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2-52*SH,"2 JOUEURS");
        				
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2-50*SH,60*SW,20*SH);
        				StdDraw.text(X_MAX/4,Y_MAX/2-52*SH,"1 JOUEUR");
        				StdDraw.show();
        				}
    		         
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {bool1 = true;
    		        	menuTheme.Stop();
    		        	Niveau.DispDeplacement();} // Detection choix mode de jeu
    			} }     	
        
        	}
        }
	
}