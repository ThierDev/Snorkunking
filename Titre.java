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
        AudioInputStream in = AudioSystem.getAudioInputStream(new File("GuileTheme.wav"));
        Sound2 menuTheme = new Sound2("GuileTheme.wav");
        
        while(true){	

    		if (compteurlancement<1) {
    			for (int i = Y_MAX; i> 20; i=i-4) { //Chute de la bouteille
    			
    			StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg"); 
    		    StdDraw.picture(X_MAX/2, i,"bouteille.png",30,30);
    		    
    		    	if (i<= 25) {StdDraw.picture(X_MAX/2, i,"explosion.gif");

    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 500, 500);	
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 320, 240); }
    		    	StdDraw.show(20);}
    				
    				menuTheme.PlaySoundC(); // Logo + Musique + Explosion
    		    	
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 500, 500);
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 320, 240);
    				StdDraw.show(3000);
    				
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");  // Ecran titre
    				StdDraw.setPenColor(StdDraw.WHITE);
    				StdDraw.setFont(FontSelctionTitre);
    				StdDraw.rectangle(X_MAX/4,Y_MAX/2,55,20);
    				StdDraw.text(X_MAX/4,Y_MAX/2-2,"1 JOUEUR");
    				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2,55,20);
    				StdDraw.text(3*X_MAX/4,Y_MAX/2-2,"2 JOUEUR");
    				StdDraw.show(100);
    				
    				while(bool1 == false) {
    				
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2,55,20);
        				StdDraw.text(X_MAX/4,Y_MAX/2-2,"1 JOUEUR");
        			
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2,55,20);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2-2,"2 JOUEUR");
        				StdDraw.show();}
    		        
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2,55,20);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2-2,"2 JOUEUR");
        				
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2,55,20);
        				StdDraw.text(X_MAX/4,Y_MAX/2-2,"1 JOUEUR");
        				StdDraw.show();}
    		        
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {bool1 = true;
    		        
    		        	Niveau.Graphique();
    		     
    		        }
    			} }     	
        
        	}
        }
	
}