import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.List;

import edu.princeton.cs.introcs.StdDraw;


public class Scaling{
	
	public static int[] screenResolution() {
		// Classe qui récupère les infos de l'ordi
		//import java.awt.GraphicsDevice;
		//import java.awt.GraphicsEnvironment;
		int[] wh;
		wh = new int[2];
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		wh[0] = gd.getDisplayMode().getWidth(); // width resolution 
		wh[1] = gd.getDisplayMode().getHeight();//length resolution
		//System.out.println(wh[0]);
		
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
			scalingWH[0] = 1;//(((double) width/1280)/1); // la moitié de la résolution 
			scalingWH[1] = 1;//(((double) height/720)/1.1);
			
			//System.out.println(scalingWH[0]);
			return scalingWH;
			
		}
		
		else {
			scalingWH[0]=1; scalingWH[1]=1;
			return scalingWH;
		} 
		
		
	}

public static void printList(double[] list) {
	for (int d=0; d<list.length;d++) {
		if (d==list.length) {
			System.out.println(list[d]);
		}
		System.out.println(list[d]);
	}
}
}