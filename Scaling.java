import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import edu.princeton.cs.introcs.StdDraw;


public class Scaling{
//public class Displaytest{ // je vais changer le nom de cette classe en scaling après.
	/*public final static int X_MAX=16;
	public final static int Y_MAX=9;
	public final static float WIDTH=0.5f;*/

	public static void main(String[]args) throws Exception{
		
		
	

		
		/*StdDraw.setCanvasSize((int) ,(int) scalingFactorHeight*720/2);
		StdDraw.setXscale(-WIDTH,X_MAX+WIDTH);
		StdDraw.setYscale(-WIDTH,Y_MAX+WIDTH);
		for(int y=Y_MAX;y>=0;--y){
				for(int x=0;x<=X_MAX;++x){

					StdDraw.clear(StdDraw.BLUE);
					
					StdDraw.setPenColor(StdDraw.RED);
					
					StdDraw.filledCircle(x,y,WIDTH);
					
					StdDraw.show(500); 

				}
		} */

	}
	public static int[] screenResolution() {
		// Classe qui récupère les infos de l'ordi
		//import java.awt.GraphicsDevice;
		//import java.awt.GraphicsEnvironment;
		int[] wh;
		wh = new int[2];
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		wh[0] = gd.getDisplayMode().getWidth(); // width resolution 
		wh[1] = gd.getDisplayMode().getHeight();//length resolution
		
		return wh;
				
	}
	public static String aspectRatio(int w,int h) {
		
		
		if (w/h == 16/9) {
			
			return "16x9";
		}
		else if (w/h == 3/2) {
			return "3x2";
			
		}
		else if(w/h == 4/3) {
			return "4x3";
		}
		else {return "UnssuportedAspectRatio";}
		
		
		
	}
	public static double[] scalingFactor(){
		
		int width=screenResolution()[0];
		int height = screenResolution()[1];
		
		double[] scalingWH = new double[2];
		
		if(aspectRatio(width,height).equals("16x9")) {
			
			// The game original resolution is 1280/720 (we decided this) we will scale for other resolution accordingly.
			scalingWH[0] = ((double) width/1280); // la moitié de la résolution 
			scalingWH[1] = ((double) height/720);
			
			
			return scalingWH;
			
		}
		
		else {
			scalingWH[0]=1; scalingWH[1]=1;
			return scalingWH;
		} 
		
		
	}
}