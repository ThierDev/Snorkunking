import java.awt.event.KeyEvent;
import java.util.Random;
import edu.princeton.cs.introcs.StdDraw;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Scanner;

public class Niveau extends Main{

	public int index;
	public final static int X_MAX=120;
	public final static int Y_MAX=120;
	public final static double WIDTH=0.5f;
	
	public static void Graphique() throws Exception {	
		
	    final int FPS= 1000;
	    final int NB_JOUEURS = 4;
        double deltaX=0;
        double deltaY=0;
        double deltaZ=1;
		int spawn1=0;
		int compteurbouteille = 0;
		
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
		
        while(true){	
        	
		StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");

        StdDraw.setPenColor(StdDraw.RED);
        
		for (int i = 0; i < niveauxC3; i++) {
			StdDraw.rectangle(X_MAX/2,(2+4*i),58,1.5);
		}
		
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
		
        for (int i = 0; i < niveauxC2; i++) {
			StdDraw.rectangle(X_MAX/2,(6+4*niveauxC3+4*i),58,1.5);
        }
        
        StdDraw.setPenColor(StdDraw.YELLOW);
        
        for (int i = 0; i < niveauxC1; i++) {
			StdDraw.rectangle(X_MAX/2,(10+4*niveauxC3+4*niveauxC2+4*i),58,1.5);
        }
		StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.rectangle(X_MAX/2,(10+4*niveauxC3+4*niveauxC2+4*niveauxC1),58,1.5);
        
        

        if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN)) {
            deltaY= deltaY+4;
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_UP)) {
            deltaY= deltaY-4;
        }
		
        if (deltaY<=0) deltaY = 0 ;
        if (deltaY>(8+4*niveauxC3+4*niveauxC2+4*niveauxC1)) deltaY = 8+4*niveauxC3+4*niveauxC2+4*niveauxC1 ;        
        
		StdDraw.setPenColor(StdDraw.RED);
		double h1 = 10+4*niveauxC3+4*niveauxC2+4*niveauxC1;
		

		
		if (compteurbouteille<1) {
		for (int i = Y_MAX; i> 20; i--) {
		
		StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");
	    StdDraw.picture(X_MAX/2, i,"bouteille.png",20,20);
	    	if (i<= 25) {StdDraw.picture(X_MAX/2, i,"explosion.gif");
	    	StdDraw.show(20); 
	    	StdDraw.picture(X_MAX/2, Y_MAX/2,"ocean.jpg");
	    	StdDraw.picture(X_MAX/2, Y_MAX/2,"explosion.gif", 100, 100);	    	
	    	StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 120, 100); }
	    	StdDraw.show(30);}
    		StdDraw.picture(X_MAX/2, Y_MAX/2,"SnorkUnkingLogo.png", 120, 100);
    		Sound.launchMusic();
			StdDraw.show(3000);}
		
	    while (spawn1<4 || spawn1>116) {
	    spawn1 = randomGenerator.nextInt(9); }
        StdDraw.picture(spawn1, h1-deltaY,"plongeur.png",50,20);
        
        compteurbouteille++;
        
        StdDraw.show(120);
        
        	}
        }
}

     