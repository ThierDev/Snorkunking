import java.awt.Font;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Main extends Scaling{
	public boolean activScaling=true;
	public static double SW = Scaling.scalingFactor()[0];
	public static double SH = Scaling.scalingFactor()[1];
	
	public static int X_MAX=(int)(640*SW);
	public static int Y_MAX=(int)(360*SH);
	public static double WIDTH=0.5f;
	
	public static int debug1 = 1;
	
	static Random randomGenerator = new Random();
	public static int niveauxC1 = 9 + randomGenerator.nextInt(12-9);
	public static int niveauxC2 = 6 + randomGenerator.nextInt(9-6);
	public static int niveauxC3 = 3+ randomGenerator.nextInt(6-3);
	
	public static void main(String[] args) 
		throws Exception {
		
		
		StdDraw.setCanvasSize((int)(1280*SW),(int)(720*SH));
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
		//Titre.Launch();
		
		Partie.createNiveau();
		Partie.DispDeplacement();
		
	}
}