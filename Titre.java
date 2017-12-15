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
	public final static int X_MAX=120;
	public final static int Y_MAX=120;
	public final static double WIDTH=0.5f;
	

	
	public static void Launch() throws Exception {	
		
		int compteurlancement = 0;
		Boolean bool1 = false;
		
		Font FontSelctionTitre = new Font("Arial", Font.BOLD, 40);
		
	    Random randomGenerator = new Random();
	    int niveauxC1 = 0;
	    int niveauxC2 = 0;
	    int niveauxC3 = 0;
	    niveauxC1 = 9+randomGenerator.nextInt(12-9);
	    niveauxC2 = 6+randomGenerator.nextInt(9-6);
	    niveauxC3 = 3+ randomGenerator.nextInt(6-3);
		System.out.println(niveauxC1);
		System.out.println(niveauxC2);
		System.out.println(niveauxC3);
		
		StdDraw.setCanvasSize(720,720);
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
        AudioInputStream in = AudioSystem.getAudioInputStream(new File("GuileTheme.wav"));
        Sound2 menuTheme = new Sound2("GuileTheme.wav");
        
        while(true){	

    		if (compteurlancement<1) {
    			for (int i = Y_MAX; i> 20; i=i-2) { //Chute de la bouteille
    			
    			StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg"); 
    		    StdDraw.picture(X_MAX/2, i,"bouteille.png",20,20);
    		    
    		    	if (i<= 25) {StdDraw.picture(X_MAX/2, i,"explosion.gif");
    		    	StdDraw.show(20); 
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 100, 100);	
    		    	StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 120, 100); }
    		    	StdDraw.show(30);}
    				
    				menuTheme.PlaySoundC(); // Logo + Musique + Explosion
    		        
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 120, 100);
    				StdDraw.show(3000);
    				
    				StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");  // Ecran titre
    				StdDraw.setPenColor(StdDraw.WHITE);
    				StdDraw.setFont(FontSelctionTitre);
    				StdDraw.rectangle(X_MAX/4,Y_MAX/2,20,10);
    				StdDraw.text(X_MAX/4,Y_MAX/2,"1 JOUEUR");
    				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2,20,10);
    				StdDraw.text(3*X_MAX/4,Y_MAX/2,"2 JOUEUR");
    				StdDraw.show(100);
    				
    				while(bool1 == false) {
    				
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2,20,10);
        				StdDraw.text(X_MAX/4,Y_MAX/2,"1 JOUEUR");
        			
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2,20,10);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2,"2 JOUEUR");
        				StdDraw.show();}
    		        
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
        				StdDraw.setFont(FontSelctionTitre);
    		        	StdDraw.setPenColor(StdDraw.RED);
        				StdDraw.rectangle(3*X_MAX/4,Y_MAX/2,20,10);
        				StdDraw.text(3*X_MAX/4,Y_MAX/2,"2 JOUEUR");
        				
        				StdDraw.setPenColor(StdDraw.WHITE);
        				StdDraw.rectangle(X_MAX/4,Y_MAX/2,20,10);
        				StdDraw.text(X_MAX/4,Y_MAX/2,"1 JOUEUR");
        				StdDraw.show();}
    		        
    		        if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {bool1 = true;
    		        
    		        	Niveau.Graphique();
    		     
    		        }
    			} }     	
        
        	}
        }
	
}

     