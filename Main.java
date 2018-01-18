import java.awt.Font;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Main extends Scaling{
	
	public static boolean IAStatus = false;
	
	public boolean activScaling=true;
	public static double SW = Scaling.scalingFactor()[0];
	public static double SH = Scaling.scalingFactor()[1];
	
	public static int X_MAX=(int)(640*SW);
	public static int Y_MAX=(int)(360*SH);
	public static double WIDTH=0.5f;
	
	public static int debug1 = 1;
	
	public static Titre titre;
	
	
	
	public static void main(String[] args) 
		throws Exception {
		
		
		StdDraw.setCanvasSize((int)(1280*SW),(int)(720*SH));
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
		
		titre = new Titre(true);
		Partie.createNiveau();
		Partie.DispDeplacement();
		
		
	}
	
}