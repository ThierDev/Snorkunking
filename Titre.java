import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;
import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioInputStream.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Scanner;
import java.io.*;
import javax.sound.sampled.AudioInputStream.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Titre extends Main{

	public int index;
	public final static int X_MAX=640;
	public final static int Y_MAX=360;
	public final static double WIDTH=0.5f;
	
	public static void Launch() throws Exception {	
		
		int compteurlancement = 0;
		Boolean bool1 = false;
		Font FontSelctionTitre = new Font("Arial", Font.BOLD, 40);
		StdDraw.setCanvasSize(1280,720);
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
        Sound2 menuTheme = new Sound2("GuileTheme.wav");
        Sound2 Explosion = new Sound2("explosion2.wav");
        
        
        while(true){	
        	
        	StdDraw.picture(X_MAX/2, Y_MAX/2, "Avertissement.png");

        	
        	try {
				Thread.sleep(4000);   }             
			catch(InterruptedException ex) {
				Thread.currentThread().interrupt();  }
        	
    		if (compteurlancement<1) {
    			for (int i = Y_MAX; i> 20; i=i-5) { //Chute de la bouteille
    			
    			StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg"); 
    		    StdDraw.picture(X_MAX/2, i,"bouteille.png",50,50);
    		    
    		    	if (i<= 25) { 
	
    		    	StdDraw.picture(X_MAX/2, i,"explosion.gif");
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 350, 350);	
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 380, 240); }
    		    	StdDraw.show(20);}
					Explosion.PlaySound(); // Explosion son
    				
    				try {
    					Thread.sleep(800);   }             
    				catch(InterruptedException ex) {
    					Thread.currentThread().interrupt();  }
    				
    				for (int i=0; i <=50; i = i +5) {  // Explosions + Titre
    					
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 350, 350);
    				StdDraw.show(10); 
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 380, 240);
    				StdDraw.show(10);
    				StdDraw.picture(X_MAX/4, 3*Y_MAX/4,"explosion.gif", 350, 350);
    				StdDraw.show(10); 
    				StdDraw.picture(X_MAX/4, Y_MAX/4,"explosion.gif", 350, 350);
    				StdDraw.show(10); 
    				StdDraw.picture(3*X_MAX/4, 3*Y_MAX/4,"explosion.gif", 350, 350);
    				StdDraw.show(10); 
    				StdDraw.picture(3*X_MAX/4, Y_MAX/4,"explosion.gif", 350, 350);
    				StdDraw.show(10); }
    				
    				menuTheme.PlaySoundC();
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 380, 240);
    				StdDraw.show(2000);
    				
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");  // Ecran titre
    				StdDraw.picture(X_MAX/2, Y_MAX/2+60,"SnorkUnkingLogo.png", 380, 240);
    				StdDraw.setPenColor(StdDraw.WHITE);
    				StdDraw.setFont(FontSelctionTitre);
    				StdDraw.rectangle(X_MAX/4,Y_MAX/2-50,60,20);
    				StdDraw.text(X_MAX/4,Y_MAX/2-52,"1 JOUEUR");
    				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2-50,60,20);
    				StdDraw.text(3*X_MAX/4,Y_MAX/2-52,"2 JOUEURS");	
    				StdDraw.show();
    				
    				while(bool1 == false) {
    					
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) { //Selection 1 JOUEUR
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2-50,60,20);
        				StdDraw.text(X_MAX/4,Y_MAX/2-52,"1 JOUEUR");
        			
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2-50,60,20);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2-52,"2 JOUEURS");
        				StdDraw.show();}
    		        
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) { //Selection 2 JOUEURS
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2-50,60,20);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2-52,"2 JOUEURS");
        				
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2-50,60,20);
        				StdDraw.text(X_MAX/4,Y_MAX/2-52,"1 JOUEUR");
        				StdDraw.show();}
    		         
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {bool1 = true;
    		        	menuTheme.Stop();
    		        	Niveau.Graphique();} // Detection choix mode de jeu
    			} }     	
        
        	}
        }
	
}